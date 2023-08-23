package aplicacao;

import DAO.ConexaoHibernate;
import dominio.Ator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AplCadastrarAtor {

	public static int incluirAtor(String nomeAtor) {
		if (nomeAtor.equals("")) {
			return 1;			
		}
		Ator a = new Ator();
		a.setNome(nomeAtor);
		
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
