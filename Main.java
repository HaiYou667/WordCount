import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
    	
    	System.out.println("\n********************功能 菜单*********************");
    	System.out.println("* 菜单选项：\t\t\t\t\t*");
    	System.out.println("*  选项1-----统计词频个数并显示结果\t\t*");
    	System.out.println("*  选项2-----统计指定单词词频个数\t\t\t*");
    	System.out.println("*  选项3-----查询K个出现频次最高的单词且显示柱状图*");
    	System.out.println("*  选项4-----退出\t\t\t\t*");
    	System.out.println("*************************************************\n");
    	
    	Scanner sc = new Scanner(System.in); 
        System.out.println("请输入选项:"); 
        //int opt = sc.nextInt();
        String opt=sc.next();//用户的输入可能是各种类型的
        Main m=new Main();
        
    	switch(opt){
    	case "1": 
    		m.opt1count();
    		main(null);
    		break;
    	case "2": 
    		//System.out.println("该功能正在开发中..");
    		m.opt2count();
    		main(null);
    		break;
    	case "3": 
    		m.opt3count();
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
    //功能选项1
    public void opt1count(){
    	Count1 count1= new Count1();
	    count1.wcount();
	}
    //功能选项2
    public void opt2count(){
    	Count2 count2= new Count2();
	    count2.wcount();
	}
    //功能选项2
    public void opt3count(){
    	Count3 count3= new Count3();
	    count3.wcount();
	}
}