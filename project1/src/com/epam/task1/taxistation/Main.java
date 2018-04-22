//добавь этот класс еще в пакет какой-нибудь controller или runner 
package com.epam.task1.taxistation;

import com.epam.task1.taxistation.model.TaxiStation;
import com.epam.task1.taxistation.view.TaxiMenu;

//Класс тоже лучше переименовать в Controller либо Runner либо Starter
public class Main {

	public static void main(String[] args) {

		TaxiMenu menu = new TaxiMenu(new TaxiStation());
		
	}

}
