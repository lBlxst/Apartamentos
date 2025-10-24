package com.apartamentos.apartamentos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.apartamentos.apartamentos.models.pagosModel;
import com.apartamentos.apartamentos.services.pagosServices;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/pagos")
public class pagosController {

    @Autowired
    private pagosServices pagoServices;

    @GetMapping()
    public ArrayList<pagosModel> getPagos() {
        return pagoServices.getAllPagos();
    }

    @GetMapping(path = "/{id}")
    public Optional<pagosModel> getPagoById(@PathVariable("id") Long id) {
        return pagoServices.getPagoById(id);
    }

    @PostMapping()
    public pagosModel savePago(@RequestBody pagosModel pago) {
        return pagoServices.savePago(pago);
    }

    @PutMapping(path = "/{id}")
    public pagosModel updateById(@RequestBody pagosModel request, @PathVariable("id") Long id) {
        return pagoServices.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deletePago(@PathVariable("id") Long id) {
        boolean ok = pagoServices.deletePago(id);
        if (ok) {
            return "Se eliminó el pago con id " + id;
        } else {
            return "No se pudo eliminar el pago con id " + id;
        }
    }
}
