package io.jeet.springboot.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RoomAvailabilityService {
	
	 private List<Rooms> availableRooms = new ArrayList<>(Arrays.asList(Rooms.builder().floor("3rd").roomNo("305").build(),
			Rooms.builder().floor("6th").roomNo("602").build(),
			Rooms.builder().floor("9th").roomNo("907").build(),
			Rooms.builder().floor("11th").roomNo("1103").build())) ;
	 
	 public List<Rooms> getAvailableRooms(){
		 return availableRooms;
	 }
	 
	 public Rooms getRoomInfo(String room){
		 return availableRooms.stream().filter(r -> r.getRoomNo().equalsIgnoreCase(room)).findFirst().get();
	 }

	public void addRoom(Rooms room) {
		 
		availableRooms.add(room);
	}

}
