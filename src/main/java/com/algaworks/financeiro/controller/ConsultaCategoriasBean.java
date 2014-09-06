package com.algaworks.financeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.algaworks.financeiro.model.Categoria;
import com.algaworks.financeiro.repository.Categorias;

@Named
@ViewScoped
public class ConsultaCategoriasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categorias categorias;
	
	private TreeNode raiz;
	
	public void consultar() {
		List<Categoria> categoriasRaizes = categorias.raizes();
		
		this.raiz = new DefaultTreeNode("Raiz", null);
		
		adicionarNos(categoriasRaizes, this.raiz);
	}
	
	private void adicionarNos(List<Categoria> categorias, TreeNode pai) {
		for (Categoria categoria : categorias) {
			TreeNode no = new DefaultTreeNode(categoria, pai);
			
			adicionarNos(categoria.getSubcategorias(), no);
		}
	}

	public TreeNode getRaiz() {
		return raiz;
	}

}