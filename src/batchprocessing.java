import java.sql.*;
import java.util.Scanner;

public class batchprocessing {
    private static final String url = "jdbc:postgresql://localhost:5432/mydb";
    private static final String username = "postgres";
    private static final String password = "Rinki12";
    public static void main(String[] args) throws Exception{
        //for load driver
        Class.forName("org.postgresql.Driver");
        // make connection with database
        Connection con = DriverManager.getConnection(url, username,password);
        // insert query with placeholder
        String query = "insert into database(emp_id,name,position,hire_date,salary,department) values(?,?,?,?,?,?)";
        // prepared statement
        PreparedStatement ps = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        // infinite loop for multiple record
        while(true){
            System.out.println("Enter emp_id = ");
            int emp_id = sc.nextInt();
            System.out.println("enter name = ");
            String name = sc.next();
            System.out.println("enter position = ");
            String position = sc.next();
            System.out.println("hire_date = ");
            String date = sc.next();
            //convert string date into SQL date
            Date date1;
            try{
                date1 = Date.valueOf(date);
            } catch (Exception e) {
                System.out.println("wrong date format");
                continue;
            }
            System.out.println("salary = ");
            Float salary = sc.nextFloat();
            sc.nextLine();  // for clear buffer
            System.out.println("department = ");
            String department = sc.nextLine();

            // set placeholder value
            ps.setInt(1,emp_id);
            ps.setString(2,name);
            ps.setString(3, position);
            ps.setDate(4, date1);
            ps.setFloat(5, salary);
            ps.setString(6, department);

            // add query in batch
            ps.addBatch();
            // check you want to insert more data or not
            System.out.println("Enter more data(Y/N) ");
            String choice = sc.next();
            if(choice.toUpperCase().equals("N")){
                break;
            }

        }
        // for execute batch
        int arr[] = ps.executeBatch();
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 0) {
                System.out.println("query " + i + "not executed successfully");
            }
        }

    }
}
