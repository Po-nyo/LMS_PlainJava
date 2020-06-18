package lms.main;

import java.util.Scanner;

import lms.clearScreen.ClearScreen;
import lms.info.LMSInfoService;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		ClearScreen.clear();
		LMSInfoService lmsInfo = new LMSInfoService();

		lmsInfo.lmsInfo();
		LMSProcessing lmsp = new LMSProcessing();
		lmsp.run();
		sc.close();
	}

}
