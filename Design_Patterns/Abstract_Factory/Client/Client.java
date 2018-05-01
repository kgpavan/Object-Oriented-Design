
/**
 * In this example, provides an interface for creating PC devices without
 * specifying their concrete classes. Pattern is implemented by creating an
 * abstract class AbstractFactory, which is an interface for creating
 * different system components (heirs of CPU and MMU). Then write classes
 * that implement this interface(EmberToolkit and EnginolaToolkit).
 */

abstract class CPU {}

class EmberCPU extends CPU {}

class EnginolaCPU extends CPU {}

abstract class MMU {}

class EmberMMU extends MMU {}

class EnginolaMMU extends MMU {}


class EmberToolkit extends AbstractFactory {

    @Override
    public CPU createCPU() {
        return new EmberCPU();
    }

    @Override
    public MMU createMMU() {
        return new EmberMMU();
    }
}

class EnginolaToolkit extends AbstractFactory {
    @Override
    public CPU createCPU() {
        return new EnginolaCPU();
    }

    @Override
    public MMU createMMU() {
        return new EnginolaMMU();
    }
}

enum Architecture {
    ENGINOLA, EMBER
}

abstract class AbstractFactory {

    private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
    private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();

    // Returns a concrete factory object that is an instance of the
    // concrete factory class appropriate for the given architecture.
    static AbstractFactory getFactory(Architecture architecture) {
    
        AbstractFactory factory = null;
    
        switch (architecture) {
            case ENGINOLA:
                factory = ENGINOLA_TOOLKIT;
            case EMBER:
                factory = EMBER_TOOLKIT;
        }
        return factory;
    }

    public abstract CPU createCPU();

    public abstract MMU createMMU();
}



public class Client {

    public static void main(String[] args) {

        AbstractFactory factory = AbstractFactory.getFactory(Architecture.EMBER);
        CPU cpu = factory.createCPU();
    }
}
