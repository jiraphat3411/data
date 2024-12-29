import java.util.*;
/*class node {
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
class Stack{
    private node stackTop=null;
    public Stack(){
    }
    public void push(int newInfo) {
    	node newNode = new node(newInfo);
		newNode.setLink(stackTop);	
		stackTop = newNode;
    }
    public int getSize() {
        int size = 1;
        node S = stackTop;
    	while(true){
            if(S.getLink()==null){
                break;
            }
            size++;
            S = S.getLink();
        }
        return size;
    }
    public void Pop() {
    	stackTop = stackTop.getLink();
    }
    @Override
    public String toString() {
    	String text = "";
        node S =stackTop;
    	while(true){
            if(S.getLink() == null){
                text = text+S.getInfo()+" ";
                break;
            }
            text = text+S.getInfo()+" ";
            S = S.getLink();
        }
        return text;
    }
}
public class OddEvenStack {
    public static void main(String[] args) {
        Random rand = new Random();
        Stack odd = new Stack();
        Stack even = new Stack();
        int n = rand.nextInt(11)+10;
        System.out.println("---Random Numbers ["+n+"] ---");
        for(int i = 0;i<n;i++){
            int x = rand.nextInt(101);
            System.out.print(x+" ");
            if(x%2==0){
                even.push(x);
            }else{
                odd.push(x);
            }
        }
        System.out.println();
        System.out.println("--- Even Stack ["+even.getSize()+"] --");
        System.out.println(even.toString());
        System.out.println("--- Odd Stack ["+odd.getSize()+"] ---");
        System.out.println(odd.toString());
        if(even.getSize()>odd.getSize()){
            System.out.println("===> Even is the winner");
        }else if(even.getSize()<odd.getSize()){
            System.out.println("===> Odd is the winner");
        }else{
            System.out.println("===> Even and Odd is equal");
        }
    }
}*/
