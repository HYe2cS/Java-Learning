package aes;

import java.io.*;
import java.security.*;
import javax.crypto.*;

/**
 * This program tests the AES cipher. Usage:<br>
 * java aes.AESTest -genkey keyfile<br>
 * java aes.AESTest -encrypt plaintext encrypted keyfile<br>
 * java aes.AESTest -decrypt encrypted decrypted keyfile<br>
 *
 * @author Cay Horstmann
 * @version 1.02 2018-05-01
 */
public class AESTest {
    public static void main(String[] args)
            throws IOException, GeneralSecurityException, ClassNotFoundException {
        if ("-genkey".equals(args[0])) {
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            var random = new SecureRandom();
            keygen.init(random);
            SecretKey key = keygen.generateKey();
            try (var out = new ObjectOutputStream(new FileOutputStream(args[1]))) {
                out.writeObject(key);
            }
        } else {
            int mode;
            if ("-encrypt".equals(args[0])) {
                mode = Cipher.ENCRYPT_MODE;
            } else {
                mode = Cipher.DECRYPT_MODE;
            }
            
            try (var keyIn = new ObjectInputStream(new FileInputStream(args[3]));
                 var in = new FileInputStream(args[1]);
                 var out = new FileOutputStream(args[2])) {
                var key = (Key) keyIn.readObject();
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(mode, key);
                Util.crypt(in, out, cipher);
            }
        }
    }
}

