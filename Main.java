import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    static private Scanner sc = new Scanner(System.in);
    static private GerenciadorSistema sistema = new GerenciadorSistema();
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
                cadastrarUsuario(Pessoa p);
                break;

            case 2:
                checarAvisos();
                break;

            case 3:
                verificarProntuario(Paciente p);
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

    public void cadastrarUsuario(Pessoa p){
        List<Paciente> pacientes = new ArrayList<>();
        System.out.println("Quem você quer cadastrar?");
        System.out.println("1. Psicólogo");
        System.out.println("2. Psiquiatra");
        System.out.println("3. Paciente");
        
        int opcao;
        do { 
            opcao = Integer.parseInt(sc.next());

            if(opcao < 1 || opcao > 3){
                System.out.println("Por favor, escolha uma opção válida");
            }
        } while (opcao < 1 || opcao > 3);

        
        System.out.println("\n\nDados pessoais");
        System.out.println("Insira seu nome");
        String nome = sc.nextLine();
        p.setNome(nome);
        
        System.out.println("Insira sua idade");
        int idade = sc.nextInt();
        p.setIdade(idade);
        sc.nextLine();
        
        System.out.println("Insira seu cpf");
        String cpf = sc.nextLine();
        p.setCpf(cpf);
        
        System.out.println("Insira sua senha");
        String senha = sc.nextLine();
        p.autenticar(senha);
        p.setSenha(senha);

        
        // if(p instanceof Psicologo){
        //     System.out.println("Insira sua especialidade");
        //     String especialidade = sc.nextLine();
        //     p.setEspecialidade(especialidade);
        // }if(p instanceof Psiquiatra){
        //     System.out.println("Insira seu registro de conselho");
        //     String registro = sc.nextLine();
        //     p.setRegistroConselho(registro);
        // }if(p instanceof Paciente){
        //     if(p.getIdade() < 18){
        //         System.out.println("Insira o nome do seu responsavel");
        //         String responsavel = sc.nextLine();
        //         p.setResponsavelLegal(responsavel);
        //     }
        //     System.out.println("Insira seu telefone");
        //     String telefone = sc.nextLine();
        //     p.setTelefone(telefone);
        //     pacientes.add(paciente);
        // }
        
        System.out.println("Pronto! cadastro concluído");
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
