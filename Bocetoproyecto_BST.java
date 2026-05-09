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
    public void Modificar_puntaje_estudiante(Estudiante estudiante,byte puntaje_nuevo){
        Estudiantes_ordenados_por_Puntaje_SE.delete((T) estudiante);
        estudiante.setPuntajeSE(puntaje_nuevo);
        Agregar_Estudiante(estudiante);
    }
    
    @SuppressWarnings("unchecked")
	public void Eliminar_Estudiante(Estudiante estudiante){
        Estudiantes_ordenados_por_Puntaje_SE.delete((T) estudiante);
        //borrar_ID(estudiante.getId()); TODO
        Asignar_Cupos();
    }
    //Listar Estudiantes por puntaje socioeconomico en orden creciente
    public void Listar_por__puntaje_SE(){
        Estudiantes_ordenados_por_Puntaje_SE.inOrder();
    }
    
} 

class ArrayListP<T extends Comparable<T>> {
    private Object[] main = new Object[1];
    private int size = 0;
    
    private void resize() {
        Object[] a = main;
        Object[] b = new Object[size * 2];
        for (int i = 0; i < main.length; i++) {
            b[i] = a[i];
        }
        main = b;
    }
    
    public void pushFront(T valor){
        if (size == main.length) resize();
        for (int i = size-1; i >= 0; i--) {
            main[i+1] = main[i];
        }
        main[0] = valor;
        size++;
    }
  
    public void pushBack(T valor){
        if(size == main.length) resize();
        main[size] = valor;
        size++;
    }
  
    public void popFront(){
        for (int i = 0; i < size-1; i++) {
            main[i] = main[i+1];
        }
        main[size-1] = null;
        size--;
    }
  
    public void popBack(){
        main[size-1] = null;
        size--;
    }
  
    public int find(T valor){
        int index = -1;
        for(int i = 0; i < size; i++) {
            @SuppressWarnings("unchecked")
            T cmp = (T)main[i];
            if(valor.compareTo(cmp) == 0) {
                index = i; 
                break;
            }
        }
        return index;
    }
  
    public void remove(T valor){
        int index = 0; 
        for (int i = 0; i < size; i++) {
            @SuppressWarnings("unchecked")
            T cmp = (T)main[i];
            if(valor.compareTo(cmp) == 0) {
                index = i;
                for (int j = index; j < size-1; j++) {
                    main[j] = main[j+1];
                }
                main[size-1] = null;
                size--;
                break;
            }
        }
    }
  
    public void add(int index, T valor){
        if(size == main.length) resize();
        for (int i = size-1; i >= index; i--) {
            main[i+1] = main[i];
        }
        main[index] = valor;
        size++;
    }
  
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void Imprimir_elementos(){
        if (!SISTEMA.silenciar) System.out.println("Estudiantes que obtuvieron cupo en las residencias estudiantiles");
        for (int i = 0; i < size; i++) {
            if (!SISTEMA.silenciar) System.out.println(main[i]);
        }
    }
      
    @SuppressWarnings("unchecked")
    public T ultimo_elemento_ingresado(){
        T last = null;
        if(size >= 1) {
            last = (T) main[size-1];
        }
        return last;
    }
    
    public void EraseALL(){
        main = new Object[1];
        size = 0;
    }
}
