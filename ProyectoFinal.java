public class ProyectoFinal {
    public static void main(String[] args){
        SISTEMA sistemaPrin=new SISTEMA(0);
        for (int i = 1; i <= 200; i++) {
            int idAleatorio = 1000 + i; 
            String nombreAleatorio = "Estudiante " + i; 
            byte puntajeAleatorio = (byte) (1 + (int)(Math.random() * 100)); 
            Estudiante prueba = new Estudiante(idAleatorio, nombreAleatorio, puntajeAleatorio);
            sistemaPrin.Agregar_Estudiante(prueba);
        }
        win ventana=new win(sistemaPrin);
        ventana.setVisible(true);
        ventana.Actualizar();
    }
}
