/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richardhell.petclinic.controller.comercial.cliente;

import com.richardhell.petclinic.dao.*;
import com.richardhell.petclinic.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author pantojarosales
 */
@Controller
@Transactional
@SessionAttributes("propietario")
@RequestMapping("com/atencion")
public class AtencionController {

    @Autowired
    MascotaDAO mascotaDAO;

    @Autowired
    VeterinarioDAO veterinarioDAO;

    @Autowired
    VisitaDAO visitaDao;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("visitas", visitaDao.all());
        return "comercial/cliente/atencion";
    }

    @RequestMapping("new")
    public String create(Model model) {

        model.addAttribute("atencion",new Visita());
        model.addAttribute("veterinarios", new Veterinario());
        model.addAttribute("mascotas", new Mascota());
        return "comercial/cliente/atencionForm";
    }

}
