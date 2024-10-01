package br.com.geovanaaugusta.itau.usuarioservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geovanaaugusta.itau.usuarioservice.model.User;
import br.com.geovanaaugusta.itau.usuarioservice.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável pelas operações de negócio relacionadas à entidade {@link User}.
 * 
 * Este serviço lida com operações como criação, atualização, obtenção e exclusão de usuários.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Retorna a lista de todos os usuários cadastrados.
     * 
     * @return uma lista de {@link User}.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retorna um usuário específico pelo seu ID.
     * 
     * @param id o ID do usuário.
     * @return um {@link Optional} contendo o usuário, caso ele exista.
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Cria um novo usuário e o salva no banco de dados.
     * 
     * @param user os dados do usuário a ser criado.
     * @return o usuário criado e salvo.
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Atualiza os dados de um usuário existente.
     * 
     * @param id o ID do usuário a ser atualizado.
     * @param user os novos dados do usuário.
     * @return o usuário atualizado, ou {@code null} se o usuário não for encontrado.
     */
    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    /**
     * Exclui um usuário pelo seu ID.
     * 
     * @param id o ID do usuário a ser excluído.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
