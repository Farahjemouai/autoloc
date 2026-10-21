package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    Client addClient(Client client);
    Client updateClient(Client client);
    void deleteClient(Long id);
    Optional<Client> getClientById(Long id);
    List<Client> getAllClients();
}
