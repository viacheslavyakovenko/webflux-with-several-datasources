package com.wfwsds.model;

public class CreditCardRes implements ExternalDataRes {

  public static final CreditCardRes CC_RES_ERROR
      = new CreditCardRes(Errors.DEFAULT);

  private Integer userId;
  private String cardNo;
  private Errors errors;

  public CreditCardRes() {
    super();
  }

  public CreditCardRes(Integer userId, String cardNo) {
    this.userId = userId;
    this.cardNo = cardNo;
  }

  public CreditCardRes(Errors errors) {
    this.errors = errors;
  }

  public Integer getUserId() {
    return userId;
  }

  public String getCardNo() {
    return cardNo;
  }

  public Errors getErrors() {
    return errors;
  }

  @Override
  public String toString() {

    if (this.errors != null && this.errors.isError()) {
      return "CreditCaredRes{"
          + this.errors + "}";
    }

    return "CreditCaredRes{" +
        "userId=" + userId +
        ", cardNo='" + cardNo + '\'' +
        '}';
  }
}
