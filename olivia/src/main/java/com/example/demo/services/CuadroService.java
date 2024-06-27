package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Cuadro;
import com.example.demo.exceptions.MiServiceException;


public interface CuadroService {

	List<Cuadro> findAll()throws MiServiceException;
	Cuadro save(Cuadro cuadro)throws MiServiceException;
	Cuadro findById (Long id) throws MiServiceException;
	Cuadro deleteById (Long id) throws MiServiceException; 
}
