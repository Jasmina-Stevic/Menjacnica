package interfejs;

import java.util.GregorianCalendar;

import valute.Kursevi;
public interface InterfejsMenjacnica {

	public void dodajKurs(GregorianCalendar datum, double kupovni, double srednji, double prodajni, String naziv,String skraceniNaziv);
	//izmenjen potpis metode, dodati ulazni parametri naziv i skraceniNaziv
	public void obrisiKurs(String skraceniNaziv, GregorianCalendar datum);	
	public Kursevi vratiKursNaDan(String skraceniNaziv, GregorianCalendar datum);
	
}
