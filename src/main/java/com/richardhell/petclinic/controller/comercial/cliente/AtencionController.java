/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richardhell.petclinic.controller.comercial.cliente;

import com.richardhell.petclinic.dao.*;
import com.richardhell.petclinic.model.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    

    @Autowired
    AtencionService service;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

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
        
          Date date = new Date();
          visita.setFechaIngreso(date);

        if (visita.getId() == null) {           
          
            visitaDao.saveDAO(visita);
            
        } else {
            visitaDao.updateDAO(visita);
        }
        return "redirect:/com/atencion";
    }

    @RequestMapping("salida/{id}")
    public String salida(@PathVariable("id") Long id, Model model) {

        Visita visita = service.findVisita(new Visita(id));
        model.addAttribute("visita", visita);
        System.out.println(visita);

        if (visita.getFechaSalida() == null) {            
            Date date = new Date();
            visita.setFechaSalida(date);  
            visita.setFinalizado(false);
            return "redirect:/com/atencion";            
        }


        return"redirect:/com/atencion";
    }
}
