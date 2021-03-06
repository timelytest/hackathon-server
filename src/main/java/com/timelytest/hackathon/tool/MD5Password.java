package com.timelytest.hackathon.tool;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Password {
    public  String getMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
