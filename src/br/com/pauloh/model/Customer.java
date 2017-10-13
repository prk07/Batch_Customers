package br.com.pauloh.model;

public class Customer {
	private int id;
	private String cpf_cnpj;
	private String nome;
	private boolean ativo;
	private float valorTotal;		

	public Customer(int id, String cpf_cnpj, String nome, boolean ativo,
			float valorTotal) {
		this.id = id;
		this.cpf_cnpj = cpf_cnpj;
		this.nome = nome;
		this.ativo = ativo;
		this.valorTotal = valorTotal;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
