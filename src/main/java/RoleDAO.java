import java.util.List;

public interface RoleDAO {
    Role add (Role role);

    List<Role> getAll();

    Role getById(int id);

    Role update(Role role, int id);

    void remove(Role role);

    List <Role> getAllRoles();

    void deleteRole(Role role);
}