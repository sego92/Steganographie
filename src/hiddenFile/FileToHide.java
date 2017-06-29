package hiddenFile;

import java.io.File;

public class FileToHide extends File {
	
	public FileToHide(String pathname) {
		super(pathname);
		// TODO Auto-generated constructor stub
	}

	private int fileSize;

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	


}
