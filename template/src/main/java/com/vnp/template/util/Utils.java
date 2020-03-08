package com.vnp.template.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.codec.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    private static Utils instance = new Utils();

    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }
    private static String mobileNoPattern = null;

    public String generateUnique() {
        String guid = UUID.randomUUID().toString();
        guid = guid.replace("-", "");
        return guid;
    }
    public boolean isEmptyStr(String str) {
        return str == null || "".equals(str);
    }

    public boolean isMobileNo(String phoneNumber) {
        if (mobileNoPattern == null) {
            mobileNoPattern = "^(098)[0-9]\\d{6}$|^(097)[0-9]\\d{6}$|^(096)[0-9]\\d{6}$|^(097)[0-9]\\d{6}$|^(016)[2-9]\\d{7}$|^(086)[0-9]\\d{6}$|"
                    + "(090)[0-9]\\d{6}$|^(093)[0-9]\\d{6}$|^(0120)\\d{7}$|^(0121)\\d{7}$|^(0122)\\d{7}$|^(0126)\\d{7}$|^(0128)\\d{7}$|^(089)[0-9]\\d{6}$|"
                    + "(091)[0-9]\\d{6}$|^(094)[0-9]\\d{6}$|^(0123)\\d{7}$|^(0124)\\d{7}$|^(0125)\\d{7}$|^(0127)\\d{7}$|^(0129)\\d{7}$|^(088)[0-9]\\d{6}$|"
                    + "(092)[0-9]\\d{6}$|^(0188)[0-9]\\d{6}$|^(0186)[0-9]\\d{6}$|"
                    + "(099)[3-7]\\d{6}$|^(0199)[2389]\\d{6}$";
        }

        return phoneNumber.matches(mobileNoPattern);

    }

    public String getMd5(String password) {
        try {
            MessageDigest algorithm;

            byte[] passBytes = password.getBytes();

            //md5 algorithm
            algorithm = MessageDigest.getInstance("MD5");

            algorithm.reset();
            algorithm.update(passBytes);
            byte messageDigest[] = algorithm.digest();

            //get hexa format
            return (new String(Hex.encode(messageDigest))).toUpperCase();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }

        return "";
    }

}
