package com.example.withouwaste_v001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {
    EditText nome;
    EditText senha1;
    EditText senha2;
    EditText email;
    CheckBox robo;
    Button cadastro;
    static Repositorio r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();
        nome = findViewById(R.id.editTextUsuario0);
        senha1 = findViewById(R.id.editTextSenha1);
        senha2 = findViewById(R.id.editTextSenha2);
        email = findViewById(R.id.editTextEmail);
        robo = findViewById(R.id.checkBoxRobo);
        cadastro = findViewById(R.id.buttonCadastro);
        cadastro.setOnClickListener(view -> {
            cadastrar();
        });
    }
    public void cadastrar(){

        try{

            if(isEmpty(nome) || isEmpty(senha1) || isEmpty(senha2) || isEmpty(email)){

                Toast.makeText( Cadastro.this, "Preencha todos os campos corretamente.", Toast.LENGTH_LONG).show();

            }else{
                String nomeA = nome.getText().toString();
                String senha1A = senha1.getText().toString();
                String senha2A = senha2.getText().toString();
                String emailA = email.getText().toString();

                if(robo.isChecked()){
                    switch(verificaCadastro(nomeA, emailA)){
                        case 1:
                            Toast.makeText(Cadastro.this, "O Email inserido já está em uso.", Toast.LENGTH_LONG).show();
                            break;
                        case 2:
                            Toast.makeText(this, "O Usuário inserido já está em uso.", Toast.LENGTH_LONG).show();
                            break;
                        case 0:
                            if(senha1A.equals(senha2A)){
                                cadastraUsuario(nomeA, senha1A, emailA);
                                Toast.makeText(this, "Usuário cadastrado com sucesso.", Toast.LENGTH_LONG).show();
                                voltar();
                            }else{
                                Toast.makeText(Cadastro.this, "As senhas inseridas não coincidem.", Toast.LENGTH_LONG).show();
                            }
                            break;
                    }
                }else{
                    Toast.makeText(Cadastro.this, "Confirme que você não é um robô", Toast.LENGTH_LONG).show();
                }
            }
        }catch(Exception e){
            Toast.makeText(Cadastro.this, "Erros: " + e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void cancelar(View view){
        voltar();
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

   public int verificaCadastro(String cNome, String cEmail){
       int resultado = 0;
        for(int i = 0; i < r.listaUsuarios.size(); i++){
            if(r.listaUsuarios.get(i).getEmail().equals(cEmail)){
                resultado = 1;
                break;
            }else if(r.listaUsuarios.get(i).getNome().equals(cNome)){
                resultado = 2;
                break;
            }
        }
        Toast.makeText(Cadastro.this, "" + resultado, Toast.LENGTH_LONG);
        return resultado;
    }

    public void cadastraUsuario(String cNome, String cSenha, String cEmail){
        Usuario u = new Usuario();
        u.setNome(cNome);
        u.setSenha(cSenha);
        u.setEmail(cEmail);
        u.setVip_ou_free(false);
        r.listaUsuarios.add(u);
  }
  public void voltar(){
      Intent i = new Intent(this, MainActivity.class);
      startActivity(i);
      MainActivity.r = r;
  }
}