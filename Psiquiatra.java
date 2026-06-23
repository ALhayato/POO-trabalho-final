class Psiquiatra extends Funcionario{

  private String registroConselho;

  public Psiquiatra(String registroConselho){
    super.Funcionario(cargo, matricula, id, nome, cpf, senha);
    this.registroConselho = registroConselho;
  }

  public void evoluirProntuario(Paciente p, String anotacao){
    String laudo = anotacao;
    p.adicionarEvolucao(laudo, this);
    
  }

  @Override
  public void exibirDados(){
    
  }
}
