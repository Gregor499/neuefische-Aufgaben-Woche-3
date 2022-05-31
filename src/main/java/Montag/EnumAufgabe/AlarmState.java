package Montag.EnumAufgabe;

public enum AlarmState {
    ROT(0),
    GELB(30),
    GRÜN(60);
private int maxNumbersOfCustomers;

AlarmState(int maxNumbersOfCustomers){
    this.maxNumbersOfCustomers = maxNumbersOfCustomers;

}

/*    private static String checkCustomers(int numberOfCustomers, int maxNumberOfCustomers) {
        if (numberOfCustomers > maxNumberOfCustomers) {
            return WARNING_MESSAGE;
        }
        return OK_MESSAGE;
    }*/
}
