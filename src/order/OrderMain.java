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
		System.out.println("> ������� javaCafe�Դϴ٢�");
		System.out.println("> ��ȣ�� �������ּ���!");
		System.out.println();
		while(end){
			System.out.println();
			System.out.println("-----------��ѨببϨۨ٨�-���-�֨ͨ�ͨϨͨҨ�-----------");
			System.out.println("0.ī�� ���� | 1.�޴� ���� | 2.�޴� �ֹ�  | 3.�޴� ��õ | 4.���� | 5.�ֹ� ����");
			System.out.println("----------------------------������----------------------------");
			System.out.print("���� > ");
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
					System.out.println("����ü �������� ���α��");
					System.out.print("> � �並 �����Ͻðڽ��ϱ�? ");
					num = scan.nextInt();
					if(num == 1) {
						System.out.println("��[��ü �޴�]");
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
						System.out.println("�� �����մϴ�. ('U')b");
					}
				}
				break;
			case 2 :
				stop2 = true;
				while(stop2) {
					System.out.println();
					System.out.println("��coffe ��tea ��smoothie ��dessert");
					System.out.print("> � ������ �ֹ��Ͻðڽ��ϱ�? ");
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
						System.out.println("�ֹ��� �����մϴ�. ('U')b");
					}
				}
				break;
			case 3 :
				stop3 = true;
				while(stop3) {
					System.out.println();
					System.out.println("��coffe ��tea ��smoothie ��dessert");
					System.out.print("> � ���� �߿��� ��õ �����ðڽ��ϱ�? ");
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
						System.out.println("��õ�� �����մϴ�. ('U')b");
					}
				}
				break;
			case 4 :
				boolean stop4 = true;
				while(stop4) {
					System.out.println();
					System.out.println("��ȸ������ ������");
					System.out.print("> ������ �����Ͻðڽ��ϱ�? ");
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
						System.out.println("������ �����մϴ�. ('U')b");
					}
				}
				break;
			case 5 :
				end = false;
				System.out.println("�����մϴ�. ������ �� ������(^_^)��");
				break;
	
			}
		}	

		scan.close();	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
