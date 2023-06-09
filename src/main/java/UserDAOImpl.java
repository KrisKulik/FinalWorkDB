import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOImpl implements UserDAO {
        @Override
        public User add(User user) {
            try(Session session = HibernateUtil.getSessionFactory().openSession()){
                Transaction transaction = session.beginTransaction();
                session.persist(user);
                transaction.commit();
            }
            return user;
        }

        @Override
        public User getById(int id) {
            try(Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.get(User.class,id);
            }
        }

        @Override
        public List<User> getAllUser() {
            try(Session session = HibernateUtil.getSessionFactory().openSession()){
                return session.createQuery("FROM User").list();
            }
        }

        @Override
        public User updateUser(User user) {
            User update;
            try(Session session = HibernateUtil.getSessionFactory().openSession()){
                Transaction transaction = session.beginTransaction();
                update = session.merge(user);
                transaction.commit();
            }
            return update;
        }

        @Override
        public void deleteUser(User user) {
            try(Session session = HibernateUtil.getSessionFactory().openSession()){
                Transaction transaction = session.beginTransaction();
                session.delete(user);
                transaction.commit();
                session.close();
            }
        }
        @Override
        public void addRoleToUser(User user, Role role) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            User updateUser = session.find(User.class, user.getId());
            Role roleToUser = session.find(Role.class, role.getId());
            updateUser.getRoles().add(roleToUser);
            transaction.commit();
            session.close();
        }
    }
    }


