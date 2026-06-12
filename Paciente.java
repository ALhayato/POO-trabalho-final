class pacient extends Pessoa{
  private String responsavelLegal;
  private String telefoneResponsavel;
  private List<String> historicoClinico;

  public Paciente(int id, String nome, String cpf, String senha, int idade, String responsavelLegal, String telefoneResponsavel){
    super(id, nome, cpf, senha, idade);
    this.historicoClinico = new ArrayList<String>();
    if(this.getIdade() < 18){
      if(this.responsavelLegal == null || responsavelLegal.trim().isEmpty() || this.telefoneresponsavel == null || telefoneResponsavel.trim().isEmpty()){
        throw new IllegalArgumentException("menores de 18 anos devem ter um responsavel legal e o telefone do responsavel.");
      }
      this.responsavelLegal = responsavelLegal;
      this.telefoneResponsavel = telefoneResponsavel;
    }
    
  }
  public void adicionarEvolucao(String texto, Funcionario autor){
    
  }
  public String[] getHistoricoClinico(){
    
  }
  @Override
  public void exibirDados(){
    
  }
}
