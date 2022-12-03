import java.util.LinkedList;
import java.util.Queue;

public class Heap extends ArbolBin {

    private Nodo ultimoDisponible; // ultima posicion disponible
    private int tamano;

    public Heap() {
        super();
        tamano = 0; // setea como 0 el tamaño
    }

    @Override
    public void add(Nodo nuevo) {
        // agregar raiz
        if (tamano == 0) { // verifica si no existe algun nodo, en caso de que no se setea la raiz
            this.root = nuevo;
            this.root.setPosicion(tamano);
            tamano++;
            return;
        }
        int posicionDisponible = tamano;
        nuevo.setPosicion(posicionDisponible);
        tamano++;

        setUltimoDisponible(nuevo);
        Nodo padre = getDady(nuevo);

        /*una vez colocado el nodo a la izquierda o derecha
          con su nueva posicion, se procede a verificar
          si el padre es mayor o menor
         */

        while(padre.valor < nuevo.valor){
            nuevo = swap(nuevo, padre); // se intercambia la posicon del padre con la del hijo
            padre = getDady(nuevo);
            if (padre == null){ // en caso de que ya no tenga padre el nuevo sera la raiz
                return;
            }
        }
    }

    public Nodo swap(Nodo hijo, Nodo padre){
        int temp = padre.valor;
        // colocar datos del hijo en el padre
        padre.valor = hijo.valor;
        // los datos del padre ahora estaran en el hijo
        hijo.valor = temp;

        return padre;
    }
    public void setUltimoDisponible(Nodo nuevo) {
        /* con el nodo nuevo a ingresar se va
           obtener la posicion en la que el nodo tendria
           que ir al igual que su posicion en el padre
           ya sea la izquierda o derecha
         */

        Nodo padre = getDady(nuevo); // obtener el padre a partir de un nodo nuevo o hijo
        int lado = getLado(nuevo.posicion);

        if (lado == 1){ // si el lado es 1, se coloca a la izquierda
            padre.setIzq(nuevo);
        }
        else // si el lado de 2 se coloca a la derecha
        {
            padre.setDer(nuevo);
        }
    }


    public Nodo getDady(Nodo hijo){
        /* por medio de la posicion del hijo obtiene con la formula
           la posicion del padre, llama al metodo getNodoByPosicion
           ejecuta BFS y busca el nodo que tiene esa posicion,
           cuando lo encuentra retorna el nodo.
         */
        int posHijo = hijo.posicion;
        int lado = this.getLado(posHijo);


        int posPadre = this.getPosicionDady(posHijo, lado);

        if (posPadre <= -1){
            return null;
        }

        Nodo padre = this.getNodoByPosicion(posPadre);

        return padre;
    }

    public int getLado(int posicion){
        int lado;
        if (posicion%2 == 0) // si es par debe estar a la derecha
            lado = 2;
        else // en caso de ser impar, estara a la izquierda (si se toma que la raiz empieza en 0)
            lado = 1;

        return lado;
    }

    public int getPosicionDady(int posicion, int lado) {
        /* posicion sera la posicion del hijo
           lado 1 == lado izquierdo
           lado 2 == lado derecho
         */
        if (lado < 1 || lado > 2){ // en caso de no ingresar bien los lados
            throw new IllegalArgumentException();
        }

        return ((posicion - lado)/2);
    }



    public Nodo getNodoByPosicion(int posicion){
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList();
        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();

                if (r.posicion == posicion)
                    return r;
                if(r.izq!=null)
                    queue.add(r.izq);
                if(r.der!=null)
                    queue.add(r.der);
            }
        }

        return null; // en caso de no encontrarlo
    }


    public Nodo getUltimoDisponible(){
        return ultimoDisponible;
    }

}

// Java Program to print binary tree in 2D
class GFG {

    static final int COUNT = 10;

    // Function to print binary tree in 2D
    // It does reverse inorder traversal
    static void print2DUtil(Nodo root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.der, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.valor + "\n");

        // Process left child
        print2DUtil(root.izq, space);
    }

    // Wrapper over print2DUtil()
    static void print2D(Nodo root) {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

}
