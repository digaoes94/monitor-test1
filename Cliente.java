package entities;

public class Cliente {
	private String name;
	private String cpf;
	
	//  constructor
	public Cliente(String name, String cpf) {
		this.name = name;
		this.cpf = cpf;
	}

	//  get set name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//  get set cpf
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
