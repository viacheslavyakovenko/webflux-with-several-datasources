package com.wfwsds;

import com.wfwsds.model.BookRes;
import com.wfwsds.model.CreditCardRes;
import com.wfwsds.model.StatisticRes;
import com.wfwsds.model.UserRes;
import java.time.Duration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
public class WebFluxWithSeveralDataSourceApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebFluxWithSeveralDataSourceApplication.class, args);
  }

  @Bean("MonoUserRes")
  public Mono<UserRes> userData() {
    WebClient client = WebClient.create("http://127.0.0.1:3001");
    return client.get().uri("/user").retrieve().bodyToMono(UserRes.class)
        .timeout(Duration.ofMillis(1000L)).subscribeOn(
            Schedulers.elastic());
  }

  @Bean("MonoCreditCardRes")
  public Mono<CreditCardRes> creditCardData() {
    WebClient client = WebClient.create("http://127.0.0.1:3002");
    return client.get().uri("/creditcard").retrieve().bodyToMono(CreditCardRes.class)
        .timeout(Duration.ofMillis(1000L)).subscribeOn(
            Schedulers.elastic());
  }

  @Bean("MonoBookRes")
  public Mono<BookRes> bookData() {
    WebClient client = WebClient.create("http://127.0.0.1:3003");
    return client.get().uri("/book").retrieve().bodyToMono(BookRes.class)
        .timeout(Duration.ofMillis(1000L)).subscribeOn(
            Schedulers.elastic());
  }

  @Bean("MonoStatisticRes")
  public Mono<StatisticRes> statisticData() {
    WebClient client = WebClient.create("http://127.0.0.1:3004");
    return client.get().uri("/statistic").retrieve().bodyToMono(StatisticRes.class)
        .timeout(Duration.ofMillis(1000L)).subscribeOn(
            Schedulers.elastic());
  }
}