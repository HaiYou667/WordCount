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
 * 统计前K个出现频次最高的单词
 */
public class Count3 {
	public void wcount(){
		
		 String filecontent = "";//用来存放读取到的文件内容信息
       //用键值对分别存储单词和它出现的次数
       Map<String,Integer> map = new HashMap<String, Integer>();
       try {
           //读取指定文件DATA.txt,这里使用的是相对路径
//         FileInputStream fis = new FileInputStream("J:\\计算机科学与技术\\02 第二学期\\2  软件工程（代祖华）\\实验二 词频统计\\DATA.txt");
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
