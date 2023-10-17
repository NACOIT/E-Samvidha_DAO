package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterPlaceOfArt;

@Repository
public interface MasterPlaceOfArtRepository extends JpaRepository<MasterPlaceOfArt, Long> {

	List<MasterPlaceOfArt> findByIsDelete(Boolean isDelete);

}