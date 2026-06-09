abstract class Pessoa implements Autenticavel{
    private int id;
    private String nome;
    private String cpf;
    private String senha;
    
    abstract void exibirDados();
} 