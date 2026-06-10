class pacient extends Pessoa{
  private String responsavelLegal;
  private String telefoneResponsavel;
  private String[] historicoClinico;

  public Paciente(String responsavelLegal, String telefoneResponsavel){
    super.Pessoa(int id, String nome, String cpf, String senha);
    this.responsavel = responsavel;
    this.telefoneResponsavel = telefoneResponsavel;
  }
  public void adicionarEvolucao(String texto, Funcionario autor){
    
  }
  public String[] getHistoricoClinico(){
    
  }
  @Override
  public void exibirDados(){
    
  }
}
