package gov.naco.soch.repository;

import java.util.List;

import gov.naco.soch.entity.MasterDsrcBeneficiaryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterDsrcBeneficiaryStatusRepository extends JpaRepository<MasterDsrcBeneficiaryStatus, Long> {

    List<MasterDsrcBeneficiaryStatus> findByIsDelete(Boolean isDelete);

}