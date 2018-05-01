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
            if (!contieneCandidato(unCandidato, provincia)){
                listadoCandidato.get(provincia).add(unCandidato);
                listadoCandidato.put(provincia, listadoCandidato.get(provincia));
            }
        } else {
            List<Candidato> candidatos = new ArrayList<>();
            candidatos.add(unCandidato);
            listadoCandidato.put(provincia, candidatos);
        }
    }

    public boolean contieneCandidato(Candidato unCandidato, Provincia provincia) {
        Optional<Candidato> anOptional = listadoCandidato.get(provincia).stream().filter(candidato ->
                (candidato.equals(unCandidato))).findFirst();
        return anOptional.isPresent();
    }
}
