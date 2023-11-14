package christmas;

import controller.ChristmasController;
import mapper.ChristmasMapper;
import view.InputView;
import view.OutputView;

public class Application {
    
    public static void main(String[] args) {
        ChristmasController christmasController = new ChristmasController(
                new InputView(), new OutputView(), new ChristmasMapper()
        );
        
        christmasController.startPlanner();
        christmasController.inputOrder();
        christmasController.outputResult();
    }
}
