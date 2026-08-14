package Department;

import db.DataBase;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DepartmentInsert {
     public static void main(String[] args) throws  Exception {
          Scanner sc = new Scanner(System.in);
          String sql = "insert into department (department_name) values (?)";

          Connection con = DataBase.getConnection();
          PreparedStatement ps = con.prepareStatement(sql);
          System.out.print("Enter Department Name: ");
          String Department = sc.nextLine();
         ps.setString(1,Department);
          ps.executeUpdate();
          ps.close();
          con.close();
     }

}
