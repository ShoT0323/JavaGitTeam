package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.LendLocker;
import dto.Locker;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class LockerDAO {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
//ロッカー利用者
	public static int quizAccount(Locker account) {
		String sql = "INSERT INTO Locker VALUES(default, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		
		// ランダムなソルトの取得(今回は32桁で実装)
		String salt = GenerateSalt.getSalt(32);
		
		// 取得したソルトを使って平文PWをハッシュ
		String hashedPw = GenerateHashedPw.getSafetyPassword(account.getPassword(), salt);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, account.getMail());
			pstmt.setString(2, account.getName());
			pstmt.setString(3, salt);
			pstmt.setString(4, hashedPw);
			

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	// メールアドレスを元にソルトを取得
	public static String getSalt(String mail) {
		String sql = "SELECT salt FROM Locker WHERE mail = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("salt");
					return salt;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	// ログイン処理
		public static Locker login(String mail, String hashedPw) {
			String sql = "SELECT * FROM Locker WHERE mail = ? AND password = ?";
			
			try (
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				pstmt.setString(1, mail);
				pstmt.setString(2, hashedPw);

				try (ResultSet rs = pstmt.executeQuery()){
					
					if(rs.next()) {
						int lockerno = rs.getInt("lockerno");
						String name = rs.getString("name");
						String salt = rs.getString("salt");
						
						return new Locker(lockerno, name, mail, salt, hashedPw,null);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return null;
		}
//ロッカー登録機能
	public static int registerLocker(LendLocker Number) {
		String sql = "INSERT INTO  lendlocker VALUES(default, ?, ?, ?, ?, ?, ?, ?)";
		int result=0;
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1,Number.getStuff1() );
            pstmt.setString(2,Number.getStuff2() );
            pstmt.setString(3,Number.getStuff3() );
            pstmt.setInt(6,Number.getOpen() );
          
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件登録しました。");
		}
		return result;
	}
		public static List<LendLocker> selectAllLocker(){
			
			
			//返却用変数
			List<LendLocker>result = new ArrayList<>();
			
			String sql = "SELECT * FROM lendlocker";
			try (
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				try (ResultSet l = pstmt.executeQuery()){
					while(l.next()) {
						int Lockerno = l.getInt("lockerno");
						String Stuff1 = l.getString("stuff1");
						String Stuff2 = l.getString("stuff2");
						String Stuff3 = l.getString("stuff3");
						int Open = l.getInt("open");

						LendLocker Locker = new LendLocker(Lockerno, Stuff1, Stuff2, Stuff3, Open);

					result.add(Locker);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();

				// Listを返却する。0件の場合は空のListが返却される。
			}
			return result;
		}


}