
import java.util.*;

class Triangle {

    private double base;
    private double height;
    private String title;
    private boolean equalSide;

    public Triangle() {
    }

    public Triangle(String title) {
        this.title = title;
    }

    public Triangle(double side) {
        this.base = side;
        this.height = (Math.sqrt(3) / 2) * side;
        this.equalSide = true;
    }

    public Triangle(double side, String title) {
        this.base = side;
        this.height = (Math.sqrt(3) / 2) * side;
        this.title = title;
        this.equalSide = true;
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
        if (base == (height / (Math.sqrt(3))) * 2) {
            this.equalSide = true;
        } else {
            this.equalSide = false;
        }
    }

    public Triangle(double base, double height, String title) {
        this.base = base;
        this.height = height;
        this.title = title;
        if (base == (height / Math.sqrt(3)) * 2) {
            this.equalSide = true;
        } else {
            this.equalSide = false;
        }
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setBaseHeight(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public void setSide(double side) {
        this.base = side;
        this.height = (Math.sqrt(3) / 2) * side;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public double getSide() {
        return base;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "<" + title + ">[<" + base + ">:<" + height + "> => <" + Triangle.this.getArea() + ">]";
    }

    public boolean isEquilateral() {
        return equalSide;
    }

    public double getArea() {
        return 0.5 * base * height;
    }
}

class TriangleSet {

    private int maxItem;
    private int noItem;
    private Triangle[] triangleArr;
    private String title;

    public TriangleSet(int max) {
        this.maxItem = max;
        this.noItem = 0;
        this.triangleArr = new Triangle[maxItem];
        this.title = null;
    }

    public TriangleSet(Triangle tri) {
        this.maxItem = 10;
        this.noItem = 1;
        this.triangleArr = new Triangle[maxItem];
        this.triangleArr[0] = tri;
        this.title = null;
    }

    public TriangleSet(Triangle tri, int max) {
        this.maxItem = max;
        this.noItem = 1;
        this.triangleArr = new Triangle[maxItem];
        this.triangleArr[0] = tri;
        this.title = null;
    }

    public TriangleSet(TriangleSet triSet) {
        this.maxItem = 10;
        this.noItem = triSet.triangleArr.length;
        for (int i = 0; i < triSet.triangleArr.length; i++) {
            this.triangleArr[i] = triSet.triangleArr[i];
        }
        this.title = null;
    }

    public TriangleSet(TriangleSet triSet, int max) {
        this.maxItem = max;
        this.noItem = triSet.triangleArr.length;
        for (int i = 0; i < triSet.triangleArr.length; i++) {
            this.triangleArr[i] = triSet.triangleArr[i];
        }
        this.title = null;
    }

    public TriangleSet(String title) {
        this.maxItem = 10;
        this.noItem = 0;
        this.triangleArr = new Triangle[maxItem];
        this.title = title;
    }

    public TriangleSet(String title, int max) {
        this.maxItem = max;
        this.noItem = 0;
        this.triangleArr = new Triangle[maxItem];
        this.title = title;
    }

    public TriangleSet() {
        this.maxItem = 10;
        this.noItem = 0;
        this.triangleArr = new Triangle[maxItem];
        this.title = null;
    }

    //
    public void setTitle(String title) {
        this.title = title;
    }

    public void add(Triangle tri) {
        this.triangleArr[this.noItem] = tri;
        this.triangleArr[this.noItem].setBaseHeight(tri.getBase(), tri.getHeight());
        this.noItem++;
    }

    public void add(TriangleSet triSet) {
        for (int i = 0; i < triSet.getSize(); i++) {
            this.triangleArr[noItem] = triSet.triangleArr[i];
            this.triangleArr[noItem].setBaseHeight(triSet.triangleArr[i].getBase(), triSet.triangleArr[i].getHeight());
            this.noItem++;
        }
    }

    /*public void merge(TriangleSet triSet){
        
    }*/
    public void removeTitle(String title) {
        this.title = null;
    }

    public void removeItem(int no) {
        this.noItem--;
        for (int i = no; i < noItem; i++) {
            this.triangleArr[no] = this.triangleArr[no + 1];
        }
        this.triangleArr[noItem] = null;
    }

    public void removeAll() {
        for (int i = 0; i < noItem; i++) {
            this.triangleArr[i] = null;
        }
        this.noItem = 0;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        for (int i = this.noItem; i < this.maxItem; i++) {
            Triangle t = new Triangle();
            //this.triangleArr[i] = t;
            System.out.println("Enter triangle's title [Return <NONE>, - <END>]");
            String title1 = sc.nextLine();
            if (title1.equalsIgnoreCase("")) {
            } else if (title1.equalsIgnoreCase("-")) {
                break;
            } else {
                //this.triangleArr[i].setTitle(title1);
                t.setTitle(title1);
            }
            while(true){
                System.out.println("Is it a equilateral triangle (y/n) ?");
                title1 = sc.nextLine();
                if (title1.equalsIgnoreCase("y")) {
                    System.out.print("Enter side length > ");
                    double side = sc.nextDouble();
                    t.setSide(side);
                    //this.triangleArr[i].setSide(side);
                    sc.nextLine();
                    break;
                } else if (title1.equalsIgnoreCase("n")) {
                    System.out.print("Enter base length > ");
                    double base = sc.nextDouble();
                    System.out.print("Enter heigth length > ");
                    double heigth = sc.nextDouble();
                    t.setBaseHeight(base, heigth);
                    //this.triangleArr[i].setBaseHeight(base, heigth);
                    sc.nextLine();
                    break;
                }else{
                    continue;
                }
            }
            TriangleSet.this.add(t);
                //this.noItem++;
        }
    }

    public int getSize() {
        return noItem;
    }

    public int getMaxSize() {
        return maxItem;
    }

    public boolean isAllEquilateral() {
        boolean b = true;
        for (int i = 0; i < noItem; i++) {
            if (triangleArr[i].isEquilateral() == false) {
                b = false;
                break;
            }
        }
        return b;
    }

    public boolean isEmpty() {
        if (this.noItem == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (this.noItem == this.maxItem) {
            return true;
        } else {
            return false;
        }
    }

    public double getSumArea() {
        double sum = 0;
        for (int i = 0; i < noItem; i++) {
            sum += triangleArr[i].getArea();
        }
        return sum;
    }

    public Triangle getItem(int no) {
        return triangleArr[no];
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "<" + title + ">:<" + maxItem + ">:<" + noItem + ">";
    }
}

public class Main {

    public static void main(String[] args) {
        TriangleSet ts = new TriangleSet(3);
        ts.setTitle("test");
        ts.inputData();
        System.out.println(ts.toString());
        if (!ts.isEmpty()) {
            for (int i = 0; i < ts.getSize(); i++) {
                System.out.println(ts.getItem(i).toString());
            }
        }
    }
}
