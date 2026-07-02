package model;

import interfacemdl.Clinico;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa{
  private String responsavelLegal;
  private String telefoneResponsavel;
  private String telefoneMaior;
  private final List<String> historicoClinico;

  public Paciente(String nome, String cpf, int idade, String senha, String responsavelLegal, String telefoneResponsavel){
    super(nome, cpf, idade, senha);
    this.historicoClinico = new ArrayList<>();

    if(this.getIdade() < 18 && responsavelLegal == null){
      throw new IllegalArgumentException("menores de 18 anos devem ter um responsavel legal e o telefone do responsavel.");
    }

    if(this.getIdade() < 18){
      this.responsavelLegal = responsavelLegal;
      this.telefoneResponsavel = telefoneResponsavel;
    } else {
      this.responsavelLegal = "Não se aplica";
      this.telefoneResponsavel = telefoneResponsavel;
    }
  }
  
  
  public void adicionarEvolucao(String texto, Funcionario autor){
    if(texto != null && !texto.isEmpty()){
      this.historicoClinico.add(texto);
    }
  }

  /**
   * recupera o prontuario de um paciente
   * @param f objeto que implenta clinico (psiquiatra ou psicologo)
   * @return retorna o array de historico 
   */
  public List<String> getHistoricoClinico(Clinico f){
      return this.historicoClinico;
  }
    
  

  @Override
  public void exibirDados(){
    System.out.println("ID: " + getId());
    System.out.println("Nome:" + getNome());
    System.out.println("Idade:" + getIdade());
    System.out.println("CPF:" + getCpf());
    System.out.println("Responável: " + this.responsavelLegal);
    System.out.println("Telefone do Responsável: " + this.telefoneResponsavel);
  }

  @Override
  public boolean autenticar(String senha){
    return this.getSenha().equals(senha);
  }

  public String getResponsavelLegal() {
      return responsavelLegal;
  }

  public void setResponsavelLegal(String responsavelLegal) {
      this.responsavelLegal = responsavelLegal;
  }

  public String getTelefoneResponsavel() {
      return telefoneResponsavel;
  }

  public void setTelefoneResponsavel(String telefoneResponsavel) {
      this.telefoneResponsavel = telefoneResponsavel;
  }

  public String getTelefoneMaior() {
      return telefoneMaior;
  }

  public void setTelefoneMaior(String telefoneMaior) {
      this.telefoneMaior = telefoneMaior;
  }
}