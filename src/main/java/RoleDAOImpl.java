import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoleDAOImpl implements RoleDAO {
        @Override
        public Role add(Role role) {
            try(Session session = HibernateUtil.getSessionFactory().openSession()){
                Transaction transaction = session.beginTransaction();
                session.persist(role);
                transaction.commit();
                session.close();
            }
            return role;
        }

        @Override
        public List<Role> getAll() {
            return null;
        }

        @Override
        public Role getById(int id) {
            try(Session session = HibernateUtil.getSessionFactory().openSession()){
                return session.get(Role.class, id);
            }
        }

        @Override
        public Role update(Role role, int id) {
            return null;
        }

        @Override
        public void remove(Role role) {

        }

        @Override
        public List <Role> getAllRoles() {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.createQuery("FROM Role").list();
            }
        }

        @Override
        public void deleteRole(Role role) {
            try(Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(role);
                transaction.commit();
                session.close();
            }
        }
    }
