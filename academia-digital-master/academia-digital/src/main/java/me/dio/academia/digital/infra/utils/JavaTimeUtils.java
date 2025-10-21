package me.dio.academia.digital.infra.utils;

import java.time.format.DateTimeFormatter;

/**
 * Classe de utilidades para formatação de data e hora.
 * O construtor é privado para evitar que a classe seja instanciada.
 */
public final class JavaTimeUtils {

    private JavaTimeUtils() {
    }

    public static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

}