package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.List;

public class ConsejoElectoral {

    public HashMap<Provincia, Candidato> calcularCandidatoMasVotado(List<Partido> partidos) {
        HashMap<Provincia, Candidato> ganadores = new HashMap<>();
        Integer cantidadDeVotos = 0;
        Candidato candidato;
        for (Provincia prov : Provincia.values()) {
            ganadores.put(prov, null);
            for (Partido item : partidos) {
                candidato = item.obtenerCandidatoMasVotado(prov);
                if (candidato.obtenerCantidadDeVotos() > cantidadDeVotos) {
                    cantidadDeVotos = item.cantidadDeVotos(prov);
                    ganadores.put(prov, candidato);
                }
            }
        }
        return ganadores;
    }
}
