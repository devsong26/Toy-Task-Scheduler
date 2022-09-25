package dev.sig.domain.ui;

public class Header {

    private static final Header INSTANCE = new Header();

    private Header(){}

    public static Header getInstance(){
        return INSTANCE;
    }

}
