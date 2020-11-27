package management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import order.DBConnection;

public class CafeDAO {

	Scanner scan = new Scanner(System.in);
	
	CoffeListDTO coffeList = null;
	TeaListDTO teaList = null;
	SmoothieListDTO smoothieList = null;
	DessertListDTO dessertList = null;
	SalesDTO sales = new SalesDTO();
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void dbconnection() {
		con = DBConnection.makeConnection();
		System.out.println(" javaCafe에 출근하였습니다:P");
	}

	public void coffeAdd() {
		System.out.print("> 메뉴 이름을 입력하세요 : ");
		String coffeMenu = scan.next();
		System.out.print("> 메뉴 재고를 입력하세요 : ");
		int coffeStock = scan.nextInt();
		System.out.print("> 메뉴 가격을 입력하세요 : ");
		int coffePrice = scan.nextInt();
		
		coffeList = new CoffeListDTO();
		coffeList.setCoffeMenu(coffeMenu);
		coffeList.setCoffeStock(coffeStock);
		coffeList.setCoffePrice(coffePrice);
		
		String sql = "INSERT INTO COFFELIST (COFFEMENU, CMENUNUM, COFFESTOCK, COFFEPRICE, COFFEHITS) "+
		             "VALUES (?,SEQ_COFFE.NEXTVAL,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, coffeList.getCoffeMenu());
			pstmt.setInt(2, coffeList.getCoffeStock());
			pstmt.setInt(3, coffeList.getCoffePrice());
			pstmt.setInt(4, coffeList.getCoffeHits());
			pstmt.executeUpdate();
			System.out.println("☆등록 완료☆");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void teaAdd() {
		System.out.print("> 메뉴 이름을 입력하세요 : ");
		String teaMenu = scan.next();
		System.out.print("> 메뉴 재고를 입력하세요 : ");
		int teaStock = scan.nextInt();
		System.out.print("> 메뉴 가격을 입력하세요 : ");
		int teaPrice = scan.nextInt();
		
		teaList = new TeaListDTO();
		teaList.setTeaMenu(teaMenu);
		teaList.setTeaStock(teaStock);
		teaList.setTeaPrice(teaPrice);
		                                          
		String sql = "INSERT INTO TEALIST (TEAMENU,TMENUNUM,TEASTOCK,TEAPRICE,TEAHITS) "+
		             "VALUES (?,SEQ_TEA.NEXTVAL,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, teaList.getTeaMenu());
			pstmt.setInt(2, teaList.getTeaStock());
			pstmt.setInt(3, teaList.getTeaPrice());
			pstmt.setInt(4, teaList.getTeaHits());
			pstmt.executeUpdate();
			System.out.println("☆등록 완료☆");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void smoothieAdd() {
		System.out.print("> 메뉴 이름을 입력하세요 : ");
		String smoothieMenu = scan.next();
		System.out.print("> 메뉴 재고를 입력하세요 : ");
		int smoothieStock = scan.nextInt();
		System.out.print("> 메뉴 가격을 입력하세요 : ");
		int smoothiePrice = scan.nextInt();
		
		smoothieList = new SmoothieListDTO();
		smoothieList.setSmoothieMenu(smoothieMenu);
		smoothieList.setSmoothieStock(smoothieStock);
		smoothieList.setSmoothiePrice(smoothiePrice);
		
		String sql = "INSERT INTO SMOOTHIELIST (SMOOTHIEMENU, SMENUNUM, SMOOTHIESTOCK, SMOOTHIEPRICE, SMOOTHIEHITS) "+
		             "VALUES (?,SEQ_SMOOTHIE.NEXTVAL,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, smoothieList.getSmoothieMenu());
			pstmt.setInt(2, smoothieList.getSmoothieStock());
			pstmt.setInt(3, smoothieList.getSmoothiePrice());
			pstmt.setInt(4, smoothieList.getSmoothieHits());
			pstmt.executeUpdate();
			System.out.println("☆등록 완료☆");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void dessertAdd() {
		System.out.print("> 메뉴 이름을 입력하세요 : ");
		String dessertMenu = scan.next();
		System.out.print("> 메뉴 재고를 입력하세요 : ");
		int dessertStock = scan.nextInt();
		System.out.print("> 메뉴 가격을 입력하세요 : ");
		int dessertPrice = scan.nextInt();
		
		dessertList = new DessertListDTO();
		dessertList.setDessertMenu(dessertMenu);
		dessertList.setDessertStock(dessertStock);
		dessertList.setDessertPrice(dessertPrice);
		
		String sql = "INSERT INTO DESSERTLIST (DESSERTMENU, DMENUNUM, DESSERTSTOCK, DESSERTPRICE, DESSERTHITS) "+
		             "VALUES (?,SEQ_DESSERT.NEXTVAL,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dessertList.getDessertMenu());
			pstmt.setInt(2, dessertList.getDessertStock());
			pstmt.setInt(3, dessertList.getDessertPrice());
			pstmt.setInt(4, dessertList.getDessertHits());
			pstmt.executeUpdate();
			System.out.println("☆등록 완료☆");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	String coffeMenu="";
	public void coffeUpdate() {
		System.out.print("> 수정 할 메뉴의 이름을 입력하세요 : ");
		coffeMenu = scan.next();
		int updateStock = cStock();
		System.out.print("> 메뉴의 추가 재고를 입력하세요 : ");
		int coffeStock = scan.nextInt();
		System.out.print("> 메뉴의 수정 가격을 입력하세요 : ");
		int coffePrice = scan.nextInt();
		
		coffeList = new CoffeListDTO();
		updateStock = updateStock + coffeStock;
		coffeList.setCoffeStock(updateStock);
		coffeList.setCoffePrice(coffePrice);
		
		String sql = "UPDATE COFFELIST SET COFFESTOCK = ? , COFFEPRICE = ? WHERE COFFEMENU =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, coffeList.getCoffeStock());
			pstmt.setInt(2, coffeList.getCoffePrice());
			pstmt.setString(3, coffeMenu);
			pstmt.executeUpdate();
			System.out.println("☆수정 완료☆");
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	String teaMenu = "";	
	public void teaUpdate() {
		System.out.print("> 수정 할 메뉴의 이름을 입력하세요 : ");
		teaMenu = scan.next();
		int updateStock = tStock();
		System.out.print("> 메뉴의 추가 재고를 입력하세요 : ");
		int teaStock = scan.nextInt();
		System.out.print("> 메뉴의 수정 가격을 입력하세요 : ");
		int teaPrice = scan.nextInt();
			
		teaList = new TeaListDTO();
		updateStock = updateStock + teaStock;
		teaList.setTeaStock(updateStock);
		teaList.setTeaPrice(teaPrice);
			
		String sql = "UPDATE TEALIST SET TEASTOCK = ? , TEAPRICE = ? WHERE TEAMENU =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, teaList.getTeaStock());
			pstmt.setInt(2, teaList.getTeaPrice());
			pstmt.setString(3, teaMenu);
			pstmt.executeUpdate();
			System.out.println("☆수정 완료☆");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	String smoothieMenu ="";
	public void smoothieUpdate() {
		System.out.print("> 수정 할 메뉴의 이름을 입력하세요 : ");
		smoothieMenu = scan.next();
		int updateStock = sStock();
		System.out.print("> 메뉴의 추가 재고를 입력하세요 : ");
		int smoothieStock = scan.nextInt();
		System.out.print("> 메뉴의 수정 가격을 입력하세요 : ");
		int smoothiePrice = scan.nextInt();
			
		smoothieList = new SmoothieListDTO();
		updateStock = updateStock + smoothieStock;
		smoothieList.setSmoothieStock(updateStock);
		smoothieList.setSmoothiePrice(smoothiePrice);
			
		String sql = "UPDATE SMOOTHIELIST SET SMOOTHIESTOCK = ? , SMOOTHIEPRICE = ? WHERE SMOOTHIEMENU =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, smoothieList.getSmoothieStock());
			pstmt.setInt(2, smoothieList.getSmoothiePrice());
			pstmt.setString(3, smoothieMenu);
			pstmt.executeUpdate();
			System.out.println("☆수정 완료☆");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	String dessertMenu = "";
	public void dessertUpdate() {
		System.out.print("> 수정 할 메뉴의 이름을 입력하세요 : ");
		dessertMenu = scan.next();
		int updateStock = dStock();
		System.out.print("> 메뉴의 추가 재고를 입력하세요 : ");
		int dessertStock = scan.nextInt();
		System.out.print("> 메뉴의 수정 가격을 입력하세요 : ");
		int dessertPrice = scan.nextInt();
			
		dessertList = new DessertListDTO();
		updateStock = updateStock + dessertStock;
		dessertList.setDessertStock(updateStock);
		dessertList.setDessertPrice(dessertPrice);
			
		String sql = "UPDATE DESSERTLIST SET DESSERTSTOCK = ? , DESSERTPRICE = ? WHERE DESSERTMENU =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dessertList.getDessertStock());
			pstmt.setInt(2, dessertList.getDessertPrice());
			pstmt.setString(3, dessertMenu);
			pstmt.executeUpdate();
			System.out.println("☆수정 완료☆");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void coffeDelete() {
		System.out.print("> 어떤 메뉴를 삭제하시겠습니까? ");
		String coffeMenu = scan.next();
			
		String sql = "DELETE FROM COFFELIST WHERE COFFEMENU = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, coffeMenu);
			pstmt.executeUpdate();
			System.out.println("☆삭제 완료☆");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public void teaDelete() {
		System.out.print("> 어떤 메뉴를 삭제하시겠습니까? ");
		String teaMenu = scan.next();
			
		String sql = "DELETE FROM TEALIST WHERE TEAMENU = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, teaMenu);
			pstmt.executeUpdate();
			System.out.println("☆삭제 완료☆");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public void smoothieDelete() {
		System.out.print("> 어떤 메뉴를 삭제하시겠습니까? ");
		String smoothieMenu = scan.next();
			
		String sql = "DELETE FROM SMOOTHIELIST WHERE SMOOTHIEMENU = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, smoothieMenu);
			pstmt.executeUpdate();
			System.out.println("☆삭제 완료☆");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public void dessertDelete() {
		System.out.print("> 어떤 메뉴를 삭제하시겠습니까? ");
		String dessertMenu = scan.next();
			
		String sql = "DELETE FROM DESSERTLIST WHERE DESSERTMENU = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dessertMenu);
			pstmt.executeUpdate();
			System.out.println("☆삭제 완료☆");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public void cStockView() {
		String sql = "SELECT COFFEMENU, COFFESTOCK FROM COFFELIST";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("COFFEMENU")+"\t");
				System.out.println(rs.getInt("COFFESTOCK")+"개");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void tStockView() {
		String sql = "SELECT TEAMENU, TEASTOCK FROM TEALIST";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("TEAMENU")+"\t");
				System.out.println(rs.getInt("TEASTOCK")+"개");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void sStockView() {
		String sql = "SELECT SMOOTHIEMENU, SMOOTHIESTOCK FROM SMOOTHIELIST";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("SMOOTHIEMENU")+"\t");
				System.out.println(rs.getInt("SMOOTHIESTOCK")+"개");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void dStockView() {
		String sql = "SELECT DESSERTMENU, DESSERTSTOCK FROM DESSERTLIST";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("DESSERTMENU")+"\t");
				System.out.println(rs.getInt("DESSERTSTOCK")+"개");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int cStock() {
		String sql = "SELECT COFFESTOCK FROM COFFELIST WHERE COFFEMENU = ?";
		int cStock = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, coffeMenu);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cStock = rs.getInt("COFFESTOCK");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cStock;
	}
	public int tStock() {
		String sql = "SELECT TEASTOCK FROM TEALIST WHERE TEAMENU = ?";
		int tStock = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, teaMenu);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tStock = rs.getInt("TEASTOCK");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tStock;
	}
	public int sStock() {
		String sql = "SELECT SMOOTHIESTOCK FROM SMOOTHIELIST WHERE SMOOTHIEMENU = ?";
		int sStock = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, smoothieMenu);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sStock = rs.getInt("SMOOTHIESTOCK");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sStock;
	}
	public int dStock() {
		String sql = "SELECT DESSERTSTOCK FROM DESSERTLIST WHERE DESSERTMENU = ?";
		int dStock = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dessertMenu);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dStock = rs.getInt("DESSERTSTOCK");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dStock;
	}
	
	
	public void allSales() {
		String sql = "SELECT SUM(PRICE) FROM CAFEDATE";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("-총 매출액 ▼");
				System.out.println(rs.getInt("SUM(PRICE)")+"원");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void daySales() {
		String sql = "SELECT TO_CHAR(SELECTDATE,'DD') ,SUM(PRICE) FROM CAFEDATE GROUP BY TO_CHAR(SELECTDATE,'DD')";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("-일 매출액 ▼");
				System.out.print(rs.getString("TO_CHAR(SELECTDATE,'DD')")+"일\t");
				System.out.println(rs.getInt("SUM(PRICE)")+"원");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void monthSales() {
		String sql = "SELECT TO_CHAR(SELECTDATE,'MM') ,SUM(PRICE) FROM CAFEDATE GROUP BY TO_CHAR(SELECTDATE,'MM')";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("-월 매출액 ▼");
				System.out.print(rs.getString("TO_CHAR(SELECTDATE,'MM')")+"월\t");
				System.out.println(rs.getInt("SUM(PRICE)")+"원");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void yearSales() {
		String sql = "SELECT TO_CHAR(SELECTDATE,'YYYY') ,SUM(PRICE) FROM CAFEDATE GROUP BY TO_CHAR(SELECTDATE,'YYYY')";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("-연 매출액 ▼");
				System.out.print(rs.getString("TO_CHAR(SELECTDATE,'YYYY')")+"년\t");
				System.out.println(rs.getInt("SUM(PRICE)")+"원");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


















































}
