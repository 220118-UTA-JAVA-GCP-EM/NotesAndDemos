import { ITeacher } from "./ITeacher";

export interface ICourse {
    id: number;
    subject: string;
    number: number;
    name: string;
    teacher?: ITeacher;
}