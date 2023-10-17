package gov.naco.soch.repository;

import java.sql.Timestamp;
import java.util.List;

import gov.naco.soch.projection.DispensationProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.projection.StatisticsProjection;

@Repository
public interface ARTDashboardRepository extends JpaRepository<Beneficiary, Long> {

    @Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',abd.visited_date),'MONTH') AS name, "
			+ "	count(*) AS value from soch.art_beneficiary_due_list abd "
			+ "	where abd.facility_id  =:facilityId and abd.is_active = true and abd.is_delete =false and abd.is_visited =false "
			+ " and abd.visited_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getBenificiaryDueForVisit(@Param("facilityId") Long facilityId);

	/*@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',abd.visited_date),'MONTH') AS name,"
			+ " count(*) AS value from soch.art_beneficiary_due_list abd "
			+ " where abd.is_visited =true and abd.facility_id  =:facilityId  " 
			+ " and abd.visited_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1")*/
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',bvr.visit_date),'MONTH') AS name,\r\n"
			+ "count(*) AS value FROM soch.beneficiary_visit_register bvr\r\n"
			+ "WHERE bvr.facility_id =:facilityId AND bvr.visit_date >= date_trunc('month',now())- INTERVAL '11 month' GROUP BY 1")
	List<StatisticsProjection> getBenificiaryForVisit(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id)   AS value from soch.beneficiary b "
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.master_four_s_screening mfs on mfs.id = ab.four_s_screening_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where mfs.id = 1 and bfm.facility_id  =:facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getFourPlusDetectedCountByCc(@Param("facilityId") Long facilityId);

	// Modified query like MissedAppoinmentListing ON 06-AUG-2020
	
	@Query(value = "select TO_CHAR(DATE_TRUNC('month',dq.visited_date),'MONTH') AS name," + 
			"		count(dq.beneficiary_id) AS value from soch.art_beneficiary_due_list dq where dq.facility_id=:facilityId "+
			"		and dq.is_visited=false and dq.visited_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1", nativeQuery = true)
	List<StatisticsProjection> getBenificiaryMissedAppoinmentsCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.art_registration_date),'MONTH') AS name,count(distinct ab.beneficiary_id) AS value from soch.beneficiary b\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id \n" +
			"where bfm.facility_id  =:facilityId and ab.is_active  = true and ab.is_delete =false\n" +
			"and ab.art_registration_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryNewRegistrationsCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where ab.art_start_date is not null and bfm.facility_id  =:facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryNewInitiationsCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',t.accepted_time),'MONTH') AS name,\r\n" + 
			"count(beneficiary_id) as value from soch.transfers t\r\n" + 
			"where t.source_facility_id = :facilityId \r\n" + 
			"and t.is_active = true and lower(t.transfer_status) = lower('ACCEPTED')\r\n" + 
			"and t.accepted_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryTransferOutCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',t.accepted_time),'MONTH') AS name,\r\n" + 
			"count(beneficiary_id) as value from soch.transfers t\r\n" + 
			"where t.destination_facility_id = :facilityId \r\n" + 
			"and t.is_active = true and lower(t.transfer_status) = lower('ACCEPTED')\r\n" + 
			"and t.accepted_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryTransferInCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',t.initiation_date),'MONTH') AS name," + 
			"count(distinct t.beneficiary_id) as value from soch.transfers t " + 
			"inner join soch.beneficiary b on b.id = t.beneficiary_id " + 
			"where t.destination_facility_id = :facilityId " + 
			"and t.is_active = true  and lower(t.transfer_status) = lower('PENDING')" + 
			"and b.is_delete= false and t.is_deleted = false " + 
			"and t.initiation_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryPendingTransferInCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ad.created_time),'MONTH') AS name,"
			+ "	count(*) AS value from soch.art_dispensation ad where ad.facility_id =:facilityId and ad.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getNumberOfDispensationCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,"
			+ "	count(*) AS value from soch.lab_test_sample lts"
			+ "	inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ "	inner join soch.test t on t.id = lts.test_id "
			+ "	where t.id = 2 and lts.result_received_date is not null"
			+ "	and f.id =:facilityId and lts.created_time >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getnumberOfTestsVlConductedCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ad.created_time),'MONTH') AS name ,count(adi.art_dispensation_id ) as value\n "+
			"from soch.art_dispensation ad\n" +
			"inner join soch.art_dispensation_item adi on ad.id = adi.art_dispensation_id\n" +
			"inner join soch.product p on p.id = adi.product_id\n" +
			"where ad.facility_id = :facilityId and p.is_active = true and p.id = :productId\n" +
			"and ad.created_time >= date_trunc('month', now())- interval '11 month'\n "+
			"group by 1")
	List<StatisticsProjection> getNumberOfDispensationAsPerDrugCountDetails(@Param("facilityId") Long facilityId , @Param("productId") int productId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ad.created_time),'MONTH') AS name ,count(adi.art_dispensation_id ) as value, p.id as id\n" +
			"from soch.art_dispensation ad\n" +
			"inner join soch.art_dispensation_item adi on ad.id = adi.art_dispensation_id\n" +
			"inner join soch.product p on p.id = adi.product_id\n" +
			"where ad.facility_id = :facilityId and p.is_active = true and p.id IN :productIds "+
			"and ad.created_time >= date_trunc('month', now())- interval '11 month'\n" +
			"group by 1,p.id")
	List<DispensationProjection> getNumberOfDispensationAsPerDrugCountDetailsV1(@Param("facilityId") Long facilityId , @Param("productIds") List<Integer> productIds);

	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',abi.investigation_date),'MONTH') AS name,"
			+ " count(ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.art_beneficiary_investigation abi on abi.beneficiary_id = ab.beneficiary_id  "
			+ " inner join soch.master_investigation mi on abi.investigation_id = mi.id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and ab.is_active = true and ab.is_delete=false "
			+ " and abi.investigation_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1 ")
	List<StatisticsProjection> getInvestigationCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',bvr.created_time),'MONTH') AS name,  \r\n" + 
			"count(distinct ab.beneficiary_id) as value from soch.beneficiary b  \r\n" + 
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id \r\n" + 
			"inner join soch.beneficiary_visit_register bvr on ab.beneficiary_id  = bvr.beneficiary_id \r\n" + 
			"inner join soch.beneficiary_four_s_symptoms_per_visit bfsv on bfsv.visit_register_id  = bvr.id \r\n" + 
			"inner join soch.master_four_s_symptom mfs on mfs.id = bfsv.four_s_symptom \r\n" + 
			"inner join soch.user_role_mapping urm on bfsv.modified_by  = urm.user_id \r\n" + 
			"inner join soch.role r on r.id = urm.role_id \r\n" + 
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id  \r\n" + 
			"where r.name = 'ART Staff Nurse' and bfm.facility_id  = :facilityId \r\n" + 
			"and bvr.four_s_symptoms  = true and bvr.created_time >= date_trunc('month', now())- interval '11 month'  \r\n" + 
			"and lower(mfs.name) =lower(:symptom) and ab.is_active = true and ab.is_delete=false group by 1")
	List<StatisticsProjection> getFourSplusDetectedCount(@Param("facilityId") Long facilityId , @Param("symptom") String symptom);
	
	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.result_received_date),'MONTH') AS name, "
			+ " count(*) as value from soch.lab_test_sample lts"
			+ " inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ " inner join soch.test t on t.id = lts.test_id "
			+ " where t.id = 1 and lts.result_received_date is not null "
			+ " and f.id =:facilityId and lts.is_delete=false "
			+ " and lts.result_received_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1 ")
	List<StatisticsProjection> getcd4TestConductedCount(@Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',abd.visited_date),'MONTH') AS name, "
				+ "	count(*) AS value from soch.art_beneficiary_due_list abd "
				+ "	where abd.facility_id  =:facilityId and abd.is_active = true and abd.is_delete =false and abd.is_visited =false"
				+ " and abd.visited_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBenificiaryDueForVisitMonthFilterList(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(abd.visited_date,'MM/dd/yyyy') AS name, "
			+ "	count(*) AS value from soch.art_beneficiary_due_list abd "
			+ "	where abd.facility_id  =:facilityId and abd.is_active = true and abd.is_delete =false and abd.is_visited =false"
			+ " and abd.visited_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBenificiaryDueForVisitDaysFilterList(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select f.name as name , count(distinct ab.beneficiary_id ) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id "
			+ " inner join soch.facility f on br.refered_from  = f.id  "
			+ " inner join soch.facility_type ft on ft.id  = f.facility_type_id "
			+ " where ab.facility_id =:facilityId and ft.id =11 and ab.is_active = true and ab.is_delete=false " + " group by f.name ")
	List<StatisticsProjection> getAllFacilities(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select rf.name as name ,count(ab.beneficiary_id ) as value from soch.beneficiary b "
			+ " inner  join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_risk_factor rf on rf.id = ab.hiv_risk_factor_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  = :facilityId and ab.is_active = true and ab.is_delete=false "
			+ " group by rf.name ")
	List<StatisticsProjection> getAllRiskFactorsByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select ep.name as name ,count(ab.beneficiary_id) as value from soch.beneficiary b  "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_entry_point ep on ab.entry_point_id  = ep.id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  = :facilityId and ab.is_active = true and ab.is_delete=false "
			+ " group by ep.name ")
	List<StatisticsProjection> getAllEntryPointsByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select mo.name as name ,count(ab.beneficiary_id )as value from soch.beneficiary b  "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_occupation mo on mo.id  = b.occupation_id  "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  = :facilityId and ab.is_active = true and ab.is_delete=false "
			+ " group by mo.name ")
	List<StatisticsProjection> getAllOccupationByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select el.name as name ,count(ab.beneficiary_id) as value from soch.beneficiary b  "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_education_level el on el.id  = b.education_level_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and ab.is_active = true and ab.is_delete=false " + " group by el.name ")
	List<StatisticsProjection> getAllEducationByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select mi.name as  name ,count(ab.beneficiary_id ) as value from soch.beneficiary b   "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.master_monthly_income mi on b.monthly_income   = mi.id  "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and ab.is_active = true and ab.is_delete=false " + " group by mi.name ")
	List<StatisticsProjection> getAllSalaryByFacilityId(@Param("facilityId") Long facilityId);
	
	/*@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',abd.visited_date),'MONTH') AS name,"
			+ " count(*) AS value from soch.art_beneficiary_due_list abd "
			+ " where abd.is_visited =true and abd.facility_id  =:facilityId  " 
			+ " and abd.visited_date between :dateFrom AND :dateTo GROUP BY 1 ")*/
	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',bvr.visit_date),'MONTH') AS name,\r\n"
			+ "count(*) AS value FROM soch.beneficiary_visit_register bvr\r\n"
			+ "WHERE bvr.facility_id =:facilityId AND bvr.visit_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getFilteredBenificiaryForVisit(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select  TO_CHAR(abd.visited_date,'MM/dd/yyyy') AS name ,"
			+ " count(*) AS value from soch.art_beneficiary_due_list abd "
			+ " where abd.is_visited =true and abd.facility_id  =:facilityId " 
			+ " and abd.visited_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getBenificiaryVisitDaysFilterList(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id)   AS value from soch.beneficiary b "
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.master_four_s_screening mfs on mfs.id = ab.four_s_screening_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where mfs.id = 1 and bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getFourPlusDetectedCountByCcFilteredByMonth(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(ab.created_time,'MM/dd/yyyy') AS name,"
			+ "	count(distinct ab.beneficiary_id)   AS value from soch.beneficiary b "
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ "	inner join soch.master_four_s_screening mfs on mfs.id = ab.four_s_screening_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where mfs.id = 1 and bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getFourPlusDetectedCountByCcFilteredByDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	
	@Query(value = "select TO_CHAR(DATE_TRUNC('month',dq.visited_date),'MONTH') AS name,count(dq.beneficiary_id) AS value from soch.art_beneficiary_due_list dq\n" +
			"where dq.facility_id=:facilityId and dq.is_visited=false  and dq.visited_date between :dateFrom And :dateTo\n" +
			"GROUP BY 1", nativeQuery = true)
	List<StatisticsProjection> getBenificiaryMissedAppoinmentsFilterCountDetails(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	
	@Query(value = "select TO_CHAR(dq.visited_date,'MM/dd/yyyy') AS name,count(dq.beneficiary_id) AS value \n" +
			"from soch.art_beneficiary_due_list dq where dq.facility_id=:facilityId and dq.is_visited=false and\n" +
			"dq.visited_date between :dateFrom And :dateTo GROUP BY 1", nativeQuery = true)
	List<StatisticsProjection> getBenificiaryMissedAppoinmentsFilterByDateCountDetails(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(ab.art_registration_date,'MM/dd/yyyy') AS name,\tcount(distinct ab.beneficiary_id) AS value from soch.beneficiary b\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id \n" +
			"where bfm.facility_id =:facilityId and ab.is_active  = true and ab.is_delete =false \n" +
			"and ab.art_registration_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryNewRegistrationsCountDetailsForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.art_registration_date),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where bfm.facility_id =:facilityId and ab.is_active  = true and ab.is_delete =false"
			+ " and ab.art_registration_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryNewRegistrationsCountDetailsForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(ab.created_time,'MM/dd/yyyy') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where ab.art_start_date is not null and bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryNewInitiationsCountDetailsForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,"
			+ "	count(distinct ab.beneficiary_id) AS value from soch.beneficiary b"
			+ "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id"
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ "	where ab.art_start_date is not null and bfm.facility_id =:facilityId and ab.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryNewInitiationsCountDetailsForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select f.name as name , count(distinct ab.beneficiary_id ) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id "
			+ " inner join soch.facility f on br.refered_from  = f.id  "
			+ " inner join soch.facility_type ft on ft.id  = f.facility_type_id " 
			+ " where ab.facility_id =:facilityId and f.name IN :facilityNames "
			+ " and ft.id =11  and ab.is_active = true and ab.is_delete=false " + " group by f.name")
	List<StatisticsProjection> facilitywiseBreakupUsingFilters(@Param("facilityNames") List<String> facilityNames,@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select  'Others' as name , count(distinct ab.beneficiary_id ) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id "
			+ " inner join soch.facility f on br.refered_from  = f.id "
			+ " inner join soch.facility_type ft on ft.id  = f.facility_type_id "
			+ " where ab.facility_id =:facilityId and f.name NOT IN :facilityNames " + " and ft.id =11 and ab.is_active = true and ab.is_delete=false ")
	List<StatisticsProjection> facilitywiseBreakupOthersUsingFilters(
			@Param("facilityNames") List<String> facilityNames ,@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select rf.name as name ,count(ab.beneficiary_id ) as value from soch.beneficiary b  "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.master_risk_factor rf on rf.id = ab.hiv_risk_factor_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and rf.name IN :riskFactors "
			+ " and ab.is_active = true and ab.is_delete=false " + " group by rf.name ")
	List<StatisticsProjection> riskFactorBreakupUsingFilters(@Param("facilityId") Long facilityId,
			@Param("riskFactors") List<String> riskFactors);

	@Query(nativeQuery = true, value = "select 'Others' as name ,count(ab.beneficiary_id ) as value from soch.beneficiary b  "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.master_risk_factor rf on rf.id = ab.hiv_risk_factor_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and rf.name NOT IN :riskFactors "
			+ " and ab.is_active = true and ab.is_delete=false ")
	List<StatisticsProjection> riskFactorBreakupOthersUsingFilters(@Param("facilityId") Long facilityId,
			@Param("riskFactors") List<String> riskFactors);

	@Query(nativeQuery = true, value = " select ep.name as name ,count(ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_entry_point ep on ab.entry_point_id  = ep.id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and ep.name IN :entryPoints  "
			+ " and ab.is_active = true and ab.is_delete=false " + " group by ep.name ")
	List<StatisticsProjection> entryPointBreakupUsingFilters(@Param("facilityId") Long facilityId,
			@Param("entryPoints") List<String> entryPoints);

	@Query(nativeQuery = true, value = " select 'Others' as name ,count(ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_entry_point ep on ab.entry_point_id  = ep.id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and ep.name NOT IN :entryPoints  "
			+ " and ab.is_active = true and ab.is_delete=false ")
	List<StatisticsProjection> entryPointBreakupOthersUsingFilters(@Param("facilityId") Long facilityId,
			@Param("entryPoints") List<String> entryPoints);

	@Query(nativeQuery = true, value = " select mo.name as name ,count(ab.beneficiary_id ) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_occupation mo on mo.id  = b.occupation_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and mo.name IN :occupations  "
			+ " and ab.is_active = true and ab.is_delete=false  " + " group by mo.name ")
	List<StatisticsProjection> occupationBreakupUsingFilters(@Param("facilityId") Long facilityId,
			@Param("occupations") List<String> occupations);

	@Query(nativeQuery = true, value = " select 'Others' as name ,count(ab.beneficiary_id ) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id  "
			+ " inner join soch.master_occupation mo on mo.id  = b.occupation_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and mo.name NOT IN :occupations  "
			+ " and ab.is_active = true and ab.is_delete=false ")
	List<StatisticsProjection> occupationBreakupOthersUsingFilters(@Param("facilityId") Long facilityId,
			@Param("occupations") List<String> occupations);

	@Query(nativeQuery = true, value = " select el.name as name ,count(ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.master_education_level el on el.id  = b.education_level_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and el.name IN :educations "
			+ " and ab.is_active = true and ab.is_delete=false " + " group by el.name ")
	List<StatisticsProjection> educationBreakupUsingFilters(@Param("facilityId") Long facilityId,
			@Param("educations") List<String> educations);

	@Query(nativeQuery = true, value = " select 'Others' as name ,count(ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.master_education_level el on el.id  = b.education_level_id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  =:facilityId and el.name NOT IN :educations "
			+ " and ab.is_active = true and ab.is_delete=false ")
	List<StatisticsProjection> educationBreakupOthersUsingFilters(@Param("facilityId") Long facilityId,
			@Param("educations") List<String> educations);

	@Query(nativeQuery = true, value = "select mi.name as name ,count(ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.master_monthly_income mi on b.monthly_income   = mi.id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  = :facilityId and mi.name IN :salaries "
			+ " and ab.is_active = true and ab.is_delete=false " + " group by mi.name ")
	List<StatisticsProjection> salaryBreakupUsingFilters(@Param("facilityId") Long facilityId,
			@Param("salaries") List<String> salaries);

	@Query(nativeQuery = true, value = "select 'Others' as name ,count(ab.beneficiary_id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.master_monthly_income mi on b.monthly_income   = mi.id "
			+ " inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id "
			+ " where bfm.facility_id  = :facilityId and mi.name NOT IN :salaries "
			+ " and ab.is_active = true and ab.is_delete=false ")
	List<StatisticsProjection> salaryBreakupOthersUsingFilters(@Param("facilityId") Long facilityId,
			@Param("salaries") List<String> salaries);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,count(*) AS value from soch.lab_test_sample lts \n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id "
			+ "inner join soch.test t on t.id = lts.test_id  "
			+ "where t.id = 2  and lts.result_received_date is not null and f.id =:facilityId GROUP BY 1")
	List<StatisticsProjection> getVlTestConducted(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.result_dispatch_date),'MONTH') AS name,count(*) AS value from soch.lab_test_sample lts\n" +
			"inner join soch.facility f on f.id = lts.sample_collected_facility_id\n" +
			"inner join soch.test t on t.id = lts.test_id\n" +
			"where lts.result_status_id=4 and t.id = 1 and lts.result_received_date is not null and f.id = :facilityId\n" +
			"and result_value is not null and  result_value !='' and cast(result_value as INT)<350\n" +
			"group by 1")
	List<StatisticsProjection> getcd4TestLessThan350(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.sample_collected_date ),'MONTH') AS name,count(*) AS value from soch.lab_test_sample lts\n" +
			"inner join soch.facility f on f.id = lts.sample_collected_facility_id\n" +
			"inner join soch.test t on t.id = lts.test_id  \n" +
			"where t.id = 1 and lts.sample_collected_date is not null \n" +
			"and f.id = :facilityId GROUP BY 1")
	List<StatisticsProjection> getcd4SamplesCollected(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.sample_dispatch_date ),'MONTH') AS name,count(*) AS value from soch.lab_test_sample lts\n" +
			"inner join soch.facility f on f.id = lts.sample_collected_facility_id\n" +
			"inner join soch.test t on t.id = lts.test_id  \n" +
			"where t.id = 1 and lts.sample_dispatch_date is not null \n" +
			"and f.id = :facilityId GROUP BY 1")
	List<StatisticsProjection> getcd4SamplesDispatched(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',t.accepted_time),'MONTH') AS name,\r\n" + 
			"count(beneficiary_id) as value from soch.transfers t\r\n" + 
			"where t.destination_facility_id = :facilityId \r\n" + 
			"and t.is_active = true and lower(t.transfer_status) = lower('ACCEPTED')\r\n" + 
			"and t.accepted_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryTransferInFilterCount(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',t.accepted_time),'MONTH') AS name,\r\n" + 
			"count(beneficiary_id) as value from soch.transfers t\r\n" + 
			"where t.source_facility_id = :facilityId \r\n" + 
			"and t.is_active = true and lower(t.transfer_status) = lower('ACCEPTED')\r\n" + 
			"and t.accepted_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryTransferOutFilterCount(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(t.accepted_time,'MM/dd/yyyy') AS name,\r\n" + 
			"count(beneficiary_id) as value from soch.transfers t\r\n" + 
			"where t.destination_facility_id = :facilityId \r\n" + 
			"and t.is_active = true and lower(t.transfer_status) = lower('ACCEPTED')\r\n" + 
			"and t.accepted_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryTransferInFilterCountByDate(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(t.accepted_time,'MM/dd/yyyy') AS name,\r\n" + 
			"count(beneficiary_id) as value from soch.transfers t\r\n" + 
			"where t.source_facility_id = :facilityId \r\n" + 
			"and t.is_active = true and lower(t.transfer_status) = lower('ACCEPTED')\r\n" + 
			"and t.accepted_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryTransferOutFilterCountByDate(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',t.initiation_date),'MONTH') AS name, \r\n" + 
			"count(t.source_facility_id) AS value from soch.transfers t \r\n" + 
			"where t.destination_facility_id =:facilityId and t.transfer_status= lower('PENDING') and\r\n" + 
			"t.initiation_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryPendingTransferInFilterByMonthCountDetails(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(t.initiation_date,'MM/dd/yyyy') AS name, \r\n" + 
			"count(t.source_facility_id) AS value from soch.transfers t \r\n" + 
			"where t.destination_facility_id =:facilityId and t.transfer_status= lower('PENDING') and\r\n" + 
			"t.initiation_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryPendingTransferInFilterByDateCountDetails(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ad.created_time),'MONTH') AS name,"
			+ "	count(*) AS value from soch.art_dispensation ad where ad.facility_id =:facilityId and ad.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getNumberOfDispensationCountFilterByMonthDetails(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(ad.created_time,'MM/dd/yyyy') AS name,"
			+ "	count(*) AS value from soch.art_dispensation ad where ad.facility_id =:facilityId and ad.created_time between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getNumberOfDispensationCountFilterByDateDetails(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,"
			+ "	count(*) AS value from soch.lab_test_sample lts"
			+ "	inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ "	inner join soch.test t on t.id = lts.test_id "
			+ "	where t.id = 2 and lts.result_received_date is not null"
			+ "	and f.id =:facilityId and lts.created_time between :dateFrom and :dateTo GROUP BY 1")
	List<StatisticsProjection> getnumberOfTestsVlConductedCountDetailsFilteredByMonth(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(lts.created_time,'MM/dd/yyyy') AS name,"
			+ "	count(*) AS value from soch.lab_test_sample lts"
			+ "	inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ "	inner join soch.test t on t.id = lts.test_id "
			+ "	where t.id = 2 and lts.result_received_date is not null"
			+ "	and f.id =:facilityId and lts.created_time between :dateFrom and :dateTo GROUP BY 1")
	List<StatisticsProjection> getnumberOfTestsVlConductedCountDetailsFilteredByDate(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select  TO_CHAR(ad.created_time,'MM/dd/yyyy') AS name,count(adi.art_dispensation_id ) as value \n" +
			"from soch.art_dispensation ad \n" +
			"inner join soch.art_dispensation_item adi on ad.id = adi.art_dispensation_id \n" +
			"inner join soch.product p on p.id = adi.product_id \n" +
			"where ad.facility_id = :facilityId and p.is_active = true \n" +
			"and ad.created_time between :dateFrom and :dateTo and p.id =:productId \n" +
			"group by 1")
	List<StatisticsProjection> getNumberOfDispensationAsPerDrugCountDetailsByDateFilter(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo, @Param("productId") int productId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ad.created_time),'MONTH') AS name,count(adi.art_dispensation_id ) as value \n" +
			"from soch.art_dispensation ad \n" +
			"inner join soch.art_dispensation_item adi on ad.id = adi.art_dispensation_id \n" +
			"inner join soch.product p on p.id = adi.product_id \n" +
			"where ad.facility_id = :facilityId and p.is_active = true  \n" +
			"and ad.created_time between :dateFrom and :dateTo and p.id =:productId \n" +
			"group by 1")
	List<StatisticsProjection> getNumberOfDispensationAsPerDrugCountDetailsByMonthFilter(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo, @Param("productId") int productId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.sample_received_date),'MONTH') AS name, count(*) AS value from soch.lab_test_sample lts\r\n" + 
			"inner join soch.facility f on f.id = lts.sample_collected_facility_id\r\n" + 
			"inner join soch.test t on t.id = lts.test_id\r\n" + 
			"where t.id = 2 and lts.sample_received_date is not null\r\n" + 
			"and f.id = :facilityId GROUP BY 1")
	List<StatisticsProjection> getVlSamplesCollected(@Param("facilityId") Long facilityId);
		
	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.sample_dispatch_date),'MONTH') AS name, count(*) AS value from soch.lab_test_sample lts\r\n" + 
			"inner join soch.facility f on f.id = lts.sample_collected_facility_id\r\n" + 
			"inner join soch.test t on t.id = lts.test_id\r\n" + 
			"where t.id = 2  and lts.sample_dispatch_date is not null\r\n" + 
			"and f.id = :facilityId GROUP BY 1")
	List<StatisticsProjection> getVlSamplesDispatched(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',br.accepted_date),'MONTH') AS name,count( b.id ) as value from soch.beneficiary  b\r\n" + 
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = b.id\r\n" + 
			"where  br.refered_to =:facilityId and br.referral_status_id =3 and br.is_active = true and br.is_delete = false\r\n" + 
			"and br.accepted_date >= date_trunc('month', now())- interval '11 month' group by 1 ")
	List<StatisticsProjection> getreferredFromICTCCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',br.accepted_date),'MONTH') AS name,count( b.id ) as value from soch.beneficiary  b\r\n" + 
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = b.id\r\n" + 
			"where  br.refered_to =:facilityId and br.referral_status_id =3 and br.is_active = true and br.is_delete = false\r\n" + 
			"and br.accepted_date between :dateFrom and :dateTo group by 1 ")
	List<StatisticsProjection> getreferredFromICTCCountDetailsByMonthFilter(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(br.accepted_date,'MM/dd/yyyy') AS name ,count( b.id ) as value from soch.beneficiary  b\r\n" + 
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = b.id\r\n" + 
			"where  br.refered_to =:facilityId and br.referral_status_id =3 and br.is_active = true and br.is_delete = false\r\n" + 
			"and br.accepted_date between :dateFrom and :dateTo group by 1 ")
	List<StatisticsProjection> getreferredFromICTCCountDetailsByDateFilter(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.tb_treatment_completion_date ),'MONTH') as name ,count(distinct ab.id ) as value\n" +
			"from soch.art_beneficiary ab\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = ab.beneficiary_id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = ab.beneficiary_id\n" +
			"where bfm.facility_id  = :facilityId and ab.is_active =true and ab.is_delete =false\n" +
			"and iad.tb_treatment_completion_date is not null\n" +
			"and iad.tb_treatment_completion_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getAttCompletionDetailsCountDetails(@Param("facilityId") Long facilityId);

	// dummy query
	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id ) from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id\n" +
			"inner join soch.facility f on br.refered_from  = f.id\n" +
			"where bfm.id = :facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' group by 1")
	List<StatisticsProjection> getwidgetForAttStoppedOrOptedOutCountDetails(@Param("facilityId") Long facilityId);

	// dummy query
	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id ) from soch.beneficiary b\n" +
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id \n" +
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id \n" +
			"inner join soch.facility f on br.refered_from  = f.id\n" +
			"where bfm.id = :facilityId and ab.created_time between :dateFrom and :dateTo group by 1 ")
	List<StatisticsProjection> getwidgetForAttStoppedOrOptedOutFilterByMonthCountDetails(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	// dummy query
	@Query(nativeQuery = true, value = "select  TO_CHAR(ab.created_time,'MM/dd/yyyy') AS name,count(distinct ab.beneficiary_id ) from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id\n" +
			"inner join soch.facility f on br.refered_from  = f.id \n" +
			"where bfm.id = :facilityId and ab.created_time between :dateFrom and :dateTo group by 1")
	List<StatisticsProjection> getwidgetForAttStoppedOrOptedOutFilterByDatesCountDetails(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	// dummy query
	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') AS name,count(distinct ab.beneficiary_id ) from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id \n" +
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id\n" +
			"inner join soch.facility f on br.refered_from  = f.id\n" +
			"where bfm.id = :facilityId and ab.created_time >= date_trunc('month', now())- interval '11 month' group by 1 ")
	List<StatisticsProjection> getwidgetForbeneficiaryStatusBreakUpCountDetails(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') as name , count(ab.beneficiary_id ) as value\n" +
			"from soch.art_beneficiary ab inner join soch.beneficiary b on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id\n" +
			"where ab.beneficiary_id NOT IN (select t.beneficiary_id from soch.transfers t\n" +
			"where t.source_facility_id = :facilityId and lower(t.transfer_status) = lower('ACCEPTED'))\n" +
			"and bfm.facility_id = :facilityId and ab.is_active = true and ab.is_delete =false and mabs.id = :statusId\n" +
			"and ab.created_time >= date_trunc('month', now())- interval '11 month' group by 1")
	List<StatisticsProjection> getwidgetForbeneficiaryStatusBreakUpCountDetailsForStatus(
			@Param("facilityId") Long facilityId, @Param("statusId") int statusId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',ab.created_time),'MONTH') as name , count(ab.beneficiary_id ) as value, mabs.id as id\n" +
			"from soch.art_beneficiary ab inner join soch.beneficiary b on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.master_art_beneficiary_status mabs on mabs.id = ab.art_beneficiary_status_id\n" +
			"where ab.beneficiary_id NOT IN (select t.beneficiary_id from soch.transfers t\n" +
			"where t.source_facility_id = :facilityId and lower(t.transfer_status) = lower('ACCEPTED'))\n" +
			"and bfm.facility_id = :facilityId and ab.is_active = true and ab.is_delete =false and mabs.id IN :statusIds \n" +
			"and ab.created_time >= date_trunc('month', now())- interval '11 month' group by 1,mabs.id")
	List<DispensationProjection> getwidgetForbeneficiaryStatusBreakUpCountDetailsForStatusV1(
			@Param("facilityId") Long facilityId, @Param("statusIds") List<Integer> statusIds);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.tb_treatment_completion_date ),'MONTH') as name ,count(distinct ab.id ) as value\n" +
			"from soch.art_beneficiary ab\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = ab.beneficiary_id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = ab.beneficiary_id\n" +
			"where bfm.facility_id  = :facilityId and ab.is_active =true and ab.is_delete =false\n" +
			"and iad.tb_treatment_completion_date is not null\n" +
			"and iad.tb_treatment_completion_date between :dateFrom and :dateTo GROUP BY 1")
	List<StatisticsProjection> getwidgetForAttCompletionFilterByMonthGraphCountDetails(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(iad.tb_treatment_completion_date,'MM/dd/yyyy') as name ,count(distinct ab.id ) as value\n" +
			"from soch.art_beneficiary ab\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = ab.beneficiary_id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = ab.beneficiary_id\n" +
			"where bfm.facility_id  = :facilityId and ab.is_active =true and ab.is_delete =false\n" +
			"and iad.tb_treatment_completion_date is not null\n" +
			"and iad.tb_treatment_completion_date between :dateFrom and :dateTo GROUP BY 1")
	List<StatisticsProjection> getwidgetForAttCompletionFilterByDateGraphCountDetails(
			@Param("facilityId") Long facilityId, @Param("dateFrom") Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select  TO_CHAR(DATE_TRUNC('month',abi.investigation_date),'MONTH') AS name, count(ab.beneficiary_id) as value from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.art_beneficiary_investigation abi on abi.beneficiary_id = ab.beneficiary_id \n" +
			"inner join soch.master_investigation mi on abi.investigation_id = mi.id\n" +
			"where bfm.facility_id  = :facilityId and ab.is_active = true and ab.is_delete=false\n" +
			"and abi.investigation_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getInvestigationCountDetailsForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(abi.investigation_date,'MM/dd/yyyy') AS name, count(ab.beneficiary_id) as value from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.art_beneficiary_investigation abi on abi.beneficiary_id = ab.beneficiary_id \n" +
			"inner join soch.master_investigation mi on abi.investigation_id = mi.id\n" +
			"where bfm.facility_id  = :facilityId and ab.is_active = true and ab.is_delete=false\n" +
			"and abi.investigation_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getInvestigationCountDetailsForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',bvr.created_time),'MONTH') AS name,  \r\n" + 
			"count(distinct ab.beneficiary_id) as value from soch.beneficiary b  \r\n" + 
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id \r\n" + 
			"inner join soch.beneficiary_visit_register bvr on ab.beneficiary_id  = bvr.beneficiary_id \r\n" + 
			"inner join soch.beneficiary_four_s_symptoms_per_visit bfsv on bfsv.visit_register_id  = bvr.id \r\n" + 
			"inner join soch.master_four_s_symptom mfs on mfs.id = bfsv.four_s_symptom \r\n" + 
			"inner join soch.user_role_mapping urm on bfsv.modified_by  = urm.user_id \r\n" + 
			"inner join soch.role r on r.id = urm.role_id \r\n" + 
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id  \r\n" + 
			"where r.name = 'ART Staff Nurse' and bfm.facility_id  = :facilityId \r\n" + 
			"and bvr.four_s_symptoms  = true and bvr.created_time between :dateFrom AND :dateTo  \r\n" + 
			"and lower(mfs.name) =lower(:symptom) and ab.is_active = true and ab.is_delete=false group by 1 ")
	List<StatisticsProjection> getFourSPlusDetectedCountDetailsForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo , @Param("symptom") String symptom);

	@Query(nativeQuery = true, value = "select TO_CHAR(bvr.created_time,'MM/dd/yyyy') AS name ,  \r\n" + 
			"count(distinct ab.beneficiary_id) as value from soch.beneficiary b  \r\n" + 
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id \r\n" + 
			"inner join soch.beneficiary_visit_register bvr on ab.beneficiary_id  = bvr.beneficiary_id \r\n" + 
			"inner join soch.beneficiary_four_s_symptoms_per_visit bfsv on bfsv.visit_register_id  = bvr.id \r\n" + 
			"inner join soch.master_four_s_symptom mfs on mfs.id = bfsv.four_s_symptom \r\n" + 
			"inner join soch.user_role_mapping urm on bfsv.modified_by  = urm.user_id \r\n" + 
			"inner join soch.role r on r.id = urm.role_id \r\n" + 
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id  \r\n" + 
			"where r.name = 'ART Staff Nurse' and bfm.facility_id  =:facilityId \r\n" + 
			"and bvr.four_s_symptoms  = true and bvr.created_time between :dateFrom AND :dateTo  \r\n" + 
			"and lower(mfs.name) =lower(:symptom) and ab.is_active = true and ab.is_delete=false group by 1 ")
	List<StatisticsProjection> getFourSPlusDetectedCountDetailsForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo,@Param("symptom") String symptom);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.created_time),'MONTH') AS name,count(*) AS value from soch.lab_test_sample lts \n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id  \n"
			+ "where t.id = 2 and lts.result_received_date is not null \n"
			+ "and f.id = :facilityId  and lts.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getFilteredVlTestConductedForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(lts.created_time,'MM/dd/yyyy') AS name,count(*) AS value from soch.lab_test_sample lts \n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id  \n"
			+ "where t.id = 2 and lts.result_received_date is not null \n"
			+ "and f.id = :facilityId and lts.created_time between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getFilteredVlTestConductedForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.result_dispatch_date),'MONTH') AS name,count(*) AS value from soch.lab_test_sample lts\n" +
			"inner join soch.facility f on f.id = lts.sample_collected_facility_id\n" +
			"inner join soch.test t on t.id = lts.test_id\n" +
			"where lts.result_status_id=4 and t.id = 1 and lts.result_received_date is not null and f.id = :facilityId\n" +
			"and result_value is not null and  result_value !='' and cast(result_value as INT)<350\n" +
			"and lts.result_dispatch_date between :dateFrom AND :dateTo\n" +
			"group by 1")
	List<StatisticsProjection> getFilteredCd4TestLessThan350ForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(lts.result_dispatch_date,'MM/dd/yyyy') AS name,count(*) AS value from soch.lab_test_sample lts\n" +
			"inner join soch.facility f on f.id = lts.sample_collected_facility_id\n" +
			"inner join soch.test t on t.id = lts.test_id\n" +
			"where lts.result_status_id=4 and t.id = 1 and lts.result_received_date is not null and f.id = :facilityId\n" +
			"and result_value is not null and  result_value !='' and cast(result_value as INT)<350\n" +
			"and lts.result_dispatch_date between :dateFrom AND :dateTo\n" +
			"group by 1")
	List<StatisticsProjection> getFilteredCd4TestLessThan350ForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.sample_collected_date),'MONTH') AS name,count(*) AS value from soch.lab_test_sample lts\n" +
			"inner join soch.facility f on f.id = lts.sample_collected_facility_id\n" +
			"inner join soch.test t on t.id = lts.test_id  \n" +
			"where t.id = 1 and lts.sample_collected_date is not null\n" +
			"and f.id = :facilityId and lts.sample_collected_date between :dateFrom AND :dateTo\n" +
			"GROUP BY 1")
	List<StatisticsProjection> getFilteredCd4SamplesCollectedForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(lts.sample_collected_date,'MM/dd/yyyy') AS name,count(*) AS value from soch.lab_test_sample lts\n" +
			"inner join soch.facility f on f.id = lts.sample_collected_facility_id\n" +
			"inner join soch.test t on t.id = lts.test_id \n" +
			"where t.id = 1 and lts.sample_collected_date is not null\n" +
			"and f.id = :facilityId and lts.sample_collected_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getFilteredCd4SamplesCollectedForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.sample_dispatch_date ),'MONTH') AS name,count(*) AS value from soch.lab_test_sample lts\n" +
			"inner join soch.facility f on f.id = lts.sample_collected_facility_id\n" +
			"inner join soch.test t on t.id = lts.test_id  \n" +
			"where t.id = 1 and lts.sample_dispatch_date is not null\n" +
			"and f.id = :facilityId and lts.sample_dispatch_date between :dateFrom AND :dateTo\n" +
			"GROUP BY 1")
	List<StatisticsProjection> getFilteredCd4SamplesDispatchedForMonths(@Param("facilityId") Long facilityId,
																	   @Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(lts.sample_dispatch_date,'MM/dd/yyyy') AS name,count(*) AS value from soch.lab_test_sample lts\n" +
			"inner join soch.facility f on f.id = lts.sample_collected_facility_id\n" +
			"inner join soch.test t on t.id = lts.test_id \n" +
			"where t.id = 1 and lts.sample_dispatch_date is not null\n" +
			"and f.id = :facilityId and lts.sample_dispatch_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getFilteredCd4SamplesDispatchedForDates(@Param("facilityId") Long facilityId,
																	  @Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.sample_received_date),'MONTH') AS name, count(*) AS value from soch.lab_test_sample lts\r\n" + 
			"inner join soch.facility f on f.id = lts.sample_collected_facility_id\r\n" + 
			"inner join soch.test t on t.id = lts.test_id  \r\n" + 
			"where t.id = 2 and lts.sample_received_date is not null \r\n" + 
			"and lts.sample_dispatch_date is not null \r\n" + 
			"and f.id = :facilityId and lts.sample_received_date between :dateFrom AND :dateTo\r\n" + 
			"GROUP BY 1")
	List<StatisticsProjection> getFilteredVlSamplesCollectedForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);
	
	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.sample_dispatch_date),'MONTH') AS name, count(*) AS value from soch.lab_test_sample lts\r\n" + 
			"inner join soch.facility f on f.id = lts.sample_collected_facility_id\r\n" + 
			"inner join soch.test t on t.id = lts.test_id  \r\n" + 
			"where t.id = 2 and lts.sample_received_date is not null \r\n" + 
			"and lts.sample_dispatch_date is not null \r\n" + 
			"and f.id = :facilityId and lts.sample_dispatch_date between :dateFrom AND :dateTo\r\n" + 
			"GROUP BY 1")
	List<StatisticsProjection> getFilteredVlSamplesDispatchedForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);
	
	@Query(nativeQuery = true, value = "select TO_CHAR(lts.sample_received_date,'MM/dd/yyyy') AS name, count(*) AS value from soch.lab_test_sample lts\n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id  \n"
			+ "where t.id = 2 and lts.sample_received_date is not null \n"
			+ "and lts.sample_dispatch_date is not null \n"
			+ "and f.id = :facilityId and lts.sample_received_date between :dateFrom AND :dateTo\n" + "GROUP BY 1")
	List<StatisticsProjection> getFilteredVlSamplesCollectedForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);
	
	@Query(nativeQuery = true, value = "select TO_CHAR(lts.sample_dispatch_date,'MM/dd/yyyy') AS name, count(*) AS value from soch.lab_test_sample lts\n"
			+ "inner join soch.facility f on f.id = lts.sample_collected_facility_id\n"
			+ "inner join soch.test t on t.id = lts.test_id  \n"
			+ "where t.id = 2 and lts.sample_received_date is not null \n"
			+ "and lts.sample_dispatch_date is not null \n"
			+ "and f.id = :facilityId and lts.sample_dispatch_date between :dateFrom AND :dateTo\n" + "GROUP BY 1")
	List<StatisticsProjection> getFilteredVlSamplesDispatchedForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);
	
	@Query(nativeQuery = true, value = "select p.product_name as name, coalesce(sum(fas.available_quantity),0) as value from (select product_id, facility_id, git,damaged_quantity,case\n" +
			"when date(batch_expiry_date) < date(now()) then 0 else available_quantity\n" +
			"end as available_quantity,case\n" +
			"when date(batch_expiry_date) < date(now()) then available_quantity else 0\n" +
			"end as expired_quantity from soch.facility_aggregate_stock\n" +
			"where facility_id = :facilityId ) fas\n" +
			"inner join soch.product p on p.id = fas.product_id where p.is_active =true and p.is_delete =false and fas.facility_id = :facilityId group by p.product_name")
	List<StatisticsProjection> getInventoryQuantityPerDrug(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select p.product_name as name, coalesce(sum(fas.available_quantity),0) as value from (select product_id, facility_id, git,damaged_quantity,case\n" +
			"when date(batch_expiry_date) < date(now()) then 0 else available_quantity\n" +
			"end as available_quantity,case\n" +
			"when date(batch_expiry_date) < date(now()) then available_quantity else 0\n" +
			"end as expired_quantity from soch.facility_aggregate_stock\n" +
			"where facility_id = :facilityId) fas\n" +
			"inner join soch.product p on p.id = fas.product_id where p.is_active =true and p.is_delete =false and fas.facility_id = :facilityId\n" +
			"and p.product_name in :drugs\n" +
			"group by p.product_name")
	List<StatisticsProjection> getInventoryQuantityPerDrugForFilters(@Param("facilityId") Long facilityId,
			@Param("drugs") List<String> drugs);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',abcd.entry_date),'MONTH') AS name, count(b.id) as value from soch.beneficiary b \n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id \n" +
			"inner join soch.art_beneficiary_clinical_details abcd on abcd.beneficiary_id = b.id\n" +
			"where bfm.facility_id = :facilityId and ab.is_active  = true  GROUP BY 1")
	List<StatisticsProjection> getRegimenBreakup(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',abcd.entry_date),'MONTH') AS name, count(b.id) as value, abcd.regimen_id as id from soch.beneficiary b \n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id \n" +
			"inner join soch.art_beneficiary_clinical_details abcd on abcd.beneficiary_id = b.id\n" +
			"where bfm.facility_id = :facilityId and ab.is_active  = true and abcd.regimen_id IN :regimenIds GROUP BY 1, abcd.regimen_id")
	List<DispensationProjection> getRegimenBreakupV1(@Param("facilityId") Long facilityId, @Param("regimenIds")List<Integer> regimenIds);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',lts.result_received_date),'MONTH') AS name, "
			+ " count(*) as value from soch.lab_test_sample lts"
			+ " inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ " inner join soch.test t on t.id = lts.test_id "
			+ " where t.id = 1 and lts.result_received_date is not null "
			+ " and f.id =:facilityId and lts.is_delete=false "
			+ " and lts.result_received_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getcd4TestConductedCountForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(lts.result_received_date,'MM/dd/yyyy') AS name, "
			+ " count(*) as value from soch.lab_test_sample lts"
			+ " inner join soch.facility f on f.id = lts.sample_collected_facility_id"
			+ " inner join soch.test t on t.id = lts.test_id "
			+ " where t.id = 1 and lts.result_received_date is not null "
			+ " and f.id =:facilityId and lts.is_delete=false "
			+ " and lts.result_received_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getcd4TestConductedCountForDates(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',abcd.entry_date),'MONTH') AS name, count(abcd.id) "+
     " 	as value from  soch.art_beneficiary_clinical_details abcd "+
	 " 	inner join soch.beneficiary b  on abcd.beneficiary_id = b.id  " +
	 "	inner join soch.beneficiary_visit_register bvr on bvr.beneficiary_id = b.id "+
	 "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id " +
	 "	inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id " +
	 "	where bvr.is_pregnant = true and  bfm.facility_id =:facilityId and ab.is_active  = true and abcd.entry_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1 ")
	List<StatisticsProjection> getPregnantDetectedCount(@Param("facilityId") Long facilityId);

	
	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',abcd.entry_date),'MONTH') AS name, count(abcd.id) "+
		     " 	as value from  soch.art_beneficiary_clinical_details abcd "+
			 " 	inner join soch.beneficiary b  on abcd.beneficiary_id = b.id  " +
			 "	inner join soch.beneficiary_visit_register bvr on bvr.beneficiary_id = b.id "+
			 "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id " +
			 "	inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id " +
			 "	where bvr.is_pregnant = true and  bfm.facility_id =:facilityId and ab.is_active  = true and abcd.entry_date between :dateFrom AND :dateTo  GROUP BY 1")
	List<StatisticsProjection> getPregnantDetectedCountForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(abcd.entry_date,'MM/dd/yyyy')  AS name, count(abcd.id) "+
		     " 	as value from  soch.art_beneficiary_clinical_details abcd "+
			 " 	inner join soch.beneficiary b  on abcd.beneficiary_id = b.id  " +
			 "	inner join soch.beneficiary_visit_register bvr on bvr.beneficiary_id = b.id "+
			 "	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id " +
			 "	inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id " +
			 "	where bvr.is_pregnant = true and  bfm.facility_id =:facilityId and ab.is_active  = true and abcd.entry_date between :dateFrom AND :dateTo  GROUP BY 1")
	List<StatisticsProjection> getPregnantWomenDetectedCountForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	
	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',abcd.entry_date),'MONTH') AS name, count(abcd.id) "+
		    " 	as value from  soch.art_beneficiary_clinical_details abcd "+
			" 	inner join soch.beneficiary b  on abcd.beneficiary_id = b.id \n" +
			"	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"	inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id \n" +
			"	where abcd.pptct_referred = true and  bfm.facility_id = :facilityId and ab.is_active  = true  GROUP BY 1")
	List<StatisticsProjection> getPregnantReferredCount(@Param("facilityId") Long facilityId);

	
	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',abcd.entry_date),'MONTH') AS name, count(abcd.id) "+
		    " 	as value from  soch.art_beneficiary_clinical_details abcd "+
			" 	inner join soch.beneficiary b  on abcd.beneficiary_id = b.id \n" +
			"	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"	inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id \n" +
			"	where abcd.pptct_referred = true and  bfm.facility_id = :facilityId and ab.is_active  = true and abcd.entry_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getPregnantReferredCountForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);



	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',abcd.entry_date),'MONTH') AS name, count(abcd.id) "+
		    " 	as value from  soch.art_beneficiary_clinical_details abcd "+
			" 	inner join soch.beneficiary b  on abcd.beneficiary_id = b.id \n" +
			"	inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"	inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id \n" +
			"	where abcd.pptct_referred = true and  bfm.facility_id = :facilityId and ab.is_active  = true and abcd.entry_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getPregnantWomenRefferedCountForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.tb_test_referred_date),'MONTH') as name ,count( distinct ab.id ) as value from soch.art_beneficiary ab\n" + 
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = ab.beneficiary_id\n" + 
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = ab.beneficiary_id\n" + 
			"where bfm.facility_id  = :facilityId and ab.is_active =true and ab.is_delete =false \n" + 
			"and iad.tb_test_referred_date is not null and iad.four_s_screening_id = 1 \n" + 
			"and lower(iad.tb_referral_facility) = 'ntep'\n" + 
			"and iad.tb_test_referred_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1 ")
	List<StatisticsProjection> getNtepReferralCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.tb_test_referred_date),'MONTH') as name ,count( distinct ab.id ) as value from soch.art_beneficiary ab\n" + 
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = ab.beneficiary_id\n" + 
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = ab.beneficiary_id\n" + 
			"where bfm.facility_id  = :facilityId and ab.is_active =true and ab.is_delete =false \n" + 
			"and iad.tb_test_referred_date is not null and iad.four_s_screening_id = 1 \n" + 
			"and lower(iad.tb_referral_facility) = 'ntep'\n" + 
			"and iad.tb_test_referred_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getNtepReferralCountDetailsForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(iad.tb_test_referred_date,'MM/dd/yyyy') AS name ,count( distinct ab.id ) as value from soch.art_beneficiary ab\n" + 
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = ab.beneficiary_id\n" + 
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = ab.beneficiary_id\n" + 
			"where bfm.facility_id  = :facilityId and ab.is_active =true and ab.is_delete =false \n" + 
			"and iad.tb_test_referred_date is not null and iad.four_s_screening_id = 1 \n" + 
			"and lower(iad.tb_referral_facility) = 'ntep'\n" + 
			"and iad.tb_test_referred_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getNtepReferralCountDetailsForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.ipt_start_date ),'MONTH') as name ,count(distinct b.id ) as value from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  = :facilityId and b.is_active =true and b.is_delete =false\n" +
			"and iad.ipt_start_date is not null\n" +
			"and iad.ipt_start_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getIptInitiationCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.ipt_start_date ),'MONTH') as name ,count(distinct b.id ) as value from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id \n" +
			"where bfm.facility_id  = :facilityId and b.is_active =true and b.is_delete =false \n" +
			"and iad.ipt_start_date is not null\n" +
			"and iad.ipt_start_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getIptInitiationCountForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(iad.ipt_start_date,'MM/dd/yyyy') AS name,count(distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id = :facilityId and b.is_active =true and b.is_delete =false\n" +
			"and iad.ipt_start_date is not null\n" +
			"and iad.ipt_start_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getIptInitiationCountForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.ipt_end_date ),'MONTH') as name ,count( distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true and b.is_delete =false\n" +
			"and iad.ipt_end_date is not null\n" +
			"and iad.ipt_end_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getIptCompletionCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.ipt_end_date ),'MONTH') as name ,count( distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true and b.is_delete =false\n" +
			"and iad.ipt_end_date is not null and iad.ipt_end_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getIptCompletionCountForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(iad.ipt_end_date,'MM/dd/yyyy') AS name,count( distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true and b.is_delete =false\n" +
			"and iad.ipt_end_date is not null and iad.ipt_end_date between :dateFrom and :dateTo GROUP BY 1")
	List<StatisticsProjection> getIptCompletionCountForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.ipt_stop_date ),'MONTH') as name ,count(distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  = :facilityId and b.is_active =true\n" +
			"and b.is_delete =false and iad.ipt_stop_date is not null and iad.ipt_stop_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getIptStoppedOrOptedOutCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.ipt_stop_date ),'MONTH') as name ,count(distinct b.id ) as value from soch.beneficiary b \n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true\n" +
			"and b.is_delete =false and iad.ipt_stop_date is not null and iad.ipt_stop_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getIptStoppedOrOptedOutCountForMonths(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(iad.ipt_stop_date,'MM/dd/yyyy') AS name ,count(distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true\n" +
			"and b.is_delete =false and iad.ipt_stop_date is not null and iad.ipt_stop_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getIptStoppedOrOptedOutForDays(@Param("facilityId") Long facilityId,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.att_start_date ),'MONTH') as name ,count( distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  = :facilityId and b.is_active =true\n" +
			"and b.is_delete =false and iad.att_start_date is not null\n" +
			"and iad.att_start_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1")
	List<StatisticsProjection> getAttInitiationCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.att_start_date ),'MONTH') as name ,count( distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  = :facilityId and b.is_active =true\n" +
			"and b.is_delete =false and iad.att_start_date is not null\n" +
			"and iad.att_start_date between :dateFrom AND :dateTo GROUP BY 1 ")
	List<StatisticsProjection> getAttInitiationCountForMonths(@Param("facilityId") Long facilityId,
															  @Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(iad.att_start_date,'MM/dd/yyyy') AS name ,count( distinct b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"where bfm.facility_id  = :facilityId and b.is_active =true\n" +
			"and b.is_delete =false and iad.att_start_date is not null\n" +
			"and iad.att_start_date between :dateFrom AND :dateTo GROUP BY 1")
	List<StatisticsProjection> getAttInitiationCountForDays(@Param("facilityId") Long facilityId,
															@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',abcd.entry_date),'MONTH') AS name, count(b.id) as value from soch.beneficiary b \n" +
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id\n" +
			"inner join soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id \n" +
			"inner join soch.art_beneficiary_clinical_details abcd on abcd.beneficiary_id = b.id\n" +
			"where bfm.facility_id = :facilityId and ab.is_active = true and abcd.regimen_id =:regimenFilter \n" +
			"GROUP BY 1")
	List<StatisticsProjection> getBeneficiaryRegimenBreakupCountDetailsForRegimen(
			@Param("facilityId") Long facilityId, @Param("regimenFilter") Integer regimenFilter);

	@Query(nativeQuery = true, value = "select name from soch.master_art_beneficiary_status where id =:statusId")
	String getStatusName(@Param("statusId") int statusId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.tb_diagnosis),'MONTH') as name ,count(b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"inner join soch.master_tb_result tr on tr.id = iad.tb_diagnosis_id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true and b.is_delete =false\n" +
			"and  tr.id =:tbType and iad.tb_diagnosis >= date_trunc('month', now())- interval '11 month'\n" +
			"group by 1 ")
	List<StatisticsProjection> getTBCount(@Param("facilityId") Long facilityId, @Param("tbType") int tbType);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',iad.tb_diagnosis),'MONTH') as name ,count(b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"inner join soch.master_tb_result tr on tr.id = iad.tb_diagnosis_id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true and b.is_delete =false\n" +
			"and  tr.id =:tbType and iad.tb_diagnosis between :dateFrom AND :dateTo\n" +
			"group by 1 ")
	List<StatisticsProjection> getTBCountForMonths(@Param("facilityId") Long facilityId, @Param("tbType") int tbType,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true, value = "select TO_CHAR(iad.tb_diagnosis,'MM/dd/yyyy') as name ,count(b.id ) as value from soch.beneficiary b\n" +
			"inner join  soch.beneficiary_facility_mapping bfm on bfm.beneficiary_id = b.id\n" +
			"inner join soch.art_beneficiary_ipt_att_details iad on iad.beneficiary_id  = b.id\n" +
			"inner join soch.master_tb_result tr on tr.id = iad.tb_diagnosis_id\n" +
			"where bfm.facility_id  =:facilityId and b.is_active =true and b.is_delete =false\n" +
			"and  tr.id =:tbType and iad.tb_diagnosis between :dateFrom AND :dateTo\n" +
			"group by 1 ")
	List<StatisticsProjection> getTBCountForDays(@Param("facilityId") Long facilityId, @Param("tbType") int tbType,
			@Param("dateFrom") Timestamp dateFrom, @Param("dateTo") Timestamp dateTo);

	@Query(nativeQuery = true , value = " select p.product_short_code from soch.product p where p.id =:productId")
	String getproductName(@Param("productId") int productId);

	@Query(nativeQuery = true, value = "select id as value, name from soch.master_art_beneficiary_status where name  in('ART Preparedness Counselling','On-ART', 'On-ART-MIS', 'On-ART-LFU', 'On-ART-Died')")
	List<StatisticsProjection> getBeneficiaryStatusMaster();

	@Query(nativeQuery = true, value = "select id as value, regimen_name as name from soch.regimen r where id in(:regimenFilter)")
	List<StatisticsProjection> getRegimenFilter(@Param("regimenFilter") List<Integer> regimenFilter);

	@Query(nativeQuery = true, value = "select\n" +
			"\tp.product_short_code as name,\n" +
			"\tfas.product_id as value\n" +
			"from\n" +
			"\t(\n" +
			"\tselect\n" +
			"\t\tproduct_id, facility_id, git,damaged_quantity,\n" +
			"\t\tcase\n" +
			"\t\t\twhen date(batch_expiry_date) < date(now()) then 0\n" +
			"\t\t\telse available_quantity\n" +
			"\t\tend as available_quantity,\n" +
			"\t\tcase\n" +
			"\t\t\twhen date(batch_expiry_date) < date(now()) then available_quantity\n" +
			"\t\t\telse 0\n" +
			"\t\tend as expired_quantity\n" +
			"\tfrom\n" +
			"\t\tsoch.facility_aggregate_stock\n" +
			"\twhere\n" +
			"\t\tfacility_id = :facilityId) as fas\n" +
			"join soch.product as p on\n" +
			"\tp.id = fas.product_id\n" +
			"group by\n" +
			"\tfas.product_id,\n" +
			"\tfas.facility_id,\n" +
			"\tp.product_name,\n" +
			"\tp.product_image,p.product_short_code\n" +
			"having\n" +
			"\tfas.facility_id = :facilityId")
	List<StatisticsProjection> getProductMaster(@Param("facilityId") long facilityId);

	@Query(nativeQuery = true, value = "select\n" +
			"\tp.product_short_code as name,\n" +
			"\tfas.product_id as value\n" +
			"from\n" +
			"\t(\n" +
			"\tselect\n" +
			"\t\tproduct_id, facility_id, git,damaged_quantity,\n" +
			"\t\tcase\n" +
			"\t\t\twhen date(batch_expiry_date) < date(now()) then 0\n" +
			"\t\t\telse available_quantity\n" +
			"\t\tend as available_quantity,\n" +
			"\t\tcase\n" +
			"\t\t\twhen date(batch_expiry_date) < date(now()) then available_quantity\n" +
			"\t\t\telse 0\n" +
			"\t\tend as expired_quantity\n" +
			"\tfrom\n" +
			"\t\tsoch.facility_aggregate_stock\n" +
			"\twhere\n" +
			"\t\tfacility_id = :facilityId) as fas\n" +
			"join soch.product as p on\n" +
			"\tp.id = fas.product_id\n" +
			"group by\n" +
			"\tfas.product_id,\n" +
			"\tfas.facility_id,\n" +
			"\tp.product_name,\n" +
			"\tp.product_image,p.product_short_code\n" +
			"having\n" +
			"\tfas.facility_id = :facilityId limit 6")
	List<StatisticsProjection> getDispensationDrugCountFilter(@Param("facilityId") long facilityId);
	@Query(nativeQuery = true, value = "select distinct on(r.id) r.id as value,r.regimen_name as name\n" +
			"from soch.regimen r \n" +
			"left join soch.regimen_constituent rc on r.id = rc.regimen_id and rc.is_delete =false  \n" +
			"left join soch.product p on rc.product_id =p.id  and p.is_delete =false and p.is_active = true \n" +
			"left join soch.product_uom_master pum on p.uom_id =pum.id and pum.is_delete = false and pum.is_active = true \n" +
			"left join soch.master_data ap on r.adult_ped =ap.id and ap.is_delete =false \n" +
			"left join soch.master_data li on r.line =li.id and li.is_delete =false \n" +
			"where r.is_delete = false \n" +
			"group by r.id,ap.id,li.id order by r.id asc limit 5")
	List<StatisticsProjection> getDefaultRegimenFilter();

	@Query(nativeQuery = true, value = "select f.name as name , f.id as value from soch.beneficiary b \r\n" + 
			"inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id \r\n" + 
			"inner join soch.beneficiary_referral br on br.beneficiary_id  = ab.beneficiary_id \r\n" + 
			"inner join soch.facility f on br.refered_from  = f.id and br.refered_to =:facilityId \r\n" + 
			"inner join soch.facility_type ft on ft.id  = f.facility_type_id \r\n" + 
			"where ft.id =11 and ab.is_active = true and ab.is_delete=false group by f.name ,f.id ")
	List<StatisticsProjection> getAllFacilityReferredFromICTC(@Param("facilityId") long facilityId);

	@Query(nativeQuery = true , value = "select rf.id as value,rf.name as name from soch.master_risk_factor rf ")
	List<StatisticsProjection> getMasterRiskFactor();

	@Query(nativeQuery = true , value = "select ep.id as value , ep.name as name from soch.master_entry_point ep ")
	List<StatisticsProjection> getMasterEntryPoint();

	@Query(nativeQuery = true , value = "select mo.id as value ,mo.name as name from soch.master_occupation mo ")
	List<StatisticsProjection> getOccupation();

	@Query(nativeQuery = true , value = "select mel.id as value , mel.name as name from soch.master_education_level mel ")
	List<StatisticsProjection> getEducation();

	@Query(nativeQuery = true , value = "select mi.id as value , mi.name as name  from soch.master_monthly_income mi ")
	List<StatisticsProjection> getSalary();

	@Query(nativeQuery = true , value = "select id as value, name from soch.master_tb_type where is_delete = false")
	List<StatisticsProjection> getTbType();

	@Query(nativeQuery = true, value = "select\n" +
			"\tp.product_name as name,\n" +
			"\tfas.product_id as value\n" +
			"from\n" +
			"\t(\n" +
			"\tselect\n" +
			"\t\tproduct_id, facility_id, git,damaged_quantity,\n" +
			"\t\tcase\n" +
			"\t\t\twhen date(batch_expiry_date) < date(now()) then 0\n" +
			"\t\t\telse available_quantity\n" +
			"\t\tend as available_quantity,\n" +
			"\t\tcase\n" +
			"\t\t\twhen date(batch_expiry_date) < date(now()) then available_quantity\n" +
			"\t\t\telse 0\n" +
			"\t\tend as expired_quantity\n" +
			"\tfrom\n" +
			"\t\tsoch.facility_aggregate_stock\n" +
			"\twhere\n" +
			"\t\tfacility_id = :facilityId) as fas\n" +
			"join soch.product as p on\n" +
			"\tp.id = fas.product_id\n" +
			"group by\n" +
			"\tfas.product_id,\n" +
			"\tfas.facility_id,\n" +
			"\tp.product_name,\n" +
			"\tp.product_image	" +
			"having\n" +
			"\tfas.facility_id = :facilityId")
	List<StatisticsProjection> getProductNameMaster(@Param("facilityId") long facilityId);
}
