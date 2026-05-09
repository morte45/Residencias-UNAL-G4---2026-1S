public class Bocetoproyecto_BST {
    public static void main(String[] args) {
       
    }
}

class AnalizadorRendimiento {

    private static StringBuilder salida = new StringBuilder();

    private static void log(String texto) {
        salida.append(texto).append("\n");
    }

    public static void medirLectura(int size, String method,
                                     java.util.function.Function<Integer, SISTEMA> systemSupplier,
                                     java.util.function.Consumer<SISTEMA> operation) {

        int reps = 500;
        SISTEMA sistema = systemSupplier.apply(size);

        for (int i = 0; i < 20; i++) {
            operation.accept(sistema);
        }

        long start = System.nanoTime();

        for (int i = 0; i < reps; i++) {
            operation.accept(sistema);
        }

        long finish = System.nanoTime();

        double nanos = (double)(finish - start) / reps;

        if (nanos >= 1_000_000) {

            salida.append(String.format(
                    "  %-35s N=%-8d >> %10.3f ms (promedio de %d reps)%n",
                    method, size, nanos / 1_000_000, reps));

        } else if (nanos >= 1_000) {

            salida.append(String.format(
                    "  %-35s N=%-8d >> %10.2f us (promedio de %d reps)%n",
                    method, size, nanos / 1_000, reps));

        } else {

            salida.append(String.format(
                    "  %-35s N=%-8d >> %10.2f ns (promedio de %d reps)%n",
                    method, size, nanos, reps));
        }
    }

    public static void medirEscritura(int size, String method,
                                       java.util.function.Function<Integer, SISTEMA> systemSupplier,
                                       java.util.function.Consumer<SISTEMA> operation) {

        int reps = 30;
        long tiempoTotal = 0;
        int exitos = 0;

        for (int rep = 0; rep < reps; rep++) {

            SISTEMA sistema = systemSupplier.apply(size);

            if (rep % 10 == 0 && rep > 0) {
                System.gc();

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {}
            }

            long start = System.nanoTime();

            operation.accept(sistema);

            long finish = System.nanoTime();

            tiempoTotal += (finish - start);
            exitos++;
        }

        double nanos = (double) tiempoTotal / exitos;

        if (nanos >= 1_000_000) {

            salida.append(String.format(
                    "  %-35s N=%-8d >> %10.3f ms (promedio de %d reps)%n",
                    method, size, nanos / 1_000_000, exitos));

        } else if (nanos >= 1_000) {

            salida.append(String.format(
                    "  %-35s N=%-8d >> %10.2f us (promedio de %d reps)%n",
                    method, size, nanos / 1_000, exitos));

        } else {

            salida.append(String.format(
                    "  %-35s N=%-8d >> %10.2f ns (promedio de %d reps)%n",
                    method, size, nanos, exitos));
        }
    }

    private static SISTEMA construirSistema(int n) {

        SISTEMA sistema = new SISTEMA(100);

        for (int i = 0; i < n; i++) {

            byte puntaje = (byte) (i % 101);

            sistema.Agregar_Estudiante(
                    new Estudiante(i + 1, "E" + i, puntaje));
        }

        return sistema;
    }

    private static SISTEMA construirSistemaParaInsercion(int nFinal) {
        return construirSistema(nFinal - 1);
    }

    public static void ejecutarAnalisis() {

        int[] tamanios = {100, 500, 1000, 5000, 10000};

        log("");
        log("================================================================");
        log("         ANALISIS DE RENDIMIENTO - SISTEMA BST");
        log("================================================================");
        log("NOTA: Los datos se insertan en ORDEN CRECIENTE");
        log("      El BST se comporta como lista enlazada");
        log("");

        for (int n : tamanios) {

            log(String.format("==> N = %,d estudiantes", n));
            log("----------------------------------------------------------------");

            try {

                final int tamanoActual = n;

                medirLectura(
                        tamanoActual,
                        "obtener_datos_por_ID",
                        (tam) -> construirSistema(tam),
                        (sistema) -> sistema.obtener_datos_por_ID(tamanoActual / 2)
                );

                medirLectura(
                        tamanoActual,
                        "Listar_por_puntaje_SE",
                        (tam) -> construirSistema(tam),
                        (sistema) -> {
                            SISTEMA.silenciar = true;
                            sistema.Listar_por__puntaje_SE();
                            SISTEMA.silenciar = false;
                        }
                );

                medirLectura(
                        tamanoActual,
                        "listar_estudiantes_con_residencia",
                        (tam) -> construirSistema(tam),
                        (sistema) -> {
                            SISTEMA.silenciar = true;
                            sistema.listar_estudiantes_con_residencia();
                            SISTEMA.silenciar = false;
                        }
                );

                medirLectura(
                        tamanoActual,
                        "Listar_estudiantes_sin_residencia",
                        (tam) -> construirSistema(tam),
                        (sistema) -> {
                            SISTEMA.silenciar = true;
                            sistema.Listar_estudiantes_sin_residencia();
                            SISTEMA.silenciar = false;
                        }
                );

                medirEscritura(
                        tamanoActual,
                        "Agregar_Estudiante",
                        (tam) -> construirSistemaParaInsercion(tam),
                        (sistema) -> {
                            Estudiante nuevo =
                                    new Estudiante(tamanoActual, "Nuevo", (byte) 50);

                            sistema.Agregar_Estudiante(nuevo);
                        }
                );

                medirEscritura(
                        tamanoActual,
                        "Eliminar_Estudiante_por_ID",
                        (tam) -> construirSistema(tam),
                        (sistema) ->
                                sistema.Eliminar_Estudiante_por_ID(tamanoActual)
                );

                medirEscritura(
                        tamanoActual,
                        "Asignar_numero_de_cupos",
                        (tam) -> construirSistema(tam),
                        (sistema) ->
                                sistema.Asignar_numero_de_cupos(500)
                );

                log("");

            } catch (OutOfMemoryError e) {

                log(String.format(
                        "ERROR: OutOfMemoryError para N = %,d", n));

                break;

            } catch (StackOverflowError e) {

                log(String.format(
                        "ERROR: StackOverflowError para N = %,d", n));

                break;
            }
        }

        log("================================================================");

        System.out.println(salida.toString());
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
    private Object[] Estudiantes_por_id;
    private ArrayListP Estudiantes_con_cupo;
    public static final int ids = 10000000;
    private int c;
    public static boolean silenciar = false;

    public SISTEMA(int cupos_disponibles) {
        this.cupos_disponibles = cupos_disponibles;
        Estudiantes_por_id = new Object[ids];
        Estudiantes_ordenados_por_Puntaje_SE = new BST<>();
        Estudiantes_con_cupo = new ArrayListP();
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
    
    private void asignar_ID(int index, T item){
        if(index < ids && index >= 0) Estudiantes_por_id[index] = item;
    }
    
    @SuppressWarnings("unchecked")    
    public T obtener_datos_por_ID(int id){
        return (id < ids && id >= 0 && Estudiantes_por_id[id] != null) ? (T)Estudiantes_por_id[id] : null;
    }
    
    private void borrar_ID(int id_Estudiante){
        if(id_Estudiante < ids && id_Estudiante >= 0) Estudiantes_por_id[id_Estudiante] = null;
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
