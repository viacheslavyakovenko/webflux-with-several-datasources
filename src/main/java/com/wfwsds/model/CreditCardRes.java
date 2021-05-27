package com.wfwsds.model;

public class CreditCardRes implements ExternalDataRes {

  private Integer userId;
  private String cardNo;

  public CreditCardRes(){
    super();
  }

  public CreditCardRes(Integer userId, String cardNo) {
    this.userId = userId;
    this.cardNo = cardNo;
  }

  public Integer getUserId() {
    return userId;
  }

  public String getCardNo() {
    return cardNo;
  }

  @Override
  public String toString() {
    return "CreditCaredRes{" +
        "userId=" + userId +
        ", cardNo='" + cardNo + '\'' +
        '}';
  }
}
