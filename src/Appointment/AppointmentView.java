package Appointment;

import db.DataBase;

import java.sql.*;

public class AppointmentView {

    public static void main(String[] args) {

        String sql = """
                SELECT
                    a.appointment_id,
                    p.patient_name,
                    d.doctor_name,
                    a.appointment_date,
                    a.appointment_time,
                    a.reason
                FROM Appointment a
                JOIN Patient p
                    ON a.patient_id = p.patient_id
                JOIN Doctor d
                    ON a.doctor_id = d.doctor_id
                """;

        try {
            Connection con = DataBase.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int appointmentId =
                        rs.getInt("appointment_id");

                String patientName =
                        rs.getString("patient_name");

                String doctorName =
                        rs.getString("doctor_name");

                Date appointmentDate =
                        rs.getDate("appointment_date");

                Time appointmentTime =
                        rs.getTime("appointment_time");

                String reason =
                        rs.getString("reason");

                System.out.println("Appointment ID: " + appointmentId);
                System.out.println("Patient Name: " + patientName);
                System.out.println("Doctor Name: " + doctorName);
                System.out.println("Appointment Date: " + appointmentDate);
                System.out.println("Appointment Time: " + appointmentTime);
                System.out.println("Reason: " + reason);
                System.out.println("--------------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}