#language: pt
# enconding: utf-8

  Funcionalidade: Usuario
    Criar, manter e autenticar usuarios
    Cenário: Login com Senha Valida
      Dado que acesso o site Microsoft To Do
      Quando clico no icone Sign in your account
      Então exibe a página de login
      Quando digito o e-mail e clico em próximo
      E seleciona a conta pessoal
      E digito a senha "correta" e clica em entrar
      Então o site realiza o login e exibe a pagina do To Do

    Cenário: Login com Senha Invalida
      Dado que acesso o site Microsoft To Do
      Quando clico no icone Sign in your account
      Então exibe a página de login
      Quando digito o e-mail e clico em próximo
      E seleciona a conta pessoal
      E digito a senha "incorreta" e clica em entrar
      Então o site exibe a mensagem de erro: Sua conta ou senha está incorreta

    Cenário: Esqueci minha Senha
      Dado que acesso o site Microsoft To Do
      Quando clico no icone Sign in your account
      Então exibe a página de login
      Quando digito o e-mail e clico em próximo
      E clico em Esqueceu a senha?
      Então abre um pop up Como deseja obter o codigo de segurança? e marco a opcao do email sugerido e clico em Obter codigo
      Quando abro meu email e digito o codigo recebido e pressiono Proximo
      E abre um pop up digito nos campos Nova senha e Redigitar a senha e pressiono proximo
      Então abre um pop up com a mensagem Sua senha foi alterada e pressiono Entrar

    Cenário: Esqueci minha Senha
      Dado que acesso o site Microsoft To Do
      Quando clico no icone Sign in your account
      Então exibe a página de login
      E clico em Nao tem uma conta? Crie uma!
      Quando digito o e-mail e clico em próximo
      Então digito uma senha em Criar senha e clico em proximo
      E preencho os campos Nome e Sobrenome e pressiono proximo
      E informo os dados de Pais/regiao e data de nascimento e pressiono proximo
      Quando digio os caracteres exibidos na tela e pressiono proximo
      Então o site realiza o login e exibe a pagina do To Do



