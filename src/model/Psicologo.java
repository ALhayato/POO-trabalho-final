package model;
import interfacemdl.Clinico;
import interfacemdl.VideoChamada;

public class Psicologo extends Funcionario implements Clinico, VideoChamada{
  
  private String especialidade;

  public Psicologo(String nome, String cpf, int idade, String senha, String matricula, String cargo, String especialidade){
    super(nome, cpf, idade, senha, matricula, cargo);
    this.especialidade = especialidade;
  }

  public void setEspecialidade(String especialidade){
    this.especialidade = especialidade;
  }
  
  public String getEspecialidade(){
    return especialidade;
  }

  public boolean fazerVideoChamada(Paciente p){
    boolean conectado = false;
    String tel = p.getTelefoneResponsavel();
    if(tel != null){
      conectado = true;
    }
    System.out.println("ligacao conectada");
    return conectado;
  }

  public void evoluirProntuario(Paciente p, String anotacao){
    p.adicionarEvolucao(anotacao, this);
  }

  @Override
  public void exibirDados(){
    System.out.println("Dados do Psicólogo");
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Cargo: " + getCargo());
        System.out.println("Especialidade : " + getEspecialidade());
  }
}
