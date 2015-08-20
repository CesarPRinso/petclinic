/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richardhell.petclinic.controller.comercial.cliente;

import com.richardhell.petclinic.dao.*;
import com.richardhell.petclinic.model.*;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

        model.addAttribute("veterinarios", veterinarioDAO.all());
        model.addAttribute("mascotas", mascotaDAO.all());
        model.addAttribute("atencion", new Visita());
        return "comercial/cliente/atencionForm";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {

        visitaDao.deleteDAO(new Visita(id));
        return "redirect:/com/atencion";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {

        model.addAttribute("veterinarios", veterinarioDAO.all());
        model.addAttribute("mascotas", mascotaDAO.all());
        model.addAttribute("atencion", visitaDao.find(new Visita(id)));
        return "comercial/cliente/atencionForm";

    }

    @RequestMapping("save")
    public String save(@ModelAttribute("atencion") Visita visita) {

        if (visita.getId() == null) {
            Date date = new Date();
            visita.setFechaIngreso(date);
            visitaDao.saveDAO(visita);
        } else {
            visitaDao.updateDAO(visita);
        }
        return "redirect:/com/atencion";
    }

}
