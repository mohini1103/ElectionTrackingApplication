package com.tka.client;

import java.util.List;
import java.util.Scanner;

import com.tka.controller.ECIController;
import com.tka.entity.Candidate;

public class ECIClient {

	public static void main(String[] args) {

		ECIController eciController = new ECIController();
		List<Candidate> allCandidates = eciController.getAllCandidates();

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\nElection App - Candidate Tracking System");
			System.out.println("1. Add Candidate");
			System.out.println("2. Display All Candidates");
			System.out.println("3. Update Candidate");
			System.out.println("4. Delete Candidate");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter Candidate ID:");
				int id = sc.nextInt();
				sc.nextLine(); // consume newline character after reading int
				System.out.println("Enter Candidate Name:");
				String c_name = sc.nextLine();
				System.out.println("Enter Candidate Party Name:");
				String partyname = sc.nextLine();
				System.out.println("Enter Assembly of Candidate:");
				String assembly = sc.nextLine();
				System.out.println("Enter State of Candidate:");
				String state = sc.nextLine();
				System.out.println("Enter Gender of Candidate:");
				String gender = sc.nextLine();
				System.out.println("Enter Age of Candidate:");
				int age = sc.nextInt();

				Candidate candidate = new Candidate(id, c_name, partyname, assembly, state, gender, age);
				// Pass the Candidate object to the controller to add it
				eciController.addCandidate(candidate);
				break;

			case 2:
				List<Candidate> candidates = eciController.getAllCandidates();
				if (candidates.isEmpty()) {
					System.out.println("No candidates found.");
				} else {
					System.out.println(
							"--------------------------------------------------------------------------------------------------------------------------");

					// Print table header
					System.out.printf("%-10s  %-30s  %-20s %-20s %-15s %-10s %-5s%n", "ID", "Name", "Party",
							"Assembly", "State", "Gender", "Age");
					System.out.println(
							"--------------------------------------------------------------------------------------------------------------------------");

					// Print each candidate's information in a row
					for (Candidate c : candidates) {
						System.out.printf("%-10d %-30s %-20s %-20s %-15s %-10s %-5d%n", c.getId(), c.getC_name(),
								c.getPartyname(), c.getAssembly(), c.getState(), c.getGender(), c.getAge());

						System.out.println(
								"--------------------------------------------------------------------------------------------");

					}
				}
				break;

			case 3:
				System.out.println("Enter Candidate ID to update:");
				int updatedid = sc.nextInt();
				sc.nextLine(); // consume newline
				System.out.println("Enter New Candidate Name:");
				String newc_name = sc.nextLine();
				System.out.println("Enter New Candidate Party Name:");
				String newpartyname = sc.nextLine();
				System.out.println("Enter New Assembly of Candidate:");
				String newassembly = sc.nextLine();
				System.out.println("Enter New State of Candidate:");
				String newstate = sc.nextLine();
				System.out.println("Enter New Gender of Candidate:");
				String newgender = sc.nextLine();
				System.out.println("Enter New Age of Candidate:");
				int newage = sc.nextInt();

				eciController.updateCandidate(updatedid, newc_name, newpartyname, newassembly, newstate, newgender,
						newage);
				break;

			case 4:
				System.out.println("Enter Candidate ID to Delete:");
				int deleteId = sc.nextInt();
				eciController.deleteCandidate(deleteId);
				break;

			case 5:
				// Exit the program
				System.out.println("Exiting the system. Goodbye!");
				sc.close();
				return;

			default:
				System.out.println("Invalid Choice. Please select a valid option.");
			}
		}
	}
}
