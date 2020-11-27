package management;

public class DessertListDTO {

	private int dMenuNum;
	private String dessertMenu;
	private int dessertStock;
	private int dessertPrice;
	private int dessertHits;
	
	public DessertListDTO(int dMenuNum, String dessertMenu, int dessertStock, int dessertPrice, int dessertHits) {
		super();
		this.dMenuNum = dMenuNum;
		this.dessertMenu = dessertMenu;
		this.dessertStock = dessertStock;
		this.dessertPrice = dessertPrice;
		this.dessertHits = dessertHits;
	}

	public DessertListDTO() {
		super();
	}

	public int getdMenuNum() {
		return dMenuNum;
	}

	public String getDessertMenu() {
		return dessertMenu;
	}

	public int getDessertStock() {
		return dessertStock;
	}

	public int getDessertPrice() {
		return dessertPrice;
	}

	public int getDessertHits() {
		return dessertHits;
	}

	public void setdMenuNum(int dMenuNum) {
		this.dMenuNum = dMenuNum;
	}

	public void setDessertMenu(String dessertMenu) {
		this.dessertMenu = dessertMenu;
	}

	public void setDessertStock(int dessertStock) {
		this.dessertStock = dessertStock;
	}

	public void setDessertPrice(int dessertPrice) {
		this.dessertPrice = dessertPrice;
	}

	public void setDessertHits(int dessertHits) {
		this.dessertHits = dessertHits;
	}

	@Override
	public String toString() {
		return "DessertListDTO [dMenuNum=" + dMenuNum + ", dessertMenu=" + dessertMenu + ", dessertStock="
				+ dessertStock + ", dessertPrice=" + dessertPrice + ", dessertHits=" + dessertHits + "]";
	}
	

}
