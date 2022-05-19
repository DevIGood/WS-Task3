package lt.viko.eif.amvisnevskij.hotel.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rooms {
	private List<Room> rooms = new ArrayList<>();

	public List<Room> getRooms() {
		return rooms;
	}

	@XmlElement(name = "room")
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
}
