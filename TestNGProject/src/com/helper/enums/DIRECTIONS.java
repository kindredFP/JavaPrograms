package com.helper.enums;

public enum DIRECTIONS {
    UP("up"), DOWN("down"), LEFT("left"), RIGHT("right");

    private final String classReference;

    DIRECTIONS(String classReference) {
        this.classReference = classReference;
    }

    public String getClassReference() {
        return this.classReference;
    }

}
