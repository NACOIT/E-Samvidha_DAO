package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtResourceDirectoryEntity;

@Repository
public interface ArtResourceDirectoryRepository extends JpaRepository<ArtResourceDirectoryEntity, Long> {

}
