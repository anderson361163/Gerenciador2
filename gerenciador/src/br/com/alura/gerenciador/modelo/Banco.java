package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		lista.add(empresa);
		lista.add(empresa2);
	}
	
	/*
	 * LEMBRANDO QUE COMO É UM ATRIBUTO DA CLASSE
	 * A REFERENCIA É DA CLASSE E NÃO DO MÉTODO
	 * POR ISSO SE CHAMA A CLASE
	 */
	
	
	public void adicionar(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}
	
	public void removeEmpresa(Integer id) {
		
		
		/*
		 * 
		 *
		 * 
		 * Iterators são objetos padronizados
		 * que tem a capacidade de PERCORRER e 
		 * MANIPULAR OS ITEMS as 4 implementações
		 * de coleções do java que são:
		 *  
		 *  ArrayList;
		 *  LinkedList;
		 *  HashSet;
		 *  TreeSet.
		 *  
		 *  Já que todas estas implementações seguem a interface
		 *  Collection
		 *  
		 * Fonte muito boa: https://youtu.be/53cFp9P9ao8
		 */
		
		Iterator<Empresa> it = lista.iterator();
		
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
				it.remove();
			}
		}
		
		
		
// Isso se usava no java 1.5

//		for(Empresa empresa : lista) {
//			if(empresa.getId() == id) {
//				lista.remove(empresa);
//			}
//		}
	}

	public Empresa buscaEmpresaPeloId(Integer id) {

		for(Empresa empresa: lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		
		return null;
	}

}
