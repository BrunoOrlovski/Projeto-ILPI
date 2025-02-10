package org.example;

 import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

 import java.time.LocalDate;
 import java.time.format.DateTimeFormatter;
 import java.util.Scanner;

 import org.example.model.AvaliacaoMedica;
 import org.example.model.Paciente;
 import org.example.model.ProfissionalSaude;
 import org.example.service.PacienteService;
 import org.example.service.ProfissionalSaudeService;
import org.example.service.AvaliacaoMedicaService;
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static EntityManager em;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PostgresPU");
        em = emf.createEntityManager();

        PacienteService pacienteService = new PacienteService(em);
        ProfissionalSaudeService profissionalService = new ProfissionalSaudeService(em);
        AvaliacaoMedicaService avaliacaoService = new AvaliacaoMedicaService(em);

        boolean continuar = true;

        while (continuar) {
            System.out.println("----- MENU -----");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Alterar Paciente");
            System.out.println("3. Excluir Paciente");
            System.out.println("4. Consultar Paciente por CPF");
            System.out.println("5. Listar todos os Pacientes");
            System.out.println("6. Cadastrar Profissional de Saúde");
            System.out.println("7. Alterar Profissional");
            System.out.println("8. Excluir Profissional");
            System.out.println("9. Consultar Profissional por Especialidade");
            System.out.println("10. Listar todos os Profissionais");
            System.out.println("11. Registrar Avaliação Médica");
            System.out.println("12. Alterar Avaliação Médica");
            System.out.println("13. Excluir Avaliação Médica");
            System.out.println("14. Consultar Avaliação por Paciente");
            System.out.println("15. Listar Avaliações por Período");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarPaciente(pacienteService);
                case 2 -> alterarPaciente(pacienteService);
                case 3 -> excluirPaciente(pacienteService);
                case 4 -> consultarPacientePorCPF(pacienteService);
                case 5 -> listarPacientes(pacienteService);
                case 6 -> cadastrarProfissional(profissionalService);
                case 7 -> alterarProfissional(profissionalService);
                case 8 -> excluirProfissional(profissionalService);
                case 9 -> consultarProfissionalPorEspecialidade(profissionalService);
                case 10 -> listarProfissionais(profissionalService);
                case 11 -> registrarAvaliacao(avaliacaoService);
                case 12 -> alterarAvaliacao(avaliacaoService);
                case 13 -> excluirAvaliacao(avaliacaoService);
                case 14 -> consultarAvaliacaoPorPaciente(avaliacaoService);
                case 15 -> listarAvaliacoesPorPeriodo(avaliacaoService);
                case 0 -> continuar = false;
                default -> System.out.println("Opção inválida!");
            }
        }

        em.close();
        emf.close();
        System.out.println("Programa encerrado.");
    }

    private static void cadastrarPaciente(PacienteService pacienteService) {
        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Contato de emergência: ");
        String contatoEmergencia = scanner.nextLine();
        System.out.print("Condições médicas: ");
        String condicoesMedicas = scanner.nextLine();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataN = LocalDate.parse(dataNascimento, formatter);

        Paciente paciente= new Paciente(nome, cpf, dataN, contatoEmergencia, condicoesMedicas);

        pacienteService.inserir(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    private static void alterarPaciente(PacienteService pacienteService) {
        System.out.print("Digite o ID do paciente: ");
        Long idPaciente = scanner.nextLong();
        scanner.nextLine();

        Paciente paciente = em.find(Paciente.class, idPaciente);

        if (paciente == null) {
            System.out.println("Paciente não encontrado com o ID informado!");
            return;
        }

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nova data de Nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Condições médicas: ");
        String condicoesMedicas = scanner.nextLine();
        System.out.print("Contato de emergência: ");
        String contatoEmergencia = scanner.nextLine();

        paciente.setNome(nome);
        paciente.setCpf(cpf);
       // paciente.setDataNascimento(dataNascimento);
        paciente.setCondicoesMedicas(condicoesMedicas);
        paciente.setContatoEmergencia(contatoEmergencia);

        pacienteService.alterar(paciente);
        System.out.println("Dados do paciente alterados com sucesso!");
    }

    private static void excluirPaciente(PacienteService pacienteService) {
        System.out.print("Digite o ID do paciente a ser excluído: ");
        Long idPaciente = scanner.nextLong();
        scanner.nextLine();


        Paciente paciente = em.find(Paciente.class, idPaciente);

        if (paciente == null) {
            System.out.println("Paciente não encontrado com o ID informado!");
            return;
        }

        pacienteService.excluir(paciente);
        System.out.println("Paciente excluído com sucesso!");
    }

    private static void consultarPacientePorCPF(PacienteService pacienteService) {
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        System.out.println(pacienteService.buscarPacientePorCpf(cpf));
    }

    private static void listarPacientes(PacienteService pacienteService) {
        pacienteService.buscarTodosOsPacientes().forEach(System.out::println);
    }

    private static void cadastrarProfissional(ProfissionalSaudeService profissionalService) {
        System.out.print("Nome do profissional: ");
        String nome = scanner.nextLine();
        System.out.print("Registro: ");
        String registro = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.print("Contato: ");
        String contato = scanner.nextLine();

        ProfissionalSaude profissionalSaude = new ProfissionalSaude(nome, registro, especialidade, contato);
        profissionalService.inserir(profissionalSaude);
        System.out.println("Profissional cadastrado com sucesso!");
    }

    private static void alterarProfissional(ProfissionalSaudeService profissionalService) {
        System.out.print("Nome do profissional: ");
        String nome = scanner.nextLine();
        System.out.print("Registro: ");
        String registro = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.print("Contato: ");
        String contato = scanner.nextLine();

        ProfissionalSaude profissionalSaude = new ProfissionalSaude(nome, registro, especialidade, contato);
        profissionalService.alterar(profissionalSaude);
        System.out.println("Dados do profissional alterados com sucesso!");
    }

    private static void excluirProfissional(ProfissionalSaudeService profissionalService) {
        System.out.print("Nome do profissional a ser excluído: ");
        long id = scanner.nextLong();
        ProfissionalSaude profissionalSaude = em.find(ProfissionalSaude.class, id);
        profissionalService.excluir(profissionalSaude);
        System.out.println("Profissional excluído com sucesso!");
    }

    private static void consultarProfissionalPorEspecialidade(ProfissionalSaudeService profissionalService) {
        System.out.print("Digite a especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.println(profissionalService.buscarProfissionaisPorEspecialidade(especialidade));
    }

    private static void listarProfissionais(ProfissionalSaudeService profissionalService) {
        profissionalService.buscarTodosOsProfissionais().forEach(System.out::println);
    }

    private static void registrarAvaliacao(AvaliacaoMedicaService avaliacaoService) {
        System.out.print("Digite o ID do paciente: ");
        Long idPaci = scanner.nextLong();
        scanner.nextLine(); // Consome a nova linha pendente
        System.out.print("Digite o id do profissional: ");
        Long idProf = scanner.nextLong();
        scanner.nextLine(); // Consome a nova linha pendente
        System.out.print("Digite a data da avaliação (dd/MM/yyyy): ");
        String data = scanner.nextLine();
        System.out.print("Digite a hora da avaliação: ");
        String hora = scanner.nextLine();
        System.out.print("Digite as observações: ");
        String observacoes = scanner.nextLine();
        System.out.print("Digite o diagnostico: ");
        String diagnostico = scanner.nextLine();
        System.out.print("Digite os medicamentos: ");
        String medicamentos = scanner.nextLine();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define o formato esperado

        LocalDate dataAv = LocalDate.parse(data, formatter); // Converte String para LocalDate6
        Paciente paciente = em.find(Paciente.class, idPaci);
        ProfissionalSaude profissional = em.find(ProfissionalSaude.class, idProf);

        if (paciente == null || profissional == null) {
            throw new IllegalArgumentException("Paciente ou Profissional de Saúde não encontrados!");
        }

        AvaliacaoMedica avaliacaoMedica = new AvaliacaoMedica(
                paciente,  // Passa o objeto Paciente
                profissional,  // Passa o objeto ProfissionalSaude
                dataAv.atStartOfDay(),  // Converte LocalDate para LocalDateTime
                hora,
                observacoes,
                diagnostico,
                medicamentos
        );
        avaliacaoService.registrar(avaliacaoMedica);
        System.out.println("Avaliação médica registrada com sucesso!");
    }

    private static void alterarAvaliacao(AvaliacaoMedicaService avaliacaoService) {
        System.out.print("Digite o ID da avaliação: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Digite as novas observações: ");
        String novasObservacoes = scanner.nextLine();

        AvaliacaoMedica avaliacaoMedica = em.find(AvaliacaoMedica.class, id);
        avaliacaoService.alterar(avaliacaoMedica);
        System.out.println("Avaliação médica alterada com sucesso!");
    }

    private static void excluirAvaliacao(AvaliacaoMedicaService avaliacaoService) {
        System.out.print("Digite o ID da avaliação a ser excluída: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        AvaliacaoMedica avaliacaoMedica = em.find(AvaliacaoMedica.class, id);
        avaliacaoService.excluir(avaliacaoMedica);
        System.out.println("Avaliação médica excluída com sucesso!");
    }

    private static void consultarAvaliacaoPorPaciente(AvaliacaoMedicaService avaliacaoService) {
        System.out.print("Digite o ID do paciente: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consome a nova linha pendente
        System.out.println(avaliacaoService.buscarAvaliacoesPorPaciente(id));
    }

    private static void listarAvaliacoesPorPeriodo(AvaliacaoMedicaService avaliacaoService) {
        System.out.print("Digite a data inicial (dd/MM/yyyy): ");
        String dataInicial = scanner.nextLine();
        System.out.print("Digite a data final (dd/MM/yyyy): ");
        String dataFinal = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define o formato esperado

        LocalDate dataIn = LocalDate.parse(dataInicial, formatter); // Converte String para LocalDate

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define o formato esperado

        LocalDate dataFim = LocalDate.parse(dataFinal, formatter); // Converte String para LocalDate


        avaliacaoService.buscarAvaliacoesPorPeriodo(dataIn.atStartOfDay(), dataFim.atStartOfDay()).forEach(System.out::println);
    }


}
