package gov.naco.soch.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ContractProductScheduleSacsLot;
import gov.naco.soch.projection.ContractProductScheduleSacsLotProjection;
import gov.naco.soch.projection.LotProjection;

@Repository
public interface ContractProductScheduleSacsLotRepository extends JpaRepository<ContractProductScheduleSacsLot, Long> {

	@Query(nativeQuery = true, value = "select * from soch.contract_product_schedule_sacs_lot cpssl join "
			+ "soch.contract_product_schedule_sacs cpss on (cpssl.contract_product_scedule_sacs_id=cpss.id) join "
			+ "soch.contract_product_schedule cps on(cpss.contract_product_schedule_id=cps.id) "
			+ "where cps.schedule_number=(:scheduleNumber) ")
	Set<ContractProductScheduleSacsLot> findLotsByScheduleNumber(@Param("scheduleNumber") String scheduleNumber);

	Set<ContractProductScheduleSacsLot> findAllByContractProductScheduleSac_ContractProductSchedule_ContractProduct_Contract_ContractId(
			Integer contractId);

	Set<ContractProductScheduleSacsLot> findAllByContractProductScheduleSac_ContractProductSchedule_ContractProduct_Contract_ContractIdAndContractProductScheduleSac_ContractProductSchedule_ContractProduct_Product_Id(
			Long contractId, Long productId);

	Set<ContractProductScheduleSacsLot> findAllByContractProductScheduleSac_ContractProductSchedule_ContractProduct_Contract_ContractIdAndContractProductScheduleSac_ContractProductSchedule_ContractProduct_Product_IdAndContractProductScheduleSac_Facility_IdOrderByStartDateAsc(
			Long contractId, Long productId, Long sacsId);

	@Query(nativeQuery = true, value = "SELECT distinct cpssl.lot_number\r\n"
			+ "FROM soch.contract_product_schedule_sacs_lot cpssl\r\n"
			+ "join soch.contract_product_schedule_sacs cpss on\r\n"
			+ "(cpssl.contract_product_scedule_sacs_id=cpss.id) join soch.contract_product_schedule cps on \r\n"
			+ "(cpss.contract_product_schedule_id=cps.id) where cps.id=:sheduleId")
	List<String> findLotsByscheduleId(@Param("sheduleId") Long id);

	@Query(nativeQuery = true, value = "select distinct cpssl.start_date as startDate,cpssl.end_date as enddate,cpssl.lot_number lotNumber from\r\n"
			+ "soch.contract_product_schedule_sacs_lot cpssl\r\n"
			+ "join soch.contract_product_schedule_sacs cpss on\r\n"
			+ "(cpssl.contract_product_scedule_sacs_id=cpss.id) join soch.contract_product_schedule cps on \r\n"
			+ "(cpss.contract_product_schedule_id=cps.id) where cps.id=:sheduleId and cpssl.lot_number=:lot")
	LotProjection findLotDetailsByLotNumberAndScheduleId(@Param("sheduleId") Long sheduleId,
			@Param("lot") String lot);

	@Query(nativeQuery=true,value="select cpssl.id as lotId,cpssl.lot_number as lotNumber,\r\n" + 
			"cpssl.start_date as startDate,cpssl.end_date as endDate,\r\n" + 
			"cpssl.quantity as quantity,cpssl.contract_product_scedule_sacs_id\r\n" + 
			"as scheduleSacsId from soch.contract_product_schedule_sacs_lot cpssl where cpssl.contract_product_scedule_sacs_id in :sacsIds ")
	List<ContractProductScheduleSacsLotProjection> findBySacsIds(@Param("sacsIds")List<Integer> sacsIds);

}
