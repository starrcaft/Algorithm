import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static PriorityQueue queue=null;
    static Scanner sc= null;
    static StringTokenizer st= null;
    public static void main(String[] args) throws Exception{
//        BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream("data05.txt"),"UTF-8"));
        BufferedReader br= new BufferedReader(new FileReader("data05.txt"));

        Object[] linesObject= br.lines().toArray();

        Heap heap= new Heap();
        Node[] list= new Node[linesObject.length];

        for (int o= 0; o<(linesObject).length; o++){
            st= new StringTokenizer((String)linesObject[o], ",");
            Node node= new Node(Integer.parseInt(st.nextToken()), st.nextToken());

            list[o]= node;
        }
        heap=(heap.buildMaxHeap(list));
        heap.setSize(linesObject.length);

        Node[] heapList= heap.getData();


        queue= new PriorityQueue(heap);
        queue.printList();
        System.out.println("---------------------------------\n1. 작업 추가 2. 최대 값 3. 최대 우선순위 작업 처리 \n4. 원소 키 값 증가 5. 작업 제거 6. 종료 \n---------------------------------");
        sc= new Scanner(System.in);
        int input= sc.nextInt();
        while (input!= 6){
            switch (input){
                case 1:
                    //add
                    queue.add(addprocess());
                    queue.printList();
                    break;
                case 2:
                    //max
                    queue.max();
                    break;
                case 3:
                    //최대우선순위
                    break;
                case 4:
                    //key 증가
                    keyIncreaseProcess();
                    break;

                default:
                    delete();
                    //제거
                   break;


            }
            System.out.println("---------------------------------\n1. 작업 추가 2. 최대 값 3. 최대 우선순위 작업 처리 \n4. 원소 키 값 증가 5. 작업 제거 6. 종료 \n---------------------------------");
            input= sc.nextInt();
        }
        System.out.println("종료");
    }
    public static Node addprocess(){
        sc= new Scanner(System.in);
        System.out.println("입력 >>");
        st= new StringTokenizer(sc.next(), ",");
        Node node= new Node(Integer.parseInt(st.nextToken()), st.nextToken());

        return node;
    }
    public static void keyIncreaseProcess(){
        sc= new Scanner(System.in);
        System.out.println("증가하고자 하는 key index 입력 >>");
        int index= sc.nextInt();
        System.out.println("원하는 key 입력(ex 3을 5로 바꾸려면 5 입력) >>");
        int goal= sc.nextInt();
        queue.keyIncrease(index, goal);
    }

    public static void delete(){
        queue.delete();

    }

}
