package homework08.task01;

import homework08.task01.Appliances;

public abstract class ElectricalAppliances extends Appliances {
    private boolean plugged;
    public void plugin(){
        if (plugged) {
            System.out.println("Устройство уже подключено");
        } else {
            plugged = true;
            System.out.println("Подключено");
        }
    }

    @Override
    public void startJob() {
        if (plugged) {
            doProcess();
        } else {
            System.out.println("Устройство не включено в розетку");
        }
    }

    abstract void doProcess();
}
