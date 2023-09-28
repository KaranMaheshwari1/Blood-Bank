package DonorOperations;

import java.io.PrintWriter;
import java.sql.*;

import DBConnection.connectionSQL;
import DonorGetSt.DonorGtSt;

public class DonorPrp {
	private Connection con;
	private PreparedStatement ps;

	public DonorPrp() {
		con = connectionSQL.GetConnection();
	}

	public String AddNewDnr(DonorGtSt dnr) {
		String check = "Error";

		try {
			ps = con.prepareStatement(
					"insert into Donor(Name,FathersName,Surname,Caste,Email,Password,Currentcity,Nativecity,Mobile,Dob,Bloodgrp,Gender,Ltbd ) value(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, dnr.getName());
			ps.setString(2, dnr.getFathersName());
			ps.setString(3, dnr.getSurname());
			ps.setString(4, dnr.getCaste());
			ps.setString(5, dnr.getEmail());
			ps.setString(6, dnr.getPassword());
			ps.setString(7, dnr.getCurrentcity());
			ps.setString(8, dnr.getNativecity());
			ps.setString(9, dnr.getMobile());
			ps.setString(10, dnr.getDob());
			ps.setString(11, dnr.getBloodgrp());
			ps.setString(12, dnr.getGender());
			ps.setString(13, dnr.getLtbd());
			int count = ps.executeUpdate();
			if (count == 1) {
				check = "success";
			}

		} catch (Exception e) {
			// TODO: handle exception
			check = e.getMessage();
		}

		return check;

	}

	public ResultSet ShowAllDonors() {
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("Select Name,FathersName,Surname,Currentcity,mobile,Bloodgrp from Donor");
			rs = ps.executeQuery();

		} catch (Exception e) {
			rs = null;
		}
		return rs;
	}

	public DonorGtSt LoginCheck(String email, String pwd) {
		DonorGtSt emp = null;
		// select * from employee where email='sahasra@gmail.com' and pwd='1234';
		try {
			ps = con.prepareStatement("Select * from Donor where Email=? and Password=?");
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				emp = new DonorGtSt();
				emp.setName(rs.getString("Name"));
				emp.setFathersName(rs.getString("FathersName"));
				emp.setSurname(rs.getString("Surname"));
				emp.setBloodgrp(rs.getString("Bloodgrp"));
				emp.setEmail(rs.getString("Email"));
				emp.setPassword(rs.getString("Password"));
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return emp;
	}

	public String DeleteDonor(String eno) {
		String chk = "Err";
		try {
			ps = con.prepareStatement("Delete from Donor where Mobile=?");
			ps.setString(1, eno);
			int res = ps.executeUpdate();

			if (res >= 1)
				chk = "Success";

		} catch (Exception ex) {
			chk = ex.getMessage();
		}
		return chk;
	}

	public String EditDonor(String eno) throws Exception {
		ps = con.prepareStatement(
				"update Donor set Name=?,FathersName=?,Surname=?,Caste=?,Email=?,Password=?,Currentcity=?,Nativecity=?,Mobile=?,Dob=?,Bloodgrp=?,Gender=?,Ltbd=?");

		return eno;
	}
}