package com.poor.billy.exceptions;

import com.poor.billy.dto.ErrorsDTO;
import com.poor.billy.dto.FieldErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    /**
     * NotFoundException
     *
     * @param ex - exception param
     * @return message
     */
    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String NotFoundHandler(EntityNotFoundException ex) {
        return ex.getMessage();
    }

    /**
     * BadRequestException
     *
     * @param ex
     * @return message
     */
    @ResponseBody
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsDTO BadRequestHandler(BadRequestException ex) {

        ErrorsDTO errorsDTO = new ErrorsDTO();
        errorsDTO.setServerError(ex.getMessage());

        return errorsDTO;
    }

    /**
     * ResponseEntity HANDLE
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return new ResponseEntity<>
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        List<FieldErrorDTO> fieldErrors = new ArrayList<>();

        List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();

        for (ObjectError o : objectErrors) {

            String fieldName = ((FieldError) o).getField();
            String errorMessage = o.getDefaultMessage();

            FieldErrorDTO fieldErrorDTO = new FieldErrorDTO();
            fieldErrorDTO.setField(fieldName);
            fieldErrorDTO.setMessage(errorMessage);

            fieldErrors.add(fieldErrorDTO);

        }
        ErrorsDTO errorsDTO = new ErrorsDTO();
        errorsDTO.setValidationErrors(fieldErrors);

        return new ResponseEntity<>(errorsDTO, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}