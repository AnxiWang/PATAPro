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
//导入所需要的包
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
			//初始化
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
			//为shell增加监听器

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
		shell.setText("Ad-hoc路由协议性能分析软件");
		java.net.URL imgURL=MainUI.class.getResource("/images/logo1.png");
		Image image = new Image(null,"images/logo1.png");
		
		shell.setImage(image);
		// 通过shell对象和SWT.BAR样式值来创建一个菜单条  
		Menu menu;
        menu = new Menu(shell, SWT.BAR);
        // 在菜单条的基础之上创建一个File的菜单
        MenuItem file;
        file = new MenuItem(menu, SWT.CASCADE);
        file.setText("&文件");
        // 先在Shell上创建一个下拉框，然后将下拉框添加到File菜单上
        Menu filemenu;
        filemenu = new Menu(shell, SWT.DROP_DOWN);
        file.setMenu(filemenu);
        // 在下拉框上创建菜单项Open
        final MenuItem openItem = new MenuItem(filemenu, SWT.CASCADE);
        openItem.setText("&打开");
        new MenuItem(filemenu, SWT.SEPARATOR);  
        // 在下拉框上创建菜单项Exit  
        MenuItem exitItem;
        exitItem = new MenuItem(filemenu, SWT.PUSH);  
        exitItem.setText("&退出");  
        
 		MenuItem picture; 
        picture = new MenuItem(menu, SWT.CASCADE);
        picture.setText("&作图");
        // 先在Shell上创建一个下拉框，然后将下拉框添加到File菜单上
        Menu picmenu;
        picmenu = new Menu(shell, SWT.DROP_DOWN);
        picture.setMenu(picmenu);
        // 在下拉框上创建菜单项Open
        MenuItem partItem1 = new MenuItem(picmenu, SWT.CASCADE);
        partItem1.setText("&数据包投递率");
        new MenuItem(picmenu, SWT.SEPARATOR);  
        // 在下拉框上创建菜单项  
        MenuItem partItem2 = new MenuItem(picmenu, SWT.CASCADE);  
        partItem2.setText("&归一化路由开销"); 
        new MenuItem(picmenu, SWT.SEPARATOR); 
        // 在下拉框上创建菜单项 
        MenuItem partItem3 = new MenuItem(picmenu, SWT.CASCADE);  
        partItem3.setText("&平均端到端时延");

        // 设置help菜单  
        MenuItem help;
        help = new MenuItem(menu, SWT.CASCADE);  
        help.setText("&帮助");  
        Menu helpmenu;
        helpmenu = new Menu(shell, SWT.DROP_DOWN);  
        help.setMenu(helpmenu);
        MenuItem aboutItem;  
        aboutItem = new MenuItem(helpmenu, SWT.PUSH);  
        aboutItem.setText("&关于我们");  
        
  
        // 将菜单条添加到shell上  
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
        
        label1.setText("分析结果:");
//       label1.setText("Packet delivery ratio : ");
//       label2.setText("Normalized routing overhead :");
//       label3.setText("Average end-to-end delay :");
        label4.setText("南京信息工程大学");
//       label5.setText("云计算团队   ");
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
        btOpen.setText("打开文件");
        Button btAnalyze;
		btAnalyze = new Button(shell,SWT.None);
		btAnalyze.setBounds(200, 245, 100, 35);
		btAnalyze.setText("开始分析!");
		Button btQuit;
		btQuit = new Button(shell,SWT.None);
		btQuit.setBounds(205,510, 90, 25);
		btQuit.setText("退出");
		//---------------------------------------------------------------------------
		
		openItem.addListener(SWT.Selection, new Listener()
		{
			//为下拉菜单栏增加监听器

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
			//为下拉菜单栏增加监听器
		    public void handleEvent(Event e) 
		    {
				// TODO Auto-generated method stub
				shell.dispose();
			}});
		//---------------------------------------------------------------------------
	
		partItem1.addListener(SWT.Selection, new Listener() 
		{
			//为按钮增加事件监听器
			
		    public void handleEvent(Event e) 
		    {
				// TODO Auto-generated method stub
		    	new pdr(shell, SWT.None);
			}});
		partItem2.addListener(SWT.Selection, new Listener() 
		{
			//为按钮增加事件监听器
			
		    public void handleEvent(Event e) 
		    {
				// TODO Auto-generated method stub
		    	new overhead(shell, SWT.None);
			}});
		partItem3.addListener(SWT.Selection, new Listener() 
		{
			//为按钮增加事件监听器
			
		    public void handleEvent(Event e) 
		    {
				// TODO Auto-generated method stub
		    	new delay(shell, SWT.None);
			}});
		aboutItem.addListener(SWT.Selection, new Listener() 
		{
			//为按钮增加事件监听器
			
		    public void handleEvent(Event e) 
		    {
				// TODO Auto-generated method stub
		    	new AboutWindow(shell, SWT.None);
			}});
		//---------------------------------------------------------------------------
		
		btQuit.addListener(SWT.MouseDown, new Listener()
		{
			@Override
			//为按钮增加事件监听器

			public void handleEvent(org.eclipse.swt.widgets.Event arg0) 
			{
				// TODO Auto-generated method stub
				shell.dispose();
			}});
		//---------------------------------------------------------------------------

		btOpen.addListener(SWT.MouseDown, new Listener()
		{
			@Override
			//为按钮增加事件监听器

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
			//为按钮增加事件监听器
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
							resultText.setText("分析中...\n");
							String result = new Analysis().analyseData(path);
							resultText.append(result);
							resultText.append("\n完成!");
							new Adddata(result);
						}else
						{
							MessageBox messageBox =   
									   new MessageBox(shell, SWT.OK);   
									 messageBox.setMessage("打开的文件不是以.tr结尾的，请重新打开！");   
						             messageBox.open(); 
						}
					}
					else
					{
						MessageBox messageBox =   
								   new MessageBox(shell, SWT.OK);   
								 messageBox.setMessage("你打开的文件不存在！");   
					             messageBox.open(); 
					}
				}
				else
				{
					MessageBox messageBox =   
							   new MessageBox(shell, SWT.OK);   
							 messageBox.setMessage("请选择打开的文件！");   
				             messageBox.open(); 
			}
		}});
	}
}