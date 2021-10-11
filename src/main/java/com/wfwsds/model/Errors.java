package com.wfwsds.model;

import java.util.ArrayList;
import java.util.List;

public class Errors {

  public static Errors DEFAULT = new Errors("Contains error!");
  public static Errors TIMEOUT = new Errors("Timeout occurred!");


  private final List<String> errorsList;

  public Errors(String error) {

    this.errorsList = new ArrayList<String>();
    this.errorsList.add(error);
  }

  public boolean isError() {

    return !this.errorsList.isEmpty();
  }

  @Override
  public String toString() {
    return "Errors{" +
        "errorsList=" + errorsList +
        '}';
  }
}
