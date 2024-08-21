package components;

import complements.Address;
import complements.Instruction;
import complements.ProgramCounterWire;
import complements.Wire;

public class MemoryInstruction {
    public Instruction<?>[] instructionsOnMemory;
    // Fio que Liga a memoria de instruções
    public Wire instructionQueueWire;
    // Fio que liga a unidade de controle que possui o programcounter
    public ProgramCounterWire unitControlProgramCounter;

    public void behavior(){
        // Recebe o endereço da proxima instrução pelo program Counter
        Address programCounterAddress =  unitControlProgramCounter.reciveAddress();
        // Busca a instrução na memoria
        Instruction<?> instructionForQueue = instructionsOnMemory[programCounterAddress.tag()];
        // Envia a instrucao para a fila
        instructionQueueWire.sendData(instructionForQueue);
    }
}


