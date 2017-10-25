package br.com.pauloh.view;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import br.com.pauloh.controller.CustomersController;
import br.com.pauloh.dao.CustomerDAO;
import br.com.pauloh.model.Customer;
import br.com.pauloh.tools.CustomerCalculator;
import br.com.pauloh.tools.GeradorDeDocumentos;

public class Main {

	public static void main(String[] args) {		
		//populaBanco();
		entradaDeDados();
							
		final float VALORMINIMO = 560;
		final int ID_INICIAL = 1500;
		final int ID_FINAL = 2700;
		
		CustomersController cCtr = new CustomersController();
		List<Customer> listaFiltrada = cCtr.getCustomersFiltered(ID_INICIAL,ID_FINAL);
		
		CustomerCalculator cm = cCtr.calculaMedia(listaFiltrada, VALORMINIMO,Float.MAX_VALUE);				
		System.out.println("A media do valor total dos Clientes de id entre "+ID_INICIAL+" e "+ID_FINAL+" que é maior que "+VALORMINIMO+" é: "+cm.getMedia());
		List<Customer> listaDoCalculo = cm.getLista();
		
		System.out.println("Clientes Utilizados no cálculo: ");
		for (Customer customer : listaDoCalculo) {
			System.out.println(customer);
		}
	}
	private static void populaBanco(){
		
		/**
		 * Gera 50 Customer aleatorios
		 * 
		 * @author pauloh
		 * @see CustomerController		
		 * */
		
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
	
	private static void entradaDeDados(){
		int op = 1;
		Scanner entrada = new Scanner(System.in);
		while (op == 1){
			System.out.println("|====== Cadastro de novo cliente =====");
			Customer c = new Customer();		
			
			System.out.print("| Nome : ");
			c.setNome(entrada.nextLine());
			
			System.out.println("| CPF ou CNPJ ");
			System.out.println("| Formato 999.999.999-99 ou 99.999.999/9999-99 :");
			System.out.print("| ");
			c.setCpf_cnpj(entrada.nextLine());
			
			System.out.print("| ID: ");
			c.setId(entrada.nextInt());
			
			System.out.print("| 1 - Ativo, 0 - Inativo");
			if (entrada.nextInt()==1) {
				c.setAtivo(true);
			} else {
				c.setAtivo(false);
			}
			
			System.out.print("| Valor Total: ");
			c.setValorTotal(entrada.nextFloat());
			
			new CustomerDAO().inserir(c);
			
			System.out.println("| Deseja cadastrar mais um cliente?: [1/0] ");
			op = entrada.nextInt();					
		}
		System.out.println("| ========================= \n\n\n\n");
		entrada.close();
	}
}
