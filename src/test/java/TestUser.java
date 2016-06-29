import com.slavyanin.dao.UsersDao;
import com.slavyanin.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@ContextConfiguration("/spring/spring-context.xml")
public class TestUser extends AbstractJUnit4SpringContextTests {

    @Autowired
    private UsersDao usersDao;

    @Test
    public void testInsertFind() {
        // Создать тестовый объект
        User user = new User();
        user.setName("monty");
        user.setEmail("monty@python.org");
        user.setPassword("12345");


        // Сохранить тестовый объект в базе данных
        Long id = usersDao.insert(user);
        // Вытащить тестовый объект из базы данных
        User userFromDb = usersDao.findById(id);

        // Сравнить вытащенный объект из базы данных с тестовым объектом
        assertEquals(user, userFromDb);

        // Удалить тестовый объект из базы данных
        usersDao.delete(userFromDb);
    }

    @Test
    public void testInsertFindUpdate() {
        // Создать тестовый объект
        User user = new User();
        user.setName("monty");
        user.setEmail("monty@python.org");
        user.setPassword("12345");


        // Сохранить тестовый объект в базе данных
        Long id = usersDao.insert(user);

        // Вытащить тестовый объект из базы данных
        User userFromDb = usersDao.findById(id);

        // Обновить в вытащенном объекте поле name
        userFromDb.setName("changed Name");
        // Записать обновленый тестовый объект в базу данных
        usersDao.update(userFromDb);
        // После обновления повторно вытащить тестовый объект из базы данных
        User updatedUserFromDb = usersDao.findById(userFromDb.getId());

        // Сравнить тестовый обновленный объект с повторно вытащенным
        assertEquals(userFromDb, updatedUserFromDb);

        // Удалить тестовый объект из базы данных
        usersDao.delete(updatedUserFromDb);
    }

    @Test
    public void testDelete() {
        // Создать тестовый объект
        User user = new User();
        user.setName("monty_test");
        user.setEmail("monty_test@python.org");
        user.setPassword("12345");


        // Сохранить тестовый объект в базе данных
        Long id = usersDao.insert(user);
        // Вытащить тестовый объект из базы данных
        User userToDelete = usersDao.findById(id);
        // Удалить тестовый объект из базы данных
        usersDao.delete(userToDelete);
        // Найти удаленный объект в базе данных
        User userAfterDeleting = usersDao.findById(id);

        // Сравнить вытащенный объект после удаления из базы данных на null
        assertNull(userAfterDeleting);
    }
}
