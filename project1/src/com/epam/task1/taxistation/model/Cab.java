package com.epam.task1.taxistation.model;

public class Cab implements Comparable<Cab> {
	//кодировка - пиши лучше на английском
	//óíèêàëüíûé íîìåð äëÿ êàæäîãî êýáà
	private static int counter = 0;
	
	private int speed;
	private int fuelConsumption;
	private int price;
	private int identifier;
	
	public Cab() {
		this.speed = 0;
		this.fuelConsumption = 0;
		this.price = 0;
		counter++;
		this.identifier = counter;
	}
	
	public Cab(int speed, int fuelConsumption, int price) {
		this.speed = speed;
		this.fuelConsumption = fuelConsumption;
		this.price = price;
		counter++;
		this.identifier = counter;
	}
	
	@Override
	public int compareTo(Cab o) {
		//после if else  - не забывай ставить {} - даже если в теле условия будет одна строчка
		//чтобы не было ошибок в будущем если этот блок изменится 
		//это касается также циклов - пройдись по проекту и проставь {}
		if (this.fuelConsumption < o.fuelConsumption)
			return -1;
		else if (this.fuelConsumption > o.fuelConsumption)
			return 1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		//опять кодировка
		StringBuilder s = new StringBuilder("Òàêñè ¹" + identifier);
		if (speed>0)
			s.append(" ñî ñêîðîñòüþ " + speed); 
		else
			s.append(" ñ íåèçâåñòíîé ñêîðîñòüþ");
		
		if (fuelConsumption>0)
			s.append(" è ïîòðåáëåíèåì òîïëèâà " + fuelConsumption); 
		else
			s.append(" è íåèçâåñòíûì ðàñõîäîì òîïëèâà,");
		
		if (price>0)
			s.append(", ñòîèìîñòüþ " + price); 
		else
			s.append(", ïî íåâåäîìî öåíå.");
		
		return s.toString();
	}

	//get/set - методы следуют в классе обычно после конструкторов
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(int fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
