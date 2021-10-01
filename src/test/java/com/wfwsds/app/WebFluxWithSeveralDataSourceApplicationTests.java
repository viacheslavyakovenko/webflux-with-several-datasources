package com.wfwsds.app;

import com.wfwsds.model.ExternalDataRes;
import com.wfwsds.model.ProductDto;
import com.wfwsds.model.UserReq;
import com.wfwsds.service.ConnectionFactory;
import com.wfwsds.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WebFluxWithSeveralDataSourceApplicationTests {

  @Autowired
  ProductService productService;

  @Autowired
  ConnectionFactory connectionFactory;

  @Test
  public void tesProductDto() {

    Mono<ProductDto> mono = productService.process();
    StepVerifier.create(mono.log())
        .expectNextMatches(productDto -> productDto.toString().startsWith("ProductDto{"))
        .verifyComplete();
  }

  @Test
  public void testCreditCardHiddenDigits() {

    Mono<ProductDto> mono = productService.process();
    StepVerifier.create(mono.log())
        .expectNextMatches(productDto -> productDto.toString().contains("cardNo='**** **** ****"))
        .verifyComplete();
  }

  @Test
  public void testAddUserByPost() {

    Mono<? extends ExternalDataRes> monoUserAddRes = connectionFactory
        .postUserData(new UserReq("100500", "testName", "testLastName"));

    StepVerifier.create(monoUserAddRes.log())
        .expectNextMatches(userRes -> userRes.toString().startsWith("UserRes{userId"))
        .verifyComplete();

  }

}