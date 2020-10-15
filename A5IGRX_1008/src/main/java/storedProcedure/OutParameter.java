package storedProcedure;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import CRUD.Select;

public class OutParameter {
	Select s = new Select();
	public void mod_owner()
	{
		s.Con();
		try {
			CallableStatement cs = s.con.prepareCall("{call count_owner(?,?)}");
			cs.setString(1, "Perzsa");
			cs.registerOutParameter(2, Types.INTEGER);
			
			 cs.execute();
			 int x = cs.getInt(2);
			 cs.close();
			System.out.println("Count"+x);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
