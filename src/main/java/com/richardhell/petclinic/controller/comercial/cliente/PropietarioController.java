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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@Transactional
@SessionAttributes("propietario")
@RequestMapping("com/propietario")
public class PropietarioController {

    @Autowired
    PropietarioDAO propietarioDAO;
    
    @Autowired
    PersonaDAO personaDAO;
    
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
     @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("propietario", propietarioDAO.all());
        return "comercial/cliente/propietario";
    }
    
    @RequestMapping("list/{persona}")
    public String list(@PathVariable("persona") Long persona, Model model) {

        Persona per = personaDAO.find(new Persona(persona));

        model.addAttribute("persona", per);
        model.addAttribute("propietario", personaDAO.find(per));
        return "comercial/cliente/mascota";
    }


}
