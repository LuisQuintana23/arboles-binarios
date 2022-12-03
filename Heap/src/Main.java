import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Nodo n43 = new Nodo(43);
        Nodo n8 = new Nodo(8);
        Nodo n52 = new Nodo(52);
        Nodo n15 = new Nodo(15);
        Nodo n4 = new Nodo(4);
        Nodo n37 = new Nodo(37);
        Nodo n80 = new Nodo(80);
        Nodo n2 = new Nodo(2);
        Nodo n90 = new Nodo(90);

        Heap heap1 = new Heap();
        heap1.add(n43);
        heap1.add(n8);
        heap1.add(n52);
        heap1.add(n15);
        heap1.add(n4);
        heap1.add(n37);
        heap1.add(n80);
        heap1.add(n2);
        heap1.add(n90);

        GFG.print2D(heap1.root);
    }
}