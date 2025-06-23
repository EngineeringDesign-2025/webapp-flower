package design;
 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
public class FlowerDAO {
 
    // DB接続情報（適宜変更）
    private static final String URL = "jdbc:mysql://localhost:3306/db_dev";
    private static final String USER = "dev";
    private static final String PASS = "dev";
 
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
 
    // 全ての植木鉢情報を取得
    public static List<Flower> getAllFlowers() {
        List<Flower> list = new ArrayList<>();
        String sql = "SELECT * FROM Flowers ORDER BY id";
 
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
 
            while (rs.next()) {
                Flower f = new Flower();
                f.setId(rs.getInt("id"));
                f.setName(rs.getString("name"));
                f.setLevel(rs.getInt("level"));
                f.setLast_Datetime(rs.getTimestamp("last_datatime"));
                list.add(f);
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
 
    // IDで植木鉢を取得
    public static Flower getFlowerById(int id) {
        Flower f = null;
        String sql = "SELECT * FROM Flowers WHERE id = ?";
 
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    f = new Flower();
                    f.setId(rs.getInt("id"));
                    f.setName(rs.getString("name"));
                    f.setLevel(rs.getInt("level"));
                    f.setLast_Datetime(rs.getTimestamp("last_datatime"));
                }
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }
}
