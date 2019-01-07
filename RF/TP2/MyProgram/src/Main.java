import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        // TODO : condition to get files.
        // ... and...
        // TODO : condition to get c.
        // TODO : condition to get g.
        // ... or...
        // TODO : guess the best options c and g.

        // TODO : call the training.
        svm_train.main();

        // TODO : call the test.
        String predict[] = [5];
        predict[0] = "-c";
        predict[1] = "1"; // TODO.
        predict[2] = "-g ";
        predict[3] = "1"; // TODO.
        predict[4] = "PATH"; // TODO.

        try {
            svm_predict.main(predict);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // TODO : print c and g.
        // TODO : print the accuracy.
    }
}
