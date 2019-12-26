package com.capgemini.jdbc.dao;

import java.io.FileReader;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.jdbc.bean.UserBean;

public class UserDAOImpl implements UserDAO {

	FileReader reader;
	Properties prop;
	UserBean user;

	public UserDAOImpl() {
		try {
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<UserBean> getAllUser() {
		List<UserBean> list = new ArrayList<UserBean>();
		try (Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = con.createStatement();
				ResultSet rst = stmt.executeQuery(prop.getProperty("query1"))) {
			while (rst.next()) {
				user = new UserBean();
				user.setUserid(rst.getInt(1));
				user.setUsername(rst.getString(2));
				user.setEmail(rst.getString(3));
				user.setPassword(rst.getString(4));
				list.add(user);
			}
			return list;
		} catch (Exception e) {

		}
		return null;
	}

	public UserBean userLogin(String username, String password) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("query2"))) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rst = pstmt.executeQuery();

			while (rst.next()) {
				user = new UserBean();
				user.setUserid(rst.getInt(1));
				user.setUsername(rst.getString(2));
				user.setEmail(rst.getString(3));
				user.setPassword(rst.getString(4));
				return user;
			}
		} catch (Exception e) {

		}
		return null;
	}

	public boolean updateUser(int userid, String password, String email) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("updateQuery"))) {
			pstmt.setString(1, email);
			pstmt.setInt(2, userid);
			pstmt.setString(3, password);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {

		}
		return false;
	}

	public boolean insertUser(UserBean user) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
		
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("insertQuery"))) {

			pstmt.setInt(1, user.getUserid());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());

			int count = pstmt.executeUpdate();

			if (count > 0)
				return true;
		} catch (Exception e) {

		}

		return false;
	}

	public boolean deleteUser(int userid, String password) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("deleteQuery"))) {
			pstmt.setInt(1, userid);
			pstmt.setString(2, password);

			int count = pstmt.executeUpdate();
			if (count > 0)
				return true;
		} catch (Exception e) {

		}
		return false;
	}
}
