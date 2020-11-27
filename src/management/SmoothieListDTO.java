package management;

public class SmoothieListDTO {

	private int sMenuNum;
	private String smoothieMenu;
	private int smoothieStock;
	private int smoothiePrice;
	private int smoothieHits;
	
	public SmoothieListDTO(int sMenuNum, String smoothieMenu, int smoothieStock, int smoothiePrice, int smoothieHits) {
		super();
		this.sMenuNum = sMenuNum;
		this.smoothieMenu = smoothieMenu;
		this.smoothieStock = smoothieStock;
		this.smoothiePrice = smoothiePrice;
		this.smoothieHits = smoothieHits;
	}
	public SmoothieListDTO() {
		super();
	}
	public int getsMenuNum() {
		return sMenuNum;
	}
	public String getSmoothieMenu() {
		return smoothieMenu;
	}
	public int getSmoothieStock() {
		return smoothieStock;
	}
	public int getSmoothiePrice() {
		return smoothiePrice;
	}
	public int getSmoothieHits() {
		return smoothieHits;
	}
	public void setsMenuNum(int sMenuNum) {
		this.sMenuNum = sMenuNum;
	}
	public void setSmoothieMenu(String smoothieMenu) {
		this.smoothieMenu = smoothieMenu;
	}
	public void setSmoothieStock(int smoothieStock) {
		this.smoothieStock = smoothieStock;
	}
	public void setSmoothiePrice(int smoothiePrice) {
		this.smoothiePrice = smoothiePrice;
	}
	public void setSmoothieHits(int smoothieHits) {
		this.smoothieHits = smoothieHits;
	}
	@Override
	public String toString() {
		return "SmoothieListDTO [sMenuNum=" + sMenuNum + ", smoothieMenu=" + smoothieMenu + ", smoothieStock="
				+ smoothieStock + ", smoothiePrice=" + smoothiePrice + ", smoothieHits=" + smoothieHits + "]";
	}
	
}
