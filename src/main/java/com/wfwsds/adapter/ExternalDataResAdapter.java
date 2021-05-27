package com.wfwsds.adapter;

import com.wfwsds.model.ExternalDataRes;

@FunctionalInterface
public interface ExternalDataResAdapter {

  ExternalDataRes postProcess(ExternalDataRes in);
}
