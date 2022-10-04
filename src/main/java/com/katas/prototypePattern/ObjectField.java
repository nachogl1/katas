package com.katas.prototypePattern;

public class ObjectField implements Prototype {
    int intField;
    String stringField;

    public ObjectField(int intField, String stringField) {
        this.intField = intField;
        this.stringField = stringField;
    }

    private ObjectField(ObjectField objectField) {
        this.intField = objectField.intField;
        this.stringField = objectField.stringField;
    }

    @Override
    public Prototype makeCopy() {
        return new ObjectField(this);
    }


}
