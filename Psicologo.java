class Psicologo extends Funcionario{
  
  private String especialidade;

  public Psicologo(String especialidade, String cargo, String matricula, int id, String nome, String cpf, int idade, String senha){
    super(cargo, matricula, id, nome, cpf, idade, senha);
    this.especialidade = especialidade;
  }

  public boolean fazerVideochamada(Paciente p){
    boolean conectado = false;
    String telC = p.getTelefoneResponsavel();
    String tel = p.getTelefone();
    if(telC.equals(p.getTelefoneResponsavel()) || tel.equals(p.getTelefone())){
      conectado = true;
    }
    System.out.println("ligacao conectada");
    return conectado;
  }

  public void evoluirProntuario(Paciente p, String anotacao){
    String laudo = anotacao;
    p.adicionarEvolucao(laudo, this);
  }

  @Override
  public void exibirDados(){
    
  }
}
