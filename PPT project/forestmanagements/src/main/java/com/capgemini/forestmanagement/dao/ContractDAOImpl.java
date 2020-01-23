package com.capgemini.forestmanagement.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.forestmanagement.bean.Contract;
import com.capgemini.forestmanagement.exception.ForestManagementException;

public class ContractDAOImpl implements ContractDAO {

	FileReader reader;
	Properties prop;
	Contract user;

	public ContractDAOImpl() {
		try {
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driver"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("hi");
		}
	}

	@Override
	public boolean addContract(Contract bean) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("insertcontract"))) {
			boolean status = true;
			pstmt.setInt(1, bean.getContractNo());
			pstmt.setInt(2, bean.getCustomerId());
			pstmt.setString(3, bean.getProductId());
			pstmt.setInt(4, bean.getTransportId());
			pstmt.setString(5, bean.getDeliveryDate());
			pstmt.setString(6, bean.getDeliveryDay());
			pstmt.setInt(7, bean.getQuality());

			int count = pstmt.executeUpdate();

			if (count > 0)
				status = true;
			return status;
		} catch (Exception e) {
			throw new ForestManagementException("Contract is already Present");
		}
	}

	@Override
	public boolean deleteContact(int contract_no) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("deletecontract"))) {
			pstmt.setInt(1, contract_no);

			boolean status = true;
			int count = pstmt.executeUpdate();
			if (count > 0)
				status = true;
			return status;
		} catch (Exception e) {
			throw new ForestManagementException("Account is already Deleted");
		}
	}

	@Override
	public List<Contract> contractDetail() {
		// TODO Auto-generated method stub

		List<Contract> list = new ArrayList<Contract>();
		try (Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				Statement stmt = con.createStatement();
				ResultSet rst = stmt.executeQuery(prop.getProperty("selectcontract"))) {
			while (rst.next()) {
				user = new Contract();
				user.setContractNo(rst.getInt(1));
				user.setCustomerId(rst.getInt(2));
				user.setProductId(rst.getString(3));
				user.setTransportId(rst.getInt(4));
				user.setDeliveryDate(rst.getString(5));
				user.setDeliveryDay(rst.getString(6));
				user.setQuality(rst.getInt(7));
				list.add(user);
			}
			return list;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public Contract search(int contract_no) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("displaycontract"))) {
			pstmt.setInt(1, contract_no);

			ResultSet rst = pstmt.executeQuery();
			if (rst.next()) {
				user = new Contract();
				user.setContractNo(rst.getInt(1));
				user.setCustomerId(rst.getInt(2));
				user.setProductId(rst.getString(3));
				user.setTransportId(rst.getInt(4));
				user.setDeliveryDate(rst.getString(5));
				user.setDeliveryDay(rst.getString(6));
				user.setQuality(rst.getInt(7));
				return user;
			}
			return user;
		} catch (Exception e) {

		}
		return null;
	}

}
