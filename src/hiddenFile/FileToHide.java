package hiddenFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileToHide {
	private long sizeFile;
	private File file;
	private byte octet;
	private int nbBitsRestant;
	private FileInputStream fis;
	private long sizeFileToSend;
	private int nbBitsRestantSize;
	
	public FileToHide (File file) {
		this.file = file;
		sizeFile = file.length();
		nbBitsRestant = 0;
		sizeFileToSend = sizeFile;
		nbBitsRestantSize = 16;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public FileToHide (String pathFile) {
		file = new File(pathFile);
		sizeFile = file.length();
		nbBitsRestant = 0;
		sizeFileToSend = sizeFile;
		nbBitsRestantSize = 16;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public byte long2Bits(){
		if (nbBitsRestantSize == 0){
			return (byte) 0xFF;
		}
		byte ret = (byte) (sizeFileToSend & 0x03);
		sizeFileToSend = (byte) (sizeFileToSend >>>2);
		nbBitsRestantSize -=2;
		return ret;
	}
	
	public byte read2Bits (){
		if (nbBitsRestant == 0){
			byte[] tabByte = new byte[1];
			int ret = 0;
			try {
				ret = fis.read(tabByte);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ret == -1){
				return (byte) 0xFF;
			}
			octet = tabByte[0];
			nbBitsRestant = 8;
		}
		byte ret2 = (byte) (octet & 0x03);
		octet = (byte) (octet >>>2);
		nbBitsRestant -=2;
		
		return ret2;
		
	}

	public long getSizeFile() {
		return sizeFile;
	}

	
}