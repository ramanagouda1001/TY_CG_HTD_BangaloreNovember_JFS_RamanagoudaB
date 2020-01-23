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

import com.capgemini.forestmanagement.bean.Land;
import com.capgemini.forestmanagement.exception.ForestManagementException;

public class LandDAOImpl implements LandDAO {

	FileReader reader;
	Properties prop;
	Land user;

	public LandDAOImpl() {
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
	public boolean addLand(Land land) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("landinsert"))) {
			boolean status = false;
			pstmt.setInt(1, land.getNumber());
			pstmt.setString(2, land.getName());
			pstmt.setInt(3, land.getArea());
			pstmt.setString(4, land.getRegion());
			pstmt.setString(5, land.getForestType());

			int count = pstmt.executeUpdate();

			if (count > 0)
				status = true;
			return status;

		} catch (Exception e) {
			throw new ForestManagementException("Already Present");
		}
	}

	@Override
	public boolean deleteLand(int LandNumber) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("landdelete"))) {
			pstmt.setInt(1, LandNumber);

			boolean status = false;
			int count = pstmt.executeUpdate();
			if (count > 0)
				status = true;

			return status;
		} catch (Exception e) {
			throw new ForestManagementException("Not Present");
		}

	}

	@Override
	public List<Land> displayLand() {
		List<Land> list = new ArrayList<Land>();
		try (Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				Statement stmt = con.createStatement();
				ResultSet rst = stmt.executeQuery(prop.getProperty("landdisplay"))) {
			while (rst.next()) {
				user = new Land();
				user.setNumber(rst.getInt(1));
				user.setName(rst.getString(2));
				user.setArea(rst.getInt(3));
				user.setRegion(rst.getString(4));
				user.setForestType(rst.getString(5));
				list.add(user);
			}
			return list;
		} catch (Exception e) {

		}
		return null;
	}

}
