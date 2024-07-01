package com.credmarg.payment_flow_backend.Open.Repositories;

import com.credmarg.payment_flow_backend.Open.Model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long> {
}
