package Doctor;

import db.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DoctorCreate {
    public static void main(String[] args) throws Exception {
        String sql = """
                        create table if not exists Doctor(
                             Doctor_id int AUTO_INCREMENT primary key,
                             Doctor_name varchar(100) NOT NULL,
                             Gender varchar(20) Not Null,
                             Specialization Varchar(20) Not Null,
                             Email_id  Varchar(150) Unique,
                             phone varchar(15) unique,
                             department_id int Not null,
                             experience int  Not null,
                             consultation_fee DECIMAL(10,2) NOT NULL,
                             FOREIGN KEY (department_id) references Department(department_id)
          
                        )
                   """;
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        con.close();
    }
}
