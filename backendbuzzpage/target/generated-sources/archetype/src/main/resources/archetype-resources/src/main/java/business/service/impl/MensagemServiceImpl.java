#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ${package}.business.service.MensagemService;
import ${package}.dao.AvaliacaoDao;
import ${package}.dao.ConteudoColaboradorDao;
import ${package}.dao.MensagemDao;
import ${package}.dao.PessoaDao;
import ${package}.entity.Mensagem;
import ${package}.entity.Pessoa;
import ${package}.entity.Texto;
import ${package}.util.StringUtil;
import ${package}.vo.DadosGrid;
import ${package}.vo.GridMensagensVo;
import ${package}.vo.MensagemVo;

public class MensagemServiceImpl implements MensagemService {

	@Autowired
	AvaliacaoDao avaliacaoDao;

	@Autowired
	PessoaDao pessoaDao;

	@Autowired
	MensagemDao mensagemDao;

	@Autowired
	ConteudoColaboradorDao conteudoDao;

	@Transactional
	public Mensagem criarMensagem(MensagemVo mensagemVo) {

		Mensagem mensagem = null;

		if (mensagemVo.getId() != null && mensagemVo.getId() > 0) {
			mensagem = mensagemDao.find(mensagemVo.getId());
		} else {
			mensagem = new Mensagem();
		}

		mensagem = copyPropertiesVoToEntity(mensagemVo, mensagem);

		if (mensagemVo.getId() != null && mensagemVo.getId() > 0) {
			mensagemDao.update(mensagem);
		} else {
			mensagemDao.create(mensagem);
		}

		return mensagem;
	}

	private Mensagem copyPropertiesVoToEntity(MensagemVo mensagemVo, Mensagem mensagem) {

		if (mensagemVo.getId() == null || mensagemVo.getId() == 0) {
			mensagem.setDataMensagem(new Date());
		}

		if (mensagemVo.getIdDestinatario() != null && mensagemVo.getIdDestinatario() > 0) {
			Pessoa destinatario = pessoaDao.find(mensagemVo.getIdDestinatario());
			mensagem.setDestinatario(destinatario);
		}

		if (mensagemVo.getIdRemetente() != null && mensagemVo.getIdRemetente() > 0) {
			Pessoa remetente = pessoaDao.find(mensagemVo.getIdRemetente());
			mensagem.setRemetente(remetente);
		}

		if (mensagemVo.getTexto() != null) {
			mensagem.setTexto(mensagemVo.getTexto());
		}

		if (mensagemVo.getTitulo() != null) {
			mensagem.setTitulo(mensagemVo.getTitulo());
		}

		if (mensagemVo.getIdConteudo() != null && mensagemVo.getIdConteudo() > 0) {

			Texto textoVinculado = conteudoDao.find(mensagemVo.getIdConteudo());
			mensagem.setTextoVinculado(textoVinculado);

		}

		return mensagem;
	}

	private MensagemVo copyPropertiesEntityToVo(MensagemVo mensagemVo, Mensagem mensagem) {

		if (mensagem.getDataMensagem() != null) {
			mensagemVo.setDataMensagem(
					StringUtil.dateToString(mensagem.getDataMensagem(), StringUtil.DD_MM_YYYY_HORARIO));
		}

		mensagemVo.setId(mensagem.getId());

		if (mensagem.getTexto() != null) {

			Texto texto = conteudoDao.findByMensagem(mensagem.getId());
			mensagemVo.setIdConteudo(texto.getIdTexto());

		}

		if (mensagem.getDestinatario() != null) {

			Pessoa destinatario = pessoaDao.findDestinatarioByMensagem(mensagem.getId());
			mensagemVo.setIdDestinatario(destinatario.getIdPessoa());

		}

		if (mensagem.getRemetente() != null) {

			Pessoa remetente = pessoaDao.findRemetenteByMensagem(mensagem.getId());
			mensagemVo.setIdRemetente(remetente.getIdPessoa());
			mensagemVo.setNomeRemetente(remetente.getNome());

		}

		mensagemVo.setStatusMensagem(mensagem.getStatusMensagem());

		if (mensagem.getTexto() != null) {

			mensagemVo.setTexto(mensagem.getTexto());

		}

		if (mensagem.getTitulo() != null) {

			mensagemVo.setTitulo(mensagem.getTitulo());

		}

		return mensagemVo;
	}

	public MensagemVo getMensagemVoById(Long id) {

		Mensagem mensagem = mensagemDao.find(id);
		return copyPropertiesEntityToVo(new MensagemVo(), mensagem);

	}

	public boolean deletarMensagemRemetente(Long id, Long idPessoa) {

		Mensagem mensagem = mensagemDao.findByRemetenteEIdMensagem(id, idPessoa);

		if (mensagem != null) {
			mensagemDao.delete(mensagem);
			return true;
		} else {
			return false;
		}

	}

	public DadosGrid montarGridMensagens(Long idPessoa, Long idConteudo) {

		DadosGrid dados = new DadosGrid();

		List<MensagemVo> lista = new ArrayList<MensagemVo>();

		List<Mensagem> mensagens = mensagemDao.findMensagensDaPessoaPorConteudo(idPessoa, idConteudo);

		if (mensagens != null) {
			for (Mensagem mensagem : mensagens) {

				MensagemVo msgVo = copyPropertiesEntityToVo(new MensagemVo(), mensagem);
				lista.add(msgVo);

			}
		}

		GridMensagensVo[] data = new GridMensagensVo[lista.size()];

		int i = 0;

		for (MensagemVo msgVo : lista) {

			GridMensagensVo grid = new GridMensagensVo();

			grid.setData(msgVo.getDataMensagem());
			grid.setId(msgVo.getId());
			grid.setIdRemetente(msgVo.getIdRemetente());
			grid.setTexto(msgVo.getTexto());
			grid.setTitulo(msgVo.getTitulo());
			grid.setNomeRemetente(msgVo.getNomeRemetente());

			String nomeDestinatario = null;

			if (msgVo.getIdDestinatario() != null && msgVo.getIdDestinatario() > 0) {
				Pessoa destinatario = pessoaDao.find(msgVo.getIdDestinatario());
				grid.setNomeDestinatario(destinatario.getNome());
			}

			data[i] = grid;

			i++;
		}

		dados.setData(data);
		dados.setDraw(1);
		dados.setRecordsFiltered(lista.size());
		dados.setRecordsTotal(lista.size());

		return dados;

	}

}
