package logic;

import java.util.List;

import org.apache.commons.collections15.Transformer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;

public class ManagmentRoutes {

	ArrayList<City> cities; 
	ArrayList<Route> routes; 
	Graph<City, Route> graph = null;
	private FileCity fileCity;
	private FileRoute fileRoute;

	private static final String FILES_PATH = "C:\\Users\\ASUS\\workspace\\ProyectoProga\\resources\\files\\";
	
	public ManagmentRoutes(Comparator<City> compId) {
		graph= new SparseMultigraph<>();
		cities = new ArrayList<>();
		fileCity = new FileCity();
		fileCity.setPathFile(FILES_PATH);
		fileCity.setNameFile("city.json");
		fileCity.openFile();
		
		//
		routes = new ArrayList<>();
		fileRoute = new FileRoute();
		fileRoute.setPathFile(FILES_PATH);
		fileRoute.setNameFile("j.json");
		fileRoute.openFile();
		
		
		try {
			pullJsonR();
			pullJson();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	//Metodo que ace una busqueda en el grafo
	
	public List<Route> findRoute(int destiny, Graph graph) {
		DijkstraShortestPath<City, Route> shorthPath = new DijkstraShortestPath<>(graph);
		List<Route> list = shorthPath.getPath(getCities().get(2), getCities().get(destiny - 1));
		return list;
	}
	
	
	//metodo que hace una busqueda en el grafo y se obtiene el de menor recorrido
	
	public	List<Route> showPrice(int destiny, Graph graph){
		
		Transformer<Route, Double> transformer =new Transformer<Route, Double>(){

			@Override
			public Double transform(Route i) {
				
				return i.getMileage();
			}
			
		};
		
		DijkstraShortestPath<City, Route> distance = new DijkstraShortestPath<>(graph,transformer);
		List<Route> list = distance.getPath(getCities().get(2), getCities().get(destiny - 1));
		return list;
	}
	
	//metodo que hace una busqueda en el grafo y se obtiene el de menor costo
	
	public List<Route> showCost(int destiny,Graph graph){
		Transformer<Route, Double> transformer =new Transformer<Route, Double>(){

			@Override
			public Double transform(Route i) {
				
				return i.getCost();
			}
		};
		DijkstraShortestPath<City, Route> cost = new DijkstraShortestPath<>(graph,transformer);
		List<Route> list = cost.getPath(getCities().get(2), getCities().get(destiny - 1));
		return list;
	}
	
	//metodo que hace una busqueda en el grafo y se obtiene el de menor numero de paradas
	
	public List<Route> showStops(int destiny, Graph graph){
		Transformer<Route, Double> transformer =new Transformer<Route, Double>(){

			@Override
			public Double transform(Route i) {
				
				return (double) i.getNumberOfStops();
			}
		};
		DijkstraShortestPath<City, Route> cost = new DijkstraShortestPath<>(graph,transformer);
		List<Route> list = cost.getPath(getCities().get(2), getCities().get(destiny - 1));
		return list;
	}
	

	public City findCity(String name) throws NoSuchFieldException, IOException {
		for (City city : cities) {
			if (city.getNameCity().equals(name)) {
				return city;
			}
		}
		return null;
	}

	public boolean addCity(String name) throws NoSuchFieldException, IOException {
		if (findCity(name) == null) {
			cities.add(new City(name));
			return true;
		}
		return false;
	}

	public void PushJson() throws IOException, NoSuchFieldException {
		fileCity = new FileCity();
		fileCity.setPathFile(FILES_PATH);
		fileCity.setNameFile("city.json");
		fileCity.openFile();
		fileCity.pushJson(cities);
	}

	public void pullJson() throws IOException, NoSuchFieldException {
		fileCity = new FileCity();
		fileCity.setPathFile(FILES_PATH);
		fileCity.setNameFile("city.json");
		fileCity.openFile();
		cities = fileCity.pullJson();
	}

	public Route findRoutes(String routte) {
		for (Route route : routes) {
			if (route.getRoute().equals(routte)) {
				return route;
			}
		}
		return null;
	}

	public boolean addRoutes(String nameCompany,String route, int numberOfStops, String duration, double mileage, double cost) {
		if (findRoutes(route) == null) {
			routes.add(new Route(nameCompany, route, numberOfStops, duration, mileage, cost));
			return true;
		}
		return false;
	}

	public void pushJsonR() throws IOException {
		fileRoute = new FileRoute();
		fileRoute.setPathFile(FILES_PATH);
		fileRoute.setNameFile("j.json");
		fileRoute.openFile();
		fileRoute.pushJson(routes);
	}

	public void pullJsonR() throws IOException {
		fileRoute = new FileRoute();
		fileRoute.setPathFile(FILES_PATH);
		fileRoute.setNameFile("j.json");
		fileRoute.openFile();
		routes = fileRoute.pullJson();
	}

	public ArrayList<City> getCities() {
		return cities;
	}

	public ArrayList<Route> getRoutes() {
		return (ArrayList<Route>) routes.clone();
	}

	public Graph<City, Route> getGraph() {
		return graph;
	}

	public void setGraph(Graph<City, Route> graph) {
		this.graph = graph;
	}
}
