package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Address;
import gov.naco.soch.projection.WhiteCardDetailsProjection;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> ,JpaSpecificationExecutor<Address>{

	@Query(nativeQuery=true, value="select concat(ad.address_line_one,' ',ad.address_line_two) as caregiverAddress from soch.address ad where " + 
			"ad.id = :caregiverAddressId")
	WhiteCardDetailsProjection findAddressDetails(@Param("caregiverAddressId") Integer caregiverAddressId);

}
