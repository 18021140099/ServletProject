import java.sql.*;

public class LoginDao {

    public static boolean sendDetails(String iid,String iname,String uname,String umail,String ubid,String ucheck){
        boolean status=false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auctions","lucious","u*r*good1");

            String query;
            query = " insert into auc_reg (item_id, item_name, user_name, user_mail,amt_bid,bid_auto)" + " values(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,iid);
            ps.setString(2,iname);
            ps.setString(3,uname);
            ps.setString(4,umail);
            ps.setString(5,ubid);
            ps.setString(6,ucheck);
            int rs = ps.executeUpdate();
            if(rs>0)
                status=true;
        }catch(Exception e){System.out.println(e);}
        return status;
    }
}