package br.com.geovanaaugusta.itau.usuarioservice.validation;

import br.com.geovanaaugusta.itau.usuarioservice.enums.NotificationPreference;
import br.com.geovanaaugusta.itau.usuarioservice.model.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validador customizado para a entidade {@link User}.
 * 
 * A validação garante que, dependendo das preferências de notificação, o
 * usuário forneça o email e/ou telefone. 
 * Se o usuário escolher receber notificações por EMAIL, deve fornecer um email válido. 
 * Se escolher receber por SMS, deve fornecer um telefone válido. 
 * Se escolher AMBOS, ambos devem ser fornecidos.
 */
public class UserValidator implements ConstraintValidator<ValidUser, User> {

    /**
     * Valida os campos de um usuário com base nas suas preferências de notificação.
     * 
     * @param user O objeto {@link User} a ser validado.
     * @param context O contexto da validação, onde podem ser adicionadas mensagens personalizadas de erro.
     * @return {@code true} se o usuário for válido, {@code false} caso contrário.
     */
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        boolean hasEmail = user.getEmail() != null && !user.getEmail().isEmpty();
        boolean hasPhone = user.getTelefone() != null && !user.getTelefone().isEmpty();

        // Valida se ao menos um meio de contato foi fornecido (email ou telefone)
        if (!hasEmail && !hasPhone) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Usuário deve fornecer email ou telefone")
                    .addConstraintViolation();
            return false;
        }

        // Valida se a preferência de EMAIL foi selecionada, mas o email não foi fornecido
        if (user.getNotificationPreference() == NotificationPreference.EMAIL && !hasEmail) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Para receber notificações por EMAIL, um email válido deve ser fornecido")
                    .addConstraintViolation();
            return false;
        }

        // Valida se a preferência de SMS foi selecionada, mas o telefone não foi fornecido
        if (user.getNotificationPreference() == NotificationPreference.SMS && !hasPhone) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Para receber notificações por SMS, um telefone válido deve ser fornecido")
                    .addConstraintViolation();
            return false;
        }

        // Valida se a preferência de AMBOS foi selecionada, mas tanto o email quanto o telefone não foram fornecidos
        if (user.getNotificationPreference() == NotificationPreference.AMBOS && (!hasEmail || !hasPhone)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Para receber notificações por AMBOS, email e telefone devem ser fornecidos")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
