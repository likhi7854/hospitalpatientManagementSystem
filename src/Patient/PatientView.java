package Patient;

import db.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientView {
       public static void main(String[] args) {


        String sql ="select * from patient";
        try {
            Connection con = DataBase.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            while(rs.next()) {
                int patient_id = rs.getInt("patient_id");
                String patientName = rs.getString("patient_name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String dateOfBirth = rs.getString("date_of_birth");

                System.out.println("Patient ID: " + patient_id);
                System.out.println("Patient Name: " + patientName);
                System.out.println("Age: " + age);
                System.out.println("Gender: " + gender);
                System.out.println("Phone: " + phone);
                System.out.println("Address: " + address);
                System.out.println("Date of Birth: " + dateOfBirth);
                System.out.println("-------------------------------");
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
