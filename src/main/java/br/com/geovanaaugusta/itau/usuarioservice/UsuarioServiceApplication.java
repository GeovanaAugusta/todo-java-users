package br.com.geovanaaugusta.itau.usuarioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal do serviço de gerenciamento de usuários.
 * 
 * Esta classe inicializa a aplicação Spring Boot para o serviço de usuários, que oferece
 * funcionalidades de criação, leitura, atualização e exclusão de usuários.
 * 
 * O método {@link #main(String[])} é o ponto de entrada da aplicação.
 */
@SpringBootApplication
public class UsuarioServiceApplication {

    /**
     * Ponto de entrada da aplicação Spring Boot.
     * 
     * Este método inicia o contexto Spring e carrega todas as configurações da aplicação.
     * 
     * @param args argumentos de linha de comando.
     */
    public static void main(String[] args) {
        SpringApplication.run(UsuarioServiceApplication.class, args);
    }

}
