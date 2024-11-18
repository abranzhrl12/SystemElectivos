/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Abraham
 */
public class DocenteModel {

   public List<Map<String, Object>> MostrarDocentes() {
    List<Map<String, Object>> resultados = new ArrayList<>();

    // Definir el procedimiento almacenado
    String procedimiento = "{call mostrar_docentes()}"; // Ajusta el nombre según tu procedimiento

    try (Connection con = CONEXION.conectar();
         CallableStatement stmt = con.prepareCall(procedimiento);
         ResultSet rs = stmt.executeQuery()) {

        // Obtener los metadatos del ResultSet para manejar dinámicamente las columnas
        int columnCount = rs.getMetaData().getColumnCount();

        while (rs.next()) {
            Map<String, Object> fila = new LinkedHashMap<>(); // Cambiar a LinkedHashMap
            for (int i = 1; i <= columnCount; i++) {
                String columnLabel = rs.getMetaData().getColumnLabel(i); // Obtiene el alias de la columna
                Object value = rs.getObject(i); // Obtiene el valor de la columna
                fila.put(columnLabel, value);
            }
            resultados.add(fila);
        }

        // Verificar si se trajeron datos
        if (resultados.isEmpty()) {
            System.err.println("No se encontraron datos en el procedimiento almacenado.");
        } else {
            System.out.println("Datos obtenidos exitosamente. Total de filas: " + resultados.size());
            System.out.println("Primer registro (si aplica): " + resultados.get(0));
        }

    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Error ejecutando el procedimiento almacenado: " + e.getMessage());
    }

    return resultados;
}


}
