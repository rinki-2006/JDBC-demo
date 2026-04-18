import java.sql.*;

public class delete {
    private static final String url = "jdbc:postgresql://localhost:5432/mydb";
    private static final String username = "postgres";
    private static final String password = "Rinki12";
    public static void main(String[] args) throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url,username,password);
        Statement stm = con.createStatement();
        String query = "DELETE from database where emp_id = 104";
        int resultAffected = stm.executeUpdate(query);
       String query2 = "SELECT*FROM database";
       ResultSet rs = stm.executeQuery(query2);
       while(rs.next()){
           int emp_id = rs.getInt("emp_id");
           String name = rs.getString("name");
           String position = rs.getString("position");
           System.out.println("id = "+emp_id+ " " + "name = " + name + " " + "position " + position);

       }
    }
}
