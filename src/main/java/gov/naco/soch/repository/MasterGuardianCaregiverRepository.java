/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterGuardianCaregiver;


@Repository
public interface MasterGuardianCaregiverRepository extends JpaRepository<MasterGuardianCaregiver, Long> {

	
	 List<MasterGuardianCaregiver> findByIsDelete(Boolean isDelete);
}