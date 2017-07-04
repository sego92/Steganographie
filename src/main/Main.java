package main;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import fileBMP.FileBMP;
import hiddenFile.FileToHide;

public class Main {

	public static void main(String[] args) throws Exception{
		File file = new File ("D:\\AgilityFactory\\imageBMP.bmp");
		FileBMP fileBMP = new FileBMP();
		fileBMP.readFileBMP(file);		
		
//		TODO verifier que fileBNP ok (fichier = fichierBMP et fichier en couleur reelle
		
//		File file2 = new File ("D:\\AgilityFactory\\imageCache.png");
		File file2 = new File ("D:\\AgilityFactory\\imageCache.png");
		FileToHide fileToHide = new FileToHide(file2);
		
		
		
//		TODO verifier que taille fichier ok	< oxFFFF
		byte bitsToHide;
		
//		on cache la longueur du fichier a cacher dans 10 premiers octets du corps du fichierBMP
		do {
			bitsToHide = fileToHide.long2Bits();
			
			if (bitsToHide != -1)
				fileBMP.hidBits(bitsToHide);
			
		} while (bitsToHide != -1);
			
		
//		on cache les données du fichier dans fichierBMP
		while ((bitsToHide=fileToHide.read2Bits()) != -1){
			fileBMP.hidBits(bitsToHide);
		}
	
//		TODO on sauvegarde le new fichier créer
		File file3 = new File ("D:\\AgilityFactory\\newImageBMP.bmp");
		fileBMP.saveNewBMPFile(file3);
		
		
//		on recupere le fichier cache
		byte[] data = fileBMP.readNewFileBMP(file3);
		if (data !=null){
			File file4 = new File ("D:\\AgilityFactory\\newImageCache.png");
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(file4);
				BufferedOutputStream bos = new BufferedOutputStream (fos);
				bos.write(data);
				bos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	}

}
