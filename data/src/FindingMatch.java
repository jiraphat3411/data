
import java.util.*;

class Hash {

    private int[] hashTable;

    Hash(int n) {
        this.hashTable = new int[2 * n];
        for (int i = 0; i < 2*n; i++) {
            this.hashTable[i] = -1;
        }
    }

    public int hashFunction(int data) {
        return data % (this.hashTable.length);
    }
    
    public int getSizeData() {
        int count = 0;
        for (int i = 0; i < this.hashTable.length; i++) {
            if(this.hashTable[i]>=0){
                count++;
            }
        }
        return count;
    }

    public void add(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int index = this.hashFunction(data[i]);
            for (int j = index;; j++) {
                if (index >= this.hashTable.length) {
                    index = 0;
                }
                if (this.hashTable[index] == -1||this.hashTable[index] == -2) {
                    this.hashTable[index] = data[i];
                    break;
                } else {
                    index++;
                }
            }
        }
    }
    
    public boolean deleteOneHundred(int data) {
        for(int i = 0; i < this.hashTable.length; i++){
            if(this.hashTable[i]+data==100&&this.hashTable[i]>=0){
                this.hashTable[i] = -2;
                return true;
            }
        }
        return false;
    }

    public void printData() {
        for (int i = 0; i < this.hashTable.length; i++) {
            if(this.hashTable[i]>=0){
                System.out.print(i+":"+this.hashTable[i]);
                if(this.hashFunction(hashTable[i])!=i){
                    System.out.print("* ");
                }else{
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }
}

public class FindingMatch {

    public static void main(String[] args) {
        Random R = new Random();
        int n = R.nextInt(11) + 10;
        System.out.println("---Random Numbers [" + n + "] ---");
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            int m = R.nextInt(101);
            for (int j = 0; j < n; j++) {
                if (m == data[j]) {
                    m = R.nextInt(101);
                    j = 0;
                }
            }
            System.out.print(m+" ");
            data[i] = m;
        }
        System.out.println();
        //
        System.out.println("---Hash Table [" + n + "] ---");
        Hash h = new Hash(n);
        h.add(data);
        h.printData();
        //
        System.out.println("---Finding Match ---");
        int count = 0;
        int countFound = 0;
        while(true) {
            int m = R.nextInt(101);
            if(countFound == 3){
                break;
            }
            boolean b = h.deleteOneHundred(m);
            if(b){
                countFound++;
                System.out.print(m+" ");
            }else{
                System.out.print("!"+m+" ");
            }
            count++;
        }
        System.out.println();
        System.out.println("Total Finding: "+count);
        //
        System.out.println("---Hash Table [" + h.getSizeData() + "] ---");
        h.printData();
    }
}
