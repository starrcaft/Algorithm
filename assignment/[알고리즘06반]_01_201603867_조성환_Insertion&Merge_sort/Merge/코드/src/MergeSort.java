import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MergeSort {

    static int mergeCount=0;
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
        int o=0;
        while(st.hasMoreTokens()){
            list[o]=Integer.parseInt(st.nextToken());
            o++;
        }

        System.out.println(Arrays.toString(list));
        mergeSort(list, 0, list.length-1);
        String outputString="";
        int i=0;
        while (true){
            if(i==list.length) break;
            else outputString+=list[i]+",";
            i++;
        }
        outputString+=mergeCount;
        try{
            File output= new File("hw01_06_201603867_merge.txt");
            FileWriter fw= new FileWriter(output);
            fw.write(outputString);

            fw.flush();
            fw.close();
        } catch (IOException e){
            System.out.println(e);
        }
        System.out.println(Arrays.toString(list));

    }

    static void mergeSort(int[] a, int low, int high){
        if(low>= high) return;
        int mid= (low+high)/2;
        mergeSort(a, low, mid);
        mergeSort(a, mid+1, high);
        merge(a, low, mid, high);

    }
    static void merge(int[] a, int low, int mid, int high){
        mergeCount++;
        int leftEndIndex= mid, rightStartIndex= mid+1, left= low, temp=0;
        while(left<=leftEndIndex && rightStartIndex<=high && low<= rightStartIndex) {
            if (a[low] <= a[rightStartIndex]) {
                low++;
            } else {
                temp=a[rightStartIndex];
                for(int o= rightStartIndex-1; o>= low; o--){
                    a[o+1]= a[o];
                }
                a[low]= temp;
                low++; leftEndIndex++; rightStartIndex++;
            }
        }
    }
}
