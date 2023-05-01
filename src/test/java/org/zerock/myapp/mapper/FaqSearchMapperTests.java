package org.zerock.myapp.mapper;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.FaqDTO;
import org.zerock.myapp.domain.ProductDTO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/**/root-*.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FaqSearchMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private FaqSearchMapper mapper;
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked");
		
		Objects.requireNonNull(this.mapper);
		log.info("\t+this.mapper:{}, type:{}", this.mapper, this.mapper.getClass().getName());
	} // beforeAll
	
	
	@Test
	@Order(1)
	@DisplayName("contextloads")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void contextloads() {
		log.trace("contextloads() invoked");
		
	} // contextloads
	
	@Test
	@Order(2)
	@DisplayName("테스트1: FaqSearch")
	@Timeout(value = 1, unit = TimeUnit.MINUTES)
	void FaqSearch() { // 상품 리스트 가져오기
		log.info("FaqSearch() invoked");
		
		Criteria cri = new Criteria();
		
		//테스트해볼 keyword 적기
		cri.setKeyword("공지");
		log.info("cri: " + cri);
		
		List<FaqDTO> list = this.mapper.faqSearchList(cri);
		log.info("list: " + list);
		
		Integer totalProduct = this.mapper.totalFaq(cri);
		log.info("total: " + totalProduct);
		
		
	} // FaqSearch

}
