package com.example.withouwaste_v001;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static Repositorio r = new Repositorio();
    EditText nome;
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        nome = findViewById(R.id.editTextUsuario);
        senha = findViewById(R.id.editTextSenha);
        Usuario u = new Usuario();
        u.setNome("admin");
        u.setSenha("admin");
        u.setEmail("admin@gmail.com");
        u.setVip_ou_free(false);
        r.listaUsuarios.add(u);
    }

    public void Teste(View view){
        Toast.makeText(MainActivity.this, "" + r.listaUsuarios.get(0).getNome() + "\n" + r.listaUsuarios.get(0).getEmail() + "\n" + r.listaUsuarios.get(0).getSenha(), Toast.LENGTH_LONG).show();
    }

    boolean verificaUsuario(String cNome, String cSenha){
        for(Usuario u : r.listaUsuarios){
            if(u.nome.equals(cNome) && u.senha.equals(cSenha)){
                return true;
            }
        }
        return false;
    }

    public void entrar(View view){
        try{
            String nomeA = nome.getText().toString();
            String senhaA = senha.getText().toString();
            if(nomeA.isEmpty() || senhaA.isEmpty()){
                Toast.makeText( MainActivity.this, "Preencha todos os campos corretamente.", Toast.LENGTH_LONG).show();
            }else if(!verificaUsuario(nomeA, senhaA)){
                Toast.makeText( MainActivity.this, "Usuário ou Senha inseridos são inválidos.", Toast.LENGTH_LONG).show();
            }else{
                Intent i = new Intent(this, Selecao.class);
                startActivity(i);
            }
        }catch(Exception e){
            Toast.makeText( MainActivity.this, "Preencha todos os campos corretamente.", Toast.LENGTH_LONG).show();
        }
    }

    public void cadastrar(View view){
        Intent i = new Intent(this, Cadastro.class);
        startActivity(i);
        Cadastro.r = r;
    }
}
