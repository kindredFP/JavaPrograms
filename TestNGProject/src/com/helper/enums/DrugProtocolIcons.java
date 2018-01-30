package com.helper.enums;

public enum DrugProtocolIcons {
    ALLERGY("text"), DOSE_CHECK("text2"), DRUG_INTERACTION("text3"), BLACK_BOX("text4");

    private final String classReference;

    DrugProtocolIcons(String classReference) {
        this.classReference = classReference;
    }

    public String getClassReference() {
        return this.classReference;
    }

}
