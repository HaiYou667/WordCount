import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * @author guojia
 * 统计指定单词个数
 */
public class Count2 {
		 public void wcount(){
			 
			int count2=0;
			String word="";
			int flag=1;
			
			Count1 c=new Count1();
			c.readandprocessfile();
	        
			List<Map.Entry<String, Integer>> ordlist = new ArrayList<Map.Entry<String,Integer>>(c.map.entrySet());
				// 用sort函数来排序
			Collections.sort(ordlist,c.valcom);	
			
			Scanner sc = new Scanner(System.in); 
		    System.out.println("请输入想要统计出现在文章中的单词:"); 
            String w = sc.next();		
		         
			for (Map.Entry<String, Integer> entry : ordlist) {
				
				if(entry.getKey().equals(w)){//
					word=entry.getKey();
					count2=entry.getValue();
					flag=1;
					break;
				}else{
					flag=0;
				}				
			}

			if(flag==1){
				System.out.println("该单词"+word+"出现的个数为:"+count2);	
			}else{
				System.out.println("对不起文章中没有出现该单词！");
			}
				
		 }
	}
