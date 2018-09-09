package com.solo.myapplication.utily;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by solo on 2018/9/8.
 */

public class MD5Utily {
    public  static  String md5(String text)
    {
        MessageDigest digest=null;
        try {
            digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(text.getBytes());
            StringBuilder sb=new StringBuilder();
            for (byte b : result)
            {
                int number=b&0xff;
                String hex= Integer.toHexString(number);
                if(hex.length()==1)
                {
                    sb.append("0"+hex);
                }
                else
                {
                    sb.append(hex);
                }
         }
return  sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return  "";
        }
    }
}
