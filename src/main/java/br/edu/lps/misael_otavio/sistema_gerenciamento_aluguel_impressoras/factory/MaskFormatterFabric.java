package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory;

import org.slf4j.Logger;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class MaskFormatterFabric {
    public static MaskFormatter getMaskFormatter(String pattern) throws ParseException {
        MaskFormatter mask = new MaskFormatter(pattern);
        mask.setPlaceholderCharacter('_');
        mask.setAllowsInvalid(false);
        mask.setOverwriteMode(true);
        return mask;
    }
}
