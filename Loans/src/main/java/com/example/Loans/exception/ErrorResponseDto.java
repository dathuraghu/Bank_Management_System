package com.example.Loans.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ErrorResponseDto {

    private String apiPath;

    private String errorMsg;

    private HttpStatus errorCode;

    private LocalDateTime errorTime;

}
