import java.sql.*;
public class update {
    private static final String url = "jdbc:postgresql://localhost:5432/mydb";
    private static final String username = "postgres";
    private static final String password = "Rinki12";
    public static void main(String[] args) throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url,username,password);
        Statement stm = con.createStatement();
        String query = "UPDATE database SET position = 'CSE' WHERE emp_id = 102";
        int resultAffected = stm.executeUpdate(query);
        if(resultAffected>0){
            System.out.println("update successfully");
        }
        else{
            System.out.println("data not affected");
        }
    }
}
