package Vista;

import Clases.Alumno;
import Clases.Apoderado;
import Controlador.*;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class fmrAgregarAlumnos extends JDialog {
    // ========== ATRIBUTOS ==========
    private Alumno nuevoAlumno;

    // ----- PANEL -----
    private JPanel AgregarAlumno;
    private JPanel AgregarAlumnos;
    private JPanel AgregarApoderados;
    private JPanel Apoderado;
    private JPanel Alumno;


    // ----- TABBED PANEL -----
    private JTabbedPane tabbedPane1;


    // ----- JTABLE -----
    private JTable tblListado;


    // ----- TXT -----
    private JTextField txtRut;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtEdad;
    private JTextField txtFechaNacimiento;
    private JTextField txtDireccion;
    private JTextField txtEmail;
    private JTextField txtNacionalidad;
    private JTextField txtTelefono;
    private JTextField txtCiudad;
    private JTextField txtDatosAdicionales;
    private JTextField txtFechaMatricula;
    private JTextField txtCurso;
    private JTextField txtLetra;
    private JTextField txtElectivo;
    private JTextField txtEnfermedades;
    private JTextField txtCiudadApoderado;
    private JTextField txtRutApoderado;
    private JTextField txtNombresApoderado;
    private JTextField txtApellidosApoderado;
    private JTextField txtParentescoApoderado;
    private JTextField txtTelefonoApoderado;
    private JTextField txtDireccionApoderado;
    private JTextField txtObservacionesApoderado;


    // ----- BUTTON -----
    private JButton     btnGrabar;
    private JButton     btnLimpiar;
    private JButton     btnSalir;
    private JButton     btnBorrar;
    private JButton     btnModificar;
    private JButton     btnListar;
    private JButton     btnBuscar;
    private JButton     btnLimpiarApoderado;


    // ----- BUTTON GROUP -----
    private ButtonGroup grupoBotonesGenero;
    private ButtonGroup grupoBotonesGeneroApoderado;


    // ----- RDO -----
    private JRadioButton    rdoMasculino;
    private JRadioButton    rdoFemenino;
    private JRadioButton    rdoOtro;
    private JRadioButton    rdoMasculinoApoderado;
    private JRadioButton    rdoFemeninoApoderado;
    private JRadioButton    rdoOtroApoderado;


    // ----- LBL -----
    private JLabel lblDatos;
    private JLabel lblRut;
    private JLabel lblNombres;
    private JLabel lblApellidos;
    private JLabel lblEdad;
    private JLabel lblFechaNacimiento;
    private JLabel lblDireccion;
    private JLabel lblCiudad;
    private JLabel lblTelefono;
    private JLabel lblEmail;
    private JLabel lblNacionalidad;
    private JLabel lblDatosAdicionales;
    private JLabel lblFechaMatricula;
    private JLabel lblGenero;
    private JLabel lblEnfermedades;
    private JLabel lblCurso;
    private JLabel lblLetra;
    private JLabel lblElectivo;
    private JLabel lblAgregarAlumno;
    private JLabel lblAgregarApoderado;
    private JLabel lblRutApoderado;
    private JLabel lblNombresApoderado;
    private JLabel lblApellidosApoderado;
    private JLabel lblParentescoApoderado;
    private JLabel lblTelefonoApoderado;
    private JLabel lblCiudadApoderado;
    private JLabel lblDireccionApoderado;
    private JLabel lblGeneroApoderado;
    private JLabel lblObservacionesApoderado;


    // ========== CONSTRUCTOR ==========
    public fmrAgregarAlumnos() {
        try {
            UIManager.setLookAndFeel(new FlatDarkPurpleIJTheme()); // Configura el tema
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setModal(true);
        setTitle("Agregar Alumno");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setContentPane(AgregarAlumno);
        setResizable(false);
        cargarListadoAlumnos(null);

        // ----- GRUPO DE BOTONES -----
        this.grupoBotonesGenero = new ButtonGroup();
        grupoBotonesGenero.add(rdoFemenino);
        grupoBotonesGenero.add(rdoMasculino);
        grupoBotonesGenero.add(rdoOtro);

        this.grupoBotonesGeneroApoderado = new ButtonGroup();
        grupoBotonesGeneroApoderado.add(rdoFemeninoApoderado);
        grupoBotonesGeneroApoderado.add(rdoMasculinoApoderado);
        grupoBotonesGeneroApoderado.add(rdoOtroApoderado);

// # ======================================== BOTONES ======================================== #
        // ----- BOTÓN LIMPIAR ALUMNO-----
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });


        // ----- BOTÓN SALIR -----
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        // ----- BOTÓN BUSCAR ALUMNO POR RUT -----
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarAlumnoPorRut();
            }
        });


        // ----- BOTÓN LISTAR -----
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarListadoAlumnos(null);
                limpiar();
                btnBorrar.setEnabled(false);
                btnModificar.setEnabled(false);
            }
        });


        // ----- BOTÓN GRABAR -----
        btnGrabar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grabarTotal();
                limpiar();
                limpiarApoderado();
                cargarListadoAlumnos(null);
            }
        });


        // ----- BOTÓN LIMPIAR APODERADO -----
        btnLimpiarApoderado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        // ----- BOTÓN BORRAR -----
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarEstudiante();
                cargarListadoAlumnos(null);
                btnBorrar.setEnabled(false);
                btnModificar.setEnabled(false);
            }
        });
        btnBorrar.setEnabled(false);


        // ----- BOTÓN MODIFICAR -----
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarAlumno();
                limpiar();
                cargarListadoAlumnos(null);
            }
        });
        btnModificar.setEnabled(false);
    }





    // # ======================================== MÉTODOS ======================================== #
    // -------------------- GRABAR TOTAL --------------------
    public void grabarTotal() {
        if (validarCampos()) {
            this.nuevoAlumno = grabar();
            grabarApoderado();
            Controlador.agregarAlumnoCSV(this.nuevoAlumno);
            JOptionPane.showMessageDialog(null, "Alumno y apoderado agregados correctamente");
        }
    }



    // -------------------- GRABAR ALUMNO --------------------
    public Alumno grabar() {
        String rut              = txtRut                .getText();
        String nombres          = txtNombres            .getText();
        String apellidos        = txtApellidos          .getText();
        String edad             = txtEdad               .getText();
        String fechaNacimiento  = txtFechaNacimiento    .getText();
        String direccion        = txtDireccion          .getText();
        String ciudad           = txtCiudad             .getText();
        String telefono         = txtTelefono           .getText();
        String email            = txtEmail              .getText();
        String nacionalidad     = txtNacionalidad       .getText();
        String datosAdicionales = txtDatosAdicionales   .getText();
        String fechaMatricula   = txtFechaMatricula     .getText();
        String enfermedades     = txtEnfermedades       .getText();
        String genero           = obtenerGeneroAlumno();
        String curso            = txtCurso              .getText();
        String letra            = txtLetra              .getText();
        String electivo         = txtElectivo           .getText();

        Alumno nuevoAlumno      = new Alumno(   rut             , nombres           , apellidos         , edad              ,
                fechaNacimiento , email             , ciudad            , telefono          ,
                nacionalidad    , fechaMatricula    , direccion         , curso             ,
                letra           , electivo          , enfermedades      , datosAdicionales  ,
                genero);
        return nuevoAlumno;
    }
    // ----- Obtener género -----
    private String obtenerGeneroAlumno() {
        String generoAlumno = "";

        if (rdoMasculino.isSelected()) {
            return "Masculino";
        } else if (rdoFemenino.isSelected()) {
            return "Femenino";
        } else if (rdoOtro.isSelected()) {
            return "Otro";
        }
        return generoAlumno;
    }



    // -------------------- GRABAR APODERADO --------------------
    public void grabarApoderado() {
        String rutApoderado             = txtRutApoderado           .getText();
        String nombresApoderado         = txtNombresApoderado       .getText();
        String apellidosApoderado       = txtApellidosApoderado     .getText();
        String parentescoApoderado      = txtParentescoApoderado    .getText();
        String telefonoApoderado        = txtTelefonoApoderado      .getText();
        String ciudadApoderado          = txtCiudadApoderado        .getText();
        String direccionApoderado       = txtDireccionApoderado     .getText();
        String observacionesApoderado   = txtObservacionesApoderado .getText();
        String generoApoderado          = obtenerGeneroApoderado();

        Clases.Apoderado nuevoApoderado = new Apoderado(    rutApoderado            , nombresApoderado          , apellidosApoderado        ,
                parentescoApoderado     , telefonoApoderado         , ciudadApoderado           ,
                direccionApoderado      , observacionesApoderado    , generoApoderado           );
        nuevoAlumno.setNuevoApoderado(nuevoApoderado);
    }
    // ----- Obtener género apoderado-----
    private String obtenerGeneroApoderado() {
        String generoApoderado = "";

        if (rdoMasculino.isSelected()) {
            return "Masculino";
        } else if (rdoFemenino.isSelected()) {
            return "Femenino";
        } else if (rdoOtro.isSelected()) {
            return "Otro";
        }
        return generoApoderado;
    }



    // -------------------- LIMPIAR ALUMNO --------------------
    public void limpiar() {
        txtRut              .setText(null);
        txtNombres          .setText(null);
        txtApellidos        .setText(null);
        txtEdad             .setText(null);
        txtFechaNacimiento  .setText(null);
        txtDireccion        .setText(null);
        txtDireccion        .setText(null);
        txtCiudad           .setText(null);
        txtTelefono         .setText(null);
        txtEmail            .setText(null);
        txtNacionalidad     .setText(null);
        txtDatosAdicionales .setText(null);
        txtFechaMatricula   .setText(null);
        txtEnfermedades     .setText(null);
        txtCurso            .setText(null);
        txtLetra            .setText(null);
        txtElectivo         .setText(null);
        grupoBotonesGenero.clearSelection();
    }



    // -------------------- LIMPIAR APODERADO --------------------
    public void limpiarApoderado() {
        txtRutApoderado             .setText(null);
        txtNombresApoderado         .setText(null);
        txtApellidosApoderado       .setText(null);
        txtParentescoApoderado      .setText(null);
        txtTelefonoApoderado        .setText(null);
        txtCiudadApoderado          .setText(null);
        txtDireccionApoderado       .setText(null);
        txtObservacionesApoderado   .setText(null);
        grupoBotonesGeneroApoderado.clearSelection();
    }



    // -------------------- SET NUEVO ALUMNO --------------------
    public void setNuevoAlumno(Alumno nuevoAlumno) {
        this.nuevoAlumno = nuevoAlumno;
    }



    // -------------------- VALIDAR CAMPOS --------------------
    private boolean validarCampos() {
        if (    txtRut                  .getText().isEmpty() ||
                txtNombres              .getText().isEmpty() ||
                txtApellidos            .getText().isEmpty() ||
                txtEdad                 .getText().isEmpty() ||
                txtFechaNacimiento      .getText().isEmpty() ||
                txtDireccion            .getText().isEmpty() ||
                txtCiudad               .getText().isEmpty() ||
                txtTelefono             .getText().isEmpty() ||
                txtNacionalidad         .getText().isEmpty() ||
                txtDatosAdicionales     .getText().isEmpty() ||
                txtFechaMatricula       .getText().isEmpty() ||
                txtDireccion            .getText().isEmpty() ||
                txtCurso                .getText().isEmpty() ||
                txtLetra                .getText().isEmpty() ||
                txtElectivo             .getText().isEmpty() ||
                txtRutApoderado         .getText().isEmpty() ||
                txtNombresApoderado     .getText().isEmpty() ||
                txtApellidosApoderado   .getText().isEmpty() ||
                txtParentescoApoderado  .getText().isEmpty() ||
                txtTelefonoApoderado    .getText().isEmpty() ||
                txtDireccionApoderado   .getText().isEmpty() ||
                txtCiudadApoderado      .getText().isEmpty()
        ) {
            JOptionPane.showMessageDialog(this, "Faltan campos por rellenar", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }



    // -------------------- CARGAR LISTADO ALUMNOS --------------------
    private void cargarListadoAlumnos(String filtroRut) {
        // Obtener los datos de los alumnos desde el controlador
        List<Object[]> alumnosData = Controlador.listadoAlumnos(filtroRut);

        // Crear un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas
        String[] columnas = {   "Rut Alumno"                , "Nombres Alumno"              , "Apellidos Alumno"            , "Edad Alumno"                     ,
                                "Fecha Nacimiento Alumno"   , "Email Alumno"                , "Ciudad Alumno"               , "Teléfono Alumno"                 ,
                                "Nacionalidad Alumno"       , "Fecha Matrícula Alumno"      , "Dirección Alumno"            , " Curso Alumno"                   ,
                                "Letra Alumno"              , "Electivo Alumno"             , "Enfermedades Alumno"         , "Datos Adicionales Alumno"        ,
                                "Género Alumno"};
        modelo.setColumnIdentifiers(columnas);

        // Agregar los datos al modelo
        for (Object[] rowData : alumnosData) {
            modelo.addRow(rowData);
        }

        // Establecer el modelo en la tabla
        tblListado.setModel(modelo);
    }



    // -------------------- ELIMINAR ESTUDIANTE --------------------
    private void eliminarEstudiante() {
        String rutEstudiante = txtRut.getText();

        if (!rutEstudiante.isEmpty()) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar al estudiante?", "Confirmar Borrado", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                Controlador.eliminarAlumnoCSV(rutEstudiante);

                limpiar();
                limpiarApoderado();
                cargarListadoAlumnos(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Primero debes buscar al estudiante que deseas eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    // -------------------- BUSCAR ALUMNO POR RUT --------------------
    private void buscarAlumnoPorRut() {
        String filtroRut = txtRut.getText();
        cargarListadoAlumnos(filtroRut);

        // Obtener los datos de los alumnos desde el controlador
        List<Object[]> alumnosData      = Controlador.listadoAlumnos(filtroRut);

        if (!alumnosData.isEmpty()) {
            btnGrabar.setEnabled(false);
            Object[] alumnoEncontrado   = alumnosData.get(0);

            // Datos del alumno encontrado en los TextField
            txtRut                  .setText((String) alumnoEncontrado[0]);
            txtNombres              .setText((String) alumnoEncontrado[1]);
            txtApellidos            .setText((String) alumnoEncontrado[2]);
            txtEdad                 .setText((String) alumnoEncontrado[3]);
            txtFechaNacimiento      .setText((String) alumnoEncontrado[4]);
            txtEmail                .setText((String) alumnoEncontrado[5]);
            txtCiudad               .setText((String) alumnoEncontrado[6]);
            txtTelefono             .setText((String) alumnoEncontrado[7]);
            txtNacionalidad         .setText((String) alumnoEncontrado[8]);
            txtFechaMatricula       .setText((String) alumnoEncontrado[9]);
            txtDireccion            .setText((String) alumnoEncontrado[10]);
            txtCurso                .setText((String) alumnoEncontrado[11]);
            txtLetra                .setText((String) alumnoEncontrado[12]);
            txtElectivo             .setText((String) alumnoEncontrado[13]);
            txtEnfermedades         .setText((String) alumnoEncontrado[14]);
            txtDatosAdicionales     .setText((String) alumnoEncontrado[15]);
            String generoAlumno = (String) alumnoEncontrado[16];
            if (generoAlumno.equals("Masculino")) {
                rdoMasculino.setSelected(true);
            } else if (generoAlumno.equals("Femenino")) {
                rdoFemenino.setSelected(true);
            } else {
                rdoOtro.setSelected(true);
            }
            btnBorrar.setEnabled(true);
            btnModificar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró un alumno con el RUT especificado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            limpiar();
            limpiarApoderado();
            btnBorrar.setEnabled(false);
            btnModificar.setEnabled(false);
        }
    }


    // -------------------- MODIFICAR ALUMNO --------------------
    private void modificarAlumno() {
        if (validarCampos()) {
            // Obtener los datos modificados de los TextField
            Alumno alumnoModificado = grabar();

            Controlador.modificarAlumno(alumnoModificado);

            JOptionPane.showMessageDialog(null, "Alumno modificado correctamente");
        }
    }
}