import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
    static Random random= null;
    public static void main (String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new FileReader("data06.txt"));
        String s= br.readLine();
        StringTokenizer st= new StringTokenizer(s,",");
        int[] A= new int[1000000];

        int index= 0;
        while (st.hasMoreTokens()){
            A[index]= Integer.parseInt(st.nextToken());
            index++;
        }
        int[] B= Arrays.copyOf(A,1000000);

        //quick
        quickSort(A,0,index-1);
        BufferedWriter bw= new BufferedWriter(new FileWriter("week06_06_201603867_quick.txt"));
        for(int i=0; i< index; i++){
            if(i== index-1) bw.write(A[i]+"");
            else bw.write(A[i]+",");
        }
        bw.flush();
        bw= null;
        bw= new BufferedWriter(new FileWriter("week06_06_quickRandom.txt"));
        //randomized
        quickSort_withRandom(B,0,index-1);
        for(int i=0; i< index; i++){
            if(i== index-1) bw.write(B[i]+"");
            else bw.write(B[i]+",");
        }
        bw.flush();
    }
    public static int partition(int[] A,int p,int r){
        int x= A[r];
        int i=p-1;
        for (int j=p; j<r; j++){
            if(A[j]<= x) {
                i++;
                int temp= A[j];
                A[j]= A[i];
                A[i]= temp;
            }
        }
        A[r]= A[i+1];
        A[i+1]= x;

        return i+1;
    }
    public static int randomizedPartition(int[] A,int p,int r){
        double randomValue= Math.random();

        int ranN= (int)(randomValue*(r-p))+p;

        int x=A[ranN];
        A[ranN]= A[r];
        A[r]= x;

        return partition(A, p,r);
    }
    public static void quickSort(int[] A, int p,int r){
        if (p< r){
            int q= partition(A,p,r);
            quickSort(A,p, q-1);
            quickSort(A, q+1, r);
        }

    }
    public static void quickSort_withRandom(int[] A,int p,int r){
        if (p< r){
            int q= randomizedPartition(A,p,r);
            quickSort(A,p, q-1);
            quickSort(A, q+1, r);
        }
    }
}
