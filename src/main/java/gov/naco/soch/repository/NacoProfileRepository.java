package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.NacoProfileEntity;


@Repository
public interface NacoProfileRepository extends JpaRepository<NacoProfileEntity, Long>{

	List<NacoProfileEntity> findByIsDelete(Boolean false1);

}
