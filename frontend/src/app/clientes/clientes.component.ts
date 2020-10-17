import { ClientesService } from './clientes.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Cliente } from './models/cliente.interface';
import { ConfirmationService } from 'primeng/api';
import { ClientesModule } from './clientes.module';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css'],
  providers: [ConfirmationService]
})
export class ClientesComponent {

  formulario: FormGroup;
  clientes: Array<Cliente> = new Array<Cliente>();
  //clientes2: any;
  //clonedClientes: { [s: string]: Cliente; } = {};

  client: Array<Cliente>;
  cliente = new Cliente();

  constructor(
    public clientesService: ClientesService,
    private formBuilder: FormBuilder,
    private confirmationService: ConfirmationService) {
    this.formulario = this.formBuilder.group({
      nome: ['', [Validators.required, Validators.maxLength(120)]],
      email: ['', [Validators.required, Validators.maxLength(255)]], 
      endereco: ['', [Validators.required]],
      cpf: ['', [Validators.required, Validators.minLength(11), Validators.maxLength(11)]],
      rg: ['', [Validators.required, Validators.minLength(7), Validators.maxLength(7)]],
      telefone: ['', [Validators.required, Validators.minLength(12), Validators.maxLength(12)]],
      dataNascimento: ['',[Validators.required]]
    });

  }

  ngOnInit(){
    this.listar()

  }

  //adicionarCliente() {
    //this.clientes2 = this.clientesService.adicionarCliente(this.formulario.getRawValue());
    //console.log(this.clientes)
    //this.formulario.reset()
  //}


  listar(){
    this.clientesService.listar().subscribe(dados => this.client = dados)
  }

  deletar(id:any){
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja excluir esse registro?',
      accept: () => {
        this.clientesService.deletar(id).subscribe(
          r => {
            this.listar()
          }
        )

      }
    })
  }

  salvar(){
    this.cliente.dataNascimento = new Date();
    this.cliente.dataNascimento.setDate(1);
    console.log('cliente', this.cliente);
    this.clientesService.salvar(this.cliente).subscribe(
      response =>{
        this.cliente = response
      },
      error => {
        alert("deu merda ai")
      }
    )

  }

}
