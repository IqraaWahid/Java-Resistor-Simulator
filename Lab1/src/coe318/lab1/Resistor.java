/**
 * A Resistor models an ideal resistor that obeys Ohm's Law.
 *
 * @author Iqraa Wahid
 */
package coe318.lab1;

public class Resistor {
    private double resistance_val, voltage_val; //setting two private and double instance variables
   
    /**
     * Create an ideal Resistor. The initial current through and voltage across
     * the Resistor are zero.
     *
     * @param resistance resistance in Ohms
     */
    public Resistor(double resistance) {
        resistance_val = resistance; //When the object is created, this constructor is called, and it sets an initial value of the state variable 'resistance_val' (the initial value set is the constructor's parameter value)
    }
   
    /**
     * Returns the value of the resistor in Ohms.
     *
     * @return the resistance
     */
    public double getResistance() {
        return resistance_val;
    }
   
    /**
     * Returns the voltage across the resistor.
     *
     * @return the voltage
     */
    public double getVoltage() {
        return voltage_val;
    }
   
    /**
     * Sets the value of the voltage across the resistor.
     *
     * @param voltage the voltage to set
     */
    public void setVoltage(double voltage) {
        //FIX THIS. Only set the voltage value if the parameter is between 50 and -50, otherwise print an error message.
        if(voltage<=50 && voltage>=-50){
            voltage_val=voltage;
        }
        else{
            System.out.println("Error: Voltage value beyond limit");
        }
    }
   
    /**
     * Returns the current through the Resistor.
     *
     * @return the current
     */
    public double getCurrent() {
        return voltage_val/resistance_val; //return the value of the current, since there is no instance variable for the current, we can return the value of the current by simply, according to Ohm's Law, divide voltage_val by resistance_val (I=V/R)
    }
   
    /**
     * Sets the value of the current through the resistor.
     *
     * @param current the current to set
     */
    public void setCurrent(double current) {
        //Only set the current value if the parameter is between 5 and -5, otherwise print an error message.
        if(current>=-5 && current<=5){
            voltage_val = current*resistance_val;//since we can only use two instance variables, change the voltage_val's value to the ratio of given current to given resistance; this would allow current and resistor to be the value they need to be, while satisfying Ohm's Law
        }
        else{
            System.out.println("Error: Current value beyond limit");
        }
    }
   
    /**
     * Returns the power (in Watts) dissipated by the Resistor.
     *
     * @return the power
     */
    public double getPower() {
        return getCurrent()*voltage_val;//P=I*V <-- value of current will be obtained by calling the getCurrent() function which will return the value of the current
    }
   
    /**
     * A simple example of using a Resistor.
     * <p>
     * The output should be:
     * <pre>
     * Creating a 50 Ohm resistor (r1)
     * Its resistance is 50.0 Ohms
     * Its current is 0.0 Amps
     * Its voltage is 0.0 Volts
     * * Its power is 0.0 Watts
     * Creating a 100 Ohm resistor (r2)
     * Its resistance is 100.0 Ohms
     * Setting r1's current to 10 Amps
     * Error: current value beyond limit
     * Setting r1's current to 2 Amps
     * Its current is 2.0 Amps
     * Its voltage is 100.0 Volts
     * Its power is 200.0 Watts
     * Setting r1's voltage to 90 Volts
     * Error: voltage value beyond limit
     * Setting r1's voltage to 50 Volts
     * Its current is 1.0 Amps
     * Setting r2's current to 3 Amps
     * Its voltage is 300.0 Volts
     * </pre>
     *
     * @param args (Command line arguments not used.)
     */
    public static void main(String[] args) {
        Resistor r1, r2;
        System.out.println("Creating a 50 Ohm resistor (r1)");
        r1 = new Resistor(50.0);
        System.out.println("Its resistance is " + r1.getResistance() + " Ohms");
        System.out.println("Its current is " + r1.getCurrent() + " Amps");
        System.out.println("Its voltage is " + r1.getVoltage() + " Volts");
        System.out.println("Its power is " + r1.getPower() + " Watts");
        System.out.println("Creating a 100 Ohm resistor (r2)");
        r2 = new Resistor(100.0);
        System.out.println("Its resistance is " + r2.getResistance() + " Ohms");
        System.out.println("Setting r1's current to 10 Amps");
        r1.setCurrent(10.0);
        System.out.println("Setting r1's current to 2 Amps");//We want current to be 2A
        r1.setCurrent(2.0);
        System.out.println("Its current is " + r1.getCurrent() + " Amps");
        System.out.println("Its voltage is " + r1.getVoltage() + " Volts");
        System.out.println("Its power is " + r1.getPower() + " Watts");
        System.out.println("Setting r1's voltage to 90 Volts");
        r1.setVoltage(90.0);
        System.out.println("Setting r1's voltage to 50 Volts");
        r1.setVoltage(50.0);
        System.out.println("Its current is " + r1.getCurrent() + " Amps");
        System.out.println("Setting r2's current to 3 Amps");
        r2.setCurrent(3.0);
        System.out.println("Its voltage is " + r2.getVoltage() + " Volts");
    }
}