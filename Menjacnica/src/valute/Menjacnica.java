package valute;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import valute.Kursevi;
import valute.Valuta;
import interfejs.InterfejsMenjacnica;

public class Menjacnica implements InterfejsMenjacnica {
		private LinkedList<Valuta> valute = new LinkedList<Valuta>();

	public LinkedList<Valuta> getValute() {
			return valute;
		}

		public void setValute(LinkedList<Valuta> valute) {
			this.valute = valute;
		}

	@Override
	public void dodajKurs(GregorianCalendar datum, double kupovni, double srednji, double prodajni, String naziv, String skraceniNaziv) {
		Kursevi k = new Kursevi();
		k.setDatum(datum);
		k.setKupovni(kupovni);
		k.setProdajni(prodajni);
		k.setSrednji(srednji);
		for (int i = 0; i < valute.size(); i++) {
			if(valute.get(i).getNaziv().equals(naziv))
				valute.get(i).setKurs(k);
			else {
				Valuta v = new Valuta();
				v.setKurs(k);
				v.setNaziv(naziv);
				v.setSkraceniNaziv(skraceniNaziv);
				valute.add(v);
			}
		}
		
	}

	@Override
	public void obrisiKurs(String skraceniNaziv, GregorianCalendar datum) {
		for (int i = 0; i < valute.size(); i++) {
			for (int j = 0; j < valute.get(i).getKurs().size(); j++) {
				
			int dan = valute.get(i).getKurs().get(j).getDatum().DAY_OF_MONTH;
			int mesec = valute.get(i).getKurs().get(j).getDatum().MONTH;
			int godina = valute.get(i).getKurs().get(j).getDatum().YEAR;
			
			if(valute.get(i).getSkraceniNaziv().equals(skraceniNaziv) && datum.DAY_OF_MONTH == dan && datum.MONTH == mesec && datum.YEAR == godina)
				valute.remove(i);
			
				}
			}
		}

	@Override
	public Kursevi vratiKursNaDan(String skraceniNaziv, GregorianCalendar datum) {
		Kursevi k = new Kursevi();
		for (int i = 0; i < valute.size(); i++) {
			for (int j = 0; j < valute.get(i).getKurs().size(); j++) {
				
			int dan = valute.get(i).getKurs().get(j).getDatum().DAY_OF_MONTH;
			int mesec = valute.get(i).getKurs().get(j).getDatum().MONTH;
			int godina = valute.get(i).getKurs().get(j).getDatum().YEAR;
			
			if(valute.get(i).getSkraceniNaziv().equals(skraceniNaziv) && datum.DAY_OF_MONTH == dan && datum.MONTH == mesec && datum.YEAR == godina)
				 k = valute.get(i).getKurs().get(j);
			return k;
			
				}
			
			}
		return null;
	}

}
