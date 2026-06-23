class Psicologo extends Funcionario{
  
  private String especialidade;

  public Psicologo(String especialidade, String cargo, String matricula, int id, String nome, String cpf, int idade, String senha){
    super(cargo, matricula, id, nome, cpf, idade, senha);
    this.especialidade = especialidade;
  }

  public boolean fazerVideochamada(Paciente p){
    
  }

  public void evoluirProntuario(Paciente p, String anotacao){
    
  }

  @Override
  public void exibirDados(){
    
  }
}
