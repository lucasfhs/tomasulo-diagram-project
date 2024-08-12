package components;

import java.util.HashMap;
import java.util.Map;

import complements.GenericValue;
import complements.Register;

public class RegisterBank {
    private boolean control;
    private Map<String, Register> registers;

    public RegisterBank() {
        this.control = false;
        registers = new HashMap<>();

        // Inicializando 10 registradores de inteiros (R0, R1, ..., R9)
        for (int i = 0; i < 10; i++) {
            String id = "R" + i;
            registers.put(id, new Register(id, new GenericValue<>(0))); // Valor inicial 0
        }

        // Inicializando 10 registradores de ponto flutuante (F0, F1, ..., F9)
        for (int i = 0; i < 10; i++) {
            String id = "F" + i;
            registers.put(id, new Register(id, new GenericValue<>(0))); // Valor inicial 0.0
        }
    }

    public Register getRegister(String id) {
        return registers.get(id);
    }

    public void setRegisterValue(String id, GenericValue value) {
        if (control) {
            Register reg = registers.get(id);
            if (reg != null) {
                reg.setValue(value);
            }
        }
    }
}
