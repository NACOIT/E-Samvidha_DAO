package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ContractProductScheduleSac;
import gov.naco.soch.projection.ContractProductScheduleLotSacsProjection;
import gov.naco.soch.projection.ContractProductScheduleSacsProjection;

@Repository
public interface ContractProductScheduleSacRepository extends JpaRepository<ContractProductScheduleSac, Long> {

	@Query(nativeQuery = true, value = "select * from soch.Contract_product_schedule_sacs cpss join "
			+ "soch.contract_product_schedule cps on (cpss.contract_product_schedule_id=cps.id) join "
			+ " soch.contract_product cp on (cp.id=cps.contract_product_id) join "
			+ "soch.contract c on (c.contract_id=cp.contract_id) where to_facility=(:sacsId)")
	List<ContractProductScheduleSac> findByFacility(@Param("sacsId") Integer sacsId);

	@Query(nativeQuery = true, value = "SELECT cpss.id as contractProductscheduleSacsId,cpssl.id as\r\n"
			+ "contractProductScheduleSacsLotId,\r\n" + "f.name as facilityName,f.id as facilityId,\r\n"
			+ "cpssl.lot_number as lotNumber,cpssl.quantity as lotQuantity,sum(db.quantity_number) as dispatchQuantity\r\n"
			+ "FROM soch.contract_product_schedule_sacs cpss\r\n" + "join soch.contract_product_schedule cps\r\n"
			+ "on (cpss.contract_product_schedule_id=cps.id)\r\n"
			+ "join soch.contract_product_schedule_sacs_lot cpssl\r\n"
			+ "on(cpssl.contract_product_scedule_sacs_id=cpss.id)\r\n"
			+ "join soch.facility f on (f.id=cpss.to_facility)\r\n"
			+ "left join soch.dispatch d on(d.lot_id=cpssl.id)\r\n"
			+ "left join soch.dispatch_batch db on(d.dispatch_id=db.dispatch_id)\r\n"
			+ "where cps.id=:scheduleId AND  f.facility_type_id IN :facilityTypeIds  and\r\n"
			+ "cpssl.lot_number=:lotNumber and coalesce(d.dispatch_status_id,0) not in (3,4) and coalesce(db.is_active,true)=true group by cpss.id,cpssl.id,f.id,f.name,cpssl.lot_number")
	List<ContractProductScheduleLotSacsProjection> findFacilityByScheduleId(@Param("scheduleId") Long scheduleId,
			@Param("facilityTypeIds") List<Long> facilityTypeIds, @Param("lotNumber") String lotNumber);

	@Query(nativeQuery=true,value = "select cpss.id as contractProductScheduleSacsId,\r\n"
			+ "cpss.to_facility as facilityId,f.name as facilityName,f.facility_type_id as facilityTypeId,\r\n"
			+ "cpss.contract_product_schedule_id scheduleId,a.state_id as stateId\r\n"
			+ "from soch.contract_product_schedule_sacs cpss \r\n"
			+ "join soch.facility f on(cpss.to_facility=f.id)\r\n"
			+ "join soch.address a on(f.address_id=a.id) where cpss.contract_product_schedule_id in :scheduleIds ")
	List<ContractProductScheduleSacsProjection> findByScheduleId(@Param("scheduleIds") List<Long> scheduleIds);

}
