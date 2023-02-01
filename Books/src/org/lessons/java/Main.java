package org.lessons.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Vogliamo gestire il catalogo di libri di una biblioteca.

Un libro è composto da :
- titolo
- numero pagine
- autore
- editore

Scrivere un programma che inserisce n libri in un array.

Chiede i dati di un libro (titolo, numero pagine, autore, editore), istanzia un nuovo oggetto della classe Book e lo inserisce nell’array.
Lo fa per il numero di elementi previsti nell’array.

Quando vengono inseriti i dati, verificare che siano corretti (es. non accettare titolo o autore o editore vuoto, numero pagine ≤ 0). Se ci sono errori, lanciare un’eccezione e gestirla mostrando a video il tipo di errore.

Implementare i getter e setter di tutti gli attributi del libro gestendo anche in questo caso eventuali errori di dati non corretti (che generano quindi eccezione).

Al termine dell’inserimento scrivere tutti i dati dei libri in un file e in seguito rileggerli dal file e mostrarli a video
 * 
 * 
 */
public class Main {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Book[] elencoLibri=null;
		System.out.println("Quanti libri vuoi inserire? ");
		FileWriter fw;
		
		
		
			
		int n;
		try {
			 n= Integer.parseInt(s.nextLine());
			 
		} catch (NumberFormatException e) {
			
			n=0;
		}
		if (n<=0)
			System.out.println("Numero di libri non valido!");
		else
		
		 {
			
			elencoLibri=new Book[n];
			for(int i=0;i<elencoLibri.length;i++) {
				System.out.println("Libro nr: "+(i+1));
				System.out.print("Inserisci il titolo: ");
				String titolo=s.nextLine();
				System.out.print("Inserisci l'autore: ");
				String autore=s.nextLine();
				System.out.print("Inserisci l'editore: ");
				String editore=s.nextLine();
				System.out.print("Inserisci il numero di pagine: ");
				int numPagine;
				try {
					numPagine=Integer.parseInt(s.nextLine());										
				}
				catch(NumberFormatException e) {
					System.out.println("Numero di pagine non valido!");
					numPagine=0;
				}
				Book b=new Book(titolo, numPagine,autore,editore);
				if (b.getErrori().size()>0) {
					System.out.println("Si sono verificati degli errori:");
					for(int j=0;j<b.getErrori().size();j++)
						System.out.println(b.getErrori().get(j).getMessage());
					i--;
				}
				else	{
					elencoLibri[i]=b;
					
				}
						
				
				
			}
			System.out.println("Scrittura del file...");
			try {
				fw=new FileWriter("libri.txt");  //se il file esiste, lo sovrascrive
				for (int i=0;i<elencoLibri.length;i++)
					fw.write(elencoLibri[i].toString()+"\n");	//accodo una stringa al file
				fw.close();
			} catch (IOException e) {
				System.out.println("Errore nella scrittura del file");
			}
			
			System.out.println("Lettura del file...");
			File f=new File("libri.txt");
			Scanner sf=null;
			try {
				sf=new Scanner(f);
				while(sf.hasNextLine()) {
					String linea=sf.nextLine();
					System.out.println(linea);
				}
			} catch (FileNotFoundException e) {				
				e.printStackTrace();
			}
			finally {
				if (sf!=null)
					sf.close();
			}
		}
		
		s.close();

	}

}
