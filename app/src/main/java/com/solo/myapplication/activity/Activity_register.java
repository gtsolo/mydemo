package com.solo.myapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.solo.myapplication.R;
import com.solo.myapplication.utils.MD5Utils;

public class Activity_register extends AppCompatActivity {

    //标题
    private TextView tv_main_title;
    //返回按钮
    private TextView tv_back;
    //注册按钮
    private Button btn_register;
    //账号、密码、再次输入的密码的控件
    private EditText et_user_name,et_psw,et_psw_again;
    //账号、密码、再次输入的密码的控件的获取值
    private String userName,psw,pswAgain;
    //标题布局
    private RelativeLayout rl_title_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.acitvity_register);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        init();
        super.onCreate(savedInstanceState);
    }

    private void init() {
        tv_main_title= (TextView) findViewById(R.id.tv_main_title);
        tv_main_title.setText("注册");
        tv_back=(TextView) findViewById(R.id.tv_back);
        rl_title_bar=(RelativeLayout) findViewById(R.id.main_title_bar);
        rl_title_bar.setBackgroundColor(Color.TRANSPARENT);
        //从activity_register.xml页面布局中获得对应的UI控件
        btn_register=(Button) findViewById(R.id.btn_register);
        et_user_name=(EditText) findViewById(R.id.ed_name);
        et_psw=(EditText) findViewById(R.id.ed_psw);
        et_psw_again=(EditText) findViewById(R.id.ed_psw_conf);
        tv_main_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity_register.this.finish();
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
                  @Override
                   public void onClick(View v) {
                    getEditString();
                      if(TextUtils.isEmpty(userName))
                      {
                          Toast.makeText(Activity_register.this,"请输入姓名",Toast.LENGTH_LONG).show();
                          return;
                      }else if(TextUtils.isEmpty(psw))
                      {
                          Toast.makeText(Activity_register.this,"请输入密码",Toast.LENGTH_LONG).show();
                          return;
                      }else if(TextUtils.isEmpty(pswAgain))
                      {
                          Toast.makeText(Activity_register.this,"请输入确认密码",Toast.LENGTH_LONG).show();
                          return;
                      }else if(!psw.equals(pswAgain))
                      {
                          Toast.makeText(Activity_register.this,"请输入确认密码",Toast.LENGTH_LONG).show();
                          return;
                      }else if(isExistUsername(userName))
                      {
                          Toast.makeText(Activity_register.this,"此账户已存在",Toast.LENGTH_LONG).show();
                          return;
                      }else{
                          Toast.makeText(Activity_register.this,"注册成功",Toast.LENGTH_LONG).show();
                          saveRegisterName(userName,psw);
                          Intent intent=new Intent();
                          intent.putExtra("userName",userName);
                          setResult(RESULT_OK,intent);
                          Activity_register.this.finish();
                      }


                                            }
                                        }
        );
    }

    private void saveRegisterName(String userName, String psw) {
        String md5psw= MD5Utils.md5(psw);
        SharedPreferences sp=getSharedPreferences("loginInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(userName,md5psw);
        editor.commit();
    }

    private boolean isExistUsername(String userName) {
            boolean has_usename=false;
        SharedPreferences sp =getSharedPreferences("loginInfo",MODE_PRIVATE);
    String psw=sp.getString(userName,"");
        if(!TextUtils.isEmpty(psw))
        {
            has_usename=true;
        }
        return has_usename;
    }

    private void getEditString() {
        userName=et_user_name.getText().toString().trim();
        psw=et_psw.getText().toString().trim();
        pswAgain=et_psw_again.getText().toString().trim();
    }

}
