/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.nexttech.gapsi.ecomerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ArminJesusLunaMorale
 */
@RestController
@RequestMapping("api/v1/gapsi/ecommerce")
public class GapsiController {

    @GetMapping("/test")
    public String test() {
        return "OK";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Bienvenido Candidato 01";
    }

    @GetMapping("/version")
    public String version() {
        return "1.0.0";
    }
}
