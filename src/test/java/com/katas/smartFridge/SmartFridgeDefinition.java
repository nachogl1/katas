package com.katas.smartFridge;

import com.katas.smartFridge.adapters.FridgeConsole;
import com.katas.smartFridge.adapters.InMemItemStorage;
import com.katas.smartFridge.adapters.PrototypeClockDevice;
import com.katas.smartFridge.core.entities.SmartFridge;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;

import static com.katas.smartFridge.core.entities.FridgeItemBuilder.getFridgeItemBuilder;
import static com.katas.smartFridge.core.entities.FridgeItemState.OPENED;
import static com.katas.smartFridge.core.entities.FridgeItemState.SEALED;
import static org.mockito.Mockito.*;

public class SmartFridgeDefinition {
    FridgeConsole consoleMock = mock(FridgeConsole.class);
    InMemItemStorage storage = new InMemItemStorage();
    PrototypeClockDevice clockMock = mock(PrototypeClockDevice.class);
    SmartFridge fridge;

    @Given("a fixed date for the fridge current date is set")
    public void fixedDateForTheFridgeCurrentDateIsSet() {
        when(clockMock.getCurrentMoment()).thenReturn(LocalDateTime.of(2021, 10, 18, 21, 00));
        this.fridge = new SmartFridge(consoleMock, storage, clockMock);
    }


    @When("a predefined series of steps of interactions are carried out")
    public void predefinedSeriesOfStepsOfInteractionsAreCarriedOut() {
        fridge.signalFridgeDoorOpened();
        fridge.scanAddedItem(getFridgeItemBuilder().setBarcode("1").setName("Milk").setExpiryDate("20/10/2021").setState(SEALED).build());
        fridge.scanAddedItem(getFridgeItemBuilder().setBarcode("2").setName("Cheese").setExpiryDate("18/11/21").setState(SEALED).build());
        fridge.scanAddedItem(getFridgeItemBuilder().setBarcode("3").setName("Beef").setExpiryDate("20/10/21").setState(SEALED).build());
        fridge.scanAddedItem(getFridgeItemBuilder().setBarcode("4").setName("Lettuce").setExpiryDate("22/10/21").setState(SEALED).build());
        fridge.signalFridgeDoorClosed();

        clockMock.simulateDayOver();

        fridge.signalFridgeDoorOpened();
        fridge.signalFridgeDoorClosed();

        fridge.signalFridgeDoorOpened();
        fridge.signalFridgeDoorClosed();

        fridge.signalFridgeDoorOpened();
        fridge.scanRemovedItem("1");
        fridge.signalFridgeDoorClosed();

        fridge.signalFridgeDoorOpened();
        fridge.scanAddedItem(getFridgeItemBuilder().setBarcode("5").setName("Milk").setExpiryDate("26/10/21").setState(OPENED).build());
        fridge.scanAddedItem(getFridgeItemBuilder().setBarcode("6").setName("Peppers").setExpiryDate("23/10/21").setState(OPENED).build());
        fridge.signalFridgeDoorClosed();

        clockMock.simulateDayOver();

        fridge.signalFridgeDoorOpened();
        fridge.scanRemovedItem("3");
        fridge.scanRemovedItem("4");
        fridge.signalFridgeDoorClosed();

        fridge.signalFridgeDoorOpened();
        fridge.scanAddedItem(getFridgeItemBuilder().setBarcode("7").setName("Lettuce").setExpiryDate("22/10/21").setState(OPENED).build());
        fridge.signalFridgeDoorClosed();

        fridge.signalFridgeDoorOpened();
        fridge.signalFridgeDoorClosed();

        clockMock.simulateDayOver();
    }


    @Then("the system displays the food that is left and their details correctly")
    public void theSystemDisplaysTheFoodThatIsLeftAndTheirDetailsCorrectly() {

        String messageAboutMilk = "EXPIRED: Milk";
        String messageAboutLettuce = "Lettuce: 0 days remaining";
        String messageAboutPeppers = "Peppers: 1 day remaining";
        String messageAboutCheese = " Cheese: 31 days remaining";

        fridge.showDisplay();

        verify(consoleMock).print(messageAboutMilk);
        verify(consoleMock).print(messageAboutLettuce);
        verify(consoleMock).print(messageAboutPeppers);
        verify(consoleMock).print(messageAboutCheese);
    }

}
