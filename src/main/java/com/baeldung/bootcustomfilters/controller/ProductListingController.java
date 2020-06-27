
package com.baeldung.bootcustomfilters.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * This class sends an HTML UI for the products listing page.
 */
@RestController
public class ProductListingController
{
    @RequestMapping("/products")
    public String index() 
    {
        return "Product Listing";
    }
}
