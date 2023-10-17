/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterFourSScreening;
import gov.naco.soch.entity.MasterFourSsymptom;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Jun-04 6:22:10 pm 
 * 
 */
@Repository
public interface  MasterFourSsymptomRepository extends JpaRepository<MasterFourSsymptom, Long> {

	List<MasterFourSsymptom> findByIsDelete(Boolean isDelete);

}