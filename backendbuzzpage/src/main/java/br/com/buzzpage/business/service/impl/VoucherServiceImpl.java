package br.com.buzzpage.business.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.buzzpage.business.service.VoucherService;
import br.com.buzzpage.dao.PessoaDao;
import br.com.buzzpage.dao.VoucherDAO;
import br.com.buzzpage.entity.Pessoa;
import br.com.buzzpage.entity.Voucher;
import br.com.buzzpage.util.StringUtil;
import br.com.buzzpage.vo.VoucherVo;

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
