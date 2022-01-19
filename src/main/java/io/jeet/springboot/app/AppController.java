package io.jeet.springboot.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class AppController {
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private RoomAvailabilityService roomAvilabilityService;
	
	@RequestMapping("/hello")
	public String sayHello(){
		
		return "Hello User! ";
	}
	
	@RequestMapping("/available-rooms")
	public List<Rooms> availability(){
		
		return roomAvilabilityService.getAvailableRooms();
	}
	
	@RequestMapping("/available-rooms/{room}")
	public Rooms findRoomInfo(@PathVariable String room){
		
		return roomAvilabilityService.getRoomInfo(room);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/available-rooms")
	public String addNewRoomDetails(@RequestBody String  room ){		
		
		try {
			Rooms room1 = objectMapper.readValue(room, Rooms.class);
			roomAvilabilityService.addRoom(room1);
			}
			catch(Exception e) {
				
			  System.out.println(e);	
			  return "failure";
			}
		return "success";
	}

}
