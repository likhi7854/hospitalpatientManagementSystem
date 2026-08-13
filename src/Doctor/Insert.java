package Doctor;

import db.DateBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Insert {
     public static void main(String[] args) throws Exception {
           String sql = """
                            Insert into doctor (Doctor_name,Gender,Specialization,Email_id,phone,experience,consultation_fee,department_id ) 
                            value(?,?,?,?,?,?,?,?)
                      """;

         Connection con = DateBase.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1,"Dr.Likhitha");
         ps.setString(2,"Female");
         ps.setString(3,"Cardiology");
         ps.setString(4,"Likhitha141523@gmail.com");
         ps.setString(5,"9857472728");
         ps.setInt(6,4);
         ps.setDouble(7,500.00);
         ps.setInt(8,3);
         ps.executeUpdate();
         con.close();
     }
}
