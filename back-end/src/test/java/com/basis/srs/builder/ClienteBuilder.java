package com.basis.srs.builder;
import com.basis.srs.dominio.Cliente;
import com.basis.srs.repositorio.ClienteRepositorio;
import com.basis.srs.servico.ClienteServico;
import com.basis.srs.servico.dto.ClienteDTO;
import com.basis.srs.servico.mapper.ClienteMapper;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteBuilder extends ConstrutorDeEntidade<Cliente>{

    @Autowired
    private ClienteServico clienteServico;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public Cliente construirEntidade() throws ParseException {

        Cliente cliente = new Cliente();
        cliente.setCpf("12345678911");
        cliente.setNome("Lucas");
        cliente.setEmail("Lucas@gmai.com");
        cliente.setEndereco("campina");
        cliente.setRg("1234567");
        cliente.setTelefone("123456789102");
        cliente.setDataNascimento(LocalDate.now().minusDays(500));

        return cliente;
    }

    @Override
    public Cliente persistir(Cliente entidade) {
        ClienteDTO dto = clienteServico.salvar(clienteMapper.toDto(entidade));
        return clienteMapper.toEntity(dto);
    }

    @Override
    public Collection<Cliente> obterTodos() {
        return null;
    }

    @Override
    public Cliente obterPorId(Long id) {
        return null;
    }

    public void limparBanco() {
        clienteRepositorio.deleteAll();
    }
    public Object converterToDto(Cliente cliente) {
        return clienteMapper.toDto(cliente);
    }
}
