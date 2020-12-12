
package org.onebeartoe.boot.inventory;

import java.net.URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

/**
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InventoryControllerIT 
{
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception 
    {
        this.base = new URL("http://localhost:" + port + "/api/inventory");
    }

    /**
     * Verify the REST endpoint is available and has the default products.
     * 
     * @throws Exception 
     */
    @Test
    public void getListing() throws Exception 
    {
        ResponseEntity<Product[]> response = template.getForEntity(base.toString(),
                Product[].class);
        
        Product[] products = response.getBody();
        
        // expect the 5 default products
        assertEquals(products.length, 5);
    }    
}
