import java.sql.*;
import java.util.Scanner;

public class delteps {
    private static final String url = "jdbc:postgresql://localhost:5432/mydb";
    private static final String username = "postgres";
    private static final String password = "Rinki12";
    public static void main(String[] args) throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, username,password);
        Scanner sc = new Scanner(System.in);
        String query = "DELETE fROM database where emp_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        System.out.println("Enter id = ");
        int id = sc.nextInt();
        ps.setInt(1, id);
        int rowsAffectd = ps.executeUpdate();
        if(rowsAffectd>0){
            System.out.println("delete successfully");
        }
        else{
            System.out.println("data not affected");
        }


    }
}
