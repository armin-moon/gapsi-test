/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.nexttech.gapsi.ecomerce.dto;

import java.util.List;
import lombok.Data;

/**
 *
 * @author ArminJesusLunaMorale
 */
@Data
public class PaginaProveedor {

    private List proveedores;
    private Integer totalPage;
    private Long totalItems;
    private Integer currentPage;
}
