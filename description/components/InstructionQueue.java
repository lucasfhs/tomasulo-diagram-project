package components;

import java.util.ArrayList;
import java.util.HashMap;

import complements.Instruction;
import complements.InstructionQueueElement;
import complements.MemoryInstructionWire;
import complements.Tag;
import complements.UnitControlBranchWire;
import complements.Wire;


public class InstructionQueue {
    // Fio que vem da memoria de instruções
    public MemoryInstructionWire memoryInstructionWire;
    // Fila de instrucoes propriamente dita
    public ArrayList<InstructionQueueElement> instructionQueue = new ArrayList<>();
    // Fio que liga a unidade de despacho e decodificacao
    public UnitControlBranchWire dispatchAndDecodeUnitWire;


    public InstructionQueue(){
    // Classe que existe por fins de completude
    // Especifica que a fila de instruções possui um tamanho e que os dados são inicializados e indicados
    // Com ControlSignal = false, demonstrando que é uma posição que não possui um dado válido e pode ser sobrescrita.
        for(int i = 0; i < 127; i++){
            instructionQueue.add(new InstructionQueueElement(null, new Tag( instructionQueue.size() + 1), false));
        }
        
    }

    public void behavior(){
        // Insere a instrucao adquirida da memoria de instrucoes na fila (em ordem)
        Instruction<?> instructionFromMemory =  memoryInstructionWire.reciveDataMemory();
        // Procura uma posicao livre na fila de instrucoes para colocar o dado vindo
        // Da memoria de instrucoes na fila
        for(InstructionQueueElement i : instructionQueue){
            if(i.controlSignalElement == false){
                i.elementInstruction = instructionFromMemory;
                i.controlSignalElement = true;
            }
        }
        // A unidade de despacho pode enviar um sinal indicando que a instrucao nao deve ser despachada
        if(dispatchAndDecodeUnitWire.reciveControlSignal() == true){
            // Caso o despacho seja possivel a instrucao é enviada em ordem para a unidade de despacho
            // e decodificao
            dispatchAndDecodeUnitWire.sendData(instructionQueue.getFirst());
            // Apos o despacho ela sai da fila em ordem
            // Para remover o item da fila de instrucoes definimos seu sinal de controle como false
            // Indicando que aquela nao é mais uma posicao valida e pode ser sobrescrita
            instructionQueue.getFirst().controlSignalElement = false;
        }
        // Caso o sinal de controle indique um atraso no despacho ele nao executa o procedimento
        // Supracitado.

    }

    
}
