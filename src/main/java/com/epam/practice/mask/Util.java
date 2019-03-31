package com.epam.practice.mask;

import java.util.HashMap;
import java.util.Map;

public class Util {
    public static Map<Permissions.Type, Byte> parser;
    static {
        parser.put(Permissions.Type.GUEST, (byte) 0b10100);
        parser.put(Permissions.Type.EDITOR, (byte) 0b11110);
        parser.put(Permissions.Type.ADMIN, (byte) 0b11111);
    }


}
