package gov.naco.soch.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.SacsCmssWarehouseMapping;

@Repository
public interface SacsCmssWarehouseMappingRepository extends JpaRepository<SacsCmssWarehouseMapping, Long> {

	List<SacsCmssWarehouseMapping> findAllByFacility_Id(Long sacsId);

	List<SacsCmssWarehouseMapping> findAllByCmssWarehouse_Id(@Valid Long warehouseId);

}
