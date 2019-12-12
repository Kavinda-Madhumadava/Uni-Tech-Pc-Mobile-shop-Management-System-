/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.Controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author kavinda
 */
public class Encryption {

    public static String Encrypt(String id) {

        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            byte[] digest = instance.digest(id.getBytes());
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                buffer.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
            }
            return buffer.toString();

        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

}
