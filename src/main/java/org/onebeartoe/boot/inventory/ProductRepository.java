
package org.onebeartoe.boot.inventory;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Product, Long> 
{

}
