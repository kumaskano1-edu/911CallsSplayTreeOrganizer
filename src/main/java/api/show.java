package api;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletContext;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Servlet implementation class show
 */
@WebServlet("/show")
public class show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("").append("");
		  JsonObject json = new JsonObject();

		String filename = "/WEB-INF/dataset.csv";
		ServletContext context = getServletContext();
		InputStream inp = context.getResourceAsStream(filename);
		if(inp != null) {
			  InputStreamReader isr = new InputStreamReader(inp);
			  BufferedReader reader = new BufferedReader(isr);
			  String text = "";
			  Scanner scanner = new Scanner(reader);
			  ArrayList<CallObject> callList = new ArrayList<CallObject>();
		        //READ TXT FILE, POPULATE callslist with CallObjects
		        while (scanner.hasNext()) 
		        {
		            String line = scanner.nextLine();
		           
		            
		            String[] lineIntoParts = line.split(",");
		            CallObject single911call = new CallObject(lineIntoParts[0], lineIntoParts[1], lineIntoParts[2], lineIntoParts[3], lineIntoParts[4], lineIntoParts[5], lineIntoParts[6], lineIntoParts[7], lineIntoParts[8]);
		            if(single911call.title.contains("VEHICLE ACCIDENT")) {
		            	callList.add(single911call);
		            }
		        }

		        int count = 0;
		        String res = new Gson().toJson(callList);
		        response.getWriter().print(res);
//		        while(count < callsList.size() / 2) {
//		            System.out.println(callsList.get(count).toString());
//		            count = count + 1;
//		        }
		        //END READ TXT FILE

		        
		        scanner.close();
		    }

		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
