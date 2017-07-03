package fileBMP;

public class EnteteBMP {
	
	private byte[] enteteBNPSize = new byte [4];
	private int width;
	private int height;
	private int numberColorPlane;
	private int numberBitsByPixel;
	private int compressionMethod;
	private byte[] imageSize = new byte[4];
	private int horyzontalResolution;
	private int verticalResolution;
	private int numberColorPalette;
	private int numberImportantColor;

	
	public EnteteBMP() {
		// TODO Auto-generated constructor stub
	}


	public byte[] getEnteteBNPSize() {
		return enteteBNPSize;
	}


	public void setEnteteBNPSize(byte[] enteteBNPSize) {
		this.enteteBNPSize = enteteBNPSize;
	}

	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getNumberColorPlane() {
		return numberColorPlane;
	}


	public void setNumberColorPlane(int numberColorPlane) {
		this.numberColorPlane = numberColorPlane;
	}



	public int getCompressionMethod() {
		return compressionMethod;
	}


	public void setCompressionMethod(int compressionMethod) {
		this.compressionMethod = compressionMethod;
	}


	public byte[] getImageSize() {
		return imageSize;
	}


	public void setImageSize(byte[] imageSize) {
		this.imageSize [0] = imageSize[0];
		this.imageSize [1] = imageSize[1];
		this.imageSize [2] = imageSize[2];
		this.imageSize [3] = imageSize[3];
	}


	public int getHoryzontalResolution() {
		return horyzontalResolution;
	}


	public void setHoryzontalResolution(int horyzontalResolution) {
		this.horyzontalResolution = horyzontalResolution;
	}


	public int getVerticalResolution() {
		return verticalResolution;
	}


	public void setVerticalResolution(int verticalResolution) {
		this.verticalResolution = verticalResolution;
	}


	public int getNumberColorPalette() {
		return numberColorPalette;
	}


	public void setNumberColorPalette(int numberColorPalette) {
		this.numberColorPalette = numberColorPalette;
	}


	public int getNumberImportantColor() {
		return numberImportantColor;
	}


	public void setNumberImportantColor(int numberImportantColor) {
		this.numberImportantColor = numberImportantColor;
	}


	public int getNumberBitsByPixel() {
		return numberBitsByPixel;
	}


	public void setNumberBitsByPixel(int numberBitsByPixel) {
		this.numberBitsByPixel = numberBitsByPixel;
	}
	
	
	

}