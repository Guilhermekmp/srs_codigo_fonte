import { SalaEquipamento } from './sala-equipamento';
export class Sala{
    id:number;
    descricao: String;
    idTipoSala: number;
    precoDiario:number;
    capacidade: number;
    equipamentos: SalaEquipamento[] = [];
}