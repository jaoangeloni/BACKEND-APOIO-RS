package Controller;
 
public class CheckoutItem {
    private int id;
    private int itemId;
    private int centroDistribuicaoId;
    private int quantidade;
    private boolean aprovado;
    private String motivoRecusa;
 
    public CheckoutItem(int id, int itemId, int centroDistribuicaoId, int quantidade, boolean aprovado, String motivoRecusa) {
        setId(id);
        setItemId(itemId);
        setCentroDistribuicaoId(centroDistribuicaoId);
        setQuantidade(quantidade);
        setAprovado(aprovado);
        setMotivoRecusa(motivoRecusa);
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("ID não pode ser negativo.");
        this.id = id;
    }
 
    public int getItemId() {
        return itemId;
    }
 
    public void setItemId(int itemId) {
        if (itemId < 0) throw new IllegalArgumentException("Item ID não pode ser negativo.");
        this.itemId = itemId;
    }
 
    public int getCentroDistribuicaoId() {
        return centroDistribuicaoId;
    }
 
    public void setCentroDistribuicaoId(int centroDistribuicaoId) {
        if (centroDistribuicaoId < 0) throw new IllegalArgumentException("Centro de Distribuição ID não pode ser negativo.");
        this.centroDistribuicaoId = centroDistribuicaoId;
    }
 
    public int getQuantidade() {
        return quantidade;
    }
 
    public void setQuantidade(int quantidade) {
        if (quantidade < 0) throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        this.quantidade = quantidade;
    }
 
    public boolean isAprovado() {
        return aprovado;
    }
 
    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
 
    public String getMotivoRecusa() {
        return motivoRecusa;
    }
 
    public void setMotivoRecusa(String motivoRecusa) {
        if (motivoRecusa != null && motivoRecusa.trim().isEmpty()) {
            throw new IllegalArgumentException("Motivo de recusa não pode ser vazio.");
        }
        this.motivoRecusa = motivoRecusa;
    }
 
    @Override
    public String toString() {
        return "CheckoutItem{" +
               "id=" + id +
               ", itemId=" + itemId +
               ", centroDistribuicaoId=" + centroDistribuicaoId +
               ", quantidade=" + quantidade +
               ", aprovado=" + aprovado +
               ", motivoRecusa='" + motivoRecusa + '\'' +
               '}';
    }
}
 