package UserProgram;
import java.util.ArrayList;

public class RoomTypeList {
    private static ArrayList<RoomType> roomTypeList;

    public RoomTypeList(){
        roomTypeList = new ArrayList<>();
    }
    public void addRoomType(String categoryName, int maxGuestAllowance, double pricePerNight, double pricePerWeek, double promoPrice){
        RoomType newRoomType = new RoomType(categoryName,maxGuestAllowance,pricePerNight,  pricePerWeek,  promoPrice);
        roomTypeList.add(newRoomType);
    }
    public static RoomType getRoomType(int roomTypeId){
        return roomTypeList.get(roomTypeId);
    }
    public void showAllRoomType(){
        for (int i = 0; i < roomTypeList.size() ; i++) {
            System.out.println(roomTypeList.get(i));
        }
    }
}
