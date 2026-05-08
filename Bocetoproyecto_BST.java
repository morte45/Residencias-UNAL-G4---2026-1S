

public class Bocetoproyecto_BST{
    public static void main(String[] args){

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

class BST<T extends Comparable<T>>{


    private Node root;

    public Node getRoot() {
        return root;
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
    private BST<T> Estudiantes_ordenados_por_Puntaje_SE;
    private Object[] Estudiantes_por_id;
    //private ArrayListP Estudiantes_con_cupo; TODO
    public static final int ids = 10000;
    private int c;

 
    
  //CONSTRUCTOR
    public SISTEMA(int cupos_disponibles) {
    	this.cupos_disponibles = cupos_disponibles;
        Estudiantes_por_id = new Object[ids];
        Estudiantes_ordenados_por_Puntaje_SE = new BST<>();
        c=cupos_disponibles;
    }
    
    @SuppressWarnings("unchecked") //Se suprimen advertencias de casting de Objeto a T sin checkear
    //Esto debido a la naturaleza de como se comportan los génericos en Java con el compilador
    
    //Metodos para Asignar cupos
    public void Agregar_Estudiante(Estudiante estudiante){
    	
    	Estudiantes_ordenados_por_Puntaje_SE.insert((T) estudiante);
    	c=cupos_disponibles;
    	Asignar_Cupos();
      	//asignar_ID(estudiante.getId(),(T)estudiante); TODO
    }
    public void Asignar_numero_de_cupos(int n){
        cupos_disponibles=n;
        c=cupos_disponibles;
        Asignar_Cupos();
    }
    public void Asignar_Cupos(){
    	Node root = Estudiantes_ordenados_por_Puntaje_SE.getRoot();
    	//Estudiantes_con_cupo.EraseALL(); TODO
    	c = cupos_disponibles; 
    	//^^^ ESTA LINEA SE AGREGO PARA QUE DESPUES DE EJECUTAR LA ELIMINACIÓN SE INICIE C CON EL VALOR CORRECTO Y SE RESETEE
    	// DE ESTE MODO DESPUES DE ELIMINAR IMPRIMIRÁ BIEN LOS ESTUDIANTES CON RESIDENCIA, PUESTO QUE CUANDO SE LLAMA A ELIMINAR_ESTUDIANTE_POR_ID
    	// C NO SE INCIALIZA SINO QUE SE EJECUTA HASTA LLEGAR A 0, A PARTIR DE AHI NO IMPRIME NINGUN ESTUDIANTE CON RESIDENCIA 
    	Asignar_CuposREC(root);
    }
    
    @SuppressWarnings("unchecked")
	private void Asignar_CuposREC(Node node){
        if(node!=null){
            Asignar_CuposREC(node.left);
            if(c>0){
              //Estudiantes_con_cupo.pushBack((T)node.data); TODO
              c--;
            }
            Asignar_CuposREC(node.right);
        }
    }
    
}    
