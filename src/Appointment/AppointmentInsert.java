package Appointment;


import db.DataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.Scanner;

public class AppointmentInsert {
    public static void main(String[] args) throws  Exception{
        Scanner sc = new Scanner(System.in);

        String sql = """
                INSERT INTO Appointment
                (patient_id, doctor_id, appointment_date,
                 appointment_time, reason)
                VALUES (?, ?, ?, ?, ?)
                """;

        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();

        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter Appointment Date (yyyy-MM-dd): ");
        String date = sc.nextLine();

        System.out.print("Enter Appointment Time (HH:mm:ss): ");
        String time = sc.nextLine();

        System.out.print("Enter Reason: ");
        String reason = sc.nextLine();

        ps.setInt(1, patientId);
        ps.setInt(2, doctorId);
        ps.setDate(3, Date.valueOf(date));
        ps.setTime(4, Time.valueOf(time));
        ps.setString(5, reason);
        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Appointment inserted successfully.");
        } else {
            System.out.println("Appointment insertion failed.");
        }

        ps.close();
        con.close();
        sc.close();


    }
}
