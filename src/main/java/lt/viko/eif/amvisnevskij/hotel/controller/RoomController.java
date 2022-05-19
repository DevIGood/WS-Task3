package lt.viko.eif.amvisnevskij.hotel.controller;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

import lt.viko.eif.amvisnevskij.hotel.dataaccess.RoomDao;
import lt.viko.eif.amvisnevskij.hotel.model.Room;
import lt.viko.eif.amvisnevskij.hotel.model.Rooms;

@Path("/Rooms")
public class RoomController {

	// Data access object - used for the essential logic of reading or writing data from/to database, file, etc...
	private RoomDao roomDao = new RoomDao();
	
	// Get all objects
	@GET
	@Path("/GetAll")
	@Produces(MediaType.APPLICATION_XML)
	public Response getAllRooms() throws JAXBException, IOException {
		Rooms rooms = roomDao.getAllRooms();
		
		return Response.status(200).entity(rooms).build();
	}
	
	// Get single object by it's unique property (id, etc.)
	@GET
	@Path("/Get/{roomNumber}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getRoomByNumber(@PathParam("roomNumber") int roomNumber) throws JAXBException, IOException {
		Room room = roomDao.getByNumber(roomNumber);
		
		return Response.status(200).entity(room).build();
	}
	
	// Create a new object
	@POST
	@Path("/Create")
	@Consumes(MediaType.APPLICATION_XML)
	public Response createRoom(Room room) throws JAXBException, IOException {
		roomDao.saveRoom(room);
		
		return Response.status(201).build();
	}
	
	// PUT - similar to POST, receives a unique property in path or query and replaces the existing object by the new one.
	// DELETE - receives a unique property in path or query and deletes the object.
}
