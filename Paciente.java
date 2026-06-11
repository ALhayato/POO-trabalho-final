class pacient extends Pessoa{
  private String responsavelLegal;
  private String telefoneResponsavel;
  private List<String> historicoClinico;

  public Paciente(int id, String nome, String cpf, String senha, String responsavelLegal, String telefoneResponsavel){
    super(id, nome, cpf, senha);
    if(super.getIdade() < 18){
      this.responsavel = responsavel;
      this.telefoneResponsavel = telefoneResponsavel;
    }
    this.historicoClinico = new ArrayList<String>();
  }
  public void adicionarEvolucao(String texto, Funcionario autor){
    
  }
  public String[] getHistoricoClinico(){
    
  }
  @Override
  public void exibirDados(){
    
  }
}
