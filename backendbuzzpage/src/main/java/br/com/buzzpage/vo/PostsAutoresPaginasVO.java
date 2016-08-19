package br.com.buzzpage.vo;

import java.io.Serializable;
import java.util.List;

public class PostsAutoresPaginasVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private List<PessoaVo> autores;
	private List<TextoVo> posts;
	private List<PaginaVo> paginas;
	
	
	public List<PessoaVo> getAutores() {
		return autores;
	}
	public void setAutores(List<PessoaVo> autores) {
		this.autores = autores;
	}
	public List<TextoVo> getPosts() {
		return posts;
	}
	public void setPosts(List<TextoVo> posts) {
		this.posts = posts;
	}
	public List<PaginaVo> getPaginas() {
		return paginas;
	}
	public void setPaginas(List<PaginaVo> paginas) {
		this.paginas = paginas;
	}
	
	
}
