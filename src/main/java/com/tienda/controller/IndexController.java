package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.tienda.domain.Cliente;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    private ClienteDao ClienteDao;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora utilizamos MVC");
        
        /*var mensaje = "Estamos en la semana 4";
        model.addAttribute("mensaje", mensaje);
        
        /*Cliente cliente = new Cliente("Juan", "Santamaria", "juan@gmail.com", "83775496");
        Cliente cliente2 = new Cliente("kevin", "Araya", "juan@gmail.com", "83775496");
        Cliente cliente3 = new Cliente("Pedro", "Araya", "juan@gmail.com", "83775496");
        var clientes = Arrays.asList(cliente, cliente2, cliente3);
        model.addAttribute("cliente", cliente);
        model.addAttribute("clientes", clientes);*/

        var clientes = ClienteDao.findAll();
        model.addAttribute("clientes", clientes);
        return "index";
    }

}
