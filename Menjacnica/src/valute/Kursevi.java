package valute;

import java.util.GregorianCalendar;

public class Kursevi {
	private GregorianCalendar datum;
	private double kupovni;
	private double srednji;
	private double prodajni;
	
	
	public double getKupovni() {
		return kupovni;
	}
	public void setKupovni(double kupovni) {
		if(kupovni < 0)
			throw new RuntimeException("Kupovni kurs ne moze biti manji od nule.");
		this.kupovni = kupovni;
	}
	public double getSrednji() {
		return srednji;
	}
	public void setSrednji(double srednji) {
		if(srednji < 0)
			throw new RuntimeException("Srednji kurs ne moze biti manji od nule.");
		this.srednji = srednji;
	}
	public double getProdajni() {
		return prodajni;
	}
	public void setProdajni(double prodajni) {
		if(prodajni < 0)
			throw new RuntimeException("Prodajni kurs ne moze biti manji od nule.");
		this.prodajni = prodajni;
	}
	public GregorianCalendar getDatum() {
		return datum;
	}
	public void setDatum(GregorianCalendar datum) {
		GregorianCalendar danas = new GregorianCalendar();
		int dan = danas.DAY_OF_MONTH;
		int mesec = danas.MONTH;
		int godina = danas.YEAR;
		if(datum == null || !(dan == datum.DAY_OF_MONTH && mesec == datum.MONTH && godina == datum.YEAR))
			throw new RuntimeException("Datum nije tacno unet.");
		
		this.datum = datum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		long temp;
		temp = Double.doubleToLongBits(kupovni);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(prodajni);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(srednji);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Kursevi))
			return false;
		Kursevi other = (Kursevi) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (Double.doubleToLongBits(kupovni) != Double.doubleToLongBits(other.kupovni))
			return false;
		if (Double.doubleToLongBits(prodajni) != Double.doubleToLongBits(other.prodajni))
			return false;
		if (Double.doubleToLongBits(srednji) != Double.doubleToLongBits(other.srednji))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Kursevi [datum=" + datum + ", kupovni=" + kupovni + ", srednji=" + srednji + ", prodajni=" + prodajni
				+ "]";
	}
	
	
	
	
}
