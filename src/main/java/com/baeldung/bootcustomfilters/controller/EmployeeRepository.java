
package com.baeldung.bootcustomfilters.controller;

import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaRepository<Employee, Long> 
{

}
