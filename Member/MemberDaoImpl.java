package EncoreTeamProject.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import EncoreTeamProject.DataBaseConnect;

public class MemberDaoImpl implements MemberDao {
	private DataBaseConnect db;
	
	public MemberDaoImpl() {
		db= DataBaseConnect.getInstance();
	}

	@Override
	public void insert(MemberVO m) {
		// TODO Auto-generated method stub
		
		String sql = "insert into member values(?,?,?)";
		
		//1. db Ŀ�ؼ� ����
		Connection conn = db.getConnect();
		try {
			//2. Ŀ�ؼ� ��ü�� ������Ʈ��Ʈ ��ü ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//3. sql ����
			pstmt.setString(1,  m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setInt(3, m.getPhoneNum());
			pstmt.setInt(4, m.getRegister());
			//4. ���� ����
			pstmt.executeUpdate();	//���� ����, executeQuere: �б� ���� select�� ���
			System.out.println("��� ������ ���� ����");
		} catch(java.sql.SQLIntegrityConstraintViolationException e){
			System.out.println("id �ߺ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from member where id = " + id;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int a = pstmt.executeUpdate();
			if(a==0) {
				System.out.println("id �Է� ����");
			} else {
				System.out.println("��� ���� ����");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public MemberVO selectByID(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from member where id = '" + id + "'  ";
		ResultSet rs = null;
		Connection conn = db.getConnect();
		MemberVO m = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				m = new MemberVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return m;
	}

	@Override
	public ArrayList<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		String sql = "select * from member";
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		ResultSet rs = null;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) { //rs.next() �˻� ������� �� �̵�
				String id = rs.getString(1);
				String pw = rs.getString(2);
				int phoneNum = rs.getInt(3);
				int register = rs.getInt(4);
				MemberVO m = new MemberVO(id, pw, phoneNum, register);
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}


	@Override
	public void updatePW(MemberVO m, String newPW) {
		// TODO Auto-generated method stub
		String sql = "update member set pw = ?";
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, newPW);
			pstmt.setInt(3, m.getPhoneNum());
			pstmt.setInt(4, m.getRegister());
			pstmt.executeUpdate();
			System.out.println("pw ���� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updatePhoneNum(MemberVO m, int phoneNum) {
		// TODO Auto-generated method stub
		String sql = "update member set phoneNum = ?";
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setInt(3, phoneNum);
			pstmt.executeUpdate();
			System.out.println("��ȭ��ȣ ���� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void updateRegister(MemberVO m, int register) {
		// TODO Auto-generated method stub
		String sql = "update member set register = ?";
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setInt(3, m.getPhoneNum());
			pstmt.setInt(4, register);
			pstmt.executeUpdate();
			System.out.println("���Խ��ο��� ���� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void insertSignUp(MemberVO m) {
		String sql = "insert into member values (?,?,?,-1)";

		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setInt(3, m.getPhoneNum());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public int checkId(String id) {
		String sql = "select id from member where id = ?";

		ResultSet rs = null;
		Connection conn = db.getConnect();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 1;
	}
}
