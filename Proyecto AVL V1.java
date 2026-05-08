public class Bocetoproyecto{
  public static void main(String[] args){
  }

  ///////////////Clase Estudiante////////////////////
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

  ///////////////Clase AVL////////////////////
  
}
