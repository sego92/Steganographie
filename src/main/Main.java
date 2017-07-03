package main;

import java.io.File;

import fileBMP.FileBMP;
import hiddenFile.FileToHide;

public class Main {

	public static void main(String[] args){
		File file = new File ("D:\\AgilityFactory\\imageBMP.bmp");
		FileBMP fileBMP = new FileBMP();
		fileBMP.readFile(file);		
		
//		TODO verifier que fileBNP ok (fichier = fichierBMP et fichier en couleur reelle
		
		File file2 = new File ("D:\\AgilityFactory\\imageCache.png");
		FileToHide fileToHide = new FileToHide(file2);
		
		
		
//		TODO verifier que taille fichier ok	
		Byte bitsToHide;
		while ((bitsToHide=fileToHide.read2Bits()) != 0xff){
			fileBMP.hidBits(bitsToHide);
		}
	
//		TODO save le new fichier créer
	}

}
