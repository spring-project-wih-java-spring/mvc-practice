package jdbctest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

public class UserDaoTest {

    @BeforeEach
    void setUp() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db_schema.sql"));
        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());
    }

    @Test
    void createTest() {
        UserDao userDao = new UserDao();
        userDao.create(new User("wizard", "pw", "name", "email"));
        User user = userDao.findByUserId("wizard");
        Assertions.assertThat(user).isEqualTo(new User("wizard", "pw", "name", "email"));
    }
}
