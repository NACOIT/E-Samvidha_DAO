package gov.naco.soch.constructordto;

import java.math.BigInteger;

public class InventoryDto {

	private BigInteger currentQuantityCondom;
	private BigInteger monthsCondom;
	private BigInteger currentQuantityHivKit;
	private BigInteger monthsOfHivKitStock;
	private BigInteger currentQuantitySyringe;
	private BigInteger monthsOfSyringeStock;
	
	public BigInteger getCurrentQuantityCondom() {
		return currentQuantityCondom;
	}
	public void setCurrentQuantityCondom(BigInteger currentQuantityCondom) {
		this.currentQuantityCondom = currentQuantityCondom;
	}
	public BigInteger getMonthsCondom() {
		return monthsCondom;
	}
	public void setMonthsCondom(BigInteger monthsCondom) {
		this.monthsCondom = monthsCondom;
	}
	public BigInteger getCurrentQuantityHivKit() {
		return currentQuantityHivKit;
	}
	public void setCurrentQuantityHivKit(BigInteger currentQuantityHivKit) {
		this.currentQuantityHivKit = currentQuantityHivKit;
	}
	public BigInteger getMonthsOfHivKitStock() {
		return monthsOfHivKitStock;
	}
	public void setMonthsOfHivKitStock(BigInteger monthsOfHivKitStock) {
		this.monthsOfHivKitStock = monthsOfHivKitStock;
	}
	public BigInteger getCurrentQuantitySyringe() {
		return currentQuantitySyringe;
	}
	public void setCurrentQuantitySyringe(BigInteger currentQuantitySyringe) {
		this.currentQuantitySyringe = currentQuantitySyringe;
	}
	public BigInteger getMonthsOfSyringeStock() {
		return monthsOfSyringeStock;
	}
	public void setMonthsOfSyringeStock(BigInteger monthsOfSyringeStock) {
		this.monthsOfSyringeStock = monthsOfSyringeStock;
	}

}
