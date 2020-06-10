package com.livelo.application.client.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ValidDateConstraintValidation implements ConstraintValidator<ValidDate, Object> {

  private DateTimeFormatter formatter;

  @Override
  public void initialize(ValidDate annotation) {
    formatter = DateTimeFormatter.ofPattern(annotation.format());
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    try {
      if (Objects.isNull(value)) {
        return true;
      }
      boolean isLocalDateTime = value.toString().split(":").length > 1;
      if (isLocalDateTime) {
        LocalDateTime.parse(value.toString(), formatter);
      } else {
        LocalDate.parse(value.toString(), formatter);
      }
    } catch (Exception ex) {
      return false;
    }
    return true;
  }
}