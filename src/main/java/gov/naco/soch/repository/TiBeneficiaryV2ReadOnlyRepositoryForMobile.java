package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.entity.TiBeneficiaryV2ReadOnly;
import gov.naco.soch.projection.TiBeneficiaryProjection;
import gov.naco.soch.projection.TiBeneficiaryProjectionForMobile;

public interface TiBeneficiaryV2ReadOnlyRepositoryForMobile
		extends JpaRepository<TiBeneficiaryV2ReadOnly, Long>, JpaSpecificationExecutor<TiBeneficiaryV2ReadOnly> {
	@Override
	@EntityGraph(value = "tiBeneficiaryV2ReadOnlyGraph")
	Page<TiBeneficiaryV2ReadOnly> findAll(Specification<TiBeneficiaryV2ReadOnly> spec, Pageable pageable);

	String query = " select tiben.id as id,ben.id as beneficiaryId,ben.date_of_birth as dateOfBirth,ben.uid as uid,ben.first_name as firstname, ben.mobile_number as mobile, ben.last_name as lastname,tiben.ti_code as tiCode,\r\n"
			+ "    tm.typology_id as typologyId,tm.typology_name as typologyName, bg.name as gender,cs.name as masterClientStatus , \r\n"
			+ "	 tiben.date_of_reg as dateOfReg,tiben.facility_id as facilityId,bfm.id as bfmId,bfm.beneficiary_id as bfmBenId,bfm.facility_id as bfmFacilityId,fac.facility_type_id as bfmFacilityTypeId, \r\n"
			+ "    msc.id as statusId,msc.name as status from soch.ti_beneficiary tiben left outer join soch.beneficiary ben on tiben.beneficiary_id=ben.id \r\n"
			+ "    left outer join soch.beneficiary_facility_mapping bfm on ben.id=bfm.beneficiary_id \r\n"
			+ "   and (bfm.is_active=true) left outer join soch.facility fac on bfm.facility_id=fac.id\r\n"
			+ "   left outer join soch.master_client_status_ticore msc on tiben.status_id=msc.id \r\n"
			+ "   left outer join soch.typology_master tm on tm.typology_id = tiben.master_hrg_primary_id\r\n"
			+ "   left outer join soch.master_gender bg on ben.gender_id = bg.id \r\n"
			+ "   left outer join soch.master_client_status cs on ben.client_status_id = cs.id \r\n"
			+ "   where fac.id=:facilityId and tiben.orw_code = :orwCode and tiben.is_deleted=:isDeleted and ben.ti_benf_search_str ilike :searchString order by tiben.id desc";

	String count = " select count(*) from soch.ti_beneficiary tiben left outer join soch.beneficiary ben on tiben.beneficiary_id=ben.id \r\n"
			+ "   left outer join soch.beneficiary_facility_mapping bfm on ben.id=bfm.beneficiary_id \r\n"
			+ "   and (bfm.is_active=true) left outer join soch.facility fac on bfm.facility_id=fac.id\r\n"
			+ "   left outer join soch.master_client_status_ticore msc on tiben.status_id=msc.id \r\n"
			+ "   left outer join soch.typology_master tm on tm.typology_id = tiben.master_hrg_primary_id\r\n"
			+ "   left outer join soch.master_gender bg on ben.gender_id = bg.id \r\n"
			+ "   where fac.id=:facilityId and tiben.is_deleted=:isDeleted and ben.ti_benf_search_str ilike :searchString ";

	@Query(nativeQuery = true, value = query, countQuery = count)
	Page<TiBeneficiaryProjectionForMobile> findTiBeneficiaryByBasicSearchWithTsVector(@Param("facilityId") Long facilityId,
			@Param("isDeleted") Boolean isDeleted, @Param("orwCode") String orwCode, @Param("searchString") String searchString, Pageable pageable);

}
