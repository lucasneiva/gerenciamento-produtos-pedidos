package fatec.poo.control;

import fatec.poo.model.Cliente;
import fatec.poo.model.Pedido;
import fatec.poo.model.Produto;
import fatec.poo.model.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class DaoPedido {
    private Connection conn;
    
    public DaoPedido(Connection conn) {
         this.conn = conn;
    }    
    
    public Pedido consultar (String numero) {
        Pedido objPed = null;         
       
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT * FROM PEDIDO WHERE NUMERO = ?");
            
            ps.setString(1, numero);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next() == true) {
                objPed = new Pedido(rs.getString("NUMERO"));
                objPed.setDataEmissao(rs.getString("DATA_EMISSAO"));
                objPed.setValor(rs.getDouble("VALOR"));
                
                //busca o cliente
                DaoCliente daoCli = new DaoCliente(conn);
                Cliente cli = daoCli.consultar(rs.getString("CPF_CLIENTE"));
                objPed.addCliente(cli);
                
                //busca o vendedor
                DaoVendedor daoVend = new DaoVendedor(conn);
                Vendedor vend = daoVend.consultar(rs.getString("CPF_VENDEDOR"));
                objPed.addVendedor(vend);
                
                //busca itens
                ps = conn.prepareStatement("SELECT * FROM ITEM_PEDIDO WHERE NUMERO_PEDIDO = ?");
                
                System.out.println(numero);
                ps.setString(1, numero);
                rs = ps.executeQuery();
                DaoProduto daoProd = new DaoProduto(conn);

                while (rs.next()) {
                    Produto prod = daoProd.consultar(rs.getInt("CODIGO_PRODUTO"));
                    Pedido.ItemPedido item = objPed.new ItemPedido(prod, rs.getInt("QTDE"));
                    objPed.addItem(item);
                    
                }
            }
            
            
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return(objPed);
    }    
     
    public void inserir(Pedido objPed) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO PEDIDO(" +
                                       "NUMERO, DATA_EMISSAO, VALOR, " +
                                       "CPF_CLIENTE, CPF_VENDEDOR)" +
                                       " VALUES(?,?,?,?,?)");
            ps.setString(1, objPed.getNumero());
            ps.setString(2, objPed.getDataEmissao());
            ps.setDouble(3, objPed.getValor());
            ps.setString(4, objPed.getCliente().getCpf());
            ps.setString(5, objPed.getVendedor().getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }  
    
    
    public void inserirItem(String numero, Pedido.ItemPedido objItem) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO ITEM_PEDIDO(" +
                                       "CODIGO_PRODUTO, NUMERO_PEDIDO, QTDE)" +
                                       " VALUES(?,?,?)");
            ps.setInt(1, objItem.getProduto().getCodigo());
            ps.setString(2, numero);
            ps.setInt(3, objItem.getQuantidade());
          
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }  
    
    public void alterar(Pedido objPed) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("UPDATE PEDIDO SET " +
                                       "DATA_EMISSAO = ?, " +
                                       "VALOR = ?, " +
                                       "CPF_CLIENTE = ?, " +
                                       "CPF_VENDEDOR = ? " +
                                       "WHERE NUMERO = ?");
            
            ps.setString(1, objPed.getDataEmissao());
            ps.setDouble(2, objPed.getValor());
            ps.setString(3, objPed.getCliente().getCpf());
            ps.setString(4, objPed.getVendedor().getCpf());
            ps.setString(5, objPed.getNumero());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void excluir(Pedido objPed) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM PEDIDO WHERE NUMERO = ?");
            
            ps.setString(1, objPed.getNumero());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}
