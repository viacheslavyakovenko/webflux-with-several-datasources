package com.wfwsds.model;

public class UserRes implements ExternalDataRes {

  public static final UserRes USER_RES_ERROR
      = new UserRes(Errors.DEFAULT);

  private String userId;
  private String firstName;
  private String lastName;
  private Errors errors;

  public UserRes() {
    super();
  }

  public UserRes(String userId, String firstName, String lastName) {
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public UserRes(Errors errors) {
    this.errors = errors;
  }

  public String getUserId() {
    return userId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Errors getErrors() {
    return errors;
  }

  @Override
  public String toString() {

    if (this.errors != null && this.errors.isError()) {
      return "UserRes{"
          + this.errors + "}";
    }

    return "UserRes{" +
        "userId='" + userId + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}

