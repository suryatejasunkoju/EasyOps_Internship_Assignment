package com.example.EasyOpsAssignment.Repository;

import com.example.EasyOpsAssignment.Entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long>{

}
