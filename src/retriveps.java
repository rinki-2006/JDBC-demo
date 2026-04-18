import java.io.PushbackReader;
import java.sql.*;
public class retriveps {
    private static final String url = "jdbc:postgresql://localhost:5432/mydb";
    private static final String username = "postgres";
    private static final String password = "Rinki12";
    public static void main(String[] args) throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        String query = "SELECT name FROM database WHERE emp_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,108);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            String name = rs.getString("name");
            System.out.println(name);
        }
        else{
            System.out.println("name not found");
        }

    }
}
