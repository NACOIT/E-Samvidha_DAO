package gov.naco.soch.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Dispensation;

//repository mapped with entity class

@Repository
public interface DispensationRepository extends JpaRepository<Dispensation, Long>  {

	@Query(nativeQuery = true , value = "select * from soch.dispensation where beneficiary_id =:benfId")
	ArrayList<Dispensation>findByBeneficiaryId(@Param("benfId") Long benfId);

	List<Dispensation> findByBeneficiaryIdAndIsDelete(Long beneficiaryId, boolean b);
}
