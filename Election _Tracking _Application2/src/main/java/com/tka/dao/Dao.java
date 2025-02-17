package com.tka.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tka.entity.Candidate;

public class Dao {
	String url = "jdbc:mysql://localhost:3306/ecicollection";
	String uname = "root";
	String pwd = "root";

	// Fetch all candidates from the database
	public List<Candidate> getAllCandidates() {
		List<Candidate> candidates = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String sql = "Select * from ecicollection.candidate";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url, uname, pwd);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt(1);
				String c_name = rs.getString(2);
				String partyname = rs.getString(3);
				String assembly = rs.getString(4);
				String state = rs.getString(5);
				String gender = rs.getString(6);
				int age = rs.getInt(7);
				Candidate candidate = new Candidate(id, c_name, partyname, assembly, state, gender, age);
				candidates.add(candidate);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return candidates;
	}

	// Add new candidates
	public void addCandidate(Candidate candidate) {
		String sql = "INSERT INTO candidate(id, c_name, partyname, assembly, state, gender, age)VALUES(?,?,?,?,?,?,?)";

		try {
			Connection connection = DriverManager.getConnection(url, uname, pwd);
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, candidate.getId());
			pstmt.setString(2, candidate.getC_name());
			pstmt.setString(3, candidate.getPartyname());
			pstmt.setString(4, candidate.getAssembly());
			pstmt.setString(5, candidate.getState());
			pstmt.setString(6, candidate.getGender());
			pstmt.setInt(7, candidate.getAge());

			pstmt.executeUpdate(); // execute insert
			System.out.println("Candidate addded successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean updateCandidate(Candidate candidate) {
		String sql = "UPDATE candidate SET c_name=?, partyname=?,assembly=?,state=?,gender=?,age=? WHERE id=?";
		try {
			Connection connection = DriverManager.getConnection(url, uname, pwd);
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, candidate.getC_name());
			pstmt.setString(2, candidate.getPartyname());
			pstmt.setString(3, candidate.getAssembly());
			pstmt.setString(4, candidate.getState());
			pstmt.setString(5, candidate.getGender());
			pstmt.setInt(6, candidate.getAge());
			pstmt.setInt(7, candidate.getId());

			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("Candidate updated successfully");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public void deleteCandidate(int id) {
		String sql = "DELETE From candidate where id=?";
		try {
			Connection connection = DriverManager.getConnection(url, uname, pwd);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.out.println("Candidate deleted successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
