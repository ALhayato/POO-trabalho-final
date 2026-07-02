package main;

import interfacemdl.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.*;
import view.*;



public class Main{

    static private final Scanner sc = new Scanner(System.in);
    static private final GerenciadorSistem sistema = new GerenciadorSistem();
    public static void main(String[] args) {
    // List<Paciente> pacientes = new ArrayList<>();
        Paciente a = new Paciente("Carlos", "64578925421", 20, "1234cl", null, "999458237");
        Paciente b = new Paciente("Lucas", "07489653152", 25, "onmark58228", null, "999987654");
        Paciente c = new Paciente("Fernanda", "07845135457", 28, "nan74986", null, "999585795");

        Funcionario m = new Psiquiatra("Hugo", "05948725984", 40, "health63342", "459752", "Psiquiatra", "CRM-025487");
        Funcionario f = new Psicologo("Adriana", "45317859452", 38, "dri5874", "582461", "Psicologo", "geral");
        
        sistema.cadastrarUsuario(a);
        sistema.cadastrarUsuario(b);
        sistema.cadastrarUsuario(c);
        sistema.cadastrarUsuario(m);
        sistema.cadastrarUsuario(f);

        try{
            Paciente d = new Paciente("Ana", "05473526812", 15, "574842", null, "999123456");
            sistema.cadastrarUsuario(d);
        }catch(IllegalArgumentException e){
        System.out.println("Erro: " + e.getMessage());
        }

        Paciente r = new Paciente("Laura", "08794624534", 15, "7542lala", "Luane", "997568425");
        sistema.cadastrarUsuario(r);

        int opcao = 0;
        do{
            menu();
            try{
                opcao = Integer.parseInt(sc.nextLine());
                escolherOpcao(opcao, m, f);
               }catch(NumberFormatException e){
                    System.out.println("Erro: escolha uma opção valida");
                }
        }while (opcao != 6);
    
    }


    public static void menu(){
        System.out.println("\n------------------------\nBem vindo ao CAPSistema!\n------------------------\n");
        System.out.println("Escolha a opção desejada:");
        System.out.println("1. Cadastrar usuário");
        System.out.println("2. Checar avisos");
        System.out.println("3. Verificar prontuario");
        System.out.println("4. Editar avisos");
        System.out.println("5. Conferir sua ficha");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    /**
     * metodo que controla o fluxo de terminal
     * @param opcao numero inteiro que representa o escolha do usuario
     * @param m atua como psiquiatra
     * @param f atua como clinico 
     */
    private static void escolherOpcao(int opcao, Funcionario m, Funcionario f){
           switch(opcao){
            case 1:
                cadastrarUsuario();
                break;

            case 2:
                checarAvisos();
                break;

            case 3:
                verificarProntuario(m);
                break;

            case 4:
                criarAvisos();
                break;

            case 5:
                conferirSuaFicha((Clinico) f);
                break;

            case 6:
                sair();
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void cadastrarUsuario(){
        System.out.println("\nInsira o tipo de perfil");
        System.out.println("1. Paciente");
        System.out.println("2. Psicólogo");
        System.out.println("3. Psiquiatra");
        int tipo = Integer.parseInt(sc.nextLine());
        
        System.out.println("\nDados pessoais");
        System.out.print("Insira seu nome: ");
        String nome = sc.nextLine();
        
        System.out.print("Insira sua idade: ");
        int idade = Integer.parseInt(sc.nextLine());
        
        System.out.print("Insira seu cpf: ");
        String cpf = sc.nextLine();
        
        System.out.print("Insira sua senha: ");
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
                    
                    System.out.print("Insira o telefone do responsável: ");
                    telefoneresp = sc.nextLine();

                    Pessoa paciente= new Paciente(nome, cpf, idade, senha, responsavel, telefoneresp);
                    sistema.cadastrarUsuario(paciente);
                    break;
                case 2:
                    {
                        System.out.print("Insira sua matricula");
                        String matricula = sc.nextLine();

                        System.out.print("Insira sua especialidade");
                        String especialidade = sc.nextLine();

                        Funcionario psicologo = new Psicologo(nome, cpf, idade, senha, matricula, "Psicólogo", especialidade);
                        sistema.cadastrarUsuario(psicologo);
                        break;
                    }
                case 3:
                    {
                        System.out.print("Insira sua matricula");
                        String matricula = sc.nextLine();

                        System.out.print("Insira seu CRM");
                        String registroConselho = sc.nextLine();

                        Funcionario psiquiatra = new Psiquiatra(nome, cpf, idade, senha, matricula, "Psiquiatra", registroConselho);
                        sistema.cadastrarUsuario(psiquiatra);
                        break;
                    }
                default:
                    System.out.println("Tipo inválido");
                    break;
            }

            System.out.println("Pronto, cadastro concluído!\n==============================\n");

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

    public static void verificarProntuario(Funcionario m){
        List<Paciente> pacientes = new ArrayList<>();
        for(Pessoa p : sistema.getUsuarios()){
            if(p instanceof Paciente){
                pacientes.add((Paciente) p);
            }
        }

        if(pacientes.isEmpty()){
            System.out.println("Nenhum paciente cadastrado!");
            return;
        }
        
        System.out.println("Escolha um paciente");

        for(int i = 0; i < pacientes.size(); i++){
            System.out.println("[" + i + "]" + pacientes.get(i).getNome());
        }

        System.out.print("Digite o número do paciente: ");
        try{
            int i = Integer.parseInt(sc.nextLine());
            
            if(i >= 0 && i < pacientes.size()){
                Paciente e = pacientes.get(i);
                System.out.println("Nome :" + e.getNome());
                System.out.println("historico :" + e.getHistoricoClinico((Clinico) m));

                System.out.println("Digite as anotações");
                String novoLaudo = sc.nextLine();
                ((Clinico)m).evoluirProntuario(e, novoLaudo);
                System.out.println("Prontuario atualizado");
            }

            else{
                System.out.println("Número inválido");
            }

        } catch(NumberFormatException e) {
            System.out.println("Digite um número inteiro válido");
        }
    }
    public static void conferirSuaFicha(Clinico f){
        List<Paciente> pacientes = new ArrayList<>();
        for(Pessoa p : sistema.getUsuarios()){
            if(p instanceof Paciente){
                    pacientes.add((Paciente) p);
            }
        }        
                
        System.out.println("Escolha um paciente");

        for(int i = 0; i < pacientes.size(); i++){
            System.out.println("[" + i + "]" + pacientes.get(i).getNome());
        }

        try{
            int i = Integer.parseInt(sc.nextLine());
            
            if(i >= 0 && i < pacientes.size()){
                Paciente e = pacientes.get(i);

                System.out.println("Histórico de: " + e.getNome());
                System.out.println("historico :" + e.getHistoricoClinico(f));
            }

            else{
                System.out.println("Número inválido");
            }
        } catch(NumberFormatException e){
            System.out.println("Digite um número inteiro válido");
        }
    }

    public static void sair(){
        System.out.println("Fechando o sistema!");
    }
}
