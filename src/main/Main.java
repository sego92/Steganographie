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
		
		
		
//		TODO verifier que taille fichier ok	< oxFFFF
		byte bitsToHide;
		
//		on cache la longueur du fichier a cacher dans 10 premiers octets du corps du fichierBMP
		while ((bitsToHide=fileToHide.long2Bits()) != 0xff){
			fileBMP.hidBits(bitsToHide);
		}		
		
//		on cache les données du fichier dans fichierBMP
		while ((bitsToHide=fileToHide.read2Bits()) != 0xff){
			fileBMP.hidBits(bitsToHide);
		}
	
//		TODO save le new fichier créer
		File file3 = new File ("D:\\AgilityFactory\\newImageBMP.bmp");
		fileBMP.saveNewBMPFile(file3);
	}

}
