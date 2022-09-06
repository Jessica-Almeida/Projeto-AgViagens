package crud;

import java.util.Scanner;

import dao.DestinoDAO;
import modelo.Destino;

public class DestinoCrud {

	public static void main(String args[]) {

		DestinoDAO destinoDAO = new DestinoDAO();
		Destino destino = new Destino();

		Scanner entrada = new Scanner(System.in);
		int opcao, id = 0;
		String pais, cidade, dataIda, dataVolta = "";
		double preco = 0;

		do {

			System.out.println("===== CRUD DESTINO =====");
			System.out.println("1 - Cadastro de destino");
			System.out.println("2 - Excluir destino");
			System.out.println("3 - Atualizar destino");
			System.out.println("4 - Mostrar destinos");
			System.out.println("5 - Buscar por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {
				System.out.println("Digite o País: ");
				pais = entrada.next();
				destino.setPais(pais);
				System.out.println("Digite a Cidade: ");
				cidade = entrada.next();
				destino.setCidade(cidade);
				entrada.next();
				System.out.println("Digite a data de ida: ");
				dataIda = entrada.next();
				destino.setDataIda(dataIda);

				System.out.println("Digite a data de volta: ");
				dataVolta = entrada.next();
				destino.setDataVolta(dataVolta);

				System.out.println("Digite o preço do destino: ");
				preco = entrada.nextDouble();
				destino.setPreco(preco);

				destinoDAO.save(destino);

				break;
			}
			case 2: {
				System.out.println("Digite o ID do destino para exclusao: ");

				id = entrada.nextInt();

				destinoDAO.deleteById(id);

				break;
			}
			case 3: {

				System.out.println("Digite o ID do destino para atualizar: ");

				id = entrada.nextInt();

				System.out.println("Digite o novo País: ");
				pais = entrada.next();

				System.out.println("Digite a nova Cidade: ");
				cidade = entrada.next();

				System.out.println("Digite a nova data de ida: ");
				dataIda = entrada.next();

				System.out.println("Digite a nova data de volta: ");
				dataVolta = entrada.next();

				System.out.println("Digite o novo preço do destino: ");
				preco = entrada.nextDouble();

				Destino a = new Destino(id, pais, cidade, dataIda, dataVolta, preco);
				destinoDAO.update(a);

				break;
			}
			case 4: {
				for (Destino d : destinoDAO.getDestino()) {

					System.out.println(
							"Id: " + d.getId() + " País: " + d.getPais() + " Cidade:: " + d.getCidade() + " Data de ida: "
									+ d.getDataIda() + " Data de volta: " + d.getDataVolta() + "Preço: " + d.getPreco());

					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Digite o ID para buscar: ");
				int iD = entrada.nextInt();

				Destino d = destinoDAO.getDestinoById(iD);

				System.out.println("País: " + d.getPais() + " Cidade: " + d.getCidade() + " Data de ida: "
						+ d.getDataIda() + " Data de volta: " + d.getDataVolta() + " Preço: " + d.getPreco());

				System.out.println("----------------------------------- ");
			}
				break;

			case 6: {
				System.out.println(" === Até Logo! === ");
				break;
			}
			default:
				System.out.println(opcao != 6 ? "opção invalida, digite novamente." : "");

			}
			;

		} while (opcao != 6);

		entrada.close();

	}
}
