package view;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class GerenciadorSistem{
  private final List<Pessoa> usuarios = new ArrayList<>();
  private final List<Aviso> muralAvisos = new ArrayList<>();

  public void cadastrarUsuario(Pessoa p){
    if(p == null){ //verifica se o objeto é nulo
      throw new IllegalArgumentException("Não é possivel cadastrar um usuário nulo");
    }

    for(Pessoa u : usuarios){
      if(u.getCpf().equals(p.getCpf())){ //verifica se o cpf já existe
        throw new IllegalArgumentException("Já existe um usuário cadastrado com esse CPF");
      }
    }

    usuarios.add(p);
    System.out.println("Usuário cadastrado com sucesso");
  }

  public Pessoa fazerLogin(String cpf, String senha){
    if(cpf == null || senha == null){
      return null;
    }

    for(Pessoa p : usuarios){
      if(p.getCpf().equals(cpf)/* && falta fazer a parte de autenticar senha*/){
        System.out.println("Login realizado com sucesso");
        return p;
      }
    }
    throw new IllegalArgumentException("CPF ou senha incorretos");
  }

  public List<Aviso> listarAvisosAtivos(){
    List<Aviso> ativos = new ArrayList<>();

    for(Aviso aviso : muralAvisos){ //adiciona a lista ativos apenas os avisos que ainda estão válidos
      if(aviso.estaValido()){
        ativos.add(aviso);
      }
    }
    return ativos;
  }
  
  public void adicionarAviso(Aviso a){
    muralAvisos.add(a);
  }

  public List<Pessoa> getUsuarios(){
    return usuarios;
  }
}
