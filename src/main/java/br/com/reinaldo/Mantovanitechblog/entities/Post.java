package br.com.reinaldo.Mantovanitechblog.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
	name = "posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"titulo"})}
)
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titulo", nullable = false)
	private String titulo;
	@Column(name = "descricao", nullable = false)
	private String descricao;
	@Column(name = "conteudo", nullable = false)
	private String conteudo;
	
	public Post() {
		
	}
	
	public Post(Long id, String titulo, String descricao, String conteudo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.conteudo = conteudo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudo, descricao, id, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(conteudo, other.conteudo) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(titulo, other.titulo);
	}
	
	
	
}
