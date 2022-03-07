package com.training.ms.error;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestErrorAdvice {

    @Autowired
    private MicroserviceInfo msi;

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final IllegalArgumentException exp) {
        return this.createBaseError()
                   .setDesc(exp.getMessage())
                   .setErrorCode(1002);
    }

    private ErrorObj createBaseError() {
        return ErrorObj.create()
                       .setBoundedcontext(this.msi.getBoundedContext())
                       .setMicroservice(this.msi.getName());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final MethodArgumentNotValidException exp) {
        ErrorObj rootErrorLoc = this.createBaseError()
                                    .setDesc("Validation error")
                                    .setErrorCode(1002);
        List<ObjectError> allErrorsLoc = exp.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            rootErrorLoc.addSuberror(this.createBaseError()
                                         .setDesc(objectErrorLoc.toString())
                                         .setErrorCode(1003));
        }
        return rootErrorLoc;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorObj handleException(final ConstraintViolationException exp) {
        ErrorObj rootErrorLoc = this.createBaseError()
                                    .setDesc("Validation error")
                                    .setErrorCode(1002);
        Set<ConstraintViolation<?>> allErrorsLoc = exp.getConstraintViolations();
        for (ConstraintViolation<?> objectErrorLoc : allErrorsLoc) {
            rootErrorLoc.addSuberror(this.createBaseError()
                                         .setDesc(objectErrorLoc.toString())
                                         .setErrorCode(1003));
        }
        return rootErrorLoc;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handleException(final Exception exp) {
        exp.printStackTrace();

        if (exp instanceof NullPointerException) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                                 .header("xyz",
                                         "deneme")
                                 .body(this.createBaseError()
                                           .setDesc("beklenmedik bir olay")
                                           .setErrorCode(1002));
        } else if (exp instanceof HttpRequestMethodNotSupportedException) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                                 .body(this.createBaseError()
                                           .setDesc("Yanlış http metodu girdiniz")
                                           .setErrorCode(10008));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .header("xyz",
                                         "deneme")
                                 .body(this.createBaseError()
                                           .setDesc(exp.getMessage())
                                           .setErrorCode(1002));
        }
    }
}
