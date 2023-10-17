package gov.naco.soch.repository;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import gov.naco.soch.entity.OstDispensationItem;
import gov.naco.soch.projection.DailyDispensationListProjection;

@Repository
public interface OstDispensationItemRepository 
extends JpaRepository<OstDispensationItem, Long>, JpaSpecificationExecutor<OstDispensationItem> {

	@Query(nativeQuery = true, value = "select case when  coalesce(max(t.take_home_date),max(t.dispensation_date))<= max(t.dispensation_date) " + 
		" then MAX(t.dispensation_date) else MAX(t.take_home_date) end from soch.ti_ost_dispensation_item t "
			+ " where t.ti_ost_beneficiary_id=:beneficiaryId  ")
	LocalDate findLastdispensationdate(@Param("beneficiaryId") Long beneficiaryId);
	
	@Query(nativeQuery = true, value = "select distinct t.last_dispensation_date as lastDispensationDate, " + 
			"   case when top.substitution_drug=1 then concat(cast(top.dosage_qty as numeric), ' mg ') " + 
			"   when top.substitution_drug=2 then concat(cast(top.dosage_qty as numeric), ' ml ') " + 
			"   end as dosageQuantity from soch.ti_ost_prescription top " + 
			"   left outer join soch.ti_ost_dispensation_item  t on t.ti_ost_prescription_id = top.id " + 
			"   and t.last_dispensation_date=(select max(last_dispensation_date) as latestdate from soch.ti_ost_dispensation_item " + 
			"   where ti_ost_beneficiary_id=:beneficiaryId) " + 
			"   where top.ti_ost_beneficiary_id=:beneficiaryId and top.id=(select max(id) from soch.ti_ost_prescription where ti_ost_beneficiary_id=:beneficiaryId)" )
		Object findLatestDispensationDateByBeneficiary(@Param("beneficiaryId") Long beneficiaryId);

		public default OstDispensationItem getLatestDispensationDateOfBeneficiary(Long beneficiaryId) {
			Object response = findLatestDispensationDateByBeneficiary(beneficiaryId);
			if (response instanceof Object[]) {
				Object[] values = (Object[]) response;
				OstDispensationItem dispensation = new OstDispensationItem();
				if (values[0] != null) {
					LocalDate date = ((Date) values[0]).toLocalDate();
					dispensation.setLastDispensationDate(date);
				}
				Double dosageQuantity = ((Double) values[1]);
				dispensation.setDosageQty(dosageQuantity);
				return dispensation;
			}
			return null;

		}
		
		
		@Query(nativeQuery = true, value = " select ods.name from soch.ti_beneficiary_dispensation_status tbds " + 
				" join soch.master_ost_dispensation_status ods on  ods.id=tbds.dispensation_status_id " + 
				" where extract(month from tbds.dispensation_status_date)=extract(month from now()- interval '1 month') " + 
				" and tbds.ti_ost_beneficiary_id=:beneficiaryId")
			String findDispensationStatusByBeneficiary(@Param("beneficiaryId") Long beneficiaryId);
		
		
		@Query(value = "select distinct tob.id as Id,b.uid as Uid,tob.ost_number as OstNumber, \r\n" + 
				"CONCAT( b.first_name,' ', b.last_name ) as name, mg.name as Gender,b.date_of_birth as dateOfBirth,\r\n" + 
				"todi.last_dispensation_date as LastDispensationDate,md.name as Drug,top.dosage_qty as Dosage, \r\n" + 
				"b.age,b.first_name,b.id as Beneficiaryid,top.id as PrescriptionId,tob.is_transit as IsTransit from soch.ti_ost_beneficiary tob\r\n" + 
				"join soch.beneficiary b on b.id = tob.beneficiary_id\r\n" + 
				"join soch.master_gender mg on mg.id = b.gender_id   \r\n" + 
				"join soch.ti_ost_assessment toa on toa.ti_ost_beneficiary_id= tob.id  and tob.facility_id =toa.facility_id\r\n" + 
				"and tob.consent_taken_date <=:date\r\n" + 
				"AND (tob.transit_start_date is null or (tob.transit_start_date <=:date AND :date<= tob.transit_end_date))\r\n" + 
				"and tob.facility_id =:facilityId\r\n" + 
				"join soch.ti_ost_follow_up tof on tof.ti_ost_beneficiary_id = tob.id and tof.facility_id=tob.facility_id\r\n" + 
				"left join soch.ti_ost_prescription top on top.facility_id= tob.facility_id and top.ost_assessment_id =toa.id\r\n" +
			//	"and top.ost_follow_up_id =tof.id \r\n"+
				"and top.ti_ost_beneficiary_id =tob.id\r\n" + 
				"left join soch.ti_ost_dispensation_item todi on todi.facility_id =tob.facility_id and todi.facility_id =:facilityId\r\n" + 
				"and todi.ti_ost_beneficiary_id=tob.id and todi.ti_ost_prescription_id= top.id\r\n" + 
				"and ( todi.dispensation_date is null or ( todi.dispensation_date <> :date AND :date between todi.dispensation_date AND Coalesce(todi.take_home_date,todi.dispensation_date)))\r\n" + 
				"left join soch.master_client_status_ost mcso ON mcso.id = tob.ost_status_id and mcso.id in (1,7)\r\n" + 
				"left join soch.master_drugs md on md.id =:drug\r\n" + 
				"join soch.master_ost_status_beneficiary mosb on mosb.id=tob.ost_status_id and mosb.id =2\r\n" +
				"where (b.uid ilike %:param% or '' like %:param% or tob.ost_number ilike %:param% or b.first_name ilike %:param% or b.last_name ilike %:param% \r\n" + 
				"or b.mobile_number ilike %:param% or CONCAT( b.first_name,' ', b.last_name ) ilike %:param%)",
				nativeQuery = true)
		Page<DailyDispensationListProjection> getDailyDispensationOstBeneficiaryList(@Param("facilityId") Long facilityId , Pageable pageable ,
				 @Param("param") String param, @Param("date") LocalDate date, @Param("drug") Long drug);
		
		@Query(value = "select distinct tob.id as Id,b.uid as Uid,tob.ost_number as OstNumber, \r\n" + 
				"CONCAT( b.first_name,' ', b.last_name ) as name, mg.name as Gender,b.date_of_birth as dateOfBirth,\r\n" + 
				"todi.last_dispensation_date as LastDispensationDate,md.name as Drug,top.dosage_qty as Dosage, \r\n" + 
				"b.age,b.first_name,b.id as Beneficiaryid,top.id as PrescriptionId,tob.is_transit as IsTransit from soch.ti_ost_beneficiary tob\r\n" + 
				"join soch.beneficiary b on b.id = tob.beneficiary_id\r\n" + 
				"join soch.master_gender mg on mg.id = b.gender_id   \r\n" + 
				"join soch.ti_ost_assessment toa on toa.ti_ost_beneficiary_id= tob.id\r\n" + 
				"and tob.consent_taken_date <=:date\r\n" + 
				"AND (tob.transit_start_date is null or (tob.transit_start_date <=:date AND :date<= tob.transit_end_date))\r\n" + 
				"and tob.linked_facility_id =:linkedFacilityId\r\n" + 
				"join soch.ti_ost_follow_up tof on tof.ti_ost_beneficiary_id = tob.id\r\n" + 
				"left join soch.ti_ost_prescription top on top.ost_assessment_id =toa.id\r\n" + 
				"and top.ti_ost_beneficiary_id =tob.id\r\n" + 
				"left join soch.ti_ost_dispensation_item todi on \r\n" + 
				"todi.ti_ost_beneficiary_id=tob.id and todi.ti_ost_prescription_id= top.id\r\n" + 
				"and ( todi.dispensation_date is null or ( todi.dispensation_date <> :date AND :date between todi.dispensation_date AND Coalesce(todi.take_home_date,todi.dispensation_date)))\r\n" + 
				"left join soch.master_client_status_ost mcso ON mcso.id = tob.ost_status_id and mcso.id in (1,7)\r\n" + 
				"left join soch.master_drugs md on md.id =:drug\r\n" + 
				"join soch.master_ost_status_beneficiary mosb on mosb.id=tob.ost_status_id and mosb.id =2\r\n" + 
				"where (b.uid ilike %:param% or '' like %:param% or tob.ost_number ilike %:param% or b.first_name ilike %:param% or b.last_name ilike %:param% \r\n" + 
				"or b.mobile_number ilike %:param% or CONCAT( b.first_name,' ', b.last_name ) ilike %:param%)",
				nativeQuery = true)
		Page<DailyDispensationListProjection> getDailyDispensationOstBeneficiaryListForSatOst(@Param("linkedFacilityId") Long linkedFacilityId , Pageable pageable ,
				 @Param("param") String param, @Param("date") LocalDate date, @Param("drug") Long drug);
		
		
		
		// New Working Query for Daily Dispensation
		
		@Query(value = "SELECT count( DISTINCT ostbensube0_)\r\n" + 
				"FROM soch.ti_ost_beneficiary ostbensube0_\r\n" + 
				"LEFT OUTER JOIN soch.ti_ost_assessment ostassess1_ ON ostbensube0_.id = ostassess1_.ti_ost_beneficiary_id\r\n" + 
				"LEFT OUTER JOIN soch.ti_ost_prescription tiostpresc2_ ON ostassess1_.id = tiostpresc2_.ost_assessment_id\r\n" + 
				"LEFT OUTER JOIN soch.ti_ost_follow_up ostfollowu3_ ON ostbensube0_.id = ostfollowu3_.ti_ost_beneficiary_id\r\n" + 
				"LEFT OUTER JOIN soch.ti_ost_prescription tiostpresc5_ ON ostbensube0_.id = tiostpresc5_.ti_ost_beneficiary_id\r\n" + 
				"LEFT OUTER JOIN soch.master_drugs masterdrug4_ ON tiostpresc5_.substitution_drug = masterdrug4_.id\r\n" + 
				"JOIN soch.beneficiary b ON b.id = ostbensube0_.beneficiary_id\r\n" + 
				"JOIN soch.master_gender mg ON mg.id = b.gender_id\r\n" + 
				"LEFT JOIN soch.ti_ost_dispensation_item todi ON todi.facility_id = ostbensube0_.facility_id\r\n" + 
				"AND todi.ti_ost_beneficiary_id = ostbensube0_.id\r\n" + 
				"WHERE  (lower(b.ost_benf_search_str) like %:searchString%) and ostbensube0_.is_delete = false AND (tiostpresc5_.id in\r\n" + 
				" (SELECT max(ostprescri6_.id) FROM soch.ti_ost_prescription ostprescri6_\r\n" + 
				"LEFT OUTER JOIN soch.ti_ost_beneficiary ostbensube7_ ON ostprescri6_.ti_ost_beneficiary_id = ostbensube7_.id\r\n" + 
				"LEFT OUTER JOIN soch.master_client_status_ost masterostc8_ ON ostbensube7_.status_id = masterostc8_.id\r\n" + 
				"LEFT OUTER JOIN soch.master_ost_status_beneficiary masterbene9_ ON ostbensube7_.ost_status_id = masterbene9_.id\r\n" + 
				"JOIN soch.master_drugs masterdrug10_ ON ostprescri6_.substitution_drug = masterdrug10_.id\r\n" + 
				"WHERE masterbene9_.id = 2 AND ostbensube7_.facility_id = :facilityId AND ostbensube7_.consent_taken_date <=:date \r\n" + 
				"AND ostbensube7_.linked_facility_id IS null AND masterostc8_.id in (1,7)\r\n" + 
				"AND (ostbensube7_.id not in (SELECT ostdispens12_.ti_ost_beneficiary_id\r\n" + 
				"FROM soch.ti_ost_dispensation_item ostdispens12_ WHERE (ostdispens12_.dispensation_date =:date\r\n" + 
				" OR :date BETWEEN ostdispens12_.dispensation_date AND Coalesce(ostdispens12_.take_home_date, ostdispens12_.dispensation_date))\r\n" + 
				" AND ostdispens12_.facility_id =:facilityId )) AND masterdrug10_.id =:drug\r\n" + 
				" GROUP BY ostbensube7_.id))  AND (ostbensube0_.id not in\r\n" + 
				" (SELECT ostbensube13_.id  FROM soch.ti_ost_beneficiary ostbensube13_ WHERE ostbensube13_.transit_start_date <=:date\r\n" + 
				"AND :date <= ostbensube13_.transit_end_date AND ostbensube13_.facility_id =:facilityId))\r\n" + 
				"AND ostbensube0_.facility_id = :facilityId",nativeQuery = true)
		Long getDailyDispensationOstBeneficiaryListCount(@Param("facilityId") Long facilityId ,
				 @Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug);
		
		@Query(value = "SELECT tiostpresc5_.id AS PrescriptionId,ostbensube0_.id AS Id, b.uid AS UID,ostbensube0_.ost_number AS OstNumber, \r\n"
				+ " Concat(b.first_name, ' ', b.last_name) AS name,mg.name AS Gender,b.date_of_birth AS dateOfBirth,masterdrug4_.name AS Drug, \r\n"
				+ " tiostpresc5_.dosage_qty AS Dosage,max(todi.last_dispensation_date) AS dispensationDate,b.age AS age,b.first_name AS firstName "
				+ " FROM soch.ti_ost_beneficiary ostbensube0_ \r\n"
				+ " left JOIN soch.ti_ost_prescription tiostpresc5_ ON ostbensube0_.id = tiostpresc5_.ti_ost_beneficiary_id and tiostpresc5_.facility_id = :facilityId \r\n"
				+ " JOIN soch.master_drugs masterdrug4_ ON tiostpresc5_.substitution_drug = masterdrug4_.id \r\n"
				+ " JOIN soch.beneficiary b ON b.id = ostbensube0_.beneficiary_id \r\n"
				+ " JOIN soch.master_gender mg ON mg.id = b.gender_id \r\n"
				+ " left JOIN soch.ti_ost_dispensation_item todi ON todi.facility_id = ostbensube0_.facility_id AND todi.ti_ost_beneficiary_id = ostbensube0_.id  and todi.facility_id = :facilityId \r\n"
				+ " WHERE  ostbensube0_.is_delete = false and ostbensube0_.facility_id = :facilityId \r\n"
				+ " AND (lower(b.ost_benf_search_str) like %:searchString%) \r\n"
				+ " AND (ostbensube0_.id not in \r\n"
				+ " (SELECT ostbensube13_.id  FROM soch.ti_ost_beneficiary ostbensube13_ \r\n"
				+ " WHERE  ostbensube13_.facility_id = :facilityId and ostbensube13_.is_delete = false and \r\n"
				+ " ostbensube13_.transit_start_date <= :date AND :date <= ostbensube13_.transit_end_date )) \r\n"
				+ " AND (tiostpresc5_.id in \r\n"
				+ " (SELECT max(ostprescri6_.id) FROM soch.ti_ost_prescription ostprescri6_ \r\n"
				+ " JOIN soch.ti_ost_beneficiary ostbensube7_ ON ostprescri6_.ti_ost_beneficiary_id = ostbensube7_.id \r\n"
				+ " JOIN soch.master_client_status_ost masterostc8_ ON ostbensube7_.status_id = masterostc8_.id \r\n"
				+ " JOIN soch.master_ost_status_beneficiary masterbene9_ ON ostbensube7_.ost_status_id = masterbene9_.id \r\n"
				+ " JOIN soch.master_drugs masterdrug10_ ON ostprescri6_.substitution_drug = masterdrug10_.id \r\n"
				+ " WHERE masterbene9_.id =2 AND ostbensube7_.linked_facility_id IS null AND masterostc8_.id in (1,7) \r\n"
				+ " AND ostbensube7_.facility_id = :facilityId and ostprescri6_.facility_id = :facilityId \r\n"
				+ " AND ostbensube7_.consent_taken_date <= :date \r\n"
				+ " AND (ostbensube7_.id not in \r\n"
				+ " (SELECT ostdispens12_.ti_ost_beneficiary_id FROM soch.ti_ost_dispensation_item ostdispens12_ \r\n"
				+ " WHERE ostdispens12_.facility_id =:facilityId and ostdispens12_.is_deleted = false and \r\n"
				+ " (ostdispens12_.dispensation_date = :date OR :date BETWEEN ostdispens12_.dispensation_date \r\n"
				+ " AND Coalesce(ostdispens12_.take_home_date, ostdispens12_.dispensation_date)) \r\n"
				+ " )) AND masterdrug10_.id = :drug GROUP BY ostbensube7_.id)) \r\n"
				+ " GROUP BY tiostpresc5_.id,ostbensube0_.id,b.uid,ostbensube0_.ost_number,Concat(b.first_name, ' ', b.last_name),mg.name, \r\n"
				+ " b.date_of_birth,masterdrug4_.name,tiostpresc5_.dosage_qty,b.age,b.first_name \r\n"
				+ " ORDER BY ostbensube0_.id \r\n"
				+ "  ",		nativeQuery = true)
		Page<DailyDispensationListProjection> getDailyDispensationOstBeneficiaryList1(@Param("facilityId") Long facilityId , Pageable pageable ,
				 @Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug);
		
		
		@Query(value = "SELECT tiostpresc5_.id AS PrescriptionId,ostbensube0_.id AS Id, b.uid AS UID,ostbensube0_.ost_number AS OstNumber, \r\n"
				+ " Concat(b.first_name, ' ', b.last_name) AS name,mg.name AS Gender,b.date_of_birth AS dateOfBirth,masterdrug4_.name AS Drug, \r\n"
				+ " tiostpresc5_.dosage_qty AS Dosage,max(todi.last_dispensation_date) AS dispensationDate,b.age AS age,b.first_name AS firstName "
				+ " FROM soch.ti_ost_beneficiary ostbensube0_ \r\n"
				+ " left JOIN soch.ti_ost_prescription tiostpresc5_ ON ostbensube0_.id = tiostpresc5_.ti_ost_beneficiary_id and tiostpresc5_.facility_id = :facilityId \r\n"
				+ " JOIN soch.master_drugs masterdrug4_ ON tiostpresc5_.substitution_drug = masterdrug4_.id \r\n"
				+ " JOIN soch.beneficiary b ON b.id = ostbensube0_.beneficiary_id \r\n"
				+ " JOIN soch.master_gender mg ON mg.id = b.gender_id \r\n"
				+ " left JOIN soch.ti_ost_dispensation_item todi ON todi.facility_id = ostbensube0_.facility_id AND todi.ti_ost_beneficiary_id = ostbensube0_.id  and todi.facility_id = :facilityId \r\n"
				+ " WHERE  ostbensube0_.is_delete = false and ostbensube0_.facility_id = :facilityId \r\n"
				+ " AND (lower(b.ost_benf_search_str) like %:searchString%) \r\n"
				+ " AND (ostbensube0_.id not in \r\n"
				+ " (SELECT ostbensube13_.id  FROM soch.ti_ost_beneficiary ostbensube13_ \r\n"
				+ " WHERE  ostbensube13_.facility_id = :facilityId and ostbensube13_.is_delete = false and \r\n"
				+ " ostbensube13_.transit_start_date <= :date AND :date <= ostbensube13_.transit_end_date )) \r\n"
				+ " AND (tiostpresc5_.id in \r\n"
				+ " (SELECT max(ostprescri6_.id) FROM soch.ti_ost_prescription ostprescri6_ \r\n"
				+ " JOIN soch.ti_ost_beneficiary ostbensube7_ ON ostprescri6_.ti_ost_beneficiary_id = ostbensube7_.id \r\n"
				+ " JOIN soch.master_client_status_ost masterostc8_ ON ostbensube7_.status_id = masterostc8_.id \r\n"
				+ " JOIN soch.master_ost_status_beneficiary masterbene9_ ON ostbensube7_.ost_status_id = masterbene9_.id \r\n"
				+ " JOIN soch.master_drugs masterdrug10_ ON ostprescri6_.substitution_drug = masterdrug10_.id \r\n"
				+ " WHERE masterbene9_.id =2 AND ostbensube7_.linked_facility_id IS null AND masterostc8_.id in (1,7) \r\n"
				+ " AND ostbensube7_.facility_id = :facilityId and ostprescri6_.facility_id = :facilityId \r\n"
				+ " AND ostbensube7_.consent_taken_date <= :date \r\n"
				+ " AND (ostbensube7_.id not in \r\n"
				+ " (SELECT ostdispens12_.ti_ost_beneficiary_id FROM soch.ti_ost_dispensation_item ostdispens12_ \r\n"
				+ " WHERE ostdispens12_.facility_id =:facilityId and ostdispens12_.is_deleted = false and \r\n"
				+ " (ostdispens12_.dispensation_date = :date OR :date BETWEEN ostdispens12_.dispensation_date \r\n"
				+ " AND Coalesce(ostdispens12_.take_home_date, ostdispens12_.dispensation_date)) \r\n"
				+ " )) AND masterdrug10_.id = :drug GROUP BY ostbensube7_.id)) \r\n"
				+ " GROUP BY tiostpresc5_.id,ostbensube0_.id,b.uid,ostbensube0_.ost_number,Concat(b.first_name, ' ', b.last_name),mg.name, \r\n"
				+ " b.date_of_birth,masterdrug4_.name,tiostpresc5_.dosage_qty,b.age,b.first_name \r\n"
				+ " order by  SUBSTRING(ostbensube0_.ost_number FROM '([0-9]+)')\\:\\:BIGINT ASC, ostbensube0_.ost_number"
				+ " ",nativeQuery = true)
		Page<DailyDispensationListProjection> getDailyDispensationOstBeneficiaryListSortByOStNumberAsc(@Param("facilityId") Long facilityId , Pageable pageable ,
				 @Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug);
		
		
		@Query(value = "SELECT tiostpresc5_.id AS PrescriptionId,ostbensube0_.id AS Id, b.uid AS UID,ostbensube0_.ost_number AS OstNumber, \r\n"
				+ " Concat(b.first_name, ' ', b.last_name) AS name,mg.name AS Gender,b.date_of_birth AS dateOfBirth,masterdrug4_.name AS Drug, \r\n"
				+ " tiostpresc5_.dosage_qty AS Dosage,max(todi.last_dispensation_date) AS dispensationDate,b.age AS age,b.first_name AS firstName "
				+ " FROM soch.ti_ost_beneficiary ostbensube0_ \r\n"
				+ " left JOIN soch.ti_ost_prescription tiostpresc5_ ON ostbensube0_.id = tiostpresc5_.ti_ost_beneficiary_id and tiostpresc5_.facility_id = :facilityId \r\n"
				+ " JOIN soch.master_drugs masterdrug4_ ON tiostpresc5_.substitution_drug = masterdrug4_.id \r\n"
				+ " JOIN soch.beneficiary b ON b.id = ostbensube0_.beneficiary_id \r\n"
				+ " JOIN soch.master_gender mg ON mg.id = b.gender_id \r\n"
				+ " left JOIN soch.ti_ost_dispensation_item todi ON todi.facility_id = ostbensube0_.facility_id AND todi.ti_ost_beneficiary_id = ostbensube0_.id  and todi.facility_id = :facilityId \r\n"
				+ " WHERE  ostbensube0_.is_delete = false and ostbensube0_.facility_id = :facilityId \r\n"
				+ " AND (lower(b.ost_benf_search_str) like %:searchString%) \r\n"
				+ " AND (ostbensube0_.id not in \r\n"
				+ " (SELECT ostbensube13_.id  FROM soch.ti_ost_beneficiary ostbensube13_ \r\n"
				+ " WHERE  ostbensube13_.facility_id = :facilityId and ostbensube13_.is_delete = false and \r\n"
				+ " ostbensube13_.transit_start_date <= :date AND :date <= ostbensube13_.transit_end_date )) \r\n"
				+ " AND (tiostpresc5_.id in \r\n"
				+ " (SELECT max(ostprescri6_.id) FROM soch.ti_ost_prescription ostprescri6_ \r\n"
				+ " JOIN soch.ti_ost_beneficiary ostbensube7_ ON ostprescri6_.ti_ost_beneficiary_id = ostbensube7_.id \r\n"
				+ " JOIN soch.master_client_status_ost masterostc8_ ON ostbensube7_.status_id = masterostc8_.id \r\n"
				+ " JOIN soch.master_ost_status_beneficiary masterbene9_ ON ostbensube7_.ost_status_id = masterbene9_.id \r\n"
				+ " JOIN soch.master_drugs masterdrug10_ ON ostprescri6_.substitution_drug = masterdrug10_.id \r\n"
				+ " WHERE masterbene9_.id =2 AND ostbensube7_.linked_facility_id IS null AND masterostc8_.id in (1,7) \r\n"
				+ " AND ostbensube7_.facility_id = :facilityId and ostprescri6_.facility_id = :facilityId \r\n"
				+ " AND ostbensube7_.consent_taken_date <= :date \r\n"
				+ " AND (ostbensube7_.id not in \r\n"
				+ " (SELECT ostdispens12_.ti_ost_beneficiary_id FROM soch.ti_ost_dispensation_item ostdispens12_ \r\n"
				+ " WHERE ostdispens12_.facility_id =:facilityId and ostdispens12_.is_deleted = false and \r\n"
				+ " (ostdispens12_.dispensation_date = :date OR :date BETWEEN ostdispens12_.dispensation_date \r\n"
				+ " AND Coalesce(ostdispens12_.take_home_date, ostdispens12_.dispensation_date)) \r\n"
				+ " )) AND masterdrug10_.id = :drug GROUP BY ostbensube7_.id)) \r\n"
				+ " GROUP BY tiostpresc5_.id,ostbensube0_.id,b.uid,ostbensube0_.ost_number,Concat(b.first_name, ' ', b.last_name),mg.name, \r\n"
				+ " b.date_of_birth,masterdrug4_.name,tiostpresc5_.dosage_qty,b.age,b.first_name \r\n"
				+ " order by  SUBSTRING(ostbensube0_.ost_number FROM '([0-9]+)')\\:\\:BIGINT DESC, ostbensube0_.ost_number"
				+ " ",nativeQuery = true)
		Page<DailyDispensationListProjection> getDailyDispensationOstBeneficiaryListSortByOStNumberDesc(@Param("facilityId") Long facilityId , Pageable pageable ,
				 @Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug);
	
		
		@Query(value = "SELECT count( DISTINCT ostbensube0_) FROM soch.ti_ost_beneficiary ostbensube0_ LEFT OUTER JOIN \r\n" + 
				"soch.ti_ost_assessment ostassess1_ ON ostbensube0_.id = ostassess1_.ti_ost_beneficiary_id LEFT OUTER JOIN\r\n" + 
				"soch.ti_ost_prescription tiostpresc3_ ON ostbensube0_.id = tiostpresc3_.ti_ost_beneficiary_id LEFT OUTER JOIN\r\n" + 
				"soch.master_drugs masterdrug4_ ON tiostpresc3_.substitution_drug = masterdrug4_.id JOIN soch.beneficiary b \r\n" + 
				"ON b.id = ostbensube0_.beneficiary_id JOIN soch.master_gender mg ON mg.id = b.gender_id LEFT JOIN\r\n" + 
				"soch.ti_ost_dispensation_item todi ON todi.facility_id = ostbensube0_.facility_id and todi.ti_ost_beneficiary_id = ostbensube0_.id\r\n" + 
				"WHERE (lower(b.ost_benf_search_str) like %:searchString%) \r\n"+
				"and ostbensube0_.is_delete = false AND( tiostpresc3_.id IN\r\n" + 
				"( SELECT Max(ostprescri7_.id) FROM soch.ti_ost_prescription ostprescri7_ LEFT OUTER JOIN soch.ti_ost_beneficiary ostbensube8_ ON\r\n" + 
				" ostprescri7_.ti_ost_beneficiary_id = ostbensube8_.id LEFT OUTER JOIN soch.master_ost_status_beneficiary masterbene9_ ON\r\n" + 
				" ostbensube8_.ost_status_id = masterbene9_.id LEFT OUTER JOIN soch.master_client_status_ost masterostc10_ ON\r\n" + 
				" ostbensube8_.status_id = masterostc10_.id WHERE masterbene9_.id = 2 AND ostbensube8_.consent_taken_date <=:date AND\r\n" + 
				" masterostc10_.id IN ( 1, 7) AND ostbensube8_.linked_facility_id =:linkedFacilityId  AND\r\n" + 
				" ( ostbensube8_.id NOT IN ( SELECT ostbensube11_.id FROM soch.ti_ost_beneficiary ostbensube11_ \r\n" + 
				" WHERE ostbensube11_.transit_start_date <=:date AND\r\n" + 
				":date<= ostbensube11_.transit_end_date AND ostbensube11_.linked_facility_id =:linkedFacilityId ) ) AND ( ostbensube8_.id NOT IN\r\n" + 
				"( SELECT ostdispens12_.ti_ost_beneficiary_id FROM soch.ti_ost_dispensation_item ostdispens12_   left join soch.ti_ost_beneficiary toben on toben.id=ostdispens12_.ti_ost_beneficiary_id  WHERE\r\n" + 
				"( ostdispens12_.dispensation_date =:date OR :date BETWEEN ostdispens12_.dispensation_date AND\r\n" + 
				"Coalesce( ostdispens12_.take_home_date, ostdispens12_.dispensation_date) )  AND toben.linked_facility_id=:linkedFacilityId) ) GROUP BY\r\n" + 
				" ostprescri7_.ti_ost_beneficiary_id ) ) AND ostbensube0_.linked_facility_id =:linkedFacilityId  AND masterdrug4_.id =:drug",
				nativeQuery = true)
		Long getDailyDispensationOstBeneficiaryListForSatOstCount(@Param("linkedFacilityId") Long linkedFacilityId ,
				 @Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug);
		
		
		@Query(value = "SELECT tiostpresc5_.id as PrescriptionId, ostbensube0_.id AS Id, b.uid AS Uid, ostbensube0_.ost_number AS OstNumber, \r\n" + 
				"Concat(b.first_name, ' ', b.last_name) AS name, mg.name AS Gender, b.date_of_birth AS dateOfBirth, \r\n" + 
				"masterdrug4_.name AS Drug, tiostpresc5_.dosage_qty AS Dosage,max(todi.last_dispensation_date) as dispensationDate, \r\n" + 
				"b.age as age, b.first_name as firstName FROM soch.ti_ost_beneficiary ostbensube0_ LEFT OUTER JOIN \r\n" + 
				"soch.ti_ost_assessment ostassess1_ ON ostbensube0_.id = ostassess1_.ti_ost_beneficiary_id LEFT OUTER JOIN\r\n" + 
				"soch.ti_ost_prescription tiostpresc5_ ON ostbensube0_.id = tiostpresc5_.ti_ost_beneficiary_id LEFT OUTER JOIN\r\n" + 
				"soch.master_drugs masterdrug4_ ON tiostpresc5_.substitution_drug = masterdrug4_.id JOIN soch.beneficiary b \r\n" + 
				"ON b.id = ostbensube0_.beneficiary_id JOIN soch.master_gender mg ON mg.id = b.gender_id LEFT JOIN\r\n" + 
				"soch.ti_ost_dispensation_item todi ON todi.facility_id = ostbensube0_.facility_id and todi.ti_ost_beneficiary_id = ostbensube0_.id\r\n" + 
				"WHERE (lower(b.ost_benf_search_str) like %:searchString%) \r\n"+
				"and ostbensube0_.is_delete = false AND( tiostpresc5_.id IN\r\n" + 
				"( SELECT Max(ostprescri7_.id) FROM soch.ti_ost_prescription ostprescri7_ LEFT OUTER JOIN soch.ti_ost_beneficiary ostbensube8_ ON\r\n" + 
				" ostprescri7_.ti_ost_beneficiary_id = ostbensube8_.id LEFT OUTER JOIN soch.master_ost_status_beneficiary masterbene9_ ON\r\n" + 
				" ostbensube8_.ost_status_id = masterbene9_.id LEFT OUTER JOIN soch.master_client_status_ost masterostc10_ ON\r\n" + 
				" ostbensube8_.status_id = masterostc10_.id WHERE masterbene9_.id = 2 AND ostbensube8_.consent_taken_date <=:date AND\r\n" + 
				" masterostc10_.id IN ( 1, 7) AND ostbensube8_.linked_facility_id =:linkedFacilityId AND\r\n" + 
				" ( ostbensube8_.id NOT IN ( SELECT ostbensube11_.id FROM soch.ti_ost_beneficiary ostbensube11_ WHERE ostbensube11_.transit_start_date <= :date AND\r\n" + 
				":date <= ostbensube11_.transit_end_date AND ostbensube11_.linked_facility_id = :linkedFacilityId ) ) AND ( ostbensube8_.id NOT IN\r\n" + 
				"( SELECT ostdispens12_.ti_ost_beneficiary_id FROM soch.ti_ost_dispensation_item ostdispens12_  left join soch.ti_ost_beneficiary toben on toben.id=ostdispens12_.ti_ost_beneficiary_id WHERE\r\n" + 
				"( ostdispens12_.dispensation_date =:date OR :date BETWEEN ostdispens12_.dispensation_date AND\r\n" + 
				"Coalesce( ostdispens12_.take_home_date, ostdispens12_.dispensation_date) ) AND toben.linked_facility_id=:linkedFacilityId ) ) GROUP BY\r\n" + 
				" ostprescri7_.ti_ost_beneficiary_id ) ) AND ostbensube0_.linked_facility_id =:linkedFacilityId  AND masterdrug4_.id =:drug\r\n" +
				"group by tiostpresc5_.id,ostbensube0_.id,b.uid,ostbensube0_.ost_number,Concat(b.first_name, ' ', b.last_name),mg.name,\r\n" + 
				"b.date_of_birth,masterdrug4_.name,tiostpresc5_.dosage_qty,b.age,b.first_name",
				nativeQuery = true)
		Page<DailyDispensationListProjection> getDailyDispensationOstBeneficiaryListForSatOst1(@Param("linkedFacilityId") Long linkedFacilityId , Pageable pageable ,
				 @Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug);
		
		@Query(value = "SELECT tiostpresc5_.id as PrescriptionId, ostbensube0_.id AS Id, b.uid AS Uid, ostbensube0_.ost_number AS OstNumber, \r\n" + 
				"Concat(b.first_name, ' ', b.last_name) AS name, mg.name AS Gender, b.date_of_birth AS dateOfBirth, \r\n" + 
				"masterdrug4_.name AS Drug, tiostpresc5_.dosage_qty AS Dosage,max(todi.last_dispensation_date) as dispensationDate, \r\n" + 
				"b.age as age, b.first_name as firstName FROM soch.ti_ost_beneficiary ostbensube0_ LEFT OUTER JOIN \r\n" + 
				"soch.ti_ost_assessment ostassess1_ ON ostbensube0_.id = ostassess1_.ti_ost_beneficiary_id LEFT OUTER JOIN\r\n" + 
				"soch.ti_ost_prescription tiostpresc5_ ON ostbensube0_.id = tiostpresc5_.ti_ost_beneficiary_id LEFT OUTER JOIN\r\n" + 
				"soch.master_drugs masterdrug4_ ON tiostpresc5_.substitution_drug = masterdrug4_.id JOIN soch.beneficiary b \r\n" + 
				"ON b.id = ostbensube0_.beneficiary_id JOIN soch.master_gender mg ON mg.id = b.gender_id LEFT JOIN\r\n" + 
				"soch.ti_ost_dispensation_item todi ON todi.facility_id = ostbensube0_.facility_id and todi.ti_ost_beneficiary_id = ostbensube0_.id\r\n" + 
				"WHERE (lower(b.ost_benf_search_str) like %:searchString%) \r\n"+
				"and ostbensube0_.is_delete = false AND( tiostpresc5_.id IN\r\n" + 
				"( SELECT Max(ostprescri7_.id) FROM soch.ti_ost_prescription ostprescri7_ LEFT OUTER JOIN soch.ti_ost_beneficiary ostbensube8_ ON\r\n" + 
				" ostprescri7_.ti_ost_beneficiary_id = ostbensube8_.id LEFT OUTER JOIN soch.master_ost_status_beneficiary masterbene9_ ON\r\n" + 
				" ostbensube8_.ost_status_id = masterbene9_.id LEFT OUTER JOIN soch.master_client_status_ost masterostc10_ ON\r\n" + 
				" ostbensube8_.status_id = masterostc10_.id WHERE masterbene9_.id = 2 AND ostbensube8_.consent_taken_date <=:date AND\r\n" + 
				" masterostc10_.id IN ( 1, 7) AND ostbensube8_.linked_facility_id =:linkedFacilityId AND\r\n" + 
				" ( ostbensube8_.id NOT IN ( SELECT ostbensube11_.id FROM soch.ti_ost_beneficiary ostbensube11_ WHERE ostbensube11_.transit_start_date <= :date AND\r\n" + 
				":date <= ostbensube11_.transit_end_date AND ostbensube11_.linked_facility_id = :linkedFacilityId ) ) AND ( ostbensube8_.id NOT IN\r\n" + 
				"( SELECT ostdispens12_.ti_ost_beneficiary_id FROM soch.ti_ost_dispensation_item ostdispens12_  left join soch.ti_ost_beneficiary toben on toben.id=ostdispens12_.ti_ost_beneficiary_id WHERE\r\n" + 
				"( ostdispens12_.dispensation_date =:date OR :date BETWEEN ostdispens12_.dispensation_date AND\r\n" + 
				"Coalesce( ostdispens12_.take_home_date, ostdispens12_.dispensation_date) ) AND toben.linked_facility_id=:linkedFacilityId ) ) GROUP BY\r\n" + 
				" ostprescri7_.ti_ost_beneficiary_id ) ) AND ostbensube0_.linked_facility_id =:linkedFacilityId  AND masterdrug4_.id =:drug\r\n" +
				"group by tiostpresc5_.id,ostbensube0_.id,b.uid,ostbensube0_.ost_number,Concat(b.first_name, ' ', b.last_name),mg.name,\r\n" + 
				"b.date_of_birth,masterdrug4_.name,tiostpresc5_.dosage_qty,b.age,b.first_name order by  SUBSTRING(ostbensube0_.ost_number FROM '([0-9]+)')\\:\\:BIGINT ASC, ostbensube0_.ost_number",nativeQuery = true)
		Page<DailyDispensationListProjection> getDailyDispensationOstBeneficiaryListForSatOstSortByOstNumberAsc(@Param("linkedFacilityId") Long linkedFacilityId , Pageable pageable ,
				 @Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug);
		
		@Query(value = "SELECT tiostpresc5_.id as PrescriptionId, ostbensube0_.id AS Id, b.uid AS Uid, ostbensube0_.ost_number AS OstNumber, \r\n" + 
				"Concat(b.first_name, ' ', b.last_name) AS name, mg.name AS Gender, b.date_of_birth AS dateOfBirth, \r\n" + 
				"masterdrug4_.name AS Drug, tiostpresc5_.dosage_qty AS Dosage,max(todi.last_dispensation_date) as dispensationDate, \r\n" + 
				"b.age as age, b.first_name as firstName FROM soch.ti_ost_beneficiary ostbensube0_ LEFT OUTER JOIN \r\n" + 
				"soch.ti_ost_assessment ostassess1_ ON ostbensube0_.id = ostassess1_.ti_ost_beneficiary_id LEFT OUTER JOIN\r\n" + 
				"soch.ti_ost_prescription tiostpresc5_ ON ostbensube0_.id = tiostpresc5_.ti_ost_beneficiary_id LEFT OUTER JOIN\r\n" + 
				"soch.master_drugs masterdrug4_ ON tiostpresc5_.substitution_drug = masterdrug4_.id JOIN soch.beneficiary b \r\n" + 
				"ON b.id = ostbensube0_.beneficiary_id JOIN soch.master_gender mg ON mg.id = b.gender_id LEFT JOIN\r\n" + 
				"soch.ti_ost_dispensation_item todi ON todi.facility_id = ostbensube0_.facility_id and todi.ti_ost_beneficiary_id = ostbensube0_.id\r\n" + 
				"WHERE (lower(b.ost_benf_search_str) like %:searchString%) \r\n"+
				"and ostbensube0_.is_delete = false AND( tiostpresc5_.id IN\r\n" + 
				"( SELECT Max(ostprescri7_.id) FROM soch.ti_ost_prescription ostprescri7_ LEFT OUTER JOIN soch.ti_ost_beneficiary ostbensube8_ ON\r\n" + 
				" ostprescri7_.ti_ost_beneficiary_id = ostbensube8_.id LEFT OUTER JOIN soch.master_ost_status_beneficiary masterbene9_ ON\r\n" + 
				" ostbensube8_.ost_status_id = masterbene9_.id LEFT OUTER JOIN soch.master_client_status_ost masterostc10_ ON\r\n" + 
				" ostbensube8_.status_id = masterostc10_.id WHERE masterbene9_.id = 2 AND ostbensube8_.consent_taken_date <=:date AND\r\n" + 
				" masterostc10_.id IN ( 1, 7) AND ostbensube8_.linked_facility_id =:linkedFacilityId AND\r\n" + 
				" ( ostbensube8_.id NOT IN ( SELECT ostbensube11_.id FROM soch.ti_ost_beneficiary ostbensube11_ WHERE ostbensube11_.transit_start_date <= :date AND\r\n" + 
				":date <= ostbensube11_.transit_end_date AND ostbensube11_.linked_facility_id = :linkedFacilityId ) ) AND ( ostbensube8_.id NOT IN\r\n" + 
				"( SELECT ostdispens12_.ti_ost_beneficiary_id FROM soch.ti_ost_dispensation_item ostdispens12_  left join soch.ti_ost_beneficiary toben on toben.id=ostdispens12_.ti_ost_beneficiary_id WHERE\r\n" + 
				"( ostdispens12_.dispensation_date =:date OR :date BETWEEN ostdispens12_.dispensation_date AND\r\n" + 
				"Coalesce( ostdispens12_.take_home_date, ostdispens12_.dispensation_date) ) AND toben.linked_facility_id=:linkedFacilityId ) ) GROUP BY\r\n" + 
				" ostprescri7_.ti_ost_beneficiary_id ) ) AND ostbensube0_.linked_facility_id =:linkedFacilityId  AND masterdrug4_.id =:drug\r\n" +
				"group by tiostpresc5_.id,ostbensube0_.id,b.uid,ostbensube0_.ost_number,Concat(b.first_name, ' ', b.last_name),mg.name,\r\n" + 
				"b.date_of_birth,masterdrug4_.name,tiostpresc5_.dosage_qty,b.age,b.first_name order by  SUBSTRING(ostbensube0_.ost_number FROM '([0-9]+)')\\:\\:BIGINT DESC, ostbensube0_.ost_number",nativeQuery = true)
		Page<DailyDispensationListProjection> getDailyDispensationOstBeneficiaryListForSatOstSortByOstNumberDesc(@Param("linkedFacilityId") Long linkedFacilityId , Pageable pageable ,
				 @Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug);
		
		
		@Query(value ="select max(last_dispensation_date) as lastDispensationDate from soch.ti_ost_dispensation_item where ti_ost_beneficiary_id=:tiOstBeneficiaryId",	nativeQuery = true)
		LocalDate getLastDispensationDate(@Param("tiOstBeneficiaryId") Long tiOstBeneficiaryId);
		
		@Query(value = "select ostprescri3_.id as PrescriptionId, ostbensube0_.id AS Id, b.uid AS Uid, ostbensube0_.ost_number AS OstNumber, \r\n"
				+ "Concat(b.first_name, ' ', b.last_name) AS name, mg.name AS Gender, b.date_of_birth AS dateOfBirth, \r\n"
				+ "masterdrug4_.name AS Drug, ostprescri3_.dosage_qty AS Dosage, max(tiostdispe1_.last_dispensation_date) as dispensationDate, \r\n"
				+ "b.age as age, b.first_name as firstName,ostbensube0_.facility_id as FacilityId,b.id as Beneficiaryid, \r\n"
				+ "ostbensube0_.transit_start_date as TransitStartDate,ostbensube0_.transit_end_date as TransitEndDate \r\n"
				+ "from soch.ti_ost_beneficiary ostbensube0_ \r\n"
				+ "join soch.beneficiary b on b.id=ostbensube0_.beneficiary_id \r\n"
				+ "join soch.master_gender mg ON mg.id = b.gender_id \r\n"
				+ "left outer join soch.ti_ost_dispensation_item tiostdispe1_ on ostbensube0_.id = tiostdispe1_.ti_ost_beneficiary_id \r\n"
				+ "left outer join soch.ti_ost_prescription ostprescri3_ on tiostdispe1_.ti_ost_prescription_id = ostprescri3_.id \r\n"
				+ "join soch.master_drugs masterdrug4_  on ostprescri3_.substitution_drug = masterdrug4_.id \r\n"
				+ "where ostbensube0_.is_delete =false and masterdrug4_.id = :drug and \r\n"
				+ "(lower(b.ost_benf_search_str) like %:searchString%)  \r\n"
				+ "and ( ostbensube0_.referred_from_id =:facilityId  or tiostdispe1_.facility_id =:facilityId \r\n"
				+ "or ostbensube0_.facility_id =:facilityId  or ostprescri3_.facility_id=:facilityId ) \r\n"
				+ "and ( tiostdispe1_.dispensation_date = :date \r\n"
				+ "or tiostdispe1_.take_home_date between :date and soch.date_adder(coalesce(tiostdispe1_.take_home_days, 0), :date)) \r\n"
				+ "group by ostprescri3_.id,ostbensube0_.id,b.uid,ostbensube0_.ost_number,Concat(b.first_name, ' ', b.last_name),mg.name, \r\n"
				+ "b.date_of_birth,masterdrug4_.name,ostprescri3_.dosage_qty,b.age,b.first_name,b.id \r\n"
				+ "order by ostbensube0_.id \r\n"  
				+"				",nativeQuery = true)
		Page<DailyDispensationListProjection> getTodaysDispensationOstBeneficiaryList(@Param("facilityId") Long facilityId , Pageable pageable ,
				 @Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug);
		
		@Query(value =  "select ostprescri3_.id as PrescriptionId, ostbensube0_.id AS Id, b.uid AS Uid, ostbensube0_.ost_number AS OstNumber, \r\n"
				+ "Concat(b.first_name, ' ', b.last_name) AS name, mg.name AS Gender, b.date_of_birth AS dateOfBirth, \r\n"
				+ "masterdrug4_.name AS Drug, ostprescri3_.dosage_qty AS Dosage, max(tiostdispe1_.last_dispensation_date) as dispensationDate, \r\n"
				+ "b.age as age, b.first_name as firstName,ostbensube0_.facility_id as FacilityId,b.id as Beneficiaryid, \r\n"
				+ "ostbensube0_.transit_start_date as TransitStartDate,ostbensube0_.transit_end_date as TransitEndDate \r\n"
				+ "from soch.ti_ost_beneficiary ostbensube0_ \r\n"
				+ "join soch.beneficiary b on b.id=ostbensube0_.beneficiary_id \r\n"
				+ "join soch.master_gender mg ON mg.id = b.gender_id \r\n"
				+ "left outer join soch.ti_ost_dispensation_item tiostdispe1_ on ostbensube0_.id = tiostdispe1_.ti_ost_beneficiary_id \r\n"
				+ "left outer join soch.ti_ost_prescription ostprescri3_ on tiostdispe1_.ti_ost_prescription_id = ostprescri3_.id \r\n"
				+ "join soch.master_drugs masterdrug4_  on ostprescri3_.substitution_drug = masterdrug4_.id \r\n"
				+ "where ostbensube0_.is_delete =false and masterdrug4_.id = :drug and \r\n"
				+ "(lower(b.ost_benf_search_str) like %:searchString%)  \r\n"
				+ "and ( ostbensube0_.referred_from_id =:facilityId  or tiostdispe1_.facility_id =:facilityId \r\n"
				+ "or ostbensube0_.facility_id =:facilityId  or ostprescri3_.facility_id=:facilityId ) \r\n"
				+ "and ( tiostdispe1_.dispensation_date = :date \r\n"
				+ "or tiostdispe1_.take_home_date between :date and soch.date_adder(coalesce(tiostdispe1_.take_home_days, 0), :date)) \r\n"
				+ "group by ostprescri3_.id,ostbensube0_.id,b.uid,ostbensube0_.ost_number,Concat(b.first_name, ' ', b.last_name),mg.name, \r\n"
				+ "b.date_of_birth,masterdrug4_.name,ostprescri3_.dosage_qty,b.age,b.first_name,b.id \r\n"
				+ "order by  SUBSTRING(ostbensube0_.ost_number FROM '([0-9]+)')\\:\\:BIGINT ASC, ostbensube0_.ost_number\r\n" + 
				"				",nativeQuery = true)
		Page<DailyDispensationListProjection> getTodaysDispensationOstBeneficiaryListSortByOstNumberAsc(@Param("facilityId") Long facilityId , Pageable pageable ,
				 @Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug);
		
		@Query(value =  "select ostprescri3_.id as PrescriptionId, ostbensube0_.id AS Id, b.uid AS Uid, ostbensube0_.ost_number AS OstNumber, \r\n"
				+ "Concat(b.first_name, ' ', b.last_name) AS name, mg.name AS Gender, b.date_of_birth AS dateOfBirth, \r\n"
				+ "masterdrug4_.name AS Drug, ostprescri3_.dosage_qty AS Dosage, max(tiostdispe1_.last_dispensation_date) as dispensationDate, \r\n"
				+ "b.age as age, b.first_name as firstName,ostbensube0_.facility_id as FacilityId,b.id as Beneficiaryid, \r\n"
				+ "ostbensube0_.transit_start_date as TransitStartDate,ostbensube0_.transit_end_date as TransitEndDate \r\n"
				+ "from soch.ti_ost_beneficiary ostbensube0_ \r\n"
				+ "join soch.beneficiary b on b.id=ostbensube0_.beneficiary_id \r\n"
				+ "join soch.master_gender mg ON mg.id = b.gender_id \r\n"
				+ "left outer join soch.ti_ost_dispensation_item tiostdispe1_ on ostbensube0_.id = tiostdispe1_.ti_ost_beneficiary_id \r\n"
				+ "left outer join soch.ti_ost_prescription ostprescri3_ on tiostdispe1_.ti_ost_prescription_id = ostprescri3_.id \r\n"
				+ "join soch.master_drugs masterdrug4_  on ostprescri3_.substitution_drug = masterdrug4_.id \r\n"
				+ "where ostbensube0_.is_delete =false and masterdrug4_.id = :drug and \r\n"
				+ "(lower(b.ost_benf_search_str) like %:searchString%)  \r\n"
				+ "and ( ostbensube0_.referred_from_id =:facilityId  or tiostdispe1_.facility_id =:facilityId \r\n"
				+ "or ostbensube0_.facility_id =:facilityId  or ostprescri3_.facility_id=:facilityId ) \r\n"
				+ "and ( tiostdispe1_.dispensation_date = :date \r\n"
				+ "or tiostdispe1_.take_home_date between :date and soch.date_adder(coalesce(tiostdispe1_.take_home_days, 0), :date)) \r\n"
				+ "group by ostprescri3_.id,ostbensube0_.id,b.uid,ostbensube0_.ost_number,Concat(b.first_name, ' ', b.last_name),mg.name, \r\n"
				+ "b.date_of_birth,masterdrug4_.name,ostprescri3_.dosage_qty,b.age,b.first_name,b.id \r\n"
				+ "order by  SUBSTRING(ostbensube0_.ost_number FROM '([0-9]+)')\\:\\:BIGINT DESC, ostbensube0_.ost_number\r\n" + 
				"				",nativeQuery = true)
		Page<DailyDispensationListProjection> getTodaysDispensationOstBeneficiaryListSortByOstNumberDesc(@Param("facilityId") Long facilityId , Pageable pageable ,
				 @Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug);
		
		@Query(value = "SELECT count( ostbensube0_)  from soch.ti_ost_beneficiary ostbensube0_ \r\n" + 
				"join soch.beneficiary b on b.id=ostbensube0_.beneficiary_id\r\n" + 
				"join soch.master_gender mg ON mg.id = b.gender_id "+
				"left outer join soch.ti_ost_dispensation_item tiostdispe1_ on ostbensube0_.id = tiostdispe1_.ti_ost_beneficiary_id  \r\n"+
				"left outer join soch.ti_ost_prescription ostprescri3_ on tiostdispe1_.ti_ost_prescription_id = ostprescri3_.id  \r\n"+
				"join soch.master_drugs masterdrug4_ on ostprescri3_.substitution_drug = masterdrug4_.id \r\n" + 
				"where  (lower(b.ost_benf_search_str) like %:searchString%) and ostbensube0_.is_delete =false and masterdrug4_.id =:drug  and \r\n" + 
				" ( tiostdispe1_.dispensation_date =:date\r\n" + 
				"   or tiostdispe1_.take_home_date between :date and soch.date_adder(coalesce(tiostdispe1_.take_home_days, 0), :date )) \r\n" + 
				" and ( ostbensube0_.referred_from_id =:facilityId  or tiostdispe1_.facility_id =:facilityId  or ostbensube0_.facility_id =:facilityId  or ostprescri3_.facility_id =:facilityId\r\n" + 
				" ) ",nativeQuery = true)
		Long getTodaysDispensationOstBeneficiaryCount(@Param("facilityId") Long facilityId , 
				 @Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug);
		
		
		@Query(value = "SELECT tiostpresc5_.id as PrescriptionId, ostbensube0_.id AS Id, b.uid AS Uid, ostbensube0_.ost_number AS OstNumber,\r\n" + 
				"Concat(b.first_name, ' ', b.last_name) AS name, mg.name AS Gender, b.date_of_birth AS dateOfBirth, masterdrug4_.name AS Drug, \r\n" + 
				"tiostpresc5_.dosage_qty AS Dosage, max(todi.last_dispensation_date) as dispensationDate, b.age as age, b.first_name as firstName\r\n" + 
				"from soch.ti_ost_beneficiary ostbensube0_ left outer join soch.ti_ost_assessment ostassess1_ on \r\n" + 
				"ostbensube0_.id = ostassess1_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc2_ on\r\n" + 
				"ostassess1_.id = tiostpresc2_.ost_assessment_id left outer join soch.ti_ost_follow_up ostfollowu3_ on\r\n" + 
				"ostbensube0_.id = ostfollowu3_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc5_ on\r\n" + 
				"ostbensube0_.id = tiostpresc5_.ti_ost_beneficiary_id left outer join soch.master_drugs masterdrug4_ ON\r\n" + 
				"tiostpresc5_.substitution_drug = masterdrug4_.id join soch.beneficiary b on b.id = ostbensube0_.beneficiary_id \r\n" + 
				"join soch.master_gender mg ON mg.id = b.gender_id left join soch.ti_ost_dispensation_item todi ON\r\n" + 
				"todi.facility_id = ostbensube0_.facility_id and todi.ti_ost_beneficiary_id = ostbensube0_.id \r\n" + 
				"where ostbensube0_.is_delete = false and( tiostpresc5_.id in ( select max(ostprescri6_.id) \r\n" + 
				"from soch.ti_ost_prescription ostprescri6_ left outer join soch.ti_ost_beneficiary ostbensube7_ on\r\n" + 
				"ostprescri6_.ti_ost_beneficiary_id = ostbensube7_.id left outer join soch.master_client_status_ost masterostc8_ on\r\n" + 
				"ostbensube7_.status_id = masterostc8_.id left outer join soch.master_ost_status_beneficiary masterbene9_ on\r\n" + 
				"ostbensube7_.ost_status_id = masterbene9_.id left outer join soch.master_drugs masterdrug10_ on\r\n" + 
				"ostprescri6_.substitution_drug = masterdrug10_.id where masterbene9_.id = 2 and ostbensube7_.facility_id = :facilityId and\r\n" + 
				"ostbensube7_.consent_taken_date <= :date and ostbensube7_.linked_facility_id is null and masterostc8_.id in ( 1, 7) and\r\n" + 
				"( ostbensube7_.id not in ( select distinct ostbensube12_.id from soch.ti_ost_dispensation_item ostdispens11_ \r\n" + 
				"left outer join soch.ti_ost_beneficiary ostbensube12_ on ostdispens11_.ti_ost_beneficiary_id = ostbensube12_.id \r\n" + 
				"where ostbensube12_.facility_id = :facilityId and case when ostdispens11_.take_home_date IS NULL \r\n" + 
				"then ostdispens11_.last_dispensation_date = :date or (ostdispens11_.last_dispensation_date >= :date\r\n" + 
				"and ostdispens11_.last_dispensation_date <= :endDate) else ( (:endDate >= ostdispens11_.last_dispensation_date \r\n" + 
				"and :endDate <= ostdispens11_.take_home_date) or (:date >= ostdispens11_.last_dispensation_date and \r\n" + 
				":date <= ostdispens11_.take_home_date) ) end ) ) and masterdrug10_.id = :drug group by ostbensube7_.id ) ) and\r\n" + 
				"( ostbensube0_.id not in ( select ostbensube13_.id from soch.ti_ost_beneficiary ostbensube13_ \r\n" + 
				"where ostbensube13_.transit_start_date <= :date and :date <= ostbensube13_.transit_end_date and\r\n" + 
				"ostbensube13_.facility_id = :facilityId ) ) and ostbensube0_.facility_id = :facilityId and ( lower(b.ost_benf_search_str) \r\n" + 
				"like %:searchString% or '' like %:searchString% ) group by tiostpresc5_.id, ostbensube0_.id, b.uid, ostbensube0_.ost_number, \r\n" + 
				"Concat(b.first_name, ' ', b.last_name), mg.name, b.date_of_birth, masterdrug4_.name, tiostpresc5_.dosage_qty, b.age, b.first_name",
				nativeQuery = true)
				Page<DailyDispensationListProjection> getTakeHomeDispensationOstBeneficiaryList(@Param("facilityId") Long facilityId , Pageable pageable ,
				@Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug ,  @Param("endDate") LocalDate endDate);

				@Query(value = "SELECT tiostpresc5_.id as PrescriptionId, ostbensube0_.id AS Id, b.uid AS Uid, ostbensube0_.ost_number AS OstNumber,\r\n" + 
				"Concat(b.first_name, ' ', b.last_name) AS name, mg.name AS Gender, b.date_of_birth AS dateOfBirth, masterdrug4_.name AS Drug, \r\n" + 
				"tiostpresc5_.dosage_qty AS Dosage, max(todi.last_dispensation_date) as dispensationDate, b.age as age, b.first_name as firstName\r\n" + 
				"from soch.ti_ost_beneficiary ostbensube0_ left outer join soch.ti_ost_assessment ostassess1_ on \r\n" + 
				"ostbensube0_.id = ostassess1_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc2_ on\r\n" + 
				"ostassess1_.id = tiostpresc2_.ost_assessment_id left outer join soch.ti_ost_follow_up ostfollowu3_ on\r\n" + 
				"ostbensube0_.id = ostfollowu3_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc5_ on\r\n" + 
				"ostbensube0_.id = tiostpresc5_.ti_ost_beneficiary_id left outer join soch.master_drugs masterdrug4_ ON\r\n" + 
				"tiostpresc5_.substitution_drug = masterdrug4_.id join soch.beneficiary b on b.id = ostbensube0_.beneficiary_id \r\n" + 
				"join soch.master_gender mg ON mg.id = b.gender_id left join soch.ti_ost_dispensation_item todi ON\r\n" + 
				"todi.facility_id = ostbensube0_.facility_id and todi.ti_ost_beneficiary_id = ostbensube0_.id \r\n" + 
				"where ostbensube0_.is_delete = false and( tiostpresc5_.id in ( select max(ostprescri6_.id) \r\n" + 
				"from soch.ti_ost_prescription ostprescri6_ left outer join soch.ti_ost_beneficiary ostbensube7_ on\r\n" + 
				"ostprescri6_.ti_ost_beneficiary_id = ostbensube7_.id left outer join soch.master_client_status_ost masterostc8_ on\r\n" + 
				"ostbensube7_.status_id = masterostc8_.id left outer join soch.master_ost_status_beneficiary masterbene9_ on\r\n" + 
				"ostbensube7_.ost_status_id = masterbene9_.id left outer join soch.master_drugs masterdrug10_ on\r\n" + 
				"ostprescri6_.substitution_drug = masterdrug10_.id where masterbene9_.id = 2 and ostbensube7_.facility_id = :facilityId and\r\n" + 
				"ostbensube7_.consent_taken_date <= :date and ostbensube7_.linked_facility_id is null and masterostc8_.id in ( 1, 7) and\r\n" + 
				"( ostbensube7_.id not in ( select distinct ostbensube12_.id from soch.ti_ost_dispensation_item ostdispens11_ \r\n" + 
				"left outer join soch.ti_ost_beneficiary ostbensube12_ on ostdispens11_.ti_ost_beneficiary_id = ostbensube12_.id \r\n" + 
				"where ostbensube12_.facility_id = :facilityId and case when ostdispens11_.take_home_date IS NULL \r\n" + 
				"then ostdispens11_.last_dispensation_date = :date  or (ostdispens11_.last_dispensation_date >= :date\r\n" + 
				"and ostdispens11_.last_dispensation_date <= :endDate) else ( (:endDate >= ostdispens11_.last_dispensation_date \r\n" + 
				"and :endDate <= ostdispens11_.take_home_date) or (:date >= ostdispens11_.last_dispensation_date and \r\n" + 
				":date <= ostdispens11_.take_home_date) ) end ) ) and masterdrug10_.id = :drug group by ostbensube7_.id ) ) and\r\n" + 
				"( ostbensube0_.id not in ( select ostbensube13_.id from soch.ti_ost_beneficiary ostbensube13_ \r\n" + 
				"where ostbensube13_.transit_start_date <= :date and :date <= ostbensube13_.transit_end_date and\r\n" + 
				"ostbensube13_.facility_id = :facilityId ) ) and ostbensube0_.facility_id = :facilityId and ( lower(b.ost_benf_search_str) \r\n" + 
				"like %:searchString% or '' like %:searchString% ) group by tiostpresc5_.id, ostbensube0_.id, b.uid, ostbensube0_.ost_number, \r\n" + 
				"Concat(b.first_name, ' ', b.last_name), mg.name, b.date_of_birth, masterdrug4_.name, tiostpresc5_.dosage_qty, b.age, b.first_name order by  SUBSTRING(ostbensube0_.ost_number FROM '([0-9]+)')\\:\\:BIGINT ASC, ostbensube0_.ost_number ",nativeQuery = true)
				Page<DailyDispensationListProjection> getTakeHomeDispensationOstBeneficiaryListOrderByOstNumberAsc(@Param("facilityId") Long facilityId , Pageable pageable ,
				@Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug, @Param("endDate") LocalDate endDate);
				
				
				@Query(value = "SELECT tiostpresc5_.id as PrescriptionId, ostbensube0_.id AS Id, b.uid AS Uid, ostbensube0_.ost_number AS OstNumber,\r\n" + 
				"Concat(b.first_name, ' ', b.last_name) AS name, mg.name AS Gender, b.date_of_birth AS dateOfBirth, masterdrug4_.name AS Drug, \r\n" + 
				"tiostpresc5_.dosage_qty AS Dosage, max(todi.last_dispensation_date) as dispensationDate, b.age as age, b.first_name as firstName\r\n" + 
				"from soch.ti_ost_beneficiary ostbensube0_ left outer join soch.ti_ost_assessment ostassess1_ on \r\n" + 
				"ostbensube0_.id = ostassess1_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc2_ on\r\n" + 
				"ostassess1_.id = tiostpresc2_.ost_assessment_id left outer join soch.ti_ost_follow_up ostfollowu3_ on\r\n" + 
				"ostbensube0_.id = ostfollowu3_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc5_ on\r\n" + 
				"ostbensube0_.id = tiostpresc5_.ti_ost_beneficiary_id left outer join soch.master_drugs masterdrug4_ ON\r\n" + 
				"tiostpresc5_.substitution_drug = masterdrug4_.id join soch.beneficiary b on b.id = ostbensube0_.beneficiary_id \r\n" + 
				"join soch.master_gender mg ON mg.id = b.gender_id left join soch.ti_ost_dispensation_item todi ON\r\n" + 
				"todi.facility_id = ostbensube0_.facility_id and todi.ti_ost_beneficiary_id = ostbensube0_.id \r\n" + 
				"where ostbensube0_.is_delete = false and( tiostpresc5_.id in ( select max(ostprescri6_.id) \r\n" + 
				"from soch.ti_ost_prescription ostprescri6_ left outer join soch.ti_ost_beneficiary ostbensube7_ on\r\n" + 
				"ostprescri6_.ti_ost_beneficiary_id = ostbensube7_.id left outer join soch.master_client_status_ost masterostc8_ on\r\n" + 
				"ostbensube7_.status_id = masterostc8_.id left outer join soch.master_ost_status_beneficiary masterbene9_ on\r\n" + 
				"ostbensube7_.ost_status_id = masterbene9_.id left outer join soch.master_drugs masterdrug10_ on\r\n" + 
				"ostprescri6_.substitution_drug = masterdrug10_.id where masterbene9_.id = 2 and ostbensube7_.facility_id = :facilityId and\r\n" + 
				"ostbensube7_.consent_taken_date <= :date and ostbensube7_.linked_facility_id is null and masterostc8_.id in ( 1, 7) and\r\n" + 
				"( ostbensube7_.id not in ( select distinct ostbensube12_.id from soch.ti_ost_dispensation_item ostdispens11_ \r\n" + 
				"left outer join soch.ti_ost_beneficiary ostbensube12_ on ostdispens11_.ti_ost_beneficiary_id = ostbensube12_.id \r\n" + 
				"where ostbensube12_.facility_id = :facilityId and case when ostdispens11_.take_home_date IS NULL \r\n" + 
				"then ostdispens11_.last_dispensation_date = :date or (ostdispens11_.last_dispensation_date >= :date\r\n" + 
				"and ostdispens11_.last_dispensation_date <= :endDate) else ( (:endDate >= ostdispens11_.last_dispensation_date \r\n" + 
				"and :endDate <= ostdispens11_.take_home_date) or (:date >= ostdispens11_.last_dispensation_date and \r\n" + 
				":date <= ostdispens11_.take_home_date) ) end ) ) and masterdrug10_.id = :drug group by ostbensube7_.id ) ) and\r\n" + 
				"( ostbensube0_.id not in ( select ostbensube13_.id from soch.ti_ost_beneficiary ostbensube13_ \r\n" + 
				"where ostbensube13_.transit_start_date <= :date and :date <= ostbensube13_.transit_end_date and\r\n" + 
				"ostbensube13_.facility_id = :facilityId ) ) and ostbensube0_.facility_id = :facilityId and ( lower(b.ost_benf_search_str) \r\n" + 
				"like %:searchString% or '' like %:searchString% ) group by tiostpresc5_.id, ostbensube0_.id, b.uid, ostbensube0_.ost_number, \r\n" + 
				"Concat(b.first_name, ' ', b.last_name), mg.name, b.date_of_birth, masterdrug4_.name, tiostpresc5_.dosage_qty, b.age, b.first_name order by  SUBSTRING(ostbensube0_.ost_number FROM '([0-9]+)')\\:\\:BIGINT DESC, ostbensube0_.ost_number ",nativeQuery = true)
				Page<DailyDispensationListProjection> getTakeHomeDispensationOstBeneficiaryListOrderByOstNumberDesc(@Param("facilityId") Long facilityId , Pageable pageable ,
				@Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug,@Param("endDate") LocalDate endDate);
				
				
				@Query(value = "SELECT count( DISTINCT ostbensube0_)\r\n" + 
				"from soch.ti_ost_beneficiary ostbensube0_ left outer join soch.ti_ost_assessment ostassess1_ on \r\n" + 
				"ostbensube0_.id = ostassess1_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc2_ on\r\n" + 
				"ostassess1_.id = tiostpresc2_.ost_assessment_id left outer join soch.ti_ost_follow_up ostfollowu3_ on\r\n" + 
				"ostbensube0_.id = ostfollowu3_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc5_ on\r\n" + 
				"ostbensube0_.id = tiostpresc5_.ti_ost_beneficiary_id left outer join soch.master_drugs masterdrug4_ ON\r\n" + 
				"tiostpresc5_.substitution_drug = masterdrug4_.id join soch.beneficiary b on b.id = ostbensube0_.beneficiary_id \r\n" + 
				"join soch.master_gender mg ON mg.id = b.gender_id left join soch.ti_ost_dispensation_item todi ON\r\n" + 
				"todi.facility_id = ostbensube0_.facility_id and todi.ti_ost_beneficiary_id = ostbensube0_.id \r\n" + 
				"where ostbensube0_.is_delete = false and( tiostpresc5_.id in ( select max(ostprescri6_.id) \r\n" + 
				"from soch.ti_ost_prescription ostprescri6_ left outer join soch.ti_ost_beneficiary ostbensube7_ on\r\n" + 
				"ostprescri6_.ti_ost_beneficiary_id = ostbensube7_.id left outer join soch.master_client_status_ost masterostc8_ on\r\n" + 
				"ostbensube7_.status_id = masterostc8_.id left outer join soch.master_ost_status_beneficiary masterbene9_ on\r\n" + 
				"ostbensube7_.ost_status_id = masterbene9_.id left outer join soch.master_drugs masterdrug10_ on\r\n" + 
				"ostprescri6_.substitution_drug = masterdrug10_.id where masterbene9_.id = 2 and ostbensube7_.facility_id = :facilityId and\r\n" + 
				"ostbensube7_.consent_taken_date <= :date and ostbensube7_.linked_facility_id is null and masterostc8_.id in ( 1, 7) and\r\n" + 
				"( ostbensube7_.id not in ( select distinct ostbensube12_.id from soch.ti_ost_dispensation_item ostdispens11_ \r\n" + 
				"left outer join soch.ti_ost_beneficiary ostbensube12_ on ostdispens11_.ti_ost_beneficiary_id = ostbensube12_.id \r\n" + 
				"where ostbensube12_.facility_id = :facilityId and case when ostdispens11_.take_home_date IS NULL \r\n" + 
				"then ostdispens11_.last_dispensation_date = :date or (ostdispens11_.last_dispensation_date >= :date\r\n" + 
				"and ostdispens11_.last_dispensation_date <= :endDate) else ( (:endDate >= ostdispens11_.last_dispensation_date \r\n" + 
				"and :endDate <= ostdispens11_.take_home_date) or (:date >= ostdispens11_.last_dispensation_date and \r\n" + 
				":date <= ostdispens11_.take_home_date) ) end ) ) and masterdrug10_.id = :drug group by ostbensube7_.id ) ) and\r\n" + 
				"( ostbensube0_.id not in ( select ostbensube13_.id from soch.ti_ost_beneficiary ostbensube13_ \r\n" + 
				"where ostbensube13_.transit_start_date <= :date and :date <= ostbensube13_.transit_end_date and\r\n" + 
				"ostbensube13_.facility_id = :facilityId ) ) and ostbensube0_.facility_id = :facilityId and ( lower(b.ost_benf_search_str) \r\n" + 
				"like %:searchString% or '' like %:searchString% )",nativeQuery = true)
				Long getTakeHomeDispensationOstBeneficiaryListCount(@Param("facilityId") Long facilityId ,
				@Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug,@Param("endDate") LocalDate endDate);
				
				
				@Query(value = "SELECT tiostpresc5_.id as PrescriptionId, ostbensube0_.id AS Id, b.uid AS Uid, ostbensube0_.ost_number AS OstNumber, \r\n" + 
				"Concat(b.first_name, ' ', b.last_name) AS name, mg.name AS Gender, b.date_of_birth AS dateOfBirth, masterdrug4_.name AS Drug,\r\n" + 
				"tiostpresc5_.dosage_qty AS Dosage, max(todi.last_dispensation_date) as dispensationDate, b.age as age, b.first_name as firstName \r\n" + 
				"from soch.ti_ost_beneficiary ostbensube0_ left outer join soch.ti_ost_assessment ostassess1_ on\r\n" + 
				"ostbensube0_.id = ostassess1_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc2_ on\r\n" + 
				"ostassess1_.id = tiostpresc2_.ost_assessment_id left outer join soch.ti_ost_follow_up ostfollowu3_ on\r\n" + 
				"ostbensube0_.id = ostfollowu3_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc5_ on\r\n" + 
				"ostbensube0_.id = tiostpresc5_.ti_ost_beneficiary_id left outer join soch.master_drugs masterdrug4_ ON\r\n" + 
				"tiostpresc5_.substitution_drug = masterdrug4_.id join soch.beneficiary b on b.id = ostbensube0_.beneficiary_id\r\n" + 
				"join soch.master_gender mg ON mg.id = b.gender_id left join soch.ti_ost_dispensation_item todi ON\r\n" + 
				"todi.facility_id = ostbensube0_.facility_id and todi.ti_ost_beneficiary_id = ostbensube0_.id\r\n" + 
				"where ostbensube0_.is_delete = false and( tiostpresc5_.id in ( select max(ostprescri6_.id)\r\n" + 
				"from soch.ti_ost_prescription ostprescri6_ left outer join soch.ti_ost_beneficiary ostbensube7_ on\r\n" + 
				"ostprescri6_.ti_ost_beneficiary_id = ostbensube7_.id left outer join soch.master_client_status_ost masterostc8_ on\r\n" + 
				"ostbensube7_.status_id = masterostc8_.id left outer join soch.master_ost_status_beneficiary masterbene9_ on \r\n" + 
				"ostbensube7_.ost_status_id = masterbene9_.id left outer join soch.master_drugs masterdrug10_ on\r\n" + 
				"ostprescri6_.substitution_drug = masterdrug10_.id where masterbene9_.id = 2 and ostbensube7_.linked_facility_id = :linkedFacilityId\r\n" + 
				"and ostbensube7_.consent_taken_date <= :date and masterostc8_.id in ( 1, 7) and ( ostbensube7_.id not in\r\n" + 
				"( select distinct ostbensube12_.id from soch.ti_ost_dispensation_item ostdispens11_ left outer join\r\n" + 
				" soch.ti_ost_beneficiary ostbensube12_ on ostdispens11_.ti_ost_beneficiary_id = ostbensube12_.id \r\n" + 
				" where ostbensube12_.linked_facility_id = :linkedFacilityId and case when ostdispens11_.take_home_date IS NULL \r\n" + 
				" then ostdispens11_.last_dispensation_date = :date or (ostdispens11_.last_dispensation_date >= :date\r\n" + 
				"and ostdispens11_.last_dispensation_date <= :endDate) else ( (:endDate >= ostdispens11_.last_dispensation_date \r\n" + 
				"and :endDate <= ostdispens11_.take_home_date) or ( :date >= ostdispens11_.last_dispensation_date and\r\n" + 
				":date <= ostdispens11_.take_home_date ) ) end ) ) and masterdrug10_.id = :drug group by ostbensube7_.id ) ) \r\n" + 
				"and ( ostbensube0_.id not in ( select ostbensube13_.id from soch.ti_ost_beneficiary ostbensube13_ \r\n" + 
				"where ostbensube13_.transit_start_date <= :date and :date <= ostbensube13_.transit_end_date and\r\n" + 
				"ostbensube13_.linked_facility_id = :linkedFacilityId ) ) and ostbensube0_.linked_facility_id = :linkedFacilityId and\r\n" + 
				"( lower(b.ost_benf_search_str) like %:searchString% or '' like %:searchString% ) \r\n" + 
				"group by tiostpresc5_.id, ostbensube0_.id, b.uid, ostbensube0_.ost_number, Concat(b.first_name, ' ', b.last_name), \r\n" + 
				"mg.name, b.date_of_birth, masterdrug4_.name, tiostpresc5_.dosage_qty, b.age, b.first_name",nativeQuery = true)
				Page<DailyDispensationListProjection> getTakeHomeDispensationOstBeneficiaryListForSatOSt(@Param("linkedFacilityId") Long linkedFacilityId , Pageable pageable ,
				@Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug,@Param("endDate") LocalDate endDate);
				
				
				@Query(value = "SELECT tiostpresc5_.id as PrescriptionId, ostbensube0_.id AS Id, b.uid AS Uid, ostbensube0_.ost_number AS OstNumber, \r\n" + 
				"Concat(b.first_name, ' ', b.last_name) AS name, mg.name AS Gender, b.date_of_birth AS dateOfBirth, masterdrug4_.name AS Drug,\r\n" + 
				"tiostpresc5_.dosage_qty AS Dosage, max(todi.last_dispensation_date) as dispensationDate, b.age as age, b.first_name as firstName \r\n" + 
				"from soch.ti_ost_beneficiary ostbensube0_ left outer join soch.ti_ost_assessment ostassess1_ on\r\n" + 
				"ostbensube0_.id = ostassess1_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc2_ on\r\n" + 
				"ostassess1_.id = tiostpresc2_.ost_assessment_id left outer join soch.ti_ost_follow_up ostfollowu3_ on\r\n" + 
				"ostbensube0_.id = ostfollowu3_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc5_ on\r\n" + 
				"ostbensube0_.id = tiostpresc5_.ti_ost_beneficiary_id left outer join soch.master_drugs masterdrug4_ ON\r\n" + 
				"tiostpresc5_.substitution_drug = masterdrug4_.id join soch.beneficiary b on b.id = ostbensube0_.beneficiary_id\r\n" + 
				"join soch.master_gender mg ON mg.id = b.gender_id left join soch.ti_ost_dispensation_item todi ON\r\n" + 
				"todi.facility_id = ostbensube0_.facility_id and todi.ti_ost_beneficiary_id = ostbensube0_.id\r\n" + 
				"where ostbensube0_.is_delete = false and( tiostpresc5_.id in ( select max(ostprescri6_.id)\r\n" + 
				"from soch.ti_ost_prescription ostprescri6_ left outer join soch.ti_ost_beneficiary ostbensube7_ on\r\n" + 
				"ostprescri6_.ti_ost_beneficiary_id = ostbensube7_.id left outer join soch.master_client_status_ost masterostc8_ on\r\n" + 
				"ostbensube7_.status_id = masterostc8_.id left outer join soch.master_ost_status_beneficiary masterbene9_ on \r\n" + 
				"ostbensube7_.ost_status_id = masterbene9_.id left outer join soch.master_drugs masterdrug10_ on\r\n" + 
				"ostprescri6_.substitution_drug = masterdrug10_.id where masterbene9_.id = 2 and ostbensube7_.linked_facility_id = :linkedFacilityId\r\n" + 
				"and ostbensube7_.consent_taken_date <= :date and masterostc8_.id in ( 1, 7) and ( ostbensube7_.id not in\r\n" + 
				"( select distinct ostbensube12_.id from soch.ti_ost_dispensation_item ostdispens11_ left outer join\r\n" + 
				" soch.ti_ost_beneficiary ostbensube12_ on ostdispens11_.ti_ost_beneficiary_id = ostbensube12_.id \r\n" + 
				" where ostbensube12_.linked_facility_id = :linkedFacilityId and case when ostdispens11_.take_home_date IS NULL \r\n" + 
				" then ostdispens11_.last_dispensation_date = :date or (ostdispens11_.last_dispensation_date >= :date\r\n" + 
				"and ostdispens11_.last_dispensation_date <= :endDate) else ( (:endDate >= ostdispens11_.last_dispensation_date \r\n" + 
				"and :endDate <= ostdispens11_.take_home_date) or ( :date >= ostdispens11_.last_dispensation_date and\r\n" + 
				":date <= ostdispens11_.take_home_date ) ) end ) ) and masterdrug10_.id = :drug group by ostbensube7_.id ) ) \r\n" + 
				"and ( ostbensube0_.id not in ( select ostbensube13_.id from soch.ti_ost_beneficiary ostbensube13_ \r\n" + 
				"where ostbensube13_.transit_start_date <= :date and :date <= ostbensube13_.transit_end_date and\r\n" + 
				"ostbensube13_.linked_facility_id = :linkedFacilityId ) ) and ostbensube0_.linked_facility_id = :linkedFacilityId and\r\n" + 
				"( lower(b.ost_benf_search_str) like %:searchString% or '' like %:searchString% ) \r\n" + 
				"group by tiostpresc5_.id, ostbensube0_.id, b.uid, ostbensube0_.ost_number, Concat(b.first_name, ' ', b.last_name), \r\n" + 
				"mg.name, b.date_of_birth, masterdrug4_.name, tiostpresc5_.dosage_qty, b.age, b.first_name order by  SUBSTRING(ostbensube0_.ost_number FROM '([0-9]+)')\\:\\:BIGINT ASC, ostbensube0_.ost_number",nativeQuery = true)
				Page<DailyDispensationListProjection> getTakeHomeDispensationOstBeneficiaryListForSatOStSortByOstNumAsc(@Param("linkedFacilityId") Long linkedFacilityId , Pageable pageable ,
				@Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug,@Param("endDate") LocalDate endDate);
				
				
				@Query(value = "SELECT tiostpresc5_.id as PrescriptionId, ostbensube0_.id AS Id, b.uid AS Uid, ostbensube0_.ost_number AS OstNumber, \r\n" + 
				"Concat(b.first_name, ' ', b.last_name) AS name, mg.name AS Gender, b.date_of_birth AS dateOfBirth, masterdrug4_.name AS Drug,\r\n" + 
				"tiostpresc5_.dosage_qty AS Dosage, max(todi.last_dispensation_date) as dispensationDate, b.age as age, b.first_name as firstName \r\n" + 
				"from soch.ti_ost_beneficiary ostbensube0_ left outer join soch.ti_ost_assessment ostassess1_ on\r\n" + 
				"ostbensube0_.id = ostassess1_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc2_ on\r\n" + 
				"ostassess1_.id = tiostpresc2_.ost_assessment_id left outer join soch.ti_ost_follow_up ostfollowu3_ on\r\n" + 
				"ostbensube0_.id = ostfollowu3_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc5_ on\r\n" + 
				"ostbensube0_.id = tiostpresc5_.ti_ost_beneficiary_id left outer join soch.master_drugs masterdrug4_ ON\r\n" + 
				"tiostpresc5_.substitution_drug = masterdrug4_.id join soch.beneficiary b on b.id = ostbensube0_.beneficiary_id\r\n" + 
				"join soch.master_gender mg ON mg.id = b.gender_id left join soch.ti_ost_dispensation_item todi ON\r\n" + 
				"todi.facility_id = ostbensube0_.facility_id and todi.ti_ost_beneficiary_id = ostbensube0_.id\r\n" + 
				"where ostbensube0_.is_delete = false and( tiostpresc5_.id in ( select max(ostprescri6_.id)\r\n" + 
				"from soch.ti_ost_prescription ostprescri6_ left outer join soch.ti_ost_beneficiary ostbensube7_ on\r\n" + 
				"ostprescri6_.ti_ost_beneficiary_id = ostbensube7_.id left outer join soch.master_client_status_ost masterostc8_ on\r\n" + 
				"ostbensube7_.status_id = masterostc8_.id left outer join soch.master_ost_status_beneficiary masterbene9_ on \r\n" + 
				"ostbensube7_.ost_status_id = masterbene9_.id left outer join soch.master_drugs masterdrug10_ on\r\n" + 
				"ostprescri6_.substitution_drug = masterdrug10_.id where masterbene9_.id = 2 and ostbensube7_.linked_facility_id = :linkedFacilityId\r\n" + 
				"and ostbensube7_.consent_taken_date <= :date and masterostc8_.id in ( 1, 7) and ( ostbensube7_.id not in\r\n" + 
				"( select distinct ostbensube12_.id from soch.ti_ost_dispensation_item ostdispens11_ left outer join\r\n" + 
				" soch.ti_ost_beneficiary ostbensube12_ on ostdispens11_.ti_ost_beneficiary_id = ostbensube12_.id \r\n" + 
				" where ostbensube12_.linked_facility_id = :linkedFacilityId and case when ostdispens11_.take_home_date IS NULL \r\n" + 
				" then ostdispens11_.last_dispensation_date = :date or (ostdispens11_.last_dispensation_date >= :date\r\n" + 
				"and ostdispens11_.last_dispensation_date <= :endDate) else ( (:endDate >= ostdispens11_.last_dispensation_date \r\n" + 
				"and :endDate <= ostdispens11_.take_home_date) or ( :date >= ostdispens11_.last_dispensation_date and\r\n" + 
				":date <= ostdispens11_.take_home_date ) ) end ) ) and masterdrug10_.id = :drug group by ostbensube7_.id ) ) \r\n" + 
				"and ( ostbensube0_.id not in ( select ostbensube13_.id from soch.ti_ost_beneficiary ostbensube13_ \r\n" + 
				"where ostbensube13_.transit_start_date <= :date and :date <= ostbensube13_.transit_end_date and\r\n" + 
				"ostbensube13_.linked_facility_id = :linkedFacilityId ) ) and ostbensube0_.linked_facility_id = :linkedFacilityId and\r\n" + 
				"( lower(b.ost_benf_search_str) like %:searchString% or '' like %:searchString% ) \r\n" + 
				"group by tiostpresc5_.id, ostbensube0_.id, b.uid, ostbensube0_.ost_number, Concat(b.first_name, ' ', b.last_name), \r\n" + 
				"mg.name, b.date_of_birth, masterdrug4_.name, tiostpresc5_.dosage_qty, b.age, b.first_name order by  SUBSTRING(ostbensube0_.ost_number FROM '([0-9]+)')\\:\\:BIGINT DESC, ostbensube0_.ost_number",nativeQuery = true)
				Page<DailyDispensationListProjection> getTakeHomeDispensationOstBeneficiaryListForSatOStSortByOstNumDesc(@Param("linkedFacilityId") Long linkedFacilityId , Pageable pageable ,
				@Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug,@Param("endDate") LocalDate endDate);
				
				
				@Query(value = "SELECT count( DISTINCT ostbensube0_)\r\n" + 
				"from soch.ti_ost_beneficiary ostbensube0_ left outer join soch.ti_ost_assessment ostassess1_ on\r\n" + 
				"ostbensube0_.id = ostassess1_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc2_ on\r\n" + 
				"ostassess1_.id = tiostpresc2_.ost_assessment_id left outer join soch.ti_ost_follow_up ostfollowu3_ on\r\n" + 
				"ostbensube0_.id = ostfollowu3_.ti_ost_beneficiary_id left outer join soch.ti_ost_prescription tiostpresc5_ on\r\n" + 
				"ostbensube0_.id = tiostpresc5_.ti_ost_beneficiary_id left outer join soch.master_drugs masterdrug4_ ON\r\n" + 
				"tiostpresc5_.substitution_drug = masterdrug4_.id join soch.beneficiary b on b.id = ostbensube0_.beneficiary_id\r\n" + 
				"join soch.master_gender mg ON mg.id = b.gender_id left join soch.ti_ost_dispensation_item todi ON\r\n" + 
				"todi.facility_id = ostbensube0_.facility_id and todi.ti_ost_beneficiary_id = ostbensube0_.id\r\n" + 
				"where ostbensube0_.is_delete = false and( tiostpresc5_.id in ( select max(ostprescri6_.id)\r\n" + 
				"from soch.ti_ost_prescription ostprescri6_ left outer join soch.ti_ost_beneficiary ostbensube7_ on\r\n" + 
				"ostprescri6_.ti_ost_beneficiary_id = ostbensube7_.id left outer join soch.master_client_status_ost masterostc8_ on\r\n" + 
				"ostbensube7_.status_id = masterostc8_.id left outer join soch.master_ost_status_beneficiary masterbene9_ on \r\n" + 
				"ostbensube7_.ost_status_id = masterbene9_.id left outer join soch.master_drugs masterdrug10_ on\r\n" + 
				"ostprescri6_.substitution_drug = masterdrug10_.id where masterbene9_.id = 2 and ostbensube7_.linked_facility_id = :linkedFacilityId\r\n" + 
				"and ostbensube7_.consent_taken_date <= :date and masterostc8_.id in ( 1, 7) and ( ostbensube7_.id not in\r\n" + 
				"( select distinct ostbensube12_.id from soch.ti_ost_dispensation_item ostdispens11_ left outer join\r\n" + 
				" soch.ti_ost_beneficiary ostbensube12_ on ostdispens11_.ti_ost_beneficiary_id = ostbensube12_.id \r\n" + 
				" where ostbensube12_.linked_facility_id = :linkedFacilityId and case when ostdispens11_.take_home_date IS NULL \r\n" + 
				" then ostdispens11_.last_dispensation_date = :date or (ostdispens11_.last_dispensation_date >= :date\r\n" + 
				"and ostdispens11_.last_dispensation_date <= :endDate) else ( (:endDate >= ostdispens11_.last_dispensation_date \r\n" + 
				"and :endDate <= ostdispens11_.take_home_date) or ( :date >= ostdispens11_.last_dispensation_date and\r\n" + 
				":date <= ostdispens11_.take_home_date ) ) end ) ) and masterdrug10_.id = :drug group by ostbensube7_.id ) ) \r\n" + 
				"and ( ostbensube0_.id not in ( select ostbensube13_.id from soch.ti_ost_beneficiary ostbensube13_ \r\n" + 
				"where ostbensube13_.transit_start_date <= :date and :date <= ostbensube13_.transit_end_date and\r\n" + 
				"ostbensube13_.linked_facility_id = :linkedFacilityId ) ) and ostbensube0_.linked_facility_id = :linkedFacilityId and\r\n" + 
				"( lower(b.ost_benf_search_str) like %:searchString% or '' like %:searchString% )",nativeQuery = true)
				Long getTakeHomeDispensationOstBeneficiaryListForSatOStCount(@Param("linkedFacilityId") Long linkedFacilityId ,
				@Param("searchString") String searchString, @Param("date") LocalDate date, @Param("drug") Long drug,@Param("endDate") LocalDate endDate);
		
}
