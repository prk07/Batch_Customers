package br.com.pauloh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pauloh.dataconnect.ConnectionFactory;
import br.com.pauloh.model.Customer;
/** 
 * Classe para CRUD no Objeto Customer
 * @see ConnectionFactory 
 * @author pauloh
 */
public class CustomerDAO {
	private static Connection con;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static String sql;
			
	public CustomerDAO(){
		this.con = ConnectionFactory.getConnection();
	}	
		
	public boolean inserir(Customer c){		
		/**
		 * Insere um Cliente(Customer) no banco de dados
		 * @param Customer
		 * @return Boolean informando a conclusao da operacao
		 * @author pauloh 
		 * */
		boolean result = false;		
			
		sql = "insert into TB_CUSTOMER_ACCOUNT values (?,?,?,?,?)";		
		try {						
			ps = con.prepareStatement(sql);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getCpf_cnpj());
			ps.setString(3, c.getNome());
			
			if(c.isAtivo()){
				ps.setInt(4, 1);
			} else {
				ps.setInt(4, 0);
			}
			
			ps.setFloat(5, c.getValorTotal());
			
			con.setAutoCommit(true);
			ps.execute();
			
			result = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return result;
	}

	public List<Customer> getCostumers() throws SQLException{
		List<Customer> listaSaida = new ArrayList<Customer>();
		
		con = ConnectionFactory.getConnection();
		
		sql = "select * from tb_customer_account";
		ps = con.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		while (rs.next()){			
			//Verifica se esta ativo
			boolean ativo = false;
			if(rs.getInt("is_active")==1){
				ativo = true;
			} 
			listaSaida.add(new Customer(
					rs.getInt("id_customer"), 
					rs.getString("cpf_cnpj"), 
					rs.getString("nm_customer"), 
					ativo, 
					rs.getFloat("vl_total")
				)
			);
		}//fim do loop
		return listaSaida;
	}
}
