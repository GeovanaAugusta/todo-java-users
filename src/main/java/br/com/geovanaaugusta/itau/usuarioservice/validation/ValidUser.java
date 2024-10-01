package br.com.geovanaaugusta.itau.usuarioservice.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação customizada para validar a entidade {@link br.com.geovanaaugusta.itau.usuarioservice.model.User}.
 * 
 * Esta anotação aplica a validação da classe {@link UserValidator}, que verifica se os campos de 
 * email ou telefone estão corretamente preenchidos de acordo com as preferências de notificação.
 * 
 * @see UserValidator
 */
@Constraint(validatedBy = UserValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUser {

    /**
     * Mensagem de erro padrão que será exibida caso a validação falhe.
     * 
     * @return a mensagem de erro padrão.
     */
    String message() default "Usuário inválido";

    /**
     * Permite a especificação de grupos de validação personalizados.
     * 
     * @return os grupos de validação.
     */
    Class<?>[] groups() default {};

    /**
     * Define informações adicionais de payload que podem ser passadas junto com a anotação de validação.
     * 
     * @return o payload adicional.
     */
    Class<? extends Payload>[] payload() default {};
}
