import org.example.db.DBUtils;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class JDBC {

    @Test
    public void testFetchAllFromUsers() {
        //create the connection to db
        DBUtils.createConnection();

        //save the query result as a list of maps(just like we did together)
        List<Map<String, Object>> queryData = DBUtils.getQueryResultMap("Select * from users");

        //printing the result
        for (Map<String, Object> row : queryData) {
            System.out.println(row);
        }

        //close connection
        DBUtils.destroy();

    }
}
