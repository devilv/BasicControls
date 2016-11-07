package com.example.devil.myapp;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by devil on 10/19/2016.
 */

public class Fourthpage extends Activity {

    ImageView imageview;
    Button button;
    InputStream is;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourthpage);
        TextView textView = (TextView) findViewById(R.id.txt1);
        Intent i = getIntent();
        String s = i.getStringExtra("key1");
        textView.setText(s);
        Button button1 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent i = new Intent("ducatee");
                startActivity(i);

            }
        });
        imageview= (ImageView)findViewById(R.id.imageView);
        button= (Button)findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image/*");
                startActivityForResult(i, 40);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==40 && resultCode==-1 && data!=null);
        {
            Uri uri=data.getData();
            ContentResolver cr= getContentResolver();

            try {
                is=cr.openInputStream(uri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Bitmap b=BitmapFactory.decodeStream(is);
            imageview.setImageBitmap(b);
        }

    }
}



