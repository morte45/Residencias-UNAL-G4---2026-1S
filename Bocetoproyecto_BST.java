public class Bocetoproyecto_BST {
    public static void main(String[] args) {
       
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
        return node;
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            if (!SISTEMA.silenciar) System.out.print(node.data+" ");
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
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                Node sucesor = getMinNode(node.right);
                node.data = sucesor.data;
                node.right = deleteRec(node.right, (T) sucesor.data);
            }
        }
        return node;
    }

    private Node getMinNode(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }    
}

class SISTEMA <T extends Comparable<T>>{
    private int cupos_disponibles;
    private BST<T> Estudiantes_ordenados_por_Puntaje_SE;
    private HashTableP Estudiantes_con_cupo;
    private HashTableP Estudiantes_por_id;
    private int c;

    public SISTEMA(int cupos_disponibles) {
        this.cupos_disponibles = cupos_disponibles;
        Estudiantes_por_id = new HashTableP();
        Estudiantes_ordenados_por_Puntaje_SE = new BST<>();
        Estudiantes_con_cupo =new HashTableP();
        c = cupos_disponibles;
    }
    
    @SuppressWarnings("unchecked")
    public void Agregar_Estudiante(Estudiante estudiante){
        if (estudiante.getId() < ids && estudiante.getId() >= 0) {
            Estudiantes_ordenados_por_Puntaje_SE.insert((T) estudiante);
            c = cupos_disponibles;
            Asignar_Cupos();
            asignar_ID(estudiante.getId(), (T)estudiante);
        }
    }
    
    public void Asignar_numero_de_cupos(int n){
        cupos_disponibles = n;
        c = cupos_disponibles;
        Asignar_Cupos();
    }
    
    public void Asignar_Cupos(){
        Node root = Estudiantes_ordenados_por_Puntaje_SE.getRoot();
        Estudiantes_con_cupo.EraseALL();
        c = cupos_disponibles;
        Asignar_CuposREC(root);
    }
    
    @SuppressWarnings("unchecked")
    private void Asignar_CuposREC(Node node){
        if(node != null){
            Asignar_CuposREC(node.left);
            if(c > 0){
                Estudiantes_con_cupo.pushBack((T)node.data);
                c--;
            }
            Asignar_CuposREC(node.right);
        }
    }
    
    public void Modificar_puntaje_estudiante(Estudiante estudiante, byte puntaje_nuevo){
        Estudiantes_ordenados_por_Puntaje_SE.delete((T) estudiante);
        estudiante.setPuntajeSE(puntaje_nuevo);
        Agregar_Estudiante(estudiante);
    }
    
    @SuppressWarnings("unchecked")
    public void Eliminar_Estudiante(Estudiante estudiante){
        Estudiantes_ordenados_por_Puntaje_SE.delete((T) estudiante);
        borrar_ID(estudiante.getId());
        Asignar_Cupos();
    }
    
    public void Listar_por__puntaje_SE(){
        Estudiantes_ordenados_por_Puntaje_SE.inOrder();
    }
    
    public void listar_estudiantes_con_residencia(){
        Estudiantes_con_cupo.Imprimir_elementos();
    }
    
    public void Listar_estudiantes_sin_residencia(){
        if (!silenciar) System.out.println("Estudiantes sin cupo en las residencias estudiantiles");
        Estudiante ultimo_estudiante_con_cupo = (Estudiante) Estudiantes_con_cupo.ultimo_elemento_ingresado();
        if(ultimo_estudiante_con_cupo == null){
            Estudiantes_ordenados_por_Puntaje_SE.inOrder();
            return;
        }
        Node root = Estudiantes_ordenados_por_Puntaje_SE.getRoot();
        Listar_estudiantes_sin_residenciaREC(ultimo_estudiante_con_cupo, root);
        if (!silenciar) System.out.println("");
    }

    @SuppressWarnings("unchecked")
    private void Listar_estudiantes_sin_residenciaREC(Estudiante estudiante, Node nodo){
        if(nodo != null){
            Listar_estudiantes_sin_residenciaREC(estudiante, nodo.left);            
            if(((Estudiante) nodo.data).compareTo(estudiante) > 0){
                if (!silenciar) System.out.println(nodo.data + " ");
            } 
            Listar_estudiantes_sin_residenciaREC(estudiante, nodo.right);
        }
    }
    
    private void asignar_ID(int index, T item) {
    Estudiantes_por_id.add((Estudiante) item);
    }   

    public T obtener_datos_por_ID(int id) {
        return (T) Estudiantes_por_id.getById(id);
    }   

    private void borrar_ID(int id_Estudiante) {
        Estudiantes_por_id.removeById(id_Estudiante);
    }

    public void Eliminar_Estudiante_por_ID(int id){
        T estudiante = obtener_datos_por_ID(id);
        if (estudiante != null) {
            Estudiantes_ordenados_por_Puntaje_SE.delete(estudiante);
            borrar_ID(id);
            Asignar_Cupos();
            if (!silenciar && ids <= 10000) {
                System.out.println("Estudiante con ID " + id + " eliminado correctamente: \n" + estudiante.toString());
            }
        } else {
            if (!silenciar && ids <= 10000) {
                System.out.println("No existe ningun estudiante con ID " + id);
            }
        }
    }
}
class HashTableP{
	
	
    @SuppressWarnings("unchecked")
	private LinkedList<Estudiante>[] main = new LinkedList[1];
	private int size = 0;
	private int capacity = 1;
	private double loadFactorThreshold = 1;
	private Estudiante lastAdded;
	
	private int hash(int key) {
		//Byte Hashing simple
		int scrambled = key ^ (key >>> 16);
	    return (scrambled & 0x7FFFFFFF) & (capacity-1);
	}
	
	public void add(Estudiante valor) {
		if (getCurrentLoadFactor() >= loadFactorThreshold) resize();
		
		int hashKey = hash(valor.getId());
		if (main[hashKey] == null) {
			main[hashKey] = new LinkedList();
		}
		main[hashKey].PushFront(valor);
		lastAdded = valor;
		size++;
	}
	
	public void remove(Estudiante valor){
		int hashKey = hash (valor.getId());
		if (main[hashKey] != null) {
			main[hashKey].Erase(valor);
		}
	}
	
	public boolean contains(Estudiante valor) {
		int hashKey = hash(valor.getId());
		
		if (main[hashKey] == null) return false;
		if (main[hashKey].Find(valor) !=null) return true;
		return false;
	}
	
	private void resize() {
		capacity*=2;
		
		LinkedList<Estudiante>[] a = main;
		LinkedList<Estudiante>[] b = new LinkedList[capacity]; //Crear un array con capacidad aumentada
		for (int i = 0; i < a.length; i++) {
			
			if(a[i]!=null) {
				while (!a[i].isEmpty()) {
					Estudiante current = a[i].PopFront();
					int hashKey = hash(current.getId());
					if(b[hashKey] == null) b[hashKey] = new LinkedList();
					b[hashKey].PushFront(current);
				}
			}
		}
		
		main = b;
	}
	
	public int getCurrentLoadFactor() {
		return size/capacity;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void Imprimir_elementos(){
		System.out.println("Estudiantes que obtuvieron cupo en las residencias estudiantiles");
		for (int i = 0; i < capacity; i++) {
			if (main[i] != null && !main[i].isEmpty()) {
				main[i].Imprimir_elementos();
			}
		}
	}
	  
	@SuppressWarnings("unchecked")
	public Estudiante ultimo_elemento_ingresado(){
		return lastAdded;
	}
	public void EraseALL(){
		main = new LinkedList[1];
		capacity = 1;
		size = 0;
	}

    public Estudiante getById(int id) {
    int hashKey = hash(id);
    if (main[hashKey] == null) return null;
    return main[hashKey].findById(id);
    }

    public void removeById(int id) {
        int hashKey = hash(id);
        if (main[hashKey] != null) {
            main[hashKey].eraseById(id);
            size--;
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
    private Nodo<T>head;
    
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
  
    public T PopFront(){
    	T pop;
    	if(!isEmpty()){
    		pop = head.valor;
    		head=head.next;
    		return pop;
    	}
    	return null;
    }
  
    public T PopBack(){
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
    		T pop = (T)var.next.valor;
    		var.next=null;
    		return (T)pop;
    	}
    	return null;
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
    	//System.out.println("Estudiantes que obtuvieron cupo en las residencias estudiantiles");
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

    public T findById(int id) {
    Nodo<T> var = head;
    while (var != null) {
        Estudiante e = (Estudiante) var.valor;
        if (e.getId() == id) return (T) e;
        var = var.next;
    }
    return null;
    }

    public void eraseById(int id) {
    if (isEmpty()) return;

    if (((Estudiante) head.valor).getId() == id) {
        head = head.next;
        return;
    }

    Nodo<T> var = head;
    while (var.next != null) {
        if (((Estudiante) var.next.valor).getId() == id) {
            var.next = var.next.next;
            return;
        }
        var = var.next;
    }
}
}
