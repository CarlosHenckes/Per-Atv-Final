package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Professor;
import br.com.fiap.helper.HelperMatricula;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();

		HelperMatricula dao = new HelperMatricula(em);
		Professor professor = new Professor();
		professor.setNome("Carlos Andre");
		professor.setCpf("15683857813");
		
		List<Curso> cursos = new ArrayList<Curso>();
		Curso e = new Curso();
		e.setNome("JPA Avancado");
		e.setCargahoraria(80);
		e.setProfessor(professor);
		List<Aluno> alunos = new ArrayList<Aluno>();
		Aluno a1 = new Aluno();
		a1.setNome("Matheus");
		a1.setCurso(e);
		Aluno a2 = new Aluno();
		a2.setNome("Junior");
		a2.setCurso(e);
		alunos.add(a1);
		alunos.add(a2);
		e.setAlunos(alunos);
		cursos.add(e);
		professor.setCursos(cursos);
		dao.salvar(professor);
	}

}
