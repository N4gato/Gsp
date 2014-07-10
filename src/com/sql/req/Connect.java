package com.sql.req;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.beans.Positions;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Connect
 */
@WebServlet(description = "to connect to the server", urlPatterns = { "/Connect" })
public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i=0;
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

		/* Chargement du driver JDBC pour MySQL */
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			out.println("working");
		} catch ( ClassNotFoundException e ) {
		/* Gérer les éventuelles erreurs ici. */
			out.println("erreur de chargement du driver"+e);
		}
		
		/* Connexion à la base de données */
		String url = "jdbc:mysql://localhost:3306/db";
		String utilisateur = "root";
		String motDePasse = "123";
		Connection connexion = null;
		try {
			
			connexion = (Connection) DriverManager.getConnection( url, utilisateur,motDePasse );
		/* Ici, nous placerons nos requêtes vers la BDD */
		/* ... */
			/*
		Statement st= (Statement) connexion.createStatement();
		
		String sql= "insert into info (username,password,firstname,lastname,address,pincode,phonenumber) values(username,password,firstname,lastname,address,14,14)";
				
		st.executeUpdate(sql);
		*/
		
		String sql = "SELECT * FROM positions";
		 
		Statement statement = (Statement) connexion.createStatement();
		ResultSet result = statement.executeQuery(sql);
		 
		ArrayList<Positions> positionListe = new ArrayList<Positions>();
		 
		while (result.next()){
		    int id = result.getInt(1);
		    String address = result.getString(2);
		    double altitude = result.getDouble(3);
		    double course = result.getDouble(4);
		    double latitude = result.getDouble(5);
		    double longitude = result.getDouble(6);
		    String other = result.getString(7);
		    double power = result.getDouble(8);
		    double speed = result.getDouble(9);
		    String time = result.getString(10);
		    int valid = result.getInt(11);
		    int device_id = result.getInt(12);
		    
		   
		    
		    Positions positions1 = new Positions();
		    
		    
		    positions1.setId(id);
		    positions1.setAddress(address);
		    positions1.setAltitude(altitude);
		    positions1.setCourse(course);
		    positions1.setLatitude(latitude);
		    positions1.setLongitude(longitude);
		    positions1.setOther(other);
		    positions1.setPower(power);
		    positions1.setSpeed(speed);
		    positions1.setTime(time);
		    positions1.setValid(valid);
		    positions1.setDevice_id(device_id);
		   		   
		    positionListe.add(i , positions1);
		  
		   
		    
		}
		
		 request.setAttribute( "positionListe", positionListe );
		    //request.getRequestDispatcher( "/map.jsp" ).forward( request, response );
		    
		 this.getServletContext().getRequestDispatcher( "/index.jsp").forward( request, response );
		 positionListe.clear();
		
		} catch ( SQLException e ) {
		/* Gérer les éventuelles erreurs ici */
			out.println("connection to database error");
			out.println(e);  
			out.println("fuck");
		} finally {
					if ( connexion != null )
					try {
						/* Fermeture de la connexion */
						connexion.close();
					} catch ( SQLException ignore ) {
						/* Si une erreur survient lors de la fermeture, il
						suffit de l'ignorer. */
						out.println("cant close connection");
					}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
