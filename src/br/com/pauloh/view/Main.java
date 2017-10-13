package br.com.pauloh.view;

import java.util.Random;

import br.com.pauloh.controller.CustomersController;
import br.com.pauloh.gerador.GeradorDeDocumentos;
import br.com.pauloh.model.Customer;

public class Main {

	public static void main(String[] args) {		
		populaBanco();
	
	}
	private static void populaBanco(){
		CustomersController cCtr = new CustomersController();		
		
		String nome;
		String cpf_cnpj;
		float valor=0;
		boolean ativo;
		Random aleatorio;

		for(int i = 102; i<5201;i+=102.5){
			
			aleatorio = new Random();

			nome = "Customer: "+i;
			valor = aleatorio.nextFloat()*1000;
			
			if (Math.round(Math.random())==0){
				ativo = false;
				cpf_cnpj = GeradorDeDocumentos.geraCNPJ();
			} else {
				ativo = true;
				cpf_cnpj = GeradorDeDocumentos.geraCPF();
			}
			
			
			Customer c = new Customer(i, cpf_cnpj, nome, ativo, valor);		
			cCtr.insertCustomer(c);
		}
	}
}
