package com.wfwsds.adapter;

import com.wfwsds.model.ExternalDataRes;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ExternalDataAdapterContext {

  private static final String ADAPTER_SUFFIX = "Adapter";

  private final ApplicationContext context;

  public ExternalDataAdapterContext(ApplicationContext context) {

    this.context = context;
  }

  public ExternalDataRes postProcess(ExternalDataRes externalDataRes) {

    String adapterBeanName = externalDataRes.getClass().getSimpleName() + ADAPTER_SUFFIX;
    ExternalDataResAdapter adapter = (ExternalDataResAdapter) context.getBean(adapterBeanName);

    return adapter.postProcess(externalDataRes);
  }
}