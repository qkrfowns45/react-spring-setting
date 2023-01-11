package com.newbietop.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

//통합테스트(모든 Bean들을 똑같이 Ioc 올리고 테스트 하는 것)

@Transactional //각각의 테스트함수가 종료될때마다 롤백해주는 트랜잭션이다.
@AutoConfigureMockMvc //통합테스트에선 이게 있어야 ioc에 등록해줌
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)//Mock은 실제 톰켓을 올리는게 아니라 다른 톰켓으로 테스트
public class BookControllerIntegreTest {
	
	@Autowired
	private MockMvc mockMvc;
}
