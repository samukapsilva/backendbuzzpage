#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ${package}.business.service.ClickAnuncioService;
import ${package}.dao.ClickAnuncioDao;
import ${package}.entity.ClickAnuncio;
import ${package}.vo.ClickAnuncioVO;

public class ClickAnuncioServiceImpl implements ClickAnuncioService {

	@Autowired
	ClickAnuncioDao clickAnuncioDao;

	@Override
	public ClickAnuncioVO salvarClickAnuncio(ClickAnuncioVO clickAnuncioVO) {
		ClickAnuncio clickAnuncio = copyVOToEntity(clickAnuncioVO);
		return copyEntityToVO(clickAnuncioDao.create(clickAnuncio));
	}

	@Override
	public void delete(ClickAnuncioVO clickAnuncioVO) {
		ClickAnuncio clickAnuncio = copyVOToEntity(clickAnuncioVO);
		clickAnuncioDao.delete(clickAnuncio);
	}

	@Override
	public Long buscarClicksAnuncio(Long idClickAnuncio) {
		Long qtdeClicks = clickAnuncioDao.buscarClicksAnuncio(idClickAnuncio);
		return qtdeClicks;
	}

	@Override
	public ClickAnuncioVO update(ClickAnuncioVO clickAnuncioVO) {
		ClickAnuncio clickAnuncio = copyVOToEntity(clickAnuncioVO);
		clickAnuncio = clickAnuncioDao.update(clickAnuncio);
		return copyEntityToVO(clickAnuncioDao.update(clickAnuncio));
	}

	private ClickAnuncio copyVOToEntity(ClickAnuncioVO clickAnuncioVO) {
		ClickAnuncio clickAnuncio = new ClickAnuncio();
		clickAnuncio.setIdClickAnuncio(clickAnuncioVO.getIdClickAnuncio());
		clickAnuncio.setDataClick(clickAnuncioVO.getDataClick());
		clickAnuncio.setGeolocalizacao(clickAnuncioVO.getGeolocalizacao());
		clickAnuncio.setIdBanner(clickAnuncioVO.getIdBanner());
		;
		clickAnuncio.setIpUsuario(clickAnuncioVO.getIpUsuario());
		clickAnuncio.setSessionID(clickAnuncioVO.getSessionID());
		clickAnuncio.setTipoDispositivo(clickAnuncioVO.getTipoDispositivo());

		return clickAnuncio;
	}

	private ClickAnuncioVO copyEntityToVO(ClickAnuncio clickAnuncio) {
		ClickAnuncioVO clickAnuncioVO = new ClickAnuncioVO();
		clickAnuncioVO.setIdClickAnuncio(clickAnuncio.getIdClickAnuncio());
		clickAnuncioVO.setDataClick(clickAnuncio.getDataClick());
		clickAnuncioVO.setGeolocalizacao(clickAnuncio.getGeolocalizacao());
		clickAnuncioVO.setIdBanner(clickAnuncio.getIdBanner());
		;
		clickAnuncioVO.setIpUsuario(clickAnuncio.getIpUsuario());
		clickAnuncioVO.setSessionID(clickAnuncio.getSessionID());
		clickAnuncioVO.setTipoDispositivo(clickAnuncio.getTipoDispositivo());
		return clickAnuncioVO;
	}
}