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

        MinHeap minHeap1 = new MinHeap();
        minHeap1.add(n43);
        minHeap1.add(n8);
        minHeap1.add(n52);
        minHeap1.add(n15);
        minHeap1.add(n4);
        minHeap1.add(n37);
        minHeap1.add(n80);
        minHeap1.add(n2);
        minHeap1.add(n90);

        System.out.println("\n\tMin Heap\n");
        System.out.println("\n\tArbol 1 - insertar\n");
        ArbolBin.printTree(minHeap1.root);

        Nodo dn100 = new Nodo(100);
        Nodo dn19 = new Nodo(19);
        Nodo dn36 = new Nodo(36);
        Nodo dn17 = new Nodo(17);
        Nodo dn3 = new Nodo(3);
        Nodo dn25 = new Nodo(25);
        Nodo dn1 = new Nodo(1);
        Nodo dn2 = new Nodo(2);
        Nodo dn7 = new Nodo(7);

        MinHeap minHeap2 = new MinHeap();

        minHeap2.add(dn100);
        minHeap2.add(dn19);
        minHeap2.add(dn36);
        minHeap2.add(dn17);
        minHeap2.add(dn3);
        minHeap2.add(dn25);
        minHeap2.add(dn1);
        minHeap2.add(dn2);
        minHeap2.add(dn7);

        System.out.println("\n\tArbol 2 - eliminacion\n");
        ArbolBin.printTree(minHeap2.root);

        int valorEliminar = 1;
        System.out.println("\n\tEliminar: " + valorEliminar);
        minHeap2.remove(valorEliminar);
        ArbolBin.printTree(minHeap2.root);

        valorEliminar = 2;
        System.out.println("\n\tEliminar: " + valorEliminar);
        minHeap2.remove(valorEliminar);
        ArbolBin.printTree(minHeap2.root);


        Nodo nm43 = new Nodo(43);
        Nodo nm8 = new Nodo(8);
        Nodo nm52 = new Nodo(52);
        Nodo nm15 = new Nodo(15);
        Nodo nm4 = new Nodo(4);
        Nodo nm37 = new Nodo(37);
        Nodo nm80 = new Nodo(80);
        Nodo nm2 = new Nodo(2);
        Nodo nm90 = new Nodo(90);

        MaxHeap maxHeap1 = new MaxHeap();
        maxHeap1.add(nm43);
        maxHeap1.add(nm8);
        maxHeap1.add(nm52);
        maxHeap1.add(nm15);
        maxHeap1.add(nm4);
        maxHeap1.add(nm37);
        maxHeap1.add(nm80);
        maxHeap1.add(nm2);
        maxHeap1.add(nm90);

        System.out.println("\n\tMax Heap\n");
        System.out.println("\n\tArbol 1 - insertar\n");
        ArbolBin.printTree(maxHeap1.root);

        Nodo dnm100 = new Nodo(100);
        Nodo dnm19 = new Nodo(19);
        Nodo dnm36 = new Nodo(36);
        Nodo dnm17 = new Nodo(17);
        Nodo dnm3 = new Nodo(3);
        Nodo dnm25 = new Nodo(25);
        Nodo dnm1 = new Nodo(1);
        Nodo dnm2 = new Nodo(2);
        Nodo dnm7 = new Nodo(7);

        MaxHeap maxHeap2 = new MaxHeap();

        maxHeap2.add(dnm100);
        maxHeap2.add(dnm19);
        maxHeap2.add(dnm36);
        maxHeap2.add(dnm17);
        maxHeap2.add(dnm3);
        maxHeap2.add(dnm25);
        maxHeap2.add(dnm1);
        maxHeap2.add(dnm2);
        maxHeap2.add(dnm7);

        System.out.println("\n\tArbol 2 - eliminacion\n");
        ArbolBin.printTree(maxHeap2.root);

        valorEliminar = 100;
        System.out.println("\n\tEliminar: " + valorEliminar);
        maxHeap2.remove(valorEliminar);
        ArbolBin.printTree(maxHeap2.root);

        valorEliminar = 36;
        System.out.println("\n\tEliminar: " + valorEliminar);
        maxHeap2.remove(valorEliminar);
        ArbolBin.printTree(maxHeap2.root);

    }
}