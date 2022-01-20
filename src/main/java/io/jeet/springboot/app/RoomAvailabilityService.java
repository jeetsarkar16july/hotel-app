package io.jeet.springboot.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class RoomAvailabilityService {
	
	 private List<Rooms> availableRooms = new ArrayList<>(Arrays.asList(
			Rooms.builder().floor("3rd").roomNo("305").category("Premium").build(),
			Rooms.builder().floor("6th").roomNo("602").category("Royale").build(),
			Rooms.builder().floor("9th").roomNo("907").category("Economic").build(),
			Rooms.builder().floor("11th").roomNo("1103").category("Premium").build())) ;
	 
	 public List<Rooms> getAvailableRooms(){
		 return availableRooms;
	 }
	 
	 public Rooms getRoomInfo(String room){
		 return availableRooms.stream().filter(r -> r.getRoomNo().equalsIgnoreCase(room)).findFirst().get();
	 }

	public void addRoom(Rooms room) {
		 
		availableRooms.add(room);
	}

	public void updateRoom(String roomNo, Rooms room1) {
		
		IntStream.range(0, availableRooms.size()).forEach(i -> {
			if(availableRooms.get(i).getRoomNo().equalsIgnoreCase(roomNo)){
				availableRooms.set(i, room1);
			}
		});
		
	}

	public void deleteRoom(String roomNo) {
		
		availableRooms.removeIf(room -> room.getRoomNo().equalsIgnoreCase(roomNo));

//		IntStream.range(0, availableRooms.size()).forEach(i -> {
//			if(availableRooms.get(i).getRoomNo().equalsIgnoreCase(roomNo)){
//				availableRooms.remove(i);
//				
//			}
//		});
		
	}

}
