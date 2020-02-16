public class Node{

     boolean busy;
     int startAddress;
     int length;
     Node next;

       public Node(){
        }

    public Node(boolean busy,int startAddress,int length,Node next){
        this.busy = busy;
        this.startAddress = startAddress;
        this.length = length;
        this.next = next;
    }

}