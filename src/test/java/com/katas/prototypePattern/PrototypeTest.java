package com.katas.prototypePattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PrototypeTest {

    private Car original;
    private Car cloned;
    private ObjectField objectField;

    @BeforeEach
    void setUp() {
        original = new Car();
        objectField = new ObjectField(9, "This is another String");
        original.setMyOriginalFields(9, "I am a string field", objectField);

        cloned = (Car) original.clone();
    }

    @Test
    void assertDifferentReferences() {
        assertNotEquals(original, cloned);
    }

    @Test
    void assertSameSimpleFieldContent() {
        assertEquals(original.getPrimitiveField_1(), cloned.getPrimitiveField_1());
        assertEquals(original.getStringField_2(), cloned.getStringField_2());
    }

    @Test
    void assertDeepCopy() {

        //Forbid train wreck here (Violating LoD)
        //Check if they are similar but not same on creation
        assertEquals(original.getObjectField().intField, cloned.getObjectField().intField);
        assertEquals(original.getObjectField().stringField, cloned.getObjectField().stringField);
        assertNotEquals(original.getObjectField(), cloned.getObjectField());

        //Now we change original and cloned should stay without changes
        original.setPrimitiveField1(8);
        original.setStringField2("Halo");
        objectField.stringField = "Halo";
        objectField.intField = 8;

        assertEquals(8, original.getPrimitiveField_1());
        assertEquals("Halo", original.getStringField_2());
        assertEquals(8, original.getObjectField().intField);
        assertEquals("Halo", original.getObjectField().stringField);

        assertEquals(9, cloned.getPrimitiveField_1());
        assertEquals("I am a string field", cloned.getStringField_2());
        assertEquals(9, cloned.getObjectField().intField);
        assertEquals("This is another String", cloned.getObjectField().stringField);


    }
}
