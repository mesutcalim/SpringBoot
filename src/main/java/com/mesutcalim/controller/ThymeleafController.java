package com.mesutcalim.controller;

import com.mesutcalim.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    // http://localhost:8080
    //optional
    @GetMapping({"/","index"})
    public String index(){
        return "index";
    }
/////////////////////////////////////////////////////////////////////////
    //ResponseBody
    // http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
    // @ResponseBody
    public String getThymeleaf1() {
        return "thymeleaf1";
    }

    //Model
    // http://localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2")
    public String getThymeleaf2Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim 1");
        model.addAttribute("key_model2", "Ben modelden geldim 2");
        return "thymeleaf1";
    }

    //Birden fazla göndermek
    // http://localhost:8080/thymeleaf3
    @GetMapping("/thymeleaf3")
    public String getThymeleaf3Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim 1");
        model.addAttribute("key_model2", "Ben modelden geldim 2");
        return "thymeleaf_file/thymeleaf3";
    }

    // http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")
    public String getThymeleaf4Model(Model model) {
        model.addAttribute("key_model1", "Ben modelden geldim 4");
        return "thymeleaf4";
    }

    ////////////////////////////////////////////////////////////////////////////////
    //Model Object Göndermek
    // http://localhost:8080/thymeleaf5
    @GetMapping("/thymeleaf5")
    public String getThymeleaf5ModelObject(Model model) {
        model.addAttribute("key_model1", "text");

        ProductDto productDto = ProductDto
                .builder()
                .productId(0L)
                .productName("ürün adi")
                .productPrice(2500)
                .build();

        model.addAttribute("key_model2", productDto);
        return "thymeleaf5";
    }

    //Model Object List Göndermek
    // http://localhost:8080/thymeleaf6
    @GetMapping("/thymeleaf6")
    public String getThymeleaf6ModelObject(Model model) {
        model.addAttribute("key_model1", "text");
        List<ProductDto> listem = new ArrayList<>();
        listem.add(ProductDto.builder().productId(0L).productName("ürün adi0").productPrice(2500).build());
        listem.add(ProductDto.builder().productId(1L).productName("ürün adi1").productPrice(200).build());
        listem.add(ProductDto.builder().productId(2L).productName("ürün adi2").productPrice(500).build());
        listem.add(ProductDto.builder().productId(3L).productName("ürün adi3").productPrice(1500).build());


        model.addAttribute("product_liste", listem);
        return "thymeleaf6";
    }
    //Model Object Göndermek
    // http://localhost:8080/thymeleaf7
    @GetMapping({"/thymeleaf7/{id}", "/thymeleaf7"})
    public String getThymeleaf7ModelObject(Model model, @PathVariable(name = "id",required = false) Long id) {
        if(id!=null){
            model.addAttribute("key_model1", "id: "+ id);
        }else{
            model.addAttribute("key_model1", "id bulunamadı.");
        }


        return "thymeleaf7";
    }
}
