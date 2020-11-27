package management;

public class TeaListDTO {

	private int tMenuNum;
	private String teaMenu;
	private int teaStock;
	private int teaPrice;
	private int teaHits;
	
	public TeaListDTO(int tMenuNum, String teaMenu, int teaStock, int teaPrice, int teaHits) {
		super();
		this.tMenuNum = tMenuNum;
		this.teaMenu = teaMenu;
		this.teaStock = teaStock;
		this.teaPrice = teaPrice;
		this.teaHits = teaHits;
	}

	public TeaListDTO() {
		super();
	}

	public int gettMenuNum() {
		return tMenuNum;
	}

	public String getTeaMenu() {
		return teaMenu;
	}

	public int getTeaStock() {
		return teaStock;
	}

	public int getTeaPrice() {
		return teaPrice;
	}

	public int getTeaHits() {
		return teaHits;
	}

	public void settMenuNum(int tMenuNum) {
		this.tMenuNum = tMenuNum;
	}

	public void setTeaMenu(String teaMenu) {
		this.teaMenu = teaMenu;
	}

	public void setTeaStock(int teaStock) {
		this.teaStock = teaStock;
	}

	public void setTeaPrice(int teaPrice) {
		this.teaPrice = teaPrice;
	}

	public void setTeaHits(int teaHits) {
		this.teaHits = teaHits;
	}

	@Override
	public String toString() {
		return "TeaListDTO [tMenuNum=" + tMenuNum + ", teaMenu=" + teaMenu + ", teaStock=" + teaStock + ", teaPrice="
				+ teaPrice + ", teaHits=" + teaHits + "]";
	}
	
}
