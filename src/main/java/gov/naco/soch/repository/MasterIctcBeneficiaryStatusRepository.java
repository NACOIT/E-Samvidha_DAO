package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterIctcBeneficiaryStatus;

@Repository
public interface MasterIctcBeneficiaryStatusRepository extends JpaRepository<MasterIctcBeneficiaryStatus, Long> {

	List<MasterIctcBeneficiaryStatus> findByIsDelete(Boolean isDelete);

}
