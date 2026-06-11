class Psiquiatra extends Funcionario{

  private String registroConselho;

  public Psiquiatra(String registroConselho){
    super.Funcionario(String cargo, String matricula, int id, String nome, String cpf, String senha);
    this.registroConselho = registroConselho;
  }

  public void evoluirProntuario(Paciente p, String anotacao){
    System.out.println("%s", anotacao);
    
  }
}
