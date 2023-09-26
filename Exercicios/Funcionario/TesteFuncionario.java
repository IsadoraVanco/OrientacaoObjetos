/*
Um teste para a classe Funcionario
 */
public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario func1 = new Funcionario("Joãozinho");
        Funcionario func2 = new Funcionario("Mariazinha");

        System.out.printf("Primeiro funcionário: nome: %s %nsalario: %.2f %n", func1.getNome(), func1.getSalario());
        System.out.printf("Segundo funcionário: nome: %s %nsalario: %.2f %n", func2.getNome(), func2.getSalario());
        System.out.printf("Vale refeição dos funcionários: %.2f %n", func1.getValeRefeicao());

        func1.ajustaValeRefeicao(10);
        System.out.printf("Novo vale refeição dos funcionários: %.2f %n", func2.getValeRefeicao());

        Funcionario.ajustaValeRefeicao(-10);
        System.out.printf("Novo vale refeição dos funcionários: %.2f %n", func2.getValeRefeicao());

        func2.setSalario(3000);
        System.out.printf("Segundo funcionário: nome: %s %nnovo salario: %.2f %n", func2.getNome(), func2.getSalario());
    }
}
