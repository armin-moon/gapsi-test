/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.nexttech.gapsi.ecomerce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author ArminJesusLunaMorale
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GapsiApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Filter Price Check 1")
    public void FilterPriceCheck2() throws Exception {
        mockMvc.perform(get("/api/v1/gapsi/ecommerce/proveedor/all"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
