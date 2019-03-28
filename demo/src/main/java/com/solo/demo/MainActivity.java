package com.solo.demo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setView(R.layout.dialoglayout).create().show();
        /* setContentView(R.layout.activity_main);
        AlertDialog dialog;                           //声明对象
    dialog = new AlertDialog.Builder(this)        //绑定当前界面窗口
             .setTitle("Dialog对话框")             //设置标题
              .setMessage("是否确定退出？")         //设置提示信息
              .setIcon(R.mipmap.ic_launcher)       //设置图标
               .setPositiveButton("确定", null)     //添加“确定”按钮
               .setNegativeButton("取消", null)     //添加“取消”按钮
         .create();                          //创建对话框
       dialog.show();                              //显示对话框*/
    }

}
class Mydialog extends Dialog{

    public Mydialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialoglayout);
    }
}