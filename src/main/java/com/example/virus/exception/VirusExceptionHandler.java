package com.example.virus.exception;

import com.example.virus.dto.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class VirusExceptionHandler {

    @Autowired
    HttpServletRequest httpServletRequest;
    @ExceptionHandler(PatientIdNotFoundException.class)
    public ResponseEntity<ApiResponse> handlePatientIdNotFoundException(PatientIdNotFoundException e){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("Error");
        apiResponse.setPath(httpServletRequest.getRequestURI());
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMsg: ", e.getExceptionMsg());
        apiResponse.setError(errorMap);
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(apiResponse);
    }
}
