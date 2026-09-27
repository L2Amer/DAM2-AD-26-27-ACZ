package ud1.ejerciciosPracticos.flujosdeObjetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ColeccionPersonas implements Serializable {
    private List<Persona> lstPersonas = new ArrayList<>();

    public void añadirPersonas(Persona p) {
        lstPersonas.add(p);
    }

    @Override
    public String toString() {
        String personas = "";
        for (Persona p : lstPersonas) {
            personas += p + " \n";
        }
        return personas;
    }

    
}
