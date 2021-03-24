/**
 * 
 */
package br.com.rodrigo.acme.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigo.acme.client.domain.Client;

/**
 * @author rodrigo
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
