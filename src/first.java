import java.sql.*;
public class first {
    private static final String url = "jdbc:postgresql://localhost:5432/mydb";
    private static final String username = "postgres";
    private static final String password = "Rinki12";

    public static void main(String[] args) {
       try{
           Class.forName("org.postgresql.Driver");
       }catch (ClassNotFoundException e){
           System.out.println(e.getMessage());
       }

      try{
          Connection connection = DriverManager.getConnection(url,username,password);
          Statement statement = connection.createStatement();
          String query = "SELECT* FROM database";
          ResultSet rs = statement.executeQuery(query);
          while (rs.next()){
              int emp_id = rs.getInt("emp_id");
              String name = rs.getString("name");
              String position = rs.getString("position");
              System.out.println("id = "+emp_id+ " " + "name = " + name + " " + "position " + position);

          }
      }catch (SQLException e){
          System.out.println(e.getMessage());
      }
    }
}