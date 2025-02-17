package com.tka.controller;

import java.util.List;

import com.tka.dao.Dao;
import com.tka.entity.Candidate;
import com.tka.service.Service;

public class ECIController {

	Service service = new Service();

	public void addCandidate(Candidate candidate) {

		System.out.println("DEBUG: Candidate added: " + candidate.getC_name()); // Debugging

		service.addCandidate(candidate); // Calling the DAO layer to add candidate
	}

	public List<Candidate> getAllCandidates() {

		return service.getAllCandidates();
	}

	public void updateCandidate(int updatedid, String newc_name, String newpartyname, String newassembly,
			String newstate, String newgender, int newage) {
		Candidate updatedCandidate = new Candidate(updatedid, newc_name, newpartyname, newassembly, newstate, newgender,
				newage);
		boolean updated = service.updateCandidate(updatedCandidate);
		if (updated) {
			System.out.println("Candidate updated successfully.");
		} else {
			System.out.println("Candidate update failed.");
		}
	}

	public void deleteCandidate(int id) {
		service.deleteCandidate(id);
	}

	public List<Candidate> getAllCandidatesbyfemale() {

		return service.getAllCandidates();
	}

}
