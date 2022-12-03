public class Nodo {
    
    int valor;
    Nodo izq = null;
    Nodo der = null;

    int posicion;
    
    public Nodo(){
        izq=der=null;
    }
    public Nodo(int data){
        this(data,null,null);
    }

    public Nodo(int data, int posicion){
        this(data,null,null);
        this.posicion = posicion;
    }
    public Nodo(int data, Nodo lt, Nodo rt){
        valor=data;
        izq = lt;
        der = rt;
    }

    public void setPosicion(int valor) {
        this.posicion = valor;
    }
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
    
    public void setDer(Nodo der) {
        this.der = der;
    }


}
