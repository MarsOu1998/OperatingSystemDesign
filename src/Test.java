public class Test {
     static Node head=null;
    public static void main(String[] args) {
    add(200);
    add(300);
    add(400);
    add(500);
    show();
    }

    public static void add( int length){
        Node node=new Node(false,0,length,null);
        if(head==null){
            head=node;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node temp3=new Node(false,0,100,null);
        temp.next=node;
        node.next=temp3;
    }

    public static void show(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.length);
            temp=temp.next;
        }
    }
}
