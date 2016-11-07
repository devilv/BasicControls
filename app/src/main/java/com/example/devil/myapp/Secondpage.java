package com.example.devil.myapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by devil on 10/19/2016.
 */
public class Secondpage extends AppCompatActivity {
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondpage);
        TextView textv = (TextView) findViewById(R.id.textView2);
        textv.setText(getIntent().getStringExtra("key1"));
        final EditText editText4 = (EditText) findViewById(R.id.editText4);
        spinner = (Spinner) findViewById(R.id.spinner1);
        String[] data = {"please select", "open browser", "call me", "camera", "settings", "gallery", "messaging", "contacts", "listview"};
        ArrayAdapter<String> a = new ArrayAdapter<String>(Secondpage.this, android.R.layout.simple_spinner_dropdown_item, data);
        spinner.setAdapter(a);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub
                int x = position;
                switch (x) {
                    case (1): {
                        Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                        startActivity(i1);
                        Toast toast = Toast.makeText(Secondpage.this, "open browser", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    }
                    case (2): {
                        Intent i2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + editText4.getText()));
                        if (ActivityCompat.checkSelfPermission(Secondpage.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        startActivity(i2);
                        Toast toast=Toast.makeText(Secondpage.this,"call me", Toast.LENGTH_SHORT );
                        toast.show();
                        break;
                    }

                    case(3):{
                        Intent i3= new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivity(i3);
                        Toast toast=Toast.makeText(Secondpage.this,"camera",  Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    }
                    case(4):{
                        Intent i4= new Intent(android.provider.Settings.ACTION_SETTINGS);
                        startActivity(i4);
                        Toast toast=Toast.makeText(Secondpage.this,"settings",  Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    }
                    case(5):{
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                                "content://media/internal/images/media"));
                        startActivity(intent);

                        Toast toast=Toast.makeText(Secondpage.this,"gallery",  Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    }
                    case(6):{
                        Intent i6 = new Intent(Intent.ACTION_VIEW,Uri.parse("sms:"));
                        startActivity(i6);
                        Toast toast=Toast.makeText(Secondpage.this,"messaging",  Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    }
                    case(7):{
                        Intent i7= new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
                        startActivity(i7);
                        Toast toast=Toast.makeText(Secondpage.this,"contacts",  Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    }
                    case(8):{
                        Intent i8= new Intent(Secondpage.this,Thirdpage.class);
                        startActivity(i8);
                        Toast toast=Toast.makeText(Secondpage.this,"listview",  Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    }
                    default:
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }



        });
        Button button=(Button)findViewById(R.id.startservice);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getBaseContext(),Fifthpage.class));
            }
        });
        Button b=(Button)findViewById(R.id.stopservice);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getBaseContext(),Fifthpage.class));
            }
        });

    }

}

