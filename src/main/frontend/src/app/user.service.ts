import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse ,HttpHeaders } from '@angular/common/http';
import {Note} from './Note';

import { User } from './User';

@Injectable()
export class UserService {
    constructor(private http: HttpClient) { }

    registerUser(user : any) {
        return this.http.post(`api/registeruser`,user);
    }
    
     loginUser(username : string) {
        return this.http.post<User>(`api/loginuser`,username);
    }
    
     createNote(note  : any) {
        return this.http.post(`api/createnote`,note);
    }
    
    viewNotes(username : string) {
        return this.http.post<Note[]>(`api/viewnotes`,username);
    }

    
}