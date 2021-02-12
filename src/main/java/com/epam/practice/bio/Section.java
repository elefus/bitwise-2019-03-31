package com.epam.practice.bio;

import java.util.Objects;

public class Section {

    private String subString;

    public Section() {

    }

    public Section(String subString) {
        this.subString = subString;
    }

    @Override
    public String toString() {
        return subString;
    }

    @Override
    public boolean equals(Object other) {
        return this == other
            || other instanceof Section
            && Objects.equals(this.toString(), other.toString());
    }

    @Override
    public int hashCode() {
        return subString.hashCode();
    }
}
