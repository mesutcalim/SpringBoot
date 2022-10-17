package com.mesutcalim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Controller
public class PostConstructorTutorials {
    @Autowired
    Logger LOG;


    //Post Constructorı olmadığı için Log nesnesi çağırıldığında null pointer exception alınıyor.
    /*public PostConstructorTutorials() {
        LOG.info("Log info çağırıldı");
    }*/


    //Bir bean nesnesi oluştuğunda hemen oluşur.Boylede inject (Autowired) işlemi hatasız gerçekleşir.)
    @PostConstruct
    public void init(){
        LOG.info("Log info çağırıldı");
    }

    public static void main(String[] args) {
        PostConstructorTutorials postConstructorTutorials = new PostConstructorTutorials();
        System.out.println(postConstructorTutorials);
    }
}
