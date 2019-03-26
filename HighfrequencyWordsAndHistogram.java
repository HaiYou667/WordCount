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
 *��ѯָ���������ʲ�����״ͼ��ʾ
 */
public class HighfrequencyWordsAndHistogram {

    /*
     * ��ȡ����
     */
    private static CategoryDataset getDataset(){
    	Count1 c=new Count1();
		c.readandprocessfile();//���ö��ļ������ļ�����
		
		List<Map.Entry<String, Integer>> ordlist = new ArrayList<Map.Entry<String,Integer>>(c.map.entrySet());
		// ��sort����������
		Collections.sort(ordlist,c.valcom);
		
		
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();//�������ݼ�����
        
        Scanner sc = new Scanner(System.in); 
	    System.out.println("������Ҫ�鿴����ߴ�Ƶ�ĸ���:"); 
		int k = sc.nextInt();//k��ȡ��ѯ����
		
		if(k>0&&k<=ordlist.size()){
	        for (Map.Entry<String, Integer> entry : ordlist) {
	        	
				dataset.setValue(entry.getValue(), entry.getKey(), entry.getKey());//����ֵ��X�ᣬY�� 			
				
				if(--k==0)
					break;//���k==0z �����������Ĵ�Ƶ
	        }
		}else{
			System.out.println("�����������������룡");
		}

        return dataset;
    }

    //����������壬���ڴ���Ѿ����õ�ͼ�α���
    private ChartPanel myframe;

    //�ڹ��췽���н�ͼ�α����ʼ��
    public HighfrequencyWordsAndHistogram(){
    	
        //��ȡ����
        CategoryDataset dataset = getDataset();
        
        //����ͼ��ʵ�����
        JFreeChart chart=ChartFactory.createBarChart3D(//����ģʽ
                "Ӣ�Ĵ�Ƶͳ�Ʒ���", //��״ͼ����
                "��Ƶ����", //X���ǩ
                "���ִ���",  //Y���ǩ
                dataset, //���ݼ�
                PlotOrientation.VERTICAL, //��ֱ��ʾͼ��
                true,  //�Ƿ�����ͼ��
                false, //�Ƿ�������ʾ����
                true);//�Ƿ�����URL����
        
        CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������
        
        //��ȡX��
        CategoryAxis domainAxis=plot.getDomainAxis();
        domainAxis.setLabelFont(new Font("����",Font.BOLD,14));//����X��ı��������
        domainAxis.setTickLabelFont(new Font("����",Font.BOLD,15));//����X�������ϵ�����
        
        //��ȡY��
        ValueAxis rangeAxis=plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));//����Y�������ϵı�������
        
        //����ͼ����������ʽ
        chart.getLegend().setItemFont(new Font("����",Font.BOLD ,15));
        //����ͼ�εı���
        chart.getTitle().setFont(new Font("����",Font.BOLD ,20));

        myframe =new ChartPanel(chart,true);//���Ѿ����õ�ͼ�α����ŵ������
        
    }

    //����һ�����������ڻ�ȡ�����ͼ�ε����(��װ�����ؾ���ʵ��)
    public ChartPanel getChartPanel(){
        return myframe;
    }
}