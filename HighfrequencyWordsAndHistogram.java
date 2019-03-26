import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *查询指定个数单词并以柱状图显示
 */
public class HighfrequencyWordsAndHistogram {

    /*
     * 获取数据
     */
    private static CategoryDataset getDataset(){
    	Count1 c=new Count1();
		c.readandprocessfile();//调用读文件处理文件方法
		
		List<Map.Entry<String, Integer>> ordlist = new ArrayList<Map.Entry<String,Integer>>(c.map.entrySet());
		// 用sort函数来排序
		Collections.sort(ordlist,c.valcom);
		
		
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();//创建数据集对象
        
        Scanner sc = new Scanner(System.in); 
	    System.out.println("请输入要查看的最高词频的个数:"); 
		int k = sc.nextInt();//k获取查询个数
		
		if(k>0&&k<=ordlist.size()){
	        for (Map.Entry<String, Integer> entry : ordlist) {
	        	
				dataset.setValue(entry.getValue(), entry.getKey(), entry.getKey());//数据值，X轴，Y轴 			
				
				if(--k==0)
					break;//如果k==0z 则不再输出后面的词频
	        }
		}else{
			System.out.println("输入有误！请重新输入！");
		}

        return dataset;
    }

    //构建容器面板，用于存放已经画好的图形报表
    private ChartPanel myframe;

    //在构造方法中将图形报表初始化
    public HighfrequencyWordsAndHistogram(){
    	
        //获取数据
        CategoryDataset dataset = getDataset();
        
        //创建图形实体对象
        JFreeChart chart=ChartFactory.createBarChart3D(//工厂模式
                "英文词频统计分析", //柱状图标题
                "词频种类", //X轴标签
                "出现次数",  //Y轴标签
                dataset, //数据集
                PlotOrientation.VERTICAL, //垂直显示图形
                true,  //是否生成图样
                false, //是否生成提示工具
                true);//是否生成URL链接
        
        CategoryPlot plot=chart.getCategoryPlot();//获取图形区域对象
        
        //获取X轴
        CategoryAxis domainAxis=plot.getDomainAxis();
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));//设置X轴的标题的字体
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,15));//设置X轴坐标上的字体
        
        //获取Y轴
        ValueAxis rangeAxis=plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));//设置Y轴坐标上的标题字体
        
        //设置图样的文字样式
        chart.getLegend().setItemFont(new Font("黑体",Font.BOLD ,15));
        //设置图形的标题
        chart.getTitle().setFont(new Font("宋体",Font.BOLD ,20));

        myframe =new ChartPanel(chart,true);//将已经画好的图形报表存放到面板中
        
    }

    //构建一个方法，用于获取存放了图形的面板(封装：隐藏具体实现)
    public ChartPanel getChartPanel(){
        return myframe;
    }
}