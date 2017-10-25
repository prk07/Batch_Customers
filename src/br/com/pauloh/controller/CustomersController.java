package br.com.pauloh.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.pauloh.dao.CustomerDAO;
import br.com.pauloh.model.Customer;
import br.com.pauloh.tools.CustomerCalculator;

public class CustomersController {	
	
	public boolean insertCustomer(Customer c){
		/**
		 * Insere um Customer no banco
		 * 
		 * @author pauloh
		 * @see CustomerDAO
		 * @param Customer c
		 * @return boolean informando o exito
		 * */
		return new CustomerDAO().inserir(c);
	}
	public List<Customer> getCustomers(){
		/**
		 * Devolve todos Customers cadastrados no banco
		 * 
		 * @author pauloh
		 * @see CustomerDAO
		 * 
		 * @return ArrayList com customers
		 * */
		List<Customer> lista = null;
		 try {
			lista = new CustomerDAO().getCostumers();
		} catch (SQLException e) {
			System.out.println("Erro ao receber os dados do banco"+e.getMessage());
		}
		 
		 return lista;
	}
	public List<Customer> getCustomersFiltered(int id_inicial, int id_final){
		/**
		 * Filtra a os customers por id
		 * 
		 * @author pauloh
		 * @see CustomerDAO
		 * @param int id_inicial, int id_final
		 * @return ArrayList com customers filtrados por id
		 * */
		
		List<Customer> lista = new ArrayList<Customer>();
		
		for (Customer customer : getCustomers()) {
			if(customer.getId() >= id_inicial && customer.getId() <= id_final){
				lista.add(customer);
			}
		}		
		return lista;
	}
	public List<Customer> getCustomersFiltered(List<Customer> listaEntrada,int id_inicial, int id_final){
		/**
		 * Filtra uma lista de customers por id 
		 * 
		 * @author pauloh
		 * @see CustomerDAO
		 * @param List<Customer> lista , int id_inicial, int id_final
		 * @return ArrayList com customers filtrados por id
		 * */				
		List<Customer> listaSaida = new ArrayList<Customer>();

		for (Customer customer : listaEntrada) {
			if(customer.getId() >= id_inicial || customer.getId() <= id_final){
				listaSaida.add(customer);
			}
		}		
		return listaSaida;
	}
	public CustomerCalculator calculaMedia(List<Customer> listaFiltrada, float valor_minimo, float valor_maximo){
		CustomerCalculator cm = new CustomerCalculator();
		
		for (Customer customer : listaFiltrada) {
			if(customer.getValorTotal() > valor_minimo && customer.getValorTotal() < valor_maximo){
				cm.add(customer);
			}
		}
		cm.calculaMedia();
		return cm;
	}
}
