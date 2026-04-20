import java.sql.*;
import java.util.Scanner;

public class transactionhandling {
    private static final String url = "jdbc:postgresql://localhost:5432/transaction";
    private static final String username = "postgres";
    private static final String password = "Rinki12";
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, username,password);
        con.setAutoCommit(false);
        String debit_query = "UPDATE accounts SET balance = balance-? WHERE account_no = ?";
        String credit_query = "UPDATE accounts SET balance = balance + ? WHERE account_no = ?";

        PreparedStatement dps = con.prepareStatement(debit_query);
        PreparedStatement cps = con.prepareStatement(credit_query);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount = ");
        int amount  = sc.nextInt();
        System.out.println("Enter account_no = ");
        int account_no  = sc.nextInt();
        dps.setFloat(1,amount);
        dps.setInt(2,account_no);
        cps.setFloat(1,amount);
        cps.setInt(2,102);

        int rowsAffected = dps.executeUpdate();
        int rowAffected2 = cps.executeUpdate();

        if(isSufficient(con, amount, account_no)){
            con.commit();
            System.out.println("Transaction successfully");
        }
        else{
            con.rollback();
            System.out.println("Transaction failed");
        }
    }
    static boolean isSufficient(Connection con, int amount, int account_no){
        try{
            String query = "SELECT balance from accounts WHERE account_no = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,account_no);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                double current_balance = rs.getDouble("balance");
                if(amount>current_balance){
                    return false;
                }
                else{
                    return true;
                }
            }


        }catch (SQLException e){
            System.out.println(e);
        }
        return false;
    }
}
