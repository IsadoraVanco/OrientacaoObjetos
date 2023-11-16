package Exemplos.InterfaceGrafica.JavaFX;

//Teste utilizando JavaFX

//Instruções para utilizar no IntelliJ:
// 1. Baixar JavaFX pelo site oficial
// 2. Adicionar a pasta descompactada que foi baixada em uma pasta que VÀ ENCONTRAR
// 3. Adicionar a pasta nas libraries do IntelliJ (file->project structure->libraries)
// 4. Modificar as configurações de execução (run->edit configurations->modify options->VM options) para
// --module-path "caminhodapastadescompactadaate\lib" --add-modules javafx.controls,javafx.fxml

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Text text = new Text("Hello, world!");
        Button button = new Button("Click me!");
        StackPane root = new StackPane();
        root.getChildren().add(button);
        root.getChildren().add(text);
        Scene scene = new Scene(root, 400, 350);
        primaryStage.setTitle("Simple Window");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

