import javax.swing.JOptionPane;

public class Lista<T> {
    
  No inicio, fim;

  // método para inserir (incompleto)
  public void inserir(Produto produto) {

		No aux = new No(produto);
		
    No aux2 = inicio;

		if(inicio == null) {
			inicio = aux;
      fim = aux;
		} else if (aux.produto.datadevalidade.compareTo(fim.produto.datadevalidade) >= 0) {
			fim.dir = aux;
			aux.esq = fim;
			fim = aux;
		} else if (aux.produto.datadevalidade.compareTo(inicio.produto.datadevalidade) < 0) {
			inicio.esq = aux;
			aux.dir = inicio;
			inicio = aux;
		} else {
		  while (aux2 != null) {		
			  if (aux.produto.datadevalidade.compareTo(aux2.dir.produto.datadevalidade) <= 0 && aux.esq.produto.datadevalidade.compareTo(aux2.esq.produto.datadevalidade) >= 0) {
					aux2.dir.esq = aux;
					aux.dir = aux2.dir;
					aux.esq = aux2;
					aux2.dir = aux;
					break;
				}
				aux2 = aux2.dir;
				
			}
		}
	}

  // método para pesquisar
  public No pesquisar(String nome){
    No aux = inicio;
    boolean achou = false;
    while(aux != null && !achou){
        if(aux.produto.nome.equalsIgnoreCase(nome)){
          achou = true;
        } else {
          aux = aux.dir;
        }
    }
    return aux;
  }

  // método de imprimir
  public void imprimir(){
    No aux = inicio;
      while(aux != null){
        JOptionPane.showMessageDialog(null, "Produto: " + aux.produto.nome+ "\nData de validade: " + aux.produto.datadevalidade + "\nQuantidade: " + aux.produto.estoque);
        aux = aux.dir;
      }
  }

  // método remover
  public void remover(String nome) {
		No aux = pesquisar(nome);
		
		if(aux != null) {
			if(inicio == fim) {//caso tenha um único elemento
        inicio = fim;
				inicio = null;
				fim = null;	
			} else if(aux == inicio) { //primeiro elemento
				aux.dir.esq = null;
				inicio = aux.dir;
				aux.dir = null;
			} else if(aux == fim){//último elemento
				aux.esq.dir = null;
				fim = aux.esq;
				aux.esq = null;
			} else {//elemento do meio
				aux.esq.dir = aux.dir;
				aux.dir.esq = aux.esq;
				aux.dir = null;
				aux.esq = null;
			}
		}
	}
}
