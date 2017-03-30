package PATAPro;

import java.awt.Font;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import javax.swing.JPanel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
//---------------------------------------------------------------------------
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

public class pdr
{
	Connection con;
    Statement sql; 
    //static double shuju[];
    static double shu;
    static String series1 = "AODV";
    static String series2 = "DSDV";
    static String series3 = "DSR";
    static double []shuju=new double[110];
    static String type[]={"2","6","10","14","18"};
	public pdr(Shell parent, int style)
	{
		Shell shell = new Shell(parent);
		shell.setLayout(null);         //设置shell的布局方式
		shell.setText("数据包投递率");  //设置主窗体的标题
		shell.setSize(520,300);        //设置主窗体的大小 
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
        partItem1.setText("&节点个数");
        new MenuItem(partmenu, SWT.SEPARATOR);  
        // 在下拉框上创建菜单项  
        MenuItem partItem2 = new MenuItem(partmenu, SWT.CASCADE);  
        partItem2.setText("&停顿时间"); 
        new MenuItem(partmenu, SWT.SEPARATOR);
        // 在下拉框上创建菜单项 
        MenuItem partItem3 = new MenuItem(partmenu, SWT.CASCADE);  
        partItem3.setText("&会话数"); 
        new MenuItem(partmenu, SWT.SEPARATOR);
     // 在下拉框上创建菜单项 
        MenuItem partItem4 = new MenuItem(partmenu, SWT.CASCADE);  
        partItem4.setText("&分组输出率"); 
  
        shell.setMenuBar(menu);
		
        partItem1.addListener(SWT.Selection, new Listener() 
		{
			//为按钮增加事件监听器
			
		    @SuppressWarnings("null")
			public void handleEvent(Event e) 
		    {
		    	double shuju[] = new double[5];
				// TODO Auto-generated method stub   	
		    	 BaseDao baseDao = new BaseDao();
		    	 List<Double> list=  baseDao.getList();
		    	  for(int i=0;i<list.size();i++)    {   
		    		  
		              double a=list.get(i);  
		              shuju[i]=a;
		              //System.out.println(shuju[i]);
		    	  } 
		    	 new LineCharts(shuju);
//		    	System.out.println(shuju[0]);
//		    	System.out.println(shuju[2]);
		    }
		    
			
			});
        
        
        
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
	protected void LineCharts() {
		// TODO Auto-generated method stub
		
	}
	
}