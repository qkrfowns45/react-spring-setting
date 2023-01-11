package com.newbietop.book.web;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

//단위테스트(controller만 테스트)Filter, ControllerAdvice

@WebMvcTest//spring에서 class확장이 필요하다 @WebMvcTest안에 @ExtendWith(SpringExtension.class)가 없으면 붙여줘야한다.Junit5에서는 포함되어 있지만 4에는 없다
public class BookControllerUnitTest {

}
