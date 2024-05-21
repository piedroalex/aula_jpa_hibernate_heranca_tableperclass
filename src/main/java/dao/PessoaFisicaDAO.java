package dao;

import javax.persistence.EntityManager;

import entities.PessoaFisica;
import util.HibernateUtil;

/**
 * @author Pedro Alex
 */
public class PessoaFisicaDAO {

	public void salvar(PessoaFisica pessoa) {
    	EntityManager entityManager = HibernateUtil.getEntityManager();
    	try {
	    	entityManager.getTransaction().begin();
	    	entityManager.persist(pessoa);
	    	entityManager.getTransaction().commit();
	    	System.out.println("Pessoa física salva com sucesso!");
    	} catch (Exception e) {
        	entityManager.getTransaction().rollback();
	    	System.out.println("Erro ao salvar a pessoa física!");
            e.printStackTrace();
        } finally {
        	entityManager.close();			
		}
	}
	
}
