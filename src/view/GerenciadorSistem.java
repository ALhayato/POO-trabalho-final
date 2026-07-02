package view;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class GerenciadorSistem{
  private final List<Pessoa> usuarios = new ArrayList<>();
  private final List<Aviso> muralAvisos = new ArrayList<>();

  /**
   * metodo para adicionar um usuario ao sistema
   * @param p o objeto a ser cadastrado
   */
  public void cadastrarUsuario(Pessoa p){
    if(p == null){ //verifica se o objeto é nulo
      throw new IllegalArgumentException("Não é possivel cadastrar um usuário nulo");
    }

    for(Pessoa u : usuarios){
      if(u.getCpf().equals(p.getCpf())){ //verifica se o cpf já existe
        throw new IllegalArgumentException(" Já existe um usuário cadastrado com esse CPF");
      }
    }

    usuarios.add(p);
    System.out.println("==============================\nUsuário cadastrado com sucesso");
  }

  /**
   * metodo que permite que um usuario faça login no sistema
   * @param cpf cpf do usuario que esta logando no sistema
   * @param senha senha do usuario que esta logando no sistema
   * @return retorna o objeto Pessoa que foi logado
   */
  public Pessoa fazerLogin(String cpf, String senha){
    if(cpf == null || senha == null){
      return null;
    }

    for(Pessoa p : usuarios){
      if(p.getCpf().equals(cpf) && p.getSenha().equals(senha)){
        System.out.println("Login realizado com sucesso");
        return p;
      }
    }
    throw new IllegalArgumentException("CPF ou senha incorretos");
  }

  /**
   * metodo que varre todos os avisos e escolhe somente os que nao passaram da data de validade
   * @return lista com apenas avisos que nao passaram da data de validade
   */
  public List<Aviso> listarAvisosAtivos(){
    List<Aviso> ativos = new ArrayList<>();

    for(Aviso aviso : muralAvisos){ //adiciona a lista ativos apenas os avisos que ainda estão válidos
      if(aviso.estaValido()){
        ativos.add(aviso);
      }
    }
    return ativos;
  }
  
  /**
   * metodo que adiciona um aviso a um array de avisos
   * @param a aviso que sera registrado
   */
  public void adicionarAviso(Aviso a){
    muralAvisos.add(a);
  }

  /**
   * metodo que junta todos os usuario em um so array
   * @return lista de usuarios
   */
  public List<Pessoa> getUsuarios(){
    return usuarios;
  }
}
