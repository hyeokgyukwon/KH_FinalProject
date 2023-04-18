package org.zerock.myapp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import org.zerock.myapp.domain.MemberDTO;
import org.zerock.myapp.domain.MemberVO;
import org.zerock.myapp.exception.ServiceException;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/root-*.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserInfoServiceTests {
	
	@Setter(onMethod_=@Autowired)
	private UserInfoService service;
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeall() invoked");
	} // beforeall
	
	@Test
	@Order(1)
	@DisplayName("contextloads")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void contextloads() {
		log.trace("contextloads");
	} // contextloads
	
	@Test
	@Order(2)
	@DisplayName("테스트1: testuserDetail")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testuserDetail() throws ServiceException{
		log.trace("testuserDetail() invoked");
		
		String id = "nicknamebyul";
		MemberDTO dto = this.service.userDetail(id);
		
		assertNotNull(dto);
		
		log.info("\t+ dto : {}", dto);
	} // testuserDetail
	
	@Test
	@Order(3)
	@DisplayName("테스트2: testupdateUser")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testupdateUser() throws ServiceException{
		log.trace("testupdateUser() invoked");
		
//		MemberDTO userid = this.service.userDetail("dfkda");
		
		MemberDTO dto = new MemberDTO();
		dto.setId("dfkda");
		dto.setPassword("1994");
		dto.setName("최귤이");
		dto.setEmail("byul2@naver.com");
		dto.setTel("010-1003-1994");
		dto.setAddress1(12345);
		dto.setAddress2("역삼동");
		dto.setAddress3("고오오오시워어언");
		
		Boolean success = this.service.updateUser(dto);
		
		log.info("\t+ success : {}", success);
	} // testupdateUser
	
	@Test
	@Order(4)
	@DisplayName("테스트3: testudeleteUser")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testudeleteUser() throws ServiceException{
		log.trace("testudeleteUser() invoked");
		
		String id = "fjidas";

		Boolean success = this.service.deleteUser(id);
		
		log.info("\t+ success : {}", success);
	} // testudeleteUser

}