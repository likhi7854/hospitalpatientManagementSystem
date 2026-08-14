package Appointment;

import db.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AppointmentDelete {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String sql =
                "DELETE FROM Appointment WHERE appointment_id = ?";

        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter Appointment ID to delete: ");
        int appointmentId = sc.nextInt();

        ps.setInt(1, appointmentId);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Appointment deleted successfully.");
        } else {
            System.out.println("Appointment ID not found.");
        }

        ps.close();
        con.close();
        sc.close();
    }
}