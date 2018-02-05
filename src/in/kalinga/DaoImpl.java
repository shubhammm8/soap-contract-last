package in.kalinga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements DaoClass{
	public final String user="root";
	public final String pass="Welcome123";
	@Override
	public String getPlayers() {
		List<Player> players=new ArrayList();
		String res="";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate13",user,pass);
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("SELECT * FROM PLAYER");
			
			while(rs.next()){
				Player p=new Player();
				
				p.setPid(rs.getInt("pid"));
				p.setPlayerName(rs.getString("playerName"));
				p.setFootballStuds(rs.getString("footballStuds"));
				p.setPosition(rs.getString("position"));
				p.setTid(rs.getInt("tid"));
				res=res+rs.getString("playerName");
				players.add(p);
			}
			System.out.println(res);
		}catch(SQLException w){
			w.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
		return res;
	}


	public String insert(String fs, String pos, String pn, int tid) {
		String res="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate13",user,pass);
			PreparedStatement ps=c.prepareStatement("Insert into player values(null,?,?,?,?)");
			ps.setString(1,fs);
			ps.setString(2, pn);
			ps.setString(3, pos);
			ps.setInt(4,tid);
			int re=ps.executeUpdate();
			res="done";
			System.out.println("done");
			
			
		} catch (ClassNotFoundException e) {
		
			res="not done";
			e.printStackTrace();
		} catch (SQLException e) {
			res="not done";
			
			e.printStackTrace();
		}
		
		
		return res;
	}

}
