#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import ${package}.entity.Mensagem;
import ${package}.vo.DadosGrid;
import ${package}.vo.MensagemVo;

public interface MensagemService {

	Mensagem criarMensagem(MensagemVo mensagemVo);

	MensagemVo getMensagemVoById(Long id);

	boolean deletarMensagemRemetente(Long id, Long idPessoa);

	DadosGrid montarGridMensagens(Long idPessoa, Long idConteudo);

}
