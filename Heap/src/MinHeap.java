import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase para la creación de un min heap con sus operaciones de inserción y eliminación.
 * @author  Luis Angel Quintana Mora
 * @version 04 Dic 2022
 */

public class MinHeap extends ArbolBin {
    private int tamano;
    public MinHeap() {
        super();
        tamano = 0; // setea como 0 el tamaño
    }

    /**
     * Método para inserción de un nodo en un min heap.
     * @param nuevo Recibe el nodo que desea insertar en el heap.
     */
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

        while(padre.valor > nuevo.valor){
            nuevo = swap(padre, nuevo); // se intercambia la posicon del padre con la del hijo
            padre = getDady(nuevo);
            if (padre == null){ // en caso de que ya no tenga padre el nuevo sera la raiz
                this.root = nuevo;
                return;
            }
        }
    }



    /**
     * Método para eliminar un nodo a partir de un valor de un min heap
     * @param valor Recibe un entero que sera el valor que se desea eliminar.
     * @return Devuelve un booleano: false si no se elimino el nodo y true si se elimino.
     */
    public boolean remove(int valor){
        boolean eliminado = false;

        int posicionDisponible = tamano - 1;
        Nodo nRemove = this.getNodoByValor(valor); // obtiene el nodo del valor dado
        Nodo nChange = this.getNodoByPosicion(posicionDisponible);

        if (nRemove == null){ // en caso de que el nodo con el valor pasado no exista
            return eliminado;
        }

        nChange = this.swap(nRemove,nChange);

        removeLeaf(getNodoByValor(valor));

        Nodo nHijo = this.getHijoMayor(nChange);

        while(nChange.valor > nHijo.valor){
            nChange = swap(nHijo, nChange); // se intercambia la posicon del padre con la del hijo
            nHijo = this.getHijoMayor(nChange);
            if (nHijo == null){
                break;
            }
        }

        tamano--;
        eliminado = true;
        return eliminado;
    }

    /**
     * Método para eliminación de una hoja del arbol.
     * @param n Recibe el nodo hoja que se desea eliminar.
     * @return devuelve un booleano: false si no se elimino el nodo y true si se elimino.
     */
    public boolean removeLeaf(Nodo n){
        boolean eliminado = false;

        Nodo padre = this.getDady(n);
        int lado = this.getLado(n.posicion);

        if (lado == 1){
            padre.izq = null;
            eliminado = true;
        }else{
            padre.der = null;
            eliminado = true;
        }

        return eliminado;
    }

    /**
     * Método para intercambiar la posición de un nodo por la posición de otro.
     * @param hijo el nodo que ocupara la posición del padre.
     * @param padre el nodo que ocupara la posición del hijo.
     * @return devuelve un nodo hijo que ya toma la posición del padre.
     */
    public Nodo swap(Nodo hijo, Nodo padre){
        int temp = padre.valor;
        // colocar datos del hijo en el padre
        padre.valor = hijo.valor;
        // los datos del padre ahora estaran en el hijo
        hijo.valor = temp;

        return hijo;
    }

    /**
     * Método para colocar el nuevo nodo en la ultima posición disponible.
     * @param nuevo el nodo que se posicionará en la ultima posición disponible.
     */
    public void setUltimoDisponible(Nodo nuevo) {

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

    /**
     * Método para obtener el padre por medio de su nodo hijo.
     * @param hijo nodo a partir de donde se buscará a su nodo padre.
     * @return Retorna el nodo padre en caso de tenerlo, en otro caso retorna null.
     */
    public Nodo getDady(Nodo hijo){
        int posHijo = hijo.posicion;
        int lado = this.getLado(posHijo);


        int posPadre = this.getPosicionDady(posHijo, lado);

        if (posPadre <= -1){
            return null;
        }

        Nodo padre = this.getNodoByPosicion(posPadre);

        return padre;
    }

    /**
     * Método para obtener el lado de un nodo a partir de su posición.
     * @param posicion entero que corresponde a la posición del nodo a colocar.
     * @return Retorna un entero: 1 para posición izquierda y 2 para derecha.
     */
    public int getLado(int posicion){
        // 1 - izquierda
        // 2 - derecha
        int lado;
        if (posicion%2 == 0) // si es par debe estar a la derecha
            lado = 2;
        else // en caso de ser impar, estara a la izquierda (si se toma que la raiz empieza en 0)
            lado = 1;

        return lado;
    }

    /**
     * Método para obtener el lado de un nodo a partir de su posición.
     * @param posicion entero que corresponde a la posición del nodo a colocar.
     * @return Retorna un entero: 1 para posición izquierda y 2 para derecha.
     */
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



    /**
     * Método para obtener un nodo a partir de su posición
     * @param posicion entero que corresponde a la posición del nodo a buscar.
     * @return Retorna un nodo si es que existe, en caso contrario retorna null.
     */
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

    /**
     * Método para obtener un nodo a partir de su valor
     * @param valor entero que corresponde al valor del nodo a buscar.
     * @return Retorna un nodo si es que existe, en caso contrario retorna null.
     */
    public Nodo getNodoByValor(int valor){
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList();
        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();

                if (r.valor == valor)
                    return r;
                if(r.izq!=null)
                    queue.add(r.izq);
                if(r.der!=null)
                    queue.add(r.der);
            }
        }

        return null; // en caso de no encontrarlo
    }


    /**
     * Método para obtener al hijo mayor de un nodo padre.
     * @param padre nodo padre para poder obtener a su hijo mayor.
     * @return Retorna el nodo del hijo mayor si es que existe, en caso contrario retorna null.
     */
    public Nodo getHijoMayor(Nodo padre){

        // en caso de que no tenga hijos terna null
        if (padre.izq == null && padre.der == null){
            return null;
        }

        // verificar si solo tiene un hijo retornar directamente el hijo unico
        if(padre.izq == null){
            return padre.der;
        }
        else if(padre.der == null){
            return padre.izq;
        }

        // en caso de que si tenga los 2 hijos completos
        if (padre.izq.valor < padre.der.valor){ // si el nodo izquierdo es mayor
            return padre.izq;
        }else{ // en caso de que el derecho sea el mayor
            return padre.der;
        }

    }
}

