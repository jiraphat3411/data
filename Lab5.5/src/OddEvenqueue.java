import java.util.*;
class node {
    private int info;
    private node link;
    public node(int info,node link)
   {
       this.info=info;
       this.link=link;
    }
    public node(int info)
    {
        this(info,null);
    }
    public node()
    {
        this(0,null);
    }
    public int getInfo() {
	return this.info;
    }
    public node getLink() {
        return this.link;
    }
    public void setInfo(int info) 
    {
	this.info=info;
    }
    public void setLink(node link) {
        this.link = link;
    }
    @Override
    public String toString() {
	return ""+this.info;
    }
}
class Queue{
    private node front=null;
    private node back=null;
    public Queue(){
    }
    public void enqueue(int newInfo) {
    	node newNode = new node(newInfo);
        if(front==null){
            front=newNode;
            //newNode.setLink(back);
            back=newNode;
        }else{
            back.setLink(newNode);
            back=newNode;
        }
    }
    public int getSize() {
        int size = 1;
        node S = front;
        if(S==null){
            size = 0;
        }else{
            while(true){
                if(S.getLink()==null){
                    break;
                }
                size++;
                S = S.getLink();
            }
        }
        return size;
    }
    public void dequeue() {
    	front = front.getLink();
    }
    @Override
    public String toString() {
    	String text = "[ ";
        node S =front;
    	while(true){
            if(S==null){
                text = "[null";
                break;
            }
            if(S.getLink() == null){
                text = text+S.getInfo()+" ";
                break;
            }
            text = text+S.getInfo()+" ";
            S = S.getLink();
        }
        text = text+"]";
        return text;
    }
    public int getInfo(){
        return front.getInfo();
    }
    public node getlink(){
        return front.getLink();
    }
}
public class OddEvenqueue {
    public static void main(String[] args) {
        Random rand = new Random();
        Queue odd = new Queue();
        Queue even = new Queue();
        /*odd.enqueue(65);odd.enqueue(89);odd.enqueue(81);
        even.enqueue(68);even.enqueue(56);even.enqueue(2);even.enqueue(56);
        even.enqueue(96);even.enqueue(44);even.enqueue(16);*/
        /*odd.enqueue(11);odd.enqueue(99);odd.enqueue(11);odd.enqueue(25);
        even.enqueue(70);even.enqueue(88);even.enqueue(54);even.enqueue(58);
        even.enqueue(82);even.enqueue(14);even.enqueue(26);even.enqueue(22);
        even.enqueue(30);*/
        int n = rand.nextInt(11)+10;
        System.out.println("--- Random Numbers ["+n+"] ---");
        for(int i = 0;i<n;i++){
            int x = rand.nextInt(101);
            System.out.print(x+" ");
            if(x%2==0){
                even.enqueue(x);
            }else{
                odd.enqueue(x);
            }
        }
        System.out.println();
        System.out.println("--- Even Queue ["+even.getSize()+"] --");
        System.out.println(even.toString());
        System.out.println("--- Odd Queue ["+odd.getSize()+"] ---");
        System.out.println(odd.toString());
        if(even.getSize()>odd.getSize()){
            System.out.println("===> Even is the winner");
        }else if(even.getSize()<odd.getSize()){
            System.out.println("===> Odd is the winner");
        }else{
            System.out.println("===> Even and Odd is equal");
        }
        int ewin = 0;
        int owin = 0;
        while(true){
            //boolean b = false;
            /*System.out.println("");
            System.out.println(even.toString());
            System.out.println(odd.toString());*/
            if(odd.toString().equalsIgnoreCase("[null]")||even.toString().equalsIgnoreCase("[null]")){
                //b = true;
                break;
            }
            if(odd.getInfo()<even.getInfo()){
                if(odd.getSize()!=1){
                    odd.enqueue(odd.getInfo());
                    odd.dequeue(); 
                }
                even.dequeue();
                ewin++;
            }else if(odd.getInfo()>even.getInfo()){
                odd.dequeue();
                if(even.getSize()!=1){
                    even.enqueue(even.getInfo());
                    even.dequeue();
                }
                owin++;
            }
            /*if(b){
                break;
            }*/
        }
        System.out.print("Round="+/*round*/(ewin+owin)+", Win=(E:"+ewin+",O:"+owin+"), ");
        if(odd.getSize()==0){
            System.out.println("Even Left="+ even.getSize());
        }else if(even.getSize()==0){
            System.out.println("Odd Left="+ odd.getSize());
        }
        /*System.out.println();
        System.out.println(even.toString());
        System.out.println(odd.toString());*/
    }
}
