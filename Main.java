public class Main{
    public static void main(String[] args) {
        System.out.println("-----Bem vindo ao CapSistema-----");
        System.out.println("-----Escolha a opção desejada-----");
        System.out.println("1. Cadastrar usuário");
        System.out.println("2. Checar avisos");
        System.out.println("3. Verificar prontuario");
        System.out.println("4. Conferir sua ficha");
        System.out.println("5. Editar avisos");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção");

        private static void escolherOpcao(int opcao){
            switch(opcao){
            case 1:
                cadastrarUsuario(Pessoa p);
                break;

            case 2:
                checarAvisos();
                break;

            case 3:
                cadastrarUsuario(Pessoa p);
                break;
            }
        }
            

    }
            
}
