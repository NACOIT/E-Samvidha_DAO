package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TransporterSacsMapping;

@Repository
public interface TransporterSacsMappingRepository extends JpaRepository<TransporterSacsMapping, Long> {

	@Query(nativeQuery = true, value = "select tsm.sacs_id from soch.transporter_sacs_mapping tsm left join soch.facility f on (tsm.sacs_id=f.id) where tsm.transporter_id=:id\r\n"
			+ "and tsm.is_delete=false and tsm.is_active=true and tsm.mapping_status_flag=true and f.is_active=true and f.is_delete=false")
	List<Long> findSacsIdsByTransporterId(@Param("id") Long id);

	@Query(value = "select tsm from TransporterSacsMapping tsm LEFT JOIN FETCH tsm.sacs where tsm.transporter.id=:id and tsm.mappingStatusFlag=true")
	List<TransporterSacsMapping> findByTransporterId(@Param("id") Long id);

}
