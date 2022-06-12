import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BooksdataService {

  constructor(private http:HttpClient) { 

  }

  getBookData(){
    let apiurl="https://openlibrary.org/works/OL45883W.json";
    return this.http.get(apiurl);
  }
}
