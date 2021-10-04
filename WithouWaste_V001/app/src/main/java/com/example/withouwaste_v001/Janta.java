package com.example.withouwaste_v001;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Janta extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_janta);
        img = findViewById(R.id.ex);
    }
    public void clickImage(View view){
        trocaImage();

    }
    public void trocaImage(){
        img.setImageURI(R.drawable.ww_jantar_sf);
    }
}