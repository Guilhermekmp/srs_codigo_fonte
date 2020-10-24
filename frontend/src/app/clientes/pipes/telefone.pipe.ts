import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'TELEFONE'
})
export class TELEFONEPipe implements PipeTransform {
  transform(value: string, ...args: any[]): any {
    if (value.length === 12) {
      return value.replace(/(\d{3})?(\d{5})?(\d{4})/, '($1) $2-$3');
    }
    return 'error';
  }
}