package fileBMP;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.Arrays;

public class FileBMP {
	private EnteteFichier enteteFichier;
	private EnteteBMP EnteteBMP;
	private Corps corpsBMP;
	
	

	public FileBMP() {
		// TODO Auto-generated constructor stub
	}
	
	public void readFile(File file) {
		FileInputStream fis;
		byte[] tabEnteteFichier;
		byte[] tabEnteteBMP;
		byte[] tabCorps;
		
		try {
			fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			tabEnteteFichier = new byte[14];
			bis.read(tabEnteteFichier);
			EnteteFichier enteteFichier = new EnteteFichier();
			enteteFichier.setSignature(tabEnteteFichier);
			int j= (tabEnteteFichier[5]<<24)&0xff000000|
				   (tabEnteteFichier[4]<<16)&0x00ff0000|
				   (tabEnteteFichier[3]<< 8)&0x0000ff00|
				   (tabEnteteFichier[2]<< 0)&0x000000ff;
			enteteFichier.setFileSize(j);
			
			j= (tabEnteteFichier[13]<<24)&0xff000000|
				(tabEnteteFichier[12]<<16)&0x00ff0000|
				(tabEnteteFichier[11]<< 8)&0x0000ff00|
				(tabEnteteFichier[10]<< 0)&0x000000ff;
			enteteFichier.setOffset(j);
			
			tabEnteteBMP = new byte [40];
			byte[] tabEnteteBNP2 = Arrays.copyOfRange(tabEnteteBMP, 20, tabEnteteBMP.length);
			bis.read(tabEnteteBMP);
			EnteteBMP enteteBNP = new EnteteBMP();
			enteteBNP.setImageSize(tabEnteteBNP2);
			
//			int h = (tabEnteteBMP[35]<<24)&0xff000000|
//					(tabEnteteBMP[34]<<16)&0x00ff0000|
//					(tabEnteteBMP[33]<< 8)&0x0000ff00|
//					(tabEnteteBMP[32]<< 0)&0x000000ff;
//			enteteBNP.setNumberColorPalette(h);
			
			int h = (tabEnteteBMP[15]<< 8)&0x0000ff00|
				(tabEnteteBMP[14]<< 0)&0x000000ff;
			enteteBNP.setNumberBitsByPixel(h);
			
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

	public void hidBits(Byte bitsToHide) {
		// TODO Auto-generated method stub
		
	}

}	