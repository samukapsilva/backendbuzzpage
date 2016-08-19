#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import ${package}.business.service.VoucherService;
import ${package}.dao.PessoaDao;
import ${package}.dao.VoucherDAO;
import ${package}.entity.Pessoa;
import ${package}.entity.Voucher;
import ${package}.util.StringUtil;
import ${package}.vo.VoucherVo;

public class VoucherServiceImpl implements VoucherService {
	
	@Autowired
	VoucherDAO voucherDao;

	@Autowired
	PessoaDao pessoaDao;

	@Override
	public VoucherVo gerarVoucher(VoucherVo voucherVo) {


		Voucher voucher = new Voucher();
		voucher = converteVoToEntity(voucherVo, voucher);
		voucher =  voucherDao.create(voucher);
		
		voucherVo.setCodVoucher(voucher.getCodVoucher());
		voucherVo.setIdVoucher(voucher.getIdVoucher());
		
		return voucherVo;
	}

	public Voucher converteVoToEntity(VoucherVo voucherVo, Voucher voucher) {
		voucher.setCodVoucher(StringUtil.generateRandomPassword());
		voucher.setDataGeracao( new Date() );
		voucher.setIpUsuario(voucherVo.getIpUsuario());
		
		Pessoa pessoa = null;
		
		if(voucherVo.getIdPessoa()!=null){
			
			pessoa = pessoaDao.find(voucherVo.getIdPessoa());
		}
		
		voucher.setPessoa(pessoa);
		
		return voucher;
		
	}

}
