package Department;

import db.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DepartmentUpdate {
    public static void main(String[] args) throws  Exception {
        Scanner sc = new Scanner(System.in);
        String sql = "update department " +
                "set department_name =? where department_id =?  ";

        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        System.out.print("Enter the department ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the new department name: ");
        String Department = sc.nextLine();
        ps.setString(1,Department);
        ps.setInt(2,id);
        int rows=ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Department updated successfully.");
        } else {
            System.out.println("Department ID not found.");
        }        ps.close();
        con.close();
    }
}
