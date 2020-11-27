package order;

public class StampDTO {
	
	private String cName;
	private String cPhone;
	private String cStamp;
	public StampDTO(String cName, String cPhone, String cStamp) {
		super();
		this.cName = cName;
		this.cPhone = cPhone;
		this.cStamp = cStamp;
	}
	public StampDTO() {
		super();
	}
	public String getcName() {
		return cName;
	}
	public String getcPhone() {
		return cPhone;
	}
	public String getcStamp() {
		return cStamp;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}
	public void setcStamp(String cStamp) {
		this.cStamp = cStamp;
	}
	@Override
	public String toString() {
		return "StampDTO [cName=" + cName + ", cPhone=" + cPhone + ", cStamp=" + cStamp + "]";
	}
	
	


}
