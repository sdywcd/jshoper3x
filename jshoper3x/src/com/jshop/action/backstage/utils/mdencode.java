package com.jshop.action.backstage.utils;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */

public class mdencode {
    public mdencode() {
    }

    public String testDigest(String myinfo) {
        byte[] digesta = null;
        try {
            java.security.MessageDigest alga = java.security.MessageDigest.
                    getInstance("MD5");
            alga.update(myinfo.getBytes());
            digesta = alga.digest();

        }
        catch (java.security.NoSuchAlgorithmException ex) {
            System.out.println("�Ƿ�ժҪ�㷨");
        }
        return this.byte2hex(digesta);
    }

    public String byte2hex(byte[] b) { //������ת�ַ�
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
            if (n < b.length - 1) {
                hs = hs;
            }
        }
        return hs;
    }

}