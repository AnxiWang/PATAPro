package PATAPro;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
public class Adddata implements ActionListener {
//	Button charu;
//	TextField input1,input2,input3,input4,input5,input6;
//	TextArea show;
//
//	int k,s1,j;
//	
	Connection con;
    Statement sql; 
//    int sum=0;
//    ResultSet rs;
    static String name;
   static double pdr,overhead,delay;

			public Adddata(String result) {
		// TODO Auto-generated constructor stub
				String Result=result;
				String insert,recode;
				String a[]=Result.split("\n");
				name=a[0];
				pdr=Double.parseDouble(a[2]);
				overhead=Double.parseDouble(a[4]);
				delay=Double.parseDouble(a[6]);
//				System.out.println(pdr);
//				System.out.println(overhead);
//				System.out.println(name);
				try {  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
		        }
		   catch(ClassNotFoundException eee)
		        {  System.out.println(""+eee);
		        }
		    try {  con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Ad-hoc","sa","wanganxi");	
		           sql=con.createStatement();
		     recode="('"+name+"',"+pdr+","+overhead+","+delay+")";
		     if(name.indexOf("aodv")>0)
		     {
		           insert="INSERT INTO AODV VALUES "+recode;
		          //+recode
		           sql.executeUpdate(insert);
		           con.close();
		     }
		     else if(name.indexOf("dsdv")>0)
		     {
		    	 insert="INSERT INTO DSDV VALUES "+recode;
		          //+recode
		           sql.executeUpdate(insert);
		           con.close();
		     }
		     else{
		    	 insert="INSERT INTO DSR VALUES "+recode;
		          //+recode
		           sql.executeUpdate(insert);
		           con.close();
		     }
		         }
		    
		           catch(SQLException e) 
		           {  System.out.println(e);
		           		//JOptionPane.showMessageDialog(this, "你输入的不正确");
		           }
	}
			
			public void actionPerformed(ActionEvent ee) {
//		boolean boo=true;
		String insert,recode;
//		int m0,m1,m2,m3,number,sqlgrade,netgrade;
//		
//		
//		s0=input6.getText();
//		m0=Integer.parseInt(s0);
//		ID=s0;
//		s1=input1.getText();
//		m1=Integer.parseInt(s1);
//		number=m1;
//		s2=input2.getText();
//		name=s2;
//		s3=input3.getText();
//		date=s3;
//		s4=input4.getText();
//		m2=Integer.parseInt(s4);
//		sqlgrade=m2;
//		s5=input5.getText();
//		m3=Integer.parseInt(s5);
//		netgrade=m3;
//		try {  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
//        }
//   catch(ClassNotFoundException eee)
//        {  System.out.println(""+eee);
//        }
//    try {  con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Ad-hoc","sa","wanganxi");	
//           sql=con.createStatement();
//     recode="("+pdr+","+overhead+","+"'"+delay+"')";
//           insert="INSERT INTO AODV  VALUES "+recode;
//          //+recode
//           sql.executeUpdate(insert);
      
//           show.setText("你插入了:");
//    	 show.append("ID："+ID+" 学号："+number+"  姓名："+name+"  出生："+date+" 数据库成绩"+sqlgrade+" 计算机网络 "+netgrade);
//    	 show.append("\n");
//    	 con.close();
         }
   // con.close();
//           catch(SQLException e) 
//           {  System.out.println(e);
//           		//JOptionPane.showMessageDialog(this, "你输入的不正确");
//           }
   }    
//@Override
//public void actionPerformed(ActionEvent arg0) {
//	// TODO Auto-generated method stub
//	
//}
 