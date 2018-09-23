import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from '../User';
import { Note } from '../Note';
import {UserService} from '../user.service';

@Component({
  selector: 'app-login-success',
  templateUrl: './loginsuccess.component.html',
  styleUrls: ['./loginsuccess.component.css']
})
export class LoginSuccessComponent {
    
    public note : Note;
    public noteList : Note[];
     noteForm: FormGroup;
    message : string = '';
    loading = false;
    submitted = false;
    userName : string;
    constructor(private formBuilder: FormBuilder,
        private router: Router,private userService : UserService, private route : ActivatedRoute){
            this.userName=this.route.snapshot.paramMap.get('id');
        this.message='';
        }
    
     ngOnInit() {
        this.noteForm = this.formBuilder.group({
            notename: ['', Validators.required],
            notedesc: ['', [Validators.required]]
        });
    }
    
    onSubmit(){
     this.note= new Note(null,this.noteForm.value.notename,
                this.noteForm.value.notedesc,this.userName);

        this.userService.createNote(this.note).subscribe(response=> 
        {
            console.log("created note successfully");
            this.message="You have successfully created the note";
            //this.router.navigate(['/viewnotes']);
            });
}
    onClick(){
        this.userService.viewNotes(this.userName).subscribe(response=> 
        {
            debugger;
            //this.router.navigate(['/viewnotes']);
            this.noteList=response;
            });
        }
    
    
    }
