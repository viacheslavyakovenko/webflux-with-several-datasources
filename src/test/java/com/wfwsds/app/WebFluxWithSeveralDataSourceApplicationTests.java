package com.wfwsds.app;

import com.wfwsds.model.ProductDto;
import com.wfwsds.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebFluxWithSeveralDataSourceApplicationTests {

  @Autowired
  ProductService productService;

  @Test
  public void showProductDto() {

    System.out.println(" *** \n");
    Mono<ProductDto> mono = productService.process();
    mono.subscribe(System.out::println);
  }

}
