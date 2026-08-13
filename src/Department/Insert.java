package Department;

import db.DateBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Insert {
     public static void main(String[] args) throws  Exception {
          String sql = "insert into department (department_name) values (?)";

          Connection con = DateBase.getConnection();
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1,"Cardiology");
          ps.executeUpdate();
          ps.close();
          con.close();
     }

}
