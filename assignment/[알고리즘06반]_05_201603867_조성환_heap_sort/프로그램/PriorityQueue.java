public class PriorityQueue {
    private int MIN= Integer.MIN_VALUE;
    private Node[] data= null;
    private int size;

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

    public PriorityQueue(Heap data){
        this.setData(data.getData());
        this.setSize(data.getSize());
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
    public void swap(Node tempNode, int index, int indexTemp){
        this.getData()[indexTemp]= this.getData()[index];
        this.getData()[index]=tempNode;
    }
    public void sort(Node tempNode, int tempIndex){
        int index= tempIndex;

        while (index>1){

            if(this.data[index/2-1].getKey()< tempNode.getKey()){
                swap(tempNode, index/2-1, index-1);
                index=index/2;
            } else {
                break;
            }
        }
    }

    public void delete(){
        this.getData()[0]= this.getData()[this.getSize()-1];
        this.getData()[this.getSize()-1]= null;
        this.setSize(this.getSize()-1);

        for (int o=this.getSize()/2; o>=1; o--){
            maxHeapify(this.getData(), o, this.getSize());
        }

        this.printList();
    }
    public void sort(){
        int index= 1;
        Node tempNode= this.getData()[0];
        while (index< this.getSize()){
            if (this.getData()[index-1].getKey() <this.getData()[index*2].getKey()){
                if (this.getData()[index-1].getKey()< this.getData()[index*2-1].getKey()){
                    if (this.getData()[index*2-1].getKey()< this.getData()[index*2].getKey()){
                       // swap(tempNode, index);
                    }
                }
            } else if(this.getData()[index-1].getKey() <this.getData()[index*2].getKey()){

            }

            if(index*2<this.getSize()){
              if (this.getData()[index-1].getKey()<this.getData()[index*2-1].getKey()){
                  if(index*2+1<this.getSize()){
                      if (this.getData()[index-1].getKey()< this.getData()[index*2].getKey()){
                          if(this.getData()[index*2-1].getKey()< this.getData()[index*2].getKey()){
                              swap(tempNode, index*2, index-1);
                              index=index*2;
                          } else {
                              swap(tempNode, index*2-1, index-1);
                              index=index*2-1;
                          }
                      } else {
                          swap(tempNode, index-1, index*2-1);
                          index=index*2-1;
                      }
                  }
              } else if (index*2+1<this.getSize()){
                  if (this.getData()[index-1].getKey()< this.getData()[index*2].getKey()){
                      swap(tempNode, index*2, index-1);
                      index=index*2;
                  } else {

                  }
              } else {
                  break;
              }
            }
        }
    }

    public void printList(){
        for (int o=0; o< this.getSize(); o++){
            System.out.println(this.getData()[o].getKey()+", "+this.getData()[o].getValue());
        }
    }
    public void max(){
        System.out.println(this.getData()[0].getKey()+", "+this.getData()[0].getValue());
    }

    public void keyIncrease(int index, int goal){
        for (Node a: this.getData()){
            if (a.getKey()== index){
                a.setKey(goal);
                break;
            }
        }
        printList();
    }

    public void swap(Node[] list, Node tempNode, int index, int indexTemp){
        list[indexTemp]= list[index];
        list[index]=tempNode;
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
}
