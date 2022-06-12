package pl.uwm.banasiuk;

import org.springframework.stereotype.Service;

@Service
public class OperacjeZlozoneService {

    public String sqrt(OperationModel model) {
        return okreslWynik("pierwiastkowania", Math.sqrt(model.getC()));
    }

    public String power(OperationModel model) {
        return okreslWynik("potęgowania", model.getC() * model.getC());
    }

    public OperationModel clearAdvanced(OperationModel model) {
        model.setC(0);
        return model;
    }

    private String okreslWynik(String metoda, double wartosc) {
        return "Wynik Twojego " + metoda + " to " + wartosc;
    }
}
