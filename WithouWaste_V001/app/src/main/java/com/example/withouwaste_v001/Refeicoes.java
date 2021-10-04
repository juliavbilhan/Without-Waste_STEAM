package com.example.withouwaste_v001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Refeicoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refeicoes);
    }
    public void voltar(View view){
        Intent i = new Intent(this, Selecao.class);
        startActivity(i);
    }
}