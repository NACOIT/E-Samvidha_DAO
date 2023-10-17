package gov.naco.soch.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.projection.TestDetailsAdheranceProjection;
import gov.naco.soch.projection.TestDetailsGraphBodyProjection;

public interface TestDetailsGraphRepository extends CrudRepository<Beneficiary, Long>{
	
	@Query(nativeQuery = true, value = "select ROW_NUMBER () OVER (ORDER BY lts.modified_time desc) as resultId,mrt.result_type as resultType, lts.result_value as resultValue ,lts.modified_time as resultDate  from  soch.lab_test_sample lts " + 
			"	 inner join soch.facility f on f.id = lts.sample_collected_facility_id " + 
			"	 inner join soch.test t on t.id = lts.test_id " + 
			"	 inner join master_result_type mrt on mrt.id  = lts.result_type_id " + 
			"	 where t.id = 2 and lts.beneficiary_id =:beneficiaryId " + 
			"	 and f.id = :facilityId and lts.is_delete=false limit 6 ")
	List<TestDetailsGraphBodyProjection> getVLTestCountDetails(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select ROW_NUMBER () OVER (ORDER BY lts.modified_time desc) as resultId, lts.result_value as resultValue ,lts.modified_time as resultDate  from  soch.lab_test_sample lts "
			+ "			 inner join soch.facility f on f.id = lts.sample_collected_facility_id\r\n"
			+ "			 inner join soch.test t on t.id = lts.test_id  \r\n"
			+ "			 where t.id = 1 and lts.beneficiary_id = :beneficiaryId\r\n"
			+ "		 	 and f.id = :facilityId and lts.is_delete=false limit 6")
	List<TestDetailsGraphBodyProjection> getCDFourTestCountDetails(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select ROW_NUMBER () OVER (ORDER BY ad.dispense_date desc) as resultId, coalesce(adi.adherence_to_art,0) as adherancePercentage, ad.dispense_date as dispensationdate "+
			"  from art_beneficiary ab inner join beneficiary b on ab.beneficiary_id  = b.id "+
			"  inner join art_dispensation ad on ab.beneficiary_id  = ad.beneficiary_id  "+
			"  inner join art_dispensation_item adi on adi.art_dispensation_id  = ad.id "+
			"  where ab.beneficiary_id =:beneficiaryId order by ad.dispense_date desc limit 6")
	List<TestDetailsAdheranceProjection> getAdherenceCountDetails(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true , value = "select ab.art_start_date from soch.art_beneficiary  ab where ab.facility_id =:facilityId and ab.beneficiary_id =:beneficiaryId")
	Date getStartDate(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId);

	
	@Query(nativeQuery = true, value = "select lts.modified_time from  soch.lab_test_sample lts " + 
			"	 inner join soch.facility f on f.id = lts.sample_collected_facility_id " + 
			"	 inner join soch.test t on t.id = lts.test_id " + 
			"	 inner join master_result_type mrt on mrt.id  = lts.result_type_id " + 
			"	 where t.id = 2 and lts.beneficiary_id =:beneficiaryId " + 
			"	 and f.id = :facilityId and lts.is_delete=false  ORDER BY  lts.modified_time DESC limit 2 ")
	List<Date> getDates(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select ROW_NUMBER () OVER (ORDER BY lts.modified_time desc) as resultId,mrt.result_type as resultType, lts.result_value as resultValue ,lts.modified_time as resultDate  from  soch.lab_test_sample lts " + 
			"	 inner join soch.facility f on f.id = lts.sample_collected_facility_id " + 
			"	 inner join soch.test t on t.id = lts.test_id " + 
			"	 inner join master_result_type mrt on mrt.id  = lts.result_type_id " + 
			"	 where t.id = 2 and lts.beneficiary_id =:beneficiaryId " + 
			"	 and f.id = :facilityId and lts.is_delete=false and  lts.modified_time =:dateVal ")
	List<TestDetailsGraphBodyProjection> getCurrentVlCount(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId, @Param("dateVal") Date dateVal);

}
