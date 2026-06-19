class Psicologo extends Funcionario{
  
  Private String especialidade;

  public Psicologo(int id, String nome, String cpf, int idade, String senha, String especialidade){
    super(id, nome, cpf, idade, senha);
    this.especialidade = especialidade;
  }

  public boolean fazerVideochamada(Paciente p){
    
  }

  public void evoluirProntuario(Paciente p, String anotacao){
    
  }
}
