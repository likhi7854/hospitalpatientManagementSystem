package Doctor;

import db.DateBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class View {
      public static void main(String[] args) {
          String sql = "Select * from doctor";
          try {
              Connection con = DateBase.getConnection();
              PreparedStatement ps = con.prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
              while (rs.next()){
                  int doctorId = rs.getInt("doctor_id");
                  String doctorName = rs.getString("doctor_name");
                  String gender = rs.getString("gender");
                  String specialization = rs.getString("specialization");
                  String email = rs.getString("Email_id");
                  String phone = rs.getString("phone");
                  int departmentId = rs.getInt("department_id");
                  int experience = rs.getInt("experience");
                  double consultationFee = rs.getDouble("consultation_fee");

                  System.out.println("Doctor ID: " + doctorId);
                  System.out.println("Doctor Name: " + doctorName);
                  System.out.println("Gender: " + gender);
                  System.out.println("Specialization: " + specialization);
                  System.out.println("Email: " + email);
                  System.out.println("Phone: " + phone);
                  System.out.println("Department ID: " + departmentId);
                  System.out.println("Experience: " + experience + " years");
                  System.out.println("Consultation Fee: " + consultationFee);
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
