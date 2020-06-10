package com.livelo.application.client.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodes {

  INTERNAL_SERVER_ERROR("Internal server error"),
  INVALID_REQUEST("Invalid request"),
  VALIDATION_FAILED("Validation failed"),
  USER_NOT_FOUND("User not found"),
  INVALID_DATE("Invalid date");

  private final String message;

}
