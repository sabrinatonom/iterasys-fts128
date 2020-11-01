#language: pt
# enconding: utf-8

  Funcionalidade: Listas
    Criar e manter listas
    Persona: Stella
    Tipo: Analista Financeiro / Usuária Frequente
  Cenário: Criar uma lista
    Dado que eu acesso o site Microsoft To Do
    Quando clico no icone do usuario
    Então o site realiza o login e exibe a pagina do To Do
    Quando clico em Nova lista
    E preencho "Lista de Compras" e pressiono Enter
    Então exibe a Lista de Compras vazia

  Cenário Alterar uma Lista
    Dado que eu acesso o site Microsoft To Do
    Quando clico no icone do usuario
    Entao o site realiza o login e exibe a pagina do To Do
    Quando clico na lista criada Lista de Compras e na tela principal clico sob o nome da lista
    Então altero o nome da lista para "Lista de Compras Hoje" e pressiono Enter

: Cenário Consultar uma Lista
    Dado que eu acesso o site Microsoft To Do
    Quando clico no icone do usuario
    Entao o site realiza o login e exibe a pagina do To Do
    Quando clico sob o nome da lista
    Então disponibiliza na tela principal a lista com opcao para Adicionar uma tarefa

  Cenário Excluir uma Lista
    Dado que eu acesso o site Microsoft To Do
    Quando clico no icone do usuario
    Entao o site realiza o login e exibe a pagina do To Do
    Quando clico em uma lista criada e na tela principal clico nos tres pontinhos ao lado do nome da lista
    E abre um menu suspenso e clico em Excluir lista
    Então confirmo a exclusao da lista clicando no botao Excluir lista

   Cenário Compartilhar uma Lista
     Dado que eu acesso o site Microsoft To Do
     Quando clico no icone do usuario
     Entao o site realiza o login e exibe a pagina do To Do
     Quando clico em uma lista criada mostra a lista na tela principal e clico na opcao Compartilhar
     E abre um pop up e clico em Criar link do convite
     Então clico em Copiar link e mostra a mensagem Copiado para a area de transferencia