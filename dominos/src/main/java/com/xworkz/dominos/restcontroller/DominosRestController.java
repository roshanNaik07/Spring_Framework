package com.xworkz.dominos.restcontroller;


import com.xworkz.dominos.service.DominoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.awt.*;

@RestController
@RequestMapping("/")

public class DominosRestController {

    @Autowired
    public DominoService dominoService;

    @GetMapping(value = "/userEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String userEmail(@PathVariable String email) {
        System.out.println("this is rest controler");
        long count = dominoService.getEmailCount(email);
        if (count == 0) {
            return "";
        } else {
            return "email is already exists";

        }

    }
}
