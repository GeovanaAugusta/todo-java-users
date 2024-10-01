package br.com.geovanaaugusta.itau.usuarioservice.enums;

/**
 * Enumeração que define as preferências de notificação do usuário.
 * 
 * Os usuários podem escolher entre as seguintes opções de notificação:
 * <ul>
 *   <li>{@link #EMAIL} - Receber notificações por e-mail.</li>
 *   <li>{@link #SMS} - Receber notificações via SMS.</li>
 *   <li>{@link #AMBOS} - Receber notificações tanto por e-mail quanto por SMS.</li>
 * </ul>
 */
public enum NotificationPreference {
    /**
     * Notificações enviadas por e-mail.
     */
    EMAIL,

    /**
     * Notificações enviadas por SMS.
     */
    SMS,

    /**
     * Notificações enviadas tanto por e-mail quanto por SMS.
     */
    AMBOS
}
