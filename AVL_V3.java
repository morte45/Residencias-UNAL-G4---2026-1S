
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
        
        SISTEMA s = new SISTEMA(3);
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

        //PRUEBAS ELIMINAR ESTUDIANTE
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
        return "[ID:" + id + " Nombre:" + nombre + " Puntaje socioeconomico:" + puntajeSE + "]";
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
        Estudiantes_ordenados_por_Puntaje_SE.delete();
        estudiante.setPuntajeSE(puntaje_nuevo);
        Agregar_Estudiante(estudiante);
    }
    
    public void Eliminar_Estudiante(Estudiante estudiante){
        Estudiantes_ordenados_por_Puntaje_SE.delete();
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
        Estudiante  estudiante = (Estudiante) Estudiantes_con_cupo.ultimo_elemento_ingresado();
        Node root = Estudiantes_ordenados_por_Puntaje_SE.getRoot();
        System.out.println("Estudiantes sin cupo en las residencias estudiantiles");
        Listar_estudiantes_sin_residenciaREC(estudiante,root);
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
