package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idaluno")
	private int idaluno;
	
	@Column(name = "nome", length=80)
	private String nome;
	
	@Column(name = "datanascimento")
	@Temporal(TemporalType.DATE)
	private Date datanascimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcurso")
	private Curso curso;
	
	public int getIdaluno() {
		return idaluno;
	}
	public void setIdaluno(int idaluno) {
		this.idaluno = idaluno;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Date getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}
	@Override
	public String toString() {
		return idaluno +" - "+ nome + " - " + datanascimento;
	}
	
}
