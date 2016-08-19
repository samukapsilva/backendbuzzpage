#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest.service;

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

import ${package}.business.service.VoucherService;
import ${package}.entity.Voucher;
import ${package}.rest.serviceutil.Constants;
import ${package}.vo.StatusVo;
import ${package}.vo.VoucherVo;

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
