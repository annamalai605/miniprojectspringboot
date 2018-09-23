import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from '../User';
import {UserService} from '../user.service';

@Component({
  selector: 'app-view-notes',
  templateUrl: './viewnotes.component.html',
  styleUrls: ['./viewnotes.component.css']
})
export class ViewNotesComponent {
     
    constructor(private formBuilder: FormBuilder,
        private router: Router,private userService : UserService, private route : ActivatedRoute){
        
        }
    
//     ngOnInit() {
//       this.userService.viewNotes(this.note).subscribe(response=> 
//        {
//            console.log("created note successfully");
//            this.message="You have successfully created the note";
//            //this.router.navigate(['/viewnotes']);
//            });
//    }
    

    
    }
