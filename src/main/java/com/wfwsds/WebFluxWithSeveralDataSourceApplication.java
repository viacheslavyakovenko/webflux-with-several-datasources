package com.wfwsds;

import com.wfwsds.model.BookRes;
import com.wfwsds.model.CreditCardRes;
import com.wfwsds.model.StatisticRes;
import com.wfwsds.model.UserRes;
import java.time.Duration;
import org.reactivestreams.Publisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
public class WebFluxWithSeveralDataSourceApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebFluxWithSeveralDataSourceApplication.class, args);
  }

}