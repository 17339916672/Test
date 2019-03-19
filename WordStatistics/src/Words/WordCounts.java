package Words;
import java.io.*;

import java.util.*;

 
public class WordCounts {
 
    public void sort(int[] arry) {
    	//冒泡排序
        int t;
        for (int i = 0; i < arry.length; i++) {
            for (int j = i; j < arry.length; j++) {
                if (arry[i] > arry[j]) {
                    t = arry[i];
                    arry[i] = arry[j];
                    arry[j] = t;
                }
            }
 
        }
        for (int k = 0; k < arry.length; k++) {
            System.out.print(arry[k] + " ");
        }
    }
 
    public static void main(String[] args) { // 用HashMap存放<单词:词频>这样一个映射关系
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        // 用正则表达式来过滤字符串中的所有标点符号
        String regex = "[【】、.。,，。\"!--;:?\'\\]]";
        try {
            // 读取要处理的文件
            BufferedReader br = new BufferedReader(new FileReader("Word.txt"));
            String value;
            while ((value = br.readLine()) != null) {
                value = value.replaceAll(regex, " ");
                // 使用StringTokenizer来分词
                StringTokenizer tokenizer = new StringTokenizer(value);
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken();
                    if (!hashMap.containsKey(word)) {
                        hashMap.put(word, new Integer(1));
                    } else {
                        int k = hashMap.get(word).intValue() + 1;
                        hashMap.put(word, new Integer(k));
                    }
                }
            }
            // 遍历HashMap,输出结果
            Iterator iterator = hashMap.keySet().iterator();
            System.out.println("**********简单词频统计程序***********");
            while (iterator.hasNext()) {
                String word = (String) iterator.next();
                
                System.out.println(word + ":\t" + hashMap.get(word));
            }
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
