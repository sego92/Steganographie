package fileBMP;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileBMP {
	private EnteteFichier enteteFichierBMP;
	private EnteteImage EnteteImageBMP;
	private Corps corpsBMP;

	public FileBMP() {
		// TODO Auto-generated constructor stub
	}
	
	private void readFile(File file) {
		FileInputStream fis;
		byte[] tabEnteteFichier;
		byte[] tabEnteteImage;
		byte[] tabCorps;
		try {
			fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			tabEnteteFichier = new byte[14];
			bis.read(tabEnteteFichier);
			tabEnteteImage = new byte [40];
			bis.read(tabEnteteImage);
			tabCorps = new byte [(int) (file.length()-54)];
			bis.read(tabCorps);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}	