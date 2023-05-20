import java.util.List;

public interface UserDAO {

    User add(User user);

    User getById(int id);

    List<User> getAllUser();

    User updateUser(User user);

    void deleteUser(User user);
}
