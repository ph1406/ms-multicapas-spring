package com.pablo.veterinaria.proyectouno.application.domain.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@ControllerAdvice
public class ErrorHandler {

    private static final String UNEXPECTED_ERROR="Exception.unexpected";
    private final MessageSource messageSource;


    @Autowired
    public ErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(DuenoNoExisteException.class)
    public ResponseEntity<ErrorInfo> handleNombreException(HttpServletRequest req, DuenoNoExisteException ex, Locale locale)
    {

        String mje = messageSource.getMessage("error.mascotasindueno", null, locale);


        ErrorInfo response = new ErrorInfo();
        response.setUrl(req.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<ErrorInfo>(response, HttpStatus.IM_USED);
    }


    @ExceptionHandler(MascotaEnTratamientoException.class)
    public ResponseEntity<ErrorInfo> handleNombreException(HttpServletRequest req, MascotaEnTratamientoException ex, Locale locale)
    {

        String mje = messageSource.getMessage("error.mascotatratamiento", null, locale);


        ErrorInfo response = new ErrorInfo();
        response.setUrl(req.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<ErrorInfo>(response, HttpStatus.IM_USED);
    }


    @ExceptionHandler(MascotaDuplicadaException.class)
    public ResponseEntity<ErrorInfo> handleNombreException(HttpServletRequest req, MascotaDuplicadaException ex, Locale locale)
    {

        String mje = messageSource.getMessage("error.mascotaduplicada", null, locale);


        ErrorInfo response = new ErrorInfo();
        response.setUrl(req.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<ErrorInfo>(response, HttpStatus.IM_USED);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> handleException(Exception ex, Locale locale) {
        String errorMessage = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);
        return new ResponseEntity<>(new ErrorInfo(errorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
