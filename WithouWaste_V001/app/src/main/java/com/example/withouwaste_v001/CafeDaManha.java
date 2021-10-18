package com.example.withouwaste_v001;

import android.content.Intent;
import android.os.Bundle;

public class CafeDaManha extends Selecao {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_da_manha);
        Intent i = new Intent(CafeDaManha.this, MainActivity.class);
        startActivity(i);

    }

    public CafeDaManha() {
    }
}