package com.sjunejo.calculator.datastructures;

/**
 * This class contains:
 * var1
 * operation
 * var2
 * @author Sunny
 *
 */
public class Datastore {
	
	int var1;
	int var2;
	int operation;
	
	boolean var1Set;
	boolean operationSet;
	boolean var2Set;
	
	public Datastore(){
		var1Set = false;
		var2Set = false;
		operationSet = false;
	}
	
	void toggleVar2Set(){
		if (operationSet) var2Set = true;
	}
	
	public boolean operationWaiting(){
		// There is an operation if:
		// var1Set = true;
		// var2Set = true;
		if (var2Set) return true; else return false;
	}
	
	/*
	 * 1 = add
	 * 2 = subtract
	 * 3 = multiply 
	 * 4 = divide
	 */
	public int executeOperation(){
		switch (operation){
		case 1: 
			return var1 + var2;
		case 2: 
			return var1 - var2;
		case 3: 
			return var1 * var2;
		case 4: 
			return var1 / var2;
		 default:
			return 0;
		
		}
	}

}
