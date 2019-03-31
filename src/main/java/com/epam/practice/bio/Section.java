package com.epam.practice.bio;

import java.util.Objects;

public class Section {

    // TODO implement this class
    String section;

    public Section(String section) {
        this.section = section;
    }

    public Section() {
    }

    public String getSection() {
        return section;
    }

    @Override
    public int hashCode() {
        return section != null ? section.hashCode() : 0;
    }

    @Override
    public boolean equals(Object other) {
        return this == other
            || other != null && getClass() == other.getClass()
            && Objects.equals(this.toString(), other.toString());
    }
}
