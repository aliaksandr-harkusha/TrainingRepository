package com.epam.task1.taxistation.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.epam.task1.taxistation.model.TaxiStation;

//на самом деле этот класс избыточен
//все общение с пользователем через консоль, т.е. то что он вводит или читает, должно идти через main метод или через класс где main метод 
public class TaxiMenu {
	
	private TaxiStation taxiStation;

	public TaxiMenu(TaxiStation taxiStation) {
		this.taxiStation = taxiStation;
		printMenu();
	}
	
	//Îòîáðàæåíèå ìåíþ
	//поэтому printMenu - должно быть где-то в main-методе
	public void printMenu() {
		while (true) {
			System.out.println("Ïðèâåòñòâóåì âàñ â íàøåì òàêñîïàðêå, \nâûáåðåòå îäèí èç ñëåäóþùèõ âàðèàíòîâ:" );
			System.out.println("1 -- Ñãåíåðèðîâàòü íîâûé ðÿä òàêñîìîòîðîâ");
			System.out.println("2 -- Ïîñ÷èòàòü ñòîèìîñòü àâòîïàðêà");
			System.out.println("3 -- Îòñîðòèðîâàòü àâòîìîáèëè ïî ðàñõîäó òîïëèâà");
			System.out.println("4 -- Ïîëó÷èòü àâòîìîáèëü ñî ñêîðîñòüþ èç äèàïàçîíà");
			System.out.println("0 -- Âûõîä");
			switch (doCommand()) {
			//тело case - тоже в {}
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
				System.out.println("Ïîæàëóéñòà, ïîâòîðèòå ïîïûòêó.");
				break;
			}
		}
	}
	
	//Ñ÷èòûâàåì íîìåð êîìàíäû äëÿ ìåíþ
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
			System.out.println("Âû íå ââåëè ÷èñëî.");
		} catch (IOException ioE) {
			System.out.println("Îøèáêà ââîäà.");
		}
		//42 - это анти паттерн magic number
		//попробуй сделать так что-бы из методов был только 1 return
		return 42;
	}

	
	public TaxiStation getTaxiStation() {
		return taxiStation;
	}

	public void setTaxiStation(TaxiStation taxiStation) {
		this.taxiStation = taxiStation;
	}
	
}
