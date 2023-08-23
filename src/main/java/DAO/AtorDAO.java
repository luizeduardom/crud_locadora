package DAO;
import dominio.Ator;
import org.hibernate.*;

public class AtorDAO {
    public AtorDAO() {
    }

    public static void addAtor(Ator ator) {
        Transaction transaction = null;
        try (Session session = ConexaoHibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(ator);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
