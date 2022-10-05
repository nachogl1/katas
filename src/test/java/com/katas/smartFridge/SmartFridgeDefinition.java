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
//        fridge.signalFridgeDoorOpened();

        fridge.addItem(getFridgeItemBuilder().setBarcode("1").setName("Milk").setExpiryDate(LocalDateTime.of(2021, 10, 20, 21, 00)).setState(SEALED).build());
        fridge.addItem(getFridgeItemBuilder().setBarcode("2").setName("Cheese").setExpiryDate(LocalDateTime.of(2021, 10, 18, 21, 00)).setState(SEALED).build());
        fridge.addItem(getFridgeItemBuilder().setBarcode("3").setName("Beef").setExpiryDate(LocalDateTime.of(2021, 10, 20, 21, 00)).setState(SEALED).build());
        fridge.addItem(getFridgeItemBuilder().setBarcode("4").setName("Lettuce").setExpiryDate(LocalDateTime.of(2021, 10, 22, 21, 00)).setState(SEALED).build());
        //fridge.signalFridgeDoorClosed();

        simulateDayOver();

        //fridge.signalFridgeDoorOpened();
        //fridge.signalFridgeDoorClosed();

        //fridge.signalFridgeDoorOpened();
        //fridge.signalFridgeDoorClosed();

        //fridge.signalFridgeDoorOpened();
        fridge.scanRemovedItem("1");
        //fridge.signalFridgeDoorClosed();

        //fridge.signalFridgeDoorOpened();


        fridge.addItem(getFridgeItemBuilder().setBarcode("5").setName("Milk").setExpiryDate(LocalDateTime.of(2021, 10, 26, 21, 00)).setState(OPENED).build());
        fridge.addItem(getFridgeItemBuilder().setBarcode("6").setName("Peppers").setExpiryDate(LocalDateTime.of(2021, 10, 23, 21, 00)).setState(OPENED).build());
        //fridge.signalFridgeDoorClosed();

        simulateDayOver();

        //fridge.signalFridgeDoorOpened();
        fridge.scanRemovedItem("3");
        fridge.scanRemovedItem("4");
        //fridge.signalFridgeDoorClosed();
        //fridge.signalFridgeDoorOpened();
        fridge.addItem(getFridgeItemBuilder().setBarcode("7").setName("Lettuce").setExpiryDate(LocalDateTime.of(2021, 10, 22, 21, 00)).setState(OPENED).build());
        //fridge.signalFridgeDoorClosed();

        //fridge.signalFridgeDoorOpened();
        //fridge.signalFridgeDoorClosed();

        simulateDayOver();
    }


    @Then("the system displays the food that is left and their details correctly")
    public void theSystemDisplaysTheFoodThatIsLeftAndTheirDetailsCorrectly() {

        String message = """
                EXPIRED: Cheese
                Milk: 5 days remaining
                Peppers: 2 days remaining
                Lettuce: 1 days remaining
                """;

        fridge.showDisplay();

        verify(consoleMock).print(message);
    }

    private void simulateDayOver() {
        LocalDateTime currentTime = clockMock.getCurrentMoment();
        when(clockMock.getCurrentMoment()).thenReturn(currentTime.plusDays(1));
    }

}
