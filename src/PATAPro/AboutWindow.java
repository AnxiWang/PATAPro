package PATAPro;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import config.DirConfig;
//---------------------------------------------------------------------------

public class AboutWindow
{

	public AboutWindow(final Shell parent, final int style)
{
		final Shell shell = new Shell(parent);
		shell.setLayout(null);         //设置shell的布局方式
		shell.setText("版本信息");  //设置主窗体的标题
		shell.setSize(490,300);        //设置主窗体的大小 
		Label labela;
		labela = new Label(shell,SWT.CENTER);			
		//设置版本信息面板内容
		labela.setBounds(01, 50,480, 20);
		labela.setText("南京信息工程大学");
		Label labelb;
		labelb = new Label(shell,SWT.CENTER);
		labelb.setBounds(90, 70, 300, 20);
		labelb.setText("计算机与软件学院");
		Label labelc;
		labelc = new Label(shell,SWT.CENTER);
		labelc.setBounds(80, 90, 300, 20);
		labelc.setText("指导老师：沈剑");
		Label labeld;
		labeld = new Label(shell,SWT.CENTER);
		labeld.setBounds(40, 110, 409, 20);
		labeld.setText("小组成员： 王安喜 ;王晨 ;杨雨 ;李雷  ");
		Label labele;
		labele = new Label(shell,SWT.CENTER);
		labele.setBounds(40, 130, 400, 20);
		labele.setText("版本信息：  2014_09_02_v1");		
		Button btCancel;
		btCancel = new Button(shell,SWT.None);
		btCancel.setBounds(200, 180, 60, 25);
		btCancel.setText("OK");
		btCancel.addListener(SWT.MouseDown, new Listener()
		{
			@Override
			public void handleEvent(org.eclipse.swt.widgets.Event arg0) 
			{
				// TODO Auto-generated method stub
				shell.dispose();
			}});
		
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