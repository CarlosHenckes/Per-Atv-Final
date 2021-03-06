package br.com.fiap.helper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Professor;

public class HelperMatricula {
	private EntityManager em;

	public HelperMatricula(EntityManager em) {
		this.em = em;
	}

	public void salvar(Professor professor) {
		try {
			em.getTransaction().begin();
			em.persist(professor);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public List<Aluno> listAlunos() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			em.getTransaction().begin();
			TypedQuery<Aluno> query = em.createQuery("from Aluno", Aluno.class);
			alunos = query.getResultList();
			em.close();
		} catch (Exception e) {
			throw e;
		}
		return alunos;
	}

	public List<Aluno> listAlunosPorCurso(String curso) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			em.getTransaction().begin();
			TypedQuery<Aluno> query = em.createQuery("from Aluno a where a.curso.nome like :course", Aluno.class);
			query.setParameter("course", ("%" + curso + "%"));
			alunos = query.getResultList();
			em.close();
		} catch (Exception e) {
			throw e;
		}
		return alunos;
	}

	public void excluirAlunosPorCurso(int curso) {
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("delete from Aluno a where a.curso.idcurso = :course");
			query.setParameter("course", curso);
			query.executeUpdate();
			em.getTransaction().commit();
		
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}
}
