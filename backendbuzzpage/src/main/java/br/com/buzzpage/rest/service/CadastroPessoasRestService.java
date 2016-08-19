package br.com.buzzpage.rest.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.buzzpage.business.service.PessoaService;
import br.com.buzzpage.entity.Pessoa;
import br.com.buzzpage.rest.serviceutil.Constants;
import br.com.buzzpage.rest.serviceutil.PasswordEncryption;
import br.com.buzzpage.rest.serviceutil.TemplateConstants;
import br.com.buzzpage.util.BuzzPageMailSender;
import br.com.buzzpage.vo.DadosGrid;
import br.com.buzzpage.vo.LoginVo;
import br.com.buzzpage.vo.PessoaVo;
import br.com.buzzpage.vo.ProfileVo;
import br.com.buzzpage.vo.StatusVo;

@Component
@Path("/cadastropessoas")
public class CadastroPessoasRestService {

	@Autowired
	private PessoaService pessoaService;

	/**
	 * Adds a new resource (pessoa) from the given json format (at least title
	 * and feed elements are required at the DB level)
	 * 
	 * @param pessoaVo
	 * @return
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional(noRollbackFor = PersistenceException.class)
	public StatusVo cadastrarPessoa(PessoaVo pessoaVo) {

		StatusVo status = new StatusVo();
		Pessoa pessoa = null;

		try {
			if (pessoaVo.getIdPessoa() != null && pessoaVo.getIdPessoa() > 0) {

				boolean senhaValidada = true;
				senhaValidada = verificaSenhaCorreta(pessoaVo);

				if (senhaValidada) {
					pessoa = pessoaService.updatePessoa(pessoaVo);
				} else {
					status.setChave(Constants.CHAVE_ERRO);
					status.setIdCadastrado(0L);
					status.setValor(Constants.SENHA_NAO_CONFERE);
					return status;
				}

			} else {

				pessoa = pessoaService.salvarPessoa(pessoaVo);
				enviarEmailConfirmacao(pessoa, pessoaVo.getSenha());

			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
		}

		boolean result = (pessoa != null && pessoa.getIdPessoa() != null);

		if (result) {
			status.setChave(Constants.UM);
			status.setIdCadastrado(pessoa.getIdPessoa());
			status.setValor(Constants.CHAVE_OK);
		} else {
			status.setChave(Constants.ZERO);
			status.setValor(Constants.CHAVE_ERRO);
		}

		return status;

	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("esqueciMinhaSenha")
	@Transactional(noRollbackFor = PersistenceException.class)
	public StatusVo esqueciMinhaSenha(PessoaVo pessoaVo) {

		StatusVo status = new StatusVo();

		Pessoa pessoa = pessoaService.resetarSenha(pessoaVo);

		if (pessoa != null) {
			status.setChave(Constants.UM);
			status.setIdCadastrado(pessoa.getIdPessoa());
			status.setValor(Constants.CHAVE_OK);
		} else {
			status.setChave(Constants.ZERO);
			status.setValor(Constants.CHAVE_ERRO);
		}

		return status;

	}

	private boolean verificaSenhaCorreta(PessoaVo pessoaVo) {
		// TODO Auto-generated method stub

		if (pessoaVo != null && pessoaVo.getSenha() != null) {

			Pessoa pessoa = pessoaService.getPessoaById(pessoaVo.getIdPessoa());

			return PasswordEncryption.checkPassword(pessoaVo.getSenhaAtual(),
					pessoa.getSenha());

		} else {
			return true;
		}

	}

	@POST
	@Path("login")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional(noRollbackFor = PersistenceException.class)
	public Response login(LoginVo loginVo) {

		PessoaVo pessoaVo = pessoaService.efetuarLogin(loginVo);

		if (pessoaVo == null) {
			pessoaVo = new PessoaVo();
			pessoaVo.setIdPessoa(0L);
			pessoaVo.setNome(Constants.CHAVE_REGISTRO_INEXISTENTE);
		}

		return Response.status(200).entity(pessoaVo).build();

	}

	@GET
	@Path("myProfile/{userName}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public ProfileVo myProfile(@PathParam("userName") String userName)
			throws JsonGenerationException, JsonMappingException, IOException {

		ProfileVo pessoaVo = pessoaService.getProfile(userName);
		return pessoaVo;

		// return Response.status(200).entity(pessoaVo).build();
	}

	@GET
	@Path("buscaTodos")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public List<PessoaVo> findAll() throws JsonGenerationException,
			JsonMappingException, IOException {

		List<PessoaVo> lista = pessoaService.findAll();
		return lista;

	}

	@GET
	@Path("gridBuzzPagers")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public DadosGrid gridBuzzPagers() throws JsonGenerationException,
			JsonMappingException, IOException {

		DadosGrid grid = pessoaService.montaGridPessoas();
		return grid;

	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public PessoaVo buscaPorId(@PathParam("id") Long id)
			throws JsonGenerationException, JsonMappingException, IOException {

		PessoaVo pessoaVo = pessoaService.getPessoaVoById(id);
		return pessoaVo;

		// return Response.status(200).entity(pessoaVo).build();
	}

	@GET
	@Path("buscaPorEmail/{email}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo buscaPorEmail(@PathParam("email") String email)
			throws JsonGenerationException, JsonMappingException, IOException {

		StatusVo status = new StatusVo();

		Pessoa pessoa = pessoaService.getPessoaByEmail(email);

		if (pessoa != null) {
			status.setChave(Constants.CHAVE_OK);
			status.setIdCadastrado(pessoa.getIdPessoa());
			status.setNome(pessoa.getNome());
			status.setFoto(pessoa.getFotoPerfil());

		} else {
			status.setChave(Constants.CHAVE_ERRO);
			status.setIdCadastrado(0L);
		}

		return status;
	}

	@GET
	@Path("buscaRevisor/{idConteudo}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public PessoaVo buscaRevisor(@PathParam("idConteudo") Long idConteudo)
			throws JsonGenerationException, JsonMappingException, IOException {

		StatusVo status = new StatusVo();

		PessoaVo pessoaVo = new PessoaVo();

		pessoaVo = pessoaService.findRevisor(idConteudo);

		return pessoaVo;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo updatePessoa(PessoaVo pessoaVo) {
		return cadastrarPessoa(pessoaVo);
	}

	private void enviarEmailConfirmacao(Pessoa pessoa, String senha) {

		Map<String, String> parametros = new HashMap<String, String>();
		String emailTitle = Constants.MSG_BOAS_VINDAS_MASCULINO;

		if (pessoa.getIdSexo().longValue() == Constants.ID_FEMININO) {
			emailTitle = Constants.MSG_BOAS_VINDAS_FEMININO;
			parametros.put("bemvindo", Constants.MSG_BOAS_VINDAS_FEMININO);
		} else {
			parametros.put("bemvindo", Constants.MSG_BOAS_VINDAS_MASCULINO);
		}

		parametros.put("nome", pessoa.getNome());
		parametros.put("senha", senha);

		parametros.put("login", pessoa.getEmail());

		BuzzPageMailSender.sendMailGeneric(pessoa, parametros,
				TemplateConstants.TEMPLATE_MSG_BOAS_VINDAS, emailTitle);

		parametros.clear();
		parametros = new HashMap<String, String>();

		Pessoa reginaldo = new Pessoa();
		reginaldo.setNome("Reginaldo Pereira");
		reginaldo.setEmail("reginaldo@descubranet.com");
		reginaldo.setSenha("brazil12");

		StringBuilder html = new StringBuilder(
				"Dados do novo cadastro: <br/><br/>nome: ")
				.append(pessoa.getNome()).append("<br/>").append("Email: ")
				.append(pessoa.getEmail()).append("<br/>");

		parametros.put("html", html.toString());

		BuzzPageMailSender.sendMailGeneric(reginaldo, parametros,
				TemplateConstants.TEMPLATE_EMAIL_MSG_DIRECAO,
				"Novo Cadastro BuzzPage");

	}

	@GET
	@Path("setUsuariosNulos")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo setUsuario() throws JsonGenerationException,
			JsonMappingException, IOException {

		Boolean retorno = pessoaService.setUsuariosNulos();

		StatusVo status = new StatusVo();
		status.setChave("OK");
		return status;
	}

}
