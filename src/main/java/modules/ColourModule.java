package modules;

import com.google.gson.Gson;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class ColourModule extends AbstractModule {
    @Qualifier
    @Retention(RUNTIME)
    public @interface Message {
    }

    @Qualifier
    @Retention(RUNTIME)
    public @interface Count {
    }


    @Provides
    @Count
    static Integer provideCount() {
        return 9;
    }

    @Provides
    @Message
    static String provideMessage() {
        return "Hello Boss!";
    }

    @Override
    public void configure() {
        bind(Gson.class);
                /*.annotatedWith(Names.named("gson"))
                .to(Gson.class)
                .in(Singleton.class);*/
    }
}
