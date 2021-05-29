package com.wfwsds.service;

import com.wfwsds.adapter.ExternalDataAdapterContext;
import com.wfwsds.model.ErrorRes;
import com.wfwsds.model.ExternalDataRes;
import com.wfwsds.model.ProductDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import reactor.core.Scannable;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

  private final ApplicationContext context;
  private final ExternalDataAdapterContext externalDataAdapterContext;

  @Autowired
  public ProductService(ApplicationContext context,
      ExternalDataAdapterContext externalDataAdapterContext) {

    this.context = context;
    this.externalDataAdapterContext = externalDataAdapterContext;

  }

  public Mono<ProductDto> process() {

    // TODO: 1. set up monos list which will be called in parallel
    //  based on Req & CustomerConfiguration information
    List<Mono<ExternalDataRes>> monos = setUpMonosList(/*req, customerConfig, etc.*/);

    // TODO: 2. make a call for CreditFile (to DataService Layer)
    // TODO: 3. make a parallel calls to External Data Sources
    Mono<ProductDto> mono = aggregateResults(monos);
    // TODO: 4. set up processor list based on Req, CustomerConfiguration information and CreditFile
    // TODO: 5. make a call for External Data Sources dependant on CreditFile
    // TODO: 6. aggregate the resulted monos into ProductDto

    return mono;
  }

  private List<Mono<ExternalDataRes>> setUpMonosList() {

    List<Mono<ExternalDataRes>> monos = new ArrayList<>();

    monos.add((Mono<ExternalDataRes>) context.getBean("MonoUserRes"));
    monos.add((Mono<ExternalDataRes>) context.getBean("MonoStatisticRes"));
    monos.add((Mono<ExternalDataRes>) context.getBean("MonoCreditCardRes"));
    monos.add((Mono<ExternalDataRes>) context.getBean("MonoBookRes"));

    return monos;
  }

  private Mono<ProductDto> aggregateResults(List<Mono<ExternalDataRes>> monos) {

    ProductDto productDto = new ProductDto();

    // Error handling how-to: https://www.baeldung.com/spring-webflux-errors
    try {

      for (Mono<ExternalDataRes> mono : monos) {
        mono
            .log()
            .onErrorReturn(new ErrorRes("Put error message here"))
            .flatMap(
                value -> Mono.just(externalDataAdapterContext
                    .postProcess(value))) // postprocessing example - UpperCase for Users names
            .subscribe(
                value -> { // start parallel calls
                  productDto.concat(value.toString()); // aggregation example
                }
//                , error -> {
//                  productDto.concat(new ErrorRes("Error can be handled here also!").toString());
//                }
            );
      }

      for (Mono<? extends ExternalDataRes> mono : monos) {
        mono.block();
      }
    } catch (RuntimeException re) {
      // Nothing to do here for this example
    }
    return Mono.just(productDto);
  }

}