public class Node {

    private String value="";
    private int key;

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }

    public Node(){
        setKey(0);
        setValue("");
    }
    public Node(int key, String value){
        setKey(key);
        setValue(value);
    }
}
