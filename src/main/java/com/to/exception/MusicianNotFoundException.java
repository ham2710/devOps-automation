package com.to.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MusicianNotFoundException extends RuntimeException{

	public MusicianNotFoundException(String musician) {
		super(musician);
	}
	
	public MusicianNotFoundException(String musician, Throwable cause) {
		super(musician, cause);
	}
}
