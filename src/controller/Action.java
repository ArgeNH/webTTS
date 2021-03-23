package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;

import logic.City;
import logic.ManagmentRoutes;
import logic.Route;

/**
 * Servlet implementation class j
 */
@WebServlet("/Action")
public class Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ManagmentRoutes mng;
	Graph<City, Route> graph = null;

	public Action() {
		graph = new SparseMultigraph<>();
		try {
			mng = new ManagmentRoutes(City.compNameCity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 * @throws NoSuchFieldException
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NoSuchFieldException {
		response.setContentType("application/json;charset=UTF-8");
		String opt = request.getParameter("option");

		switch (opt) {
		case "0":
			findRoute(request, response);
			break;
		case "1":
			load(request, response);
			break;
		case "2":
			showDistance(request, response);
			break;
		case "3": showCost(request, response);
			break;
		case "4": showStops(request,response);
			break;
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on
	// the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

	public void graphs() {

		for (int i = 0; i < mng.getCities().size(); i++) {
			graph.addVertex(mng.getCities().get(i));
		}

		City Nobsa = mng.getCities().get(0);
		City Duitama = mng.getCities().get(1);
		City Sogamoso = mng.getCities().get(2);
		City Aquitania = mng.getCities().get(3);
		City Pesca = mng.getCities().get(4);
		City Tibasosa = mng.getCities().get(5);
		City Bogota = mng.getCities().get(6);
		City Tunja = mng.getCities().get(7);
		City Paipa = mng.getCities().get(8);
		City Yopal = mng.getCities().get(9);
		City Gameza = mng.getCities().get(10);
		City Bucaramanga = mng.getCities().get(11);

		Route sog_nob = mng.getRoutes().get(0);
		Route sog_nob2 = mng.getRoutes().get(1);
		Route sog_nob3 = mng.getRoutes().get(2);
		Route sog_dui = mng.getRoutes().get(3);
		Route sog_dui2 = mng.getRoutes().get(4);
		Route sog_aqui = mng.getRoutes().get(5);
		Route sog_aqui2 = mng.getRoutes().get(6);
		Route sog_pes = mng.getRoutes().get(7);
		Route sog_pes2 = mng.getRoutes().get(8);
		Route sog_tib = mng.getRoutes().get(9);
		Route sog_tib2 = mng.getRoutes().get(10);
		Route sog_gam = mng.getRoutes().get(11);
		Route sog_gam2 = mng.getRoutes().get(12);
		Route sog_bog = mng.getRoutes().get(13);;
		Route sog_bog2 = mng.getRoutes().get(14);
		Route sog_bog3 = mng.getRoutes().get(15);
		Route sog_tun = mng.getRoutes().get(16);
		Route sog_tun2 = mng.getRoutes().get(17);
		Route sog_yop = mng.getRoutes().get(18);
		Route sog_yop2 = mng.getRoutes().get(19);
		Route sog_yop3 = mng.getRoutes().get(20);
		Route sog_pai = mng.getRoutes().get(21);
		Route sog_pai2 = mng.getRoutes().get(22);
		Route sog_buc = mng.getRoutes().get(23);
		Route sog_buc2 = mng.getRoutes().get(24);
		Route sog_buc3 = mng.getRoutes().get(25);

		graph.addEdge(sog_nob, Sogamoso, Nobsa, EdgeType.UNDIRECTED);
		graph.addEdge(sog_nob2, Sogamoso, Nobsa, EdgeType.UNDIRECTED);
		graph.addEdge(sog_nob3, Sogamoso, Nobsa, EdgeType.UNDIRECTED);
		graph.addEdge(sog_dui, Sogamoso, Duitama);
		graph.addEdge(sog_dui2, Sogamoso, Duitama);
		graph.addEdge(sog_aqui, Sogamoso, Aquitania);
		graph.addEdge(sog_aqui2, Sogamoso, Aquitania);
		graph.addEdge(sog_pes, Sogamoso, Pesca);
		graph.addEdge(sog_pes2, Sogamoso, Pesca);
		graph.addEdge(sog_tib, Sogamoso, Tibasosa);
		graph.addEdge(sog_tib2, Sogamoso, Tibasosa);
		graph.addEdge(sog_gam, Sogamoso, Gameza);
		graph.addEdge(sog_gam2, Sogamoso, Gameza);
		graph.addEdge(sog_bog, Sogamoso, Bogota);
		graph.addEdge(sog_bog2, Sogamoso, Bogota);
		graph.addEdge(sog_bog3, Sogamoso, Bogota);
		graph.addEdge(sog_tun, Sogamoso, Tunja);
		graph.addEdge(sog_tun2, Sogamoso, Tunja);
		graph.addEdge(sog_yop, Sogamoso, Yopal);
		graph.addEdge(sog_yop2, Sogamoso, Yopal);
		graph.addEdge(sog_yop3, Sogamoso, Yopal);
		graph.addEdge(sog_pai, Sogamoso, Paipa);
		graph.addEdge(sog_pai2, Sogamoso, Paipa);
		graph.addEdge(sog_buc, Sogamoso, Bucaramanga);
		graph.addEdge(sog_buc2, Sogamoso, Bucaramanga);
		graph.addEdge(sog_buc3, Sogamoso, Bucaramanga);
		mng.setGraph(graph);
	}

	private void findRoute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try (PrintWriter out = response.getWriter()) {
			graphs();
			String aux = request.getParameter("index");
			int index = Integer.parseInt(aux);
			Gson gson = new Gson();
			if (mng.getGraph() != null) {
				out.print(gson.toJson(mng.findRoute(index, graph)));
			} else {
				out.print(gson.toJson(null));
			}
		}
	}

	// busqueda

	private void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try (PrintWriter out = response.getWriter()) {
			graphs();
			ArrayList<Route> routes = mng.getRoutes();
			Gson gson = new Gson();
			if (mng.getGraph() != null) {
				out.print(gson.toJson(routes));
			} else {
				out.print(gson.toJson(null));
			}
		}
	}

	// menor distancia

	private void showDistance(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try (PrintWriter out = response.getWriter()) {
			graphs();
			String aux = request.getParameter("index");
			int index = Integer.parseInt(aux);
			Gson gson = new Gson();
			if (mng.getGraph() != null) {
				out.print(gson.toJson(mng.showPrice(index, graph)));
			} else {
				out.print(gson.toJson(null));
			}
		}
	}
	
	//menor costo
	
	private void showCost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try(PrintWriter out=response.getWriter()){
			graphs();
			String aux=request.getParameter("index");
			int index=Integer.parseInt(aux);
			Gson gson=new Gson();
			if(mng.getGraph()!=null){
				out.print(gson.toJson(mng.showCost(index, graph)));
			}else{
				out.print(gson.toJson(null));
			}
		}
	}
	
	//menor paradas
	
	private void showStops(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try(PrintWriter out=response.getWriter()){
			graphs();
			String aux=request.getParameter("index");
			int index=Integer.parseInt(aux);
			Gson gson=new Gson();
			if(mng.getGraph()!=null){
				out.print(gson.toJson(mng.showStops(index, graph)));
			}else{
				out.print(gson.toJson(null));
			}
		}
	}
}
