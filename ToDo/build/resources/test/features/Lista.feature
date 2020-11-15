#language: pt
# encoding: utf8

  Funcionalidade: Lista
    Criar e manter itens em uma lista
  Esquema do Cenário: Incluir itens na lista
    Dado que estou na Lista de Compras
    Quando digito <item> e pressiono Enter
    Então exibe o <item> na Lista de Compras
    Exemplos:
    | item              |
    | "macarrão"        |
    | "molho de tomate" |

  Cenário: Alterar itens na lista
    Dado que estou na Lista de Compras
    Quando clico no item molho de tomate
    Então exibe os detalhes do item
    E clico sob o nome do item no menu direito
    Então altero o nome do item

  Cenário: Consultar itens na lista
    Dado que estou na Lista de Compras
    Quando clico em cada nome de item
    Então consulto os detalhes de cada item digitado na lista

  Cenário: Excluir itens na Lista
    Dado que estou na Lista de Compras
    Quando clico no item molho de tomate
    Então exibe os detalhes do item
    E clico no icone da lixeina
    Quando abre um pop up e clico em Excluir tarefa
    Então o item/tarefa é excluido da lista
