package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dominio.Abrigo;

public class AbrigoController {

	
    public static void validar(Abrigo abrigo) throws IllegalArgumentException {
        if (abrigo.getNome() == null || abrigo.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode estar vazio.");
        }
        
        if (abrigo.getEndereco() == null || abrigo.getEndereco().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode estar vazio.");
        }
        
        if (abrigo.getEmail() == null || !validaEmail(abrigo.getEmail())) {
            throw new IllegalArgumentException("Email inválido.");
        }

        if (abrigo.getCapacidade() <= 0) {
            throw new IllegalArgumentException("Capacidade deve ser maior que zero.");
        }

        if (abrigo.getOcupacao() == null || abrigo.getOcupacao().isEmpty()) {
            throw new IllegalArgumentException("Ocupação não pode estar vazia.");
        }

        if (abrigo.getResponsavel() == null || abrigo.getResponsavel().isEmpty()) {
            throw new IllegalArgumentException("Responsável não pode estar vazio.");
        }

        if (abrigo.getTelefone() == null || !validaTelefone(abrigo.getTelefone())) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
    }

    private static boolean validaEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean validaTelefone(String telefone) {
        String phoneRegex = "^[0-9]{10,11}$"; 
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(telefone);
        return matcher.matches();
    }
}
