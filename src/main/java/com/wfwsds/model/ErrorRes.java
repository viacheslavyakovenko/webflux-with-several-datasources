package com.wfwsds.model;

public class ErrorRes implements ExternalDataRes{

  private String errorMsg;

  public ErrorRes(){
    super();
  }

  public ErrorRes(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  @Override
  public String toString() {
    return "ErrorRes{" +
        "errorMsg='" + errorMsg + '\'' +
        '}';
  }
}
