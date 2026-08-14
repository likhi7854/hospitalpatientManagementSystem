package Doctor;

import db.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DoctorDelete {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String sql = "delete from Doctor  where doctor_id =?";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        System.out.print("Enter the doctor_id to delete: ");
        int id = sc.nextInt();
        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Doctor deleted successfully.");
        } else {
            System.out.println("Doctor  ID not found.");
        }

        ps.close();
        con.close();
        sc.close();
    }
}
