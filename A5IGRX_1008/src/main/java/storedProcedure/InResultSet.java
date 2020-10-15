package storedProcedure;



import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import CRUD.Select;

public class InResultSet {
	static Select s = new Select();
	
	public void get_cats()
	{
		s.Con();
		try {
			CallableStatement a=s.con.prepareCall("{call get_cats(?)}");
			a.setString(1, "Főni");
			ResultSet rs = a.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+String.valueOf(rs.getInt(4))+rs.getString(5)+rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void mod_owner()
	{
		s.Con();
		try {
			CallableStatement cs = s.con.prepareCall("{call mod_owner(?,?)}");
			cs.setString("Sanyi", "Perzsa");
			ResultSet rs = cs.executeQuery();
			System.out.println("Átírva");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
