package gov.naco.soch.repository;

import gov.naco.soch.entity.TiCounsellingV2SubEntity;
import gov.naco.soch.projection.ArtBeneficiaryListProjection;
import gov.naco.soch.projection.CounsellingProjection;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TiCounsellingV2ReadOnlyRepository extends JpaRepository<TiCounsellingV2SubEntity, Long>, JpaSpecificationExecutor<TiCounsellingV2SubEntity> {
    @EntityGraph("counsellingV2Graph")
    Page<TiCounsellingV2SubEntity> findAll(Specification<TiCounsellingV2SubEntity> spec, Pageable pageable);
    
    
    
    String query =" \r\n" + 
    		"   select tbc.id as id,ben.id as beneficiaryId,ben.date_of_birth as dateOfBirth,ben.uid as uid,ben.first_name as firstname, ben.middle_name as middlename, ben.last_name as lastname,tiben.ti_code as tiCode,tm.typology_id as typologyId,tm.typology_name as typologyName, bg.name as gender,tbc.last_counselling_date\r\n" + 
    		"   as lastCounsellingDate,tbc.next_counselling_date as nextCounsellingDate,msc.id as statusId,msc.name as status from soch.ti_ben_counselling tbc left outer join soch.ti_beneficiary tiben on tbc.beneficiary_id=tiben.id\r\n" + 
    		"   left outer join soch.beneficiary ben on tiben.beneficiary_id=ben.id \r\n" + 
    		"   left outer join soch.beneficiary_facility_mapping bfm on ben.id=bfm.beneficiary_id \r\n" + 
    		"   and (bfm.is_active=true) left outer join soch.facility fac on bfm.facility_id=fac.id\r\n" + 
    		"   left outer join soch.master_client_status_ticore msc on tiben.status_id=msc.id \r\n" + 
    		"   left outer join soch.typology_master tm on tm.typology_id = tiben.master_hrg_primary_id\r\n" + 
    		"   left outer join soch.master_gender bg on ben.gender_id = bg.id \r\n" + 
    		"   where msc.id=:status and fac.id=:facilityId and tbc.is_deleted=false and tbc.next_counselling_date<=:nextCounsellingDate and\r\n" + 
    		"   tbc.next_counselling_date>=:counsellingDate and ben.ti_benf_search_str ilike :searchString order by id desc ";
    
    
    String count ="select count (*) from \r\n" + 
    		"    soch.ti_ben_counselling tbc left outer join soch.ti_beneficiary tiben on tbc.beneficiary_id=tiben.id\r\n" + 
    		"   left outer join soch.beneficiary ben on tiben.beneficiary_id=ben.id \r\n" + 
    		"   left outer join soch.beneficiary_facility_mapping bfm on ben.id=bfm.beneficiary_id \r\n" + 
    		"   and (bfm.is_active=true) left outer join soch.facility fac on bfm.facility_id=fac.id\r\n" + 
    		"   left outer join soch.master_client_status_ticore msc on tiben.status_id=msc.id \r\n" + 
    		"   where msc.id=:status and fac.id=:facilityId and tbc.is_deleted=false and tbc.next_counselling_date<=:nextCounsellingDate and \r\n" + 
    		"   tbc.next_counselling_date>=:counsellingDate and ben.ti_benf_search_str ilike :searchString \r\n" + 
    		"   ";
    
    @Query(nativeQuery = true, value = query,countQuery = count)
	Page<CounsellingProjection> findCounsellingByBasicSearchWithTsVector(@Param("status") Long status,
			@Param("facilityId") Long facilityId, 
			@Param("counsellingDate") LocalDate counsellingDate, 
			@Param("nextCounsellingDate") LocalDate nextCounsellingDate,
			@Param("searchString") String searchString,Pageable pageable);
}
