package com.skeye.yagout.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtils {
 
    public static byte[] serialize(Object o) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ObjectOutputStream outo = new ObjectOutputStream(out);
            outo.writeObject(o);
        } catch (Exception e) {
        return  null;

        }
 
        return out.toByteArray();
    }
 
    public static Object deserialize(byte[] b) {
        ObjectInputStream oin;
        try {
            oin = new ObjectInputStream(new ByteArrayInputStream(b));
            return oin.readObject();
        } catch (Exception e) {
            return  null;

        }
 
    }
}
