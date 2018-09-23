export class Note
{
     noteid: number;
    notename: string;
    notedesc: string;
    updatedUser : string;
    
    constructor(noteid : number,notename : string, notedesc : string,updatedUser : string)
    {
        this.noteid=noteid;
        this.notename=notename;
        this.notedesc=notedesc;
        this.updatedUser=updatedUser;
      
        }
    
    
    }