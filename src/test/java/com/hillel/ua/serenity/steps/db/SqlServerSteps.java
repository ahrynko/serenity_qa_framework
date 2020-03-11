package com.hillel.ua.serenity.steps.db;

import com.hillel.ua.db.DataBaseUtils;
import com.hillel.ua.db.dto.Student;
import com.hillel.ua.db.dto.User;
import org.junit.Test;
import java.util.Map;
import java.util.List;

public class SqlServerSteps {

    @Test
    public void verifySqlQueryExecution() {
      /*  final String query = "insert into [dbo].[hillel_students]" +
                "([LastName], [FirstName], [Age], [Address], [City]) " +
                "values ('Shcherbina', 'Denys', '22', 'Bankova str, 45', 'Kyiv')"; */

        final String selectStudentsQuery = "select * from hillel_students";
        final String selectUsersQuery = "select * from [hillel-database].dbo.[User]";
      /*  DataBaseUtils.executeQuery(query); */
      /*  final List<Map<String, String>> results = DataBaseUtils.executeRetrieve(selectQuery); */
        final List<Student> students = DataBaseUtils.executeRetrieveAsListObjects(selectStudentsQuery, Student.class);
        final List<User> users = DataBaseUtils.executeRetrieveAsListObjects(selectUsersQuery, User.class);
    }
}
