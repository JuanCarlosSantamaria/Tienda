package com.tienda.controller;

import com.tienda.domain.Articulo;
import com.tienda.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/articulo/listado")
    public String inicio(Model model) {
        var articulos = articuloService.getArticulos(false);
        model.addAttribute("articulo", articulos);
        return "/articulos/listado";
    }

    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo) {
        return "/articulomodificar";
    }

    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo) {
        articuloService.save(articulo);
        return "/articulos/listado";
    }

    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo.modificar";
    }

    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo) {
        articuloService.delete(articulo);
        return "/articulos/listado";
    }
}



