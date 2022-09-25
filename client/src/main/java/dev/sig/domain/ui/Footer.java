package dev.sig.domain.ui;

public class Footer {

    private static final Footer INSTANCE = new Footer();

    private Footer(){}

    public static Footer getInstance(){
        return INSTANCE;
    }

}
