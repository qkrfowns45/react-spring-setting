package com.newbietop.book.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newbietop.book.domain.Book;

import lombok.extern.slf4j.Slf4j;

//통합테스트(모든 Bean들을 똑같이 Ioc 올리고 테스트 하는 것)

@Slf4j
@Transactional //각각의 테스트함수가 종료될때마다 롤백해주는 트랜잭션이다.
@AutoConfigureMockMvc //통합테스트에선 이게 있어야 ioc에 등록해줌
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)//Mock은 실제 톰켓을 올리는게 아니라 다른 톰켓으로 테스트
public class BookControllerIntegreTest {
	
	@Autowired
	private MockMvc mockMvc;

	//BDD mockito패턴 given when then
	@Test
	public void save_테스트() throws Exception {
		//given 테스트를 하기 위한 준비 
		
		Book book = new Book(null,"스프링 따라하기","newbietop"); //던질데이터 준비(given)
		
		String content = new ObjectMapper().writeValueAsString(book); //json으로 변환해서 나타나게 해준다.
		
		// when (테스트 실행)
		ResultActions resultActions = mockMvc.perform(post("/book")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(content)
				.accept(MediaType.APPLICATION_JSON_UTF8));
		
		//then (검증)
		resultActions.andExpect(status().isCreated()).andExpect(jsonPath("$.title").value("스프링 따라하기")).andDo(MockMvcResultHandlers.print());
	}
}
