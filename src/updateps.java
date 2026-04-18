import java.sql.*;
public class updateps {
    private static final String url = "jdbc:postgresql://localhost:5432/mydb";
    private static final String username = "postgres";
    private static final String password = "Rinki12";
    public static void main(String[] args) throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        String query = "UPDATE database SET salary = ? WHERE emp_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, 70000);
        ps.setInt(2, 108);
        int rowsAffected = ps.executeUpdate();
        if(rowsAffected>0){
            System.out.println("update successfully");
        }
        else{
            System.out.println("data not affectecd");
        }

    }
}
