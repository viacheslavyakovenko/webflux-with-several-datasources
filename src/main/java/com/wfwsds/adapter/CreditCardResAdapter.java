package com.wfwsds.adapter;

import com.wfwsds.model.CreditCardRes;
import com.wfwsds.model.ExternalDataRes;
import org.springframework.stereotype.Service;

@Service("CreditCardResAdapter")
public class CreditCardResAdapter implements ExternalDataResAdapter {

  public ExternalDataRes postProcess(ExternalDataRes res) {

    CreditCardRes in = (CreditCardRes) res;
    if (in.getErrors() != null && in.getErrors().isError()) {
      return in;
    }

    // TODO: any filtering, postprocessing
    return new CreditCardRes(in.getUserId(), "**** **** **** " + in.getCardNo().substring(12));
  }

}