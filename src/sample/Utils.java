package sample;

import javafx.scene.control.Alert;

/**
 * Created by Lenovo on 17.07.2017.
 */
public class Utils {
        public static void createDialog(String title, String header, String content){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(title);
            alert.setContentText(content);
            alert.setHeaderText(header);
            alert.show();
        }
}
