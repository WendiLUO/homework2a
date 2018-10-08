package edu.northeastern.ccs.cs5500.homework2a;
import java.util.*;

public class Rank{
	private String name;
	private int pips;

	public Rank(String name, int pips) {
		super();
		this.name = name;
		this.pips = pips;
	}

	public String getName() {
		return name;
	}

	public int getPips() {
		return pips;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Rank)) {
			return false;
		}
		Rank other = (Rank) obj;
		return other.getName() == name && other.pips == pips;
	}

}
