package com.to.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BandNotFoundException extends RuntimeException{

	public BandNotFoundException(String band) {
		super(band);
	}
	
	
	public BandNotFoundException(String band, Throwable cause) {
		super(band, cause);
	}
}
