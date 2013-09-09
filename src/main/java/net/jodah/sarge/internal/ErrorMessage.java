package net.jodah.sarge.internal;

import java.io.Serializable;

import net.jodah.sarge.internal.util.Assert;

/**
 * An error message.
 */
public final class ErrorMessage implements Serializable {
  private static final long serialVersionUID = 0;
  private final Throwable cause;
  private final String message;

  /**
   * Creates an ErrorMessage for the given {@code message}.
   */
  public ErrorMessage(String message) {
    this(message, null);
  }

  /**
   * Creates an ErrorMessage for the given {@code message} and {@code cause}.
   */
  public ErrorMessage(String message, Throwable cause) {
    this.message = Assert.notNull(message, "message");
    this.cause = cause;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ErrorMessage))
      return false;
    ErrorMessage e = (ErrorMessage) o;
    return message.equals(e.message) && cause.equals(e.cause);
  }

  /**
   * Returns the Throwable that caused the error or {@code null} if no Throwable caused the error.
   */
  public Throwable getCause() {
    return cause;
  }

  /**
   * Returns the error message.
   */
  public String getMessage() {
    return message;
  }

  @Override
  public int hashCode() {
    return message.hashCode();
  }

  @Override
  public String toString() {
    return message;
  }
}