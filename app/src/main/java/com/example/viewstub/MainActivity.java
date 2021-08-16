package com.example.viewstub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
ViewStub viewStub;Button b1,b2;Button button;Button button1;TextView textView; @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);setContentView(R.layout.activity_main);
        viewStub=(ViewStub)findViewById(R.id.viewStub2);b1=(Button)findViewById(R.id.button);b2=(Button)findViewById(R.id.button2);
        viewStub.inflate();
        b1.setOnClickListener(this); b2.setOnClickListener(this);
        textView=(TextView)findViewById(R.id.textView); button1=(Button)findViewById(R.id.button3);
         button1.setOnClickListener(new View.OnClickListener() {@Override
             public void onClick(View v) { String text=" ";try {
                 InputStream in=getAssets().open("and.txt");
                     int size=in.available(); byte[] buffer=new byte[size];
                     in.read(buffer);in.close();
                     text=new String(buffer);
                 } catch (IOException e) { e.printStackTrace(); }
                 textView.setText(text); }});
        button=(Button)findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {@Override
            public void onClick(View v) {
                try { Uri uri=Uri.parse("market://details?id="+getPackageName());
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Uri uri=Uri.parse("http://play.google.com/store/apps/details?id="+getPackageName());
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri); intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent); } }}); } @Override
    public void onClick(View v) { switch (v.getId()){
            case R.id.button : viewStub.setVisibility(View.VISIBLE);break;
            case R.id.button2 : viewStub.setVisibility(View.GONE);break; } }}