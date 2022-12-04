
import java.util.LinkedList;
import java.util.Queue;

public abstract class ArbolBin {
    Nodo root;
    
    public ArbolBin(){
        root=null;
    }
    
    public ArbolBin(int val){
        root=new Nodo(val);
    }
    
    public ArbolBin(Nodo root){
        this.root=root;
    }
    
    public void add(Nodo padre, Nodo hijo, int lado){
	if(lado==0)
            padre.setIzq(hijo);
	else
            padre.setDer(hijo);
    }
    
    protected void visit(Nodo n){
        System.out.println(n.valor+" ");
    }	
    
    public void breadthFrist(){
        Nodo r = root;
	Queue<Nodo> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
		visit(r);
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
	}
    }

    // proceso recursivo
    public abstract void add(Nodo nuevo);

    /**
     * Método para mostrar un árbol binario
     * @param root nodo raíz donde iniciara el recorrido del árbol.
     * @param space espacio adicional para la separación de cada nodo.
     */
    public static void printTree(Nodo root, int space) {
        //fuente: https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/
        final int COUNT = 10;
        if (root == null)
            return;

        space += COUNT;
        printTree(root.der, space);

        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.valor + "\n");

        printTree(root.izq, space);

    }

    /**
     * Método que muestra el árbol binario sin agregar espacios extra.
     * @param root nodo raíz donde iniciara el recorrido del árbol.
     */
    public static void printTree(Nodo root){
        printTree(root, 0);
    }
}
