package gov.naco.soch.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Facility.class)
public abstract class Facility_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<Facility, FacilityProductStock> facilityProductStocks;
	public static volatile SetAttribute<Facility, Dispatch> dispatches1;
	public static volatile SingularAttribute<Facility, LocalDate> validTill;
	public static volatile SingularAttribute<Facility, String> fileName;
	public static volatile SetAttribute<Facility, Dispatch> dispatches3;
	public static volatile SetAttribute<Facility, Dispatch> dispatches2;
	public static volatile SetAttribute<Facility, FacilityStock> facilityStocks;
	public static volatile SetAttribute<Facility, TIStiTreatment> tiStiTreatment;
	public static volatile SetAttribute<Facility, FacilityLinkFacilityMapping> facilityLinkFacilityMapping;
	public static volatile SingularAttribute<Facility, String> artcode;
	public static volatile SetAttribute<Facility, TIBenRVAssessment> tiRVAssessment;
	public static volatile SingularAttribute<Facility, Boolean> lacPlus;
	public static volatile SetAttribute<Facility, ContractProductScheduleSac> contractProductScheduleSacs;
	public static volatile SingularAttribute<Facility, Integer> monthlyActiveTarget;
	public static volatile SingularAttribute<Facility, Division> consigneeDivision;
	public static volatile SingularAttribute<Facility, Boolean> isActive;
	public static volatile SetAttribute<Facility, FacilityStockTracking> facilityStockTrackings;
	public static volatile SingularAttribute<Facility, Boolean> isAccreditation;
	public static volatile SingularAttribute<Facility, Division> division;
	public static volatile SingularAttribute<Facility, Long> bankid;
	public static volatile SingularAttribute<Facility, Long> ngotype;
	public static volatile SetAttribute<Facility, Indent> indents;
	public static volatile SetAttribute<Facility, Dispensation> dispensations;
	public static volatile SetAttribute<Facility, FacilityStockDailyBalance> facilityStockDailyBalances;
	public static volatile SetAttribute<Facility, TIBenCounselling> tiCounselling;
	public static volatile SetAttribute<Facility, FacilityReconciliation> facilityReconciliations;
	public static volatile SingularAttribute<Facility, Long> id;
	public static volatile SingularAttribute<Facility, MasterBloodBankOwnedBy> masterBloodBankOwnedBy;
	public static volatile SetAttribute<Facility, UserMaster> userMasters;
	public static volatile SingularAttribute<Facility, String> facilityMobileNumber;
	public static volatile SetAttribute<Facility, BeneficiaryReferral> beneficiaryReferrals;
	public static volatile SetAttribute<Facility, FacilityDispatchTransportDetails> facilityDispatchTransportDetails;
	public static volatile SingularAttribute<Facility, Boolean> isExternal;
	public static volatile SingularAttribute<Facility, Facility> tiCenter;
	public static volatile SingularAttribute<Facility, Boolean> nablAccredited;
	public static volatile SetAttribute<Facility, TIBenScrDetails> tiScreening;
	public static volatile SetAttribute<Facility, TiOstPrescription> tiOstPrescription;
	public static volatile SingularAttribute<Facility, String> facilityEmailId;
	public static volatile SingularAttribute<Facility, String> tiType;
	public static volatile SingularAttribute<Facility, String> pannumber;
	public static volatile SetAttribute<Facility, FacilityAggregateStock> facilityAggregateStocks;
	public static volatile SingularAttribute<Facility, String> cnano;
	public static volatile SetAttribute<Facility, ArtPepDispensation> artPepDispensations;
	public static volatile SingularAttribute<Facility, String> cBStatus;
	public static volatile SetAttribute<Facility, TypologyFacilityMapping> typologyFacilityMappings;
	public static volatile SetAttribute<Facility, FacilityStockAdjustment> facilityStockAdjustments;
	public static volatile SetAttribute<Facility, TIBeneficiaryExtDetails> tiBeneficiaryExtDetails;
	public static volatile SingularAttribute<Facility, LocalDateTime> workingsince;
	public static volatile SingularAttribute<Facility, String> name;
	public static volatile SingularAttribute<Facility, String> facilityNo;
	public static volatile SingularAttribute<Facility, Long> sacsId;
	public static volatile SingularAttribute<Facility, String> code;
	public static volatile SetAttribute<Facility, FacilityProductStockTran> facilityProductStockTrans;
	public static volatile SingularAttribute<Facility, Float> distance;
	public static volatile SetAttribute<Facility, TIBeneficiary> tiBeneficiary;
	public static volatile SingularAttribute<Facility, Facility> procurementAgent;
	public static volatile SetAttribute<Facility, ArtDispensation> artDispensations;
	public static volatile SingularAttribute<Facility, Long> nodalCentre;
	public static volatile SetAttribute<Facility, MappingLabFacility> mappingLabFacilitys;
	public static volatile SetAttribute<Facility, Contract> contracts;
	public static volatile SingularAttribute<Facility, String> facilityLandlineNumber;
	public static volatile SetAttribute<Facility, BeneficiaryReferral> beneficiaryReferrals_Two;
	public static volatile SetAttribute<Facility, BeneficiaryFacilityMapping> beneficiaryFacilityMappings;
	public static volatile SingularAttribute<Facility, MasterBloodBankType> masterBloodBankType;
	public static volatile SingularAttribute<Facility, Address> address;
	public static volatile SetAttribute<Facility, SupplierStock> supplierStocks;
	public static volatile SingularAttribute<Facility, Long> approvalstatus;
	public static volatile SingularAttribute<Facility, FacilityType> facilityType;
	public static volatile SingularAttribute<Facility, Boolean> isDelete;
	public static volatile SingularAttribute<Facility, Long> stateId;
	public static volatile SingularAttribute<Facility, String> filePath;
	public static volatile SetAttribute<Facility, NgoMember> ngoMember;
	public static volatile SetAttribute<Facility, TIBenChildDetails> tiBenChildDetails;
	public static volatile SingularAttribute<Facility, Boolean> clinicPresent;
	public static volatile SetAttribute<Facility, FacilityStockTransfer> facilityStockTransfers1;
	public static volatile SingularAttribute<Facility, Boolean> isNacoSupported;
	public static volatile SetAttribute<Facility, FacilityStockTransfer> facilityStockTransfers2;
	public static volatile SetAttribute<Facility, ArtBeneficiaryCounsellingNotes> artBeneficiaryCounsellingNotes;
	public static volatile SetAttribute<Facility, TransporterSacsMapping> transporterSacsMappings1;
	public static volatile SetAttribute<Facility, TransporterSacsMapping> transporterSacsMappings2;
	public static volatile SetAttribute<Facility, SatelliteOstParentOstMapping> satelliteOstParentOstMappings;
	public static volatile SetAttribute<Facility, BeneficiaryPrivateTransfers> beneficiaryPrivateTransfers;
	public static volatile SingularAttribute<Facility, MasterTiOstType> ostType;
	public static volatile SingularAttribute<Facility, Long> districtId;
	public static volatile SingularAttribute<Facility, String> nationalId;
	public static volatile SingularAttribute<Facility, Integer> monthlyOstTarget;
	public static volatile SingularAttribute<Facility, Machine> machine;
	public static volatile SingularAttribute<Facility, String> darpannumber;
	public static volatile SetAttribute<Facility, SacsCmssWarehouseMapping> sacsCmssWarehouseMappings;
	public static volatile SingularAttribute<Facility, String> bankaccountno;
	public static volatile SingularAttribute<Facility, MasterLacType> masterLacType;
	public static volatile SingularAttribute<Facility, Facility> facility;
	public static volatile SingularAttribute<Facility, Boolean> isLab;
	public static volatile SingularAttribute<Facility, LocalDateTime> expirationReminderDate;

	public static final String FACILITY_PRODUCT_STOCKS = "facilityProductStocks";
	public static final String DISPATCHES1 = "dispatches1";
	public static final String VALID_TILL = "validTill";
	public static final String FILE_NAME = "fileName";
	public static final String DISPATCHES3 = "dispatches3";
	public static final String DISPATCHES2 = "dispatches2";
	public static final String FACILITY_STOCKS = "facilityStocks";
	public static final String TI_STI_TREATMENT = "tiStiTreatment";
	public static final String FACILITY_LINK_FACILITY_MAPPING = "facilityLinkFacilityMapping";
	public static final String ARTCODE = "artcode";
	public static final String TI_RV_ASSESSMENT = "tiRVAssessment";
	public static final String LAC_PLUS = "lacPlus";
	public static final String CONTRACT_PRODUCT_SCHEDULE_SACS = "contractProductScheduleSacs";
	public static final String MONTHLY_ACTIVE_TARGET = "monthlyActiveTarget";
	public static final String CONSIGNEE_DIVISION = "consigneeDivision";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY_STOCK_TRACKINGS = "facilityStockTrackings";
	public static final String IS_ACCREDITATION = "isAccreditation";
	public static final String DIVISION = "division";
	public static final String BANKID = "bankid";
	public static final String NGOTYPE = "ngotype";
	public static final String INDENTS = "indents";
	public static final String DISPENSATIONS = "dispensations";
	public static final String FACILITY_STOCK_DAILY_BALANCES = "facilityStockDailyBalances";
	public static final String TI_COUNSELLING = "tiCounselling";
	public static final String FACILITY_RECONCILIATIONS = "facilityReconciliations";
	public static final String ID = "id";
	public static final String MASTER_BLOOD_BANK_OWNED_BY = "masterBloodBankOwnedBy";
	public static final String USER_MASTERS = "userMasters";
	public static final String FACILITY_MOBILE_NUMBER = "facilityMobileNumber";
	public static final String BENEFICIARY_REFERRALS = "beneficiaryReferrals";
	public static final String FACILITY_DISPATCH_TRANSPORT_DETAILS = "facilityDispatchTransportDetails";
	public static final String IS_EXTERNAL = "isExternal";
	public static final String TI_CENTER = "tiCenter";
	public static final String NABL_ACCREDITED = "nablAccredited";
	public static final String TI_SCREENING = "tiScreening";
	public static final String TI_OST_PRESCRIPTION = "tiOstPrescription";
	public static final String FACILITY_EMAIL_ID = "facilityEmailId";
	public static final String TI_TYPE = "tiType";
	public static final String PANNUMBER = "pannumber";
	public static final String FACILITY_AGGREGATE_STOCKS = "facilityAggregateStocks";
	public static final String CNANO = "cnano";
	public static final String ART_PEP_DISPENSATIONS = "artPepDispensations";
	public static final String C_BSTATUS = "cBStatus";
	public static final String TYPOLOGY_FACILITY_MAPPINGS = "typologyFacilityMappings";
	public static final String FACILITY_STOCK_ADJUSTMENTS = "facilityStockAdjustments";
	public static final String TI_BENEFICIARY_EXT_DETAILS = "tiBeneficiaryExtDetails";
	public static final String WORKINGSINCE = "workingsince";
	public static final String NAME = "name";
	public static final String FACILITY_NO = "facilityNo";
	public static final String SACS_ID = "sacsId";
	public static final String CODE = "code";
	public static final String FACILITY_PRODUCT_STOCK_TRANS = "facilityProductStockTrans";
	public static final String DISTANCE = "distance";
	public static final String TI_BENEFICIARY = "tiBeneficiary";
	public static final String PROCUREMENT_AGENT = "procurementAgent";
	public static final String ART_DISPENSATIONS = "artDispensations";
	public static final String NODAL_CENTRE = "nodalCentre";
	public static final String MAPPING_LAB_FACILITYS = "mappingLabFacilitys";
	public static final String CONTRACTS = "contracts";
	public static final String FACILITY_LANDLINE_NUMBER = "facilityLandlineNumber";
	public static final String BENEFICIARY_REFERRALS__TWO = "beneficiaryReferrals_Two";
	public static final String BENEFICIARY_FACILITY_MAPPINGS = "beneficiaryFacilityMappings";
	public static final String MASTER_BLOOD_BANK_TYPE = "masterBloodBankType";
	public static final String ADDRESS = "address";
	public static final String SUPPLIER_STOCKS = "supplierStocks";
	public static final String APPROVALSTATUS = "approvalstatus";
	public static final String FACILITY_TYPE = "facilityType";
	public static final String IS_DELETE = "isDelete";
	public static final String STATE_ID = "stateId";
	public static final String FILE_PATH = "filePath";
	public static final String NGO_MEMBER = "ngoMember";
	public static final String TI_BEN_CHILD_DETAILS = "tiBenChildDetails";
	public static final String CLINIC_PRESENT = "clinicPresent";
	public static final String FACILITY_STOCK_TRANSFERS1 = "facilityStockTransfers1";
	public static final String IS_NACO_SUPPORTED = "isNacoSupported";
	public static final String FACILITY_STOCK_TRANSFERS2 = "facilityStockTransfers2";
	public static final String ART_BENEFICIARY_COUNSELLING_NOTES = "artBeneficiaryCounsellingNotes";
	public static final String TRANSPORTER_SACS_MAPPINGS1 = "transporterSacsMappings1";
	public static final String TRANSPORTER_SACS_MAPPINGS2 = "transporterSacsMappings2";
	public static final String SATELLITE_OST_PARENT_OST_MAPPINGS = "satelliteOstParentOstMappings";
	public static final String BENEFICIARY_PRIVATE_TRANSFERS = "beneficiaryPrivateTransfers";
	public static final String OST_TYPE = "ostType";
	public static final String DISTRICT_ID = "districtId";
	public static final String NATIONAL_ID = "nationalId";
	public static final String MONTHLY_OST_TARGET = "monthlyOstTarget";
	public static final String MACHINE = "machine";
	public static final String DARPANNUMBER = "darpannumber";
	public static final String SACS_CMSS_WAREHOUSE_MAPPINGS = "sacsCmssWarehouseMappings";
	public static final String BANKACCOUNTNO = "bankaccountno";
	public static final String MASTER_LAC_TYPE = "masterLacType";
	public static final String FACILITY = "facility";
	public static final String IS_LAB = "isLab";
	public static final String EXPIRATION_REMINDER_DATE = "expirationReminderDate";

}

