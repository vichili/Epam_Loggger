package com.epam.constructioncost;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
	private static final Logger LOGGER = LogManager.getLogger(App.class);
	
	public static void main( String[] args )
	{

		Scanner in = new Scanner(System.in);
		PrintStream print = new PrintStream(new FileOutputStream(FileDescriptor.out));
		boolean automatedHome = false;

		print.print("Enter the Total Area of House (in per square feet) = ");
		double totalArea = in.nextDouble();

		print.println("Choose the Standard of the House : ");
		print.println("1. Standard Materials");
		print.println("2. Above Standard Materials");
		print.println("3. High Standard Materials");
		print.println("4. High Standard Materials and Fully Automated Home");
		int option = in.nextInt();

		switch(option) {

		case 1:LOGGER.info("Standard Home Cost is Rs." + standardMaterials(totalArea));
		break;
		
		case 2:LOGGER.info("Above Standard Home Cost is Rs." + aboveStandardMaterials(totalArea));
		break;
		
		case 3:LOGGER.info("High Standard Home Cost is Rs." + highStandardMaterials(totalArea, automatedHome));
		break;
		
		case 4: automatedHome = true;
		LOGGER.info("Automated Home Cost is Rs." + highStandardMaterials(totalArea, automatedHome));
		break;
		
		default: LOGGER.warn("Invalid Choice");
		break;
		}

		print.close();
		in.close();
	}

	public static double standardMaterials(double totalArea) {

		return 1200 * totalArea;
	}

	public static double aboveStandardMaterials(double totalArea) {

		return 1500 * totalArea;
	}

	public static double highStandardMaterials(double totalArea, boolean automatedHome) {

		if(automatedHome)
			return 2500 * totalArea;
		else
			return 1800 * totalArea;
	}

}