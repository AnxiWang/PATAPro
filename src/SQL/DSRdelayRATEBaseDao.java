package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DSRdelayRATEBaseDao{
	public final static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public final static String URL = "jdbc:sqlserver://localhost:1433;DataBaseName = Ad-hoc";
	public final static String DBNAME = "sa";
	public final static String DBPASS = "wanganxi";
	public static Connection getConn() throws ClassNotFoundException, SQLException {
 	Class.forName(DRIVER);
 	Connection conn = DriverManager.getConnection(URL, DBNAME, DBPASS);
 	return conn;
	}
 
 public List<Double> getList(){
	 List<Double> list= new ArrayList<Double>();
	 String SQL="select * from AEDRATE";
	 try{
		 Connection conn = DSRdelayRATEBaseDao.getConn();
		 Statement stmt = conn.createStatement();
		 ResultSet rs = stmt.executeQuery(SQL);
		 while(rs.next()){
			 list.add(rs.getDouble("dsr"));
		 }
	 }catch(Exception e){
		 System.out.println("”–“Ï≥£");
	 }
	 return list;
 	}
}
