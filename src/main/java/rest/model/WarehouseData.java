package rest.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "warehouse")
public class WarehouseData {
	private String warehouseID;
	private String warehouseName;
	private String warehouseAddress;
	private String warehousePostalCode;
	private String warehouseCity;
	private String warehouseCountry;
	private String timestamp;

	private List<Product> productData = new ArrayList<>();

	public WarehouseData() {
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}

	public String getWarehouseID() { return warehouseID; }
	public void setWarehouseID(String warehouseID) { this.warehouseID = warehouseID; }

	public String getWarehouseName() { return warehouseName; }
	public void setWarehouseName(String warehouseName) { this.warehouseName = warehouseName; }

	public String getWarehouseAddress() { return warehouseAddress; }
	public void setWarehouseAddress(String warehouseAddress) { this.warehouseAddress = warehouseAddress; }

	public String getWarehousePostalCode() { return warehousePostalCode; }
	public void setWarehousePostalCode(String warehousePostalCode) { this.warehousePostalCode = warehousePostalCode; }

	public String getWarehouseCity() { return warehouseCity; }
	public void setWarehouseCity(String warehouseCity) { this.warehouseCity = warehouseCity; }

	public String getWarehouseCountry() { return warehouseCountry; }
	public void setWarehouseCountry(String warehouseCountry) { this.warehouseCountry = warehouseCountry; }

	public String getTimestamp() { return timestamp; }
	public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

	public List<Product> getProductData() { return productData; }
	public void setProductData(List<Product> productData) { this.productData = productData; }
	public void addProduct(Product product) { this.productData.add(product); }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format(
				"Warehouse Info: ID = %s, Name = %s, Address = %s, PostalCode = %s, City = %s, Country = %s, Timestamp = %s\n",
				warehouseID,
				warehouseName,
				warehouseAddress,
				warehousePostalCode,
				warehouseCity,
				warehouseCountry,
				timestamp
		));

		if (productData != null && !productData.isEmpty()) {
			sb.append("Products:\n");
			for (Product p : productData) {
				sb.append("  ").append(p.toString()).append("\n");
			}
		} else {
			sb.append("Products: none\n");
		}

		return sb.toString();
	}
}
