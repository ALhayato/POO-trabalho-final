class Psiquiatra extends Funcionario{

  private String registroConselho;

  public Psiquiatra(String registroConselho, String cargo, String matricula, int id, String nome, String cpf, int idade, String senha){
    super(cargo, matricula, id, nome, cpf, idade, senha);
    this.registroConselho = registroConselho;
  }

  public void evoluirProntuario(Paciente p, String anotacao){
    System.out.println("%s", anotacao);
    
  }

  @Override
  public void exibirDados(){
    
  }
}
