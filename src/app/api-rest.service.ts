import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Empleado } from './empleado';

@Injectable({
  providedIn: 'root'
})
export class ApiRestService {

  constructor(private http:HttpClient) { }

  getAllEmpleados():Observable<Empleado[]>
  {
    const url='http://localhost:8084/api/empleados';
    return this.http.get<Empleado[]>(url);
  }

  putEmpleado(empleado:Empleado):Observable<Empleado>
  {
    const url='http://localhost:8084/api/empleados';
    return this.http.put<Empleado>(url,empleado);
  }

  postEmpleado(empleado:Empleado,tipoidentificacion:string,numeroidentificacion:string){
    const url='http://localhost:8084/api/empleados';
    let param1= new HttpParams().set("tipoidentificacion",tipoidentificacion).set("numeroidentificacion",numeroidentificacion);
    return this.http.post<Empleado>(url,empleado, {params:param1});
  }
}
