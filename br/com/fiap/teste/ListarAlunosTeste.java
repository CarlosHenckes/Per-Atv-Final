package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Aluno;
import br.com.fiap.helper.HelperMatricula;

public class ListarAlunosTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		
		HelperMatricula dao = new HelperMatricula(em);
		
		System.out.println("Alunos Matriculados: ");
		for (Aluno aluno : dao.listAlunos()) {
			System.out.println(aluno.toString());
		}
		
		em.close();
		emf.close();

	}

}
