package com.hexaware.FTP125.util;


/**
 * This class provides a Error Code with a message and status.
 */
public class ErrorCode {
  private String message;
  private int status;
/**
 * This is a two parameterised constructor for Error Code.
 * @param argsMessage used to initialise if there is any error.
 * @param argsStatus used to display the HTTP status code.
 */
  public ErrorCode(final String argsMessage, final int argsStatus) {
    this.message = argsMessage;
    this.status = argsStatus;
  }
/**
 * This is a default constructor for Error Code Class.
 */
  public ErrorCode() {
    super();
  }
/**
 * @return to get message.
 */
  public final String getMessage() {
    return message;
  }


  /**
   * to return the status.
   * @return status to return the status.
   */
  public final int getStatus() {
    return status;
  }
}
