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
		shell.setLayout(null);         //����shell�Ĳ��ַ�ʽ
		shell.setText("�汾��Ϣ");  //����������ı���
		shell.setSize(490,300);        //����������Ĵ�С 
		Label labela;
		labela = new Label(shell,SWT.CENTER);			
		//���ð汾��Ϣ�������
		labela.setBounds(01, 50,480, 20);
		labela.setText("�Ͼ���Ϣ���̴�ѧ");
		Label labelb;
		labelb = new Label(shell,SWT.CENTER);
		labelb.setBounds(90, 70, 300, 20);
		labelb.setText("����������ѧԺ");
		Label labelc;
		labelc = new Label(shell,SWT.CENTER);
		labelc.setBounds(80, 90, 300, 20);
		labelc.setText("ָ����ʦ����");
		Label labeld;
		labeld = new Label(shell,SWT.CENTER);
		labeld.setBounds(40, 110, 409, 20);
		labeld.setText("С���Ա�� ����ϲ ;���� ;���� ;����  ");
		Label labele;
		labele = new Label(shell,SWT.CENTER);
		labele.setBounds(40, 130, 400, 20);
		labele.setText("�汾��Ϣ��  2014_09_02_v1");		
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