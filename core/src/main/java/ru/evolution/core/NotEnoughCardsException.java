package ru.evolution.core;

public class NotEnoughCardsException extends Exception {
	public NotEnoughCardsException() {
		super("It is not enough cards.");
	}
}
