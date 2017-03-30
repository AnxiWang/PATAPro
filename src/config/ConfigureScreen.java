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
		shell.setLayout(null);         //设置shell的布局方式
		shell.setText("设置");  //设置主窗体的标题
		shell.setSize(400,300);        //设置主窗体的大小 
		shell.addListener(SWT.Close, new Listener() 
{  
            public void handleEvent(Event event) 
{  
                int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO;  
                MessageBox messageBox = new MessageBox(shell, style);  
                messageBox.setText("提示");  
                messageBox.setMessage("确定取消设置？");  
                event.doit = messageBox.open() == SWT.YES;  
            }  
        });  
		Group group;
		group = new Group(shell,SWT.NONE); //创建分组框
		group.setText("默认打开的目录设置"); 
		group.setBounds(20,20,340,60); 
		
		final Text text=new Text(group,SWT.NONE|SWT.BORDER);//带边框
		text.setBounds(10,25,240,20); 

		Button bt;
		bt = new Button(group,SWT.NONE);
		bt.setBounds(260,25,55,20); 
		bt.setText("打开");
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
		btSave.setText("保存设置");
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
							 messageBox.setMessage("设置成功！");   
				             messageBox.open(); 
					shell.dispose();
				}
				else
{
					MessageBox messageBox =   
							   new MessageBox(shell, SWT.OK);   
							 messageBox.setMessage("路径格式无效或为空，请修改！");   
				             messageBox.open(); 
				}
			}});

		Button btCancel;
		btCancel = new Button(shell,SWT.None);
		btCancel.setBounds(200, 200, 60, 25);
		btCancel.setText("取消设置");
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