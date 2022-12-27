package nordigen.api;

import nordigen.api.rest.NordigenRestApi;

public abstract class NordigenApiFactory {

    //Default Rest Interface
    private static NordigenApiFactory realFactoryInstance = new NordigenApiFactory() {
        @Override
        protected NordigenApi create() {
            return new NordigenRestApi("9f841497-4b19-42f7-87ec-d0236ab9c906", "7a8092e9115853ce6fece74d7203630bc1a7a580cb84c438a871d992fcfd0c10f656741bd9811f07c9819945e671201aa5038e10f4dca42b1a4c956a513b5653");
        }
    };

    public static NordigenApiFactory getInstance() {

        if(realFactoryInstance==null) {
            throw new RuntimeException("No real api factory has been configured");
        }

        return realFactoryInstance;
    }

    public static void setFactory(NordigenApiFactory factory) {
        realFactoryInstance = factory;
    }

    public static NordigenApi getApi() {
        return getInstance().create();
    }

    protected abstract NordigenApi create();
}
