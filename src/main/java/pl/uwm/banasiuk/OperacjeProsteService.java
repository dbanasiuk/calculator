package pl.uwm.banasiuk;

import org.springframework.stereotype.Service;

@Service
public class OperacjeProsteService {

    public String add(OperationModel model) {
        return okreslWynik("dodawania", (model.getA() + model.getB()));
    }

    public String subtract(OperationModel model) {
        return okreslWynik("odejmowania", (model.getA() - model.getB()));
    }

    public String multiply(OperationModel model) {
        return okreslWynik("mnożenia", (model.getA() * model.getB()));
    }

    public String divide(OperationModel model) {
        if (model.getA() == 0) return okreslWynik("dzielenia", 0);
        if (model.getB() == 0) return "Nie można dzielić przez 0!";
        return okreslWynik("dzielenia", (double) model.getA() / model.getB());
    }

    public OperationModel clearSimple(OperationModel model) {
        model.setA(0);
        model.setB(0);
        return model;
    }

    private String okreslWynik(String metoda, double wartosc) {
        return "Wynik Twojego " + metoda + " to " + wartosc;
    }
}
