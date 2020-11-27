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
			System.out.println("***********                  JAVA�ڡ١�CAFE                **********");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("��0.��� | 1.�޴� ��� | 2.�޴� ����  | 3.�޴� ���� | 4.�޴� ��� | 5.���� ���� | 6.��� �� ");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("*********************************************************************");
			System.out.print("���� : ");

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
					System.out.println("��coffe ��tea ��smoothie ��dessert");
					System.out.print("> � ������ ��� �Ͻðڽ��ϱ�? ");
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
						System.out.println("�ص�� �� <('��')/ ");
					}
				}
				break;
			case 2 :
				stop2 = true;
				while (stop2) {
					System.out.println();
					System.out.println("��coffe ��tea ��smoothie ��dessert");
					System.out.print("> � ������ ���� �Ͻðڽ��ϱ�? ");
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
						System.out.println("�ؼ��� ��  <('��')/ ");
					}
				}
				break;
			case 3 :
				stop3 = true;
				while (stop3) {
					System.out.println();
					System.out.println("��coffe ��tea ��smoothie ��dessert");
					System.out.print("> � ������ ���� �Ͻðڽ��ϱ�? ");
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
						System.out.println("�ػ��� ��  <('��')/ ");
					}
				}
				break;
			case 4 :
				stop4 = true;
				while (stop4) {
					System.out.println();
					System.out.println("��coffe ��tea ��smoothie ��dessert");
					System.out.print("> � ������ ��� Ȯ���Ͻðڽ��ϱ�? ");
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
						System.out.println("��Ȯ�� ��  <('��')/ ");
					}
				}
				break;
			case 5 :
				stop5 = true;
				while (stop5) {
					System.out.println();
					System.out.println("���Ѹ���  ���ϸ��� ������� �꿬����");
					System.out.print("> � ������ Ȯ���Ͻðڽ��ϱ�? ");
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
						System.out.println("��Ȯ�� ��  <('��')/ ");
					}
				}
				break;
			case 6 :
				end = false;
				System.out.println("  �����ϼ̽��ϴ� ��(^��^)�� !");
				break;
			}
		}
	
	
		scan.close();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
