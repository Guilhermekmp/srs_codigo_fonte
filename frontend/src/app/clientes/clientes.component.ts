import { ClientesService } from './clientes.service';
import { Component, OnInit } from '@angular/core';
import { Cliente } from './models/cliente.interface';
import { ConfirmationService } from 'primeng/api';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css'],
  providers: [ConfirmationService]
})
export class ClientesComponent {

  clienteId: number
  clientes: Array<Cliente> = new Array<Cliente>();
  formulario: FormGroup;
  client: Array<Cliente>;
  displayCreation: boolean = false;

  constructor(
    public clientesService: ClientesService,
    private confirmationService: ConfirmationService,
    private formBuilder: FormBuilder) {
      this.formulario = this.formBuilder.group({
        nome:['', [Validators.required]],
        email:['', [Validators.required]],
        endereco:['', [Validators.required]],
        cpf: ['', [Validators.required]],
        rg: ['', [Validators.required, Validators.minLength(7), Validators.maxLength(7)]],
        telefone:['', [Validators.required]],
        dataNascimento:['', [Validators.required]]
      })
    }

  ngOnInit() {
    this.listar()
  }

  listar() {
    this.clientesService.listar().subscribe(dados => this.client = dados)
  }


  deletar(id: any) {
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

  salvar() {
    if(this.clienteId){
      var cliente = this.formulario.getRawValue();
      cliente.id = this.clienteId
      this.clientesService.atualizarCliente(cliente).subscribe(
        response => {
          alert("Cadastrado com sucesso!")
          this.listar()
          this.formulario.reset()
        },
        error => {
          alert(error.message)
        }
      )

    }else{
      var cliente = this.formulario.getRawValue();
    this.clientesService.salvar(cliente).subscribe(
      response => {
        alert("Cadastrado com sucesso!")
        this.listar()
        this.formulario.reset()
      },
      error => {
        alert(error.message)

      }
    )

    }
    
  }
  atualizarCliente(clienteId: number) {
    this.clienteId = clienteId
    this.abrirPopUp()
    var cliente;
    this.clientesService.buscarPorId(clienteId).subscribe(
      res => this.formulario.patchValue(res))
  }

  abrirPopUp() {
    if(this.displayCreation = true){
      this.formulario.reset()
  }
}

  
}
