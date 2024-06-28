package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cuadro;

import com.example.demo.exceptions.ErrorCode;
import com.example.demo.exceptions.MiServiceException;
import com.example.demo.repositories.CuadroRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class CuadroServImpl implements CuadroService {

	@Autowired
	CuadroRepository cuadroRepository;

	@Override
	public List<Cuadro> findAll() throws MiServiceException {
		log.info("[findAll]");
		List<Cuadro> cuadros;

		try {
			cuadros = cuadroRepository.findAll();

		} catch (Exception e) {
			log.error("Exception", e);
			throw new MiServiceException(ErrorCode.ERROR_GENERAL);
		}
		return cuadros;

	}

	@Override
	public Cuadro save(Cuadro cuadro) {
		log.info("[save]");
		//try-catch
		return cuadroRepository.save(cuadro);
	}

	@Override
	public Cuadro findById(Long id) throws MiServiceException {
		log.info("[findById]");

		Cuadro cuadro;
		try {
			Optional<Cuadro> cuadroAux = cuadroRepository.findById(id);
			if (!cuadroAux.isPresent())
				throw new MiServiceException(ErrorCode.CUADRO_NOT_FOUND);
			cuadro = cuadroAux.get();
		} catch (MiServiceException mse) {
			log.error("MiServiceException", mse);
			throw mse;
		} catch (Exception e) {
			log.error("Exception", e);
			throw new MiServiceException(ErrorCode.ERROR_GENERAL);
		}
		return cuadro;

	}

	@Override
	public Cuadro deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
