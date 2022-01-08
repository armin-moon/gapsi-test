/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.nexttech.gapsi.ecomerce.service;

import com.google.gson.Gson;
import com.mx.nexttech.gapsi.ecomerce.dto.DataProveedores;
import com.mx.nexttech.gapsi.ecomerce.dto.PaginaProveedor;
import com.mx.nexttech.gapsi.ecomerce.dto.Proveedor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

/**
 *
 * @author ArminJesusLunaMorale
 */
@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Value("classpath:db.json")
    Resource resourceFile;

    @Override
    public DataProveedores list() throws BusinessException {
        try {
            return readJson();
        } catch (IOException ex) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al cargar los datos");
        }
    }

    public PaginaProveedor list(Pageable pageable) throws BusinessException {
        try {
            DataProveedores readJson = readJson();
            List<Proveedor> provedores = readJson.getProvedores();
            PageImpl page = new PageImpl(provedores, pageable, provedores.size());
            List content = page.getContent();

            PaginaProveedor pagina = new PaginaProveedor();
            pagina.setProveedores(content);
            pagina.setTotalPage(page.getTotalPages());
            pagina.setTotalItems(page.getTotalElements());
            pagina.setCurrentPage(page.getNumber());

            return pagina;
        } catch (IOException ex) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al cargar los datos");
        }
    }

    @Override
    public DataProveedores add(Proveedor proveedor) throws BusinessException {
        try {
            DataProveedores data = readJson();

            proveedor.setNombre(proveedor.getNombre().toUpperCase());

            List<Proveedor> proovedores = Optional.ofNullable(data.getProvedores()).orElse(new ArrayList<>());

            if (proovedores.stream().filter(p -> p.getNombre().equals(proveedor.getNombre())).findFirst().isPresent()) {
                throw new BusinessException(HttpStatus.CONFLICT, "Prveedor registrado previamente");
            }
            proovedores.add(proveedor);
            data.setProvedores(proovedores);
            updateJson(data);

            return data;
        } catch (IOException ex) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al cargar los datos");
        }
    }

    @Override
    public DataProveedores remove(Proveedor proveedor) throws BusinessException {
        try {
            DataProveedores data = readJson();

            if (data.getProvedores() != null) {
                boolean removeIf = data.getProvedores().removeIf(p -> p.getNombre().equals(proveedor.getNombre()));
                if (!removeIf) {
                    throw new BusinessException(HttpStatus.NOT_FOUND, "Prooveedor  " + proveedor.getNombre() + " no encontrado");
                }
            }

            updateJson(data);
            return data;
        } catch (IOException ex) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al cargar los datos");
        }
    }

    @Override
    public DataProveedores edit(Proveedor proveedor) throws BusinessException {
        try {
            DataProveedores data = readJson();
            List<Proveedor> orElse = Optional.ofNullable(data.getProvedores()).orElse(new ArrayList<>());

            if (orElse.stream().filter(p -> p.getNombre().equals(proveedor.getNombre())).findFirst().isPresent()) {
                Proveedor get = orElse.stream().filter(p -> p.getNombre().equals(proveedor.getNombre())).findFirst().get();
                get.setDireccion(proveedor.getDireccion());
                get.setRazonSocial(proveedor.getRazonSocial());
            } else {
                throw new BusinessException(HttpStatus.NOT_FOUND, "Prooveedor  " + proveedor.getNombre() + " no encontrado");
            }
            updateJson(data);
            return data;
        } catch (IOException ex) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al cargar los datos");
        }
    }

    /**
     * Lee la informacion del archivo .dbjson
     *
     * @return
     * @throws IOException
     */
    private DataProveedores readJson() throws IOException {
        Gson gson = new Gson();
        byte[] readAllBytes = Files.readAllBytes(Path.of(resourceFile.getURI()));
        return gson.fromJson(new String(readAllBytes), DataProveedores.class);// lo trasnforma al objeto DataProveedores
    }

    /**
     * Actualiza la información hacia el archivo db.json
     *
     * @param data
     * @throws IOException
     */
    private void updateJson(DataProveedores data) throws IOException {
        Gson gson = new Gson();
        String toJson = gson.toJson(data);// lo transforma a formato json
        Files.writeString(Path.of(resourceFile.getURI()), toJson, StandardOpenOption.TRUNCATE_EXISTING);

    }

}
