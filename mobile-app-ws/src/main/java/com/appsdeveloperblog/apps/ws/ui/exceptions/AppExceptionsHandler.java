package com.appsdeveloperblog.apps.ws.ui.exceptions;

import com.appsdeveloperblog.apps.ws.ui.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice // this annotation must be here so that framework will listen for exceptions
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

        String errorMessageDescrition = ex.getLocalizedMessage();
        if(errorMessageDescrition == null) errorMessageDescrition = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage("999", errorMessageDescrition, new Date());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
    public ResponseEntity<Object> handleSpecificException(Exception ex, WebRequest request) {

        String errorMessageDescrition = ex.getLocalizedMessage();
        if(errorMessageDescrition == null) errorMessageDescrition = ex.toString();

        String code = "999-NullPointerException";
        if(ex instanceof UserServiceException){
            code = "999-UserServiceException";
        }

        ErrorMessage errorMessage = new ErrorMessage(code, errorMessageDescrition, new Date());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
