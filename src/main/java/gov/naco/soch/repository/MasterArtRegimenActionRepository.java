package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterArtRegimenAction;

@Repository
public interface MasterArtRegimenActionRepository extends JpaRepository<MasterArtRegimenAction, Long> {

}
