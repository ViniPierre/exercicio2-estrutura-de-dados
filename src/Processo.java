import javax.swing.JOptionPane;

public class Processo {

    static Lista<Produto> lista = new Lista<Produto>();

    public static void cadastrar() {

        String nome = JOptionPane.showInputDialog(null, "Nome do produto: ");

        No aux = lista.pesquisar(nome);
        if (aux == null) {
            int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Dia de vencimento: "));
            int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Mês de vencimento: "));
            int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Ano de vencimento: "));
            int estoque = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantos produtos há no estoque: "));
            String datadevalidade = ano + "/" + mes + "/" + dia;

            Produto produto = new Produto(nome, datadevalidade, estoque);

            lista.inserir(produto);

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Produto já cadastrado!");
        
        }
    }

    public static void listar() {
        if(lista.inicio == null) {
            JOptionPane.showMessageDialog(null, "Não há produtos cadastrados");
        } else {
            lista.imprimir();
        }
    }

    public static void vender() {
        String nome = JOptionPane.showInputDialog(null, "Nome do produto: ");
        No aux = lista.pesquisar(nome);
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "Produto não cadastrado!");
        } else {
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de produtos atual: " +aux.produto.estoque + "\nQuantidade de produtos a ser vendida "));
            if (quantidade <= 0 || quantidade > aux.produto.estoque) {
                JOptionPane.showMessageDialog(null, "Quantidade de produto inválida!");
            } else {
                aux.produto.estoque = aux.produto.estoque - quantidade;
                JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
                if (aux.produto.estoque == 0) {
                  lista.remover(aux.produto.nome);
                }
            }
        }
    }
}