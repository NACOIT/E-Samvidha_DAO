package gov.naco.soch.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.constants.IndicatorConstant;
import gov.naco.soch.constants.QueryConstant;
import gov.naco.soch.constructordto.FacilityPerformanceDto;

@Repository
public class FacilityPerformanceRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public List<FacilityPerformanceDto> findConsolidatedPerfromanceData(String requestType, String sectionId) {
		String sectionQuery = "";
		if (requestType.equalsIgnoreCase(IndicatorConstant.REQUEST_TYPE_INIT)) {
			sectionQuery = QueryConstant.FACILITY_PERFORM_SEC_1;
		} else if (requestType.equalsIgnoreCase(IndicatorConstant.REQUEST_TYPE_CLICK)) {
			switch (sectionId) {
			case "SEC_1":
				sectionQuery = QueryConstant.FACILITY_PERFORM_SEC_1;
				break;
			case "SEC_2":
				sectionQuery = QueryConstant.FACILITY_PERFORM_SEC_2;
				break;
			case "SEC_3":
				sectionQuery = QueryConstant.FACILITY_PERFORM_SEC_3;
				break;
			}

		}
		return jdbcTemplate.query(sectionQuery, new FacilityPerformaneRowMapper());
	}

}

class FacilityPerformaneRowMapper implements RowMapper<FacilityPerformanceDto> {
	@Override
	public FacilityPerformanceDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		FacilityPerformanceDto facilityPerformanceDto = new FacilityPerformanceDto();
		facilityPerformanceDto.setSectionId(rs.getString("sectionid"));
		facilityPerformanceDto.setIndicatorId(rs.getString("indicatorid"));
		facilityPerformanceDto.setMaleCount(rs.getInt("male"));
		facilityPerformanceDto.setFemaleCount(rs.getInt("female"));
		facilityPerformanceDto.setTotalCount(rs.getInt("totalcount"));

		return facilityPerformanceDto;
	}
}
