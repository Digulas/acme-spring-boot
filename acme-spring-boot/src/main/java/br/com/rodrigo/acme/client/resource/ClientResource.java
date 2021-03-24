/**
 * 
 */
package br.com.rodrigo.acme.client.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.rodrigo.acme.client.domain.Client;
import br.com.rodrigo.acme.client.repository.ClientRepository;


@RestController
@RequestMapping("/api/clients")
public class ClientResource {
	
	@Autowired
	private ClientRepository repository;
	

	@PutMapping()
	public void updateClient(@RequestBody Client client, @RequestParam("id") Long id)throws Exception {
		
		this.repository.save(this.repository.findById(id)
			.orElseThrow(()-> 
				new ResponseStatusException(HttpStatus.BAD_REQUEST,"client not found")));
		
		this.repository.save(client);
	}
	
	@GetMapping("/id")
	public Client getClientById(@PathVariable("id") Long id) {
		return repository.findById(id).get();
	}
	
	@DeleteMapping("/(id)")
	public void deleteClient(@PathVariable("id") Long id) {
		this.repository.deleteById(id);
		
	}
	
	@GetMapping
	public List<Client> getAllClients(){
		List<Client> clients = this.repository.findAll();
		return clients;
	}
	
	@PostMapping
	public void createClient(@RequestBody Client client) {
		this.repository.save(client);
	}
}











