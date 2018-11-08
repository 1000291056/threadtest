package threadtest.draggers;

import dagger.Provides;

@dagger.Module
public class Module {
    @Provides
    Person providerPerson(){
        return new Person();
    }
}
