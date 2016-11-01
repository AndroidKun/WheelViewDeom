package com.androidkun.wheelviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.androidkun.wheelviewlibrary.bean.TypeBean;
import com.androidkun.wheelviewlibrary.utils.WheelViewUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show(View view){
        final ArrayList<TypeBean> mList = new java.util.ArrayList<TypeBean>();
        mList.add(new TypeBean(0,"北京"));
        mList.add(new TypeBean(1,"上海"));
        mList.add(new TypeBean(2,"深圳"));
        mList.add(new TypeBean(3,"广州"));
        mList.add(new TypeBean(4,"珠海"));
        mList.add(new TypeBean(5,"厦门"));
        mList.add(new TypeBean(6,"汕头"));
        mList.add(new TypeBean(7,"杭州"));

        final ArrayList<MyTypeBean> myList = new java.util.ArrayList<MyTypeBean>();
        for(int i = 0;i<10;i++){
            myList.add(new MyTypeBean(0,2000+i));
        }
        WheelViewUtil.alertBottomWheelOption(this, myList, new WheelViewUtil.OnWheelViewClick() {
            @Override
            public void onClick(View view, int postion) {
                Toast.makeText(MainActivity.this,myList.get(postion).getYear()+"",Toast.LENGTH_SHORT).show();
            }
        });
    }


    public class MyTypeBean{
        int id;
        int year;

        public MyTypeBean(int id, int year) {
            this.id = id;
            this.year = year;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        //这个用来显示在PickerView上面的字符串,PickerView会通过反射获取getPickerViewText方法显示出来。
        public String getPickerViewText() {
            return year+"";
        }
    }
}
