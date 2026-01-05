/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Composicion
 */
package com.docencia.composicion.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class CentroSalud {
    private final List<Consulta> consultas = new ArrayList<>();

    /**
     * Comprueba si la consulta es valida
     * @param paciente Paciente
     * @param motivo String motivo
     * @return true or false
     */
    public boolean consultaValida(Paciente paciente, String motivo) {

        if(motivo.isBlank()){
            return false;
        }
        if (paciente != null) {
            for (int i = 0; i < motivo.length(); i++) {
                if (!(motivo.charAt(i) >= 65 && motivo.charAt(i) <= 90
                        || motivo.charAt(i) >= 97 && motivo.charAt(i) <= 122 ||
                        motivo.charAt(i) == 'á' || motivo.charAt(i) == 'é' || motivo.charAt(i) == 'í'
                        || motivo.charAt(i) == 'ó' ||
                        motivo.charAt(i) == 'ú' || motivo.charAt(i) == 'ñ' || motivo.charAt(i) == ' ')) {

                            return false;
                }
            }
            
        }
        return true;
    }

    /**
     * Registra consulta en consultas
     * @param paciente Paciente
     * @param motivo String motivo
     */
    public void registrarConsulta(Paciente paciente, String motivo) {
        if (paciente != null && consultaValida(paciente, motivo)) {
            consultas.add(new Consulta(paciente, motivo));
        }
    }

    /**
     * Cuenta consultas por paciente
     * @param nombrePaciente nombre del paciente
     * @return entero de sus consultas
     */
    public int contarConsultasDe(String nombrePaciente) {
        if(nombrePaciente != null && !(nombrePaciente.isBlank())){
            int numeroConsultas=0;
            for (int i = 0; i < consultas.size(); i++) {
                if(nombrePaciente.trim().toLowerCase().equals(consultas.get(i).getPaciente().getNombre().toLowerCase().trim())){
                    numeroConsultas++;
                }
            }
            return numeroConsultas;
        }
        return 0;
    }

    // Getter
    public List<Consulta> getConsultas() {
        return new ArrayList<>(consultas);
    }
}
