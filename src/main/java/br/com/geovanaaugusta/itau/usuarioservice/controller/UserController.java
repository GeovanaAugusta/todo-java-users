package br.com.geovanaaugusta.itau.usuarioservice.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.geovanaaugusta.itau.usuarioservice.model.User;
import br.com.geovanaaugusta.itau.usuarioservice.services.UserService;

import java.util.List;

/**
 * Controlador REST para gerenciamento de usuários.
 * 
 * Responsável por expor os endpoints da API para criar, atualizar, listar e deletar usuários.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Retorna uma lista de todos os usuários.
     *
     * @return uma lista de objetos {@link User}
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Retorna os detalhes de um usuário específico com base no ID.
     *
     * @param id o ID do usuário a ser buscado
     * @return uma resposta {@link ResponseEntity} contendo o usuário ou {@code 404 Not Found} se o usuário não existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo usuário.
     *
     * @param user o objeto {@link User} contendo os dados do novo usuário
     * @return o objeto {@link User} criado
     */
    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * Atualiza os detalhes de um usuário existente com base no ID.
     *
     * @param id o ID do usuário a ser atualizado
     * @param user o objeto {@link User} contendo os novos dados do usuário
     * @return uma resposta {@link ResponseEntity} contendo o usuário atualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    /**
     * Deleta um usuário com base no ID.
     *
     * @param id o ID do usuário a ser deletado
     * @return uma resposta {@link ResponseEntity} sem conteúdo ({@code 204 No Content}) após a exclusão bem-sucedida
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
