import java.sql.*;

public class MysqlDatasource implements IDatasource {
    private final String host = "localhost";
    private final String port = "3306";
    private final String dbName = "mysql_test";
    private final String user = "root";
    private final String password = "02012000Artur";

    Connection dbConn = null;

    @Override
    public Connection getdbconnection() throws ClassNotFoundException, SQLException {
        String conn_str = "jdbc:mysql://" + host + ":" + port + "/" + dbName +
                "?characterEncoding=UTF-8&useLegacyDatetimeCode=false&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConn = DriverManager.getConnection(conn_str, user, password);
        return dbConn;
    }

    @Override
    public void isConnected() throws SQLException, ClassNotFoundException {
        dbConn = getdbconnection();
        System.out.print(dbConn.isValid(1000));
        System.out.println(" mysql is connected ");
    }

    @Override
    public void createTable(String tabelName) throws SQLException, ClassNotFoundException {
        String str = "CREATE TABLE IF NOT EXISTS " + tabelName
                + "(id INT AUTO_INCREMENT PRIMARY KEY, age INT (11), name VARCHAR (50),price INT(11))"
                + " ENGINE=MYISAM";
        Statement statement = getdbconnection().createStatement();
        statement.executeUpdate(str);
        System.out.println("The tabel " + tabelName +" was created in mysql");

    }

    @Override
    public void insertIntoUsers(int age ,String name, int price) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO users (age ,name ,price) VALUES (?, ?, ?)";
        PreparedStatement prSt = getdbconnection().prepareStatement(sql);
        prSt.setInt(1, age);
        prSt.setString(2, name);
        prSt.setInt(3, price);


        prSt.executeUpdate();
        System.out.println("The value was insert in the DB " + dbName + " ; Server mysql");
    }

    @Override
    public void getDateFromTabelUsers() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM users WHERE id = 1 ORDER BY id ASC";

        Statement statement = getdbconnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            System.out.println(res.getString("firstName"));
            System.out.println(res.getString("lastName"));
            System.out.println(res.getInt("age"));
            System.out.println(res.getString("country"));
            System.out.println(" ");
        }
    }

    @Override
    public void updateTabelUsers() throws SQLException, ClassNotFoundException {
        String sql = "UPDATE users SET price = ? WHERE id = 5";
        PreparedStatement prSt = getdbconnection().prepareStatement(sql);
        prSt.setString(1, "300");

        prSt.executeUpdate();
        System.out.println("The value was update in the DB " + dbName + " ; Server mysql");
    }

    @Override
    public void deleteDateFromTabelUsers() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM users WHERE id = 1";
        Statement statement = getdbconnection().createStatement();
        statement.executeUpdate(sql);
        System.out.println("The date was deleted: tabel users ; Server mysql ");
    }

    @Override
    public void dropTabel(String tabelName) throws SQLException, ClassNotFoundException {
        String sql = "DROP TABLE " + tabelName;
        Statement statement = getdbconnection().createStatement();
        statement.executeUpdate(sql);
        System.out.println("The table " + tabelName + " was deleted");
    }

    @Override
    public void createDataBase(String databaseName) throws SQLException, ClassNotFoundException {
        String sql = "CREATE DATABASE " + databaseName;
        Statement statement = getdbconnection().createStatement();
        statement.executeUpdate(sql);
        System.out.println("The database " + databaseName + " was created in mysql");
    }


}

