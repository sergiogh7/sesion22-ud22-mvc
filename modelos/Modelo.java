package modelos;

public class Modelo {
	
//	Atributos.
	private String query;
	private String respuesta;

//	Funciones.
	public void insertarDatos() {

		SQL sql = new SQL();
		sql.ConectarBD();

		respuesta = sql.Editar("insertados", "insertar", query);

		sql.desconectarBD();
	}

	public void borrarDatos() {

		SQL sql = new SQL();
		sql.ConectarBD();

		respuesta = sql.Editar("eliminados", "eliminar", query);

		sql.desconectarBD();

	}

	public void actualizarDatos() {

		SQL sql = new SQL();
		sql.ConectarBD();

		respuesta = sql.Editar("actualizados", "actualizar", query);

		sql.desconectarBD();

	}
	
	public void select () {
		SQL sql = new SQL();
		sql.ConectarBD();

		respuesta = sql.Consulta("seleccionar", query);

		sql.desconectarBD();
	}
	
//	Getters y Setters.
	public void setQuery(String query) {
		this.query = query;
	}
	public String getRespuesta() {
		return respuesta;
	}

}