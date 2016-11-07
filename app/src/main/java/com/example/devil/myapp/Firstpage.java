package com.example.devil.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class Firstpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);
        final EditText editText=(EditText)findViewById(R.id.editText1);
        final EditText editText1=(EditText)findViewById(R.id.editText2);
        Button b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast= Toast.makeText(Firstpage.this,"Welcome",Toast.LENGTH_LONG);
                toast.show();

                Intent i=new Intent(Firstpage.this,Secondpage.class); 
                i.putExtra("key1",editText.getText().toString());
                i.putExtra("key2",editText1.getText().toString());
                startActivity(i);


                           }
        });
    }
}
