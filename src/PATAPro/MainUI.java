package PATAPro;
import java.io.File;

import javax.swing.ImageIcon;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import config.DirConfig;
//��������Ҫ�İ�
//---------------------------------------------------------------------------

public class MainUI 
{

	protected Shell shell;
	DirConfig dirConfig = new DirConfig();
	String path = null;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try 
		{
			MainUI window = new MainUI();
			//��ʼ��
			window.open();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
//---------------------------------------------------------------------------

	public void open() 
	{
		Display display = Display.getDefault();
		createContents();
		shell.open();
		
		shell.layout();
		shell.addDisposeListener(new DisposeListener()
		{
			@Override
			//Ϊshell���Ӽ�����

			public void widgetDisposed(DisposeEvent arg0)
			{
				Display.getDefault().dispose();
				System.exit(0);				
			}				
		});
		
		while (!shell.isDisposed()) 
		{
			if (!display.readAndDispatch()) 
			{
				display.sleep();
			}
			
		}
		
	}
	/**
	 * Create contents of the window.
	 */
	protected void createContents() 
	{
		shell = new Shell();
		shell.setSize(520, 620);
		shell.setText("Ad-hoc·��Э�����ܷ������");
		java.net.URL imgURL=MainUI.class.getResource("/images/logo1.png");
		Image image = new Image(null,"images/logo1.png");
		
		shell.setImage(image);
		// ͨ��shell�����SWT.BAR��ʽֵ������һ���˵���  
		Menu menu;
        menu = new Menu(shell, SWT.BAR);
        // �ڲ˵����Ļ���֮�ϴ���һ��File�Ĳ˵�
        MenuItem file;
        file = new MenuItem(menu, SWT.CASCADE);
        file.setText("&�ļ�");
        // ����Shell�ϴ���һ��������Ȼ����������ӵ�File�˵���
        Menu filemenu;
        filemenu = new Menu(shell, SWT.DROP_DOWN);
        file.setMenu(filemenu);
        // ���������ϴ����˵���Open
        final MenuItem openItem = new MenuItem(filemenu, SWT.CASCADE);
        openItem.setText("&��");
        new MenuItem(filemenu, SWT.SEPARATOR);  
        // ���������ϴ����˵���Exit  
        MenuItem exitItem;
        exitItem = new MenuItem(filemenu, SWT.PUSH);  
        exitItem.setText("&�˳�");  
        
 		MenuItem picture; 
        picture = new MenuItem(menu, SWT.CASCADE);
        picture.setText("&��ͼ");
        // ����Shell�ϴ���һ��������Ȼ����������ӵ�File�˵���
        Menu picmenu;
        picmenu = new Menu(shell, SWT.DROP_DOWN);
        picture.setMenu(picmenu);
        // ���������ϴ����˵���Open
        MenuItem partItem1 = new MenuItem(picmenu, SWT.CASCADE);
        partItem1.setText("&���ݰ�Ͷ����");
        new MenuItem(picmenu, SWT.SEPARATOR);  
        // ���������ϴ����˵���  
        MenuItem partItem2 = new MenuItem(picmenu, SWT.CASCADE);  
        partItem2.setText("&��һ��·�ɿ���"); 
        new MenuItem(picmenu, SWT.SEPARATOR); 
        // ���������ϴ����˵��� 
        MenuItem partItem3 = new MenuItem(picmenu, SWT.CASCADE);  
        partItem3.setText("&ƽ���˵���ʱ��");

        // ����help�˵�  
        MenuItem help;
        help = new MenuItem(menu, SWT.CASCADE);  
        help.setText("&����");  
        Menu helpmenu;
        helpmenu = new Menu(shell, SWT.DROP_DOWN);  
        help.setMenu(helpmenu);
        MenuItem aboutItem;  
        aboutItem = new MenuItem(helpmenu, SWT.PUSH);  
        aboutItem.setText("&��������");  
        
  
        // ���˵�����ӵ�shell��  
        shell.setMenuBar(menu);  
        Label label1;
        Label label2;
        Label label3;
        Label label4;
        Label label5;
        label1 = new Label(shell,SWT.None);
        //       label2 = new Label(shell,SWT.None);
        //       label3 = new Label(shell,SWT.None);
        label4 = new Label(shell,SWT.None);
        label5 = new Label(shell,SWT.CENTER);
    
        Label labelImage;
        labelImage = new Label(shell,SWT.None);
        labelImage.setBounds(55, 5, 400, 150);
        labelImage.setImage(new Image(Display.getDefault(), "images/logo.png"));
        
        label1.setText("�������:");
//       label1.setText("Packet delivery ratio : ");
//       label2.setText("Normalized routing overhead :");
//       label3.setText("Average end-to-end delay :");
        label4.setText("�Ͼ���Ϣ���̴�ѧ");
//       label5.setText("�Ƽ����Ŷ�   ");
        label1.setBounds(30, 300, 50, 20);
//       label2.setBounds(50, 320, 200, 20);
//       label3.setBounds(50, 390, 160, 20);
//       label4.setBounds(230, 80, 200, 20);
//       label5.setBounds(230, 110, 200, 20);
        final Text filePath = new Text(shell,SWT.NONE|SWT.BORDER);
        final Text resultText = new Text(shell,SWT.NONE|SWT.BORDER|SWT.MULTI|SWT.V_SCROLL);
//       Text text2 = new Text(shell,SWT.NONE|SWT.BORDER);
//       Text text3 = new Text(shell,SWT.NONE|SWT.BORDER);
        filePath.setBounds(65,170,280,20);
        resultText.setBounds(40,330,400,150);
        resultText.setEditable(false);
        
        Button btOpen;
        btOpen = new Button(shell,SWT.None);
        btOpen.setBounds(350, 165, 90, 25);
        btOpen.setText("���ļ�");
        Button btAnalyze;
		btAnalyze = new Button(shell,SWT.None);
		btAnalyze.setBounds(200, 245, 100, 35);
		btAnalyze.setText("��ʼ����!");
		Button btQuit;
		btQuit = new Button(shell,SWT.None);
		btQuit.setBounds(205,510, 90, 25);
		btQuit.setText("�˳�");
		//---------------------------------------------------------------------------
		
		openItem.addListener(SWT.Selection, new Listener()
		{
			//Ϊ�����˵������Ӽ�����

		    public void handleEvent(Event e) 
		    {
		    	String dir;
		    	dir = dirConfig.fileDig(shell);
				if(dir!=null)
				filePath.setText(dir);
		    }
		});
		//---------------------------------------------------------------------------
		
		exitItem.addListener(SWT.Selection, new Listener()
		{
			//Ϊ�����˵������Ӽ�����
		    public void handleEvent(Event e) 
		    {
				// TODO Auto-generated method stub
				shell.dispose();
			}});
		//---------------------------------------------------------------------------
	
		partItem1.addListener(SWT.Selection, new Listener() 
		{
			//Ϊ��ť�����¼�������
			
		    public void handleEvent(Event e) 
		    {
				// TODO Auto-generated method stub
		    	new pdr(shell, SWT.None);
			}});
		partItem2.addListener(SWT.Selection, new Listener() 
		{
			//Ϊ��ť�����¼�������
			
		    public void handleEvent(Event e) 
		    {
				// TODO Auto-generated method stub
		    	new overhead(shell, SWT.None);
			}});
		partItem3.addListener(SWT.Selection, new Listener() 
		{
			//Ϊ��ť�����¼�������
			
		    public void handleEvent(Event e) 
		    {
				// TODO Auto-generated method stub
		    	new delay(shell, SWT.None);
			}});
		aboutItem.addListener(SWT.Selection, new Listener() 
		{
			//Ϊ��ť�����¼�������
			
		    public void handleEvent(Event e) 
		    {
				// TODO Auto-generated method stub
		    	new AboutWindow(shell, SWT.None);
			}});
		//---------------------------------------------------------------------------
		
		btQuit.addListener(SWT.MouseDown, new Listener()
		{
			@Override
			//Ϊ��ť�����¼�������

			public void handleEvent(org.eclipse.swt.widgets.Event arg0) 
			{
				// TODO Auto-generated method stub
				shell.dispose();
			}});
		//---------------------------------------------------------------------------

		btOpen.addListener(SWT.MouseDown, new Listener()
		{
			@Override
			//Ϊ��ť�����¼�������

			public void handleEvent(org.eclipse.swt.widgets.Event arg0) 
			{
				// TODO Auto-generated method stub
				String dir;
				dir = dirConfig.fileDig(shell);
				if(dir!=null)
				filePath.setText(dir);
			}});
		
		
//---------------------------------------------------------------------------
		
		btAnalyze.addListener(SWT.MouseDown, new Listener()
		{
			@Override
			//Ϊ��ť�����¼�������
			public void handleEvent(org.eclipse.swt.widgets.Event arg0) 
			{
				// TODO Auto-generated method stub
				path = filePath.getText();
				if(path.length()>=1)
				{
					File f = new File(path);
					if(f.exists())
					{
						String[] s = path.split("\\.");
						if(s.length ==2 && s[1].equals("tr"))
						{
							resultText.setText("������...\n");
							String result = new Analysis().analyseData(path);
							resultText.append(result);
							resultText.append("\n���!");
							new Adddata(result);
						}else
						{
							MessageBox messageBox =   
									   new MessageBox(shell, SWT.OK);   
									 messageBox.setMessage("�򿪵��ļ�������.tr��β�ģ������´򿪣�");   
						             messageBox.open(); 
						}
					}
					else
					{
						MessageBox messageBox =   
								   new MessageBox(shell, SWT.OK);   
								 messageBox.setMessage("��򿪵��ļ������ڣ�");   
					             messageBox.open(); 
					}
				}
				else
				{
					MessageBox messageBox =   
							   new MessageBox(shell, SWT.OK);   
							 messageBox.setMessage("��ѡ��򿪵��ļ���");   
				             messageBox.open(); 
			}
		}});
	}
}