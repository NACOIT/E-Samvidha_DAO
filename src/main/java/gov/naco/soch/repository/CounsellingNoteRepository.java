package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.CounsellingNote;
import gov.naco.soch.projection.ArtCounsellingNoteProjection;
import gov.naco.soch.projection.CounsellingSectionProjection;

@Repository
public interface CounsellingNoteRepository extends JpaRepository<CounsellingNote, Long>, JpaSpecificationExecutor<CounsellingNote> {


	@Query(value = "select * from soch.master_art_counselling_note", nativeQuery = true)
	List<CounsellingNote> findAllData();

	@Query(nativeQuery = true, value = " select macn.id as artCounsellingNoteId, macn.counselling_note as counsellingNoteName, " + 
			" mact.counselling_type as counsellingTypeName, macn.counselling_section as counsellingSection, " + 
			" macn.first_visit_only as firstVisitOnly, macn.is_active as counsellingNoteIsActive " + 
			" from soch.master_art_counselling_note as macn  " + 
			" left join soch.master_art_counselling_type as mact on mact.id = macn.counselling_type_id  " + 
			" where (lower(macn.counselling_note)) like %:searchText% and macn.is_delete =false ",
	countQuery=" select count(macn.id) from soch.master_art_counselling_note as macn  " + 
			" left join soch.master_art_counselling_type as mact on mact.id = macn.counselling_type_id  " + 
			" where (lower(macn.counselling_note)) like %:searchText% and macn.is_delete =false ")
	Page<ArtCounsellingNoteProjection> findArtCounsellingNoteListWithSearch(@Param("searchText") String searchText, Pageable pageable);

	@Query(nativeQuery = true, value = " select count(macn.id) from soch.master_art_counselling_note as macn  " + 
			" left join soch.master_art_counselling_type as mact on mact.id = macn.counselling_type_id  " + 
			" where (lower(macn.counselling_note)) like %:searchText% and macn.is_delete =false ")
	Long getActualCountWithSearch(@Param("searchText") String searchText);

	@Query(nativeQuery = true, value = " select macn.id as artCounsellingNoteId, macn.counselling_note as counsellingNoteName, " + 
			" mact.counselling_type as counsellingTypeName, macn.counselling_section as counsellingSection, " + 
			" macn.first_visit_only as firstVisitOnly, macn.is_active as counsellingNoteIsActive " + 
			" from soch.master_art_counselling_note as macn  " + 
			" left join soch.master_art_counselling_type as mact on mact.id = macn.counselling_type_id  " + 
			" where macn.is_delete =false ",
	countQuery=" select count(macn.id) from soch.master_art_counselling_note as macn  " + 
			" left join soch.master_art_counselling_type as mact on mact.id = macn.counselling_type_id  " + 
			" where macn.is_delete =false ")
	Page<ArtCounsellingNoteProjection> findArtCounsellingNoteListWithoutSearch(Pageable pageable);

	@Query(nativeQuery = true, value = " select count(macn.id) from soch.master_art_counselling_note as macn  " + 
			" left join soch.master_art_counselling_type as mact on mact.id = macn.counselling_type_id  " + 
			" where macn.is_delete =false " )
	Long getActualCountWithoutSearch();

	/**
	 * @return
	 */
	@Query(value = "select distinct (counselling_section ) as counsellingSection from soch.master_art_counselling_note as macn", nativeQuery = true)
	List<CounsellingSectionProjection> getAllArtCounsellingSection();

	/**
	 * @param counsellingsection
	 * @return
	 */
	@Query(value = "select count(id ) from soch.master_art_counselling_note as macn where lower(macn.counselling_section) =:counsellingsection", nativeQuery = true)
	Integer getCounsellingNoteCount(@Param("counsellingsection") String counsellingsection);

	@Modifying
	@Query(nativeQuery = true, value = " update soch.master_art_counselling_note set is_active =false , is_delete =true where id=:counsellingNoteId")
	void deleteCounsellingNote(@Param("counsellingNoteId") Long counsellingNoteId);

	@Query(nativeQuery = true, value = " select count(id) from soch.master_art_counselling_note where lower(counselling_section) =:counsellingSection and " + 
			" lower(counselling_note) =:counsellingNoteName and is_active =true and is_delete =false ")
	Integer existsByOtherName(@Param("counsellingSection") String counsellingSection, @Param("counsellingNoteName") String counsellingNoteName); 

}
