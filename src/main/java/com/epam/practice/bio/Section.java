package com.epam.practice.bio;

import lombok.EqualsAndHashCode;

import java.util.Objects;


public class Section {
    public String section;
    Section(String s){
        this.section = s;
    }

    @Override
    public String toString() {
        return section;
    }


    @Override
    public boolean equals(Object other) {
        return this == other
            || other != null && getClass() == other.getClass()
            && Objects.equals(this.toString(), other.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(section);
    }
}
