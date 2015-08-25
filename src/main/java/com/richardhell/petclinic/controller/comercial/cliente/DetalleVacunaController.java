/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richardhell.petclinic.controller.comercial.cliente;

import com.richardhell.petclinic.dao.DetalleDAO;
import com.richardhell.petclinic.dao.MascotaDAO;
import com.richardhell.petclinic.dao.VacunaDAO;
import com.richardhell.petclinic.model.Detalle;
import com.richardhell.petclinic.model.Vacuna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@Transactional
@SessionAttributes("detalle")
@RequestMapping("com/detalle")
public class DetalleVacunaController {

    @Autowired
    MascotaDAO mascotaDAO;

    @Autowired
    VacunaDAO vacunaDAO;

    @Autowired
    DetalleDAO detalleDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("vacunas", vacunaDAO.all());
        model.addAttribute("mascotas", mascotaDAO.all());
        model.addAttribute("detalles", detalleDAO.all());

        return "comercial/cliente/detalle";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {

        model.addAttribute("vacunas", vacunaDAO.all());
        model.addAttribute("mascotas", mascotaDAO.all());
        model.addAttribute("detalles", detalleDAO.all());
        model.addAttribute("detalle", vacunaDAO.find(new Vacuna(id)));
        return "com/detalle";
    }

    @RequestMapping("save")
    public String save(@ModelAttribute("detalle") Detalle detalle) {

        if (detalle.getId() == null) {
            detalleDAO.saveDAO(detalle);
        } else {
            detalleDAO.updateDAO(detalle);
        }
        return "redirect:/com/detalle";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {

        detalleDAO.deleteDAO(new Detalle(id));
        return "redirect:/com/detalle";
    }

    @ExceptionHandler(Exception.class)
    public String handleConflict() {
        return "redirect:/com/detalle";
    }

}
