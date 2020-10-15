package storedProcedure;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import CRUD.Select;

public class InParameters {
Select s = new Select();
	public void mod_owner()
	{
		s.Con();
		try {
			CallableStatement cs = s.con.prepareCall("{call mod_owner(?,?)}");
			cs.setString("Gal Dora", "Perzsa");
			ResultSet rs = cs.executeQuery();
			System.out.println("Átírva");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
