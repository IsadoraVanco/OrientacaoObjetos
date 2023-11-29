# Exercicio 03 - Conta Bancária

Créditos ao prof° Bruno, autor do exercício.

Crie uma classe **ContaBancaria**.
Inclua os seguintes atributos:
* **cliente**: String;
* **numeroConta**: String;
* **saldo**: BigDecimal;
Inclua os seguintes métodos na classe ContaBancaria:
* **sacar**: não permitir que o saldo fique menor que zero;
* **depositar**;

Crie duas subclasses de ContaBancaria: ContaCorrente e ContaPoupanca.
Na classe **ContaPoupanca**, inclua o seguinte atributo:
* **diaRendimento**: int;
Na classe ContaPoupanca, inclua o seguinte método:
* **calcularNovoSaldo**: recebe como parâmetro a taxa de rendimento e atualiza o saldo;

Na classe **ContaCorrente**, inclua o seguinte atributo:
* **limite**: BigDecimal;
Na classe ContaCorrente, redefina o método sacar, permitindo saldos negativos desde que não
superem o limite;

Faça uma classe **Principal** que permita ao usuário realizar as seguintes tarefas:
* **Cadastrar** a conta (poupança ou corrente) de um cliente;
* **Sacar** um valor da sua conta (poupança ou corrente);
* **Atualizar** uma conta poupança com o seu rendimento;
* **Depositar** um determinado valor na conta (poupança ou corrente);
* **Mostrar** o saldo de uma conta (poupança ou corrente);

## Implementação extra

Implementar busca de uma conta pelo seu número usando o método indexOf(Object o) do LinkedList 
(Dica: olhar na documentação do Java como o indexOf(Object o) é implementado).