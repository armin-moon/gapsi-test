/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.nexttech.gapsi.ecomerce.service;

import com.mx.nexttech.gapsi.ecomerce.dto.DataProveedores;
import com.mx.nexttech.gapsi.ecomerce.dto.PaginaProveedor;
import com.mx.nexttech.gapsi.ecomerce.dto.Proveedor;
import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author ArminJesusLunaMorale
 */
public interface ProveedorService {
    
    /**
     * Lista total de proveedores
     * @return
     * @throws BusinessException 
     */
    public DataProveedores list() throws BusinessException ;
    
    /**
     * 
     * @param pageable
     * @return
     * @throws BusinessException 
     */
    public PaginaProveedor list(Pageable pageable) throws BusinessException;
    
    /**
     * Crear un nuevo proveedor
     * @param p
     * @return
     * @throws BusinessException 
     */
    public DataProveedores add(Proveedor p) throws BusinessException;
    
    /**
     * Eliminar un proveedor
     * @param p
     * @return
     * @throws BusinessException 
     */
    public DataProveedores remove(Proveedor p) throws BusinessException;
    
    /**
     * Editar un proveedor
     * @param p
     * @return
     * @throws BusinessException 
     */
    public DataProveedores edit(Proveedor p) throws BusinessException;

}
