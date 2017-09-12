package com.epro.infrastructure.security;

/**
 * @author Nattawut Verarattakul
 */
public class UserDetailsException extends RuntimeException {

	private static final long serialVersionUID = 307747092779943932L;

	public UserDetailsException(String message) {
        super(message);
    }

    public UserDetailsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDetailsException(Throwable cause) {
        super(cause);
    }

}