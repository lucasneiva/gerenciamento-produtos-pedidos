/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author 0030482221012
 */

public class Pedido {
    public class ItemPedido {
        private Produto produto;
        private int quantidade;

        public ItemPedido(Produto produto, int quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
        }

        public Produto getProduto() {
            return produto;
        }

        public void setProduto(Produto produto) {
            this.produto = produto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }
        
        
    }
    
    private String numero;
    private String dataEmissao;
    private double valor;
    
    private Cliente cliente;
    private Vendedor vendedor;
    
    
    private ArrayList<ItemPedido> itens;
    
    public Pedido(String numero) {
        this.numero = numero;
        this.itens = new ArrayList<ItemPedido>();
        
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }
    
    public void addItem(ItemPedido item) {
        valor += item.getProduto().getPreco() * item.getQuantidade();
        itens.add(item);
    }
    
    public void removeItem(ItemPedido item) {
        if(itens.remove(item)) {
            valor -= item.getProduto().getPreco() * item.getQuantidade();
        }
       
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    
    public void addCliente(Cliente cliente) {
        this.cliente = cliente;
        cliente.setLimiteDisponivel(cliente.getLimiteDisponivel() - valor);
        cliente.addPedido(this);
        
    }
    
    public void removeCliente() {
        cliente.setLimiteDisponivel(cliente.getLimiteDisponivel() + valor);
        cliente.removePedido(numero);
        cliente = null;
    }
    
    public void addVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
        vendedor.addPedido(this);   
    }
    
    public String getNumero() {
        return numero;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
        
}


