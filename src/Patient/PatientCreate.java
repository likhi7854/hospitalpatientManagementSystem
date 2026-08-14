package Patient;

import db.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PatientCreate  {
      public static void main(String[] args) throws Exception{


            String sql = """
                            CREATE TABLE if not exists patient (
                                                patient_id INT AUTO_INCREMENT PRIMARY KEY,
                                                patient_name VARCHAR(100) NOT NULL,
                                                age INT NOT NULL,
                                                gender CHAR(1) NOT NULL,
                                                phone VARCHAR(15),
                                                address VARCHAR(200),
                                                date_of_birth DATE,
                                                CHECK (gender IN ('M', 'F', 'O'))
                                            )
                    """;
            Connection con = DataBase.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            con.close();
      }

}
