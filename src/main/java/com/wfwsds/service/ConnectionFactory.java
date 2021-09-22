package com.wfwsds.service;

import com.wfwsds.model.BookRes;
import com.wfwsds.model.CreditCardRes;
import com.wfwsds.model.ErrorRes;
import com.wfwsds.model.ExternalDataRes;
import com.wfwsds.model.StatisticRes;
import com.wfwsds.model.UserReq;
import com.wfwsds.model.UserRes;
import java.time.Duration;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class ConnectionFactory {

  public Mono<? extends ExternalDataRes> userData() {
    WebClient client = WebClient.create("http://127.0.0.1:3001");
    return client.get().uri("/user").retrieve().bodyToMono(UserRes.class)
        .timeout(Duration.ofMillis(1000L)).subscribeOn(
            Schedulers.elastic());
  }

  public Mono<? extends ExternalDataRes> creditCardData() {
    WebClient client = WebClient.create("http://127.0.0.1:3002");
    return client.get().uri("/creditcard").retrieve().bodyToMono(CreditCardRes.class)
        .timeout(Duration.ofMillis(1000L)).subscribeOn(
            Schedulers.elastic());
  }

  public Mono<? extends ExternalDataRes> bookData() {
    WebClient client = WebClient.create("http://127.0.0.1:3003");
    return client
        .get()
        .uri("/book")
        .retrieve()
        .bodyToMono(BookRes.class)
        .log("WebClient.book")
        .timeout(Duration.ofMillis(1000L))
        .onErrorResume(throwable -> {
          return Mono.just(BookRes.BOOK_RES_ERROR);
        })
        .subscribeOn(Schedulers.elastic());
  }

  public Mono<? extends ExternalDataRes> statisticData() {
    WebClient client = WebClient.create("http://127.0.0.1:3004");
    return client.get().uri("/statistic").retrieve().bodyToMono(StatisticRes.class)
        .timeout(Duration.ofMillis(1000L)).subscribeOn(
            Schedulers.elastic());
  }

  public Mono<? extends ExternalDataRes> postUserData(UserReq userReq) {

    WebClient client = WebClient.create("http://127.0.0.1:3001");

    Mono<UserRes> userResMono = client.post()
        .uri("/user/add")
        .body(Mono.just(userReq), UserReq.class)
        .retrieve()
        .bodyToMono(UserRes.class)
        .timeout(Duration.ofMillis(1000L))
        .subscribeOn(Schedulers.elastic());

    return (Mono<? extends ExternalDataRes>) userResMono;
  }

}