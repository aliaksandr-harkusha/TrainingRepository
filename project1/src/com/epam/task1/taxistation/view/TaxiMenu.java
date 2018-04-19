package com.epam.task1.taxistation.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.epam.task1.taxistation.model.TaxiStation;

public class TaxiMenu {
	
	private TaxiStation taxiStation;

	public TaxiMenu(TaxiStation taxiStation) {
		this.taxiStation = taxiStation;
		printMenu();
	}
	
	//Отображение меню
	public void printMenu() {
		while (true) {
			System.out.println("Приветствуем вас в нашем таксопарке, \nвыберете один из следующих вариантов:" );
			System.out.println("1 -- Сгенерировать новый ряд таксомоторов");
			System.out.println("2 -- Посчитать стоимость автопарка");
			System.out.println("3 -- Отсортировать автомобили по расходу топлива");
			System.out.println("4 -- Получить автомобиль со скоростью из диапазона");
			System.out.println("0 -- Выход");
			switch (doCommand()) {
			case 1: 
				taxiStation.generateCabs();
				break;
			case 2: 
				taxiStation.showPrice();
				break;
			case 3: 
				taxiStation.sortCabs();
				break;
			case 4:
				taxiStation.showCabWithSpeed();
				break;
			case 0: return;
			default: 
				System.out.println("Пожалуйста, повторите попытку.");
				break;
			}
		}
	}
	
	//Считываем номер команды для меню
	public int doCommand() {
		int input = -1;
		try {;
			InputStreamReader iS = new InputStreamReader(System.in);
			BufferedReader bR = new BufferedReader(iS);
			input = Integer.parseInt(bR.readLine());
			if (input == 0) {
				bR.close();
				iS.close();
			}
			return input;
		} catch(NumberFormatException nfE) {
			System.out.println("Вы не ввели число.");
		} catch (IOException ioE) {
			System.out.println("Ошибка ввода.");
		}
		return 42;
	}

	
	public TaxiStation getTaxiStation() {
		return taxiStation;
	}

	public void setTaxiStation(TaxiStation taxiStation) {
		this.taxiStation = taxiStation;
	}
	
}
