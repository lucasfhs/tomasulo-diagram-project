package components;
import java.util.HashMap;

import complements.Instruction;

public class InstructionQueue {

    private boolean control; // Sinal de controle que determina se a fila pode continuar avançando.
    private HashMap<String, Instruction<?>> queue; // Estrutura que armazena as instruções na fila. Cada entrada
                                                   // associa uma tag textual (ex: "01") à uma instrução (ex: Add).
    private int currentQueueId = -1; // Identificador da posição atual na fila. Inicia em -1 indicando que nenhuma
                                     // instrução foi processada.

    // Construtor que inicializa a fila e o controle.
    public InstructionQueue() {
        this.control = false; // Control inicializado como falso, desabilitando o avanço da fila.
        this.queue = new HashMap<>(); // Inicializa a fila como um HashMap vazio.
    }

    // Método para adicionar uma nova instrução à fila.
    public void addQueueElement(String tag, Instruction<?> instruction) {
        queue.put(tag, instruction); // Insere a instrução na fila associada à sua respectiva tag.
    }

    // Método para obter a próxima instrução na fila.
    public Instruction<?> proxQueueElement() throws Exception {
        Instruction<?> proxInstruction = null; // Inicializa a variável que armazenará a próxima instrução.
        if (control) { // Verifica se o sinal de controle permite o avanço da fila.
            // Despacho em ordem: tenta recuperar a próxima instrução na sequência numérica.
            proxInstruction = queue.get(String.valueOf(currentQueueId + 1));
            if (proxInstruction != null) {
                currentQueueId++; // Atualiza o ID atual para o próximo na sequência.
                return proxInstruction; // Retorna a próxima instrução.
            } else {
                throw new Exception("No next instruction found in the queue."); // Exceção se não houver próxima instrução.
            }
        } else {
            return proxInstruction; // Retorna null se o sinal de controle não permitir acesso à próxima instrução.
        }
    }

    // Getter e Setter para o sinal de controle.
    public boolean isControl() {
        return control;
    }

    public void setControl(boolean control) {
        this.control = control;
    }

    // Getter e Setter para a fila de instruções.
    public HashMap<String, Instruction<?>> getQueue() {
        return queue;
    }

    public void setQueue(HashMap<String, Instruction<?>> queue) {
        this.queue = queue;
    }

    // Getter e Setter para o ID atual da fila.
    public int getCurrentQueueId() {
        return currentQueueId;
    }

    public void setCurrentQueueId(int currentQueueId) {
        this.currentQueueId = currentQueueId;
    }
    
}
