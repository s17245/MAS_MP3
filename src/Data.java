
import javafx.beans.binding.Bindings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Data {

    private LocalDateTime timeStamp = LocalDateTime.now();;
    private DateTimeFormatter form;

    //private static final long serialVersionUID = 4156247124576225208L;
    public Data() {



        this.timeStamp = LocalDateTime.now();
        this.form = DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    @Override
    public String toString() {

        return timeStamp.format(this.form).toString();

    }
}
