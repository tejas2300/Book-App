import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { userinfo } from 'src/app/model/userinfo';

@Injectable({
  providedIn: 'root'
})
export class LoginService {


  constructor(private http:HttpClient) { }


  public loginUserfromBackend(user:userinfo):Observable<any>{
    return this.http.post("http://localhost:8081/login",user);
  }
  public registerUserfromBackend(user:userinfo):Observable<any>{
    return this.http.post("http://localhost:8081/register",user);
  }
  public changePassword(user:userinfo):Observable<any>{
    return this.http.post("http://localhost:8081/password",user);
  }



}  


