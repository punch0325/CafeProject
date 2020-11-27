package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


import management.CoffeListDTO;
import management.DessertListDTO;
import management.SalesDTO;
import management.SmoothieListDTO;
import management.TeaListDTO;

public class OrderDAO {

	Scanner scan = new Scanner(System.in);
	CoffeListDTO coffeList = null;
	TeaListDTO teaList = null;
	SmoothieListDTO smoothieList = null;
	DessertListDTO dessertList = null;
	SalesDTO sales = null;
	
	StampDTO stamp = null;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void dbconnection() {
		con = DBConnection.makeConnection();
		System.out.println("javaCafe에 입장하였습니다:)");
	}

	public void allView() {
		String sql = "SELECT * FROM COFFELIST";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("COFFEMENU"));
				System.out.print(rs.getInt("COFFEPRICE")+"원   ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void allView_1() {
		String sql = "SELECT * FROM COFFELIST ORDER BY COFFEHITS DESC";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("COFFEMENU"));
				System.out.print(rs.getInt("COFFEPRICE")+"원   ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public void allView1() {
		String sql = "SELECT * FROM TEALIST";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("TEAMENU"));
				System.out.print(rs.getInt("TEAPRICE")+"원   ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void allView1_1() {
		String sql = "SELECT * FROM TEALIST ORDER BY TEAHITS DESC";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("TEAMENU"));
				System.out.print(rs.getInt("TEAPRICE")+"원   ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void allView2() {
		String sql = "SELECT * FROM SMOOTHIELIST";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("SMOOTHIEMENU"));
				System.out.print(rs.getInt("SMOOTHIEPRICE")+"원   ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	public void allView2_1() {
		String sql = "SELECT * FROM SMOOTHIELIST ORDER BY SMOOTHIEHITS DESC";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("SMOOTHIEMENU"));
				System.out.print(rs.getInt("SMOOTHIEPRICE")+"원   ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void allView3() {
		String sql = "SELECT * FROM DESSERTLIST";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("DESSERTMENU"));
				System.out.print(rs.getInt("DESSERTPRICE")+"원   ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	public void allView3_1() {
		String sql = "SELECT * FROM DESSERTLIST ORDER BY DESSERTHITS DESC";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("DESSERTMENU"));
				System.out.print(rs.getInt("DESSERTPRICE")+"원   ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void typeView() {
		boolean stop = true;
		System.out.println("①coffe ②tea ③smoothie ④dessert");
		while (stop) {
			System.out.print("▶▷ 어떤 종류의 메뉴를 보시겠습니까? ");
			int num = scan.nextInt();
			if(num == 1) {
				allView();
				System.out.println();
			}else if(num == 2) {
				allView1();
				System.out.println();
			}else if(num == 3) {
				allView2();
				System.out.println();
			}else if (num == 4) {
				allView3();
				System.out.println();
			}else {
				stop = false;
				System.out.println("※다른 번호를 선택하시거나 뷰어를 종료해주세요");
			}
		}
	}

	public void hotView() {
		boolean stop = true;
		System.out.println("①coffe ②tea ③smoothie ④dessert");
		while (stop) {
			System.out.print("▶ 어떤 종류의 인기순위를 보시겠습니까? ");
			int num = scan.nextInt();
			if(num == 1) {
				allView_1();
				System.out.println();
			}else if(num == 2) {
				allView1_1();
				System.out.println();
			}else if(num == 3) {
				allView2_1();
				System.out.println();
			}else if (num == 4) {
				allView3_1();
				System.out.println();
			}else {
				stop = false;
				System.out.println("※다른 번호를 선택하시거나 뷰어를 종료해주세요");
			}
		}
		
	}

	
	String coffeMenu = "";
	public void coffeSelect() {
		System.out.print("> 주문할 메뉴 이름을 입력해주세요 : ");
		coffeMenu = scan.next();
		coffeList = new CoffeListDTO();
		coffeList.setCoffeMenu(coffeMenu);
		
		int stock = 0;
		String sql = "SELECT COFFESTOCK FROM COFFELIST WHERE COFFEMENU = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, coffeMenu);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stock = rs.getInt("COFFESTOCK");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (stock > 0) {
			System.out.println(coffeMenu+"주문 받았습니다~ 잠시만 기다려 주세요(^ㅂ^)!");
			System.out.println(coffeMenu+"완성 되었습니다! 맛있게 드세요(^O^)!");
			coffeHits();
			coffeStcok();
			coffeSales();
			salesInsert();
		}else {
			System.out.println("현재 "+coffeMenu+"은/는 품절입니다 (ㅠㅅㅠ)");
		}
		
	}
	
	
	String teaMenu ="";
	public void teaSelect() {
		System.out.print("> 주문할 메뉴 이름을 입력해주세요 : ");
		teaMenu = scan.next();
		teaList = new TeaListDTO();
		teaList.setTeaMenu(teaMenu);
		
		int stock = 0;
		String sql = "SELECT TEASTOCK FROM TEALIST WHERE TEAMENU = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, teaMenu);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stock = rs.getInt("TEASTOCK");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (stock > 0) {
			System.out.println(teaMenu+"주문 받았습니다~ 잠시만 기다려 주세요(^ㅂ^)!");
			System.out.println(teaMenu+"완성 되었습니다! 맛있게 드세요(^O^)!");
			teaHits();
			teaStcok();
			teaSales();
			salesInsert();
		}else {
			System.out.println("현재 "+teaMenu+"은/는 품절입니다 (ㅠㅅㅠ)");
		}
		
	}
	
	
	String smoothieMenu ="";
	public void smoothieSelect() {
		System.out.print("> 주문할 메뉴 이름을 입력해주세요 : ");
		smoothieMenu = scan.next();
		smoothieList = new SmoothieListDTO();
		smoothieList.setSmoothieMenu(smoothieMenu);
		
		int stock = 0;
		String sql = "SELECT SMOOTHIESTOCK FROM SMOOTHIELIST WHERE SMOOTHIEMENU = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, smoothieMenu);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stock = rs.getInt("SMOOTHIESTOCK");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (stock > 0) {
			System.out.println(smoothieMenu+"주문 받았습니다~ 잠시만 기다려 주세요(^ㅂ^)!");
			System.out.println(smoothieMenu+"완성 되었습니다! 맛있게 드세요(^O^)!");
			smoothieHits();
			smoothieStcok();
			smoothieSales();
			salesInsert();
		}else {
			System.out.println("현재 "+smoothieMenu+"은/는 품절입니다 (ㅠㅅㅠ)");
		}
	}
	
	
	String dessertMenu = "";
	public void dessertSelect() {
		System.out.print("> 주문할 메뉴 이름을 입력해주세요 : ");
		dessertMenu = scan.next();
		dessertList = new DessertListDTO();
		dessertList.setDessertMenu(dessertMenu);
		
		int stock = 0;
		String sql = "SELECT DESSERTSTOCK FROM DESSERTLIST WHERE DESSERTMENU = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,dessertMenu);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stock = rs.getInt("DESSERTSTOCK");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (stock > 0) {
			System.out.println(dessertMenu+"주문 받았습니다~ 잠시만 기다려 주세요(^ㅂ^)!");
			System.out.println(dessertMenu+"완성 되었습니다! 맛있게 드세요(^O^)!");
			dessertHits();
			dessertStcok();
			dessertSales();
			salesInsert();
		}else {
			System.out.println("현재 "+dessertMenu+"은/는 품절입니다 (ㅠㅅㅠ)");
		}
		
	}
	
	public void coffeHits() {
		String sql = "UPDATE COFFELIST SET COFFEHITS = 1+COFFEHITS WHERE COFFEMENU = ?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, coffeList.getCoffeMenu());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void teaHits() {
		String sql = "UPDATE TEALIST SET TEAHITS = 1+TEAHITS WHERE TEAMENU = ?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, teaList.getTeaMenu());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void smoothieHits() {
		String sql = "UPDATE SMOOTHIELIST SET SMOOTHIEHITS = 1+SMOOTHIEHITS WHERE SMOOTHIEMENU = ?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, smoothieList.getSmoothieMenu());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dessertHits() {
		String sql = "UPDATE DESSERTLIST SET DESSERTHITS = 1+DESSERTHITS WHERE DESSERTMENU = ?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dessertList.getDessertMenu());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void coffeStcok() {
		String sql = "UPDATE COFFELIST SET COFFESTOCK = COFFESTOCK-1 WHERE COFFEMENU = ?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, coffeList.getCoffeMenu());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void teaStcok() {
		String sql = "UPDATE TEALIST SET TEASTOCK = TEASTOCK-1 WHERE TEAMENU = ?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, teaList.getTeaMenu());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void smoothieStcok() {
		String sql = "UPDATE SMOOTHIELIST SET SMOOTHIESTOCK = SMOOTHIESTOCK-1 WHERE SMOOTHIEMENU = ?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, smoothieList.getSmoothieMenu());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void dessertStcok() {
		String sql = "UPDATE DESSERTLIST SET DESSERTSTOCK = DESSERTSTOCK-1 WHERE DESSERTMENU = ?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dessertList.getDessertMenu());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void coffeSales() {
		String sql = "SELECT COFFEPRICE FROM COFFELIST WHERE COFFEMENU =?";
		int price = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, coffeMenu);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				price = rs.getInt("COFFEPRICE");
				sales = new SalesDTO();
				sales.setPrice(price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void teaSales() {
		String sql = "SELECT TEAPRICE FROM TEALIST WHERE TEAMENU =?";
		int price = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, teaMenu);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				price = rs.getInt("TEAPRICE");
				sales = new SalesDTO();
				sales.setPrice(price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void smoothieSales() {
		String sql = "SELECT SMOOTHIEPRICE FROM SMOOTHIELIST WHERE SMOOTHIEMENU =?";
		int price = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, smoothieMenu);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				price = rs.getInt("SMOOTHIEPRICE");
				sales = new SalesDTO();
				sales.setPrice(price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void dessertSales() {
		String sql = "SELECT DESSERTPRICE FROM DESSERTLIST WHERE DESSERTMENU =?";
		int price = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dessertMenu);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				price = rs.getInt("DESSERTPRICE");
				sales = new SalesDTO();
				sales.setPrice(price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void salesInsert() {
		String sql = "INSERT INTO CAFEDATE(PRICE,SELECTDATE) VALUES(?,SYSDATE)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sales.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void coffeRandom() {
		int random = (int)(Math.random()*cRandom())+1;
		String sql = "SELECT COFFEMENU FROM COFFELIST WHERE CMENUNUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, random);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("COFFEMENU")+"를 추천합니다d(♥3♥)b!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void teaRandom() {
		int random = (int)(Math.random()*tRandom())+1;
		String sql = "SELECT TEAMENU FROM TEALIST WHERE TMENUNUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, random);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("TEAMENU")+"를 추천합니다d(♥3♥)b!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void smoothieRandom() {
		int random = (int)(Math.random()*sRandom())+1;
		String sql = "SELECT SMOOTHIEMENU FROM SMOOTHIELIST WHERE SMENUNUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, random);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("SMOOTHIEMENU")+"를 추천합니다d(♥3♥)b!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void dessertRandom() {
		int random = (int)(Math.random()*dRandom())+1;
		String sql = "SELECT DESSERTMENU FROM DESSERTLIST WHERE DMENUNUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, random);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("DESSERTMENU")+"를 추천합니다d(♥3♥)b!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int cRandom() {
		String sql = "SELECT COUNT(COFFEMENU) FROM COFFELIST";
		int count=0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt("COUNT(COFFEMENU)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public int tRandom() {
		String sql = "SELECT COUNT(TEAMENU) FROM TEALIST";
		int count=0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt("COUNT(TEAMENU)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int sRandom() {
		String sql = "SELECT COUNT(SMOOTHIEMENU) FROM SMOOTHIELIST";
		int count=0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt("COUNT(SMOOTHIEMENU)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public int dRandom() {
		String sql = "SELECT COUNT(DESSERTMENU) FROM DESSERTLIST";
		int count=0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt("COUNT(DESSERTMENU)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	String cPhone = "";
	public void cStampInsert() {
		System.out.print("> 이름을 입력하세요 :");
		String cName = scan.next();
		System.out.print("> 전화 번호를 입력하세요 : ");
		String cPhone = scan.next();
		
		stamp = new StampDTO();
		stamp.setcName(cName);
		stamp.setcPhone(cPhone);
		
		String sql = "INSERT INTO STAMP(CPHONE, CNAME, CSTAMP) VALUES(?,?,1)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stamp.getcPhone());
			pstmt.setString(2, stamp.getcName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void cStampUpdate() {
		String sql = "UPDATE STAMP SET CSTAMP = 1+CSTAMP WHERE CPHONE = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cPhone);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cStampSelect() {
		System.out.print("> 전화 번호를 입력하세요 : ");
		cPhone = scan.next();
		
		String sql = "SELECT CNAME,CSTAMP FROM STAMP WHERE CPHONE = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cPhone);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString("CNAME")+"님의 스탬프 갯수는 ");
				System.out.println(rs.getString("CSTAMP")+"개 입니다(^♡^)!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	






















































}
