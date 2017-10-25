package br.com.pauloh.dataconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 
 *  Classe para Conexoes de banco com Design Pattern Singleton
 * @author pauloh
*/

public class ConnectionFactory {	
	public ConnectionFactory(){}
	
	private static Connection connection;
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USUARIO = " ";
    private static final String SENHA = " ";
	
    
 
    public static synchronized Connection getConnection(){
    	/**
         * @author pauloh
         * @return Conexao do tipo Connection
         * */
        if(connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            } 
            catch(ClassNotFoundException e) {	
            	System.out.println("Erro no driver de conexao\n "+e);
            }
            catch(SQLException e) {
            	System.out.println("Erro na conexao com o banco, Verifique o login, senha e os dados de conexao no dataconnect.ConnectionFactory\n "+e);
            }
        }        
        return connection;
    }    
}
