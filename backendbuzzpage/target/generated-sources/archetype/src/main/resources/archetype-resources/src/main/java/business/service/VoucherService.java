#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import ${package}.vo.VoucherVo;

public interface VoucherService {

	
	VoucherVo gerarVoucher( VoucherVo voucherVo );
	
}
