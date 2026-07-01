import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    static private final Scanner sc = new Scanner(System.in);
    static private final GerenciadorSistema sistema = new GerenciadorSistema();
    public static void main(String[] args) {
        int opcao = 0;
        do{
            menu();
            try{
                opcao = Integer.parseInt(sc.nextLine());
                escolherOpcao(opcao);
               }catch(NumberFormatException e){
                    System.out.println("Erro: escolha uma opção valida");
                }
        }while (opcao != 6);
    }

        
    public static void menu(){
        System.out.println("-----Bem vindo ao CapSistema-----");
        System.out.println("-----Escolha a opção desejada-----");
        System.out.println("1. Cadastrar usuário");
        System.out.println("2. Checar avisos");
        System.out.println("3. Verificar prontuario");
        System.out.println("4. Editar avisos");
        System.out.println("5. Conferir sua ficha");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção");
    }

    private static void escolherOpcao(int opcao){
           switch(opcao){
            case 1:
                cadastrarUsuario();
                break;

            case 2:
                checarAvisos();
                break;

            case 3:
                verificarProntuario();
                break;

            case 4:
                criarAvisos();
                break;

            case 5:
                conferirSuaFicha();
                break;

            case 6:
                sair();
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void cadastrarUsuario(){
        System.out.println("\n\nDados pessoais");
        System.out.println("Insira o tipo de perfil");
        System.out.println("1. Paciente");
        System.out.println("2. Psicólogo");
        System.out.println("3. Psiquiatra");
        int tipo = Integer.parseInt(sc.nextLine());

        System.out.println("Insira seu nome");
        String nome = sc.nextLine();
        
        System.out.println("Insira sua idade");
        int idade = sc.nextInt();
        
        System.out.println("Insira seu cpf");
        String cpf = sc.nextLine();
        
        System.out.println("Insira sua senha");
        String senha = sc.nextLine();

        try {
            switch (tipo) {
                case 1:
                    String responsavel = "Nao se aplica";
                    String telefoneresp;

                    if(idade < 18){
                        System.out.print("Insira o nome do Resposável: ");
                        responsavel = sc.nextLine();
                    }   
                    
                    System.out.print("\nInsira o telefone do responsável: ");
                    telefoneresp = sc.nextLine();

                    Pessoa paciente= new Paciente(nome, cpf, idade, senha, responsavel, telefoneresp);
                    sistema.cadastrarUsuario(paciente);
                    break;
                case 2:
                    {
                        System.out.println("Insira sua matricula");
                        String matricula = sc.nextLine();

                        System.out.println("Insira sua especialidade");
                        String especialidade = sc.nextLine();

                        Funcionario psicologo = new Psicologo(nome, cpf, idade, senha, matricula, "Psicólogo", especialidade);
                        sistema.cadastrarUsuario(psicologo);
                        break;
                    }
                case 3:
                    {
                        System.out.println("Insira sua matricula");
                        String matricula = sc.nextLine();

                        System.out.println("Insira seu CRM");
                        String registroConselho = sc.nextLine();

                        Funcionario psiquiatra = new Psiquiatra(nome, cpf, idade, senha, matricula, "Psiquiatra", registroConselho);
                        sistema.cadastrarUsuario(psiquiatra);
                        break;
                    }
                default:
                    System.out.println("Tipo inválido");
                    break;
            }

            System.out.println("Pronto, cadastro concluído");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar" + e.getMessage());
        }
    }

    public static void checarAvisos(){
        List<Aviso> ativos = sistema.listarAvisosAtivos();
        if(ativos.isEmpty()){
            System.out.println("Sem avisos!");
            return;
        }
        System.out.println("-----Mural de avisos-----");
        for (Aviso aviso : ativos) {
            System.out.println("[" + aviso.getId() + "] " + aviso.getTitulo() + ": " + aviso.getConteudo());
        }
    }

    public static void criarAvisos(){
        System.out.print("Título do aviso: ");
        String titulo = sc.nextLine();
        System.out.println("Conteúdo: ");
        String conteudo = sc.nextLine();
        System.out.println("Data de expiração");
        String data = sc.nextLine();

        Aviso novo = new Aviso(conteudo, data, titulo);

        sistema.adicionarAviso(novo);
    }

    public void verificarProntuario(Paciente e, Clinico m){
        for(int i = 0; i < pacientes.size(); i++){
            System.out.println("Escolher um paciente");
            System.out.println("[" + i + "]" + pacientes.get(i).getNome());
        }
        int i = sc.nextInt();
        sc.nextLine();
        
        if(i > 0 && i < pacientes.size()){
            Paciente e = pacientes.get(i);
            System.out.println("Nome :" + e.getNome());
            System.out.println("historico :" + e.getHistoricoClinico());
            String novoLaudo = sc.nextLine();
            m.evoluirProntuario(p, novoLaudo);
        }
    }
    public void conferirSuaFicha(Paciente p){
        System.out.println("Selecione de qual medico voce quer o historico");
        String cargo = (Funcionario.getCargo()) ? "Psicologo" : "Psiquiatra";
        return p.getHistoricoClinico(cargo);
    }
}
