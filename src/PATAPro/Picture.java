package PATAPro;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import config.DirConfig;
//---------------------------------------------------------------------------

public class Picture
{
	Connection con;
    Statement sql; 

	public Picture(final Shell parent, final int style)
{
		final Shell shell = new Shell(parent);
		shell.setLayout(null);         //设置shell的布局方式
		shell.setText("绘图");  //设置主窗体的标题
		shell.setSize(520,620);        //设置主窗体的大小 
		// 通过shell对象和SWT.BAR样式值来创建一个菜单条  
		Menu menu = new Menu(shell, SWT.BAR);
        // 在菜单条的基础之上创建一个File的菜单
        MenuItem part = new MenuItem(menu, SWT.CASCADE);
        part.setText("&要素");
        // 先在Shell上创建一个下拉框，然后将下拉框添加到File菜单上
        Menu partmenu = new Menu(shell, SWT.DROP_DOWN);
        part.setMenu(partmenu);
        // 在下拉框上创建菜单项
        MenuItem partItem1 = new MenuItem(partmenu, SWT.CASCADE);
        partItem1.setText("&Packet delivery ratio");
        new MenuItem(partmenu, SWT.SEPARATOR);  
        // 在下拉框上创建菜单项  
        MenuItem partItem2 = new MenuItem(partmenu, SWT.CASCADE);  
        partItem2.setText("&Normalized routing overhead");  
        // 在下拉框上创建菜单项 
        MenuItem partItem3 = new MenuItem(partmenu, SWT.CASCADE);  
        partItem3.setText("&Average end-to-end delay"); 
        
// 		MenuItem picture; 
//        picture = new MenuItem(menu, SWT.CASCADE);
//        picture.setText("&作图");
//        // 先在Shell上创建一个下拉框，然后将下拉框添加到File菜单上
//        Menu picmenu;
//        picmenu = new Menu(shell, SWT.DROP_DOWN);
//        picture.setMenu(picmenu);
//        // 在下拉框上创建菜单项Open
//        MenuItem picItem = new MenuItem(picmenu, SWT.PUSH);
//        picItem.setText("&画图界面");
//
//        // 设置help菜单  
//        MenuItem help;
//        help = new MenuItem(menu, SWT.CASCADE);  
//        help.setText("&帮助");  
//        Menu helpmenu;
//        helpmenu = new Menu(shell, SWT.DROP_DOWN);  
//        help.setMenu(helpmenu);
//        MenuItem aboutItem;  
//        aboutItem = new MenuItem(helpmenu, SWT.PUSH);  
//        aboutItem.setText("&关于我们");  
        shell.setMenuBar(menu);
		
//        partItem1.addListener(SWT.Selection, new Listener() 
//		{
//			//为按钮增加事件监听器
//			
//		    public void handleEvent(Event e) 
//		    {
//				// TODO Auto-generated method stub
//		    	new pdr(shell, SWT.None);
//			}});
		try {  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
        }
   catch(ClassNotFoundException eee)
        {  System.out.println(""+eee);
        }
    try {  con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Ad-hoc","sa","wanganxi");	
           sql=con.createStatement();
     //recode="("+ID+","+number+","+"'"+name+"'"+","+"'"+date+"'"+","+sqlgrade+","+netgrade+")";
       //    insert1="INSERT INTO grades  VALUES "+recode;
          //+recode
         //  sql.executeUpdate(insert1);
      
           //show.setText("你插入了:");
    	 //show.append("ID："+ID+" 学号："+number+"  姓名："+name+"  出生："+date+" 数据库成绩"+sqlgrade+" 计算机网络 "+netgrade);
    	 //show.append("\n");
    	 con.close();
         }
   // con.close();
           catch(SQLException e) 
           {  System.out.println(e);
           		//JOptionPane.showMessageDialog(this, "你输入的不正确");
           }
		
//		Label labela;
//		labela = new Label(shell,SWT.CENTER);			
//		//设置版本信息面板内容
//		labela.setBounds(01, 50,480, 20);
//		labela.setText("南京信息工程大学");
//		Label labelb;
//		labelb = new Label(shell,SWT.CENTER);
//		labelb.setBounds(90, 70, 300, 20);
//		labelb.setText("计算机与软件学院");
//		Label labelc;
//		labelc = new Label(shell,SWT.CENTER);
//		labelc.setBounds(80, 90, 300, 20);
//		labelc.setText("指导老师：沈剑");
//		Label labeld;
//		labeld = new Label(shell,SWT.CENTER);
//		labeld.setBounds(40, 110, 409, 20);
//		labeld.setText("小组成员： 王安喜 ;王晨 ;杨雨 ;李雷  ");
//		Label labele;
//		labele = new Label(shell,SWT.CENTER);
//		labele.setBounds(40, 130, 400, 20);
//		labele.setText("版本信息：  2014_09_02_v1");		
//		Button btCancel;
//		btCancel = new Button(shell,SWT.None);
//		btCancel.setBounds(200, 180, 60, 25);
//		btCancel.setText("OK");
//		btCancel.addListener(SWT.MouseDown, new Listener()
//		{
//			@Override
//			public void handleEvent(org.eclipse.swt.widgets.Event arg0) 
//			{
//				// TODO Auto-generated method stub
//				shell.dispose();
//			}});
//		
		shell.open();    //打开主窗体
		while(!shell.isDisposed())
		{  
			//如果主窗体没有关闭则一直循环   
			if(!shell.getDisplay().readAndDispatch())
			{  
				//如果display不忙    
				shell.getDisplay().sleep();    //休眠    
			}    
		}    

	}
	
}