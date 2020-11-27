package management;

public class CoffeListDTO {
	
	private int cMenuNum;
	private String coffeMenu;
	private int coffeStock;
	private int coffePrice;
	private int coffeHits;
	
	public CoffeListDTO(int cMenuNum, String coffeMenu, int coffeStock, int coffePrice, int coffeHits) {
		super();
		this.cMenuNum = cMenuNum;
		this.coffeMenu = coffeMenu;
		this.coffeStock = coffeStock;
		this.coffePrice = coffePrice;
		this.coffeHits = coffeHits;
	}
	public CoffeListDTO() {
		super();
	}
	public int getcMenuNum() {
		return cMenuNum;
	}
	public String getCoffeMenu() {
		return coffeMenu;
	}
	public int getCoffeStock() {
		return coffeStock;
	}
	public int getCoffePrice() {
		return coffePrice;
	}
	public int getCoffeHits() {
		return coffeHits;
	}
	public void setcMenuNum(int cMenuNum) {
		this.cMenuNum = cMenuNum;
	}
	public void setCoffeMenu(String coffeMenu) {
		this.coffeMenu = coffeMenu;
	}
	public int setCoffeStock(int coffeStock) {
		return this.coffeStock = coffeStock;
	}
	public void setCoffePrice(int coffePrice) {
		this.coffePrice = coffePrice;
	}
	public void setCoffeHits(int coffeHits) {
		this.coffeHits = coffeHits;
	}
	@Override
	public String toString() {
		return "CoffeListDTO [cMenuNum=" + cMenuNum + ", coffeMenu=" + coffeMenu + ", coffeStock=" + coffeStock
				+ ", coffePrice=" + coffePrice + ", coffeHits=" + coffeHits + "]";
	}
	
}
