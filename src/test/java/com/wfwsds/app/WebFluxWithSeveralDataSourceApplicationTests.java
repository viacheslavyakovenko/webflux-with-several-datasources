package com.wfwsds.app;

import com.wfwsds.model.ProductDto;
import com.wfwsds.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebFluxWithSeveralDataSourceApplicationTests {

  @Autowired
  ProductService productService;

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
}