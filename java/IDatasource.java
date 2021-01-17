import java.sql.Connection;
import java.sql.SQLException;

public interface IDatasource {
    Connection getdbconnection() throws ClassNotFoundException, SQLException;

    void isConnected() throws SQLException, ClassNotFoundException;

    void createTable(String tableName) throws SQLException, ClassNotFoundException;

    void insertIntoUsers(int age ,String name, int price) throws SQLException, ClassNotFoundException;

    void getDateFromTabelUsers() throws SQLException, ClassNotFoundException;

    void updateTabelUsers() throws SQLException, ClassNotFoundException;

    void deleteDateFromTabelUsers() throws SQLException, ClassNotFoundException;

    void dropTabel(String tabelName) throws SQLException, ClassNotFoundException;

    void createDataBase(String databaseName) throws SQLException, ClassNotFoundException;

}





