package br.com.buzzpage.business.service;

import br.com.buzzpage.entity.Mensagem;
import br.com.buzzpage.vo.DadosGrid;
import br.com.buzzpage.vo.MensagemVo;

public interface MensagemService {

	Mensagem criarMensagem(MensagemVo mensagemVo);

	MensagemVo getMensagemVoById(Long id);

	boolean deletarMensagemRemetente(Long id, Long idPessoa);

	DadosGrid montarGridMensagens(Long idPessoa, Long idConteudo);

}
