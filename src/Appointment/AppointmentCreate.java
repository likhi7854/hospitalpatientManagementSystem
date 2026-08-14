package Appointment;

import db.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AppointmentCreate {
     public static void main(String[] args)  throws Exception{
        String sql =  """
               CREATE TABLE IF NOT EXISTS Appointment (
                   appointment_id INT AUTO_INCREMENT PRIMARY KEY,
                   patient_id INT NOT NULL,
                   doctor_id INT NOT NULL,
                   appointment_date DATE,
                   appointment_time TIME,
                   reason VARCHAR(200),
                   FOREIGN KEY (patient_id)
                       REFERENCES Patient(patient_id),
                   FOREIGN KEY (doctor_id)
                       REFERENCES Doctor(doctor_id)
               )
               """;
         Connection con = DataBase.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);

         ps.executeUpdate();

         System.out.println("Appointment table created successfully.");

         ps.close();
         con.close();
    }
}
