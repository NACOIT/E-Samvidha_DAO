package gov.naco.soch.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.constructordto.TiOstDispensationItemDTO;
import gov.naco.soch.entity.TiOstDispensationItem;

@Repository
public interface TiOstDispensationItemRepository extends JpaRepository<TiOstDispensationItem, Long> {

	List<TiOstDispensationItem> findAllByFacility_IdAndDispensationDate(Long facilityId, LocalDate now);

	List<TiOstDispensationItem> findAllByTiOstBeneficiary_IdAndDispensationDate(Long tiOstBeneficiaryId, LocalDate now);

	@Query(nativeQuery = true, value = "select MAX(t.dispensation_date) from soch.ti_ost_dispensation_item t"
			+ " where t.ti_ost_beneficiary_id=:beneficiaryId ")
	LocalDate findLastdispensationdate(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = " select ods.name from soch.ti_beneficiary_dispensation_status tbds " + 
		" join soch.master_ost_dispensation_status ods on  ods.id=tbds.dispensation_status_id " + 
		" where extract(month from tbds.dispensation_status_date)=extract(month from now()- interval '1 month') " + 
		" and tbds.ti_ost_beneficiary_id=:beneficiaryId limit 1")
	String findDispensationStatusByBeneficiary(@Param("beneficiaryId") Long beneficiaryId);
	
	@Query(nativeQuery = true, value = "select  t.last_dispensation_date as lastDispensationDate,\r\n" + 
			"		 case when top.substitution_drug=1 then concat(cast(top.dosage_qty as numeric), ' mg ')\r\n" + 
			"		when top.substitution_drug=2 then concat(cast(top.dosage_qty as numeric), ' ml ')\r\n" + 
			"		end as dosageQuantity,t.ost_dispensation_item_id from soch.ti_ost_prescription top\r\n" + 
			"		left outer join soch.ti_ost_dispensation_item  t on t.ti_ost_prescription_id = top.id\r\n" + 
			"		and t.last_dispensation_date=(select max(last_dispensation_date) as latestdate \r\n" + 
			"	   from soch.ti_ost_dispensation_item \r\n" + 
			"		where ti_ost_beneficiary_id=:beneficiaryId)\r\n" + 
			"		where t.ti_ost_beneficiary_id=:beneficiaryId order by ost_dispensation_item_id desc limit 1\r\n" + 
			"		" )
	Object findLatestDispensationDateByBeneficiary(@Param("beneficiaryId") Long beneficiaryId);

	public default TiOstDispensationItemDTO getLatestDispensationDateOfBeneficiary(Long beneficiaryId) {
		Object response = findLatestDispensationDateByBeneficiary(beneficiaryId);
		if (response instanceof Object[]) {
			Object[] values = (Object[]) response;
			TiOstDispensationItemDTO dispensation = new TiOstDispensationItemDTO();
			if (values[0] != null) {
				LocalDate date = ((Date) values[0]).toLocalDate();
				dispensation.setLastDispensationDate(date);
			}
			String dosageQuantity = ((String) values[1]);
			dispensation.setDosageQuantity(dosageQuantity);
			return dispensation;
		}
		return null;

	}

	List<TiOstDispensationItem> findAllByProduct_IdInAndFacility_IdAndDispensationDateOrProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			List<Long> productIds, Long facilityId, LocalDate date, List<Long> newProductIds, Long parentFacilityId,
			LocalDate newDate,Pageable page);
	
	List<TiOstDispensationItem> findAllByProduct_IdInAndFacility_IdAndDispensationDateOrProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			List<Long> productIds, Long facilityId, LocalDate date, List<Long> newProductIds, Long parentFacilityId,
			LocalDate newDate);

	/*
	 * List<TiOstDispensationItem>
	 * findAllByTiOstBeneficiary_Beneficiary_FirstNameAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Facility_Id(
	 * String name, List<Long> productIds, Long facilityId, LocalDate date, Long
	 * parentFacilityId);
	 */
	List<TiOstDispensationItem> findAllByTiOstBeneficiary_Beneficiary_FirstNameAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_FirstNameAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			String name, List<Long> productIds, Long facilityId, LocalDate date, String name2, List<Long> productIds2,
			Long facilityId2, LocalDate date2,Pageable page);
	
	List<TiOstDispensationItem> findAllByTiOstBeneficiary_Beneficiary_FirstNameAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_FirstNameAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			String name, List<Long> productIds, Long facilityId, LocalDate date, String name2, List<Long> productIds2,
			Long facilityId2, LocalDate date2);

	List<TiOstDispensationItem> findAllByTiOstBeneficiary_Beneficiary_UidOrTiOstBeneficiary_Beneficiary_FirstNameOrTiOstBeneficiary_Beneficiary_LastNameOrTiOstBeneficiary_Beneficiary_MiddleNameOrTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_UidOrTiOstBeneficiary_Beneficiary_FirstNameOrTiOstBeneficiary_Beneficiary_LastNameOrTiOstBeneficiary_Beneficiary_MiddleNameOrTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			String param, String param2, String param3, String param4, String param5, List<Long> productIds,
			Long facilityId, LocalDate date, String param6, String param7, String param8, String param9, String param10,
			List<Long> productIds2, Long facilityId2, LocalDate date2,Pageable page);
	
	List<TiOstDispensationItem> findAllByTiOstBeneficiary_Beneficiary_UidOrTiOstBeneficiary_Beneficiary_FirstNameOrTiOstBeneficiary_Beneficiary_LastNameOrTiOstBeneficiary_Beneficiary_MiddleNameOrTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_UidOrTiOstBeneficiary_Beneficiary_FirstNameOrTiOstBeneficiary_Beneficiary_LastNameOrTiOstBeneficiary_Beneficiary_MiddleNameOrTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			String param, String param2, String param3, String param4, String param5, List<Long> productIds,
			Long facilityId, LocalDate date, String param6, String param7, String param8, String param9, String param10,
			List<Long> productIds2, Long facilityId2, LocalDate date2);

	List<TiOstDispensationItem> findAllByTiOstBeneficiary_Beneficiary_UidAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_UidAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			String uid, List<Long> productIds, Long facilityId, LocalDate date, String uid2, List<Long> productIds2,
			Long facilityId2, LocalDate date2,Pageable page);
	
	List<TiOstDispensationItem> findAllByTiOstBeneficiary_Beneficiary_UidAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_UidAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			String uid, List<Long> productIds, Long facilityId, LocalDate date, String uid2, List<Long> productIds2,
			Long facilityId2, LocalDate date2);

	List<TiOstDispensationItem> findAllByTiOstBeneficiary_OstNumberAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_OstNumberAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			String ostNo, List<Long> productIds, Long facilityId, LocalDate date, String ostNo2, List<Long> productIds2,
			Long facilityId2, LocalDate date2,Pageable page);
	
	List<TiOstDispensationItem> findAllByTiOstBeneficiary_OstNumberAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_OstNumberAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			String ostNo, List<Long> productIds, Long facilityId, LocalDate date, String ostNo2, List<Long> productIds2,
			Long facilityId2, LocalDate date2);
	
	List<TiOstDispensationItem> findAllByTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			String mobile, List<Long> productIds, Long facilityId, LocalDate date, String mobile2,
			List<Long> productIds2, Long facilityId2, LocalDate date2,Pageable page);
	
	List<TiOstDispensationItem> findAllByTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			String mobile, List<Long> productIds, Long facilityId, LocalDate date, String mobile2,
			List<Long> productIds2, Long facilityId2, LocalDate date2);
	
}
