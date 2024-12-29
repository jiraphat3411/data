
import java.util.*;

class SArr {

    int[] arr;

    SArr(int n) {
        this.arr = new int[n];
    }

    public void randVal(int m) {
        Random R = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = R.nextInt((m * 2) + 1) - m;
        }
    }

    public void inserSort() {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i; j > 0&&arr[j - 1] > arr[j]; j--) {
                    arr[j] = arr[j - 1];
                    arr[j-1] = temp;
            }
        }
    }

    public void selestionSort() {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public void bubbleSort() {
        boolean swapped = true;
        int j = 0;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public void shellSort() {
        for (int gap = arr.length/2; gap > 0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                for (int j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j-gap];
                    arr[j-gap] = temp;
                }
            }
        }
    }

    public void printVal() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}

public class Lab8 {

    public static void main(String[] args) {
        Random R = new Random();
        for(int i = 0;i<4;i++){
            int n = R.nextInt(11)+10;
            int m = R.nextInt(41)+10;
            SArr sarr = new SArr(n);
            sarr.randVal(m);
            System.out.println("Random "+n+" numbers [-"+m+".."+m+"] :");
            sarr.printVal();
            if(i==0){
                System.out.println("Insertion Sort :");
                sarr.inserSort();
            }else if(i==1){
                System.out.println("Selection Sort :");
                sarr.selestionSort();
            }else if(i==2){
                System.out.println("Bubble Sort :");
                sarr.bubbleSort();
            }else if(i==3){
                System.out.println("Shell Sort :");
                sarr.shellSort();
            }
            sarr.printVal();
            System.out.println("----------------------------");
        }
        /*int n = R.nextInt(11)+10;
        int m = R.nextInt(41)+10;
        SArr sarr = new SArr(n);
        sarr.randVal(m);
        System.out.println("Random "+n+" numbers [-"+m+".."+m+"] :");
        sarr.printVal();
        System.out.println("Insertion Sort :");
        sarr.inserSort();
        sarr.printVal();
        System.out.println("----------------------------");
        //
        n = R.nextInt(11)+10;
        m = R.nextInt(41)+10;
        SArr sarr2 = new SArr(n);
        sarr2.randVal(m);
        System.out.println("Random "+n+" numbers [-"+m+".."+m+"] :");
        sarr2.printVal();
        System.out.println("Selection Sort :");
        sarr2.selestionSort();
        sarr2.printVal();
        System.out.println("----------------------------");
        //
        n = R.nextInt(11)+10;
        m = R.nextInt(41)+10;
        SArr sarr3 = new SArr(n);
        sarr3.randVal(m);
        System.out.println("Random "+n+" numbers [-"+m+".."+m+"] :");
        sarr3.printVal();
        System.out.println("Bubble Sort :");
        sarr3.bubbleSort();
        sarr3.printVal();
        System.out.println("----------------------------");
        //
        n = R.nextInt(11)+10;
        m = R.nextInt(41)+10;
        SArr sarr4 = new SArr(n);
        sarr4.randVal(m);
        System.out.println("Random "+n+" numbers [-"+m+".."+m+"] :");
        sarr4.printVal();
        System.out.println("Shell Sort :");
        sarr4.shellSort();
        sarr4.printVal();
        System.out.println("----------------------------");
        //*/
    }
}
