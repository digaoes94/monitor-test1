package application;

import entities.Cliente;
import controller.Atendimento;

import java.util.Scanner;

public class ControleFilaAtendimento {
	//  System.out.println("");
	public static Scanner scan = new Scanner(System.in);
	public static Atendimento atendimentoAtual = new Atendimento();

	public static void main(String[] args) {
		boolean run = true;
		
		System.out.println("Iniciando atendimento do dia dd/mm/aaaa.\n");
		
		do {
			run = Menu(atendimentoAtual);
		} while (run);
	}

	public static boolean Menu(Atendimento atendimento) {
		int escolha;
		
		System.out.println("Favor selecionar o procedimento a executar:");
		System.out.println("1. Adicionar cliente à fila.");
		System.out.println("2. Atender cliente.");
		System.out.println("3. Mostrar situação da fila.");
		System.out.println("4. Sair.");
		
		escolha = scan.nextInt();
		
		if (escolha == 4) {
			return false;
		}
		else {
			switch (escolha) {
			case 1:
				String nomeCliente;
				String cpfCliente;
				
				System.out.print("Favor informar nome do cliente: ");
				scan.nextLine();  //  consumir line excesso
				nomeCliente = scan.nextLine();
				System.out.print("Favor informar CPF do cliente: ");
				cpfCliente = scan.nextLine();
				
				System.out.println(atendimento.entrarNaFila(new Cliente(nomeCliente, cpfCliente)) + "\n");
				return true;
				
			case 2:
				Cliente atendendo = atendimento.atender();
				
				if (atendendo == null) {
					System.out.println("A fila está vazia, ninguém está esperando atendimento.");
				}
				else {
					System.out.print("Cliente encaminhado para atendimento.\nNome: " + atendendo.getName() + ". CPF: " + atendendo.getCpf() + ".\n\n");
				}
				return true;
				
			case 3:
				System.out.println("Limite da fila: 500 clientes.");
				System.out.println("Clientes em espera: " + atendimento.getFilaAtendimento().size() + ".");
				System.out.println("Vagas disponíveis: " + (500 - atendimento.getFilaAtendimento().size()) + ".\n");
				return true;
				
			default:
				System.out.println("Opção inválida, o programa será encerrado.");
				return false;
			}
		}
	}
}
