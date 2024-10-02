package app.service;

import app.entity.Client;
import app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public String saveClient(Client client){
        this.clientRepository.save(client);
        return (
                "Cliente " + client.getName() + " salvo com sucesso!"
        );
    }

    public List<Client> findAllClients(){
        return this.clientRepository.findAll();
    }

    public Client findClientById(Long id){
        return this.clientRepository.findById(id).get();
    }

    public String updateClient(Long id, Client client){
        client.setId(id);
        this.clientRepository.save(client);
        return (
                "Cliente " + client.getName() + " atualizado com sucesso!"
        );
    }

    public String deleteClient(Long id){
        this.clientRepository.deleteById(id);
        return (
                "Cliente com id " + id + " deletado com sucesso"
        );
    }
}
