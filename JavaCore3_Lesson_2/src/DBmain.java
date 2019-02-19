import java.sql.*;

public class DBmain {
    private static Connection connection;
    private static Statement smnt;
    private static PreparedStatement psmnt;
    public static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        smnt = connection.createStatement();

    }
    public static void disconnect () {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void clearDB(){
        try {
            smnt.execute("DELETE FROM product");
            System.out.println("Таблица очищена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createTable() throws SQLException {
        smnt.execute("CREATE TABLE  IF NOT EXISTS product (\n" +
                "    id     INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                   NOT NULL,\n" +
                "    prodid INTEGER UNIQUE\n" +
                "                   NOT NULL,\n" +
                "    title  TEXT    NOT NULL,\n" +
                "    cost   INTEGER NOT NULL\n" +
                ");");

        System.out.println("Таблица создана");
    }

    public static void fillingTable() throws SQLException {
        psmnt = connection.prepareStatement("INSERT INTO  product (prodid, title, cost) VALUES (?, ?, ?)");

        for (int i = 1; i <=10000 ; i++) {
            psmnt.setInt(1,i);
            psmnt.setString(2, "товар" + i);
            psmnt.setInt(3, i*10);
            psmnt.addBatch();
        }
        connection.setAutoCommit(false);
        psmnt.executeBatch();
        connection.setAutoCommit(true);
        System.out.println("Таблица заполнена");
    }
    public static void dropTable() throws SQLException {
        smnt.execute("DROP TABLE  IF EXISTS product");
    }


}

