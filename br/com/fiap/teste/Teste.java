package br.com.fiap.teste;

import java.text.SimpleDateFormat;
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

	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");

		HelperMatricula dao = new HelperMatricula(em);
		
		// criar objeto professor
		Professor professor = new Professor();
		professor.setNome("Carlos Andre");
		professor.setCpf("15683857813");
		
		// criar curso
		List<Curso> cursos = new ArrayList<Curso>();
		Curso e = new Curso();
		e.setNome("JPA Avancado");
		e.setCargahoraria(80);
		e.setProfessor(professor);
		
		// criar lista de alunos
		List<Aluno> alunos = new ArrayList<Aluno>();
		Aluno a1 = new Aluno(); // aluno 1
		a1.setNome("Matheus");
		a1.setCurso(e);
		a1.setDatanascimento(sdf.parse("1998/3/21"));
		
		Aluno a2 = new Aluno(); // aluno 2
		a2.setNome("Junior");
		a2.setCurso(e);
		a2.setDatanascimento(sdf.parse("1999/6/10"));
		
		// adicionar a lista
		alunos.add(a1);
		alunos.add(a2);
		
		e.setAlunos(alunos); // setar alunos do curso
		cursos.add(e);
		
		professor.setCursos(cursos); // setar cursos de professor
		dao.salvar(professor);
		
		em.close();
		emf.close();
	}

}
