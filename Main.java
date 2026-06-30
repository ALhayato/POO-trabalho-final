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
        Scannersc = new.Scanner(System.in);
        
        System.out.println("Dados pessoais");
        System.out.println("Insira seu nome");
        String nome = sc.nextLine();
        System.out.println("Insira sua idade");
        sc.nextLine();
        Int idade = sc.nextInt();
        System.out.println("Insira seu cpf");
        String cpf = sc.nextLine();
        System.out.println("Insira sua senha");
        String senha = sc.nextLine();
        p.autenticar(senha);

        
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

        Aviso novo = new Aviso(conteudo, data, 0, titulo);

        sistema.adicionarAviso(novo);
    }
}
