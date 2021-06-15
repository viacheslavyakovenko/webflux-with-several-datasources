package com.wfwsds.model;

public class ProductDto {

  private final StringBuilder data = new StringBuilder();

  public void concat(String s) {
    data.append(s);
  }

  public void concat(ExternalDataRes response) {
    concat(response.toString());
  }


  @Override
  public String toString() {

    return "ProductDto{" +
        "data=" + data.toString() +
        '}';
  }
}
