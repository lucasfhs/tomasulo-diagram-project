package complements;

// A classe GenericType representa um contêiner genérico que pode armazenar qualquer tipo de dado.
// Foi criado para simplificar a abstracao do projeto do Tomasulo.
public class GenericValue<T> {
    private T value; // Valor genérico que a classe armazena.

    // Construtor que inicializa a classe com um valor.
    public GenericValue(T value) {
        this.value = value;
    }

    // Método getter que retorna o valor armazenado.
    public T getValue() {
        return value;
    }

    // Método setter que atualiza o valor armazenado.
    public void setValue(T value) {
        this.value = value;
    }

    // Método para exibir o tipo do valor armazenado.
    public String getType() {
        return value.getClass().getName(); // Retorna o nome da classe do tipo armazenado.
    }

    // Método para converter o valor armazenado em uma string.
    @Override
    public String toString() {
        return "Value: " + value.toString();
    }

}
