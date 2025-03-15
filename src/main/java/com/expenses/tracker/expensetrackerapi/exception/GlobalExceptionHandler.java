package com.expenses.tracker.expensetrackerapi.exception;

import com.expenses.tracker.expensetrackerapi.dto.ErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(value = ResourceNotFoundException.class)
        public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage(ex.getMessage());
            errorDetails.setTimestamp(LocalDateTime.now());
            errorDetails.setDetails(request.getDescription(false));

            return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

        }

    @ExceptionHandler(ApplicationAPIException.class)
    public ResponseEntity<ErrorDetails> handleApplicationAPIException(ApplicationAPIException exception,
                                                               WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(exception.getMessage());
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setDetails(webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    // global exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex,
                                                              WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setDetails(request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
//                                                                        WebRequest webRequest){
//        Map<String, String> errors = new HashMap<>();
//        exception.getBindingResult().getAllErrors().forEach((error) ->{
//            String fieldName = ((FieldError)error).getField();
//            String message = error.getDefaultMessage();
//            errors.put(fieldName, message);
//        });
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }


    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<ErrorDetails> handleAccessDeniedException(AccessDeniedException ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setDetails(request.getDescription(false));

        return  new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);

    }



}
