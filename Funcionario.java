class Funcionario extends Pessoa{
    private String matricula;
    private String cargo;
    
    public Funcionario(String nome, String cpf, int idade, String senha, String matricula, String cargo) {
        super(nome, cpf, idade, senha);
        this.cargo = cargo;
        this.matricula = matricula;
    }
    
    @Override
    public boolean autenticar(String senha){
        return this.getSenha().equals(senha);
    }

    @Override
    public void exibirDados(){
        System.out.println("Dados do Funcionário");
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Cargo: " + getCargo());
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
