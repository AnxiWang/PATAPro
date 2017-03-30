package figure;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.StringUtils;

import SQL.AODVdelayRATEBaseDao;
import SQL.DSDVdelayRATEBaseDao;
import SQL.DSRdelayRATEBaseDao;
public class DelayRateLineCharts extends ApplicationFrame {
/**
  * 
  */
    static String series1 = "AODV";
    static String series2 = "DSDV";
    static String series3 = "DSR";
    private static final long serialVersionUID = 1L;
    static double []aodv=new double[110];
    static double []dsdv=new double[110];
    static double []dsr=new double[110];
    static String type[]={"1","2","4","8","16"};
    AODVdelayRATEBaseDao aodvbasedao=new AODVdelayRATEBaseDao();
    DSDVdelayRATEBaseDao dsdvbasedao=new DSDVdelayRATEBaseDao();
    DSRdelayRATEBaseDao dsrbasedao=new DSRdelayRATEBaseDao();
    	public DelayRateLineCharts(String s)  {
    		super(s);
    		List<Double> aodvlist= aodvbasedao.getList();
    	    for(int i=0;i<aodvlist.size();i++)
    	    {
    	    	double a=aodvlist.get(i);
    	    	aodv[i]=a;
    	    	
    	    }
    	    List<Double> dsdvlist= dsdvbasedao.getList();
    	    for(int i=0;i<dsdvlist.size();i++)
    	    {
    	    	double a=dsdvlist.get(i);
    	    	dsdv[i]=a;
    	    	
    	    }
    	    List<Double> dsrlist= dsrbasedao.getList();
    	    for(int i=0;i<dsrlist.size();i++)
    	    {
    	    	double a=dsrlist.get(i);
    	    	dsr[i]=a;
    	    	
    	    }
    		setContentPane(createDemoLine());   
    		
    	}
    	// 生成显示图表的面板

    	public static JPanel createDemoLine() {
	 
    		JFreeChart jfreechart = createChart(createDataset());
    		return new ChartPanel(jfreechart);
    	}
    	// 生成图表主对象JFreeChart
    	public static JFreeChart createChart(DefaultCategoryDataset linedataset) {
    		// 定义图表对象
	  
    		JFreeChart chart = ChartFactory.createLineChart("Average end-to-end delay", //折线图名称
    				"分组输出率", // 横坐标名称
    				"AED(平均端到端时延)", // 纵坐标名称
    				linedataset, // 数据
    				PlotOrientation.VERTICAL, // 水平显示图像
    				true, // include legend
    				true, // tooltips
    				false // urls
    				);
   
    		Font titleFont = new Font("黑体", Font.BOLD, 20); 
    		TextTitle textTitle = chart.getTitle(); 
    		textTitle.setFont(titleFont);// 为标题设置上字体 
	  
    		Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
    		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot(); 
    		CategoryAxis domainAxis = categoryplot.getDomainAxis();
    		domainAxis.setLabelFont(labelFont);// X轴的标题文字字体
    		domainAxis.setTickLabelFont(labelFont);//X轴坐标上数值字体
	
    		Font yFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
    		ValueAxis ydomainAxis = categoryplot.getRangeAxis();
    		ydomainAxis.setLabelFont(yFont);// y轴的标题文字字体
    		ydomainAxis.setTickLabelFont(yFont);//y轴坐标上数值字体
	  
    		Font LegendFont = new Font("楷体", Font.PLAIN, 18); 
    		LegendTitle legend = chart.getLegend(0); 
    		legend.setItemFont(LegendFont);// 为图例说明设置字体 
   
    		CategoryPlot plot = chart.getCategoryPlot();
    		plot.setRangeGridlinesVisible(true); //是否显示格子线
    		plot.setBackgroundAlpha(0.3f); //设置背景透明度
    		NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
   rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
   rangeAxis.setAutoRangeIncludesZero(false);
   rangeAxis.setUpperMargin(0.20);
   rangeAxis.setLabelAngle(Math.PI / 2.0);
   return chart;
 }
// 生成数据
 public static DefaultCategoryDataset createDataset() {
   DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
   // 各曲线名称

   linedataset.addValue(aodv[0], series1, type[0]);
   linedataset.addValue(aodv[1], series1, type[1]);
   linedataset.addValue(aodv[2], series1, type[2]);
   linedataset.addValue(aodv[3], series1, type[3]);
   linedataset.addValue(aodv[4], series1, type[4]);
   
   linedataset.addValue(dsdv[0], series2, type[0]);
   linedataset.addValue(dsdv[1], series2, type[1]);
   linedataset.addValue(dsdv[2], series2, type[2]);
   linedataset.addValue(dsdv[3], series2, type[3]);
   linedataset.addValue(dsdv[4], series2, type[4]);
   
   linedataset.addValue(dsr[0], series3, type[0]);
   linedataset.addValue(dsr[1], series3, type[1]);
   linedataset.addValue(dsr[2], series3, type[2]);
   linedataset.addValue(dsr[3], series3, type[3]);
   linedataset.addValue(dsr[4], series3, type[4]);
   
   return linedataset;
 }
}
