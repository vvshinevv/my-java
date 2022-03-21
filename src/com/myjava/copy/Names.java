package com.myjava.copy;

import java.util.ArrayList;
import java.util.List;

public class Names {
    private List<Name> names;

    public Names(List<Name> names) {
        this.names = new ArrayList<>(names);
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Name name : names) {
            result.append(name.getIdx());
            result.append("-");
            result.append(name.getName());
            result.append(", ");
        }
        return result.toString();
    }
}
