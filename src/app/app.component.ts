import { Component , ElementRef, TemplateRef, ViewChild} from '@angular/core';
import { ApiRestService } from './api-rest.service';
import { Empleado } from './empleado';
import { faTrashAlt, faUserEdit , faCalendarAlt, faListAlt, faBook, faUserPlus} from '@fortawesome/free-solid-svg-icons';
import {NgbModal, ModalDismissReasons, NgbDateParserFormatter} from '@ng-bootstrap/ng-bootstrap';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'sistemaGestion';

  constructor(private api:ApiRestService,private modalService: NgbModal) {}

  errors:any;
  POSTS: any;
  page = 1;
  count = 0;
  tableSize = 10;
  tableSizes = [3, 6, 9, 12];

  searchTerm!:string;
  pageFilter=1;
  pageSize = 4;
  collectionSize!: number;
  currentRate = 8;
  
  allEmpleados!: Empleado[];

  headElements = ['tipoidentificacion','numeroidentificacion','primernombre', 'otrosnombres', 'primerapellido', 'segundoapellido','paisempleo','email','estado'];
  empleados:Empleado[]=[];
  tipoidAntiguo!:string;
  numidAntiguo!:string;

  modalTitle='';
  faUserPlus = faUserPlus;
  faBook = faBook;
  faListAlt = faListAlt;
  faTrashAlt = faTrashAlt;
  faUserEdit =faUserEdit;
  faCalendarAlt=faCalendarAlt;

  closeResult:string ="";
  model!:NgbDateStruct;
  fechaIngreso:string="";
  fechahoraregistro:string="";

  datepipe:DatePipe = new DatePipe('en-US')
  fechaRegistro:string="";
  fechaActual:Date=new Date();
  messageEmpleado!:Empleado;

  minDate = {year:this.fechaActual.getFullYear(),month: this.fechaActual.getMonth(), day: this.fechaActual.getDay()}
  maxDate={year:this.fechaActual.getFullYear(),month: this.fechaActual.getMonth()+1, day: this.fechaActual.getDay()};
  startDate = {year:this.fechaActual.getFullYear(),month: this.fechaActual.getMonth(), day: this.fechaActual.getDay()}

  tiposidentificacion=["Cédula de Ciudadanía","Cédula de Extranjería","Pasaporte","Permiso Especial"];
  paisesempleo=["Colombia","Estados Unidos"];
  areas=["Administración","Financiera","Compras","Infraestructura","Operacion","Talento Humano","Servicios Varios","Otra"];
  currentIndex=1;
  errorTipoIdentificacion:boolean=false;
  errorPaisEmpleo:boolean=false;
  errorArea:boolean=false;
  update:boolean=false;
  create:boolean=false;
  enquiry1= new Empleado();
  ngOnInit()
  {
    this.obtenerEmpleados();
  }

  obtenerEmpleados()
  {
    this.api.getAllEmpleados().
    subscribe(data=>{ 
      this.collectionSize=data.length;
      this.empleados=data;
      this.allEmpleados=this.empleados;
    });
  }

  search(event:any): void {
    this.empleados = this.allEmpleados.filter((val) => val.primernombre.toLowerCase().includes(event.target.value));
    this.collectionSize = this.empleados.length;
  }

  eliminarEmpleado(empleado:Empleado)
  {
    if(confirm("Está seguro que quiere eliminar al empleado: " + empleado.numeroidentificacion + " " + empleado.primernombre))
    {
      empleado.estado='inactivo';
      this.api
      .postEmpleado(empleado,empleado.tipoidentificacion,empleado.numeroidentificacion)
      .subscribe(data=>this.messageEmpleado=data);
    }
    this.obtenerEmpleados();
  }

  actualizarEmpleado()
  {
    this.enquiry1.fechaingreso=this.fechaIngreso;

    if(this.enquiry1.paisempleo=='Colombia'){
      this.enquiry1.email=this.enquiry1.primernombre.toLowerCase()+"."+this.enquiry1.primerapellido.toLowerCase()+"@cidenet.com.co";
    }
    else{
      this.enquiry1.email=this.enquiry1.primernombre+"."+this.enquiry1.primerapellido+"@cidenet.com.us";
    }
    
    this.enquiry1.fechahoraedicion=""+this.datepipe.transform(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSS");
    this.api
    .postEmpleado(this.enquiry1,this.tipoidAntiguo,this.numidAntiguo)
    .subscribe(data=>this.messageEmpleado=data,
      error=>this.errors=error,() => {this.obtenerEmpleados()}
    );
    confirm("el empleado ha sido actualizado correctamente");
  }

  editarEmpleado(empleado:Empleado,content:TemplateRef<any>)
  {
    let tipoidAntiguo1=empleado.tipoidentificacion;
    let numidAntiguo1=empleado.numeroidentificacion;
    this.tipoidAntiguo=tipoidAntiguo1;
    this.numidAntiguo=numidAntiguo1;
    this.enquiry1=empleado;
    var date = new Date(empleado.fechaingreso);
    this.model = { day: date.getUTCDate(), month: date.getUTCMonth() + 1, year: date.getUTCFullYear()};
    this.fechahoraregistro = ""+this.datepipe.transform(empleado.fechahoraregistro, "dd/MM/yyyy HH:mm:ss.SSS");
    this.open(content,"update");
  }
  validarTipoIdentificacion(tipoidentificacion:string)
  {
    if(tipoidentificacion!="default")
    {
      this.errorTipoIdentificacion=false;
    }
    else{
      this.errorTipoIdentificacion=true;
    }
  }

  validarPaisEmpleo(paisempleo:string)
  {
    if(paisempleo!="default")
    {
      this.errorPaisEmpleo=false;
    }
    else{
      this.errorPaisEmpleo=true;
    }
  }

  validarArea(area:string)
  {
    if(area!="default")
    {
      this.errorArea=false;
    }
    else{
      this.errorArea=true;
    }
  }

  open(content:TemplateRef<any>,accion:string) {
    console.log("accion :" + accion);
    if(accion=='update'){
      this.modalTitle="Actualizar Empleado";
      this.create=false;
      this.update=true;
      
    } else{
      this.modalTitle="Agregar Empleado";
      this.create=true;
      this.update=false;
      this.fechahoraregistro = ""+this.datepipe.transform(new Date(), "dd/MM/yyyy HH:mm:ss.SSS");
    }
    
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
  
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  guardarEmpleado()
  {
    this.enquiry1.fechaingreso=this.fechaIngreso;
    if(this.enquiry1.paisempleo=='Colombia'){
      this.enquiry1.email=this.enquiry1.primernombre.toLowerCase()+"."+this.enquiry1.primerapellido.trim().toLowerCase()+"@cidenet.com.co";
    }
    else{
      this.enquiry1.email=this.enquiry1.primernombre.toLowerCase()+"."+this.enquiry1.primerapellido.trim().toLowerCase()+"@cidenet.com.us";
    }
    
    this.enquiry1.fechahoraregistro=""+this.datepipe.transform(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSS");
    this.api.putEmpleado(this.enquiry1)
    .subscribe(data=>this.messageEmpleado=data,
      error=>this.errors=error,() => {this.obtenerEmpleados()}
    );
    confirm("el empleado ha sido agregado correctamente");
  }

  onDateSelect(event:NgbDateStruct) {
    let year = event.year;
    let month = event.month <= 9 ? '0' + event.month : event.month;
    let day = event.day <= 9 ? '0' + event.day : event.day;
     this.fechaIngreso = year + "-" + month + "-" + day;
   }

   onTableDataChange(event:number){
    this.page = event;
    this.obtenerEmpleados();
  }  

  onTableSizeChange(event:any): void {
    this.tableSize = event.target.value;
    this.page = 1;
    this.obtenerEmpleados();
  }  
}
