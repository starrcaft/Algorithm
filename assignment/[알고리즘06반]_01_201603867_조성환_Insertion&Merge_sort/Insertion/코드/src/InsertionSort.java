import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InsertionSort {

    public static void main(String[] args) {

        String input= "";

        try{
            File file= new File("data02.txt");
            FileReader fileReader= new FileReader(file);
            BufferedReader br= new BufferedReader(fileReader);
            String another="";
            while ((another= br.readLine()) !=null){
                input=another;

            }
            fileReader.close();
            br.close();
        }catch (IOException e){
            System.out.println(e);
        }
        StringTokenizer st= new StringTokenizer(input, ",");
        int len=st.countTokens();
        int[] list= new int[len];
        int key=0;
        while(st.hasMoreTokens()){
            list[key]=Integer.parseInt(st.nextToken());
            key++;
        }


        System.out.println(Arrays.toString(list));
        for (int i=0; i<list.length; i++){
            if(i==0) continue;
            key= list[i];
            int temp= i;
            insertion(list, i-1, key);
        }

        String outputString="";
        int i=0;
        while (true){
            if(i==list.length) break;
            else if(i==list.length-1) outputString+=list[i];
            else outputString+=list[i]+",";
            i++;
        }

        try{
            File output= new File("hw01_06_201603867_insertion.txt");
            FileWriter fw= new FileWriter(output);
            fw.write(outputString);

            fw.flush();
            fw.close();
        } catch (IOException e){
            System.out.println(e);
        }
        System.out.println(Arrays.toString(list));

    }
    public static void insertion(int[] a, int end, int key){
        int temp=end;
        while (temp>=0){
            if(key<= a[temp]){
                a[temp+1]= a[temp];
                temp--;
            } else {
                a[temp+1]=key;
                break;
            }
        }
    }
}
