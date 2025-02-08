package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerSingleton {
    private static Logger logger;

    private LoggerSingleton() {
    }

    public static synchronized Logger getLogger(Class<?> clazz) {
        if (logger == null) {
            logger = LoggerFactory.getLogger(clazz);
        }
        return logger;
    }
}
