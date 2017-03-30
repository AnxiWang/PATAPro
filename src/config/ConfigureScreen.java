package config;
import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import PATAPro.XMLUtil;
//---------------------------------------------------------------------------

public class ConfigureScreen{

	public ConfigureScreen(final Shell parent, final int style)
{
		final DirConfig dirConfig = new DirConfig();
		final Shell shell = new Shell(parent);
		shell.setLayout(null);         //����shell�Ĳ��ַ�ʽ
		shell.setText("����");  //����������ı���
		shell.setSize(400,300);        //����������Ĵ�С 
		shell.addListener(SWT.Close, new Listener() 
{  
            public void handleEvent(Event event) 
{  
                int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO;  
                MessageBox messageBox = new MessageBox(shell, style);  
                messageBox.setText("��ʾ");  
                messageBox.setMessage("ȷ��ȡ�����ã�");  
                event.doit = messageBox.open() == SWT.YES;  
            }  
        });  
		Group group;
		group = new Group(shell,SWT.NONE); //���������
		group.setText("Ĭ�ϴ򿪵�Ŀ¼����"); 
		group.setBounds(20,20,340,60); 
		
		final Text text=new Text(group,SWT.NONE|SWT.BORDER);//���߿�
		text.setBounds(10,25,240,20); 

		Button bt;
		bt = new Button(group,SWT.NONE);
		bt.setBounds(260,25,55,20); 
		bt.setText("��");
		bt.addListener(SWT.MouseDown, new Listener()
{
			@Override
			public void handleEvent(org.eclipse.swt.widgets.Event arg0) 
{
				// TODO Auto-generated method stub
				String dir = dirConfig.folderDig(shell);
				if(dir!=null)
				text.setText(dir);
			}});
		
Button btSave ;
		btSave = new Button(shell,SWT.None);
		btSave.setBounds(110, 200, 60, 25);
		btSave.setText("��������");
		btSave.addListener(SWT.MouseDown, new Listener()
{
			@Override
			public void handleEvent(org.eclipse.swt.widgets.Event arg0) 
{
				// TODO Auto-generated method stub
				if(text.getText()!=null&&(new File(text.getText()).isDirectory()))
{
					dirConfig.setPath(text.getText());
					System.out.println(dirConfig.getPath());
					XMLUtil xml = new XMLUtil();
					xml.updateXML("config/configure.xml", dirConfig.getPath());
					MessageBox messageBox =   
							   new MessageBox(shell, SWT.OK);   
							 messageBox.setMessage("���óɹ���");   
				             messageBox.open(); 
					shell.dispose();
				}
				else
{
					MessageBox messageBox =   
							   new MessageBox(shell, SWT.OK);   
							 messageBox.setMessage("·����ʽ��Ч��Ϊ�գ����޸ģ�");   
				             messageBox.open(); 
				}
			}});

		Button btCancel;
		btCancel = new Button(shell,SWT.None);
		btCancel.setBounds(200, 200, 60, 25);
		btCancel.setText("ȡ������");
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