interface Switchable {
    void on();
    void off();

    default void toggle() {
        on();
    }
}

class Fan implements Switchable {
    public void on() {
        System.out.println("Fan is ON");
    }

    public void off() {
        System.out.println("Fan is OFF");
    }
}

class Light implements Switchable {
    public void on() {
        System.out.println("Light is ON");
    }

    public void off() {
        System.out.println("Light is OFF");
    }
}
interface SwitchPolicy {
    boolean maySwitchOn(Switchable device, int hour);
}

public class Remote_Control {
    public static void main(String[] args) {

        Switchable[] devices = {
            new Fan(),
            new Light()
        };

        for (Switchable device : devices) {
            device.toggle();
        }

        SwitchPolicy policy1 = new SwitchPolicy() {
            public boolean maySwitchOn(Switchable device, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

        SwitchPolicy policy2 = (device, hour) -> hour >= 6 && hour <= 22;

        int hour = 20;

        System.out.println("\nUsing Anonymous Class:");
        for (Switchable device : devices) {
            System.out.println(
                policy1.maySwitchOn(device, hour)
                ? "Device can be switched ON"
                : "Device cannot be switched ON"
            );
        }

        System.out.println("\nUsing Lambda:");
        for (Switchable device : devices) {
            System.out.println(
                policy2.maySwitchOn(device, hour)
                ? "Device can be switched ON"
                : "Device cannot be switched ON"
            );
        }
    }
}