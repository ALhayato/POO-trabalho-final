import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

private Scanner sc = new Scanner(System.in);

public class Main{
    public static void main(String[] args) {
        int opcao = 0;
        do{
            menu();
            try{
                opcao = Integer.parseInt(sc.nextLine());
                escolherOpcao(int opcao);
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
                editarAvisos();
                break;

            case 5:
                conferirSuaFicha();
                break;

            case 6:
                sair();
                break;
            }
        }

}
