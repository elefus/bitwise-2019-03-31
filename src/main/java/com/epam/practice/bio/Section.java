package com.epam.practice.bio;

import java.util.Objects;

public class Section {

    // TODO implement this class

    @Override
    public boolean equals(Object other) {
        return this == other
            || other instanceof Section
            && Objects.equals(this.toString(), other.toString());
    }
}
