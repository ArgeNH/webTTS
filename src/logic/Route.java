
package logic;

/**
 * 
 * @author ARGE NIÑO-GINA PEREZ
 * 
 * Esta clase contiene datos que nos permiten la identificación de la rutas,la cuales contienen nombre de la empresa, ruta (nombre de origen y destino),
 * número de paradas, la ditancia en kmy el valor del pasaje.
 *
 */



public class Route {
	
	/**
	 * Parametros propios de la clase
	 */
	
	public String nameCompany;
	public String route;
	public int numberOfStops;
	public String duration;
	public double mileage;
	public double cost;
	
	/**
	 * Constructor de la clase Route
	 * 
	 * @param nameCompany
	 * @param route
	 * @param numberOfStops
	 * @param duration
	 * @param mileage
	 * @param cost
	 */
	
	public Route(String nameCompany,String route, int numberOfStops, String duration, double mileage, double cost) {
		this.nameCompany=nameCompany;
		this.route = route;
		this.numberOfStops = numberOfStops;
		this.duration = duration;
		this.mileage = mileage;
		this.cost = cost;
	}
	
	
	/**
	 * Metodos get y set
	 */
	
	/**
	 * El método getNameCompany retorna el nombre de la empresa 
	 * @return
	 */

	public String getNameCompany() {
		return nameCompany;
	}

	/**
	 * El método setNamCompany recibe un parametro, el cual es nombre dela companía para poder modificar su valor
	 * @param nameCompany
	 */


	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}


/**
 * 
 * @return
 */

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public int getNumberOfStops() {
		return numberOfStops;
	}

	public void setNumberOfStops(int numberOfStops) {
		this.numberOfStops = numberOfStops;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}




	@Override
	public String toString() {
		return "Route [nameCompany=" + nameCompany + ", route=" + route + ", numberOfStops=" + numberOfStops
				+ ", duration=" + duration + ", mileage=" + mileage + ", cost=" + cost + "]";
	}

	
	    
}
