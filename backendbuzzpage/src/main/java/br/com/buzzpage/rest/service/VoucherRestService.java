package br.com.buzzpage.rest.service;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.buzzpage.business.service.VoucherService;
import br.com.buzzpage.entity.Voucher;
import br.com.buzzpage.rest.serviceutil.Constants;
import br.com.buzzpage.vo.StatusVo;
import br.com.buzzpage.vo.VoucherVo;

@Component
@Path("/voucher")
public class VoucherRestService {
	
	@Autowired
	private VoucherService voucherService;
 
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("requisitarNovoVoucher")
	@Transactional
	public VoucherVo gerarVoucher(VoucherVo voucherVo) throws JsonGenerationException, JsonMappingException, IOException {
		
		voucherVo = voucherService.gerarVoucher(voucherVo);
 
		
		return voucherVo;
	}
	
	@GET
	@Path("buscarVoucher/{codVoucher}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public VoucherVo buscarVoucher(@PathParam("codVoucher") String codVoucher)
			throws JsonGenerationException, JsonMappingException, IOException {

			VoucherVo voucherVo = null;

			return voucherVo;
	}
	
	
}
