package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Pincode;

@Repository
public interface PincodeRepository extends JpaRepository<Pincode, Long> {

	Optional<Pincode> findByPincode(String pincode);

}
