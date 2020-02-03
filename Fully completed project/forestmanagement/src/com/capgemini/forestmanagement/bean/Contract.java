package com.capgemini.forestmanagement.bean;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

@Data
public class Contract implements Serializable {
	private int contract_no;
	private String product_id;
	private String delivery_date;
	private String delivery_day;
	private int quality;
}
