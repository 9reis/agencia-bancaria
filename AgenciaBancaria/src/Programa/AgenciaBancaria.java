package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		
		System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");
        
        int operacao = input.nextInt();
        
        switch(operacao) {
        
        case 1: 
        	criarConta();
        	break;
        	
        case 2:
        	depositar();
        	break;
        	
        case 3:
        	sacar();
        	break;
        	
        case 4:
        	transferir();
        	break;
        	
        case 5:
        	listarContas();
        	break;
        	
        case 6:
        	System.out.println("Obrigado por utilizar nossa agância ");
        	System.exit(0);
        	
        	default:
        		System.out.println("Opção invalida!!!");
        		operacoes();
        		break;
        }
        
	}
	
	public static void criarConta() {
		input.nextLine();
		System.out.println("\nNome: ");
		String nome = input.nextLine();
		
		System.out.println("\nCPF: ");
		String cpf = input.nextLine();
		
		System.out.println("\nEmail: ");
		String email = input.nextLine();
		
		Pessoa pessoa = new Pessoa(nome, cpf, email);
		
		Conta conta = new Conta(pessoa);
		
		contasBancarias.add(conta);
		
		System.out.println();
		System.out.println("Sua conta foi criada com sucesso!");
		System.out.println();
		
		operacoes();
	}
	
	private static Conta encontrarConta(int numeroConta) {
		
		Conta conta = null;
		
		if(contasBancarias.size() > 0 ) {
			for(Conta c : contasBancarias) {
				if(c.getNumeroConta() == numeroConta) {
					conta = c;
				}
			}
		} return conta;
	} // FIM encontrarConta()
	
	public static void depositar() {
		System.out.println("Numero da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null){
			System.out.println("Qual o valor deseja depositar? ");
			Double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito);
			
		}else {
			System.out.println("Conta não encontrada!");
		}
		operacoes();
	} // FIM depositar()
	
	public static void sacar() {
		System.out.println("Numero da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null){
			System.out.println("Qual o valor deseja sacar? ");
			Double valorSaque = input.nextDouble();
			conta.sacar(valorSaque);
		}else {
			System.out.println("Conta não encontrada!");
		}
		operacoes();
		
	} // FIM sacar()
	
	public static void transferir() {
		System.out.println("Numero da conta do remetente:  "); 
		int numeroContaRemetente = input.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		if(contaRemetente != null) {
			System.out.println("Numero da conta do destinatário:  ");
			int numeroContaDestinatario = input.nextInt();
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if(contaDestinatario != null) {
				System.out.println("Valor da transferência:  ");
				Double valor = input.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valor);
			}
		}
		operacoes();
	} // FIM transferir()
	
	public static void listarContas () {
		if( contasBancarias.size() > 0) {
			for( Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		}else {
			System.out.println("Não há contas cadastradas!");
		}
		operacoes();
	} // FIM listarContas() 
	
}



































