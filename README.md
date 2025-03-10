﻿# Projeto-ILPI
 
Projeto: Sistema de Gestão de Asilo
Objetivo: Desenvolver uma aplicação desktop em Java para gerenciar o dia a dia de um asilo, com funcionalidades voltadas para o cadastro de pacientes e profissionais de saúde, além do registro e acompanhamento de avaliações médicas. Este projeto utiliza JPA, ORM, PostgreSQL, JUnit, MVC, e os padrões de projeto DAO e VO, permitindo uma aplicação prática desses conceitos.
Requisitos Técnicos:
Linguagem de Programação: Java
JDK: 21 ou superior
IDE: IntelliJ IDEA
Maven: Ferramenta de automação e gerenciamento de dependências
Banco de Dados Relacional: PostgreSQL

Funcionalidades Principais
1. Gerenciamento de Pacientes:
Cadastrar Paciente (nome, CPF, data de nascimento, contato de emergência, condições médicas).
Alterar dados do Paciente.
Excluir Paciente.
Consultar Paciente por CPF.
Listar todos os Pacientes.
2. Gerenciamento de Profissionais de Saúde:
Cadastrar Profissional (nome, registro profissional, especialidade, contato).
Alterar dados do Profissional.
Excluir Profissional.
Consultar Profissional por Especialidade ou Registro.
Listar todos os Profissionais cadastrados.
3. Avaliações Médicas:
Registrar Avaliação (paciente, profissional responsável, data, hora, observações, diagnóstico, medicamentos recomendados).
Alterar Avaliações Registradas.
Excluir Avaliação.
Consultar Avaliação por Paciente.
Listar Avaliações por Período, Paciente ou Profissional.
4. Relatórios e Consultas:
Relatório de Pacientes por Condição Médica.
Relatório de Avaliações Realizadas por Período.
Relatório de Profissionais e Pacientes Atendidos.
5. Histórico de Pacientes:
Consultar o Histórico Completo de Avaliações de um Paciente.
Exibir Gráficos ou Estatísticas (ex.: número de avaliações por mês).

Estrutura do Projeto
Camadas do Sistema:
Apresentação (View):
Interface de linha de comando para navegar entre as funcionalidades.
Fluxo intuitivo com menus e submenus.
Service (Controller):
Lógica de validação de dados e interação entre View e DAO.
Persistência (DAO):
Uso de JPA para mapeamento objeto-relacional e persistência de dados.
Entidades Principais:
Paciente
Atributos: id, nome, cpf, dataNascimento, condicoesMedicas, contatoEmergencia.
ProfissionalSaude
Atributos: id, nome, registro, especialidade, contato.
AvaliacaoMedica
Atributos: id, pacienteId, profissionalId, data, hora, observacoes, diagnostico, medicamentos.

Tecnologias e Ferramentas Utilizadas
JPA (Java Persistence API): Para manipular o banco de dados de forma simples e eficiente.
PostgreSQL: Para armazenar as informações de pacientes, profissionais e avaliações.
JUnit: Para testes unitários das funcionalidades principais.
Padrão MVC: Para organizar e estruturar o código.
Padrões de Projeto DAO e VO:
DAO para gerenciar as interações com o banco de dados.
VO para encapsular os dados de objetos simples.

Fluxo de Interação do Usuário
Menu Inicial:


Gerenciar Pacientes
Gerenciar Profissionais de Saúde
Registrar Avaliações Médicas
Consultar Avaliações
Gerar Relatórios
Escolha de uma Opção:


Navegação intuitiva por meio de menus e submenus para cadastro, consulta ou relatórios.
Saída:


Informações exibidas em tabelas simples na interface de linha de comando e possibilidade de exportar relatórios para arquivos.

Exemplo de Uso
Cenário 1: Registro de um Novo Paciente
O usuário acessa a opção "Gerenciar Pacientes" no menu principal.
Escolhe "Cadastrar Paciente".
Insere os dados do paciente: nome, CPF, data de nascimento, condições médicas, e contato de emergência.
O sistema valida e salva as informações no banco de dados.
Cenário 2: Consultar Avaliações por Paciente
O usuário acessa "Consultar Avaliações" no menu principal.
Escolhe a opção "Por Paciente".
Digita o CPF do paciente.
O sistema retorna uma lista de todas as avaliações realizadas, com detalhes como data, diagnóstico e medicamentos recomendados.

Este sistema oferece uma solução prática e eficiente para gerenciar as atividades de um asilo, ajudando na organização do atendimento médico e no acompanhamento do histórico dos residentes. Ele pode ser expandido para incluir outras funcionalidades, como gestão de atividades recreativas ou controle de medicamentos administrados.
