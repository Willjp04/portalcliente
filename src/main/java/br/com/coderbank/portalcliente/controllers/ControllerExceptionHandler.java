package br.com.coderbank.portalcliente.controllers;

import br.com.coderbank.portalcliente.dtos.responses.ErrorResponseDTO;
import br.com.coderbank.portalcliente.exceptions.ClienteJaExistenteException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    @ExceptionHandler({ClienteJaExistenteException.class})
    public ErrorResponseDTO conflict(final Throwable exception) {

        final var  exceptionMessage = exception.getMessage();

        return new ErrorResponseDTO(exceptionMessage, System.currentTimeMillis());

    }

}
