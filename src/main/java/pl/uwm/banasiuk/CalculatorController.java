package pl.uwm.banasiuk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {

    private final static String CALCULATOR = "calculator";
    private final static String OPERATION_MODEL = "operationModel";
    private final static String RESULT = "result";


    OperationModel operationModel = new OperationModel();

    @Autowired
    private OperacjeProsteService operacjeProsteService;
    @Autowired
    private OperacjeZlozoneService operacjeZlozoneService;

    @RequestMapping("/")
    public String getCalculatorPage(Model model) {
        model.addAttribute(OPERATION_MODEL, operationModel);
        return CALCULATOR;
    }

    @PostMapping(value = "/", params = "add")
    public String add(@ModelAttribute(OPERATION_MODEL) OperationModel operationModel, Model model) {
        model.addAttribute(RESULT, operacjeProsteService.add(operationModel));
        return CALCULATOR;
    }

    @PostMapping(value = "/", params = "subtract")
    public String subtract(@ModelAttribute(OPERATION_MODEL) OperationModel operationModel, Model model) {
        model.addAttribute(RESULT, operacjeProsteService.subtract(operationModel));
        return CALCULATOR;
    }

    @PostMapping(value = "/", params = "multiply")
    public String multiply(@ModelAttribute(OPERATION_MODEL) OperationModel operationModel, Model model) {
        model.addAttribute(RESULT, operacjeProsteService.multiply(operationModel));
        return CALCULATOR;
    }

    @PostMapping(value = "/", params = "divide")
    public String divide(@ModelAttribute(OPERATION_MODEL) OperationModel operationModel, Model model) {
        model.addAttribute(RESULT, operacjeProsteService.divide(operationModel));
        return CALCULATOR;
    }

    @PostMapping(value = "/", params = "sqrt")
    public String sqrt(@ModelAttribute(OPERATION_MODEL) OperationModel operationModel, Model model) {
        model.addAttribute(RESULT, operacjeZlozoneService.sqrt(operationModel));
        return CALCULATOR;
    }

    @PostMapping(value = "/", params = "power")
    public String power(@ModelAttribute(OPERATION_MODEL) OperationModel operationModel, Model model) {
        model.addAttribute(RESULT, operacjeZlozoneService.power(operationModel));
        return CALCULATOR;
    }

    @PostMapping(value = "/", params = "clearSimple")
    public String clearSimple(@ModelAttribute(OPERATION_MODEL) OperationModel operationModel, Model model) {
        model.addAttribute(OPERATION_MODEL, operacjeProsteService.clearSimple(operationModel));
        model.addAttribute(RESULT, 0);
        return CALCULATOR;
    }

    @PostMapping(value = "/", params = "clearAdvanced")
    public String clearAdvanced(@ModelAttribute(OPERATION_MODEL) OperationModel operationModel, Model model) {
        model.addAttribute(OPERATION_MODEL, operacjeZlozoneService.clearAdvanced(operationModel));
        model.addAttribute("result", 0);
        return CALCULATOR;
    }
}
