package fileBMP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.Arrays;

import hiddenFile.FileToHide;

public class FileBMP {
	private EnteteFichier enteteFichier;
	private EnteteBMP EnteteBMP;
	private Corps corpsBMP;
	byte[] tabCorps;
	private int indexTabCorps;
	byte[] tabEnteteFichier;
	byte[] tabEnteteBMP;


	public FileBMP() {
		// TODO Auto-generated constructor stub
	}
	
	public void readFileBMP(File file) throws Exception {
		FileInputStream fis;
		indexTabCorps = 0;
		
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

	public void hidBits(byte bitsToHide) {
		byte octetBMP;
		octetBMP= tabCorps[indexTabCorps];
		octetBMP = (byte) (octetBMP & 0xFC);
		octetBMP = (byte) (octetBMP | bitsToHide);
		tabCorps[indexTabCorps] = octetBMP;
		indexTabCorps++;
	}
	
	public void saveNewBMPFile (File file){
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream (fos);
			bos.write(tabEnteteFichier);
			bos.write(tabEnteteBMP);
			bos.write(tabCorps);
			bos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public byte[] readNewFileBMP (File file){
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			byte[] tabVide = new byte[54];
			bis.read(tabVide);
			
			byte[] tabLonguerHiddenFile = new byte [8];
			bis.read(tabLonguerHiddenFile);
			long nbOctet = FileToHide.sizeNewFile(tabLonguerHiddenFile);
			System.out.println(nbOctet);
			
			byte[] tabData = new byte [(int) (nbOctet*4)];
			bis.read(tabData);
			byte[] data = FileToHide.dataNewFile(tabData);
//			System.out.println(Arrays.toString(data));
			return data;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}	