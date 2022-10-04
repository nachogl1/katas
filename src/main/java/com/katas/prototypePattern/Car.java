package com.katas.prototypePattern;

public class Car implements Prototype {

    private int primitiveField1;
    private String stringField2;
    private ObjectField objectField;

    public Car() {
    }

    private Car(Car carToCopy) {
        this.primitiveField1 = carToCopy.getPrimitiveField_1();
        this.stringField2 = carToCopy.getStringField_2();
        this.objectField = getObjectFieldClone(carToCopy);
    }

    @Override
    public Car clone() {
        return new Car(this);
    }

    public void setMyOriginalFields(int intInput, String stringInput, ObjectField objectField) {
        this.primitiveField1 = intInput;
        this.stringField2 = stringInput;
        this.objectField = objectField;
    }

    public int getPrimitiveField_1() {
        return this.primitiveField1;
    }

    public String getStringField_2() {
        return this.stringField2;
    }

    public ObjectField getObjectField() {
        return this.objectField;
    }

    public void setPrimitiveField1(int primitiveField1) {
        this.primitiveField1 = primitiveField1;
    }

    public void setStringField2(String stringField2) {
        this.stringField2 = stringField2;
    }

    private ObjectField getObjectFieldClone(Car carToCopy) {
        return carToCopy.getObjectField().clone();
    }
}
