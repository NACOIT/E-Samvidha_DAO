package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterOstStatusBeneficiary;

@Repository
public interface MasterOstStatusBeneficiaryRepository extends JpaRepository<MasterOstStatusBeneficiary, Long> {

	List<MasterOstStatusBeneficiary> findByIsDelete(Boolean isDelete);

}