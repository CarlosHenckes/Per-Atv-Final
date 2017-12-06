package br.com.fiap.helper;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Professor;

public class HelperMatricula {
	private EntityManager em;

	public HelperMatricula(EntityManager em){
		this.em = em;
	}
	
	public void salvar(Professor professor){
		try{
			em.getTransaction().begin();
			em.persist(professor);
			em.getTransaction().commit();
		}catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}
}
