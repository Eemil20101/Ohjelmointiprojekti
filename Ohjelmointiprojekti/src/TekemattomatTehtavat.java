import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TekemattomatTehtavat {

	public void onClicked()
	{
		
		Connection connection = null; 
		Statement statement = null;  
		ResultSet resultSet = null;
		
		// Yhteyden tiedot
		String db = "trtkp20a3";
		String url = "jdbc:mysql://shell.hamk.fi/"+db+"?useSSL=false";
		String username = "trtkp20a3";
		String password = "trtkp20a3passwd";
		
		// Tietokannan taulun kentät tulostusta varten
		int id;
		//String nimi;
		//int hinta;	
		String tekemattomatTehtavat;
		
		//Scanner in = new Scanner(System.in);
		
		//System.out.println("Anna tuotteen nimi");
		//nimi = in.nextLine();
		
		//System.out.println("Anna tuotteen hinta");
		//hinta = Integer.parseInt(in.nextLine());
			
		//LAITOIN KOMMENTIKSI KOSKA TARKOITUKSENA VAIN HAKEA TIEDOT, EI LISÄTÄ
		
		try {
			
			// 1. yhteys
			connection = DriverManager.getConnection(url, username, password);
			
			// 2. MySQL-kysely
			statement = connection.createStatement();

			String querySelect = "SELECT * FROM Ryhma8";
			//String queryInsert = "INSERT INTO tuotteet (nimi,hinta) VALUES ('"+nimi+"',"+hinta+")";
			//System.out.println(queryInstert);
			
			// 3. Suoritetaan kysely
			resultSet = statement.executeQuery(querySelect);
			//statement.executeUpdate(queryInsert);
			
			// 4. Vastauksen käsittely
			System.out.println("ID\tTekemättömät Tehtävät");

			while (resultSet.next()) {
				id = resultSet.getInt("id");
				tekemattomatTehtavat = resultSet.getString("tekemattomatTehtavat");
				//nimi = resultSet.getString("nimi");  
				//hinta = resultSet.getInt("hinta");
				System.out.println(id + "\t" + tekemattomatTehtavat);
			}               //laitoin kommentiksi kun en nyt ainakaan tarvi nimeä enkä hintaa
			
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			// 5. Yhteyden sulkeminen ja kyselyjen nollaus
			if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
			if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
		    if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
		  }
	}
}


