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
		shell.setLayout(null);         //����shell�Ĳ��ַ�ʽ
		shell.setText("���ݰ�Ͷ����");  //����������ı���
		shell.setSize(520,300);        //����������Ĵ�С 
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
        partItem1.setText("&�ڵ����");
        new MenuItem(partmenu, SWT.SEPARATOR);  
        // ���������ϴ����˵���  
        MenuItem partItem2 = new MenuItem(partmenu, SWT.CASCADE);  
        partItem2.setText("&ͣ��ʱ��"); 
        new MenuItem(partmenu, SWT.SEPARATOR);
        // ���������ϴ����˵��� 
        MenuItem partItem3 = new MenuItem(partmenu, SWT.CASCADE);  
        partItem3.setText("&�Ự��"); 
        new MenuItem(partmenu, SWT.SEPARATOR);
     // ���������ϴ����˵��� 
        MenuItem partItem4 = new MenuItem(partmenu, SWT.CASCADE);  
        partItem4.setText("&���������"); 
  
        shell.setMenuBar(menu);
		
        partItem1.addListener(SWT.Selection, new Listener() 
		{
			//Ϊ��ť�����¼�������
			
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
	protected void LineCharts() {
		// TODO Auto-generated method stub
		
	}
	
}