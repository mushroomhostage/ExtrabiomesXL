package extrabiomes.api;

public interface IPlugin
{
    boolean isEnabled();

    void inject();

    String getName();
}
