class Psicologo extends Funcionario{
  
  private String especialidade;

  public Psicologo(String especialidade, String cargo, String matricula, int id, String nome, String cpf, int idade, String senha){
    super(cargo, matricula, id, nome, cpf, idade, senha);
    this.especialidade = especialidade;
  }

  public void setEspecialidade(String especialidade){
    this.especialidade = especialidade;
  }
  
  public String getEspecialidade(){
    return especialidade;
  }

  public boolean fazerVideochamada(Paciente p){
    boolean conectado = false;
    String tel = p.getTelefoneResponsavel();
    if(tel != null){
      conectado = true;
    }
    System.out.println("ligacao conectada");
    return conectado;
  }

  public void evoluirProntuario(Paciente p, String anotacao){
    p.adicionarEvolucao(anotacao, this);
  }

  @Override
  public void exibirDados(){
    System.out.println("Dados do Psicólogo");
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Cargo: " + getCargo());
        System.out.println("Especialidade : " + getEspecialidade());
  }
}
