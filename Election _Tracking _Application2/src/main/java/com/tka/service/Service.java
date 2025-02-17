package com.tka.service;

import java.util.List;

import com.tka.dao.Dao;
import com.tka.entity.Candidate;

public class Service {

	Dao dao = new Dao();

	public void addCandidate(Candidate candidate) {
		dao.addCandidate(candidate); // Calling the DAO layer to add candidate
	}

	public boolean updateCandidate(Candidate candidate) {
		return dao.updateCandidate(candidate);
	}

	public void deleteCandidate(int id) {
		dao.deleteCandidate(id);
	}

	public List<Candidate> getAllCandidates() {

		return dao.getAllCandidates();
	}

}
