package EncoreTeamProject.Member;

import java.util.Scanner;

import EncoreTeamProject.Community.ComMenu;

public class ManagerMenu {
	private MemberService mService; 
	private ComMenu cMenu;
	
	public ManagerMenu() {
		this.mService = new MemberServiceImpl();
		cMenu = new ComMenu();
	}
	
	public void run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		String str = "1.������ �ܺ������ӽõ�� ��ȸ\n 2.�ܺ������ӽõ��\n 3.������ ������� ��ȸ\n 4.������� ����\n 5.���ֹ� ��ü���\n 6.���ֹ� ��ȸ\n 7.���ֹ� ����\n 8.���ֹ� ���Խ��ν�û ������\n 9.���ֹ� ���Խ�û ����\n 10.���ֹ� ���Խ��ν�û ����\n 11.Ŀ�´�Ƽ 12.����";
		while (flag) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				//������ �ܺ������ӽõ�� ��ü���
				mService.printTempCarRegisterAll();
				break;
			case 2:	
				//�ܺ������ӽõ�� ����
				mService.acceptCar(sc);
				break;
			case 3:
				//������ ������� ��ȸ
				mService.printMyCarRegisterAll();
				break;
			case 4:
				//������� ����
				mService.acceptCar(sc);
				break;
			case 5:
				//���ֹ� ��ü���
				mService.printAll();
				break;
			case 6:
				//���ֹ� ��ȸ(id)
				mService.printMember(sc);
				break;
			case 7:
				//���ֹ� ����(id)
				mService.delMember(sc);
				break;
			case 8:	
				//���ֹ� ���Խ��ν�û ������
				mService.printSingUpList();
				break;
			case 9:
				//���ֹ� ���Խ�û ����
				mService.acceptSignUP(sc);
				break;
			case 10:
				//���ֹ� ���Խ��ν�û ����
				mService.deleteSignUP(sc);
				break;
			case 11:
				cMenu.run(sc);
				break;
			case 12:
				flag = false;
				break;
			default:
				System.out.println("�߸��� ��ȣ�Դϴ�.");
			}
		}
	}
}
