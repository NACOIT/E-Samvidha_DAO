package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.MasterReferralType;

@Repository
public interface MasterReferralTypeRepository extends JpaRepository<MasterReferralType, Long> {

	List<MasterReferralType> findByIsDelete(Boolean isDelete);

}
