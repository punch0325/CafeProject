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
		System.out.println("javaCafe拭 脊舌馬心柔艦陥:)");
	}

	public void allView() {
		String sql = "SELECT * FROM COFFELIST";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("COFFEMENU"));
				System.out.print(rs.getInt("COFFEPRICE")+"据   ");
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
				System.out.print(rs.getInt("COFFEPRICE")+"据   ");
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
				System.out.print(rs.getInt("TEAPRICE")+"据   ");
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
				System.out.print(rs.getInt("TEAPRICE")+"据   ");
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
				System.out.print(rs.getInt("SMOOTHIEPRICE")+"据   ");
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
				System.out.print(rs.getInt("SMOOTHIEPRICE")+"据   ");
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
				System.out.print(rs.getInt("DESSERTPRICE")+"据   ");
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
				System.out.print(rs.getInt("DESSERTPRICE")+"据   ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void typeView() {
		boolean stop = true;
		System.out.println("��coffe ��tea ��smoothie ��dessert");
		while (stop) {
			System.out.print("∈�� 嬢恐 曽嫌税 五敢研 左獣畏柔艦猿? ");
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
				System.out.println("『陥献 腰硲研 識澱馬獣暗蟹 坂嬢研 曽戟背爽室推");
			}
		}
	}

	public void hotView() {
		boolean stop = true;
		System.out.println("��coffe ��tea ��smoothie ��dessert");
		while (stop) {
			System.out.print("∈ 嬢恐 曽嫌税 昔奄授是研 左獣畏柔艦猿? ");
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
				System.out.println("『陥献 腰硲研 識澱馬獣暗蟹 坂嬢研 曽戟背爽室推");
			}
		}
		
	}

	
	String coffeMenu = "";
	public void coffeSelect() {
		System.out.print("> 爽庚拝 五敢 戚硯聖 脊径背爽室推 : ");
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
			System.out.println(coffeMenu+"爽庚 閤紹柔艦陥~ 節獣幻 奄陥形 爽室推(^げ^)!");
			System.out.println(coffeMenu+"刃失 鞠醸柔艦陥! 言赤惟 球室推(^O^)!");
			coffeHits();
			coffeStcok();
			coffeSales();
			salesInsert();
		}else {
			System.out.println("薄仙 "+coffeMenu+"精/澗 念箭脊艦陥 (ばさば)");
		}
		
	}
	
	
	String teaMenu ="";
	public void teaSelect() {
		System.out.print("> 爽庚拝 五敢 戚硯聖 脊径背爽室推 : ");
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
			System.out.println(teaMenu+"爽庚 閤紹柔艦陥~ 節獣幻 奄陥形 爽室推(^げ^)!");
			System.out.println(teaMenu+"刃失 鞠醸柔艦陥! 言赤惟 球室推(^O^)!");
			teaHits();
			teaStcok();
			teaSales();
			salesInsert();
		}else {
			System.out.println("薄仙 "+teaMenu+"精/澗 念箭脊艦陥 (ばさば)");
		}
		
	}
	
	
	String smoothieMenu ="";
	public void smoothieSelect() {
		System.out.print("> 爽庚拝 五敢 戚硯聖 脊径背爽室推 : ");
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
			System.out.println(smoothieMenu+"爽庚 閤紹柔艦陥~ 節獣幻 奄陥形 爽室推(^げ^)!");
			System.out.println(smoothieMenu+"刃失 鞠醸柔艦陥! 言赤惟 球室推(^O^)!");
			smoothieHits();
			smoothieStcok();
			smoothieSales();
			salesInsert();
		}else {
			System.out.println("薄仙 "+smoothieMenu+"精/澗 念箭脊艦陥 (ばさば)");
		}
	}
	
	
	String dessertMenu = "";
	public void dessertSelect() {
		System.out.print("> 爽庚拝 五敢 戚硯聖 脊径背爽室推 : ");
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
			System.out.println(dessertMenu+"爽庚 閤紹柔艦陥~ 節獣幻 奄陥形 爽室推(^げ^)!");
			System.out.println(dessertMenu+"刃失 鞠醸柔艦陥! 言赤惟 球室推(^O^)!");
			dessertHits();
			dessertStcok();
			dessertSales();
			salesInsert();
		}else {
			System.out.println("薄仙 "+dessertMenu+"精/澗 念箭脊艦陥 (ばさば)");
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
				System.out.println(rs.getString("COFFEMENU")+"研 蓄探杯艦陥d(⊂3⊂)b!");
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
				System.out.println(rs.getString("TEAMENU")+"研 蓄探杯艦陥d(⊂3⊂)b!");
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
				System.out.println(rs.getString("SMOOTHIEMENU")+"研 蓄探杯艦陥d(⊂3⊂)b!");
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
				System.out.println(rs.getString("DESSERTMENU")+"研 蓄探杯艦陥d(⊂3⊂)b!");
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
		System.out.print("> 戚硯聖 脊径馬室推 :");
		String cName = scan.next();
		System.out.print("> 穿鉢 腰硲研 脊径馬室推 : ");
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
		System.out.print("> 穿鉢 腰硲研 脊径馬室推 : ");
		cPhone = scan.next();
		
		String sql = "SELECT CNAME,CSTAMP FROM STAMP WHERE CPHONE = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cPhone);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString("CNAME")+"還税 什兎覗 姐呪澗 ");
				System.out.println(rs.getString("CSTAMP")+"鯵 脊艦陥(^⊇^)!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	






















































}
