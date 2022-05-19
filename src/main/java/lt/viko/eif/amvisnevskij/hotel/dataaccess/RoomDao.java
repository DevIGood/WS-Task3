package lt.viko.eif.amvisnevskij.hotel.dataaccess;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import lt.viko.eif.amvisnevskij.hotel.model.Room;
import lt.viko.eif.amvisnevskij.hotel.model.Rooms;

public class RoomDao {
	
	public Rooms getAllRooms() throws JAXBException, IOException {
		return readXml();
	}
	
	public Room getByNumber(int number) throws JAXBException, IOException {
		Rooms rooms = readXml();
		
		List<Room> roomList = rooms.getRooms();
		return roomList.stream().filter(room -> number == room.getRoomNumber()).findFirst().orElse(null);
	}
	
	public void saveRoom(Room room) throws JAXBException, IOException {
		writeXml(room);
	}
	
	private Rooms readXml() throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Rooms.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
        Path fileName = Path.of("./room.xml");
        String actual = Files.readString(fileName);
        StringReader reader = new StringReader(actual);
        Rooms rooms = (Rooms) unmarshaller.unmarshal(reader);
        
        return rooms;
	}
	
	private void writeXml(Room room) throws JAXBException, IOException {
		Rooms rooms = readXml();
		
		List<Room> roomList = rooms.getRooms();
		roomList.add(room);
		rooms.setRooms(roomList);
		
		JAXBContext context = JAXBContext.newInstance(Rooms.class);
		
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter xmlWriter = new StringWriter();
        marshaller.marshal(rooms, xmlWriter);
        FileWriter fw = new FileWriter("./room.xml");
        fw.write(xmlWriter.toString());
        fw.close();
	}
	
}
