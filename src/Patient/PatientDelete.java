package Patient;

import db.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PatientDelete {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String sql ="delete from patient where patient_id =?";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        System.out.print("Enter the patient_id to delete: ");
        int id = sc.nextInt();
        ps.setInt(1,id);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Patient deleted successfully.");
        } else {
            System.out.println("Patient ID not found.");
        }

        ps.close();
        con.close();
        sc.close();



    }
}
