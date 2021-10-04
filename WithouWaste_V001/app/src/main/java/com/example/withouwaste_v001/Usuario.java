package com.example.withouwaste_v001;

public class Usuario {
    String nome;
    String senha;
    String email;
    boolean vip_ou_free;
    int[] favoritos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVip_ou_free() {
        return vip_ou_free;
    }

    public void setVip_ou_free(boolean vip_ou_free) {
        this.vip_ou_free = vip_ou_free;
    }

    public int[] getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(int[] favoritos) {
        this.favoritos = favoritos;
    }
}
