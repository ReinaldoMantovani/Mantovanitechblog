package br.com.reinaldo.Mantovanitechblog.payload;

import java.util.Objects;

public class PostDto {
	private Long id;
	private String titulo;
	private String descricao;
	private String conteudo;
	
	public PostDto() {
		
	}
	public PostDto(Long id, String titulo, String descricao, String conteudo) {
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
		PostDto other = (PostDto) obj;
		return Objects.equals(conteudo, other.conteudo) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(titulo, other.titulo);
	}
	
	
	
	
}
