package com.tienda.controller;

import com.tienda.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    private ClienteService clienteService;

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

        var clientes = clienteService.getClientes();
        //var temp = Arrays.asList();
        model.addAttribute("clientes", clientes);
        
        //var temp = new Cliente();
        //temp.setIdCliente(Long.parseLong("1"));
        //var cliente = clienteService.getCliente(new Cliente());
        //model.addAttribute("cliente", cliente);
        return "index";
    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente) {
    return "modificarCliente";
}
    
    @PostMapping("/guardarCliente")
    public String guardarClienbte(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }
    
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/";
    }
}
