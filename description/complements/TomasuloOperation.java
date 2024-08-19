package complements;
public enum TomasuloOperation {
    AddInt, // Soma Inteiro
    AddPF, // Soma Ponto Flutuante
    SubInt, // Subtração Inteiro
    SubPF, // Subtração Ponto Flutuante
    MulInt, // Multiplicacao Inteiro
    MulPF, // Multiplicacao Ponto Flutuante
    DivInt, // Multiplicação
    DivPF, // Divisão
    Load, // Carregar da memória
    Store, // Armazenar na memória
    Beq, // Branch if Equal (Desvio se igual)
    Bne // Branch if Not Equal (Desvio se diferente)
}
