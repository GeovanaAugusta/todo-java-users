package br.com.geovanaaugusta.itau.usuarioservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import br.com.geovanaaugusta.itau.usuarioservice.enums.NotificationPreference;
import br.com.geovanaaugusta.itau.usuarioservice.validation.ValidUser;

/**
 * Entidade que representa um usuário no sistema.
 * 
 * A classe armazena informações como nome, telefone, email e preferências de notificação. 
 * É utilizada para realizar operações de persistência no banco de dados através de JPA.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@ValidUser
public class User {

    /**
     * Identificador único do usuário.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do usuário.
     * Este campo é obrigatório.
     */
    @NotEmpty(message = "Nome é obrigatório")
    private String nome;

    /**
     * Telefone do usuário.
     * Deve conter exatamente 13 dígitos, correspondendo ao formato internacional.
     */
    @Pattern(regexp = "\\d{13}", message = "Telefone inválido")
    private String telefone;

    /**
     * Email do usuário.
     * Deve ser um formato de email válido.
     */
    @Email(message = "Email inválido")
    private String email;

    /**
     * Preferência de notificação do usuário.
     * Pode ser {@link NotificationPreference#EMAIL}, {@link NotificationPreference#SMS} ou {@link NotificationPreference#AMBOS}.
     */
    @Enumerated(EnumType.STRING)
    private NotificationPreference notificationPreference;

}
