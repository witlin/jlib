package com.vitek.jlib.challenges;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.NumberFormatException;

/**
 * Checks password complexity. 
 * Introduces a custom implementation of the Builder Design Pattern
 * 
 * @author Victor Smolinski
 */

public class PasswordComplexity {

    private int size;
    private boolean hasSymbols, hasDigits, hasUpperCase;
  
    /**
     * 
     * @param size
     * @param hasSymbols
     * @param hasDigits
     * @param hasUpperCase
     */
    private PasswordComplexity (int size, boolean hasSymbols, boolean hasDigits, boolean hasUpperCase) {
        this.size = size;
        this.hasSymbols = hasSymbols;
        this.hasDigits = hasDigits;
        this.hasUpperCase = hasUpperCase;
    }

    public static class ComplexityBuilder {

        private int size;
        private boolean hasSymbols, hasDigits, hasUpperCase;

        /**
         * 
         * @param size
         * @return
         */
        public ComplexityBuilder ofSize(int size) {
            this.size = size;
            return this;
        }
        /**
         * 
         * @param hasSymbols
         * @return
         */
        public ComplexityBuilder withSymbols (boolean hasSymbols) {
            this.hasSymbols = hasSymbols;
            return this;
        }
        /**
         * 
         * @param hasDigits
         * @return
         */
        public ComplexityBuilder withDigits (boolean hasDigits) {
            this.hasDigits = hasDigits;
            return this;
        }
        /**
         * 
         * @param hasUpperCase
         * @return
         */
        public ComplexityBuilder withUpperCase (boolean hasUpperCase) {
            this.hasUpperCase = hasUpperCase;
            return this;
        }
        /**
         * 
         * @return
         */
        public PasswordComplexity build () {
            return new PasswordComplexity(this.size,
                                          this.hasSymbols,
                                          this.hasDigits,
                                          this.hasUpperCase);
        }
        /**
         * 
         * @return
         */
        public static ComplexityBuilder builder () {
            return new ComplexityBuilder();
        }
    }

    public boolean isComplex (String password) {
        return password.length() >= 12 &&
                password.matches(".*\\d.*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\W.*");
    }

    public String toString(){
        try {
            return "Password Configuration"+
                    "\n\tRequired Size: "+ String.valueOf(size)
                    .concat("\n\tDoes it need Symbols: "+ String.valueOf(hasSymbols)
                    .concat("\n\tDoes it need Numbers: "+ String.valueOf(hasDigits)
                    .concat("\n\tDoes it need to have Uppercase letters: "+ String.valueOf(hasUpperCase))));
        } catch (NumberFormatException nfe) {
            System.err.println(nfe.getLocalizedMessage());
        }
        return super.toString();
    }

    public void run() {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter password: ");
            String in = r.readLine();
            System.out.println("Is password most secure...? "
                               .concat(String
                               .valueOf(this.isComplex(in))));
        } catch(Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}