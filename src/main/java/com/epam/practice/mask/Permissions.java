package com.epam.practice.mask;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public interface Permissions {



    static Permissions getDefault(Type type) {
        try {if (type.equals(Type.GUEST))
            return PermissionsImpl.getDef_guest();
            if (type.equals(Type.EDITOR))
                return PermissionsImpl.getDef_editor();
            if (type.equals(Type.ADMIN))
                return PermissionsImpl.getDef_admin();

        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
        throw new UnsupportedOperationException();
    }

    void add(Permission... permissions) throws SecurityException
    ;

    void remove(Permission... permissions) throws NoSuchElementException;

    boolean has(Permission permission, Permission... other);

    /**
     * @param other permissions that need to be added.
     * @throws IllegalArgumentException mismatch types of current and other permissions.
     */
    void merge(Permissions other) throws IllegalArgumentException;


    enum Type {
        GUEST,
        EDITOR,
        ADMIN
    }
    List<Permission> roots = new ArrayList<>();
}
