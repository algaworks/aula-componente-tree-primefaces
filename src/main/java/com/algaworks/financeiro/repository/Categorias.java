package com.algaworks.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.financeiro.model.Categoria;

public class Categorias implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Categoria> raizes() {
		return manager.createQuery("from Categoria where categoriaPai is null", Categoria.class)
				.getResultList();
	}
	
}