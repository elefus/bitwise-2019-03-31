package com.epam.practice.bio;

import java.util.Objects;

public class Section {

    // TODO implement this class
    String section;

    @Override
    public String toString() {
        return section;
    }

    @Override
    public int hashCode() {
        return section.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return this == other
            || other != null && getClass() == other.getClass()
            && Objects.equals(this.toString(), other.toString());
    }
}
