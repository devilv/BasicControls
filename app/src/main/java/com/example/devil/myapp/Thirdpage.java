package com.example.devil.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by devil on 10/19/2016.
 */

public class Thirdpage extends Activity {
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdpage);
        l=(ListView)findViewById(R.id.listview);
        String[] data={"rohit","varun","rahul","somesh"};
        ArrayAdapter<String> a=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,data);
        l.setAdapter(a);
        l.setSelector(android.R.color.darker_gray);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                String s=arg0.getItemAtPosition(arg2).toString();
                if(arg2==3){
                    Intent i =new Intent(Thirdpage.this,Fourthpage.class);
                    i.putExtra("key1",s);
                    Toast toast=Toast.makeText(Thirdpage.this,s, Toast.LENGTH_SHORT);
                    toast.show();
                    startActivity(i);
                }
                else{
                    Toast toast=Toast.makeText(Thirdpage.this,"wrong selection", Toast.LENGTH_SHORT);
                    toast.show();
                    finish();
                }
            }
        });

    }
}


