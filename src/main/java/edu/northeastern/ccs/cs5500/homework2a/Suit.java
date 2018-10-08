package edu.northeastern.ccs.cs5500.homework2a;
import java.util.*;

public class Suit{
	private String name;
	private char symbol;
	
	public Suit(String name, char symbol) {
		super();
		this.name = name;
		this.symbol = symbol;
		
	}
	public String getName() {
		return name;
	}
	public char getSymbol() {
		return symbol;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Suit)) {
			return false;
		}
		Suit other = (Suit) obj;
		return other.name == name && other.symbol == symbol;
	}
	
}
