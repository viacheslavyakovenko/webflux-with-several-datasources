package com.wfwsds.app;

import com.wfwsds.model.ErrorRes;
import com.wfwsds.model.ExternalDataRes;
import com.wfwsds.model.ProductDto;
import com.wfwsds.model.UserReq;
import com.wfwsds.model.UserRes;
import com.wfwsds.service.ProductService;
import com.wfwsds.util.ConnectionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebFluxWithSeveralDataSourceApplicationTests {

  @Autowired
  ProductService productService;

  @Autowired
  ApplicationContext context;

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