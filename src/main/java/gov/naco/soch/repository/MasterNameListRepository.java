
package gov.naco.soch.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterNameList;

/**
 * @date 2020-Jan-03 12:54:20 PM
 */

// repository mapped with entity class
@Repository
public interface MasterNameListRepository extends JpaRepository<MasterNameList, Long> {

}
