package EncoreTeamProject.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import EncoreTeamProject.DataBaseConnect;

public class CarDaoImpl implements CarDao {
	private DataBaseConnect db;
	public CarDaoImpl(){
		db = DataBaseConnect.getInstance();
	}
	@Override
	public void Insert(CarVO cvo) {
		// TODO Auto-generated method stub
		
		String sql = "insert into car values(?,?,?,?,?,?,?)";
		//1. db Ŀ�ؼ� ����
		Connection conn = db.getConnect();
		try {
			//2. Ŀ�ؼ� ��ü�� ������Ʈ��Ʈ ��ü ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//3. sql���� ? ����
			pstmt.setInt(1, cvo.getCarNum());
			pstmt.setString(2, cvo.getId());
			pstmt.setString(3, cvo.getCarColor());
			pstmt.setString(4, cvo.getCarSize());
			pstmt.setTimestamp(5, java.sql.Timestamp.valueOf(LocalDateTime.now()));
			pstmt.setInt(6, cvo.isGuest() ? 1 : 0);
			pstmt.setInt(7, cvo.isPayed() ? 1 : 0);
			//4. ���� ����
			pstmt.executeUpdate();		//���� ���� , executeQuere => �б� ���� select�� ���
			System.out.println("������ ���� ����");
		} catch(java.sql.SQLIntegrityConstraintViolationException e){
			System.out.println("id �ߺ�");
		}catch (SQLException e) {
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
	public void Delete(int carNum) {
		// TODO Auto-generated method stub
		String sql = "delete from car where carNumber = "+ carNum;
		Connection conn = db.getConnect();
		try {
			//2. Ŀ�ؼ� ��ü�� ������Ʈ��Ʈ ��ü ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int a = pstmt.executeUpdate();		//���� ���� , executeQuere => �б� ���� select�� ���
			if(a == 0) System.out.println("�� ��ȣ �Է� ����");
			else System.out.println("������ ���� ����");
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
	public CarVO SelectByNum(int num) {
		// TODO Auto-generated method stub
		String sql = "select * from car where carnumber = "+num;
		ResultSet rs = null;
		Connection conn = db.getConnect();
		CarVO cvo = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cvo = new CarVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(6) == 1 ? true: false,rs.getInt(7) == 1 ? true: false);
				cvo.setCarEnrollDate(rs.getTimestamp(5).toLocalDateTime());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cvo;
	}
	
	@Override
	public ArrayList<CarVO> SelectById(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from car where id = '" + id+"'";
		ArrayList<CarVO> list = new ArrayList<CarVO>();
		ResultSet rs = null;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){	//rs.next() �˻� ������� �� �̵�
				int num = rs.getInt(1);
				String carColor = rs.getString(3);
				String carSize = rs.getString(4);
				LocalDateTime carEnrollDate = rs.getTimestamp(5).toLocalDateTime();
				boolean guest = rs.getInt(6) == 1 ? true: false;
				boolean isPayed = rs.getInt(7) == 1? true : false;
				CarVO cvo = new CarVO(num,carColor,carSize, id, guest, isPayed);
				cvo.setCarEnrollDate(carEnrollDate);
				list.add(cvo);
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
		return list;
	}
	
	@Override
	public ArrayList<CarVO> SelectAll() {
		// TODO Auto-generated method stub
		String sql = "select * from car";
		ArrayList<CarVO> list = new ArrayList<CarVO>();
		ResultSet rs = null;
		Connection conn =db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){	//rs.next() �˻� ������� �� �̵�
				int num = rs.getInt(1);
				String id = rs.getString(2);
				String carColor = rs.getString(3);
				String carSize = rs.getString(4);
				LocalDateTime carEnrollDate = rs.getTimestamp(5).toLocalDateTime();
				boolean guest = rs.getInt(6) == 1 ? true: false;
				boolean isPayed = rs.getInt(7) == 1? true : false;
				CarVO cvo = new CarVO(num,carColor,carSize, id, guest, isPayed);
				cvo.setCarEnrollDate(carEnrollDate);
				list.add(cvo);
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
		return list;
	}

	@Override
	public void Update(CarVO cvo, int newNum) {
		// TODO Auto-generated method stub
		String sql = "update car set carnumber = ?, carcolor = ?, carsize= ?, guest = ? where carnumber = ?";
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, newNum);
			pstmt.setString(2, cvo.getCarColor());
			pstmt.setString(3, cvo.getCarSize());
			pstmt.setInt(4, cvo.isGuest() ? 1 : 0);
			pstmt.setInt(5,cvo.getCarNum());
			pstmt.executeUpdate();		//���� ���� , executeQuere => �б� ���� select�� ���
			System.out.println("���� ����");
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
	public void ChangePaymentState(CarVO cvo) {
		// TODO Auto-generated method stub
		int payed = cvo.isPayed() ? 1 : 0;
		String sql = "update car set ispayed = " + payed +"where carnumber = " + cvo.getCarNum();
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();		//���� ���� , executeQuere => �б� ���� select�� ���
			System.out.println("���� ����");
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


}
