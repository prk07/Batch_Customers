package br.com.pauloh.tools;

import java.util.ArrayList;
import java.util.List;

import br.com.pauloh.model.Customer;

public class CustomerCalculator {
	private List<Customer> lista;
	private float media;
	
	public CustomerCalculator(){		
		this.lista = new ArrayList<Customer>();
	}
	
	public CustomerCalculator(List<Customer> lista){
		this.lista = lista;
	}
	
	public List<Customer> getLista() {
		return lista;
	}

	public float getMedia() {
		return media;
	}

	public void add(Customer c){
		this.lista.add(c);
	}
	
	public void calculaMedia(){		
		float total = 0;
		for(int i = 0; i < lista.size(); i++){
			total+=lista.get(i).getValorTotal();			
		}
		media = total/lista.size();
	}
}
