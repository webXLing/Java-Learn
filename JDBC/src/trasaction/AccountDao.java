package trasaction;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountDao {
    /*
     * 修改指定用户的余额
     * */
    public void updateBalance(Connection con, String name, double money) {
        try {
            String sql = "UPDATE account SET money=money+? WHERE name=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setDouble(1, money);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}