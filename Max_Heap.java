
package com.mycompany.bocetoproyecto;

public class Bocetoproyecto{
    public static void main(String[] args){
        /*AVL<Estudiante> arbol = new AVL<>();

        arbol.insert(new Estudiante(10, "Juan", (byte) 85));
        arbol.insert(new Estudiante(20, "Ana", (byte) 90));
        arbol.insert(new Estudiante(30, "Pedro", (byte) 75));
        arbol.insert(new Estudiante(40, "Maria", (byte) 95));
        arbol.insert(new Estudiante(50, "Luis", (byte) 80));
        arbol.insert(new Estudiante(25, "Carlos", (byte) 88)); 

        System.out.println("\n--- Recorrido In-Order ---");
        arbol.inOrder();*/
        
        SISTEMA_2 s = new SISTEMA_2(3);
        //AÑADIR ELEMENTOS 
        s.Agregar_Estudiante(new Estudiante(10, "Juan", (byte) 85));
        s.Agregar_Estudiante(new Estudiante(20, "Ana", (byte) 58));
        s.Agregar_Estudiante(new Estudiante(30, "Pedro", (byte) 75));
        s.Agregar_Estudiante(new Estudiante(40, "Maria", (byte) 43));
        s.Agregar_Estudiante(new Estudiante(50, "Luis", (byte) 80));
        s.Agregar_Estudiante(new Estudiante(25, "Carlos", (byte) 25));
        s.Agregar_Estudiante(new Estudiante(64, "Ramiro", (byte) 55));
        s.Agregar_Estudiante(new Estudiante(47, "Luciana", (byte) 38)); 
        
        //IMPRIMIR ESTUDIANTES QUE TIENEN RESIDENCIA
        System.out.println("Estudiantes con Residencia");
        s.listar_estudiantes_con_residencia();
        System.out.println("");
        
        //IMPRIMIR ESTUDIANTES SIN RESIDENCIA
        s.Listar_estudiantes_sin_residencia();
        System.out.println("");
        
        //MOSTRAR AVL
        System.out.println("ARBOL AVL O ESTUDIANTES ORDENADOS POR PUNTAJE SE DE MANERA CRECIENTE");
        s.Listar_por__puntaje_SE();
        System.out.println("");
        
        //OBTENER ESTUDIANTE MEDIANTE ID 
        System.out.println("OBTENER ESTUDIANTE POR ID: ID 64");
        System.out.println(s.obtener_datos_por_ID(64) );
        
        //MODIFICAR PUNTAJE DE UN ESTUDIANTE
        //s.Modificar_puntaje_estudiante(estudiante, 0);
        
        //MODIFICAR CUPOS DISPONIBLES 
        s.Asignar_numero_de_cupos(5);
        System.out.println("");
        System.out.println("NUMERO DE CUPOS MODIFICADO A 5");
        //IMPRIMIR ESTUDIANTES QUE TIENEN RESIDENCIA
        s.listar_estudiantes_con_residencia();
        System.out.println("");
        
        //IMPRIMIR ESTUDIANTES SIN RESIDENCIA
        s.Listar_estudiantes_sin_residencia();
        System.out.println("");
        
        //IMPRIMIR OTRO ESTUDIANTE POR ID
        System.out.println("IMPRIMIR OTRO ESTUDIANTE POR ID: ID 25");
        System.out.println(s.obtener_datos_por_ID(25) );
        
        //IMPRIMIR ESTUDIANTE POR ID QUE NO EXISTE
        System.out.println("IMPRIMIR  ESTUDIANTE POR ID QUE NO EXISTE: ID 250");
        System.out.println(s.obtener_datos_por_ID(250) );
        
        //PRUEBAS ELIMINAR ESTUDIANTES
        System.out.println("\n--- PRUEBAS DE ELIMINACION ---\n");

        System.out.println("\n--- ESTADO INICIAL ---");
        s.listar_estudiantes_con_residencia();
        System.out.println(" ");
        s.Listar_estudiantes_sin_residencia();
        System.out.println(" ");

        //ELIMINAR ESTUDIANTE CON CUPO (Ej. Maria)
        System.out.println("\n--- ELIMINAR ESTUDIANTE CON CUPO ---");
        s.Eliminar_Estudiante_por_ID(40);
        System.out.println(" ");
        s.listar_estudiantes_con_residencia();
        System.out.println(" ");
        s.Listar_estudiantes_sin_residencia();
        System.out.println(" ");

        //ELIMINAR ESTUDIANTE SIN CUPO (Ej. Juan)
        System.out.println("\n--- ELIMINAR ESTUDIANTE CON CUPO ---");
        s.Eliminar_Estudiante_por_ID(10);
        System.out.println(" ");
        s.listar_estudiantes_con_residencia();
        System.out.println(" ");
        s.Listar_estudiantes_sin_residencia();
        System.out.println(" ");

        //ELIMINAR ESTUDIANTE CON ID INEXISTENTE
        System.out.println("\n--- ELIMINAR ID INEXISTENTE ---");
        s.Eliminar_Estudiante_por_ID(3108);
        System.out.println(" ");
        
        //ELIMINAR Y BUSCAR ESTUDIANTE ELIMINADO POR ID (Ej. Carlos)
        System.out.println("\n--- ELIMINAR Y BUSCAR ---");
        s.Eliminar_Estudiante_por_ID(25);
        System.out.println("RESULTADO: \n " + s.obtener_datos_por_ID(25));
    }   
}

class Estudiante implements Comparable<Estudiante>{
    private int id;
    private String nombre;
    private byte puntajeSE;

    public Estudiante(int id,String nombre, byte puntajeSE){
        this.id=id;
        this.nombre=nombre;
        this.puntajeSE=puntajeSE;
    }

    public int compareTo(Estudiante otro){
        if(this.puntajeSE>otro.puntajeSE){
            return 1;
        }
        else if(this.puntajeSE<otro.puntajeSE){
            return -1;
        }
        else{
            int x=Math.min(this.nombre.length(),otro.nombre.length());
            for(int i=0;i<x;i++){
                char c1=this.nombre.charAt(i);
                char c2=otro.nombre.charAt(i);
                if(c1>c2){
                    return 1;
                }
                else if(c2>c1){
                    return -1;
                }
            }
            return 0;
        }
    }

    public int getId() {
        return id;
    }

    public String getNombre(){
        return nombre;
    }
    
    public byte getPuntajeSE() {
        return puntajeSE;
    }

    public void setPuntajeSE(byte puntajeSE) {
        this.puntajeSE = puntajeSE;
    }
    
    @Override
    public String toString() {
        return "[ID: " + id + " Nombre: " + nombre + " Puntaje socioeconomico: " + puntajeSE + "]";
    }
}
    class Node<T extends Comparable<T>> {
        T data;
        int height;
        Node left;
        Node right;

        Node(T data){
            this.data=data;
            this.height=1;
        }
    }

class AVL<T extends Comparable<T>>{


    private Node root;

    public Node getRoot() {
        return root;
    }
    

    private int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    private int getBalance(Node N) {
        if (N==null)
            return 0;
        return height(N.left)-height(N.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(T data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node node, T data) {
        if(node==null){
            return (new Node(data));
        }
        int cmp = data.compareTo((T)node.data);
        if(cmp < 0){
            node.left = insertRec(node.left, data);
        }
        else if (cmp > 0) {
            node.right = insertRec(node.right, data);
        }
        else {
            return node;
        }
        node.height=1+Math.max(height(node.left),height(node.right));
        int balance=getBalance(node);
        if(balance>1 && data.compareTo((T)node.left.data)<0){
            return rightRotate(node);
        }
        if(balance<-1 && data.compareTo((T)node.right.data)>0){
            return leftRotate(node);
        }
        if(balance>1 && data.compareTo((T)node.left.data)>0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(balance<-1 && data.compareTo((T)node.right.data)<0){
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public boolean search(T data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, T data) {
        if (root==null) return false;
        int cmp=data.compareTo((T)root.data);
        if (cmp==0) return true;
        if (cmp<0) return searchRec(root.left,data);
        return searchRec(root.right,data);
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data+" ");
            inOrderRec(node.right);
        }
    }
    public void delete(T data) {
    root = deleteRec(root, data);
    }

    private Node deleteRec(Node node, T data) {
        if (node == null) return null;

        int cmp = data.compareTo((T) node.data);

        if (cmp < 0) {
            node.left = deleteRec(node.left, data);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, data);
        } else {
            // Nodo encontrado: casos con 0 o 1 hijo
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                // Caso con 2 hijos: reemplazar con el sucesor in-order (mínimo del subárbol derecho)
                Node sucesor = getMinNode(node.right);
                node.data = sucesor.data;
                node.right = deleteRec(node.right, (T) sucesor.data);
            }
        }

        if (node == null) return null;

        // Actualizar altura y rebalancear
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // Rotaciones (mismos 4 casos que en insert)
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);

        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private Node getMinNode(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }    
}


class SISTEMA <T extends Comparable<T>>{
    //ATRIBUTOS
    private int cupos_disponibles;
    private AVL<T> Estudiantes_ordenados_por_Puntaje_SE;
    private Object[] Estudiantes_por_id;
    private LinkedList Estudiantes_con_cupo;
    public static final int ids = 10000;
    private int c;

    //CONSTRUCTOR
    public SISTEMA(int cupos_disponibles) {
        this.cupos_disponibles = cupos_disponibles;
        Estudiantes_por_id = new Object[ids];
        Estudiantes_ordenados_por_Puntaje_SE = new AVL<>();
        Estudiantes_con_cupo =new LinkedList();
        c=cupos_disponibles;
    }
    
    //Metodos para Asignar cupos
    public void Agregar_Estudiante(Estudiante estudiante){
      Estudiantes_ordenados_por_Puntaje_SE.insert((T) estudiante);
      c=cupos_disponibles;
      Asignar_Cupos();
      asignar_ID(estudiante.getId(),(T)estudiante); 
    }
    public void Asignar_numero_de_cupos(int n){
        cupos_disponibles=n;
        c=cupos_disponibles;
        Asignar_Cupos();
    }
    public void Asignar_Cupos(){
      Node root = Estudiantes_ordenados_por_Puntaje_SE.getRoot();
      Estudiantes_con_cupo.EraseALL();
      c = cupos_disponibles; 
      //^^^ ESTA LINEA SE AGREGO PARA QUE DESPUES DE EJECUTAR LA ELIMINACIÓN SE INICIE C CON EL VALOR CORRECTO Y SE RESETEE
      // DE ESTE MODO DESPUES DE ELIMINAR IMPRIMIRÁ BIEN LOS ESTUDIANTES CON RESIDENCIA, PUESTO QUE CUANDO SE LLAMA A ELIMINAR_ESTUDIANTE_POR_ID
      // C NO SE INCIALIZA SINO QUE SE EJECUTA HASTA LLEGAR A 0, A PARTIR DE AHI NO IMPRIME NINGUN ESTUDIANTE CON RESIDENCIA 
      Asignar_CuposREC(root);
    }
    private void Asignar_CuposREC(Node node){
        if(node!=null){
            Asignar_CuposREC(node.left);
            if(c>0){
              Estudiantes_con_cupo.PushFront(node.data);
              c--;
            }
            Asignar_CuposREC(node.right);
        }
    }
    
    //METODOS PARA MODIFICAR ESTUDIANTES
    public void Modificar_puntaje_estudiante(Estudiante estudiante,byte puntaje_nuevo){
        Estudiantes_ordenados_por_Puntaje_SE.delete((T) estudiante);
        estudiante.setPuntajeSE(puntaje_nuevo);
        Agregar_Estudiante(estudiante);
    }
    
    public void Eliminar_Estudiante(Estudiante estudiante){
        Estudiantes_ordenados_por_Puntaje_SE.delete((T) estudiante);
        borrar_ID(estudiante.getId());
        Asignar_Cupos();
    }
    //Listar Estudiantes por puntaje socioeconomico en orden creciente
    public void Listar_por__puntaje_SE(){
        Estudiantes_ordenados_por_Puntaje_SE.inOrder();
    }
    //Listar estudiantes que obtuvieron Residencia
    public void listar_estudiantes_con_residencia(){
        Estudiantes_con_cupo.Imprimir_elementos();
    }
    
    //Listar estudiantes que no obtuvieron Residencia 
    public void Listar_estudiantes_sin_residencia(){
        System.out.println("Estudiantes sin cupo en las residencias estudiantiles");
        
        Estudiante ultimo_estudiante_con_cupo = (Estudiante) Estudiantes_con_cupo.ultimo_elemento_ingresado();
        if(ultimo_estudiante_con_cupo == null){
            Estudiantes_ordenados_por_Puntaje_SE.inOrder();
            return;
        }
        Node root = Estudiantes_ordenados_por_Puntaje_SE.getRoot();
        Listar_estudiantes_sin_residenciaREC(ultimo_estudiante_con_cupo, root);
        System.out.println("");
        }

    private void Listar_estudiantes_sin_residenciaREC(Estudiante estudiante, Node nodo){
        if(nodo!=null){
            Listar_estudiantes_sin_residenciaREC(estudiante,nodo.left);            
            if(nodo.data.compareTo(estudiante) > 0){
                System.out.println(nodo.data+" ");
            } 
            Listar_estudiantes_sin_residenciaREC(estudiante,nodo.right);
            
        }
    }
    
    //METODOS PARA ARRAY DE ID
    private void asignar_ID(int index,T item){
        Estudiantes_por_id[index]=item;
    }
    
    @SuppressWarnings("unchecked")    
    public T obtener_datos_por_ID(int id){
        return Estudiantes_por_id[id]!=null ? (T)Estudiantes_por_id[id] : null;
    }
    
    private void borrar_ID(int id_Estudiante){
       Estudiantes_por_id[id_Estudiante]=null;
    }

    //METODO PARA ELIMINAR POR ID
    public void Eliminar_Estudiante_por_ID(int id){
        T estudiante = obtener_datos_por_ID(id);
    if (estudiante != null) {
        Estudiantes_ordenados_por_Puntaje_SE.delete(estudiante);
        borrar_ID(id);
        Asignar_Cupos();
        System.out.println("Estudiante con ID " + id + " eliminado correctamente: \n" + estudiante.toString());
    } else {
        System.out.println("No existe ningún estudiante con ID " + id);
    }
    }
}

class LinkedList<T>  {
    private class Nodo<T>{
        T valor;
        Nodo next;
        Nodo(T data){
            valor=data;
        }
    }
    public Nodo<T>head;
    
  public void LinkedList(){
      head=null;
  }
  
  public void PushFront(T valor){
    Nodo<T> nodo = new Nodo<T>(valor);
    if(isEmpty()){
        head=nodo;
    }
    else{
        nodo.next=head;
        head=nodo;
    }
 }
  
  public void PushBack(T valor){
    Nodo<T> nodo = new Nodo<T>(valor);
      if(isEmpty()){
        head=nodo;
    }
    else{
        Nodo<T> var = head;
        while(var.next!=null){
            var=var.next;
        }
        var.next=nodo;
    }
}
  
  public void PopFront(){
    if(!isEmpty()){
        head=head.next;
    }
}
  
  public void PopBack(){
    if(!isEmpty()){
        Nodo<T> var = head;
        if(head.next==null){
            head=null;
        }
        else{
            while(var.next.next!=null){
              var=var.next;
            }
        }
        var.next=null;
    }
}
  
  public Nodo Find(T valor){
    Nodo<T> var = head;
    if(!isEmpty()){
        while(var.next!=null){
            if(var.valor==valor){
                return var;
            }
            var=var.next;
        }
        return null;
    }
    else{
        return null;
    }
}
  
  public void Erase(T valor){
    Nodo<T> var = head;
    if(!isEmpty()){
        if(head.valor == valor){
            if(head.next==null){
                head=null;
            }
            else{
                head=head.next;
            }
        }
        else if(head.next!=null){
          while(var.next.next!=null){
            if(var.next.valor==valor){
                var.next=var.next.next;
                return;
            }
          }
        }
    } 
    
}
  
  public void AddBefore(Nodo nodo, T valor){
    if(Find((T) nodo.valor)!=null){
      Nodo<T> var = head;
      if(head.valor == nodo.valor){
          nodo.next=head;
          head=nodo;
      }
      else{
          while(var.next!=null){
              if(var.next==nodo){
                Nodo<T> nuevo = new Nodo<T>(valor);
                nuevo.next= var.next;
                var.next=nuevo;
              }
          }
      }
    } 
}
  
  public void AddAfter(Nodo nodo,T valor){
      Nodo<T> nuevo = new Nodo<T>(valor);
      nuevo.next=nodo.next;
      nodo.next=nuevo;
}
  
  public boolean isEmpty(){
    return head==null;
   }
  public void Imprimir_elementos(){
      Nodo nodo= head;
      System.out.println("Estudiantes que obtuvieron cupo en las residencias estudiantiles");
      while(nodo!=null){
          System.out.print(nodo.valor+" ");
          nodo=nodo.next;
      }
      System.out.println("");
  }
  
  public T ultimo_elemento_ingresado(){
      return head!=null ? head.valor: null;
  }
  public void EraseALL(){
      head=null;
  }
}

class ArrayDinamico<T extends Comparable<T>>{
    public Object [] Array; 
    public int c= 10;
    public int size; 
    int r;
    //public int capacity;
    public  ArrayDinamico(){
        Array = new Object[c];
        size=0;
        r=size;
    }
    
    public  ArrayDinamico(int q){
        Array = new Object[q];
        c=q;
        size=0;
    }
    //PRIMERA VERSION PARA shitfUp
    public void set(T valor, int i){
        if(i<c){
            Array[i]= valor;
        }
    }
    
    //Segunda version para ShifDown
    public void set(int i){
        size--;
        Array[i]=Array[size];
        Array[size]=null;
       
    }
    private void resize(){
        Object [] copy = new Object[c*2];

        for(int i =0;i<c;i++){
            copy[i]=Array[i];
        }
        Array=copy;
        c*=2;
    }
    
    public void add(T valor){
        if(isFull()){
            resize();
        }
        
        Array[size]= valor;
        size++;
    }
    
    private boolean isFull(){
        return size == Array.length;
    }
    
    public T get(int i){
        if(0<=i && i<size) return (T)Array[i];
        else return null;
    }
    
    public T getID(int i){
        return (T)Array[i];
    }
    
    public int capacity(){
        return Array.length;
    }
    
    public void Imprimir_elementos(){
        for(int j=0;j<size;j++){
            System.out.print(Array[j] +" ");
        }
        System.out.println("");
     }
    public void set_id_val(int i, T val){
        Array[i]=val;
    }
}


/// SISTEMA USANDO HEAPS Y ARRAYLIST CASERO
class SISTEMA_2 <T extends Comparable<T>>{
    //ATRIBUTOS
    private int cupos_disponibles;
    private MaxHeap Estudiantes_ordenados_por_Puntaje_SE;
    private ArrayDinamico Estudiantes_por_id;
    private ArrayDinamico Estudiantes_con_cupo;
    public static final int ids = 10000;
    private int c;

    //CONSTRUCTOR
    public SISTEMA_2(int cupos_disponibles) {
        this.cupos_disponibles = cupos_disponibles;
        Estudiantes_por_id = new ArrayDinamico(ids);
        Estudiantes_ordenados_por_Puntaje_SE = new MaxHeap();
        Estudiantes_con_cupo =new ArrayDinamico();
        c=cupos_disponibles;
    }
    
    //Metodos para Asignar cupos
    public void Agregar_Estudiante(Estudiante estudiante){
      Estudiantes_ordenados_por_Puntaje_SE.add((T) estudiante);
      c=cupos_disponibles;
      Asignar_Cupos();
      asignar_ID(estudiante.getId(),(T)estudiante); 
    }
    public void Asignar_numero_de_cupos(int n){
        cupos_disponibles=n;
        c=cupos_disponibles;
        Asignar_Cupos();
    }
    public void Asignar_Cupos(){
      int size = Estudiantes_ordenados_por_Puntaje_SE.getSize();
      Estudiantes_con_cupo = new ArrayDinamico(Estudiantes_con_cupo.capacity());
      c = cupos_disponibles;
      Estudiantes_ordenados_por_Puntaje_SE.sort();
      int cont=1;
      if(size>=c){
        while(c>0){
            Estudiantes_con_cupo.add(Estudiantes_ordenados_por_Puntaje_SE.getHeap().get(size-cont));
            cont++;
            c--;
           }
       }
      else{
        while(c>0){
            if((size-cont)>=0){
                Estudiantes_con_cupo.add(Estudiantes_ordenados_por_Puntaje_SE.getHeap().get(size-cont));
             }
            else{
                break;
            }
             cont++;
             c--;
           }          
      }
      
      c=cupos_disponibles;
    }

    //METODOS PARA MODIFICAR ESTUDIANTES
    public void Modificar_puntaje_estudiante(Estudiante estudiante,byte puntaje_nuevo){
        Estudiantes_ordenados_por_Puntaje_SE.sort();
        Estudiantes_ordenados_por_Puntaje_SE.Delete(estudiante);
        estudiante.setPuntajeSE(puntaje_nuevo);
        Agregar_Estudiante(estudiante);
    }
    
    public void Eliminar_Estudiante(Estudiante estudiante){
        Estudiantes_ordenados_por_Puntaje_SE.Delete(estudiante);
        borrar_ID(estudiante.getId());
        Asignar_Cupos();
    }
    //Listar Estudiantes por puntaje socioeconomico en orden creciente
    public void Listar_por__puntaje_SE(){
        int size=Estudiantes_ordenados_por_Puntaje_SE.getSize();
        for(int j=size-1;j>=0;j--){
            System.out.print(Estudiantes_ordenados_por_Puntaje_SE.getHeap().get(j) +" ");
            
      }
        System.out.println("");
    }
    //Listar estudiantes que obtuvieron Residencia
    public void listar_estudiantes_con_residencia(){
        Estudiantes_con_cupo.Imprimir_elementos();
    }
    
    //Listar estudiantes que no obtuvieron Residencia 
    public void Listar_estudiantes_sin_residencia(){
        System.out.println("Estudiantes sin cupo en las residencias estudiantiles");
        Estudiantes_ordenados_por_Puntaje_SE.imprimir_heap_desde_int(cupos_disponibles);
        }

    
    //METODOS PARA ARRAY DE ID
    private void asignar_ID(int index,T item){
        Estudiantes_por_id.set_id_val(index,item);
    }
    
    @SuppressWarnings("unchecked")    
    public T obtener_datos_por_ID(int id){
        return Estudiantes_por_id.getID(id)!=null ? (T)Estudiantes_por_id.getID(id) : null;
    }
    
    private void borrar_ID(int id_Estudiante){
       Estudiantes_por_id.set_id_val(id_Estudiante,null); 
    }

    //METODO PARA ELIMINAR POR ID
    public void Eliminar_Estudiante_por_ID(int id){
        T estudiante = obtener_datos_por_ID(id);
    if (estudiante != null) {
        Estudiantes_ordenados_por_Puntaje_SE.Delete(estudiante);
        borrar_ID(id);
        Asignar_Cupos();
        System.out.println("Estudiante con ID " + id + " eliminado correctamente: \n" + estudiante.toString());
    } else {
        System.out.println("No existe ningun estudiante con ID " + id);
    }
    }
}




class MaxHeap<T extends Comparable <T>>{
    /*ATRIBUTOS 
    SIZE REPRESENTA EL TAMAÑO ACTUAL Y MAXIMO DEL ARRAY
    Heap es nuestro array dinamico casero
    */
    private int size;
    private ArrayDinamico heap;
    
    
    public  MaxHeap(){
        heap = new ArrayDinamico();
        size=0;
    }
    
    public void add(T valor){
        heap.add(valor);
        shiftUp(heap.size-1);
        size++;
    }
    //SORT ORDENARA EN ASCENDENTE USANDO SHIFT UP COMO BASE PRINCIPAL, SE PARTE DE QUE YA SE TIENE UN HEAP 
    public void sort(){
        int capacity = heap.capacity();
        ArrayDinamico heap_ordenado= new ArrayDinamico(capacity );
        int g= heap.size;
        while(heap.size>0){
            heap_ordenado.add(getMax(0));
        }
        heap.size=g;
        for(int j=0;j<heap.size;j++){
            heap.set(heap_ordenado.get(j), j);
        }
        
        //heap.size=heap_ordenado.size;
        
    }
    
    public T getMax(int i){
        T max =(T)heap.get(i); 
        heap.set(i);
        //size--;
        shiftDown(i);
        return max;
    }
    
    private int getParent(int i){
        return i%2==0 ? i/2 : (i-1)/2;
    }
    
    private void Swap(int i,int j){
        T temp = (T) heap.get(j);
        heap.set(heap.get(i),j);
        heap.set(temp, i);
    }
    
    private void shiftUp(int i){
        while(i!=0){
            int parent = getParent(i);
            if( heap.get(i).compareTo(heap.get(parent))>0){
                Swap(i,parent);
                i=parent;
            }
            else{
                break;
            }
        }
    }
    
    private void shiftDown(int i){
        if(heap.size==1) return;
        while(i<heap.size){
            String l = "a";
            String r = "a";
            int lson= (i+1)*2 -1;
            int rson = (i+1)*2;
            if(lson<heap.size){
              if(heap.get(i).compareTo(heap.get(lson))<0){
                  l="l";
              }
            }
            if(rson<heap.size){
               if(heap.get(i).compareTo(heap.get(rson))<0){
                  r="r";
              }
            }
            
            if(l=="l" && r=="r"){
                if(heap.get(rson).compareTo(heap.get(lson))>0){
                    Swap(i,rson);
                    i=rson;
                }
                else{
                    Swap(i,lson);
                    i=lson;
                }
                
            }
            
            else if(l=="l" && r!="r"){
                Swap(i,lson);
                i=lson;
            }
            
            else if(l!="l" && r=="r"){
                Swap(i,rson);
                i=rson;
            }
            else{
                break;
            }
            
        
        }
    }
    
    public void imprimir_heap_desde_int(int i){
        for(int j=heap.size-i-1;j>=0;j--){
            System.out.print(heap.get(j)+" ");
        }
        System.out.println("");
    }
    
    public void Delete(T T){
        int low = 0;
        int high = heap.size -1;
        
        int u = low+ (high-low)/2;
       T temp = (T)heap.get(u);
       while(T.compareTo(temp)!=0){
           if(T.compareTo(temp)<0){
               low=u+1;
               u = low+ (high-low)/2;
               temp=(T)heap.get(u);
           }
           else{
               high= u-1;
               u = low+ (high-low)/2;
               temp=(T)heap.get(u);               
           }
       }
       getMax(u);
    }
    
    public int getSize(){
        return heap.size;
    }
    
    public ArrayDinamico getHeap(){
        return heap;
    }
   
    
}