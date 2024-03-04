package com.scaler.productService.inheritanceExample.singleTable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.productService.inheritanceExample.tablePerClass.Student;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long>{ 

}
