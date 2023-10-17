package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

	List<Test> findByIsDelete(Boolean isDelete);

	List<Test> findAllByIsDeleteAndIsActiveAndCollectionCenter(Boolean false1, Boolean true1, String collectionCenter);

}
