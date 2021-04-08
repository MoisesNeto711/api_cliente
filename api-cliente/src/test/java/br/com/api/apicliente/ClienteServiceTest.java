package br.com.api.apicliente;


import br.com.api.apicliente.model.Cliente;
import br.com.api.apicliente.service.ClienteService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    private EasyRandom easyRandom = new EasyRandom();

    @Test
    public void deveRetornarClienteMasculinos(){
        List<Cliente> clientes = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            Cliente cliente = easyRandom.nextObject(Cliente.class);
            clientes.add(cliente);
        }
        clientes.get(2).setSexo("M");

        List<Cliente> clienteList = clienteService.verificarClientesMasculinos(clientes);

        Assertions.assertEquals(0, clienteList.size());
    }
}
