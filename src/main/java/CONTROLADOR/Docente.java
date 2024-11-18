/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import VISTA.frmDocente;
import java.util.List;
import java.util.Map;
import MODELO.DocenteModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Docente {
     private DocenteModel docenteModel;
    private frmDocente docenteView;

    public Docente(frmDocente docenteView) {
        this.docenteModel = new DocenteModel(); // Instancia del modelo
        this.docenteView = docenteView; // Asigna la vista
    }

    public List<Map<String, Object>> obtenerDocentes() {
        return docenteModel.MostrarDocentes(); // Llama al método del modelo para obtener datos
    }
public void cargarDocentesEnVista() {
    // Obtener los datos desde el modelo
    List<Map<String, Object>> datos = docenteModel.MostrarDocentes();

    // Verificar si los datos están vacíos
    if (datos.isEmpty()) {
        System.err.println("No se encontraron datos de docentes.");
        return;
    }

    // Extraer las columnas dinámicamente desde el primer resultado
    List<String> columnas = datos.get(0).keySet().stream().toList(); // Mantiene el orden que viene del procedimiento almacenado
    System.out.println("Columnas obtenidas dinámicamente: " + columnas);

    // Obtener la tabla desde la vista
    JTable tabla = docenteView.getTblDocentes();

    // Crear un nuevo modelo de tabla
    DefaultTableModel modeloTabla = new DefaultTableModel();
    modeloTabla.setColumnIdentifiers(columnas.toArray()); // Configurar columnas dinámicamente

    // Agregar filas dinámicamente
    for (Map<String, Object> fila : datos) {
        Object[] filaDatos = columnas.stream()
                .map(fila::get) // Obtener el valor de cada columna dinámicamente
                .toArray();
        modeloTabla.addRow(filaDatos);
    }

    // Asignar el modelo configurado a la tabla
    tabla.setModel(modeloTabla);

    // Mensaje de éxito
    System.out.println("Datos cargados en la tabla exitosamente. Total de filas: " + datos.size());
}
}
