package Words;
import java.io.*;

import java.util.*;

 
public class WordCounts {
 
    public void sort(int[] arry) {
    	//ð������
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
 
    public static void main(String[] args) { // ��HashMap���<����:��Ƶ>����һ��ӳ���ϵ
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        // ��������ʽ�������ַ����е����б�����
        String regex = "[������.��,����\"!--;:?\'\\]]";
        try {
            // ��ȡҪ������ļ�
            BufferedReader br = new BufferedReader(new FileReader("Word.txt"));
            String value;
            while ((value = br.readLine()) != null) {
                value = value.replaceAll(regex, " ");
                // ʹ��StringTokenizer���ִ�
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
            // ����HashMap,������
            Iterator iterator = hashMap.keySet().iterator();
            System.out.println("**********�򵥴�Ƶͳ�Ƴ���***********");
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
