package logic;
import java.util.Comparator;

public class City {
	
	private String nameCity;	
	public static Comparator<City> compNameCity=new Comparator<City>() {
		@Override
		public int compare(City o1, City o2) {
			
			return o1.getNameCity().compareTo(o2.getNameCity());
		}
	};	
	
	public City(String nameCity) {
		this.nameCity=nameCity;
	}

	public String getNameCity(){
		return nameCity;
	}
	
	public void setNameCity(String nameCity){
		this.nameCity=nameCity;
	}

	@Override
	public String toString() {
		return "City [nameCity=" + nameCity + "]";
	}

}