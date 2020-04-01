package org.comstudy21.main;
import static org.comstudy21.resource.R.*;

import org.comstudy21.controller.Controller;
public class Maincls {

	public static void main(String[] args) {
		System.out.println(appTitle);
		
		//콘트롤러 호출
		Controller.service();
	}

}
