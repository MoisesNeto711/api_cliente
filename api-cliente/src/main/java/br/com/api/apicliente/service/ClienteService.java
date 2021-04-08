package br.com.api.apicliente.service;

import br.com.api.apicliente.model.Cliente;
import br.com.api.apicliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
  @Autowired
  private ClienteRepository clienteRepository;//injetando repotório dentro do serviço

  public Cliente getCliente(Long id) {
    return clienteRepository.findById(id).get();//retornar objeto opcional que pode conter um cliente, chama o get pra ver
  }

  public List<Cliente> getClientes(){//para ver todos os cliente não necessito de parâmetro
    return clienteRepository.findAll();//Retorna uma lista de clientes com o findAll
  }
  public Cliente salvarCliente(Cliente cliente){//objeto cliente sem retorno, pois é só salvar.
    clienteRepository.save(cliente);//salvando meu cliente
    return cliente;
  }
  public boolean deletarCliente(Long id){//retorna um boleano
    clienteRepository.delete(getCliente(id));// chamando o método de visualização acima
    return true;// retorna verdadeiro
  }
  public Cliente putCliente(Long id, Cliente clienteValoresNovo){//tipo de identificação e tipo com novos valores
    Cliente cliente = getCliente(id);//retorno após visualizar
    cliente.setIdade(clienteValoresNovo.getIdade());//atualize meu cliente vendo a idade recebida
    cliente.setNome(clienteValoresNovo.getNome());//atualize meu cliente vendo  nome recebido
    return clienteRepository.saveAndFlush(cliente);
  }
  public int somaIdadesMulheres(){
    List<Cliente> clienteList = getClientes();
    int somaIdade = 0;
    for (Cliente cliente:clienteList){
      if(cliente.getSexo().equals("F")){
        somaIdade += cliente.getIdade();
      }
    }
    return somaIdade;
  }


}
