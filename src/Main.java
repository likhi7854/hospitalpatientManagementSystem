
import db.DateBase;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        try {
            Connection con = DateBase.getConnection();

            System.out.println("Database connected successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}