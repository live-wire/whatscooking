package happyhours.whatscooking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * Hello world!
 *
 */

public class App {

	public static Connection connect = null;
	public static String sqlText = "";

	public static void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Worked!");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void ConnectionToMySql() {
		connection();
		String host = "jdbc:mysql://localhost:3306/gobmtc";
		String username = "root";
		String password = "happyhours";
		try {
			connect = (Connection) DriverManager.getConnection(host, username,
					password);
			System.out.println("MySQL Works!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void QueryDB() throws SQLException {
		Statement statement = null;

		try {

			statement = (Statement) connect.createStatement();
			ResultSet result = null;
			try {
				String sql = "select * from route";
				result = statement.executeQuery(sql);

				while (result.next()) {

					int name = result.getInt("route_id");
					String age = result.getString("route_name");
					sqlText = sqlText + name + age + "\n";
					System.out.println(name + " " + age);

				}
			} finally {
				if (result != null)
					result.close();
			}
		} finally {
			if (statement != null)
				statement.close();
		}

	}

	public static void handleAddressUpdate(JSONObject obj) throws SQLException {
		String busNumber = null, busName = null, latitude = null, longitude = null, driverContact = null, lastUpdated = null;
		;
		busNumber = (String) obj.get("BusNumber");
		busName = (String) obj.get("BusName");
		latitude = (String) obj.get("Latitude");
		longitude = (String) obj.get("Longitude");
		driverContact = (String) obj.get("Contact");
		lastUpdated = (String) obj.get("LastUpdated");
		Statement statement = null;
		if (busNumber != null && busName != null) {
			try {

				statement = (Statement) connect.createStatement();
				int result = 0;

				// String sql
				// ="INSERT INTO bus (number_plate,latitude,longitude,contact) VALUES ('"+busNumber+"',"+latitude+","+longitude+",'"+driverContact+"');";
				String sql = "UPDATE bus SET latitude=" + latitude
						+ ",longitude=" + longitude + ",bus_name='" + busName
						+ "',last_update='" + lastUpdated
						+ "' WHERE number_plate='" + busNumber + "';";
				String sqlExhaustivePaths = "INSERT INTO path_exhaustive (number_plate,latitude,longitude,last_update) VALUES ('"
						+ busNumber
						+ "',"
						+ latitude
						+ ","
						+ longitude
						+ ",'"
						+ lastUpdated + "');";
				result = statement.executeUpdate(sql);
				result = statement.executeUpdate(sqlExhaustivePaths);

				// while(result.next()) {
				//
				// int name = result.getInt("route_id");
				// String age = result.getString("route_name");
				// sqlText=sqlText+name+age+"\n";
				// System.out.println(name+" "+age);
				//
				// }
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				if (statement != null) {
				}

			}// end try
		}

	}

	public static void main(String[] args) throws IOException, SQLException {
		ConnectionToMySql();
		InetSocketAddress addr = new InetSocketAddress(8080);
		HttpServer server = HttpServer.create(addr, 0);

		server.createContext("/", new MyHandler());
		server.setExecutor(Executors.newCachedThreadPool());
		server.start();
		System.out.println("Server is listening on port 8080");
	}
}

class MyHandler implements HttpHandler {
	public void handle(HttpExchange exchange) throws IOException {
		String requestMethod = exchange.getRequestMethod();
		if (requestMethod.equalsIgnoreCase("POST")) {
			Headers responseHeaders = exchange.getResponseHeaders();
			responseHeaders.set("Content-Type", "application/JSON");
			exchange.sendResponseHeaders(200, 0);

			OutputStream responseBody = exchange.getResponseBody();
			Headers requestHeaders = exchange.getRequestHeaders();
			InputStream input = exchange.getRequestBody();
			String json = MyHandler.convertStreamToString(input);

			Set<String> keySet = requestHeaders.keySet();
			// Iterator<String> iter = keySet.iterator();
			// while (iter.hasNext()) {
			// String key = iter.next();
			// List values = requestHeaders.get(key);
			// String s = key + " = " + values.toString() + "\n";
			// responseBody.write(s.getBytes());
			// }
			try {

				JSONParser parser = new JSONParser();
				Object request = null;
				String type = "";
				Object category = null;
				Object resultObject = parser.parse(json);
				if (resultObject instanceof JSONArray) {
					JSONArray array = (JSONArray) resultObject;
					for (Object object : array) {
						JSONObject obj = (JSONObject) object;
						System.out.println(obj.get("Request"));
						System.out.println(obj.get("Category"));
					}

				} else if (resultObject instanceof JSONObject) {
					JSONObject obj = (JSONObject) resultObject;
					if (obj != null) {
						type = (String) obj.get("RequestType");
						if (type != null && type.equals("AddressUpdate")) {
							request = obj.get("Request");
							if (request != null
									&& request instanceof JSONObject) {
								obj = (JSONObject) request;

								App.handleAddressUpdate(obj);

							}

						} else if (type != null && type == "Find") {
						} else {

						}

					}

				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			responseBody.write(App.sqlText.getBytes());
			responseBody.write(json.getBytes());
			System.out.println(json);
			responseBody.close();
		}
	}

	static String convertStreamToString(java.io.InputStream is) {
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}

}
