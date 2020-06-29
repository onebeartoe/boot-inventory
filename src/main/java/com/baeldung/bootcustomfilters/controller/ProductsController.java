
package com.baeldung.bootcustomfilters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * This class sends an HTML UI for the products listing page.
 */
@Controller
public class ProductsController
{
    @GetMapping("/products")
    public String products(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)  
    {
        model.addAttribute("name", name);
        return "products";        
//        return "Product Listing";
    }
}
