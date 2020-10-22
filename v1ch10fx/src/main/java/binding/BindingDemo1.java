package binding;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * @author Cay Horstmann
 * @version 1.0 2017-12-29
 */
public class BindingDemo1 extends Application {
    public void start(Stage stage) {
        TextArea shipping = new TextArea();
        TextArea billing = new TextArea();
        billing.textProperty().bindBidirectional(shipping.textProperty());
        VBox root = new VBox(
                new Label("Shipping"), shipping,
                new Label("Billing"), billing);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
