package br.com.geovanaaugusta.itau.usuarioservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.geovanaaugusta.itau.usuarioservice.model.User;

/**
 * Repositório responsável pelas operações de persistência da entidade {@link User}.
 * 
 * Esta interface herda de {@link JpaRepository}, fornecendo métodos padrão para operações 
 * de CRUD (Create, Read, Update, Delete) no banco de dados.
 * 
 * A anotação {@link Repository} indica que esta interface é um componente do Spring 
 * e pode ser injetada em outros lugares do código.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
