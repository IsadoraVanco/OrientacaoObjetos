# Senhas

Créditos ao prof° Bruno Zarpelão, autor do exercício.

Desenvolva um sistema que vai controlar a emissão de senhas para atendimento em uma repartição pública. O sistema deve permitir as seguintes opções para manipulação da fila composta pelas senhas emitidas:

– Emitir nova senha: o sistema deve emitir um valor inteiro aleatório para a senha e posicioná-lo no final da fila;

– Desistir da fila: o sistema deve permitir que o usuário remova da fila um usuário que desistiu de ser atendido;

– Atender usuário: o sistema deve permitir que o usuário portador da senha que está na frente da fila seja atendido. A senha deve ser removida da fila. 

– Buscar posição na fila: o sistema deve permitir que o usuário informe o número da senha e receba como retorno a sua
posição na fila. 

– Imprimir fila: o sistema deve imprimir na tela os números de senha que estão aguardando na fila;

Faça um menu baseado em linhas de comando para manipulação do sistema. 

Para entregar o programa, você deve compactar a pasta do projeto do programa criado no Eclipse ou no IntelliJ em um arquivo com extensão .zip. O arquivo e o projeto devem ser nomeados da seguinte forma: ListaEx2<primeiro nome do aluno><último sobrenome do aluno>. Se eu fosse entregar o trabalho, o nome do arquivo e do projeto no Eclipse ou no IntelliJ seriam "ListaEx2BrunoZarpelao".

## Implementação extra

Faça uma modificação no programa do exercício anterior:

– Agora temos duas filas, a comum e a preferencial.

– Sempre que houver um novo atendimento, a senha na fila preferencial deve ser atendida primeiro. Há uma restrição para esta regra: não podem ser atendidas mais que duas senhas consecutivas da fila preferencial.