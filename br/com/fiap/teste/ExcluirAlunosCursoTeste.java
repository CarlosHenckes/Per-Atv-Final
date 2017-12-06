package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.helper.HelperMatricula;

public class ExcluirAlunosCursoTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		
		try {
			HelperMatricula dao = new HelperMatricula(em);
			dao.excluirAlunosPorCurso(1);
			System.out.println("Turma finalizada.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
