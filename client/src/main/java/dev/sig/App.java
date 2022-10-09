package dev.sig;

import dev.sig.framework.container.IocContainer;

public class App {

    public static void main(String[] args){
        init();
        run();
    }

    private static void init() {
        IocContainer.getInstance().init();
    }

    private static void run() {
    }

}
