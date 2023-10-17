package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.ArtDispensation;
import gov.naco.soch.entity.ArtPep;
import gov.naco.soch.entity.ArtPepDispensation;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.entity.FacilityReceipt;
import gov.naco.soch.entity.GoodsRequest;
import gov.naco.soch.entity.LabTestSample;
import gov.naco.soch.entity.LabTestSampleBatch;
import gov.naco.soch.entity.LinkedFacilityBeneficiary;
import gov.naco.soch.entity.ProductDosage;
import gov.naco.soch.entity.Receipt;
import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.projection.ContractListProjection;
import gov.naco.soch.projection.DispatchHistorySearchProjection;
import gov.naco.soch.projection.FacilityAggregateStockProjection;
import gov.naco.soch.projection.FacilityListColumnProjection;
import gov.naco.soch.projection.FacilityListProjection;
import gov.naco.soch.projection.IndentListSearchprojection;
import gov.naco.soch.projection.ProductSearchProjection;
import gov.naco.soch.projection.StockAdjustHistorySearchProjection;
import gov.naco.soch.projection.TIDispensationExpectedList;
import gov.naco.soch.projection.UnregisteredSourceReceiptHistoryProjection;

public interface CustomRepository {

	List<Object[]> getObjectList(String listQuery);

	List<Object[]> userAdvanceSearch(String searchQuery, Map<String, String> searchValue, Long currentUserId,
			Long currentFacilityId, Pageable pageable);

	int userActualCount(String actualCountQuery, Map<String, String> searchValue, Long currentUserId,
			Long currentFacilityId);

	int actualCount(String actualCountQuery);

	List<TIDispensationExpectedList> findBeneficiaryList(String searchQuery, Pageable page);

	List<TIDispensationExpectedList> findBeneficiaryList(String searchQuery);

	long findCountBeneficiaryList(String searchQuery);

	List<TiOstBeneficiary> findBeneficiaryListForSearch(String searchQuery);

	List<Facility> facilitySearch(String searchQuery, Pageable pageable);
	
	List<FacilityListColumnProjection> facilityCommonSearch(String searchQuery, Pageable pageable);

	List<ProductSearchProjection> findProductsByAdvanceSearch(String searchQuery, Map<String, String> searchValue);

	List<Object[]> findLacListByAdvanceSearch(String searchQuery,Pageable pageable);
	
	List<LinkedFacilityBeneficiary> findLacBenListByAdvanceSearch(String searchQuery,Pageable pageable);

	List<Object[]> regimenAdvanceSearch(String searchQuery, Map<String, String> searchValue);

	List<Object[]> divisionAdvanceSearch(String searchQuery, Map<String, String> searchValue);

	List<Object[]> roleAdvanceSearch(String searchQuery, Map<String, String> searchValue);

	List<Object[]> findIctcreferralsByAdvanceSearchs(String searchQuery,Pageable pageable);

	List<ArtDispensation> dispensationAdvanceSerach(String searchQuery);

	List<ArtPepDispensation> pepDispensationAdvanceSearch(String searchQuery);

	List<LabTestSampleBatch> getReceiveSamplesListByAdvanceSearch(String searchQuery);

	List<FacilityAggregateStockProjection> findUsingSearchValue(String searchQuery);

	List<GoodsRequest> findGoodsRequestBySearchValue(String searchQuery,Pageable pageable);

	List<FacilityDispatch> findBysearchValue(String searchQuery, Pageable pageable);

	List<LabTestSample> getRecordResultsListByAdvanceSearch(String searchQuery);

	List<ArtBeneficiaryDueList> artBeneficiaryDueListAdvanceSearch(String searchQuery);

	List<ArtBeneficiaryQueue> artBeneficiaryQueueAdvanceSearch(String searchQuery);

	List<IndentListSearchprojection> findIndentBySearchValue(String searchQuery, Pageable pageable);

	List<ContractListProjection> findContractBySearchValue(String searchQuery, Pageable paging);

	List<FacilityReceipt> findFacilityReceiptBySearchValue(String searchQuery);

	List<ProductDosage> findProductDosage(String searchQuery);
	
	List<FacilityDispatch> findFacilityDispatchBySearchValue(String searchQuery);

	List<DispatchHistorySearchProjection> findDispatchBySearchValue(String searchQuery, Pageable paging);

	List<FacilityReceipt> findReceiptHistoryBySearchValue(String searchQuery);

	List<Receipt> findReceiptHistoryBySearchQuery(String searchQuery);

	List<UnregisteredSourceReceiptHistoryProjection> findUnregisteredSourceHistoryBySearchQuery(String searchQuery,
			Pageable paging);

	List<GoodsRequest> findGoodsRequestForSacsBySearchValue(String searchQuery);

	List<DispatchHistorySearchProjection> findDispatchHistoryBySearchValue(String searchQuery, Pageable paging);

	List<Object[]> productDosageAdvanceSearch(String searchQuery, Map<String, String> searchValue);

	List<StockAdjustHistorySearchProjection> findStockAdjustHistory(String searchQuery, Pageable paging);

	List<Object[]> beneficiaryAdvanceSearch(String searchQuery, MultiValueMap<String, String> searchValueMap,
			Pageable pageable, Long facilityId, Long categoryId);

	int beneficiaryResultCount(String searchQuery, MultiValueMap<String, String> searchValueMap, Pageable pageable,
			Long facilityId, Long categoryId);
	
	Integer findCount(String searchQuery);
	
	Long findReceiptHistoryCount(String countQuery);
	
	Long findDispatchSearchCount(String countQuery);
	
	Long findUnregisteredSourceHistoryCountBySearchQuery(String countQuery);

	List<FacilityDispatch> findFacilityDispatchHistoryBySearch(String searchQuery,Pageable pageable);
	
	int lacTotalCount(String searchQuery, Pageable pageable);
	
	List<ArtPep> artBeneficiaryPepAdvanceSearch(String searchQuery);
	
	List<Object[]> dsrcBeneficiaryAdvanceSearch(String searchQuery, MultiValueMap<String, String> searchValueMap,
			Pageable pageable, Long facilityId, Long categoryId);


	int dsrcBeneficiaryResultCount(String searchQuery, MultiValueMap<String, String> searchValueMap, Pageable pageable,
			Long facilityId, Long categoryId);
	
	List<Object[]> dsrcBeneficiaryInwardRefAdvSrch(String searchQuery, MultiValueMap<String, String> searchValueMap,Pageable pageable, Long facilityId);


	int dsrcBeneficiaryInwardRefResultCount(String searchQuery, MultiValueMap<String, String> searchValueMap, Pageable pageable,Long facilityId);
	
	List<Object[]> getdsrcOngoingTreatmentAdvSrch(String searchQuery, MultiValueMap<String, String> searchValueMap,Pageable pageable, Long facilityId);

    int getdsrcOngoingTreatmentAdvSrchCount(String searchQuery, MultiValueMap<String, String> searchValueMap,Pageable pageable, Long facilityId);

	List<Object[]> dsrcBeneficiaryInwardRefList(String searchQuery, Long facilityId, Pageable pageable);

	int dsrcBeneficiaryInwardRefListCount(String searchQuery, Long facilityId, Pageable pageable);
	
	List<Object[]> dsrcBeneficiaryInwardRefBasicSrch(String searchQuery, Long facilityId, Pageable pageable,
			String searchParam);

	int dsrcBeneficiaryInwardRefBasicSrchCount(String searchQuery, Long facilityId, Pageable pageable, String searchParam);
	
	List<Object[]> getDsrcDueListResult(String string, Pageable pageable, Long facilityId, LocalDate lcledd);

	int getDsrcDueListResultCount(String string, Pageable pageable, Long facilityId, LocalDate lcledd);
	
	List<Object[]> getDsrcDueListBasicSrchResult(String string, Pageable pageable, Long facilityId, LocalDate lcledd,
			String searchParams, String searchText);
	
	int getDsrcDueListBasicSrchResultCount(String string, Pageable pageable, Long facilityId, LocalDate lcledd,
			String searchParams, String searchText);


	List<Object[]> getdsrcCompletedTreatmentAdvSrch(String searchQuery, MultiValueMap<String, String> searchValueMap,Pageable pageable, Long facilityId);

    int getdsrcCompletedTreatmentAdvSrchCount(String searchQuery, MultiValueMap<String, String> searchValueMap,Pageable pageable, Long facilityId);

	List<Object[]> getAllViralLoadPreviouDispatchedSamplesByAdvanceSearch(String searchQuery,Pageable pageable);
	
	List<Object[]> hiv2LabsTestResultAdvanceSearch(String string, MultiValueMap<String, String> paramsMap,
			Pageable pageable, Long facilityId);
	
	List<Object[]> artBeneficiaryQueueListAdvanceSearch(String searchQuery, Pageable pageable);
	
	int queueListTotalCount(String searchQuery, Pageable pageable);

	int hiv2LabsTestResultCount(String string, MultiValueMap<String, String> paramsMap, Pageable pageable, Long facilityId);

	List<Object[]> findPrisonByAdvanceSearch(String searchQuery, Pageable pageable , Integer facilityId);
	
	int findPrisonCountByAdvanceSearch(String searchQuery, Pageable pageable,Integer facilityId);

}
