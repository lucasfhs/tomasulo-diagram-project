package complements;

public class InstructionQueueElement {
    public Tag elementTag;
    public boolean controlSignalElement;
    public Instruction<?> elementInstruction;

    public InstructionQueueElement(Instruction<?> instruction, Tag tagName, boolean controlSignal){
        this.elementInstruction = instruction;
        this.elementTag = tagName;
        this.controlSignalElement = controlSignal;
        
    }
}
