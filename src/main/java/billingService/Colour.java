package billingService;

import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import modules.ColourModule;
import modules.ColourModule.Count;
import modules.ColourModule.Message;

public class Colour {

    private Integer count;
    private String message;

    @Inject
    //@Named("gson")
    private Gson gson;

    @Inject
    Colour(@Count Integer count, @Message String message) {
        this.count = count;
        this.message = message;
    }

    void sayHello(){
        for(int i =0; i< count; i++) {
            System.out.println(message);
        }
        int[] a = {0,1,2,3,4};
        System.out.println(gson.toJson(a));
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ColourModule());
        Colour colour = injector.getInstance(Colour.class);

        colour.sayHello();
    }
}
