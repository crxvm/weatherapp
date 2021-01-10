package com.example.weatherapp.exception;

import com.example.weatherapp.view.ErrorView;
import feign.FeignException;
import org.json.JSONException;
import org.springframework.cloud.openfeign.FeignErrorDecoderFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WeatherExceptionHandler {
    @ExceptionHandler(value = FeignException.class)
    public ResponseEntity<Object> error(FeignException e) {
        return new ResponseEntity<>(new ErrorView("wrong data"),HttpStatus.BAD_REQUEST);
    }
}
