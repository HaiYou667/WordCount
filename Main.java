import java.util.Scanner;

import javax.swing.JFrame;


public class Main extends JFrame{
    public static void main(String[] args) {
    	
    	System.out.println("\n********************功能 菜单*********************");
    	System.out.println("* 菜单选项：\t\t\t\t\t*");
    	System.out.println("*  选项1-----统计词频个数并显示结果\t\t*");
    	System.out.println("*  选项2-----统计指定单词词频个数\t\t\t*");
    	System.out.println("*  选项3-----查询K个出现频次最高的单词且显示柱状图*");
    	System.out.println("*  选项4-----退出\t\t\t\t*");
    	System.out.println("*************************************************\n");
    	
         Count1 c1=new Count1();
         Count2 c2=new Count2();
         Histogram c3=new Histogram();
    	
    	Scanner sc = new Scanner(System.in); 
        System.out.println("请输入选项:"); 
        //int opt = sc.nextInt();
        String opt=sc.next();//用户的输入可能是各种类型的
       
        
    	switch(opt){
    	case "1":
    		c1.wcount();
    		main(null);
    		break;
    	case "2": 
    		c2.wcount();
    		main(null);
    		break;
    	case "3": 
    		//c3.wcount();
    		new Main();//调用构造方法,获取高频词汇个数,显示柱状图
    		main(null);
    		break;
    	case "4": 
    		System.out.println("-----------感谢使用！-----------");
    		break;
    	default: 
    		System.out.println("输入有误，请重新输入！");
    		main(null);
    		break;
    		
    	}
    	
    }
   
    /**
    * 初始化窗体
    */
    public Main(){
        
        this.setSize(1000,800);//设置窗体大小
        
        this.add(new HighfrequencyWordsAndHistogram().getChartPanel());//将报表面板添加到窗体中
        
        this.setResizable(true);//设置窗体大小不可变
        
        this.setLocationRelativeTo(null);//设置窗体相对于屏幕居中
        
        this.setVisible(true);//设置窗体可见
    }
}
