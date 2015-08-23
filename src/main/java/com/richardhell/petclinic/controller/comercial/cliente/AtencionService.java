/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richardhell.petclinic.controller.comercial.cliente;

import com.richardhell.petclinic.model.Mascota;
import com.richardhell.petclinic.model.Propietario;
import com.richardhell.petclinic.model.Veterinario;
import com.richardhell.petclinic.model.Visita;
import java.util.List;

public interface AtencionService {

    List<Visita> allVisita();
    
    List<Visita> allVisitaFinalizada();

    Visita findVisita(Visita visita);

    void saveVisita(Visita visita);

    List<Propietario> allPropietario();

    List<Mascota> allMascota();

    List<Veterinario> allVeterinario();

}
