package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Aluno;
import br.com.fiap.helper.HelperMatricula;

public class ListaAlunosPorCursoTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		
		HelperMatricula dao = new HelperMatricula(em);
		
		for (Aluno aluno : dao.listAlunosPorCurso("JPA")) {
			System.out.println(aluno.toString());
		}

	}

}
