package com.example.Project;

public class NoteDto {
	public int noteid;
	public String notename;
	public String notedesc;
	public String updatedUser;
	
	public int getNoteId() {
		return noteid;
	}
	public void setNoteId(int noteId) {
		this.noteid = noteId;
	}
	public String getNoteName() {
		return notename;
	}
	public void setNoteName(String noteName) {
		this.notename = noteName;
	}
	public String getNoteDesc() {
		return notedesc;
	}
	public void setNoteDesc(String noteDesc) {
		this.notedesc = noteDesc;
	}
	public String getUpdatedUser() {
		return updatedUser;
	}
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}
	
	
	
}
