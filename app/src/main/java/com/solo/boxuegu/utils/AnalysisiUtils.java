package com.solo.boxuegu.utils;

import android.content.Context;
import android.content.SharedPreferences;


public class AnalysisiUtils {
    /**
     * 从SHaredPreference 中读取登录信息
     */

  public static String  readLoginUserName(Context context){
        SharedPreferences sp=context.getSharedPreferences("loginInfo",Context.MODE_PRIVATE);
        String userName=sp.getString("loginUserName","");
        return userName;
    }
}
