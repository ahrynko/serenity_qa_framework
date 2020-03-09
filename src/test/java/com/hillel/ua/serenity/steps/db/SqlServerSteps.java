package com.hillel.ua.serenity.steps.db;

import com.hillel.ua.db.DataBaseUtils;
import org.junit.Test;
import java.util.Map;
import java.util.List;

public class SqlServerSteps {

    @Test
    public void verifySqlQueryExecution() {
      /*  final String query = "insert into [dbo].[hillel_students]" +
                "([LastName], [FirstName], [Age], [Address], [City]) " +
                "values ('Shcherbina', 'Denys', '22', 'Bankova str, 45', 'Kyiv')"; */

        final String selectQuery = "select * from hillel_students";
      /*  DataBaseUtils.executeQuery(query); */
        final List<Map<String, String>> results = DataBaseUtils.executeRetrieve(selectQuery);
    }
}
