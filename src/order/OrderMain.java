package order;

import java.util.Scanner;

public class OrderMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean end = true;
		boolean stop1 = true;
		boolean stop2 = true;
		boolean stop3 = true;
		int selectNo = 0;
		int num = 0;

		OrderDAO oDAO = new OrderDAO();
		
		
		System.out.println();
		System.out.println("> 어서오세요 javaCafe입니다♥");
		System.out.println("> 번호를 선택해주세요!");
		System.out.println();
		while(end){
			System.out.println();
			System.out.println("-----------ⓦⓔⓛⓛⓒⓞⓜⓔ-ⓣⓞ-ⓙⓐⓥⓐⓒⓐⓕⓔ-----------");
			System.out.println("0.카페 입장 | 1.메뉴 보기 | 2.메뉴 주문  | 3.메뉴 추천 | 4.적립 | 5.주문 종료");
			System.out.println("----------------------------♥♡♥----------------------------");
			System.out.print("선택 > ");
			selectNo = scan.nextInt();
		
			switch(selectNo) {
			case 0 :
				oDAO.dbconnection();
				System.out.println();
				break;
			case 1 :
				stop1 = true;
				while(stop1) {
					System.out.println();
					System.out.println();
					System.out.println("①전체 ②종류별 ③인기순");
					System.out.print("> 어떤 뷰를 선택하시겠습니까? ");
					num = scan.nextInt();
					if(num == 1) {
						System.out.println("●[전체 메뉴]");
						oDAO.allView();
						System.out.println();
						oDAO.allView1();
						System.out.println();
						oDAO.allView2();
						System.out.println();
						oDAO.allView3();
					}else if(num == 2) {
						oDAO.typeView();
					}else if(num == 3) {
						oDAO.hotView();
					}else {
						stop1 = false;
						System.out.println("뷰어를 종료합니다. ('U')b");
					}
				}
				break;
			case 2 :
				stop2 = true;
				while(stop2) {
					System.out.println();
					System.out.println("①coffe ②tea ③smoothie ④dessert");
					System.out.print("> 어떤 종류를 주문하시겠습니까? ");
					num = scan.nextInt();
					
					if(num == 1) {
						oDAO.coffeSelect();
						System.out.println();
					}else if(num == 2) {
						oDAO.teaSelect();
						System.out.println();
					}else if(num == 3) {
						oDAO.smoothieSelect();
						System.out.println();
					}else if (num == 4) {
						oDAO.dessertSelect();
						System.out.println();
					}else {
						stop2 = false;
						System.out.println("주문을 종료합니다. ('U')b");
					}
				}
				break;
			case 3 :
				stop3 = true;
				while(stop3) {
					System.out.println();
					System.out.println("①coffe ②tea ③smoothie ④dessert");
					System.out.print("> 어떤 종류 중에서 추천 받으시겠습니까? ");
					num = scan.nextInt();
					
					if(num == 1) {
						oDAO.coffeRandom();
						System.out.println();
					}else if(num == 2) {
						oDAO.teaRandom();
						System.out.println();
					}else if(num == 3) {
						oDAO.smoothieRandom();
						System.out.println();
					}else if (num == 4) {
						oDAO.dessertRandom();
						System.out.println();
					}else {
						stop3 = false;
						System.out.println("추천을 종료합니다. ('U')b");
					}
				}
				break;
			case 4 :
				boolean stop4 = true;
				while(stop4) {
					System.out.println();
					System.out.println("①회원가입 ②적립");
					System.out.print("> 무엇을 선택하시겠습니까? ");
					num = scan.nextInt();
					if(num == 1) {
						oDAO.cStampInsert();
						System.out.println();
					}else if(num == 2) {
						oDAO.cStampUpdate();
						oDAO.cStampSelect();
						System.out.println();
					}else {
						stop4 = false;
						System.out.println("적립을 종료합니다. ('U')b");
					}
				}
				break;
			case 5 :
				end = false;
				System.out.println("감사합니다. 다음에 또 오세요(^_^)♬");
				break;
	
			}
		}	

		scan.close();	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
