import java.sql.*;
public class insert {
    private static final String url = "jdbc:postgresql://localhost:5432/mydb";
    private static final String username = "postgres";
    private static final String password = "Rinki12";
    public static void main(String[] args) throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url,username,password);
        Statement stm = con.createStatement();
        String query = "INSERT INTO database(emp_id, name, position, hire_date, salary," +
                " department) VALUES(107, 'siya','data analyst','2026-08-09',45000, 'CSE')";
        int resultAffected = stm.executeUpdate(query);
        if(resultAffected>0){
            System.out.println("Insert successfully");
        }
        else{
            System.out.println("data not affected");
        }



    }
}
