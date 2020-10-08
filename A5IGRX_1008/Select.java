package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Select {
	private Connection con = null;
	private Statement s = null;
	private ResultSet rs = null;
	ArrayList result =new ArrayList();
	
	
	public void Con()
	{
		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webalk?serverTimezone=UTC", "root",
					"ascent");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	public void Select()
	{
		String selection="Select * from Cats where Age>1";
		String a="";
		try 
		{
			Con();
			s = con.createStatement();
			rs = s.executeQuery(selection);
			while (rs.next()) {
				
				a=rs.getString("name");
				result.add(a);
				a=null;
				a=rs.getString("breed");
				result.add(a);
				a=null;
				a=String.valueOf(rs.getInt("age"));
				result.add(a);
				a=null;
				a=rs.getString("owner");
				result.add(a);
				a=null;
			}

		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void out()
	{
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
			
		}
	}
	public void Insert()
	{
		String insert="INSERT INTO cats values (11,'Sanyi','Hazi cica',7,'Kiss Zoltan')";
		Con();
		try {
			s.execute(insert);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void update()
	{
		String selection="update cats set owner=Piros Ferenc where breed like'%Sziami%'";
		try {
			Con();
			s.execute(selection);
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void Delete(String owner,String cat)
	{
		 
		 
		String delete ="delete from cats where owner like'%"+owner+"%' && name like'%"+cat+"%'";
		try {
			s.execute(delete);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
