package com.wfwsds.model;

import java.util.ArrayList;
import java.util.List;

class Errors {

  private final List<String> errorsList;

  public Errors(String error) {

    this.errorsList = new ArrayList<String>();
    this.errorsList.add(error);
  }

  public boolean isError(){

    return !this.errorsList.isEmpty();
  }

  @Override
  public String toString() {
    return "Errors{" +
        "errorsList=" + errorsList +
        '}';
  }
}
