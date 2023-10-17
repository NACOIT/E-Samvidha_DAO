package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTransportationStatus;
import gov.naco.soch.entity.TransporterSacsMapping;

@Repository
public interface MasterTransportationStatusRepository extends JpaRepository<TransporterSacsMapping, Long> {

	@Query(value="select mts from MasterTransportationStatus mts where LOWER(mts.name)=:statusCode")
	MasterTransportationStatus findByName(@Param("statusCode")String statusCode);

}
