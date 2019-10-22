package crud.cesusc.alexandre;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conexao {
	
	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {
			try {

		        
		        String url = "jdbc:postgresql://localhost:5432/Transportadora";
		        String usuario = "postgres";
		        String senha = "ads";
		        
		        conn  = DriverManager.getConnection(url,usuario,senha);
	            System.out.println("Conexao realizada com sucesso!");

				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public PreparedStatement prepareStatement(String pst) {
		return null;
	}

}