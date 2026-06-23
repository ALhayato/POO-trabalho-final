class Paciente extends Pessoa{
  private String responsavelLegal;
  private String telefoneResponsavel;
  private String telefoneMaior;
  private List<String> historicoClinico;

  public PacienteC(int id, String nome, String cpf, String senha, int idade, String responsavelLegal, String telefoneResponsavel){
    super(id, nome, cpf, senha, idade);
    this.historicoClinico = new ArrayList<String>();
    if(this.getIdade() < 18){
      throw new IllegalArgumentException("menores de 18 anos devem ter um responsavel legal e o telefone do responsavel.");
      }else{
        this.responsavelLegal = null;
        this.telefoneResponsavel = null;
      }
      this.responsavelLegal = responsavelLegal;
      this.telefoneResponsavel = telefoneResponsavel;
    }

  public Paciente(int id, String nome, String cpf, String senha, int idade, String telefoneMaior){
    super(id, nome, cpf, senha, idade);
    if(this.idade >= 18){
      this.telefoneMaior = telefoneMaior;
    }
  }
  public void adicionarEvolucao(String texto, Funcionario autor){
    
  }
  public list<String> getHistoricoClinico(){
    
  }
  @Override
  public void exibirDados(){
    
  }
}
