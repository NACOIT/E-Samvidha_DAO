package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.PediatricBeneficiaryEntity;


@Repository
public interface PediatricBeneficiaryRepository extends JpaRepository<PediatricBeneficiaryEntity, Long> {

}
