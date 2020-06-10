package com.livelo.application.client.exceptions.handler.response;

import com.livelo.application.client.constants.ErrorCodes;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private String message;
    private List<String> details;

    public ExceptionResponse(ErrorCodes errorCode, List<String> details) {
        this.code = errorCode.name();
        this.message = errorCode.getMessage();
        this.details = details;
    }

}
