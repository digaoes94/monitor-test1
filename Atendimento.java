package controller;

import entities.Cliente;
import java.util.List;
import java.util.ArrayList;

public class Atendimento {
	private List<Cliente> filaAtendimento = new ArrayList<Cliente>();
	private final int filaLimite = 500;
	
	//  constructor
	public Atendimento() {
		this.filaAtendimento = new ArrayList<Cliente>();
	}
	
	//  get set fila
	public List<Cliente> getFilaAtendimento() {
		return filaAtendimento;
	}
	public void setFilaAtendimento(List<Cliente> filaAtendimento) {
		this.filaAtendimento = filaAtendimento;
	}

	public String entrarNaFila(Cliente cliente) {
		if (filaAtendimento.size() < this.filaLimite) {
			filaAtendimento.add(cliente);
			return "Cliente adicionado à lista.";
		}
		else {
			return "A fila está cheia.";
		}
	}
	
	public Cliente atender() {
		
		if (filaAtendimento.size() == 0) {
			return null;
		}
		else {
			Cliente aux = filaAtendimento.get(0);
			filaAtendimento.remove(0);
			return aux;
		}
	}
}
