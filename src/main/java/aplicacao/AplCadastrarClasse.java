package aplicacao;

import DAO.ConexaoHibernate;
import dominio.Classe;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AplCadastrarClasse {

    public static int incluirClasse(String nomeClasse) {
        if (nomeClasse.equals("")) {
            return 1;
        }
        Classe a = new Classe();
        a.setNome(nomeClasse);


        SessionFactory sessions = ConexaoHibernate.getSessionFactory();
        Session session = sessions.openSession();

        Transaction t = null;

        try {
            t = session.beginTransaction();
            session.save(a);
            t.commit();
            return 4;
        }catch (HibernateException he) {
            t.rollback();
            return 2;
        }catch (Exception e) {
            t.rollback();
            return 3;
        }finally {
            session.close();
        }

    }

}
