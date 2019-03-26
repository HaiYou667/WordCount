import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * @author guojia
 * 统计前K个出现频次最高的单词
 * 用符号个数来模拟柱状图
 */
public class Histogram {
	public void wcount(){
		
		Count1 c=new Count1();
		c.readandprocessfile();
		
	    List<Map.Entry<String, Integer>> ordlist = new ArrayList<Map.Entry<String,Integer>>(c.map.entrySet());
				
		// 用sort函数来排序
		Collections.sort(ordlist,c.valcom);
				
		System.out.println("注：该文件中共有"+ordlist.size()+"个不同的单词！");
		Scanner sc = new Scanner(System.in); 
	    System.out.println("请输入要查看的最高词频的个数:"); 
		int k = sc.nextInt();
		//String opt=sc.next();
				
	    //System.out.println(list.size());
		if(k>0&&k<=ordlist.size())
		 {
		    System.out.println("----------词频最高的前"+k+"个单词及其柱状图-----------");
					
			for (Map.Entry<String, Integer> entry : ordlist) {
						
				//System.out.println(entry.getKey() + ":" + entry.getValue()+'\t');
				//System.out.println("单词 "+entry.getKey() + " 出现 " + entry.getValue()+" 次 ");
				System.out.printf("单词 "+"%-8s" + "出现 " +"%-3d"+" 次 |",entry.getKey(),entry.getValue());	
				//用符号个数来模拟柱状图
				for(int i=entry.getValue();i>0;i--)
				{
					System.out.print("⬛");
				}
				System.out.println();
				//System.out.println(entry.getKey() + ":" + entry.getValue());
							
				if(--k==0)
					break;//如果k==0z 则不再输出后面的词频					
						
				}
			System.out.println("------------------------------------------------");	

		    }else{
		       	System.out.println("输入有误！请重新输入！");
		     }
		        
		}
	}
