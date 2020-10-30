import { ClientesService } from './clientes.service';
import { Component, OnInit } from '@angular/core';
import { Cliente } from './models/cliente.interface';
import { ConfirmationService } from 'primeng/api';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GenericValidator } from '../shared/validators.utils';

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
      nome: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      endereco: ['', [Validators.required]],
      cpf: this.formBuilder.control({ value: null, disabled: false }, GenericValidator.isValidCpf()),
      rg: ['', [Validators.required, Validators.minLength(7), Validators.maxLength(7)]],
      telefone: ['', [Validators.required, Validators.minLength(12), Validators.maxLength(12)]],
      dataNascimento: ['', [Validators.required]]
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
    if (this.formulario.valid) {
      var cliente = this.formulario.getRawValue();
      if (this.clienteId) {
        this.editarCliente(cliente);
      } else {
        this.salvarCliente(cliente);
      }
    }
  }
  private salvarCliente(cliente: any) {
    this.clientesService.salvar(cliente).subscribe(
      response => {
        alert("Cadastrado com sucesso!");
        this.listar();
        this.formulario.reset();
        this.displayCreation = false;
      },
      error => {
        alert(error.message);
      }
    );
  }

  private editarCliente(cliente: any) {
    cliente.id = this.clienteId;
    this.clientesService.atualizarCliente(cliente).subscribe(
      response => {
        alert("Editado com sucesso!");
        this.listar();
        this.formulario.reset();
        this.displayCreation = false;
      },
      error => {
        alert(error.message);
      }
    );
  }

  atualizarCliente(clienteId: number) {
    this.clienteId = clienteId;
    this.abrirPopUp()
    this.formulario.controls['cpf'].disable();
    this.formulario.controls['rg'].disable();
    this.clientesService.buscarPorId(clienteId).subscribe(
      res => this.formulario.patchValue(res))
  }

  abrirPopUp() {
    if (this.displayCreation = true) {
      this.formulario.reset();
      this.formulario.controls['cpf'].enable();
      this.formulario.controls['rg'].enable();
    }
  }
  apagarId() {
    console.log(this.clienteId);
    
    this.clienteId = null;

    console.log(this.clienteId);

  }
}