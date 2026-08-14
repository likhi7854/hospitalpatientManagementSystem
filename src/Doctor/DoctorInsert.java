package Doctor;

import db.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DoctorInsert {
     public static void main(String[] args) throws Exception {
         Scanner sc = new Scanner(System.in);
           String sql = """
                            Insert into doctor (Doctor_name,Gender,Specialization,Email_id,phone,experience,consultation_fee,department_id ) 
                            value(?,?,?,?,?,?,?,?)
                      """;

         Connection con = DataBase.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         System.out.print("Enter the Doctor Name: ");
         String name = sc.nextLine();
         System.out.print("Enter the Gender of the Doctor: ");
         String Gender = sc.next();
         System.out.print("Enter the Specialization: ");
         String Specialization = sc.next();
         System.out.print("Enter the eMailId: ");
         String eMail = sc.next();
         System.out.print("Enter the Phone number: ");
         String PhnNum = sc.next();
         System.out.print("Experience: ");
         int Exp = sc.nextInt();
         System.out.print("consultation_fee of the doctor: ");
         double fee = sc.nextDouble();
         System.out.print("Enter Department ID: ");
         int departmentId = sc.nextInt();




         ps.setString(1,name);
         ps.setString(2,Gender);
         ps.setString(3,Specialization);
         ps.setString(4,eMail);
         ps.setString(5, PhnNum );
         ps.setInt(6,Exp);
         ps.setDouble(7,fee);
         ps.setInt(8,departmentId);
         ps.executeUpdate();
         con.close();
     }
}
