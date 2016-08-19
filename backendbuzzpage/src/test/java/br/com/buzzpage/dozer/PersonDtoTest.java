package br.com.buzzpage.dozer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;

public class PersonDtoTest {

	private Mapper mapper;

	@Before
	public void setUp() {
		List<String> list = new ArrayList<String>();
		list.add("dozer-bean-mappings.xml");
		mapper = new DozerBeanMapper(list);
	}

	@Test
	public void testPersonDomainToDTO() {
		PersonDomain p1Domain = new PersonDomain();
		p1Domain.setName("John Smith");
		p1Domain.setAge(25);
		PersonDto p1Dto = new PersonDto();
		assertNotEquals(p1Domain.getName(), p1Dto.getNameFull());
		assertNotEquals(p1Domain.getAge(), p1Dto.getAgeThisYear());
		mapper.map(p1Domain, p1Dto, "person");
		assertEquals(p1Domain.getName(), p1Dto.getNameFull());
		assertEquals(p1Domain.getAge(), p1Dto.getAgeThisYear());
	}

}
