package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.entity.MenuMaster;

public interface MenuMasterRepository extends JpaRepository<MenuMaster, Long> {

	@Query(value = "select m.* from soch.menu_master as m \r\n"
			+ "join soch.menu_access_mapping as mac on mac.menu_id = m.id \r\n"
			+ "where mac.access_code in :accessCodes order by m.position", nativeQuery = true)
	List<MenuMaster> findMenuByAccessList(@Param("accessCodes") List<String> accessCodes);
}
