#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ${package}.business.service.ConteudoColaboradorService;
import ${package}.business.service.PessoaService;
import ${package}.dao.PessoaDao;
import ${package}.entity.Pessoa;
import ${package}.entity.Texto;
import ${package}.rest.serviceutil.Constants;
import ${package}.rest.serviceutil.PasswordEncryption;
import ${package}.util.BuzzPageMailSender;
import ${package}.util.StringUtil;
import ${package}.vo.DadosGrid;
import ${package}.vo.GridBuzzPagersVo;
import ${package}.vo.ListaConteudosVo;
import ${package}.vo.LoginVo;
import ${package}.vo.PessoaVo;
import ${package}.vo.ProfileVo;

public class PessoaServiceImpl implements PessoaService {

	@Autowired
	PessoaDao pessoaDao;

	@Autowired
	private ConteudoColaboradorService conteudoService;

	public Pessoa salvarPessoa(PessoaVo pessoaVo)
			throws IllegalAccessException, InvocationTargetException {
		Pessoa pessoa = new Pessoa();

		if (pessoaVo.getIdPessoa() == null) {
			pessoaVo.setIdPessoa(0L);
		}
		if (pessoaVo.getIdPessoa() == 0) {
			pessoaVo.setIdPessoa(null);
		}

		pessoa = copyPropertiesVoToEntity(pessoa, pessoaVo);
		pessoa.setDataCadastro(new Date());
		pessoaDao.create(pessoa);
		return pessoa;
	}

	private Pessoa copyPropertiesVoToEntity(Pessoa pessoa, PessoaVo pessoaVo) {

		if (pessoaVo == null) {
			return null;
		}

		if (pessoaVo.getAgenciaBanco() != null) {
			pessoa.setAgenciaBanco(pessoaVo.getAgenciaBanco());
		}

		if (pessoaVo.getBairro() != null) {
			pessoa.setBairro(pessoaVo.getBairro());
		}

		if (pessoaVo.getCep() != null) {
			pessoa.setCep(pessoaVo.getCep());
		}

		if (pessoaVo.getCidade() != null) {
			pessoa.setCidade(pessoaVo.getCidade());
		}

		if (pessoaVo.getComplemento() != null) {
			pessoa.setComplemento(pessoaVo.getComplemento());
		}

		if (pessoaVo.getContaBanco() != null) {
			pessoa.setContaBanco(pessoaVo.getContaBanco());
		}

		if (pessoaVo.getDddFoneCelular() != null) {
			pessoa.setDddFoneCelular(pessoaVo.getDddFoneCelular());
		}

		if (pessoaVo.getDddFoneFixo() != null) {
			pessoa.setDddFoneFixo(pessoaVo.getDddFoneFixo());
		}

		if (pessoaVo.getEmail() != null) {
			pessoa.setEmail(pessoaVo.getEmail());
		}

		if (pessoaVo.getEndereco() != null) {
			pessoa.setEndereco(pessoaVo.getEndereco());
		}

		if (pessoaVo.getEstado() != null) {
			pessoa.setEstado(pessoaVo.getEstado());
		}

		if (pessoaVo.getFoneCelular() != null) {
			pessoa.setFoneCelular(pessoaVo.getFoneCelular());
		}

		if (pessoaVo.getFoneFixo() != null) {
			pessoa.setFoneFixo(pessoaVo.getFoneFixo());
		}

		if (pessoaVo.getIdSexo() != null) {
			pessoa.setIdSexo(pessoaVo.getIdSexo());
		}

		if (pessoaVo.getNome() != null) {
			pessoa.setNome(pessoaVo.getNome());
		}

		if (pessoaVo.getNumero() != null) {
			pessoa.setNumero(pessoaVo.getNumero());
		}

		if (pessoaVo.getNumeroBanco() != null) {
			pessoa.setNumeroBanco(pessoaVo.getNumeroBanco());
		}

		if (pessoaVo.getNumeroDocumento() != null) {
			pessoa.setNumeroDocumento(pessoaVo.getNumeroDocumento());
		}

		if (pessoaVo.getNumeroRG() != null) {
			pessoa.setNumeroRG(pessoaVo.getNumeroRG());
		}

		if (pessoaVo.getOperacaoBanco() != null) {
			pessoa.setOperacaoBanco(pessoaVo.getOperacaoBanco());
		}

		if (pessoaVo.getPais() != null) {
			pessoa.setPais(pessoaVo.getPais());
		}

		if (pessoaVo.getTipoConta() != null) {
			pessoa.setTipoConta(pessoaVo.getTipoConta());
		}

		if (pessoaVo.getUsuario() != null) {
			pessoa.setUsuario(pessoaVo.getUsuario());
		} else {
			if (pessoa.getIdPessoa() == null) {
				String usuario = criarUsuario(pessoa);
				pessoa.setUsuario(usuario);
			}
		}

		if (pessoaVo.getEmailIndicador() != null) {
			Pessoa indicador = pessoaDao.findByEmail(pessoaVo
					.getEmailIndicador());

			if (indicador != null) {
				pessoa.setIndicador(indicador);
			}

		}

		if (pessoaVo.getIsAdministrador() != null) {
			pessoa.setIsAdministrador(pessoaVo.getIsAdministrador());
		}

		if (pessoaVo.getIsEditor() != null) {
			pessoa.setIsEditor(pessoaVo.getIsEditor());
		}

		if (pessoaVo.getDiaAniversario() != null) {
			pessoa.setDiaAniversario(pessoaVo.getDiaAniversario());
		}

		if (pessoaVo.getMesAniversario() != null) {
			pessoa.setMesAniversario(pessoaVo.getMesAniversario());
		}

		if (pessoaVo.getAnoAniversario() != null) {
			pessoa.setAnoAniversario(pessoaVo.getAnoAniversario());
		}

		// sobreMim;
		if (pessoaVo.getSobreMim() != null) {
			pessoa.setSobreMim(pessoaVo.getSobreMim());
		}

		// facebook;
		if (pessoaVo.getFacebook() != null) {
			pessoa.setFacebook(pessoaVo.getFacebook());
		}

		// linkedin;
		if (pessoaVo.getLinkedin() != null) {
			pessoa.setLinkedin(pessoaVo.getLinkedin());
		}

		if (pessoaVo.getTwitter() != null) {
			// twitter;
			pessoa.setTwitter(pessoaVo.getTwitter());
		}

		// blogger;
		if (pessoaVo.getBlogger() != null) {
			pessoa.setBlogger(pessoaVo.getBlogger());
		}

		// youtube;
		if (pessoaVo.getYoutube() != null) {
			pessoa.setYoutube(pessoaVo.getYoutube());
		}

		// googleMais;
		if (pessoaVo.getGoogleMais() != null) {
			pessoa.setGoogleMais(pessoaVo.getGoogleMais());
		}

		// site;
		if (pessoaVo.getSite() != null) {
			pessoa.setSite(pessoaVo.getSite());
		}

		if (pessoaVo.getPaypal() != null) {
			pessoa.setPaypal(pessoaVo.getPaypal());
		}

		if (pessoaVo.getPagseguro() != null) {
			pessoa.setPagseguro(pessoaVo.getPagseguro());
		}

		// private Integer aceiteTermos;
		if (pessoaVo.getAceiteTermos() != null) {
			pessoa.setAceiteTermos(pessoaVo.getAceiteTermos());

			pessoa.setDataAceite(new Date());

			if (pessoaVo.getIpAceite() != null) {
				pessoa.setIpAceite(pessoaVo.getIpAceite());
			}

		}

		// private Integer publicarRedes;
		if (pessoaVo.getPublicarRedes() != null) {
			pessoa.setPublicarRedes(pessoaVo.getPublicarRedes());
		}

		// private Integer publicarSite;
		if (pessoaVo.getPublicarSite() != null) {
			pessoa.setPublicarSite(pessoaVo.getPublicarSite());
		}

		// private Integer publiarAutoria;
		if (pessoaVo.getPublicarAutoria() != null) {
			pessoa.setPublicarAutoria(pessoaVo.getPublicarAutoria());
		}

		if (pessoaVo.getSenha() != null) {
			pessoa.setSenha(PasswordEncryption.encrypt(pessoaVo.getSenha()));
		}

		if (pessoaVo.getFotoPerfil() != null) {
			pessoa.setFotoPerfil(pessoaVo.getFotoPerfil());
		}

		return pessoa;

	}

	private PessoaVo copyPropertiesEntityToVo(Pessoa pessoa, PessoaVo pessoaVo) {

		if (pessoa == null) {
			return null;
		}

		pessoaVo = new PessoaVo();

		pessoaVo.setAgenciaBanco(pessoa.getAgenciaBanco());
		pessoaVo.setBairro(pessoa.getBairro());
		pessoaVo.setCep(pessoa.getCep());
		pessoaVo.setCidade(pessoa.getCidade());
		pessoaVo.setComplemento(pessoa.getComplemento());
		pessoaVo.setContaBanco(pessoa.getContaBanco());
		pessoaVo.setDddFoneCelular(pessoa.getDddFoneCelular());
		pessoaVo.setDddFoneFixo(pessoa.getDddFoneFixo());
		pessoaVo.setEmail(pessoa.getEmail());
		pessoaVo.setEndereco(pessoa.getEndereco());
		pessoaVo.setEstado(pessoa.getEstado());
		pessoaVo.setFoneCelular(pessoa.getFoneCelular());
		pessoaVo.setFoneFixo(pessoa.getFoneFixo());
		pessoaVo.setIdSexo(pessoa.getIdSexo());
		pessoaVo.setNome(pessoa.getNome());
		pessoaVo.setNumero(pessoa.getNumero());
		pessoaVo.setNumeroBanco(pessoa.getNumeroBanco());
		pessoaVo.setNumeroDocumento(pessoa.getNumeroDocumento());
		pessoaVo.setTipoDocumento(pessoa.getTipoDocumento());
		pessoaVo.setNumeroRG(pessoa.getNumeroRG());
		pessoaVo.setOperacaoBanco(pessoa.getOperacaoBanco());
		pessoaVo.setPais(pessoa.getPais());
		pessoaVo.setTipoConta(pessoa.getTipoConta());
		pessoaVo.setUsuario(pessoa.getUsuario());
		pessoaVo.setIsAdministrador(pessoa.getIsAdministrador());
		pessoaVo.setIsEditor(pessoa.getIsEditor());
		pessoaVo.setIdPessoa(pessoa.getIdPessoa());
		pessoaVo.setDiaAniversario(pessoa.getDiaAniversario());
		pessoaVo.setMesAniversario(pessoa.getMesAniversario());
		pessoaVo.setAnoAniversario(pessoa.getAnoAniversario());
		pessoaVo.setTipoConta(pessoa.getTipoConta());

		// sobreMim;
		pessoaVo.setSobreMim(pessoa.getSobreMim());
		// facebook;
		pessoaVo.setFacebook(pessoa.getFacebook());
		// linkedin;
		pessoaVo.setLinkedin(pessoa.getLinkedin());
		// twitter;
		pessoaVo.setTwitter(pessoa.getTwitter());
		// blogger;
		pessoaVo.setBlogger(pessoa.getBlogger());
		// youtube;
		pessoaVo.setYoutube(pessoa.getYoutube());
		// googleMais;
		pessoaVo.setGoogleMais(pessoa.getGoogleMais());
		// site;
		pessoaVo.setSite(pessoa.getSite());

		pessoaVo.setPaypal(pessoa.getPaypal());
		pessoaVo.setPagseguro(pessoa.getPagseguro());

		// private Integer aceiteTermos;
		pessoaVo.setAceiteTermos(pessoa.getAceiteTermos());
		// private Integer publicarRedes;
		pessoaVo.setPublicarRedes(pessoa.getPublicarRedes());
		// private Integer publicarSite;
		pessoaVo.setPublicarSite(pessoa.getPublicarSite());
		// private Integer publiarAutoria;
		pessoaVo.setPublicarAutoria(pessoa.getPublicarAutoria());

		pessoaVo.setFotoPerfil(pessoa.getFotoPerfil());

		return pessoaVo;

	}

	public Pessoa getPessoaById(Long id) {
		return pessoaDao.find(id);
	}

	public Pessoa updatePessoa(PessoaVo pessoaVo)
			throws IllegalAccessException, InvocationTargetException {

		Pessoa pessoa = getPessoaById(pessoaVo.getIdPessoa());

		if (pessoa == null) {
			return new Pessoa();
		}
		pessoa = copyPropertiesVoToEntity(pessoa, pessoaVo);
		return pessoaDao.update(pessoa);

	}

	public Pessoa getPessoaByEmail(String email) {
		// TODO Auto-generated method stub
		return pessoaDao.findByEmail(email);
	}

	public PessoaVo efetuarLogin(LoginVo loginVo) {

		PessoaVo pessoaVo = null;
		Pessoa pessoa = pessoaDao.findByEmailOrLogin(loginVo);

		if (PasswordEncryption.checkPassword(loginVo.getSenha(),
				pessoa.getSenha())) {
			pessoaVo = copyPropertiesEntityToVo(pessoa, pessoaVo);
		}

		return pessoaVo;
	}

	public PessoaVo getPessoaVoById(Long id) {

		Pessoa pessoa = getPessoaById(id);
		PessoaVo pessoaVo = new PessoaVo();

		pessoaVo = copyPropertiesEntityToVo(pessoa, pessoaVo);

		return pessoaVo;
	}

	public Pessoa resetarSenha(PessoaVo pessoaVo) {

		Pessoa pessoa = pessoaDao.findByEmail(pessoaVo.getEmail());

		if (pessoa == null) {
			return null;
		}

		String senhaAleatoria = StringUtil.generateRandomPassword();
		String novaSenha = PasswordEncryption.encrypt(senhaAleatoria);

		pessoa.setSenha(novaSenha);
		pessoa = pessoaDao.update(pessoa);

		BuzzPageMailSender.sendMailEsqueciSenha(pessoa,
				Constants.TIPO_SENHA_ACESSO, senhaAleatoria);

		return pessoa;
	}

	public PessoaVo findRevisor(Long idConteudo) {

		Pessoa pessoa = pessoaDao.findRevisorTexto(idConteudo);

		return copyPropertiesEntityToVo(pessoa, new PessoaVo());
	}

	public ProfileVo getProfile(Long id) {

		Pessoa pessoa = getPessoaById(id);

		ProfileVo profile = populaProfileUsuario(id, pessoa);

		return profile;
	}

	public ProfileVo populaProfileUsuario(Long id, Pessoa pessoa) {
		ProfileVo profile = new ProfileVo();
		profile.setAnoAniversario(pessoa.getAnoAniversario());
		profile.setBlogger(pessoa.getBlogger());
		profile.setDiaAniversario(pessoa.getDiaAniversario());
		profile.setFacebook(pessoa.getFacebook());
		profile.setFotoPerfil(pessoa.getFotoPerfil());
		profile.setGoogleMais(pessoa.getGoogleMais());
		profile.setLinkedin(pessoa.getLinkedin());
		profile.setMesAniversario(pessoa.getMesAniversario());
		profile.setNome(pessoa.getNome());
		profile.setSite(pessoa.getSite());
		profile.setSobreMim(pessoa.getSobreMim());
		profile.setTwitter(pessoa.getTwitter());
		profile.setYoutube(pessoa.getYoutube());
		profile.setIdPessoa(pessoa.getIdPessoa());

		List<Texto> textos = conteudoService.getTextosColaborador(id);

		List<ListaConteudosVo> conteudos = new ArrayList<ListaConteudosVo>();

		for (Texto texto : textos) {

			ListaConteudosVo content = new ListaConteudosVo();
			content.setDataPost(StringUtil.dateToString(
					texto.getDataCadastro(), Constants.FORMATO_DATA_BR));
			content.setIdTexto(texto.getIdTexto());
			content.setResumo(StringUtil.getResumoPost(texto, 260).trim());
			content.setSlug(texto.getSlug());
			content.setTitulo(texto.getTitulo());

			conteudos.add(content);

		}

		profile.setConteudos(conteudos);
		return profile;
	}

	public ProfileVo getProfile(String userName) {

		Pessoa pessoa = pessoaDao.findByUsuario(userName);

		if (pessoa == null) {
			return new ProfileVo();
		}

		ProfileVo profile = populaProfileUsuario(pessoa.getIdPessoa(), pessoa);

		return profile;
	}

	@Transactional
	public Boolean setUsuariosNulos() {

		List<Pessoa> pessoas = pessoaDao.findAll();

		for (Pessoa pessoa : pessoas) {

			if (pessoa.getNome() == null) {
				continue;
			}

			String usuario = pessoa.getUsuario();

			if (usuario == null || usuario.equals("") || usuario.length() < 2) {

				usuario = criarUsuario(pessoa);

				pessoa.setUsuario(usuario);
				pessoa = pessoaDao.update(pessoa);

			} else {
				usuario = usuario.replaceAll("${symbol_escape}${symbol_escape}s+", "");
			}

		}
		return true;
	}

	private String criarUsuario(Pessoa pessoa) {

		String[] nomes = pessoa.getNome().split(" ");

		String usuario = "";
		String base = pessoa.getNome();

		if (nomes.length > 1) {

			String primeiroNome = nomes[0];
			String ultimoNome = nomes[nomes.length - 1];

			base = primeiroNome + ultimoNome;
		}

		usuario = StringUtil.criarSlug(base);

		Pessoa usuarioRepetido = pessoaDao.findByUsuario(usuario);

		if (usuarioRepetido != null) {
			String number = StringUtil.generateRandomNumber();
			usuario = usuario + number;
		}

		return usuario;
	}

	public List<PessoaVo> findAll() {

		List<PessoaVo> lista = new ArrayList<PessoaVo>();

		List<Pessoa> pessoas = pessoaDao.listarOrdenadoPorNome();

		for (Pessoa pessoa : pessoas) {
			PessoaVo pessoaVo = new PessoaVo();
			pessoaVo = copyPropertiesEntityToVo(pessoa, pessoaVo);

			lista.add(pessoaVo);
		}

		return lista;
	}

	public DadosGrid montaGridPessoas() {

		DadosGrid grid = new DadosGrid();

		List<Pessoa> pessoas = pessoaDao.listarOrdenadoPorNome();

		GridBuzzPagersVo[] dados = new GridBuzzPagersVo[pessoas.size()];

		int i = 0;

		for (Pessoa pessoa : pessoas) {
			GridBuzzPagersVo vo = new GridBuzzPagersVo();
			vo.setCelular(pessoa.getFoneCelular());
			vo.setCidadeEstado(pessoa.getCidade() + " - " + pessoa.getEstado());
			vo.setEmail(pessoa.getEmail());
			vo.setNome(pessoa.getNome());
			vo.setSlug(pessoa.getUsuario());
			vo.setTelefone(pessoa.getFoneFixo());
			dados[i] = vo;
			i++;
		}

		grid.setData(dados);
		grid.setDraw(1);
		grid.setRecordsFiltered(pessoas.size());
		grid.setRecordsTotal(pessoas.size());

		return grid;
	}

}
