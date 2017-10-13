package br.com.pauloh.controller;

import br.com.pauloh.dao.CustomerDAO;
import br.com.pauloh.model.Customer;

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
	
}
