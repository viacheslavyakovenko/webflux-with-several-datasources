package com.wfwsds.adapter;

import com.wfwsds.model.ExternalDataRes;
import org.springframework.stereotype.Service;

@Service("StatisticResAdapter")
public class StatisticResAdapter implements ExternalDataResAdapter {

  public ExternalDataRes postProcess(ExternalDataRes res) {

    return res;
  }
}
