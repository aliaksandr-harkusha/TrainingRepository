package com.epam.task1.taxistation.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//класс очень перегружен бизнес-логикой, хотя находится в пакете model
//нужно создать класс - типа TaxiService в пакете service - куда вынести все методы бизнесс-логики
//а здесь нужно оставить только коллекцию cabList, get/set - методы, можно также addTaxi() и getSize() 
public class TaxiStation {

	private List<Cab> cabList = new ArrayList<Cab>();
	
	//Ñãåíåðèðîâàòü ñëó÷àíûé ñïèñîê èç 5-10 àâòî ñî ñëó÷àéíûìè ïàðàìåòðàìè è âûâåñòè èõ íà ýêðàí
	public void generateCabs() {
		if (!cabList.isEmpty()) cabList.clear();
		int n = (int) Math.random()*6 + 5;
		for (int i = 0; i < n; i++) {
			int price = ((int) (Math.random()*600 + 500)) * (i+1);
			int speed = ((int) (Math.random()*16 + 15)) * (i+1);
			int fuel = ((int) (Math.random()*16 + 5));
			cabList.add(new Cab(speed, fuel, price));
		}
		showCabs();
	}
	
	//âûâîä ñïèñêà êýáîâ íà ýêðàí
	public void showCabs() {
		if (cabList.isEmpty()) {
			System.out.println("Ïðèìå÷àíèå: Âàø ñïèñîê àâòî ïóñò");
			return;
		}
		for (Cab cab: cabList) {
			System.out.println(cab);
		}
	}
	
	//îòñîðòèðîâàòü êýáû ïî ðàñõîäó òîïëèâà
	public void sortCabs(){
		if (cabList.isEmpty()) {
			System.out.println("Ïðèìå÷àíèå: Âàø ñïèñîê àâòî ïóñò");
			return;
		}
		Collections.sort(cabList);
		showCabs();
	}
	
	//âûâåñòè íà ýêðàí îáùóþ ñòîèìîñòü òàêñîïàðêà
	public int showPrice() {
		if (cabList.isEmpty()) {
			System.out.println("Ïðèìå÷àíèå: Âàø ñïèñîê àâòî ïóñò");
		}
		int sum = 0;
		for (Cab cab: cabList) {
			sum += cab.getPrice();
		}
		System.out.println("Ñòîèìîñòü àâòîïàðêà: " + sum);
		return sum;
	}
	
	//ïîèñê êýáà ïî äèàïàçîíó, ââîäèìîìîó ñ êîíñîëè
	public Cab showCabWithSpeed() {
		if (cabList.isEmpty()) {
			System.out.println("Ïðèìå÷àíèå: Âàø ñïèñîê àâòî ïóñò");
			//плохая практика возвращать null из методов
			//подумай как здесь лучше будет исправить
			return null;
		}
		String input;
		int a = -1, b = -1;
		System.out.println("Ïîæàëóéñòà, ââåäèòå äèàïàçîí èç äâóõ ÷èñåë ÷åðåç ïðîáåë");
		// вместо этих всех ридеров лучше использовать класс Scanner(System.in)
		//а потом просто scanner.next()
		//ридеры лучше использовать при работе с файлами
		InputStreamReader iS = new InputStreamReader(System.in);
		BufferedReader bR = new BufferedReader(iS);
		try {
			input = bR.readLine();
			//зря усложнил логику лучше 2 раза запроси ввод
			a = Integer.parseInt(input.split(" ")[0]);
			b = Integer.parseInt(input.split(" ")[1]);
			if (a>b) {
				a+=b;
				b = a - b;
				a-=b;
			}
			for (Cab cab: cabList) {
				if (cab.getSpeed()>=a && cab.getSpeed()<=b) {
					System.out.println("Èñêîìûé âàìè àâòîìîáèëü " + cab);
					return cab;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Âû íå ââåëè äâà ÷èñëà");
		} catch (NumberFormatException e) {
			System.out.println("Âû íå ââåëè äâà ÷èñëà");
		} catch (IOException e) {
			System.out.println("Îøèáêà ââîäà äàííûõ");
		}
		System.out.println("Àâòî ñ òàêìèì ïàðàìåòðàìè íå ñóùåñòâóåò â òàêñîïàðêå");
		return null;	
	}
	
	public List<Cab> getCabList() {
		return cabList;
	}

	public void setCabList(List<Cab> cabList) {
		this.cabList = cabList;
	}
}
