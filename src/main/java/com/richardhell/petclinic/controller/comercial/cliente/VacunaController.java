/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richardhell.petclinic.controller.comercial.cliente;

import com.richardhell.petclinic.dao.VacunaDAO;
import com.richardhell.petclinic.model.Especie;
import com.richardhell.petclinic.model.Vacuna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Transactional
@RequestMapping("com/vacuna")
public class VacunaController {

    @Autowired
    VacunaDAO vacunaDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("vacunas", vacunaDAO.all());
        return "comercial/cliente/vacuna";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {

        model.addAttribute("vacunas", vacunaDAO.all());
        model.addAttribute("vacuna", vacunaDAO.find(new Vacuna(id)));
        return "com/vacuna";
    }

    @RequestMapping("save")
    public String save(Vacuna vacuna) {

        if (vacuna.getId() == null) {
            vacunaDAO.saveDAO(vacuna);
        } else {
            vacunaDAO.updateDAO(vacuna);
        }
        return "redirect:/com/vacuna";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {

        vacunaDAO.deleteDAO(new Vacuna(id));
        return "redirect:/com/vacuna";
    }

    @ExceptionHandler(Exception.class)
    public String handleConflict() {
        return "redirect:/com/vacuna";
    }

}
