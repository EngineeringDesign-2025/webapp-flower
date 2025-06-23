package design;
 
import java.sql.Timestamp;
 
public class Flower {
    private int id;
    private String name;
    private int level;
    private Timestamp last_Datetime;
 
    // デフォルトコンストラクタ
    public Flower() {
    }
 
    // 引数付きコンストラクタ（必要に応じて）
    public Flower(int id, String name, int level, Timestamp last_Datetime) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.last_Datetime = last_Datetime;
    }
 
    // getter と setter
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getLevel() {
        return level;
    }
 
    public void setLevel(int level) {
        this.level = level;
    }
 
    public Timestamp getLast_Datetime() {
        return last_Datetime;
    }
 
    public void setLast_Datetime(Timestamp last_Datetime) {
        this.last_Datetime = last_Datetime;
    }
}