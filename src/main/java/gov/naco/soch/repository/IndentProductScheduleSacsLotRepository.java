package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.IndentProductScheduleSacsLot;
import gov.naco.soch.projection.IndentProductScheduleSacsLotProjection;

@Repository
public interface IndentProductScheduleSacsLotRepository extends JpaRepository<IndentProductScheduleSacsLot, Long> {

	@Query(nativeQuery = true, value = "select ipssl.indent_product_scedule_sacs_Id scheduleSacsId,ipssl.id as lotId,ipssl.lot_number as lotNumber,ipssl.start_date as startDate,\r\n"
			+ "ipssl.end_date as endDate,ipssl.quantity as quantity from soch.indent_product_schedule_sacs_lot ipssl\r\n"
			+ " where ipssl.indent_product_scedule_sacs_id IN :scheduleSacsIds ")
	List<IndentProductScheduleSacsLotProjection> findByIndentProductScheduleSacsId(
			@Param("scheduleSacsIds") List<Long> scheduleSacsIds);

}
