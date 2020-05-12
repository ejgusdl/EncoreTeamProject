package EncoreTeamProject.Member;

import java.util.Scanner;

import EncoreTeamProject.Car.CarService;
import EncoreTeamProject.Car.CarServiceImpl;
import EncoreTeamProject.Community.ComMenu;

public class ManagerMenu {
	private MemberService mService; 
	private CarService cService;
	private ComMenu cMenu;
	
	public ManagerMenu() {
		this.mService = new MemberServiceImpl();
		cService = new CarServiceImpl();
		cMenu = new ComMenu();
	}
	
	public void run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		String str = "1.������ �ܺ������ӽõ�� ��ȸ\n  2.�ܺ������ӽõ��\n  3.��ϵ� �ܺ����� ��ȸ\n  4.������ ������� ��ȸ\n  5.������� ����\n 6.��ϵ� ���� ��ȸ\n 7.�̰������������ȸ\n 8.���ֹ� ��ü���\n 9.���ֹ� ��ȸ\n 10.���ֹ� ����\n 11.���ֹ� ���Խ��ν�û ������\n 12.���ֹ� ���Խ�û ����\n 13.���ֹ� ���Խ��ν�û ����\n 14.Ŀ�´�Ƽ 15.����";
		while (flag) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				//������ �ܺ������ӽõ�� ��ü���
				break;
			case 2:	
				//�ܺ������ӽõ��
				break;
			case 3:
				//��ϵ� �ܺ����� ��ȸ
				break;
			case 4:
				//������ ������� ��ȸ
				break;
			case 5:
				//������� ����
				break;
			case 6:
				//��ϵ� ���� ��ȸ
				break;
			case 7:
				//�̰������������ȸ
				break;
			case 8:
				//���ֹ� ��ü���
				mService.printAll();
				break;
			case 9:
				//���ֹ� ��ȸ(id)
				mService.printMember(sc);
				break;
			case 10:
				//���ֹ� ����(id)
				mService.delMember(sc);
				break;
			case 11:	
				//���ֹ� ���Խ��ν�û ������
				mService.printSingUpList();
				break;
			case 12:
				//���ֹ� ���Խ�û ����
				mService.acceptSignUP(sc);
				break;
			case 13:
				//���ֹ� ���Խ��ν�û ����
				mService.deleteSignUP(sc);
				break;
			case 14:
				cMenu.run(sc);
				break;
			case 15:
				flag = false;
				break;
			default:
				System.out.println("�߸��� ��ȣ�Դϴ�.");
			}
		}
	}
}
