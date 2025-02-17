package com.tka.entity;

public class Candidate {

	private int id;
	private String c_name;
	private String partyname;
	private String assembly;
	private String state;
	private String gender;
	private int age;

	public Candidate() {
		super();
	}

	public Candidate(int id, String c_name, String partyname, String assembly, 
			String state, String gender, int age) {
		super();
		this.id = id;
		this.c_name = c_name;
		this.partyname = partyname;
		this.assembly = assembly;
		this.state = state;
		this.gender = gender;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getPartyname() {
		return partyname;
	}

	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}

	public String getAssembly() {
		return assembly;
	}

	public void setAssembly(String assembly) {
		this.assembly = assembly;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", c_name=" + c_name + ", partyname=" + partyname + ", assembly=" + assembly
				+ ", state=" + state + ", gender=" + gender + ", age=" + age + "]";

	}
}
