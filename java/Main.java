import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        IDatasource dataSource = chooseDatabase();
        dataSource.isConnected();
        //dataSource.createDataBase("mysql_test");
        //dataSource.createTable("users");
        //dataSource.insertIntoUsers( 27,"Iura",643);
        //dataSource.updateTabelUsers();
        //dataSource.getDateFromTabelUsers();
        //dataSource.deleteDateFromTabelUsers();
        //dataSource.dropTabel("users");
    }

    public static IDatasource chooseDatabase() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Alegeti serverul cu care doriti sa lucrati:\n1. mysql\n2. mssql\n3. postgres");
        int server = Integer.parseInt(reader.readLine());
        if (server == 1) {
            return new MysqlDatasource();
        } else if (server == 2) {
            return new MssqlDatasource();
        } else if (server == 3) {
            return new PostgresDatasource();
        } else {
            throw new IllegalArgumentException("Incorrect db selected");
        }
    }
}

//IDatasource baxi = new MysqlDatasource();
// IDatasource rex = new MssqlDatasource();
//baxi.isConnected();
//baxi.createTabel("Friends");
//baxi.insertInto(name,surname,age,country);
//baxi.getDateFromTabel("Friends");
//baxi.updateTabel("Friends");
//baxi.deleteDateFromTabel("Friends");
//baxi.dropTabel("Friends");
// < ---------------------------------------------------------------------------------  >
//rex.isConnected();
//rex.createTabel("Friends");
//rex.getDateFromTabel("Friends");
//rex.updateTabel("Friends");
//rex.deleteDateFromTabel("Friends");
//rex.insertInto(name,surname,age,country);
//rex.dropTabel("Friends");


