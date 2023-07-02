package mvcPre.foodcart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FoodCartDbUtl {

	public static List<Food> getFoodList() throws ClassNotFoundException, SQLException{
		
		String url = "jdbc:mysql://localhost:3306/javamvc?useSSL=false";
		String userName = "root";
		String password = "W@llet123";
		
		ArrayList<Food> food = new ArrayList<>();		
		
		//load the mysql driver
		Class.forName("com.mysql.jdbc.Driver");
		//get the connection
		Connection con = DriverManager.getConnection(url, userName, password);
		//create a statement
		Statement stmt = con.createStatement();
		//execute the statement and loop over the result set
		ResultSet rs = stmt.executeQuery("select * from javamvc.lpreqmvc");
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String item = rs.getString(2);
			float price = rs.getFloat(3);
			Food f = new Food(id, item, price);//injecting everything into constructor
			food.add(f);
		}
		return food;
	}
}
