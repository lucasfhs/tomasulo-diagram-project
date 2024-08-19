package components;

import complements.Address;
import complements.MemoryInstruction;
import complements.UnitControlBranchWire;
import complements.Wire;

public class ProgramCounter {
    // Endereço da instrução atual
    private Address currentAddressUnit;
    // Fio que Liga a memoria de instruções
    private Wire instructionMemoryWire;
    // Fio que liga a unidade que controla os desvios com o PC
    private UnitControlBranchWire addressBranchWire;

    public void behavior(){
        // Se o sinal que indica que uma instrução de desvio foi realizada 
        // O sinal autoriza o PC atualizar para o endereco da instrução de desvio
        // Caso contrario o programa segue no fluxo habitual.
        if(addressBranchWire.reciveControlSignal() == true){
            // Caso o desvio seja tomado atualiza o endereço com o endereço do desvio
            currentAddressUnit = addressBranchWire.reciveAddressBranch();
            // Envia para memoria de instruções o endereço do desvio
            instructionMemoryWire.sendData(currentAddressUnit);
        }else{
            // Envia para a memoria de instruções o endereço da instrucao atual
            instructionMemoryWire.sendData(currentAddressUnit);
            // Realiza PC + 1 preparando para no proximo ciclo enviar a proxima instrucao.
            currentAddressUnit = currentAddressUnit.nextInstruction();
        }
    }

}
