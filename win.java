import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

class win extends JFrame{
    private JPanel panel;
    private JButton BotonAgregar;
    private JButton BotonEliminar;
    private JButton BotonActualizar;
    private JButton BotonBuscar;
    private JButton BotonModificarCupos;
    private DefaultTableModel modeloTodos;
    private DefaultTableModel modeloConCupo;
    private DefaultTableModel modeloSinCupo;
    private SISTEMA sistema;

    public win(SISTEMA sistemaRecibido){
        this.sistema=sistemaRecibido;
        this.setSize(1400,1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("AxAxAxA");
        Componentes();
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(1400,1000));
        this.getContentPane().setBackground(Color.pink);
    }
    private void Componentes(){
        colocarPanel();
        colocarEti();
        colocarBoton();
        colocarScroll();
    }
    private void colocarPanel(){
        panel=new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);
        this.add(panel);  
    }
    private void colocarScroll(){
        String[] columnas = {"ID", "Nombre", "Puntaje Socioeconómico"};
        modeloTodos=new DefaultTableModel(columnas,0);
        modeloConCupo=new DefaultTableModel(columnas, 0);
        modeloSinCupo=new DefaultTableModel(columnas, 0);

        JTable Todos=new JTable(modeloTodos);
        JScrollPane barraBajar=new JScrollPane(Todos);
        barraBajar.setBounds(40, 200, 400, 600); 
        panel.add(barraBajar);

        JTable ConCupo=new JTable(modeloConCupo);
        JScrollPane barraBajar2=new JScrollPane(ConCupo);
        barraBajar2.setBounds(490, 200, 400, 600); 
        panel.add(barraBajar2);

        JTable SinCupo=new JTable(modeloSinCupo);
        JScrollPane barraBajar3=new JScrollPane(SinCupo);
        barraBajar3.setBounds(940, 200, 400, 600); 
        panel.add(barraBajar3);
    }
    private void colocarEti(){
        JLabel eti= new JLabel();
        eti.setText("Sistema de Asignación de Cupos");
        eti.setOpaque(true);
        eti.setHorizontalAlignment(JLabel.LEFT);
        eti.setBackground(Color.pink);
        eti.setForeground(Color.black);
        eti.setBounds(75,0,1300,100);
        eti.setFont(new Font("XXX",Font.ROMAN_BASELINE,50));
        panel.add(eti);

        ImageIcon unalImage=new ImageIcon("logo unal.png");
        JLabel unal=new JLabel();
        unal.setBounds(0, 0, 75, 100);
        Icon unalIcon=new ImageIcon(
            unalImage.getImage().getScaledInstance(unal.getWidth(), unal.getHeight(), Image.SCALE_SMOOTH)
        );
        unal.setIcon(unalIcon);
        panel.add(unal);

        JLabel eti0= new JLabel();
        eti0.setText("Estudiantes");
        eti0.setOpaque(true);
        eti0.setBackground(Color.pink);
        eti0.setForeground(Color.black);
        eti0.setHorizontalAlignment(JLabel.CENTER);
        eti0.setFont(new Font("XXX",Font.ROMAN_BASELINE,30));
        eti0.setBounds(40,150,400,50);
        panel.add(eti0);

        JLabel eti2= new JLabel();
        eti2.setText("Estudiantes Con Cupo");
        eti2.setOpaque(true);
        eti2.setBackground(Color.pink);
        eti2.setForeground(Color.black);
        eti2.setHorizontalAlignment(JLabel.CENTER);
        eti2.setFont(new Font("XXX",Font.ROMAN_BASELINE,30));
        eti2.setBounds(490,150,400,50);
        panel.add(eti2);

        JLabel eti3= new JLabel();
        eti3.setText("Estudiantes Sin Cupo");
        eti3.setOpaque(true);
        eti3.setBackground(Color.pink);
        eti3.setForeground(Color.black);
        eti3.setHorizontalAlignment(JLabel.CENTER);
        eti3.setFont(new Font("XXX",Font.ROMAN_BASELINE,30));
        eti3.setBounds(940,150,400,50);
        panel.add(eti3);
    }
    private void colocarBoton(){
        BotonAgregar=new JButton("Agregar Estudiante");
        BotonAgregar.setBackground(Color.pink);
        BotonAgregar.setForeground(Color.black);
        BotonAgregar.setBounds(215, 850, 200, 50);
        BotonAgregar.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        BotonAgregar.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        panel.add(BotonAgregar);

        BotonEliminar=new JButton("Eliminar Estudiante");
        BotonEliminar.setBackground(Color.pink);
        BotonEliminar.setForeground(Color.black);
        BotonEliminar.setBounds(465, 850, 200, 50);
        BotonEliminar.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        BotonEliminar.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        panel.add(BotonEliminar);

        BotonBuscar=new JButton("Buscar Estudiante");
        BotonBuscar.setBackground(Color.pink);
        BotonBuscar.setForeground(Color.black);
        BotonBuscar.setBounds(715, 850, 200, 50);
        BotonBuscar.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        BotonBuscar.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        panel.add(BotonBuscar);

        BotonModificarCupos=new JButton("Modificar Cupos");
        BotonModificarCupos.setBackground(Color.pink);
        BotonModificarCupos.setForeground(Color.black);
        BotonModificarCupos.setBounds(965, 850, 200, 50);
        BotonModificarCupos.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        BotonModificarCupos.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        panel.add(BotonModificarCupos);
        
        listenerAgregar();
        listenerEliminar();
        listenerBuscar();
        listenerCupos();
    }
    public void Actualizar(){
        modeloTodos.setRowCount(0);
        modeloConCupo.setRowCount(0);
        modeloSinCupo.setRowCount(0);
        LinkedList<Estudiante> c=sistema.Estudiantes();
        while(!c.isEmpty()){
            Estudiante es=c.PopFront(); 
            modeloTodos.addRow(new Object[]{es.getId(), es.getNombre(), es.getPuntajeSE()});
        }

        LinkedList<Estudiante> a=sistema.EstudiantesConCupo();
        while(!a.isEmpty()){
            Estudiante es=a.PopFront(); 
            modeloConCupo.addRow(new Object[]{es.getId(), es.getNombre(), es.getPuntajeSE()});
        }
        LinkedList<Estudiante> b=sistema.EstudiantesSinCupo();
        while(!b.isEmpty()){
            Estudiante es=b.PopFront(); 
            modeloSinCupo.addRow(new Object[]{es.getId(), es.getNombre(), es.getPuntajeSE()});
        }
    }
    private void listenerAgregar(){
        ActionListener agregar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAgregar a=new ventanaAgregar(sistema,win.this);
                a.setVisible(true);
            }
        };
        BotonAgregar.addActionListener(agregar);
    }
    private void listenerEliminar(){
        ActionListener eliminar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaEliminar b=new ventanaEliminar(sistema,win.this);
                b.setVisible(true);
            }
        };
        BotonEliminar.addActionListener(eliminar);
    }
    private void listenerBuscar(){
        ActionListener buscar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaBuscar c=new ventanaBuscar(sistema,win.this);
                c.setVisible(true);
            }
        };
        BotonBuscar.addActionListener(buscar);
    }
    private void listenerCupos(){
        ActionListener cupos=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaCupos d=new ventanaCupos(sistema,win.this);
                d.setVisible(true);
            }
        };
        BotonModificarCupos.addActionListener(cupos);
    }
}

class ventanaAgregar extends JFrame{
    private JPanel panel;
    private JButton BotonAgregar;
    private JButton BotonCancelar;
    private JTextField nombre;
    private JTextField id;
    private JTextField puntajeSE;
    private SISTEMA sistema;
    private win ventanaMain;

    public ventanaAgregar(SISTEMA sistemaRecibido,win ventanaMainRecibida){
        this.sistema=sistemaRecibido;
        this.ventanaMain=ventanaMainRecibida;
        this.setSize(500,500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Agregar Estudiante");
        Componentes();
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(500,500));
        this.getContentPane().setBackground(Color.pink);
    }
    private void Componentes(){
        colocarPanel();
        colocarEti();
        colocarBoton();
        colocarCajasTexto();
    }
    private void colocarPanel(){
        panel=new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);
        this.add(panel);  
    }
    private void colocarEti(){
        JLabel eti= new JLabel();
        eti.setText("Datos del nuevo estudiante:");
        eti.setOpaque(true);
        eti.setHorizontalAlignment(JLabel.LEFT);
        eti.setBackground(Color.pink);
        eti.setForeground(Color.black);
        eti.setBounds(0,0,600,60);
        eti.setFont(new Font("XXX",Font.ROMAN_BASELINE,30));
        panel.add(eti);

        JLabel id= new JLabel();
        id.setText("ID");
        id.setOpaque(true);
        id.setHorizontalAlignment(JLabel.CENTER);
        id.setBackground(Color.white);
        id.setForeground(Color.black);
        id.setBounds(50,100,100,30);
        id.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        id.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        panel.add(id);

        JLabel nombre= new JLabel();
        nombre.setText("Nombre");
        nombre.setOpaque(true);
        nombre.setHorizontalAlignment(JLabel.CENTER);
        nombre.setBackground(Color.white);
        nombre.setForeground(Color.black);
        nombre.setBounds(50,200,100,30);
        nombre.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        nombre.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        panel.add(nombre);

        JLabel puntajeSE= new JLabel();
        puntajeSE.setText("Puntaje SE");
        puntajeSE.setOpaque(true);
        puntajeSE.setHorizontalAlignment(JLabel.LEFT);
        puntajeSE.setBackground(Color.white);
        puntajeSE.setForeground(Color.black);
        puntajeSE.setBounds(40,300,110,30);
        puntajeSE.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        puntajeSE.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        panel.add(puntajeSE);
    }
    private void colocarBoton(){
        BotonAgregar=new JButton("Agregar");
        BotonAgregar.setBackground(Color.pink);
        BotonAgregar.setForeground(Color.black);
        BotonAgregar.setBounds(20, 400, 200, 40);
        BotonAgregar.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        BotonAgregar.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        panel.add(BotonAgregar);

        BotonCancelar=new JButton("Cancelar");
        BotonCancelar.setBackground(Color.pink);
        BotonCancelar.setForeground(Color.black);
        BotonCancelar.setBounds(240, 400, 200, 40);
        BotonCancelar.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        BotonCancelar.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        panel.add(BotonCancelar);

        listenerAgregar();
        listenerCancelar();
    }
    private void listenerAgregar(){
        ActionListener agregar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String x=nombre.getText();
                    String y=id.getText();
                    String z=puntajeSE.getText();

                    int idInt=Integer.parseInt(y);
                    byte puntajeSEByte=Byte.parseByte(z);
                    Estudiante nuevoEstudiante=new Estudiante(idInt,x,puntajeSEByte);
                    if(sistema.Agregar_Estudiante(nuevoEstudiante)){
                        ventanaMain.Actualizar();
                        dispose();
                    }
                    else{
                        JLabel errorDato=new JLabel();
                        errorDato.setText("Estudiante con esta ID ya existe");
                        errorDato.setOpaque(true);
                        errorDato.setHorizontalAlignment(JLabel.CENTER);
                        errorDato.setBackground(Color.pink);
                        errorDato.setForeground(Color.black);
                        errorDato.setBounds(50,175,400,100);
                        errorDato.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
                        errorDato.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
                        panel.add(errorDato);
                        panel.repaint();
                        int tiempoEspera=3000;
                        Timer temporizador=new Timer(tiempoEspera, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                panel.remove(errorDato);
                                panel.repaint();
                            }
                        });
                        temporizador.setRepeats(false);
                        temporizador.start();
                    }
                } 
                catch(NumberFormatException error) {
                    JLabel errorDato=new JLabel();
                    errorDato.setText("Error en los datos insertados");
                    errorDato.setOpaque(true);
                    errorDato.setHorizontalAlignment(JLabel.CENTER);
                    errorDato.setBackground(Color.pink);
                    errorDato.setForeground(Color.black);
                    errorDato.setBounds(50,175,400,100);
                    errorDato.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
                    errorDato.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
                    panel.add(errorDato);
                    panel.repaint();
                    int tiempoEspera=3000;
                    Timer temporizador=new Timer(tiempoEspera, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            panel.remove(errorDato);
                            panel.repaint();
                        }
                    });
                    temporizador.setRepeats(false);
                    temporizador.start();
                }
            }
        };
        BotonAgregar.addActionListener(agregar);
    }
    private void listenerCancelar(){
        ActionListener cancelar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        };
        BotonCancelar.addActionListener(cancelar);
    }
    private void colocarCajasTexto(){
        id=new JTextField();
        id.setBounds(150, 100, 300, 30);
        id.setBackground(Color.white);
        id.setForeground(Color.black);
        id.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        id.setBorder(BorderFactory.createLineBorder(Color.pink, 3, true));
        panel.add(id);

        nombre=new JTextField();
        nombre.setBounds(150, 200, 300, 30);
        nombre.setBackground(Color.white);
        nombre.setForeground(Color.black);
        nombre.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        nombre.setBorder(BorderFactory.createLineBorder(Color.pink, 3, true));
        panel.add(nombre);

        puntajeSE=new JTextField();
        puntajeSE.setBounds(150, 300, 300, 30);
        puntajeSE.setBackground(Color.white);
        puntajeSE.setForeground(Color.black);
        puntajeSE.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        puntajeSE.setBorder(BorderFactory.createLineBorder(Color.pink, 3, true));
        panel.add(puntajeSE);
    }
}
class ventanaEliminar extends JFrame{
    private JPanel panel;
    private JButton BotonEliminar;
    private JButton BotonCancelar;
    private JTextField id;
    private SISTEMA sistema;
    private win ventanaMain;

    public ventanaEliminar(SISTEMA sistemaRecibido,win ventanaMainRecibida){
        this.sistema=sistemaRecibido;
        this.ventanaMain=ventanaMainRecibida;
        this.setSize(500,500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Eliminar Estudiante");
        Componentes();
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(500,500));
        this.getContentPane().setBackground(Color.pink);
    }
    private void Componentes(){
        colocarPanel();
        colocarEti();
        colocarBoton();
        colocarCajasTexto();
    }
    private void colocarPanel(){
        panel=new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);
        this.add(panel);  
    }
    private void colocarEti(){
        JLabel eti= new JLabel();
        eti.setText("Datos del estudiante a eliminar:");
        eti.setOpaque(true);
        eti.setHorizontalAlignment(JLabel.LEFT);
        eti.setBackground(Color.pink);
        eti.setForeground(Color.black);
        eti.setBounds(0,0,600,60);
        eti.setFont(new Font("XXX",Font.ROMAN_BASELINE,30));
        panel.add(eti);

        JLabel id= new JLabel();
        id.setText("ID");
        id.setOpaque(true);
        id.setHorizontalAlignment(JLabel.CENTER);
        id.setBackground(Color.white);
        id.setForeground(Color.black);
        id.setBounds(50,100,100,30);
        id.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        id.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        panel.add(id);
    }
    private void colocarBoton(){
        BotonEliminar=new JButton("Eliminar");
        BotonEliminar.setBackground(Color.pink);
        BotonEliminar.setForeground(Color.black);
        BotonEliminar.setBounds(20, 400, 200, 40);
        BotonEliminar.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        BotonEliminar.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        panel.add(BotonEliminar);

        BotonCancelar=new JButton("Cancelar");
        BotonCancelar.setBackground(Color.pink);
        BotonCancelar.setForeground(Color.black);
        BotonCancelar.setBounds(240, 400, 200, 40);
        BotonCancelar.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        BotonCancelar.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        panel.add(BotonCancelar);

        listenerEliminar();
        listenerCancelar();
    }
    private void listenerEliminar(){
        ActionListener eliminar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String y=id.getText();
                    int idInt=Integer.parseInt(y);

                    if(sistema.Eliminar_Estudiante_por_ID(idInt)){
                        ventanaMain.Actualizar();
                        dispose();
                    }
                    else{
                        JLabel errorDato=new JLabel();
                        errorDato.setText("No existe este estudiante");
                        errorDato.setOpaque(true);
                        errorDato.setHorizontalAlignment(JLabel.CENTER);
                        errorDato.setBackground(Color.pink);
                        errorDato.setForeground(Color.black);
                        errorDato.setBounds(50,175,400,100);
                        errorDato.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
                        errorDato.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
                        panel.add(errorDato);
                        panel.repaint();
                        int tiempoEspera=3000;
                        Timer temporizador=new Timer(tiempoEspera, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                panel.remove(errorDato);
                                panel.repaint();
                            }
                        });
                        temporizador.setRepeats(false);
                        temporizador.start();
                    }
                } 
                catch(NumberFormatException error) {
                    JLabel errorDato=new JLabel();
                    errorDato.setText("Error en los datos insertados");
                    errorDato.setOpaque(true);
                    errorDato.setHorizontalAlignment(JLabel.CENTER);
                    errorDato.setBackground(Color.pink);
                    errorDato.setForeground(Color.black);
                    errorDato.setBounds(50,175,400,100);
                    errorDato.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
                    errorDato.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
                    panel.add(errorDato);
                    panel.repaint();
                    int tiempoEspera=3000;
                    Timer temporizador=new Timer(tiempoEspera, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            panel.remove(errorDato);
                            panel.repaint();
                        }
                    });
                    temporizador.setRepeats(false);
                    temporizador.start();
                }
            }
        };
        BotonEliminar.addActionListener(eliminar);
    }
    private void listenerCancelar(){
        ActionListener cancelar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        };
        BotonCancelar.addActionListener(cancelar);
    }
    private void colocarCajasTexto(){
        id=new JTextField();
        id.setBounds(150, 100, 300, 30);
        id.setBackground(Color.white);
        id.setForeground(Color.black);
        id.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        id.setBorder(BorderFactory.createLineBorder(Color.pink, 3, true));
        panel.add(id);
    }
}

class ventanaBuscar extends JFrame{
    private JPanel panel;
    private JButton BotonBuscar;
    private JButton BotonCancelar;
    private JButton BotonModificar;
    private JButton BotonModificar2;
    private JTextField id;
    private JTextField nuevoPuntaje;
    private SISTEMA sistema;
    private win ventanaMain;
    private JLabel nombreValor;
    private JLabel puntajeSEValor;
    private JLabel puntajeSENuevo;

    public ventanaBuscar(SISTEMA sistemaRecibido,win ventanaMainRecibida){
        this.sistema=sistemaRecibido;
        this.ventanaMain=ventanaMainRecibida;
        this.setSize(500,500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Eliminar Estudiante");
        Componentes();
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(500,500));
        this.getContentPane().setBackground(Color.pink);
    }
    private void Componentes(){
        colocarPanel();
        colocarEti();
        colocarBoton();
        colocarCajasTexto();
    }
    private void colocarPanel(){
        panel=new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);
        this.add(panel);  
    }
    private void colocarEti(){
        JLabel eti= new JLabel();
        eti.setText("Datos del estudiante a buscar:");
        eti.setOpaque(true);
        eti.setHorizontalAlignment(JLabel.LEFT);
        eti.setBackground(Color.pink);
        eti.setForeground(Color.black);
        eti.setBounds(0,0,600,60);
        eti.setFont(new Font("XXX",Font.ROMAN_BASELINE,30));
        panel.add(eti);

        JLabel id= new JLabel();
        id.setText("ID");
        id.setOpaque(true);
        id.setHorizontalAlignment(JLabel.CENTER);
        id.setBackground(Color.white);
        id.setForeground(Color.black);
        id.setBounds(50,100,100,30);
        id.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        id.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        panel.add(id);

        JLabel datos= new JLabel();
        datos.setText("Datos del estudiante:");
        datos.setOpaque(true);
        datos.setHorizontalAlignment(JLabel.CENTER);
        datos.setBackground(Color.pink);
        datos.setForeground(Color.black);
        datos.setBounds(50,16,100,30);
        datos.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        datos.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        panel.add(datos);
    }
    private void colocarBoton(){
        BotonBuscar=new JButton("Buscar");
        BotonBuscar.setBackground(Color.pink);
        BotonBuscar.setForeground(Color.black);
        BotonBuscar.setBounds(20, 400, 200, 40);
        BotonBuscar.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        BotonBuscar.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        panel.add(BotonBuscar);

        BotonCancelar=new JButton("Cancelar");
        BotonCancelar.setBackground(Color.pink);
        BotonCancelar.setForeground(Color.black);
        BotonCancelar.setBounds(240, 400, 200, 40);
        BotonCancelar.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        BotonCancelar.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        panel.add(BotonCancelar);

        listenerBuscar();
        listenerCancelar();
    }
    private void listenerBuscar(){
        ActionListener buscar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String y=id.getText();
                    int idInt=Integer.parseInt(y);
                    Estudiante es=(Estudiante) sistema.obtener_datos_por_ID(idInt);
                    if (es!=null) {
                        mostrarDatos();
                        nombreValor.setText(es.getNombre());
                        puntajeSEValor.setText(String.valueOf(es.getPuntajeSE()));
                        panel.repaint();
                    } else {
                        JLabel errorDato = new JLabel();
                        errorDato.setText("Estudiante no existe");
                        errorDato.setOpaque(true);
                        errorDato.setHorizontalAlignment(JLabel.CENTER);
                        errorDato.setBackground(Color.pink);
                        errorDato.setForeground(Color.black);
                        errorDato.setBounds(50, 175, 400, 100);
                        errorDato.setFont(new Font("XXX", Font.ROMAN_BASELINE, 20));
                        errorDato.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
                        panel.add(errorDato);
                        panel.repaint();
                        int tiempoEspera=3000;
                        Timer temporizador=new Timer(tiempoEspera, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                panel.remove(errorDato);
                                panel.repaint();
                            }
                        });
                        temporizador.setRepeats(false);
                        temporizador.start();
                    }
                } 
                catch(NumberFormatException error) {
                    JLabel errorDato=new JLabel();
                    errorDato.setText("Error en los datos insertados");
                    errorDato.setOpaque(true);
                    errorDato.setHorizontalAlignment(JLabel.CENTER);
                    errorDato.setBackground(Color.pink);
                    errorDato.setForeground(Color.black);
                    errorDato.setBounds(50,175,400,100);
                    errorDato.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
                    errorDato.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
                    panel.add(errorDato);
                    panel.repaint();
                    int tiempoEspera=3000;
                    Timer temporizador=new Timer(tiempoEspera, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            panel.remove(errorDato);
                            panel.repaint();
                        }
                    });
                    temporizador.setRepeats(false);
                    temporizador.start();
                }
            }
        };
        BotonBuscar.addActionListener(buscar);
    }
    private void listenerCancelar(){
        ActionListener cancelar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        };
        BotonCancelar.addActionListener(cancelar);
    }
    private void colocarCajasTexto(){
        id=new JTextField();
        id.setBounds(150, 100, 300, 30);
        id.setBackground(Color.white);
        id.setForeground(Color.black);
        id.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        id.setBorder(BorderFactory.createLineBorder(Color.pink, 3, true));
        panel.add(id);
    }
    private void mostrarDatos(){
        JLabel nombre=new JLabel();
        nombre.setText("Nombre");
        nombre.setOpaque(true);
        nombre.setHorizontalAlignment(JLabel.CENTER);
        nombre.setBackground(Color.white);
        nombre.setForeground(Color.black);
        nombre.setBounds(50,250,100,30);
        nombre.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        nombre.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        panel.add(nombre);

        JLabel puntajeSE=new JLabel();
        puntajeSE.setText("Puntaje SE");
        puntajeSE.setOpaque(true);
        puntajeSE.setHorizontalAlignment(JLabel.LEFT);
        puntajeSE.setBackground(Color.white);
        puntajeSE.setForeground(Color.black);
        puntajeSE.setBounds(40,300,110,30);
        puntajeSE.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        puntajeSE.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        panel.add(puntajeSE);

        nombreValor=new JLabel();
        nombreValor.setOpaque(true);
        nombreValor.setHorizontalAlignment(JLabel.CENTER);
        nombreValor.setBackground(Color.white);
        nombreValor.setForeground(Color.black);
        nombreValor.setBounds(150,250,300,30);
        nombreValor.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        nombreValor.setBorder(BorderFactory.createLineBorder(Color.pink, 3, true));
        panel.add(nombreValor);

        puntajeSEValor=new JLabel();
        puntajeSEValor.setOpaque(true);
        puntajeSEValor.setHorizontalAlignment(JLabel.CENTER);
        puntajeSEValor.setBackground(Color.white);
        puntajeSEValor.setForeground(Color.black);
        puntajeSEValor.setBounds(150,300,100,30);
        puntajeSEValor.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        puntajeSEValor.setBorder(BorderFactory.createLineBorder(Color.pink, 3, true));
        panel.add(puntajeSEValor);

        BotonModificar=new JButton("Modificar puntaje SE");
        BotonModificar.setBackground(Color.pink);
        BotonModificar.setForeground(Color.black);
        BotonModificar.setBounds(250, 300, 200, 30);
        BotonModificar.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        BotonModificar.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        panel.add(BotonModificar);

        listenerModificar();
    }
    private void listenerModificar(){
        ActionListener modificar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mostrarModificar();
                    panel.remove(BotonModificar);
                    panel.repaint();
                } 
                catch(NumberFormatException error) {
                    JLabel errorDato=new JLabel();
                    errorDato.setText("Error en los datos insertados");
                    errorDato.setOpaque(true);
                    errorDato.setHorizontalAlignment(JLabel.CENTER);
                    errorDato.setBackground(Color.pink);
                    errorDato.setForeground(Color.black);
                    errorDato.setBounds(50,175,400,100);
                    errorDato.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
                    errorDato.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
                    panel.add(errorDato);
                    panel.repaint();
                    int tiempoEspera=3000;
                    Timer temporizador=new Timer(tiempoEspera, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            panel.remove(errorDato);
                            panel.repaint();
                        }
                    });
                    temporizador.setRepeats(false);
                    temporizador.start();
                }
            }
        };
        BotonModificar.addActionListener(modificar);
    }
    private void mostrarModificar(){
        puntajeSENuevo=new JLabel();
        puntajeSENuevo.setText("Puntaje nuevo");
        puntajeSENuevo.setOpaque(true);
        puntajeSENuevo.setHorizontalAlignment(JLabel.LEFT);
        puntajeSENuevo.setBackground(Color.white);
        puntajeSENuevo.setForeground(Color.black);
        puntajeSENuevo.setBounds(40,340,130,30);
        puntajeSENuevo.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        puntajeSENuevo.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        panel.add(puntajeSENuevo);

        nuevoPuntaje=new JTextField();
        nuevoPuntaje.setBounds(170, 340, 100, 30);
        nuevoPuntaje.setBackground(Color.white);
        nuevoPuntaje.setForeground(Color.black);
        nuevoPuntaje.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        nuevoPuntaje.setBorder(BorderFactory.createLineBorder(Color.pink, 3, true));
        panel.add(nuevoPuntaje);

        BotonModificar2=new JButton("Modificar");
        BotonModificar2.setBackground(Color.pink);
        BotonModificar2.setForeground(Color.black);
        BotonModificar2.setBounds(270, 340, 150, 30);
        BotonModificar2.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        BotonModificar2.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        panel.add(BotonModificar2);

        listenerModificar2();
    }
    private void listenerModificar2(){
        ActionListener modificar2=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String x=id.getText();
                    int idInt=Integer.parseInt(x);
                    String y=nuevoPuntaje.getText();
                    byte np=Byte.parseByte(y);

                    Estudiante es=(Estudiante) sistema.obtener_datos_por_ID(idInt);
                    sistema.Modificar_puntaje_estudiante(es,np);
                    ventanaMain.Actualizar();

                    panel.remove(puntajeSENuevo);
                    panel.remove(nuevoPuntaje);
                    panel.remove(BotonModificar2);
                    panel.add(BotonModificar);
                    puntajeSEValor.setText(String.valueOf(es.getPuntajeSE()));
                    panel.repaint();
                } 
                catch(NumberFormatException error) {
                    JLabel errorDato=new JLabel();
                    errorDato.setText("Error en los datos insertados");
                    errorDato.setOpaque(true);
                    errorDato.setHorizontalAlignment(JLabel.CENTER);
                    errorDato.setBackground(Color.pink);
                    errorDato.setForeground(Color.black);
                    errorDato.setBounds(50,175,400,100);
                    errorDato.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
                    errorDato.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
                    panel.add(errorDato);
                    panel.repaint();
                    int tiempoEspera=3000;
                    Timer temporizador=new Timer(tiempoEspera, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            panel.remove(errorDato);
                            panel.repaint();
                        }
                    });
                    temporizador.setRepeats(false);
                    temporizador.start();
                }
            }
        };
        BotonModificar2.addActionListener(modificar2);
    }
}

class ventanaCupos extends JFrame{
    private JPanel panel;
    private JButton BotonCambiar;
    private JButton BotonCancelar;
    private JTextField cuposNuevos;
    private SISTEMA sistema;
    private win ventanaMain;

    public ventanaCupos(SISTEMA sistemaRecibido,win ventanaMainRecibida){
        this.sistema=sistemaRecibido;
        this.ventanaMain=ventanaMainRecibida;
        this.setSize(500,500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Cambiar Cupos");
        Componentes();
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(500,500));
        this.getContentPane().setBackground(Color.pink);
    }
    private void Componentes(){
        colocarPanel();
        colocarEti();
        colocarBoton();
        colocarCajasTexto();
    }
    private void colocarPanel(){
        panel=new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);
        this.add(panel);  
    }
    private void colocarEti(){
        JLabel eti= new JLabel();
        eti.setText("Cambiar cantidad de cupos");
        eti.setOpaque(true);
        eti.setHorizontalAlignment(JLabel.LEFT);
        eti.setBackground(Color.pink);
        eti.setForeground(Color.black);
        eti.setBounds(0,0,600,60);
        eti.setFont(new Font("XXX",Font.ROMAN_BASELINE,30));
        panel.add(eti);

        JLabel cupos= new JLabel();
        cupos.setText("ID");
        cupos.setOpaque(true);
        cupos.setHorizontalAlignment(JLabel.CENTER);
        cupos.setBackground(Color.white);
        cupos.setForeground(Color.black);
        cupos.setBounds(50,100,100,30);
        cupos.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        cupos.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
        panel.add(cupos);
    }
    private void colocarBoton(){
        BotonCambiar=new JButton("Cambiar");
        BotonCambiar.setBackground(Color.pink);
        BotonCambiar.setForeground(Color.black);
        BotonCambiar.setBounds(20, 400, 200, 40);
        BotonCambiar.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        BotonCambiar.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        panel.add(BotonCambiar);

        BotonCancelar=new JButton("Cancelar");
        BotonCancelar.setBackground(Color.pink);
        BotonCancelar.setForeground(Color.black);
        BotonCancelar.setBounds(240, 400, 200, 40);
        BotonCancelar.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        BotonCancelar.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        panel.add(BotonCancelar);

        listenerCambiar();
        listenerCancelar();
    }
    private void listenerCambiar(){
        ActionListener cambiar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String y=cuposNuevos.getText();
                    int cn=Integer.parseInt(y);

                    sistema.Asignar_numero_de_cupos(cn);
                    ventanaMain.Actualizar();
                    dispose();
                } 
                catch(NumberFormatException error) {
                    JLabel errorDato=new JLabel();
                    errorDato.setText("Error en los datos insertados");
                    errorDato.setOpaque(true);
                    errorDato.setHorizontalAlignment(JLabel.CENTER);
                    errorDato.setBackground(Color.pink);
                    errorDato.setForeground(Color.black);
                    errorDato.setBounds(50,175,400,100);
                    errorDato.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
                    errorDato.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
                    panel.add(errorDato);
                    panel.repaint();
                    int tiempoEspera=3000;
                    Timer temporizador=new Timer(tiempoEspera, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            panel.remove(errorDato);
                            panel.repaint();
                        }
                    });
                    temporizador.setRepeats(false);
                    temporizador.start();
                }
            }
        };
        BotonCambiar.addActionListener(cambiar);
    }
    private void listenerCancelar(){
        ActionListener cancelar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        };
        BotonCancelar.addActionListener(cancelar);
    }
    private void colocarCajasTexto(){
        cuposNuevos=new JTextField();
        cuposNuevos.setBounds(150, 100, 300, 30);
        cuposNuevos.setBackground(Color.white);
        cuposNuevos.setForeground(Color.black);
        cuposNuevos.setFont(new Font("XXX",Font.ROMAN_BASELINE,20));
        cuposNuevos.setBorder(BorderFactory.createLineBorder(Color.pink, 3, true));
        panel.add(cuposNuevos);
    }
}
