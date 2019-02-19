import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {
        try {
            DBmain.connection();
            DBmain.createTable();
            DBmain.clearDB();
            DBmain.fillingTable();
            DBmain.disconnect();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }




    }
}
