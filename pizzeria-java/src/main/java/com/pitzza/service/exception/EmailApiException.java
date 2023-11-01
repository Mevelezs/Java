package com.pitzza.service.exception;

/**
 Class for send an exception ( this class causes the method that uses it to fail )
 */
public class EmailApiException extends RuntimeException {
  public EmailApiException (){
    super("Error sending email...");
  }
}
