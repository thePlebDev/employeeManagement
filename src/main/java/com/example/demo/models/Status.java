package com.example.demo.models;

public class Status {
	private final static String processing = "PROCESSING";
	private final static String started = "STARTED";
	private final  static String finished = "FINISHED";
	
	public Status() {}
	
	public static String getProcessing() {
		return processing;
	}
	
	public static String getStarted() {
		return started;
	}
	
	public static String getFinished() {
		return finished;
	}
}
