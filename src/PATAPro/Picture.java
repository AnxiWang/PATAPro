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
		shell.setLayout(null);         //����shell�Ĳ��ַ�ʽ
		shell.setText("��ͼ");  //����������ı���
		shell.setSize(520,620);        //����������Ĵ�С 
		// ͨ��shell�����SWT.BAR��ʽֵ������һ���˵���  
		Menu menu = new Menu(shell, SWT.BAR);
        // �ڲ˵����Ļ���֮�ϴ���һ��File�Ĳ˵�
        MenuItem part = new MenuItem(menu, SWT.CASCADE);
        part.setText("&Ҫ��");
        // ����Shell�ϴ���һ��������Ȼ����������ӵ�File�˵���
        Menu partmenu = new Menu(shell, SWT.DROP_DOWN);
        part.setMenu(partmenu);
        // ���������ϴ����˵���
        MenuItem partItem1 = new MenuItem(partmenu, SWT.CASCADE);
        partItem1.setText("&Packet delivery ratio");
        new MenuItem(partmenu, SWT.SEPARATOR);  
        // ���������ϴ����˵���  
        MenuItem partItem2 = new MenuItem(partmenu, SWT.CASCADE);  
        partItem2.setText("&Normalized routing overhead");  
        // ���������ϴ����˵��� 
        MenuItem partItem3 = new MenuItem(partmenu, SWT.CASCADE);  
        partItem3.setText("&Average end-to-end delay"); 
        
// 		MenuItem picture; 
//        picture = new MenuItem(menu, SWT.CASCADE);
//        picture.setText("&��ͼ");
//        // ����Shell�ϴ���һ��������Ȼ����������ӵ�File�˵���
//        Menu picmenu;
//        picmenu = new Menu(shell, SWT.DROP_DOWN);
//        picture.setMenu(picmenu);
//        // ���������ϴ����˵���Open
//        MenuItem picItem = new MenuItem(picmenu, SWT.PUSH);
//        picItem.setText("&��ͼ����");
//
//        // ����help�˵�  
//        MenuItem help;
//        help = new MenuItem(menu, SWT.CASCADE);  
//        help.setText("&����");  
//        Menu helpmenu;
//        helpmenu = new Menu(shell, SWT.DROP_DOWN);  
//        help.setMenu(helpmenu);
//        MenuItem aboutItem;  
//        aboutItem = new MenuItem(helpmenu, SWT.PUSH);  
//        aboutItem.setText("&��������");  
        shell.setMenuBar(menu);
		
//        partItem1.addListener(SWT.Selection, new Listener() 
//		{
//			//Ϊ��ť�����¼�������
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
      
           //show.setText("�������:");
    	 //show.append("ID��"+ID+" ѧ�ţ�"+number+"  ������"+name+"  ������"+date+" ���ݿ�ɼ�"+sqlgrade+" ��������� "+netgrade);
    	 //show.append("\n");
    	 con.close();
         }
   // con.close();
           catch(SQLException e) 
           {  System.out.println(e);
           		//JOptionPane.showMessageDialog(this, "������Ĳ���ȷ");
           }
		
//		Label labela;
//		labela = new Label(shell,SWT.CENTER);			
//		//���ð汾��Ϣ�������
//		labela.setBounds(01, 50,480, 20);
//		labela.setText("�Ͼ���Ϣ���̴�ѧ");
//		Label labelb;
//		labelb = new Label(shell,SWT.CENTER);
//		labelb.setBounds(90, 70, 300, 20);
//		labelb.setText("����������ѧԺ");
//		Label labelc;
//		labelc = new Label(shell,SWT.CENTER);
//		labelc.setBounds(80, 90, 300, 20);
//		labelc.setText("ָ����ʦ����");
//		Label labeld;
//		labeld = new Label(shell,SWT.CENTER);
//		labeld.setBounds(40, 110, 409, 20);
//		labeld.setText("С���Ա�� ����ϲ ;���� ;���� ;����  ");
//		Label labele;
//		labele = new Label(shell,SWT.CENTER);
//		labele.setBounds(40, 130, 400, 20);
//		labele.setText("�汾��Ϣ��  2014_09_02_v1");		
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
		shell.open();    //��������
		while(!shell.isDisposed())
		{  
			//���������û�йر���һֱѭ��   
			if(!shell.getDisplay().readAndDispatch())
			{  
				//���display��æ    
				shell.getDisplay().sleep();    //����    
			}    
		}    

	}
	
}