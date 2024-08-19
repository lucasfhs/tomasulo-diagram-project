package complements;
public class Instruction<T> {
    private TomasuloOperation value; // Esse campo representa a operacao da instrução Ex: ADD
    private String firstOperand; // Representa a indentificacao (id) do  primeiro registrador Ex: F1, R1
    private String secondOperand;  // Representa a indentificacao (id) do  segundo registrador Ex: F1, R1
    private String thirdOperand; //  Representa a indentificacao (id) do  terceiro (caso houver) registrador Ex: F1, R1


    public TomasuloOperation getValue() {
        return value;
    }

    public Instruction(TomasuloOperation value) {
        this.value = value;
    }
}

