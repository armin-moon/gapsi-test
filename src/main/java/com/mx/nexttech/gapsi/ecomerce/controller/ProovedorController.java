/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.nexttech.gapsi.ecomerce.controller;

import com.mx.nexttech.gapsi.ecomerce.dto.DataProveedores;
import com.mx.nexttech.gapsi.ecomerce.dto.PaginaProveedor;
import com.mx.nexttech.gapsi.ecomerce.dto.Proveedor;
import com.mx.nexttech.gapsi.ecomerce.service.BusinessException;
import com.mx.nexttech.gapsi.ecomerce.service.ProveedorService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ArminJesusLunaMorale
 */
@RestController
@RequestMapping("api/v1/gapsi/ecommerce/proveedor")
public class ProovedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping("/all")
    public ResponseEntity<DataProveedores> list() {
        try {
            DataProveedores data = proveedorService.list();
            return new ResponseEntity<DataProveedores>(data, HttpStatus.OK);
        } catch (BusinessException ex) {
            return new ResponseEntity(ex.getMensaje(), ex.getHttpStatus());
        }
    }

    @GetMapping("/")
    public ResponseEntity<PaginaProveedor> listPagina(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        try {
            Pageable paging = PageRequest.of(page, size);
            PaginaProveedor list = proveedorService.list(paging);
            return new ResponseEntity<PaginaProveedor>(list, HttpStatus.OK);
        } catch (BusinessException ex) {
            return new ResponseEntity(ex.getMensaje(), ex.getHttpStatus());
        }
    }

    @PutMapping("/")
    public ResponseEntity<DataProveedores> add(@RequestBody Proveedor p) {
        try {
            DataProveedores data = proveedorService.add(p);
            return new ResponseEntity<DataProveedores>(data, HttpStatus.OK);
        } catch (BusinessException ex) {
            return new ResponseEntity(ex.getMensaje(), ex.getHttpStatus());
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<DataProveedores> remove(@RequestBody Proveedor p) {
        try {
            DataProveedores data = proveedorService.remove(p);
            return new ResponseEntity<DataProveedores>(data, HttpStatus.OK);
        } catch (BusinessException ex) {
            return new ResponseEntity(ex.getMensaje(), ex.getHttpStatus());
        }
    }

    @PatchMapping("/")
    public ResponseEntity<DataProveedores> edit(@RequestBody Proveedor p) {
        try {
            DataProveedores data = proveedorService.edit(p);
            return new ResponseEntity<DataProveedores>(data, HttpStatus.OK);
        } catch (BusinessException ex) {
            return new ResponseEntity(ex.getMensaje(), ex.getHttpStatus());
        }
    }
}
