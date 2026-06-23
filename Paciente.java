import java.util.ArrayList;
import java.util.List;

class Paciente extends Pessoa{
  private String responsavelLegal;
  private String telefoneResponsavel;
  private String telefoneMaior;
  private List<String> historicoClinico;

  public Paciente(int id, String nome, String cpf, int idade, String senha, String responsavelLegal, String telefoneResponsavel){
    super(id, nome, cpf, idade, senha);
    this.historicoClinico = new ArrayList<String>();

    if(this.getIdade() < 18 && responsavelLegal == null){
      throw new IllegalArgumentException("menores de 18 anos devem ter um responsavel legal e o telefone do responsavel.");
    }

    if(this.getIdade() < 18){
      this.responsavelLegal = responsavelLegal;
      this.telefoneResponsavel = telefoneResponsavel;
    } else {
      this.responsavelLegal = "Não se aplica";
      this.telefoneResponsavel = "Não se aplica";
    }
  }
  
  public void adicionarEvolucao(String texto, Funcionario autor){
    if(texto != null && !texto.isEmpty()){
      this.historicoClinico.add(texto);
    }
  }

  public List<String> getHistoricoClinico(Funcionario f){
    if(f instanceof Psicologo || f instanceof Psiquiatra){
      return this.historicoClinico;
    }
    System.out.println("Acesso negado");
    return null;
  }

  @Override
  public void exibirDados(){
    System.out.println("ID: " + getId());
    System.out.println("Nome:" + getNome());
    System.out.println("Idade:" + getIdade());
    System.out.println("CPF:" + getCpf());
    System.out.println("Responável: " + this.responsavelLegal);
    System.out.println("Telefone do Responsável: " + this.telefoneResponsavel);
  }

  @Override
  public boolean autenticar(String senha){
    return this.getSenha().equals(senha);
  }

    public String getResponsavelLegal() {
        return responsavelLegal;
    }

    public void setResponsavelLegal(String responsavelLegal) {
        this.responsavelLegal = responsavelLegal;
    }

    public String getTelefoneResponsavel() {
        return telefoneResponsavel;
    }

    public void setTelefoneResponsavel(String telefoneResponsavel) {
        this.telefoneResponsavel = telefoneResponsavel;
    }
}
