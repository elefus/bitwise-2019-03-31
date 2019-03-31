package com.epam.practice.mask;

import java.util.NoSuchElementException;

public class PermissionsImpl implements Permissions{
     static Permissions getDef_guest(){
        Permissions permissions = new PermissionsImpl();
        permissions.roots.add(Permission.VIEW_ARTICLE);
        permissions.roots.add(Permission.VIEW_PRODUCT);
    return permissions;
    }
    static Permissions getDef_editor(){
        Permissions permissions = new PermissionsImpl();
        permissions.roots.add(Permission.VIEW_ARTICLE);
        permissions.roots.add(Permission.VIEW_PRODUCT);
        permissions.roots.add(Permission.EDIT_ARTICLE);
        permissions.roots.add(Permission.EDIT_PRODUCT);
        return permissions;
    }
    static Permissions getDef_admin(){
        Permissions permissions = new PermissionsImpl();
        permissions.roots.add(Permission.VIEW_ARTICLE);
        permissions.roots.add(Permission.VIEW_PRODUCT);
        permissions.roots.add(Permission.EDIT_ARTICLE);
        permissions.roots.add(Permission.EDIT_PRODUCT);
        permissions.roots.add(Permission.CHANGE_PERMISSIONS);
        return permissions;
    }

    @Override
    public void add(Permission... permissions) throws SecurityException {

    }

    @Override
    public void remove(Permission... permissions) throws NoSuchElementException {

    }

    @Override
    public boolean has(Permission permission, Permission... other) {
       return false;
    }

    @Override
    public void merge(Permissions other) throws IllegalArgumentException {

    }
}
