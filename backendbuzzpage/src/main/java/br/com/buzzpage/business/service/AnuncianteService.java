package br.com.buzzpage.business.service;

import java.util.List;

import br.com.buzzpage.vo.AnuncianteVO;
import br.com.buzzpage.vo.AnuncioVO;
import br.com.buzzpage.vo.LoginVo;

public interface AnuncianteService {

	AnuncianteVO salvarAnunciante(AnuncianteVO anuncianteVO);

	void deletarAnunciante(AnuncianteVO anunciante);

	List<AnuncianteVO> buscarAnunciantes(Long idPessoa);

	AnuncianteVO efetuarLogin(LoginVo loginVo);

	AnuncianteVO find(Long id);

	void atualizarAnunciante(Long idAnunciante);
}
