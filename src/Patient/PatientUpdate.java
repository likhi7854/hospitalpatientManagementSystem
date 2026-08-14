package Patient;

import db.DataBase;
import  java.util.Scanner;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class PatientUpdate {
    public static void main(String[] args) throws  Exception{

        String sql = """
                     update patient 
                     set patient_name =?,
                     age=?,
                     gender=?,
                     phone=?,
                    address =?,
                     date_of_birth=?
                  
                     where patient_id =?
            
                """;
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Patient ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
        String dob = sc.nextLine();

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, gender);
        ps.setString(4, phone);
        ps.setString(5, address);
        ps.setDate(6, Date.valueOf(dob));
        ps.setInt(7, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Patient updated successfully.");
        } else {
            System.out.println("Patient ID not found.");
        }

        ps.close();
        con.close();
    }
}
