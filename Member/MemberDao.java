package EncoreTeamProject.Member;

import java.util.ArrayList;

public interface MemberDao {
	public void insert(MemberVO m); // ����� ���� �Է�

	public void delete(String id); // ����� ����

	public MemberVO selectByID(String id); // ����� ����(id)

	public ArrayList<MemberVO> selectAll(); // ����� ��ü ����

	void updatePW(MemberVO m, String newPW);

	void updatePhoneNum(MemberVO m, int phoneNum);

	void updateRegister(MemberVO m, int register);

	void insertSignUp(MemberVO m);

	int checkId(String id);
}
