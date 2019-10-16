public class Heap {
    private Node MIN= new Node(Integer.MIN_VALUE,"");
    private Node[] data= null;
    private int size;
    private int limit= 100;

    public Node[] getData() {
        return data;
    }
    public void setData(Node[] data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Heap(){
        Node[] node= new Node[limit];
        for (Node a : node){
            a=MIN;
        }
        this.setData(node);
        this.setSize(0);

    }


    public void add(Node temp){
        if(size!= 0){

            getData()[size]=temp;
            this.setSize(this.getSize()+1);

            sort(temp, size);

        } else {
            data[0]= temp;
            this.setSize(this.getSize()+1);
        }
    }
    public void swap(Node[] list, Node tempNode, int index, int indexTemp){
        list[indexTemp]= list[index];
        list[index]=tempNode;
    }
    public void sort(Node tempNode, int tempIndex){
        int index= tempIndex;

        while (index>1){

            if(this.data[index/2-1].getKey()< tempNode.getKey()){
                swap(this.getData(), tempNode, index/2-1, index-1);
                index=index/2;
            } else {
                break;
            }
        }
    }

    public Heap buildMaxHeap(Node[] nodes){

        for (int o=nodes.length/2; o>=1; o--){
            maxHeapify(nodes, o, nodes.length);
        }

        Heap newheap= new Heap();
        int index=0;
        for (Node node: nodes){
            newheap.getData()[index]= node;
            index++;
        }
        return newheap;
    }
    public void maxHeapify(Node[] nodes, int index, int size){
        while (index*2 <= size) {
            if(index*2+1<= size){
                //left right 다 있음
                if (nodes[index-1].getKey()<nodes[index*2].getKey()){
                    //temp < rght
                    if (nodes[index-1].getKey()< nodes[index*2-1].getKey()){
                        //temp < left
                        if (nodes[index*2].getKey()< nodes[index*2-1].getKey() ){
                            //left >rigjt
                            swap(nodes, nodes[index-1], index*2-1, index-1);
                            index=index*2; continue;
                        } else {
                            swap(nodes, nodes[index-1], index*2, index-1);
                        }
                    } else {
                        swap(nodes, nodes[index-1], index*2, index-1);
                    }
                } else if (nodes[index-1].getKey()< nodes[index*2-1].getKey()){
                    swap(nodes, nodes[index-1], index*2-1, index-1);
                    index= index*2; continue;
                } else {
                    break;
                }
                index=index*2+1; continue;
            }
            //left만 있음.
            if (nodes[index-1].getKey()< nodes[index*2-1].getKey()){
                //temp < left
                swap(nodes, nodes[index-1], index*2-1, index-1);
                index=index*2;
                continue;
            }
            //swap이 필요없음
            break;
        }
    }
    /*
    1
    2 3
    45 67
    89 1011 1213 1415

    7 검사 ->
    1) left, right 다 있을 때 temp< left temp< right left< right  swap temp, right
    2) " left> right swap temp, left
    3)" temp> right swap temp, left
    4) " temp> left temp <right swap temp, right
     */
}
