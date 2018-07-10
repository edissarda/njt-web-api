/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author edis
 */
@RestController
@SessionScope
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("doc")
public class DokumentacijaController {

    @GetMapping(produces = "text/html")
    public byte[] doc() {
        ClassLoader classLoader = getClass().getClassLoader();
        File f = new File(classLoader.getResource("./dokumentacija.html").getFile());
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            StringBuilder sb = new StringBuilder(500);
            String red = null;
            while ((red = br.readLine()) != null) {
                sb.append(red);
            }

            br.close();

            return sb.toString().getBytes();
        } catch (IOException ex) {
            ex.printStackTrace();
            return "Грешка".getBytes();
        }
    }

}
