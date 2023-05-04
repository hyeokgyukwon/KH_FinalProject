package org.zerock.myapp.service;

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
import org.zerock.myapp.domain.QuestionDTO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/**/root-context.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class QuestionServiceTests {

	@Setter(onMethod_ = @Autowired)
	private QuestionService questionService;

	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked");

		Objects.requireNonNull(this.questionService);

		log.trace("this.mapper{}, type {}", this.questionService, this.questionService.getClass().getName());

	} // beforeAll

//	@Disabled
	@Test
	@DisplayName("write")
	@Order(1)
	@Timeout(value = 1, unit = TimeUnit.MINUTES)
	public void write() {
		log.trace("write invoked");

		QuestionDTO  questionDTO= new QuestionDTO();

		questionDTO.setType("service test");
		questionDTO.setTitle("service test");
		questionDTO.setContent("service test");

		questionService.write(questionDTO);
	}

} // end class
