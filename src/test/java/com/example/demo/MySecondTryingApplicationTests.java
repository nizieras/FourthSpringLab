package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MySecondTryingApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void stringToUpCaseTest() throws Exception {
		this.mockMvc.perform(get("/toUpCase?string=yourString"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("YOURSTRING"));
	}

	@Test
	void stringToLowCaseTest() throws Exception {
		this.mockMvc.perform(get("/toLowCase?string=YOURSTRING"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("yourstring"));
	}

	@Test
	void stringUnionTest() throws Exception {
		this.mockMvc.perform(get("/union?string=yourString&secString=yourSecString"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("yourStringyourSecString"));
	}

}
