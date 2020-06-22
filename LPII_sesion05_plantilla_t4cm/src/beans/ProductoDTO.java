package beans;

public class ProductoDTO {
	private String idprod, descripcion;	
	private int stock;
	private double precio;
	private int idcategoria, estado;
	
	@Override
	public String toString() {
		return "Producto [idprod=" + idprod + ", descripcion=" + descripcion + ", stock=" + stock + ", precio=" + precio
				+ ", idcategoria=" + idcategoria + ", estado=" + estado + "]";
	}
	
	public String getIdprod() {
		return idprod;
	}
	public void setIdprod(String idprod) {
		this.idprod = idprod;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}	
