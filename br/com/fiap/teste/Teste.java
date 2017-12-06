package br.com.fiap.teste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

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
		Date date1 = new Date();
		date1 = df.parse("29/03/1984");
		a1.setDatanascimento(date1);
		
		Aluno a2 = new Aluno(); // aluno 2
		a2.setNome("Junior");
		a2.setCurso(e);
		Date date2 = new Date();
		date2 = df.parse("21/09/1983");
		a2.setDatanascimento(date2);
		
		// adicionar a lista
		alunos.add(a1);
		alunos.add(a2);
		
		e.setAlunos(alunos); // setar alunos do curso
		cursos.add(e);
		
		professor.setCursos(cursos); // setar cursos de professor
		dao.salvar(professor);

	}

}
