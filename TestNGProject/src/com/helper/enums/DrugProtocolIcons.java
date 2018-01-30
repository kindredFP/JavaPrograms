package com.helper.enums;

public enum DrugProtocolIcons {
    Allergy("text"), DoseCheck("text2"), DrugInteraction("text3"), BlackBox("text4");

    private final String classReference;

    DrugProtocolIcons(String classReference) {
        this.classReference = classReference;
    }

    public String getClassReference() {
        return this.classReference;
    }

}
