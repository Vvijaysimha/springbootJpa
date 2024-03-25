package com.vijay.productservice;//package com.vijay.productservice;
//
//import com.mongodb.assertions.Assertions;
//import com.vijay.productservice.DTO.ProductRequest;
//import com.vijay.productservice.Repository.ProductRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.testcontainers.containers.MongoDBContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
//import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
//import org.testcontainers.shaded.com.github.dockerjava.core.MediaType;
//
//import java.math.BigDecimal;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@Testcontainers
//@AutoConfigureMockMvc
//class ProductServiceApplicationTests {
//	@Autowired
//	private MockMvc mockMvc;
//	@Autowired
//	private ObjectMapper objectMapper;
//	@Container
//	static MongoDBContainer mongoDBContainer=new MongoDBContainer("mongo:4.4.2");
//	@Autowired
//	private ProductRepository productRepository;
//
//    @DynamicPropertySource
//	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
//		dynamicPropertyRegistry.add("spring.data.mongodb.uri",
//				mongoDBContainer::getReplicaSetUrl);
//	}
//	@Test
//	void shouldCreateProduct() throws Exception {
//    	ProductRequest productRequest=getProductRequest();
//    	String productRequestString=objectMapper.writeValueAsString(productRequest);
//
//    	mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
//				.contentType(String.valueOf(MediaType.APPLICATION_JSON))
//				.contentType(productRequestString))
//				.andExpect(status().isCreated());
//		Assertions.assertTrue(productRepository.findAll().size()==1);
//	}
//
//
//	private ProductRequest getProductRequest() {
//    	return ProductRequest.builder()
//				.name("iphone13")
//				.description("iphone13")
//				.price(BigDecimal.valueOf(130000))
//				.build();
//	}
//
//}
