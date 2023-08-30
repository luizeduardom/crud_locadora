package aplicacao;

import DAO.ConexaoHibernate;
import dominio.Ator;
import dominio.Classe;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClasseDAO {

    public ClasseDAO() {
    }

    public static void addClasse(Classe classe) {
        Transaction transaction = null;
        try (Session session = ConexaoHibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(classe);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static List<Classe> getLista(){
        try (Session session = ConexaoHibernate.getSessionFactory().openSession()) {
            return session.createQuery("FROM Classe", Classe.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static Classe getClasseById(int id) {
        try (Session session = ConexaoHibernate.getSessionFactory().openSession()) {
            return session.get(Classe.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void deletarClasse(int id) {
        try (Session session = ConexaoHibernate.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Classe classe = session.get(Classe.class, id);
            if (classe != null) {
                session.delete(classe);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void atualizarClasse(Classe classe) {
        try (Session session = ConexaoHibernate.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(classe);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
