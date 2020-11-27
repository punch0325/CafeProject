package management;

public class SalesDTO {

	private int price;
	private String selectDate;
	public SalesDTO(int price, String selectDate) {
		super();
		this.price = price;
		this.selectDate = selectDate;
	}
	public SalesDTO() {
		super();
	}
	public int getPrice() {
		return price;
	}
	public String getSelectDate() {
		return selectDate;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setSelectDate(String selectDate) {
		this.selectDate = selectDate;
	}
	@Override
	public String toString() {
		return "SalesDTO [price=" + price + ", selectDate=" + selectDate + "]";
	}
	
}
