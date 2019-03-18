import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * 统计指定单词个数
 */
public class Count2 {
		 public void wcount(){
			 
			int count2=0;
			String word="";
			int flag=1;
			 String filecontent = "";//用来存放读取到的文件内容信息
			 
	        //用键值对分别存储单词和它出现的次数
	        Map<String,Integer> map = new HashMap<String, Integer>();
	        try {
	            //读取指定文件DATA.txt,这里使用的是相对路径
//	          FileInputStream fis = new FileInputStream("J:\\计算机科学与技术\\02 第二学期\\2  软件工程（代祖华）\\实验二 词频统计\\DATA.txt");
	            FileInputStream fis = new FileInputStream("src\\DATA.txt");

	        	//创建BufferedReader的缓冲流，一次性读取很多数据，然后按要求分次交给上层调用者
	            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	            String str = "";
	            try {
	                //一行一行读取
	                while ((str = br.readLine()) != null){
	                	filecontent = filecontent + str;
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }catch (FileNotFoundException e){
	            e.printStackTrace();
	        }
	        //arrspilt数组用来统计单词出现的次数
	        String [] arrspilt = filecontent.split("[^a-zA-Z]+");
	        for (int i=0;i<arrspilt.length;i++){

	            //通过键名来获取键值
	            if (map.get(arrspilt[i]) == null){
	            	//统计键值对
	                map.put(arrspilt[i],1);
	            }else {
	                int count = map.get(arrspilt[i]);
	                map.put(arrspilt[i],++count);
	            }
	        }
	        //利用TreeMap实现Comparator接口
	        Comparator<Map.Entry<String, Integer>> valcom = new Comparator<Map.Entry<String,Integer>>() {

	        	//对词频统计结果进行排序
		        public int compare(Map.Entry<String, Integer> rst1,Map.Entry<String, Integer> rst2) {
		        	//降序排序
		        	int sortrst=rst2.getValue()-rst1.getValue();
					return sortrst;
					
		        	} 
		        
		        };
					
				List<Map.Entry<String, Integer>> ordlist = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
					
				// 用sort函数来排序
				Collections.sort(ordlist,valcom);
				
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
