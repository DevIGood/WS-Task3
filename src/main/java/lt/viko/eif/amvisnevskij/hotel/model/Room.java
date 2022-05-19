package lt.viko.eif.amvisnevskij.hotel.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "room")
public class Room implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int roomNumber;
    private String roomType;
    private String bedType;
    private boolean isFree;
    private double cost;
    
    public Room() {}
    
    public Room(int roomNumber, String roomType, String bedType, boolean isFree, double cost) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.bedType = bedType;
        this.isFree = isFree;
        this.cost = cost;
    }
//
//    private List<Room> roomList = new ArrayList<>();
//
//    public List<Room> getRoomList() {
//        return roomList;
//    }

//    @XmlElement(name = "room")
//    public void setStudentList(List<Room> roomList) {
//        this.roomList = roomList;
//    }

    @Override
    public String toString() {
        return String.format("Students: \n %s", getRoomType());
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @XmlElement(name = "roomNumber")
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    @XmlElement(name = "roomType")
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBedType() {
        return bedType;
    }

    @XmlElement(name = "bedType")
    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public boolean isFree() {
        return isFree;
    }

    @XmlElement(name = "isFree")
    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }

    public double getCost() {
        return cost;
    }

    @XmlElement(name = "cost")
    public void setCost(double cost) {
        this.cost = cost;
    }

}
