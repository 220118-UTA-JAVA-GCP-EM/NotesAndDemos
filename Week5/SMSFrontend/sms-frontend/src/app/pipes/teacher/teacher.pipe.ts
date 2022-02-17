import { Pipe, PipeTransform } from '@angular/core';
import { ITeacher } from 'src/app/Interfaces/ITeacher';

@Pipe({
  name: 'teacher'
})
export class TeacherPipe implements PipeTransform {

  /*
  transform(value: string | undefined): string {
    console.log("In the teacher pipe", value);
    if(value === ""){
      return 'Teacher is yet to be determined';
    } else {
      return `Taught by: ${value}`
    }
  }
  */
 transform(value: ITeacher | undefined){
   if(!value || value.first === null){
     return 'Teacher is yet to be determined';
   }

   return `Taught by: ${value.first} ${value.last}`;
 }

}
