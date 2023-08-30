package aplicacao;

import DAO.ConexaoHibernate;
import dominio.Ator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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

    public static List<Ator> getLista(){
        try (Session session = ConexaoHibernate.getSessionFactory().openSession()) {
            return session.createQuery("FROM Ator", Ator.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static Ator getAtorById(int id) {
        try (Session session = ConexaoHibernate.getSessionFactory().openSession()) {
            return session.get(Ator.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void deletarAtor(int id) {
        try (Session session = ConexaoHibernate.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Ator ator = session.get(Ator.class, id);
            if (ator != null) {
                session.delete(ator);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void atualizarAtor(Ator ator) {
        try (Session session = ConexaoHibernate.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(ator);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
