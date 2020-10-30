package uitask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskDemo extends Application {
    private final TextArea content = new TextArea("");
    private final Label status = new Label();
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private Task<Integer> task;
    private final Button open = new Button("Open");
    private final Button cancel = new Button("Cancel");
    
    public void start(Stage stage) {
        open.setOnAction(event -> read(stage));
        cancel.setOnAction(event ->
        {
            if (task != null) {
                task.cancel();
            }
        });
        cancel.setDisable(true);
        stage.setOnCloseRequest(event ->
        {
            if (task != null) {
                task.cancel();
            }
            executor.shutdown();
            Platform.exit();
        });
        
        HBox box = new HBox(10, open, cancel);
        VBox pane = new VBox(10, content, box, status);
        pane.setPadding(new Insets(10));
        stage.setScene(new Scene(pane));
        stage.setTitle("TaskDemo");
        stage.show();
    }
    
    private void read(Stage stage) {
        if (task != null) {
            return;
        }
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File(".."));
        File file = chooser.showOpenDialog(stage);
        if (file == null) {
            return;
        }
        content.setText("");
        task = new Task<>() {
            public Integer call() {
                int lines = 0;
                try (Scanner in = new Scanner(file, StandardCharsets.UTF_8)) {
                    while (!isCancelled() && in.hasNextLine()) {
                        Thread.sleep(10); // Simulate work
                        String line = in.nextLine();
                        Platform.runLater(() ->
                                content.appendText(line + "\n"));
                        lines++;
                        updateMessage(lines + " lines read");
                    }
                } catch (InterruptedException e) {
                    // Task was canceled in sleep
                } catch (IOException e) {
                    throw new UncheckedIOException(null, e);
                }
                return lines;
            }
        };
        executor.execute(task);
        task.setOnScheduled(event ->
        {
            cancel.setDisable(false);
            open.setDisable(true);
        });
        task.setOnRunning(event ->
        {
            status.setText("Running");
            status.textProperty().bind(task.messageProperty());
        });
        task.setOnFailed(event ->
        {
            cancel.setDisable(true);
            status.textProperty().unbind();
            status.setText("Failed due to " + task.getException());
            task = null;
            open.setDisable(false);
        });
        task.setOnCancelled(event ->
        {
            cancel.setDisable(true);
            status.textProperty().unbind();
            status.setText("Canceled");
            task = null;
            open.setDisable(false);
        });
        task.setOnSucceeded(event ->
        {
            cancel.setDisable(true);
            status.textProperty().unbind();
            status.setText("Done reading " + task.getValue() + " lines");
            task = null;
            open.setDisable(false);
        });
    }
}
