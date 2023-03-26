package com.masai.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor

public class MyErrorDetails {
	private LocalDateTime timeStamp;
    private String message;
    private String errorDetails;
}
