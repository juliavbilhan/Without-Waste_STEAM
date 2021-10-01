package com.example.withouwaste_v001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Selecao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao);
        getSupportActionBar().hide();
    }
    public void voltar(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void cafeDaManha(View view){
        Intent i = new Intent(this, CafeDaManha.class);
        startActivity(i);
    }
    public void almoco(View view){
        Intent i = new Intent(this, Almoco.class);
        startActivity(i);
    }
    public void janta(View view){
        Intent i = new Intent(this, Janta.class);
        startActivity(i);
    }
}