package dev.sig.domain.ui;

public class Body {

    private static final Body INSTANCE = new Body();

    private Body(){}

    public static Body getInstance(){
        return INSTANCE;
    }

}
