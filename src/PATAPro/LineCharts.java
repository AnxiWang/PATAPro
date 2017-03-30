package PATAPro;

import java.awt.Font;

import javax.swing.JPanel;

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
import org.jfree.ui.ApplicationFrame;

public class LineCharts {
	static double Shuju[]=new double[5];
	private static final long serialVersionUID = 1L;
	static String series1 = "AODV";
    static String series2 = "DSDV";
    static String series3 = "DSR";
    static String type[]={"2","6","10","14","18"};
	public LineCharts(double[] shuju) {
		// TODO Auto-generated constructor stub
		Shuju=shuju;
		createDemoLine();
		
	}
	 public static JPanel createDemoLine() {
		 
		 JFreeChart jfreechart = createChart(createDataset());
		 return new ChartPanel(jfreechart);
	 }
	 
	 public static JFreeChart createChart(DefaultCategoryDataset linedataset) {
		   // 定义图表对象
		   JFreeChart chart = ChartFactory.createLineChart("Package Delivery Ratio", //折线图名称
		     "节点数量", // 横坐标名称
		     "PDR(投包率)", // 纵坐标名称
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
	 public static DefaultCategoryDataset createDataset() {
		   DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		   // 各曲线名称
	   
		   linedataset.addValue(0.988438561052134, series1, type[0]);
		   linedataset.addValue(0.9785426215579038, series1, type[1]);
		   linedataset.addValue(0.9792888806986292, series1, type[2]);
		   linedataset.addValue(0.9748808266491592, series1, type[3]);
		   linedataset.addValue(0.973351668470345, series1, type[4]);
		   
		   linedataset.addValue(0.89, series2, type[0]);
		   linedataset.addValue(0.87, series2, type[1]);
		   linedataset.addValue(0.79, series2, type[2]);
		   linedataset.addValue(0.88, series2, type[3]);
		   linedataset.addValue(0.98, series2, type[4]);
		   
		   linedataset.addValue(0.86, series3, type[0]);
		   linedataset.addValue(0.82, series3, type[1]);
		   linedataset.addValue(0.84, series3, type[2]);
		   linedataset.addValue(0.85, series3, type[3]);
		   linedataset.addValue(0.98, series3, type[4]);
		   
		   return linedataset;
		 }

}
