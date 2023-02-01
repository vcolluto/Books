package org.lessons.java;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private String titolo;
	private int numeroPagine;
	private String autore;
	private String editore;
	private List<Exception> errori=new ArrayList<>();
	
	public Book(String titolo, int numeroPagine, String autore, String editore)  {
		super();
	/*	try {
			setTitolo(titolo);
		} catch (Exception e) {			
			this.titolo="undefined";
		} 
		try {
			setNumeroPagine(numeroPagine);
		} catch (Exception e1) {
			this.numeroPagine=1;
		}
		try {
			setAutore(autore);
		} catch (Exception e) {
			this.autore="undefined";
		}
		try {
			setEditore(editore);
		} catch (Exception e) {
			this.editore="undefined";
		} */
		
		
		
		try {
			setTitolo(titolo);
		} catch (Exception e) {
			errori.add(e);
		}
		try {
			setAutore(autore);
		} catch (Exception e) {
			errori.add(e);
		}
		try {
			setNumeroPagine(numeroPagine);
		} catch (Exception e) {
			errori.add(e);
		}
		try {
			setEditore(editore);
		} catch (Exception e) {
			errori.add(e);
		}
		
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) throws Exception {
		if (titolo.isEmpty())
			throw new Exception("Empty title");
		else
			this.titolo = titolo;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) throws Exception {
		if (numeroPagine<=0)
			throw new Exception("pages must be a positive number");
		else
			this.numeroPagine = numeroPagine;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) throws Exception {
		if (autore.isEmpty())
			throw new Exception("Empty author");
		else
			this.autore = autore;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) throws Exception {
		if (editore.isEmpty())
			throw new Exception("Empty publisher");
		else
			this.editore = editore;
	}
	
	public List<Exception> getErrori() {
		return errori;
	}

	@Override
	public String toString() {
		return "Book [titolo=" + titolo + ", numeroPagine=" + numeroPagine + ", autore=" + autore + ", editore="
				+ editore + "]";
	}
	
	

}
