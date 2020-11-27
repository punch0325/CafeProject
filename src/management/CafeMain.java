package management;


import java.util.Scanner;

public class CafeMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean end = true;
		boolean stop1 = true;
		boolean stop2 = true;
		boolean stop3 = true;
		boolean stop4 = true;
		boolean stop5 = true;
		int selectNo = 0;
		
		
		CafeDAO cDAO = new CafeDAO();
		
		while(end){
			System.out.println();
			System.out.println("***********                  JAVA★☆★CAFE                **********");
			System.out.println("─────────────────────────────────────────────────────────────────────");
			System.out.println("▷0.출근 | 1.메뉴 등록 | 2.메뉴 수정  | 3.메뉴 삭제 | 4.메뉴 재고 | 5.매출 관리 | 6.퇴근 ◁ ");
			System.out.println("─────────────────────────────────────────────────────────────────────");
			System.out.println("*********************************************************************");
			System.out.print("선택 : ");

			selectNo = scan.nextInt();
			switch(selectNo) {
			case 0 :
				cDAO.dbconnection();
				System.out.println();
				break;
			case 1 :
				stop1 = true;
				while (stop1) {
					System.out.println();
					System.out.println("①coffe ②tea ③smoothie ④dessert");
					System.out.print("> 어떤 종류를 등록 하시겠습니까? ");
					int num = scan.nextInt();
				
					if(num == 1) {
						cDAO.coffeAdd();
					}else if(num == 2) {
						cDAO.teaAdd();
					}else if(num == 3) {
						cDAO.smoothieAdd();
					}else if (num == 4) {
						cDAO.dessertAdd();
					}else {
						stop1 = false;
						System.out.println("※등록 끝 <('▽')/ ");
					}
				}
				break;
			case 2 :
				stop2 = true;
				while (stop2) {
					System.out.println();
					System.out.println("①coffe ②tea ③smoothie ④dessert");
					System.out.print("> 어떤 종류를 수정 하시겠습니까? ");
					int num = scan.nextInt();
				
					if(num == 1) {
						cDAO.coffeUpdate();
					}else if(num == 2) {
						cDAO.teaUpdate();
					}else if(num == 3) {
						cDAO.smoothieUpdate();
					}else if (num == 4) {
						cDAO.dessertUpdate();
					}else {
						stop2 = false;
						System.out.println("※수정 끝  <('▽')/ ");
					}
				}
				break;
			case 3 :
				stop3 = true;
				while (stop3) {
					System.out.println();
					System.out.println("①coffe ②tea ③smoothie ④dessert");
					System.out.print("> 어떤 종류를 삭제 하시겠습니까? ");
					int num = scan.nextInt();
				
					if(num == 1) {
						cDAO.coffeDelete();
					}else if(num == 2) {
						cDAO.teaDelete();
					}else if(num == 3) {
						cDAO.smoothieDelete();
					}else if (num == 4) {
						cDAO.dessertDelete();
					}else {
						stop3 = false;
						System.out.println("※삭제 끝  <('▽')/ ");
					}
				}
				break;
			case 4 :
				stop4 = true;
				while (stop4) {
					System.out.println();
					System.out.println("①coffe ②tea ③smoothie ④dessert");
					System.out.print("> 어떤 종류의 재고를 확인하시겠습니까? ");
					int num = scan.nextInt();
					if(num == 1) {
						cDAO.cStockView();
					}else if(num == 2) {
						cDAO.tStockView();
					}else if(num == 3) {
						cDAO.sStockView();
					}else if (num == 4) {
						cDAO.dStockView();
					}else {
						stop4 = false;
						System.out.println("※확인 끝  <('▽')/ ");
					}
				}
				break;
			case 5 :
				stop5 = true;
				while (stop5) {
					System.out.println();
					System.out.println("①총매출  ②일매출 ③월매출 ④연매출");
					System.out.print("> 어떤 매출을 확인하시겠습니까? ");
					int num = scan.nextInt();
					if(num == 1) {
						cDAO.allSales();
					}else if(num == 2) {
						cDAO.daySales();
					}else if(num == 3) {
						cDAO.monthSales();
					}else if (num == 4) {
						cDAO.yearSales();
					}else {
						stop5 = false;
						System.out.println("※확인 끝  <('▽')/ ");
					}
				}
				break;
			case 6 :
				end = false;
				System.out.println("  수고하셨습니다 ㄴ(^▽^)ㄱ !");
				break;
			}
		}
	
	
		scan.close();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
