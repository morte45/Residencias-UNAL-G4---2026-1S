
package com.mycompany.bocetoproyecto;

public class Bocetoproyecto{
    public static void main(String[] args){
        AVL<Estudiante> arbol = new AVL<>();

        arbol.insert(new Estudiante(10, "Juan", (byte) 85));
        arbol.insert(new Estudiante(20, "Ana", (byte) 90));
        arbol.insert(new Estudiante(30, "Pedro", (byte) 75));
        arbol.insert(new Estudiante(40, "Maria", (byte) 95));
        arbol.insert(new Estudiante(50, "Luis", (byte) 80));
        arbol.insert(new Estudiante(25, "Carlos", (byte) 88)); 

        System.out.println("\n--- Recorrido In-Order ---");
        arbol.inOrder();
    }
}

class Estudiante implements Comparable<Estudiante>{
    int id;
    String nombre;
    byte puntajeSE;

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

    @Override
    public String toString() {
        return "[ID:" + id + " Nombre:" + nombre + " Puntaje socioeconomico:" + puntajeSE + "]";
    }
}
    class Node<T> {
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
}

//Falta poder eliminar elementos

class SISTEMA <T extends Comparable<T>>{
    //ATRIBUTOS
    private int cupos_disponibles;
    private AVL<T> Estudiantes_ordenados_por_Puntaje_SE = new AVL<>();
    private int [] Estudiantes_por_id = new int [ids];
    private LinkedList Estudiantes_con_cupo;
    public static final int ids = 10000;

 
    
    public void Agregar_Estudiante(T estudiante){
      Estudiantes_ordenados_por_Puntaje_SE.insert(estudiante);
      
    }
    
    public void Asignar_Cupos(){
      Node root = Estudiantes_ordenados_por_Puntaje_SE.getRoot();
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
  
}
