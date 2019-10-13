import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class DivdenConquer {
    static int inversion_count=0;
    public static void main(String[] args) throws Exception{

        BufferedReader br= new BufferedReader( new FileReader("data04_inversion.txt"));
        String  s= br.readLine();
        StringTokenizer st= new StringTokenizer(s,",");
        int[] list= new int[st.countTokens()];
        int count= 0;
        while (st.hasMoreTokens()){
            list[count]= Integer.parseInt(st.nextToken());
            count++;
        }
        sortandcount(0,list.length-1, list);
        System.out.println(inversion_count);



    }

    public static void sortandcount(int start, int end, int[] list){
        if(start< end){
            int mid= (start+end)/2;
            sortandcount(start,mid, list);
            sortandcount(mid+1,end, list);
            mergeandcount(start,mid, end, list);
        }

    }

    public static void mergeandcount(int start, int mid, int end, int[] list){
        int left= mid-start+1, right= end-mid;
        int[] Left= new int[left+1];
        int[] Right= new int[right+1];

        for(int i=0; i< left; i++){
            Left[i]= list[start+i];
        }
        for(int i=0; i< right; i++){
            Right[i]= list[mid+i+1];
        }
        Left[left]= Integer.MAX_VALUE;
        Right[right]= Integer.MAX_VALUE;
        int i=0;
        int j=0;
        for( int k= start; k<= end; k++){
            if (Left[i]<= Right[j]){
                list[k]= Left[i];
                i++;
            } else {
                list[k]= Right[j];
                j++;
                inversion_count++;
            }
        }


    }
}
