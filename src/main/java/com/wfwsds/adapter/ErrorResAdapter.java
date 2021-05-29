package com.wfwsds.adapter;

import com.wfwsds.model.ExternalDataRes;
import org.springframework.stereotype.Service;

@Service("ErrorResAdapter")
public class ErrorResAdapter implements ExternalDataResAdapter {

  public ExternalDataRes postProcess(ExternalDataRes res) {

    return res;
  }
}
