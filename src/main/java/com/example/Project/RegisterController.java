package com.example.Project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@RequestMapping(value = "/api/registeruser", method = RequestMethod.POST)
	public void registerUser(@RequestBody UserDto user) {
		this.registerService.registerUser(user);
		return;
	}

	@RequestMapping(value = "/api/loginuser", method = RequestMethod.POST)
	public UserDto loginuser(@RequestBody String userName) {
		List<Users> userList = this.registerService.loginUser(userName);
		if (!userList.isEmpty()) {
			Users user = userList.get(0);
			UserDto userDto = new UserDto();
			userDto.setFirstName(user.getFirstName());
			userDto.setLastName(user.getLastName());
			userDto.setUsername(user.getUserName());
			userDto.setId(user.getUserId());
			userDto.setPassword(user.getPassword());
			return userDto;
		} else
			return new UserDto();
	}

	@RequestMapping(value = "/api/createnote", method = RequestMethod.POST)
	public void createNote(@RequestBody NoteDto note) {
		this.registerService.createNote(note);
		return;
	}

	@RequestMapping(value = "/api/viewnotes", method = RequestMethod.POST)
	public List<NoteDto> viewnotes(@RequestBody String userName) {
		List<Notes> noteList = this.registerService.viewNotes(userName);
		List<NoteDto> noteDtoList=new ArrayList<>();
		for(Notes note : noteList)
		{
			NoteDto noteDto=new NoteDto();
			noteDto.setNoteDesc(note.getNoteDesc());
			noteDto.setNoteId(note.getNoteId());
			noteDto.setNoteName(note.getNoteName());
			noteDto.setUpdatedUser(note.getUpdatedUser());
			noteDtoList.add(noteDto);
		}
		return noteDtoList;
	}

}
