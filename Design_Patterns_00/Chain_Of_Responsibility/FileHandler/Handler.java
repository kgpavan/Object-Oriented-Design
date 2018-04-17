package design.design_patterns.chainOfResponsibility.FileHandler;

public interface Handler {

    public void setHandler(Handler handler);

    public void process(File file);

    public String getHandlerName();
}
