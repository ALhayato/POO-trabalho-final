abstract class Pessoa implements Autenticavel{

    private int id;
    private String nome;
    private String cpf;
    private int idade;
    private String senha;
    
    public Pessoa(int id, String nome, String cpf, int idade, String senha) {
        this.cpf = cpf;
        this.id = id;
        this.nome = nome;
        this. idade = idade;
        this.senha = senha;
    }

    @Override
    public boolean autenticar(String senha){
        return senha != null && senha.matches("abc\\d+");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public int getIdade(){
        return idade;
    }
    
    public abstract void exibirDados();
} 
