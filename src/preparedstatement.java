import java.sql.*;
public class preparedstatement {
    private static final String url = "jdbc:postgresql://localhost:5432/mydb";
    private static final String username = "postgres";
    private static final String password = "Rinki12";
    public static void main(String[] args) throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        String query = "INSERT INTO database(emp_id, name, position, hire_date, salary," +
                " department) VALUES(?, ?, ?, ?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,108);
        ps.setString(2,"ankita");
        ps.setString(3, "manager");
        ps.setDate(4, Date.valueOf("2026-09-07"));
        ps.setFloat(5, 660000);
        ps.setString(6, "HR");
         int rowsaffected= ps.executeUpdate();
         if(rowsaffected>0){
             System.out.println("Insert successfully");
         }
         else{
             System.out.println("data not affected");
         }




    }
}
