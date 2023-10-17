package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.GoodsRequest;

@Repository
public interface GoodsRequestRepository extends JpaRepository<GoodsRequest, Long>, CustomRepository {

	@Query(value = "select g.* from soch.goods_request g join soch.product p on(g.product_id=p.id)\r\n"
			+ "join soch.indent_request_status_master rm on(g.goods_request_status_id=rm.id)\r\n"
			+ "where g.facility_id = :facilityId", nativeQuery = true)
	Page<GoodsRequest> findByFacilityId(@Param("facilityId") Long facilityId, Pageable paging);

	@Query(value = "select g.* from soch.goods_request g join soch.product p on(p.id=g.product_id)\r\n"
			+ "join soch.facility f on(g.facility_id=f.id) where g.sacs_id = :sacsId", nativeQuery = true)
	Page<GoodsRequest> findBySacsId(@Param("sacsId") Long sacsId, Pageable paging);

	@Query(value = "select g.* from soch.goods_request g where g.product_id = :productId and g.facility_id = :facilityId order by g.id desc", nativeQuery = true)
	List<GoodsRequest> findByProductIdAndFacilityId(@Param("productId") Long productId,
			@Param("facilityId") Long facilityId);

	@Query(value = "select g.* from soch.goods_request g join soch.facility f on(g.facility_id=f.id)\r\n"
			+ "join soch.address a on(f.address_id=a.id) join soch.district d on(a.district_id=d.id)\r\n"
			+ "join soch.product p on(g.product_id=p.id) where g.sacs_id = :sacsId and\r\n"
			+ "(LOWER(g.indent_num) like :searchValue% OR LOWER(f.name) like :searchValue%\r\n"
			+ "OR LOWER(d.name) like :searchValue% OR LOWER(p.product_name) like :searchValue% )", nativeQuery = true)
	Page<GoodsRequest> findBySacsIdUsingNormalSearch(@Param("sacsId") Long sacsId,
			@Param("searchValue") String searchValue, Pageable paging);
	
	@Query(value = "select g.* from soch.goods_request g join soch.product p on(g.product_id=p.id) where g.facility_id = :facilityId \r\n"
			+ "and (LOWER(g.indent_num) like :searchValue% OR LOWER(p.product_name) like :searchValue%)", nativeQuery = true)
	Page<GoodsRequest> findByFacilityIdByNormalSearch(@Param("facilityId") Long facilityId,@Param("searchValue")String searchvalue, Pageable paging);

}
