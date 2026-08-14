package Department;

import db.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DepartmentView {
      public static void main(String[] args) {
           String sql = "Select * from department";
           try {
               Connection con = DataBase.getConnection();
               PreparedStatement ps = con.prepareStatement(sql);
               ResultSet rs = ps.executeQuery();
               while (rs.next()){
                    int id =  rs.getInt("department_id");
                    String name = rs.getString("department_name");
                   System.out.println("department_id: "+id);
                   System.out.println("Department_name: "+name);
                   System.out.println("---------------------------");
               }
               rs.close();
               ps.close();
               con.close();
           }
           catch (Exception e){
               e.printStackTrace();
           }
      }
}
