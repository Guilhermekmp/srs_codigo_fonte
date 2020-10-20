export interface Sala{
    id:number;
    descricao: String,
    idTipoSala: number
    precoDiario:number,
    disponivel: number,
    capacidade: number,
    equipamentos: any[]
}