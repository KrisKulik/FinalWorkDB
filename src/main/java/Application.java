public class Application {
    public static void main(String[] args) {

        Role developer = Role.builder().role(RoleType.DEVELOPER).build();
        Role analyst = Role.builder().role(RoleType.ANALYST).build();
        Role tester = Role.builder().role(RoleType.TESTER).build();
        Role manager = Role.builder().role(RoleType.MANAGER).build();
        Role designer = Role.builder().role(RoleType.DESIGNER).build();

        RoleDAO roleDAO = new RoleDAOImpl();

        roleDAO.add(developer);
        roleDAO.add(analyst);
        roleDAO.add(tester);
        roleDAO.add(manager);
        roleDAO.add(designer);

    }
}
