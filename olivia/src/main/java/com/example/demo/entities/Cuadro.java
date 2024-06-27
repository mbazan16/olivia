package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Cuadro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nombre;

	@Column
	private String autor;

	@Enumerated(EnumType.STRING)
	private TipoCuadro tipo;

	public enum TipoCuadro {
		OLEO, ACUARELA, PASTEL
	}

}
