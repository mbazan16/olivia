package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.exceptions.ErrorCode;
import com.example.demo.exceptions.MessError;
import com.example.demo.exceptions.MiServiceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ErrorHadler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String errorGeneralHadler(Model model) {
		log.info("[errorGeneralHadler]");
		log.debug("[messError:" + MessError.ERROR_GENERAL + "]");
		//
		model.addAttribute("messError", MessError.ERROR_GENERAL);
		return "error";
	}

	@ExceptionHandler(MiServiceException.class)
	public String servicioExceptionHadler(MiServiceException e, Model model) {
		log.info("[servicioExceptionHadler]");
		if (ErrorCode.CUADRO_NOT_FOUND.equals(e.getCodigo())) {
			log.debug("[mesError:" + MessError.CUADRO_NOT_FOUND + "]");
			model.addAttribute("messError", MessError.CUADRO_NOT_FOUND);
			return "cuadros"; // Volvemos a la vista de cuadros
		}
		log.debug("[messError:" + MessError.ERROR_GENERAL + "]");
		model.addAttribute("messError", MessError.ERROR_GENERAL);
		return "error"; // Volvemos a la vista de errores
	}

}
