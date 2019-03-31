package com.epam.practice.bio;

import java.util.Objects;

public class Section {
    int n;
    String content;

    public Section(int n, String content) {
        this.n = n;
        this.content = content;
    }

    public Section() {
    }

    @Override
    public boolean equals(Object other) {
        return this == other
            || other != null && getClass() == other.getClass()
            && Objects.equals(this.toString(), other.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, content);
    }
}
