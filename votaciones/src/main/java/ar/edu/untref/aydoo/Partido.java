package ar.edu.untref.aydoo;

import java.util.*;

public class Partido {

    private String nombre;
    private Map<Provincia, List<Candidato>> listadoCandidato;

    public Partido(String nombre) {
        this.nombre = nombre;
        listadoCandidato = new HashMap<>();
    }

    public void cargarCandidatoAlListado(Candidato unCandidato, Provincia provincia) {
        if (listadoCandidato.containsKey(provincia)) {
            cargarCandidato(unCandidato, provincia);
        } else {
            crearListadoConCandidato(unCandidato, provincia);
        }
    }

    public boolean contieneCandidato(Candidato unCandidato, Provincia provincia) {
        Optional<Candidato> anOptional = listadoCandidato.get(provincia).stream().filter(candidato ->
                (candidato.equals(unCandidato))).findFirst();
        return anOptional.isPresent();
    }

    public void recibirVoto(Candidato candidato) {
        candidato.recibirVoto();
    }

    public Integer cantidadDeVotos(Provincia provincia) {
        Integer cantidadDeVotosProvincia = 0;
        if (contieneProvincia(provincia)) {
            for (Candidato candidato : listadoCandidato.get(provincia)) {
                cantidadDeVotosProvincia += candidato.obtenerCantidadDeVotos();
            }
        }
        return cantidadDeVotosProvincia;
    }

    public Candidato obtenerCandidatoMasVotado(Provincia provincia) {
        Candidato candidato = null;
        if (contieneProvincia(provincia)) {
            Integer cantidadDeVotosProvinciales = 0;
            for (Candidato item : listadoCandidato.get(provincia)) {
                if (item.obtenerCantidadDeVotos() > cantidadDeVotosProvinciales) {
                    cantidadDeVotosProvinciales = item.obtenerCantidadDeVotos();
                    candidato = item;
                }
            }
        }
        return candidato;
    }

    public HashMap<Provincia, Candidato> obtenerCandidatosMasVotadoEnCadaProv() {
        Candidato candidato = null;
        HashMap<Provincia, Candidato> candidatosGanadores = new HashMap<>();
        for (Provincia item : Provincia.values()) {
            candidato = obtenerCandidatoMasVotado(item);
            if (candidato != null){
               candidatosGanadores.put(item, candidato);
            }
        }
        return candidatosGanadores;
    }

    private void cargarCandidato(Candidato unCandidato, Provincia provincia) {
        if (!contieneCandidato(unCandidato, provincia)){
            listadoCandidato.get(provincia).add(unCandidato);
            listadoCandidato.put(provincia, listadoCandidato.get(provincia));
        }
    }

    private void crearListadoConCandidato(Candidato unCandidato, Provincia provincia) {
        List<Candidato> candidatos = new ArrayList<>();
        candidatos.add(unCandidato);
        listadoCandidato.put(provincia, candidatos);
    }

    private boolean contieneProvincia(Provincia provincia) {
        return listadoCandidato.containsKey(provincia);
    }
}