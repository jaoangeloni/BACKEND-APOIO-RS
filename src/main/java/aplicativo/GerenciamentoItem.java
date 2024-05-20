package aplicativo;

import java.util.ArrayList;
import java.util.List;

class GerenciamentoItem {
    private List<Item> itens;

    public GerenciamentoItem() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public List<Item> listarItens() {
        return new ArrayList<>(itens);
    }

    public Item buscarItem(String nome) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null;
    }

    public void editarItem(String nome, Item itemAtualizado) {
        Item item = buscarItem(nome);
        if (item != null) {
            item.setNome(itemAtualizado.getNome());
            item.setCategoria(itemAtualizado.getCategoria());
            item.setQuantidade(itemAtualizado.getQuantidade());
            item.setTamanho(itemAtualizado.getTamanho());
            item.setNumeroCalcado(itemAtualizado.getNumeroCalcado());
        }
    }

    public void excluirItem(String nome) {
        Item item = buscarItem(nome);
        if (item != null) {
            itens.remove(item);
        }
    }
}
