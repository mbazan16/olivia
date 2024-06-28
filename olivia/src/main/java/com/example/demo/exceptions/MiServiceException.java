package com.example.demo.exceptions;

@SuppressWarnings("serial")

public class MiServiceException extends Exception {

	final String codigo;

	public MiServiceException(String codigo, Exception e) {
		super(e.getMessage());
		this.codigo = codigo;
	}

	public MiServiceException(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return this.codigo;
	}

}
