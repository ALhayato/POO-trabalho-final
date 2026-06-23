import java.util.ArrayList;
import java.util.List;

class GerenciadorSistema{
  private List<Pessoa> usuarios = new ArrayList<>();
  private List<Aviso> muralAvisos = new ArrayList<>();

  public void cadastrarUsuario(Pessoa p){
    if(p == null){
      throw new IllegalArgumentException("Não é possivel cadastrar um usuário nulo");
    }

    for(Pessoa u : usuarios){
      if(u.getCpf().equals(p.getCpf())){
        throw new IllegalArgumentException("Já existe um usuário cadastrado com esse CPF");
      }
    }

    usuarios.add(p);
    System.out.println("Usuário cadastrado com sucesso");
  }

  public Pessoa fazerLogin(String cpf, String senha){
    return;
  }

  public List<Aviso> listarAvisosAtivos(){
    return;
  }
}
