package model;

import interfacemdl.*;

public abstract class Pessoa implements Autenticavel{
    private static int contadorId = 0;

    private int id;
    private String nome;
    private String cpf;
    private int idade;
    private String senha;
    
    public Pessoa(String nome, String cpf, int idade, String senha) {   
        contadorId++;

        this.cpf = cpf;
        this.id = contadorId;
        this.nome = nome;
        this. idade = idade;
        this.senha = senha;
    }

    @Override
    public boolean autenticar(String senhaDigitada){
        return this.senha != null && this.senha.equals(senhaDigitada);
    }

    public static int getProximoId(){
        return contadorId + 1;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public int getIdade(){
        return idade;
    }
    
    /**
     * exibe as informações sobre um determinado objeto
     */
    public abstract void exibirDados();
} 
