import java.util.Scanner;

public class Link{
    private static final int Max=1000;
    private static Node head=new Node(false,0,Max,null);
    private static int length;
    private static Node init=new Node(false,0,Max,null);
    private static Node node=new Node(false,0,Max,init);
    public static void main(String[] args) {
        int choice=menu();
        do {
            switch (choice) {
                case 1:
                    allocation();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    show();
                    break;
            }
        }while(true);
    }

    private static void show() {
        Node temp=head;
        System.out.println("起始地址\t内存大小\t是否占用");
        while(temp!=null) {
            System.out.printf("%-8d%-8d%-8s\n", temp.startAddress, temp.length, temp.busy);
            temp = temp.next;
        }
    }

    private static void delete() {
    }

    public static  int  menu(){
        Scanner in=new Scanner(System.in);
        boolean error=false;
        int choice;
        do {
            error=false;
            System.out.println("请选择功能");
            System.out.println("1.申请分区");
            System.out.println("2.回收分区");
            System.out.println("3.显示当前内存使用情况");
            choice=in.nextInt();
            switch(choice){
                case 1:
                case 2:
                case 3:break;
                default:
                    System.out.println("无效的输入，请重新输入");
                    error=true;
                    break;
            }
        }while(error);
        return choice;
    }

    public static  void allocation(){
        Scanner in=new Scanner(System.in);
        boolean error=false;
        int choice;
        System.out.println("当前系统内存可用大小："+Max);
        do {
            error=false;
            System.out.println("请选择分区算法:");
            System.out.println("1.最先适应算法");
            System.out.println("2.最佳适应算法");
            System.out.println("3.循环适应算法");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                case 2:
                case 3:break;
                default:
                    System.out.println("无效的选项，请重新输入");
                    error=true;
                    break;
            }
        }while(error);
        System.out.println("请输入分区大小:");
        length=in.nextInt();
        if(length<=Max){
            switch(choice){
                case 1:firstFit(length);break;
                case 2:bestFit();break;
                case 3:nextFit();break;
            }
        }else
        {
            System.out.println("空间不足，请重新输入分区大小。");
        }
    }

    private static void nextFit() {
    }

    private static void bestFit() {
    }

    public static void firstFit(int length){
        Node temp=head;
        while(temp!=null){
            if(!temp.busy&&temp.length>=length){
                if(temp.length==length){
                    if(temp.length+length==Max){
                        temp.next=new Node(true,temp.startAddress,length,null);
                    }
                    else
                    temp.busy=true;
                }else
                {
                    Node temp2=new Node(false,temp.startAddress+length,temp.length-length,temp.next);
                    temp.length=length;
                    temp.busy=true;
                    temp.next=temp2;

                }
                show();
                return;
            }
            temp=temp.next;
        }
        System.out.println("空间不足");

    }
}