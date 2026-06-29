class Psiquiatra extends Funcionario{

  private String registroConselho;

  public Psiquiatra(String registroConselho, String cargo, String matricula, int id, String nome, String cpf, int idade, String senha){
    super(cargo, matricula, id, nome, cpf, idade, senha);
    this.registroConselho = registroConselho;
  }

  public void evoluirProntuario(Paciente p, String anotacao){
    p.adicionarEvolucao(anotacao, this);
  }

  public void setRegistroConselho(String registroConselho){
    this.registroConselho = registroConselho;
  }

  public String getRegistroConselho(){
    return registroConselho;
  }

  @Override
  public void exibirDados(){
    System.out.println("Dados do Psiquiatra");
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Cargo: " + getCargo());
        System.out.println("Registro de Conselho : " + getRegistroConselho());
  }
}
