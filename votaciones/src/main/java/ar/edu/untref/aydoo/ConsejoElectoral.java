package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.List;

public class ConsejoElectoral {

    public HashMap<Provincia, Candidato> calcularCandidatosMasVotado(List<Partido> partidos) {
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

    public Partido calcularPartidoMasVotado(List<Partido> partidos) {
        Integer cantidadDeVotos = 0;
        HashMap<Partido, Integer> ganador = new HashMap<>();
        for (Partido item : partidos) {
            for (Provincia prov : Provincia.values()) {
                cantidadDeVotos += item.cantidadDeVotos(prov);
            }
            ganador.put(item, cantidadDeVotos);
        }
        return obtenerGanador(ganador);
    }

    private Partido obtenerGanador(HashMap<Partido, Integer> map) {
        Integer votos = 0;
        Partido partido = null;
        for (Partido item : map.keySet()) {
            if (map.get(item) > votos) {
                votos = map.get(item);
                partido = item;
            }
        }
        return partido;
    }
}
